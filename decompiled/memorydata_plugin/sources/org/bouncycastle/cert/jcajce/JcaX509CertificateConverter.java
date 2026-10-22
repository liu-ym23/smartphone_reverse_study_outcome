package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;

/* JADX INFO: loaded from: classes7.dex */
public class JcaX509CertificateConverter {

    private static class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    private static class ExCertificateParsingException extends CertificateParsingException {
        private Throwable cause;

        public ExCertificateParsingException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }
}
