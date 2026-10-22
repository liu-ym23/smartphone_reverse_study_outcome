package org.bouncycastle.cert.jcajce;

import java.security.cert.X509CRL;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.cert.X509CRLHolder;

/* JADX INFO: loaded from: classes7.dex */
public class JcaX509CRLHolder extends X509CRLHolder {
    public JcaX509CRLHolder(X509CRL r1) {
        super(CertificateList.getInstance(r1.getEncoded()));
    }
}
