package org.bouncycastle.cert.path;

/* JADX INFO: loaded from: classes7.dex */
public class CertPathValidationException extends Exception {
    private final Exception cause;

    public CertPathValidationException(String r2) {
        this(r2, null);
    }

    public CertPathValidationException(String r1, Exception r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
