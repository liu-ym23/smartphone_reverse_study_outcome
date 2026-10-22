package org.bouncycastle.eac;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class EACIOException extends IOException {
    private Throwable cause;

    public EACIOException(String r1) {
        super(r1);
    }

    public EACIOException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
