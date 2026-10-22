package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class QuicException extends NetworkException {
    public abstract int getQuicDetailedErrorCode();

    public QuicException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
