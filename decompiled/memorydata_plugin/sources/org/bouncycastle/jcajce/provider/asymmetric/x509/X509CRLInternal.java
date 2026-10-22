package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.CRLException;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes7.dex */
class X509CRLInternal extends X509CRLImpl {
    private final byte[] encoding;
    private final CRLException exception;

    X509CRLInternal(JcaJceHelper r7, CertificateList r8, String r9, byte[] r10, boolean r11, byte[] r12, CRLException r13) {
        super((JcaJceHelper) ZeusTransformUtils.wrapperContextForParams(r7, JcaJceHelper.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        this.encoding = r12;
        this.exception = r13;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() {
        CRLException r0 = this.exception;
        if (r0 != null) goto L9;
        byte[] r1 = this.encoding;
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new CRLException();
    L9:
        throw r0;
    }
}
