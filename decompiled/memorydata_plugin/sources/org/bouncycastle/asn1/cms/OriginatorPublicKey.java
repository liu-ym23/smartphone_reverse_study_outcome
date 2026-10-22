package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class OriginatorPublicKey extends ASN1Object {
    private AlgorithmIdentifier algorithm;
    private DERBitString publicKey;

    private OriginatorPublicKey(ASN1Sequence r3) {
        this.algorithm = AlgorithmIdentifier.getInstance(r3.getObjectAt(0));
        this.publicKey = (DERBitString) ZeusTransformUtils.preCheckCast(r3.getObjectAt(1), DERBitString.class, "com.obric.memorydata.plugin");
    }

    public static OriginatorPublicKey getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, OriginatorPublicKey.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new OriginatorPublicKey(ASN1Sequence.getInstance(r2));
    L5:
        return (OriginatorPublicKey) ZeusTransformUtils.preCheckCast(r2, OriginatorPublicKey.class, "com.obric.memorydata.plugin");
    }

    public static OriginatorPublicKey getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public DERBitString getPublicKey() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.algorithm);
        r0.add(this.publicKey);
        return new DERSequence(r0);
    }
}
