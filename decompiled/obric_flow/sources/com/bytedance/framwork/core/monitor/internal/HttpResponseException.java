package com.bytedance.framwork.core.monitor.internal;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public HttpResponseException(int r5, String r10) {
        this.statusCode = r5;
        this.message = r10;
    }

    public String getMsg() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
