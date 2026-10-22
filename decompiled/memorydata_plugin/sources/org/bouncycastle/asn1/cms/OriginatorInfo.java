package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class OriginatorInfo extends ASN1Object {
    private ASN1Set certs;
    private ASN1Set crls;

    private OriginatorInfo(ASN1Sequence r6) {
        int r0 = r6.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r0 != 1) goto L7;
        ASN1TaggedObject r7 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        int r1 = r7.getTagNo();
        if (r1 == 0) goto L18;
        if (r1 != 1) goto L17;
    L9:
        this.crls = ASN1Set.getInstance(r7, false);
        return;
    L17:
        throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + r7.getTagNo());
    L18:
        this.certs = ASN1Set.getInstance(r7, false);
        return;
    L7:
        if (r0 != 2) goto L11;
        this.certs = ASN1Set.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
        r7 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r6.getObjectAt(1), ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        goto L9
    L11:
        throw new IllegalArgumentException("OriginatorInfo too big");
    }

    public static OriginatorInfo getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, OriginatorInfo.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new OriginatorInfo(ASN1Sequence.getInstance(r2));
    L5:
        return (OriginatorInfo) ZeusTransformUtils.preCheckCast(r2, OriginatorInfo.class, "com.obric.memorydata.plugin");
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject r0, boolean r1) {
        return getInstance(ASN1Sequence.getInstance(r0, r1));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        if (this.certs == null) goto L6;
        r0.add(new DERTaggedObject(false, 0, this.certs));
    L6:
        if (this.crls == null) goto L9;
        r0.add(new DERTaggedObject(false, 1, this.crls));
    L9:
        return new DERSequence(r0);
    }
}
