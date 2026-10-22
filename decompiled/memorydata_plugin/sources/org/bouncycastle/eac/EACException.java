package org.bouncycastle.eac;

/* JADX INFO: loaded from: classes7.dex */
public class EACException extends Exception {
    private Throwable cause;

    public EACException(String r1) {
        super(r1);
    }

    public EACException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
