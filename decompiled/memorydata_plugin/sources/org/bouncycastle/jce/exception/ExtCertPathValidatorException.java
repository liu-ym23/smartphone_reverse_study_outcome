package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

/* JADX INFO: loaded from: classes7.dex */
public class ExtCertPathValidatorException extends CertPathValidatorException {
    private Throwable cause;

    public ExtCertPathValidatorException(String r1) {
        super(r1);
    }

    public ExtCertPathValidatorException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    public ExtCertPathValidatorException(String r1, Throwable r2, CertPath r3, int r4) {
        super(r1, r2, r3, r4);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
