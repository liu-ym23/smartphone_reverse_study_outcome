package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient a0<?> response;

    public HttpException(a0<?> r10) {
        super(getMessage(r10));
        this.code = r10.b();
        this.message = r10.g();
        this.response = r10;
    }

    private static String getMessage(a0<?> r10) {
        c0.a(r10, "response == null");
        return "HTTP " + r10.b() + " " + r10.g();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public a0<?> response() {
        return this.response;
    }
}
