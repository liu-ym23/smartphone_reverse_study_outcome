package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import java.io.IOException;
import s9.b;

/* JADX INFO: loaded from: classes2.dex */
public class CronetIOException extends IOException {
    private final int cronetInternalErrorCode;
    private b requestInfo;
    private int statusCode;
    private String traceCode;

    public CronetIOException(Exception r5, b r10, String r11, int r12) {
        super(r5.getMessage(), r5.getCause());
        this.requestInfo = r10;
        this.traceCode = r11;
        if ((r5 instanceof HttpResponseException) == false) goto L5;
        this.statusCode = ((HttpResponseException) r5).getStatusCode();
    L5:
        this.cronetInternalErrorCode = r12;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public b getRequestInfo() {
        return this.requestInfo;
    }

    public String getRequestLog() {
        return this.requestInfo.f21868o;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getTraceCode() {
        return this.traceCode;
    }
}
