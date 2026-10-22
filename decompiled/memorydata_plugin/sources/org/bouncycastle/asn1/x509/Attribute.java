package org.bouncycastle.asn1.x509;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class Attribute extends ASN1Object {
    private ASN1ObjectIdentifier attrType;
    private ASN1Set attrValues;

    private Attribute(ASN1Sequence r3) {
        if (r3.size() != 2) goto L7;
        this.attrType = ASN1ObjectIdentifier.getInstance(r3.getObjectAt(0));
        this.attrValues = ASN1Set.getInstance(r3.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r3.size());
    }

    public static Attribute getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Attribute.class) == true) goto L5;
        if (r2 != null) goto L8;
        return null;
    L8:
        return new Attribute(ASN1Sequence.getInstance(r2));
    L5:
        return (Attribute) ZeusTransformUtils.preCheckCast(r2, Attribute.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getAttrType() {
        return new ASN1ObjectIdentifier(this.attrType.getId());
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.attrType);
        r0.add(this.attrValues);
        return new DERSequence(r0);
    }
}
