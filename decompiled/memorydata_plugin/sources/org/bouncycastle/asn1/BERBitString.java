package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class BERBitString extends ASN1BitString {
    private final ASN1BitString[] elements;
    private final int segmentLimit;

    public BERBitString(byte[] r2, int r3) {
        this(r2, r3, 1000);
    }

    public BERBitString(byte[] r1, int r2, int r3) {
        super(r1, r2);
        this.elements = null;
        this.segmentLimit = r3;
    }

    public BERBitString(ASN1BitString[] r2) {
        this(r2, 1000);
    }

    public BERBitString(ASN1BitString[] r3, int r4) {
        super(flattenBitStrings(r3), false);
        this.elements = r3;
        this.segmentLimit = r4;
    }

    static byte[] flattenBitStrings(ASN1BitString[] r8) {
        int r0 = r8.length;
        int r1 = 0;
        if (r0 == 0) goto L19;
        if (r0 == 1) goto L17;
        int r3 = r0 - 1;
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r3) goto L12;
        byte[] r6 = r8[r4].contents;
        if (r6[0] != 0) goto L11;
        r5 = r5 + (r6.length - 1);
        r4 = r4 + 1;
        goto L6
    L11:
        throw new IllegalArgumentException("only the last nested bitstring can have padding");
    L12:
        byte[] r7 = r8[r3].contents;
        byte r9 = r7[0];
        byte[] r10 = new byte[r5 + r7.length];
        r10[0] = r9;
        int r11 = 1;
    L13:
        if (r1 >= r0) goto L15;
        byte[] r12 = r8[r1].contents;
        int r13 = r12.length - 1;
        System.arraycopy(r12, 1, r10, r11, r13);
        r11 = r11 + r13;
        r1 = r1 + 1;
        goto L13
    L15:
        return r10;
    L17:
        return r8[0].contents;
    L19:
        return new byte[]{0};
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r12, boolean r13) {
        if (encodeConstructed() == true) goto L6;
        DLBitString.encode(r12, r13, this.contents, 0, this.contents.length);
        return;
    L6:
        r12.writeIdentifier(r13, 35);
        r12.write(128);
        ASN1BitString[] r14 = this.elements;
        if (r14 == null) goto L10;
        r12.writePrimitives(r14);
    L16:
        r12.write(0);
        r12.write(0);
        return;
    L10:
        if (this.contents.length < 2) goto L16;
        byte r4 = this.contents[0];
        int r15 = this.contents.length;
        int r0 = r15 - 1;
        int r2 = this.segmentLimit - 1;
    L13:
        if (r0 <= r2) goto L15;
        DLBitString.encode(r12, true, (byte) 0, this.contents, r15 - r0, r2);
        r0 = r0 - r2;
        goto L13
    L15:
        DLBitString.encode(r12, true, r4, this.contents, r15 - r0, r0);
        goto L16
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        if (this.elements == null) goto L5;
    L8:
        return true;
    L5:
        if (this.contents.length > this.segmentLimit) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r5) {
        if (encodeConstructed() == false) goto L5;
        if (r5 == false) goto L8;
        int r6 = 4;
    L10:
        if (this.elements == null) goto L16;
        int r0 = 0;
    L12:
        ASN1BitString[] r2 = this.elements;
        if (r0 >= r2.length) goto L22;
        r6 = r6 + r2[r0].encodedLength(true);
        r0 = r0 + 1;
        goto L12
    L22:
        return r6;
    L16:
        if (this.contents.length < 2) goto L21;
        int r1 = this.contents.length - 2;
        int r3 = this.segmentLimit;
        int r4 = r1 / (r3 - 1);
        return (r6 + (DLBitString.encodedLength(true, r3) * r4)) + DLBitString.encodedLength(true, this.contents.length - (r4 * (this.segmentLimit - 1)));
    L21:
        return r6;
    L8:
        r6 = 3;
        goto L10
    L5:
        return DLBitString.encodedLength(r5, this.contents.length);
    }
}
