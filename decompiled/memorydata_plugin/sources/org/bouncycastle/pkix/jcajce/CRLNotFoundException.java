package org.bouncycastle.pkix.jcajce;

import java.security.cert.CertPathValidatorException;

/* JADX INFO: loaded from: classes7.dex */
class CRLNotFoundException extends CertPathValidatorException {
    CRLNotFoundException(String r1) {
        super(r1);
    }

    public CRLNotFoundException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
