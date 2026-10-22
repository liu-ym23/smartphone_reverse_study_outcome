package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkNotAvailabeException extends IOException {
    private static final long serialVersionUID = -7281385706782665299L;

    public NetworkNotAvailabeException() {
    }

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public NetworkNotAvailabeException(String r5) {
        super(r5);
    }

    public NetworkNotAvailabeException(Throwable r5) {
        initCause(r5);
    }

    public NetworkNotAvailabeException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
