package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes7.dex */
public class RecipientIdentifier extends ASN1Object implements ASN1Choice {
    private ASN1Encodable id;

    public RecipientIdentifier(ASN1OctetString r3) {
        this.id = new DERTaggedObject(false, 0, r3);
    }

    public RecipientIdentifier(ASN1Primitive r1) {
        this.id = r1;
    }

    public RecipientIdentifier(IssuerAndSerialNumber r1) {
        this.id = r1;
    }

    public static RecipientIdentifier getInstance(Object r3) {
        if (r3 == null) goto L22;
        if (ZeusTransformUtils.instanceOf(r3, RecipientIdentifier.class) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r3, IssuerAndSerialNumber.class) == false) goto L12;
        return new RecipientIdentifier((IssuerAndSerialNumber) ZeusTransformUtils.preCheckCast(r3, IssuerAndSerialNumber.class, "com.obric.memorydata.plugin"));
    L12:
        if (ZeusTransformUtils.instanceOf(r3, ASN1OctetString.class) == false) goto L16;
        return new RecipientIdentifier((ASN1OctetString) ZeusTransformUtils.preCheckCast(r3, ASN1OctetString.class, "com.obric.memorydata.plugin"));
    L16:
        if (ZeusTransformUtils.instanceOf(r3, ASN1Primitive.class) == false) goto L20;
        return new RecipientIdentifier((ASN1Primitive) ZeusTransformUtils.preCheckCast(r3, ASN1Primitive.class, "com.obric.memorydata.plugin"));
    L20:
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + r3.getClass().getName());
    L22:
        return (RecipientIdentifier) ZeusTransformUtils.preCheckCast(r3, RecipientIdentifier.class, "com.obric.memorydata.plugin");
    }

    public ASN1Encodable getId() {
        boolean r0 = ZeusTransformUtils.instanceOf(this.id, ASN1TaggedObject.class);
        ASN1Encodable r2 = this.id;
        if (r0 == false) goto L7;
        return ASN1OctetString.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r2, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
    L7:
        return IssuerAndSerialNumber.getInstance(r2);
    }

    public boolean isTagged() {
        return ZeusTransformUtils.instanceOf(this.id, ASN1TaggedObject.class);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.id.toASN1Primitive();
    }
}
