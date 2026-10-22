package org.bouncycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes7.dex */
public class JcaX509CertificateHolder extends X509CertificateHolder {
    public JcaX509CertificateHolder(X509Certificate r1) {
        super(Certificate.getInstance(r1.getEncoded()));
    }
}
