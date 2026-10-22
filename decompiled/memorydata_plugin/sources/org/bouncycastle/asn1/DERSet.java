package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DERSet extends ASN1Set {
    private int contentsLength;

    public DERSet() {
        this.contentsLength = -1;
    }

    public DERSet(ASN1EncodableVector r2) {
        super(r2, true);
        this.contentsLength = -1;
    }

    DERSet(boolean r1, ASN1Encodable[] r2) {
        super(checkSorted(r1), r2);
        this.contentsLength = -1;
    }

    private static boolean checkSorted(boolean r1) {
        if (r1 == false) goto L5;
        return r1;
    L5:
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    private int getContentsLength() {
        if (this.contentsLength >= 0) goto L9;
        int r0 = this.elements.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r2 = r2 + this.elements[r1].toASN1Primitive().toDERObject().encodedLength(true);
        r1 = r1 + 1;
        goto L5
    L7:
        this.contentsLength = r2;
    L9:
        return this.contentsLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r8, boolean r9) {
        r8.writeIdentifier(r9, 49);
        DEROutputStream r10 = r8.getDERSubStream();
        int r0 = this.elements.length;
        int r2 = 0;
        if (this.contentsLength < 0) goto L5;
    L13:
        r8.writeDL(getContentsLength());
    L14:
        if (r2 >= r0) goto L20;
        this.elements[r2].toASN1Primitive().toDERObject().encode(r10, true);
        r2 = r2 + 1;
        goto L14
    L20:
        return;
    L5:
        if (r0 > 16) goto L13;
        ASN1Primitive[] r1 = new ASN1Primitive[r0];
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r0) goto L10;
        ASN1Primitive r6 = this.elements[r4].toASN1Primitive().toDERObject();
        r1[r4] = r6;
        r5 = r5 + r6.encodedLength(true);
        r4 = r4 + 1;
        goto L8
    L10:
        this.contentsLength = r5;
        r8.writeDL(r5);
    L11:
        if (r2 >= r0) goto L16;
        r1[r2].encode(r10, true);
        r2 = r2 + 1;
        goto L11
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, getContentsLength());
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        if (this.isSorted == false) goto L6;
        return this;
    L6:
        return super.toDERObject();
    }

    @Override // org.bouncycastle.asn1.ASN1Set, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
