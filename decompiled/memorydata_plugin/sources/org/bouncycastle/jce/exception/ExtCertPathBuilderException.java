package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;

/* JADX INFO: loaded from: classes7.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException {
    private Throwable cause;

    public ExtCertPathBuilderException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    public ExtCertPathBuilderException(String r1, Throwable r2, CertPath r3, int r4) {
        super(r1, r2);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
