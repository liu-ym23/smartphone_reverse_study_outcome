package org.bouncycastle.pkcs;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class PKCSIOException extends IOException {
    private Throwable cause;

    public PKCSIOException(String r1) {
        super(r1);
    }

    public PKCSIOException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
