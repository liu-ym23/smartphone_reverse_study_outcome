package com.bytedance.retrofit2;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient SsResponse<?> response;

    public HttpException(SsResponse<?> r2) {
        super(getMessage(r2));
        this.code = r2.code();
        this.message = r2.message();
        this.response = r2;
    }

    private static String getMessage(SsResponse<?> r3) {
        Utils.checkNotNull(r3, "response == null");
        if (r3.getRetrofitMetrics() != null) goto L5;
    L7:
        String r0 = "";
    L9:
        if ("".equals(r0) == false) goto L17;
        if (r3.raw() == null) goto L17;
        r0 = new URL(r3.raw().getUrl()).getPath();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return "Path is " + r0 + " HTTP " + r3.code() + " " + r3.message();
    L5:
        if (r3.getRetrofitMetrics().url == null) goto L7;
        r0 = r3.getRetrofitMetrics().url.getPath();
        goto L9
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public SsResponse<?> response() {
        return this.response;
    }
}
