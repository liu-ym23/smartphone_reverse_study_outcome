package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class QuicException extends NetworkException {
    public QuicException(String r8, Throwable r10) {
        super(r8, r10);
    }

    public abstract int getQuicDetailedErrorCode();
}
