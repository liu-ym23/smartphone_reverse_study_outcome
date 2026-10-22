package org.bouncycastle.cert.crmf;

/* JADX INFO: loaded from: classes7.dex */
public class CRMFRuntimeException extends RuntimeException {
    private Throwable cause;

    public CRMFRuntimeException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
