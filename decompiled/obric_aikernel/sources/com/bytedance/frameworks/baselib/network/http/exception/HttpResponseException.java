package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.frameworks.baselib.network.http.util.k;
import java.net.HttpURLConnection;
import java.net.URI;
import okhttp3.x;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String errorResponse;
    private final int statusCode;

    public HttpResponseException(int r10, String r11) {
        super(r11);
        this.statusCode = r10;
        this.errorResponse = null;
    }

    public HttpResponseException(int r10, String r11, String r12) {
        StringBuilder r13 = new StringBuilder();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r13.append(r11);
        r13.append(" ");
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        r13.append(r12);
        super(r13.toString());
        this.statusCode = r10;
        this.errorResponse = null;
    }

    public HttpResponseException(int r10, String r11, String r12, String r13) {
        StringBuilder r14 = new StringBuilder();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r14.append(r11);
        r14.append(" ");
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        r14.append(r12);
        super(r14.toString());
        this.statusCode = r10;
        this.errorResponse = r13;
    }

    public static String getPathFromHttpURLConnection(HttpURLConnection r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.getURL() != null) goto L6;
        return "";
    L6:
        if (r10.getURL().getPath() != null) goto L8;
        return "";
    L8:
        return r10.getURL().getPath();
    }

    public static String getPathFromOk3Request(x r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        if (r10.l() != null) goto L6;
        return "";
    L6:
        return r10.l().u().getPath();
    }

    public static String getPathFromUrlString(String r10) {
        URI r11 = k.l(r10);
        if (r11 != null) goto L5;
        return "";
    L5:
        return r11.getPath();
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
