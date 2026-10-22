package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.net.URL;
import o2.b;

/* JADX INFO: loaded from: classes.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private int statusCode;

    public CronetIOException(Exception r10, b r11, int r12) {
        String r13 = r10.getMessage();
        if (r10.getCause() != null) goto L5;
        Throwable r14 = r10;
    L6:
        super(r13, r14);
        URL r15 = r11.f11394a;
        if (r15 == null) goto L9;
        String r16 = r15.toString();
    L10:
        super.setInfo(true, false, true, r16, r11.P, r11);
        this.cronetInternalErrorCode = r12;
        if ((r10 instanceof HttpResponseException) == false) goto L14;
        this.statusCode = ((HttpResponseException) r10).getStatusCode();
        return;
    L14:
        return;
    L9:
        r16 = "";
        goto L10
    L5:
        r14 = r10.getCause();
        goto L6
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public b getRequestInfo() {
        return (b) this.infoObj;
    }

    public String getRequestLog() {
        return getRequestInfo().A;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
