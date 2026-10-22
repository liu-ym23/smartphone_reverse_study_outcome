package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class BERTaggedObject extends ASN1TaggedObject {
    BERTaggedObject(int r3, int r4, int r5, ASN1Encodable r6) {
        super(r3, r4, r5, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r6, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public BERTaggedObject(int r3, ASN1Encodable r4) {
        super(true, r3, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r4, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public BERTaggedObject(boolean r3, int r4, ASN1Encodable r5) {
        super(r3, r4, (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r5, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r5, boolean r6) {
        ASN1Primitive r0 = this.obj.toASN1Primitive();
        boolean r1 = isExplicit();
        if (r6 == false) goto L11;
        int r7 = this.tagClass;
        if (r1 == false) goto L7;
    L8:
        r7 = r7 | 32;
    L9:
        r5.writeIdentifier(true, r7, this.tagNo);
        goto L11
    L7:
        if (r0.encodeConstructed() == false) goto L9;
    L11:
        if (r1 == false) goto L13;
        r5.write(128);
        r0.encode(r5, true);
        r5.write(0);
        r5.write(0);
        return;
    L13:
        r0.encode(r5, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        if (isExplicit() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.obj.toASN1Primitive().encodeConstructed() == true) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r3) {
        ASN1Primitive r0 = this.obj.toASN1Primitive();
        boolean r1 = isExplicit();
        int r2 = r0.encodedLength(r1);
        if (r1 == false) goto L5;
        r2 = r2 + 3;
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
        return new BERSequence(r1);
    }
}
