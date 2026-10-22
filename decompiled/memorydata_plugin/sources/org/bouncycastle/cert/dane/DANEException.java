package org.bouncycastle.cert.dane;

/* JADX INFO: loaded from: classes7.dex */
public class DANEException extends Exception {
    private Throwable cause;

    public DANEException(String r1) {
        super(r1);
    }

    public DANEException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
