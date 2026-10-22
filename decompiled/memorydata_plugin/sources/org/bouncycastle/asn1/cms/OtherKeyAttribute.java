package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class OtherKeyAttribute extends ASN1Object {
    private ASN1Encodable keyAttr;
    private ASN1ObjectIdentifier keyAttrId;

    private OtherKeyAttribute(ASN1Sequence r4) {
        this.keyAttrId = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        this.keyAttr = r4.getObjectAt(1);
    }

    public static OtherKeyAttribute getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, OtherKeyAttribute.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new OtherKeyAttribute(ASN1Sequence.getInstance(r2));
    L5:
        return (OtherKeyAttribute) ZeusTransformUtils.preCheckCast(r2, OtherKeyAttribute.class, "com.obric.memorydata.plugin");
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.keyAttrId);
        r0.add(this.keyAttr);
        return new DERSequence(r0);
    }
}
