package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CdnCacheVerifyException extends IOException {
    public CdnCacheVerifyException() {
    }

    public CdnCacheVerifyException(String r10) {
        super(r10);
    }

    public CdnCacheVerifyException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }

    public CdnCacheVerifyException(Throwable r10) {
        initCause(r10);
    }
}
