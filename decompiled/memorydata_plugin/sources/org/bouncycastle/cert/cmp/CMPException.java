package org.bouncycastle.cert.cmp;

/* JADX INFO: loaded from: classes7.dex */
public class CMPException extends Exception {
    private Throwable cause;

    public CMPException(String r1) {
        super(r1);
    }

    public CMPException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
