package org.bouncycastle.asn1.pkcs;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptionScheme extends ASN1Object {
    private AlgorithmIdentifier algId;

    public EncryptionScheme(ASN1ObjectIdentifier r2) {
        this.algId = new AlgorithmIdentifier(r2);
    }

    public EncryptionScheme(ASN1ObjectIdentifier r3, ASN1Encodable r4) {
        this.algId = new AlgorithmIdentifier(r3, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    private EncryptionScheme(ASN1Sequence r1) {
        this.algId = AlgorithmIdentifier.getInstance(r1);
    }

    public static EncryptionScheme getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, EncryptionScheme.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new EncryptionScheme(ASN1Sequence.getInstance(r2));
    L5:
        return (EncryptionScheme) ZeusTransformUtils.preCheckCast(r2, EncryptionScheme.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algId.getAlgorithm();
    }

    public ASN1Encodable getParameters() {
        return this.algId.getParameters();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.algId.toASN1Primitive();
    }
}
