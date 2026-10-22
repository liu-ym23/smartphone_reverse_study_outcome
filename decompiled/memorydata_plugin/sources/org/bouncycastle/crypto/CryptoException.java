package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public class CryptoException extends Exception {
    private Throwable cause;

    public CryptoException() {
    }

    public CryptoException(String r1) {
        super(r1);
    }

    public CryptoException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
