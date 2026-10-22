package com.bytedance.frameworks.baselib.network.http.exception;

/* JADX INFO: loaded from: classes2.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int r5, String r10) {
        super(r10);
        this.statusCode = r5;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
