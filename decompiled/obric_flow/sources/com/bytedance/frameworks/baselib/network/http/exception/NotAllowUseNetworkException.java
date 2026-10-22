package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NotAllowUseNetworkException extends IOException {
    private static final long serialVersionUID = -210264743726619965L;

    public NotAllowUseNetworkException() {
    }

    public NotAllowUseNetworkException(String r5) {
        super(r5);
    }

    public NotAllowUseNetworkException(Throwable r5) {
        initCause(r5);
    }

    public NotAllowUseNetworkException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
