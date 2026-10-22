package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.CertificateEncodingException;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes7.dex */
class X509CertificateInternal extends X509CertificateImpl {
    private final byte[] encoding;
    private final CertificateEncodingException exception;

    X509CertificateInternal(JcaJceHelper r8, Certificate r9, BasicConstraints r10, boolean[] r11, String r12, byte[] r13, byte[] r14, CertificateEncodingException r15) {
        super((JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r8, JcaJceHelper.class, "com.obric.memorydata.plugin"), r9, r10, r11, r12, r13);
        this.encoding = r14;
        this.exception = r15;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        CertificateEncodingException r0 = this.exception;
        if (r0 != null) goto L9;
        byte[] r1 = this.encoding;
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new CertificateEncodingException();
    L9:
        throw r0;
    }
}
