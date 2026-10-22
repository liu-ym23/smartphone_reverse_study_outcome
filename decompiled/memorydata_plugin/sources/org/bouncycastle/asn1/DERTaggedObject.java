package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class DERTaggedObject extends ASN1TaggedObject {
    DERTaggedObject(int r3, int r4, int r5, ASN1Encodable r6) {
        super(r3, r4, r5, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r6, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public DERTaggedObject(int r3, ASN1Encodable r4) {
        super(true, r3, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public DERTaggedObject(boolean r3, int r4, ASN1Encodable r5) {
        super(r3, r4, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r5, boolean r6) {
        ASN1Primitive r0 = this.obj.toASN1Primitive().toDERObject();
        boolean r1 = isExplicit();
        if (r6 == false) goto L10;
        int r7 = this.tagClass;
        if (r1 == false) goto L7;
    L8:
        r7 = r7 | 32;
    L9:
        r5.writeIdentifier(true, r7, this.tagNo);
        goto L10
    L7:
        if (r0.encodeConstructed() == false) goto L9;
    L10:
        if (r1 == false) goto L12;
        r5.writeDL(r0.encodedLength(true));
    L12:
        r0.encode(r5.getDERSubStream(), r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        if (isExplicit() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.obj.toASN1Primitive().toDERObject().encodeConstructed() == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r3) {
        ASN1Primitive r0 = this.obj.toASN1Primitive().toDERObject();
        boolean r1 = isExplicit();
        int r2 = r0.encodedLength(r1);
        if (r1 == false) goto L5;
        r2 = r2 + ASN1OutputStream.getLengthOfDL(r2);
    L5:
        if (r3 == false) goto L7;
        int r4 = ASN1OutputStream.getLengthOfIdentifier(this.tagNo);
    L9:
        return r2 + r4;
    L7:
        r4 = 0;
        goto L9
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject
    ASN1Sequence rebuildConstructed(ASN1Primitive r1) {
        return new DERSequence(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
