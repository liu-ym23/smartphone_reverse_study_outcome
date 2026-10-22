package org.bouncycastle.jce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Principal;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.X509Name;

/* JADX INFO: loaded from: classes7.dex */
public class X509Principal extends X509Name implements Principal {
    public X509Principal(X500Name r3) {
        super((ASN1Sequence) ZeusTransformUtils.preCheckCast(r3.toASN1Primitive(), ASN1Sequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return getEncoded("DER");
    L4:
        e = move-exception;
        throw new RuntimeException(e.toString());
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }
}
