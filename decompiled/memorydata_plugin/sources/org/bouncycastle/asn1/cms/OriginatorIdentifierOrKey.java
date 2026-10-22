package org.bouncycastle.asn1.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class OriginatorIdentifierOrKey extends ASN1Object implements ASN1Choice {
    private ASN1Encodable id;

    public OriginatorIdentifierOrKey(IssuerAndSerialNumber r1) {
        this.id = r1;
    }

    public OriginatorIdentifierOrKey(OriginatorPublicKey r4) {
        this.id = new DERTaggedObject(false, 1, r4);
    }

    public OriginatorIdentifierOrKey(SubjectKeyIdentifier r3) {
        this.id = new DERTaggedObject(false, 0, r3);
    }

    public static OriginatorIdentifierOrKey getInstance(Object r4) {
        if (r4 == null) goto L27;
        if (ZeusTransformUtils.instanceOf(r4, OriginatorIdentifierOrKey.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r4, IssuerAndSerialNumber.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r4, ASN1Sequence.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r4, ASN1TaggedObject.class) == false) goto L23;
        ASN1TaggedObject r0 = (ASN1TaggedObject) ZeusTransformUtils.preCheckCast(r4, ASN1TaggedObject.class, "com.obric.memorydata.plugin");
        if (r0.getTagNo() != 0) goto L19;
        return new OriginatorIdentifierOrKey(SubjectKeyIdentifier.getInstance(r0, false));
    L19:
        if (r0.getTagNo() != 1) goto L23;
        return new OriginatorIdentifierOrKey(OriginatorPublicKey.getInstance(r0, false));
    L23:
        throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: " + r4.getClass().getName());
    L25:
        return new OriginatorIdentifierOrKey(IssuerAndSerialNumber.getInstance(r4));
    L27:
        return (OriginatorIdentifierOrKey) ZeusTransformUtils.preCheckCast(r4, OriginatorIdentifierOrKey.class, "com.obric.memorydata.plugin");
    }

    public static OriginatorIdentifierOrKey getInstance(ASN1TaggedObject r0, boolean r1) {
        if (r1 == false) goto L6;
        return getInstance(r0.getObject());
    L6:
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        if (ZeusTransformUtils.instanceOf(this.id, IssuerAndSerialNumber.class) == true) goto L5;
        return null;
    L5:
        return (IssuerAndSerialNumber) ZeusTransformUtils.preCheckCast(this.id, IssuerAndSerialNumber.class, "com.obric.memorydata.plugin");
    }

    public OriginatorPublicKey getOriginatorKey() {
        if (ZeusTransformUtils.instanceOf(this.id, ASN1TaggedObject.class) == true) goto L5;
        return null;
    L5:
        if (((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.id, ASN1TaggedObject.class, "com.obric.memorydata.plugin")).getTagNo() == 1) goto L7;
        return null;
    L7:
        return OriginatorPublicKey.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.id, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
    }

    public SubjectKeyIdentifier getSubjectKeyIdentifier() {
        if (ZeusTransformUtils.instanceOf(this.id, ASN1TaggedObject.class) == true) goto L5;
        return null;
    L5:
        if (((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.id, ASN1TaggedObject.class, "com.obric.memorydata.plugin")).getTagNo() == 0) goto L7;
        return null;
    L7:
        return SubjectKeyIdentifier.getInstance((ASN1TaggedObject) ZeusTransformUtils.preCheckCast(this.id, ASN1TaggedObject.class, "com.obric.memorydata.plugin"), false);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.id.toASN1Primitive();
    }
}
