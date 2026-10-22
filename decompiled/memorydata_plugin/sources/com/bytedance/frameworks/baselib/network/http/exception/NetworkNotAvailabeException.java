package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkNotAvailabeException extends TTNetExceptionStorage {
    private static final int INTERNET_DISCONNECTED = -106;
    private static final long serialVersionUID = -7281385706782665299L;

    public NetworkNotAvailabeException() {
    }

    public NetworkNotAvailabeException(String r1) {
        super(r1);
    }

    public NetworkNotAvailabeException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }

    public NetworkNotAvailabeException(Throwable r1) {
        initCause(r1);
    }

    public int getCronetInternalErrorCode() {
        return -106;
    }

    @Override // com.bytedance.retrofit2.ttnet.TTNetExceptionStorage
    public void setInfo(boolean r1, boolean r2, String r3, String r4, Object r5) {
        super.setInfo(r1, r2, r3, r4, r5);
    }
}
