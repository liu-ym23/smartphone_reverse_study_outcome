package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class NotAllowApiHttpException extends IOException {
    private static final long serialVersionUID = -5588326043064908201L;

    public NotAllowApiHttpException() {
    }

    public NotAllowApiHttpException(String r10) {
        super(r10);
    }

    public NotAllowApiHttpException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }

    public NotAllowApiHttpException(Throwable r10) {
        initCause(r10);
    }
}
