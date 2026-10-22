package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private c cronetInternalExtraInfo;
    private int statusCode;

    public CronetIOException(Exception r9, com.bytedance.frameworks.baselib.network.http.b r10, int r11) {
        String r0 = r9.getMessage();
        if (r9.getCause() != null) goto L5;
        Throwable r1 = r9;
    L6:
        super(r0, r1);
        if (r10.v == null) goto L9;
        String r2 = r10.v.toString();
    L10:
        super.setInfo(false, true, r2, r10.P, r10);
        this.cronetInternalErrorCode = r11;
        if (ZeusTransformUtils.instanceOf(r9, HttpResponseException.class) == false) goto L14;
        this.statusCode = ((HttpResponseException) ZeusTransformUtils.preCheckCast(r9, HttpResponseException.class, "com.obric.memorydata.plugin")).getStatusCode();
    L14:
        if (ZeusTransformUtils.instanceOf(r10.d.networklib.misc.requestExtraInfo, c.class) == false) goto L17;
        this.cronetInternalExtraInfo = (c) ZeusTransformUtils.preCheckCast(r10.d.networklib.misc.requestExtraInfo, c.class, "com.obric.memorydata.plugin");
        return;
    L17:
        return;
    L9:
        r2 = "";
        goto L10
    L5:
        r1 = r9.getCause();
        goto L6
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public c getCronetRequestExtraInfo() {
        return this.cronetInternalExtraInfo;
    }

    public com.bytedance.frameworks.baselib.network.http.b getRequestInfo() {
        return (com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(this.infoObj, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.memorydata.plugin");
    }

    public String getRequestLog() {
        return getRequestInfo().f2361J;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
