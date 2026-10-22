package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(String r1) {
        super(r1);
    }

    public UncheckedTimeoutException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public UncheckedTimeoutException(Throwable r1) {
        super(r1);
    }
}
