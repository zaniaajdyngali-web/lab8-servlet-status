
package com.example;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
                         throws IOException {

        String code = req.getParameter("code");

        if ("404".equals(code)) {
            resp.sendError(
                HttpServletResponse.SC_NOT_FOUND,
                "Бет табылмады"
            );
            return;
        }

        if ("500".equals(code)) {
            resp.sendError(
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                "Сервер қатесі"
            );
            return;
        }

        if ("json".equals(req.getParameter("type"))) {
            resp.setContentType("application/json;charset=UTF-8");

            resp.getWriter().println(
                "{\"status\":\"ok\",\"message\":\"Сәлем\"}"
            );

        } else {
            resp.setContentType("text/plain;charset=UTF-8");

            resp.getWriter().println("Қарапайым мәтін");
        }
    }
}
