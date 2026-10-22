package org.bouncycastle.pkcs;

/* JADX INFO: loaded from: classes7.dex */
public class PKCSException extends Exception {
    private Throwable cause;

    public PKCSException(String r1) {
        super(r1);
    }

    public PKCSException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
