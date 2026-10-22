package org.bouncycastle.jce.exception;

import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes7.dex */
public class ExtCertificateEncodingException extends CertificateEncodingException {
    private Throwable cause;

    public ExtCertificateEncodingException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
