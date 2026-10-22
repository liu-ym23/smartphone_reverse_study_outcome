package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectDigestInfo extends ASN1Object {
    AlgorithmIdentifier digestAlgorithm;
    ASN1Enumerated digestedObjectType;
    ASN1BitString objectDigest;
    ASN1ObjectIdentifier otherObjectTypeID;

    private ObjectDigestInfo(ASN1Sequence r5) {
        if (r5.size() > 4) goto L12;
        if (r5.size() < 3) goto L12;
        int r0 = 0;
        this.digestedObjectType = ASN1Enumerated.getInstance(r5.getObjectAt(0));
        if (r5.size() != 4) goto L9;
        this.otherObjectTypeID = ASN1ObjectIdentifier.getInstance(r5.getObjectAt(1));
        r0 = 1;
    L9:
        this.digestAlgorithm = AlgorithmIdentifier.getInstance(r5.getObjectAt(r0 + 1));
        this.objectDigest = DERBitString.getInstance(r5.getObjectAt(r0 + 2));
        return;
    L12:
        throw new IllegalArgumentException("Bad sequence size: " + r5.size());
    }

    public static ObjectDigestInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, ObjectDigestInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new ObjectDigestInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (ObjectDigestInfo) ZeusTransformUtils.preCheckCast(r2, ObjectDigestInfo.class, "com.obric.memorydata.plugin");
    }

    public static ObjectDigestInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public ASN1Enumerated getDigestedObjectType() {
        return this.digestedObjectType;
    }

    public ASN1BitString getObjectDigest() {
        return this.objectDigest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        r0.add(this.digestedObjectType);
        ASN1ObjectIdentifier r1 = this.otherObjectTypeID;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        r0.add(this.digestAlgorithm);
        r0.add(this.objectDigest);
        return new DERSequence(r0);
    }
}
