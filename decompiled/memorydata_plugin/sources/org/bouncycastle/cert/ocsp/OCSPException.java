package org.bouncycastle.cert.ocsp;

/* JADX INFO: loaded from: classes7.dex */
public class OCSPException extends Exception {
    private Throwable cause;

    public OCSPException(String r1) {
        super(r1);
    }

    public OCSPException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
