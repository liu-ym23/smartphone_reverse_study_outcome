package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CdnCacheVerifyException extends IOException {
    public CdnCacheVerifyException() {
    }

    public CdnCacheVerifyException(String r5) {
        super(r5);
    }

    public CdnCacheVerifyException(Throwable r5) {
        initCause(r5);
    }

    public CdnCacheVerifyException(String r5, Throwable r10) {
        super(r5);
        initCause(r10);
    }
}
