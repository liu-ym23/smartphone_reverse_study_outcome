package org.bouncycastle.jce.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class ExtIOException extends IOException {
    private Throwable cause;

    public ExtIOException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
