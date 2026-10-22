package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NotAllowApiHttpException extends IOException {
    private static final long serialVersionUID = -5588326043064908201L;

    public NotAllowApiHttpException() {
    }

    public NotAllowApiHttpException(String r5) {
        super(r5);
    }

    public NotAllowApiHttpException(Throwable r5) {
        initCause(r5);
    }

    public NotAllowApiHttpException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
