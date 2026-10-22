package org.bouncycastle.jce.provider;

import java.security.cert.CRLException;

/* JADX INFO: loaded from: classes7.dex */
class ExtCRLException extends CRLException {
    Throwable cause;

    ExtCRLException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
