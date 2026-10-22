package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;
import s4.a;

/* JADX INFO: loaded from: classes.dex */
public class NetworkNotAvailabeException extends IOException implements a {
    private static final int INTERNET_DISCONNECTED = -106;
    private static final long serialVersionUID = -7281385706782665299L;
    private boolean shouldReport;

    public NetworkNotAvailabeException() {
        this.shouldReport = false;
    }

    public NetworkNotAvailabeException(String r10) {
        super(r10);
        this.shouldReport = false;
    }

    public NetworkNotAvailabeException(String r10, Throwable r11) {
        super(r10);
        this.shouldReport = false;
        initCause(r11);
    }

    public NetworkNotAvailabeException(Throwable r10) {
        this.shouldReport = false;
        initCause(r10);
    }

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public void setShouldReport(boolean r10) {
        this.shouldReport = r10;
    }

    @Override // s4.a
    public boolean shouldReport() {
        return this.shouldReport;
    }
}
