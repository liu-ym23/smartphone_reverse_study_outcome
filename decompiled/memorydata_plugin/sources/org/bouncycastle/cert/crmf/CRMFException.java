package org.bouncycastle.cert.crmf;

/* JADX INFO: loaded from: classes7.dex */
public class CRMFException extends Exception {
    private Throwable cause;

    public CRMFException(String r2) {
        this(r2, null);
    }

    public CRMFException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
