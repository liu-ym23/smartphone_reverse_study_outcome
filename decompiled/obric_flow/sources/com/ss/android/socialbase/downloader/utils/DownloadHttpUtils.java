package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadHttpUtils {
    public static String a(int r5) {
        if (r5 != 449) goto L5;
        return "Retry With";
    L5:
        if (r5 != 451) goto L7;
        return "Unavailable For Legal Reasons";
    L7:
        if (r5 != 600) goto L9;
        return "Unparseable Response Headers";
    L9:
        if (r5 != 509) goto L11;
        return "Bandwidth Limit Exceeded";
    L11:
        if (r5 == 510) goto L124;
        switch(r5) {
            case 100: goto L122;
            case 101: goto L120;
            case 102: goto L118;
            default: goto L13;
        };
    L13:
        switch(r5) {
            case 200: goto L116;
            case 201: goto L114;
            case 202: goto L112;
            case 203: goto L110;
            case 204: goto L108;
            case 205: goto L106;
            case 206: goto L104;
            case 207: goto L102;
            default: goto L14;
        };
    L14:
        switch(r5) {
            case 300: goto L100;
            case 301: goto L98;
            case 302: goto L96;
            case 303: goto L94;
            case 304: goto L92;
            case 305: goto L90;
            case 306: goto L88;
            case 307: goto L86;
            default: goto L15;
        };
    L15:
        switch(r5) {
            case 400: goto L84;
            case 401: goto L82;
            case 402: goto L80;
            case 403: goto L78;
            case 404: goto L76;
            case 405: goto L74;
            case 406: goto L72;
            case 407: goto L70;
            case 408: goto L68;
            case 409: goto L66;
            case 410: goto L64;
            case 411: goto L62;
            case 412: goto L60;
            case 413: goto L58;
            case 414: goto L56;
            case 415: goto L54;
            case 416: goto L52;
            case 417: goto L50;
            case 418: goto L48;
            default: goto L16;
        };
    L16:
        switch(r5) {
            case 421: goto L46;
            case 422: goto L44;
            case 423: goto L42;
            case 424: goto L40;
            case 425: goto L38;
            case 426: goto L36;
            default: goto L17;
        };
    L17:
        switch(r5) {
            case 500: goto L34;
            case 501: goto L32;
            case 502: goto L30;
            case 503: goto L28;
            case 504: goto L26;
            case 505: goto L24;
            case 506: goto L22;
            case 507: goto L20;
            default: goto L18;
        };
    L18:
        return "";
    L20:
        return "Insufficient Storage";
    L22:
        return "Variant Also Negotiates";
    L24:
        return "HTTP Version Not Supported";
    L26:
        return "Gateway Timeout";
    L28:
        return "Service Unavailable";
    L30:
        return "Bad Gateway";
    L32:
        return "Not Implemented";
    L34:
        return "Internal Server Error";
    L36:
        return "Upgrade Required";
    L38:
        return "Unordered Collection";
    L40:
        return "Failed Dependency";
    L42:
        return "Locked";
    L44:
        return "Unprocessable Entity";
    L46:
        return "Too Many Connections";
    L48:
        return "I'm a teapot";
    L50:
        return "Expectation Failed";
    L52:
        return "Requested Range Not Satisfiable";
    L54:
        return "Unsupported Media Type";
    L56:
        return "Request-URI Too Long";
    L58:
        return "Request Entity Too Large";
    L60:
        return "Precondition Failed";
    L62:
        return "Length Required";
    L64:
        return "Gone";
    L66:
        return "Conflict";
    L68:
        return "Request Timeout";
    L70:
        return "Proxy Authentication Required";
    L72:
        return "Not Acceptable";
    L74:
        return "Method Not Allowed";
    L76:
        return "Not Found";
    L78:
        return "Forbidden";
    L80:
        return "Payment Required";
    L82:
        return "Unauthorized";
    L84:
        return "Bad Request";
    L86:
        return "Temporary Redirect";
    L88:
        return "Switch Proxy";
    L90:
        return "Use Proxy";
    L92:
        return "Not Modified";
    L94:
        return "See Other";
    L96:
        return "Move Temporarily";
    L98:
        return "Moved Permanently";
    L100:
        return "Multiple Choices";
    L102:
        return "Multi-Status";
    L104:
        return "Partial Content";
    L106:
        return "Reset Content";
    L108:
        return "No Content";
    L110:
        return "Non-Authoritative Information";
    L112:
        return "Accepted";
    L114:
        return "Created";
    L116:
        return "OK";
    L118:
        return "Processing";
    L120:
        return "Switching Protocols";
    L122:
        return "Continue";
    L124:
        return "Not Extended";
    }
}
