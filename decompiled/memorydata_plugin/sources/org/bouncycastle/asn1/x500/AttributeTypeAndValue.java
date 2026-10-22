package org.bouncycastle.asn1.x500;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class AttributeTypeAndValue extends ASN1Object {
    private ASN1ObjectIdentifier type;
    private ASN1Encodable value;

    private AttributeTypeAndValue(ASN1Sequence r4) {
        this.type = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r4.getObjectAt(0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
        this.value = r4.getObjectAt(1);
    }

    public static AttributeTypeAndValue getInstance(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, AttributeTypeAndValue.class) == true) goto L5;
        if (r2 == null) goto L10;
        return new AttributeTypeAndValue(ASN1Sequence.getInstance(r2));
    L10:
        throw new IllegalArgumentException("null value in getInstance()");
    L5:
        return (AttributeTypeAndValue) ZeusTransformUtils.preCheckCast(r2, AttributeTypeAndValue.class, "com.obric.memorydata.plugin");
    }

    public ASN1ObjectIdentifier getType() {
        return this.type;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(2);
        r0.add(this.type);
        r0.add(this.value);
        return new DERSequence(r0);
    }
}
