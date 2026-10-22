package org.bouncycastle.x509;

import java.security.cert.CRLException;

/* JADX INFO: loaded from: classes7.dex */
public class X509V2CRLGenerator {

    private static class ExtCRLException extends CRLException {
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
}
