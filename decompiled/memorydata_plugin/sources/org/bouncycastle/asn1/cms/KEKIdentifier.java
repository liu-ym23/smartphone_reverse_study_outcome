package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class KEKIdentifier extends ASN1Object {
    private ASN1GeneralizedTime date;
    private ASN1OctetString keyIdentifier;
    private OtherKeyAttribute other;

    private KEKIdentifier(ASN1Sequence r6) {
        this.keyIdentifier = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r6.getObjectAt(0), ASN1OctetString.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        if (r0 != 1) goto L5;
        return;
    L5:
        if (r0 != 2) goto L7;
        boolean r1 = ZeusTransformUtils.instanceOf(r6.getObjectAt(1), ASN1GeneralizedTime.class);
        ASN1Encodable r7 = r6.getObjectAt(1);
        if (r1 == true) goto L14;
    L9:
        this.other = OtherKeyAttribute.getInstance(r7);
        return;
    L14:
        this.date = (ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r7, ASN1GeneralizedTime.class, "com.obric.memorydata.plugin");
        return;
    L7:
        if (r0 != 3) goto L11;
        this.date = (ASN1GeneralizedTime) ZeusTransformUtils.preCheckCast(r6.getObjectAt(1), ASN1GeneralizedTime.class, "com.obric.memorydata.plugin");
        r7 = r6.getObjectAt(2);
        goto L9
    L11:
        throw new IllegalArgumentException("Invalid KEKIdentifier");
    }

    public static KEKIdentifier getInstance(Object r3) {
        if (r3 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, KEKIdentifier.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, ASN1Sequence.class) == false) goto L12;
        return new KEKIdentifier((ASN1Sequence) ZeusTransformUtils.preCheckCast(r3, ASN1Sequence.class, "com.obric.memorydata.plugin"));
    L12:
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + r3.getClass().getName());
    L14:
        return (KEKIdentifier) ZeusTransformUtils.preCheckCast(r3, KEKIdentifier.class, "com.obric.memorydata.plugin");
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(3);
        r0.add(this.keyIdentifier);
        ASN1GeneralizedTime r1 = this.date;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        OtherKeyAttribute r2 = this.other;
        if (r2 == null) goto L9;
        r0.add(r2);
    L9:
        return new DERSequence(r0);
    }
}
