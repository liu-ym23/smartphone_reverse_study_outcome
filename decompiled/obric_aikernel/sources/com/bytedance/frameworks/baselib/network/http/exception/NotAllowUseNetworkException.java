package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class NotAllowUseNetworkException extends IOException {
    private static final long serialVersionUID = -210264743726619965L;

    public NotAllowUseNetworkException() {
    }

    public NotAllowUseNetworkException(String r10) {
        super(r10);
    }

    public NotAllowUseNetworkException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }

    public NotAllowUseNetworkException(Throwable r10) {
        initCause(r10);
    }
}
