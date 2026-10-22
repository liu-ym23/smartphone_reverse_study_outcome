package com.bytedance.android.live.base.model.exception;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class NetworkErrorException extends IOException {
    private String message;
    public int statusCode;

    @Override // java.lang.Throwable
    public String toString() {
        String r0 = super.toString();
        if (r0 != null) goto L5;
        return r0;
    L5:
        return r0 + "NetworkErrorException{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public NetworkErrorException(int r1, String r2) {
        this.statusCode = r1;
        this.message = r2;
    }

    public NetworkErrorException(int r1, String r2, String r3, Throwable r4) {
        super(r3, r4);
        this.statusCode = r1;
        this.message = r2;
    }
}
