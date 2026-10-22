package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class BERSequence extends ASN1Sequence {
    public BERSequence() {
    }

    public BERSequence(ASN1Encodable r3) {
        super((ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin"));
    }

    public BERSequence(ASN1EncodableVector r1) {
        super(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingIL(r3, 48, this.elements);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r5) {
        if (r5 == false) goto L4;
        int r6 = 4;
    L5:
        int r0 = 0;
        int r1 = this.elements.length;
    L6:
        if (r0 >= r1) goto L8;
        r6 = r6 + this.elements[r0].toASN1Primitive().encodedLength(true);
        r0 = r0 + 1;
        goto L6
    L8:
        return r6;
    L4:
        r6 = 3;
        goto L5
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1BitString toASN1BitString() {
        return new BERBitString(getConstructedBitStrings());
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1External toASN1External() {
        return ((ASN1Sequence) ZeusTransformUtils.preCheckCast(toDLObject(), ASN1Sequence.class, "com.obric.memorydata.plugin")).toASN1External();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1OctetString toASN1OctetString() {
        return new BEROctetString(getConstructedOctetStrings());
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1Set toASN1Set() {
        return new BERSet(false, toArrayInternal());
    }
}
