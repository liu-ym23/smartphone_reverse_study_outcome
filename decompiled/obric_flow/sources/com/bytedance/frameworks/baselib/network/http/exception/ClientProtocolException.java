package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ClientProtocolException extends IOException {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String r5) {
        super(r5);
    }

    public ClientProtocolException(Throwable r5) {
        initCause(r5);
    }

    public ClientProtocolException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
