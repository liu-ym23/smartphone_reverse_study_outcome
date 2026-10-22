package org.bouncycastle.cert.jcajce;

import java.security.cert.CRLException;

/* JADX INFO: loaded from: classes7.dex */
public class JcaX509CRLConverter {

    private static class ExCRLException extends CRLException {
        private Throwable cause;

        public ExCRLException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }
}
