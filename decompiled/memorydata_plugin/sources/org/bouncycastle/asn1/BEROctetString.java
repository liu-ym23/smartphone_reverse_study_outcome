package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class BEROctetString extends ASN1OctetString {
    private final ASN1OctetString[] elements;
    private final int segmentLimit;

    public BEROctetString(byte[] r2) {
        this(r2, 1000);
    }

    public BEROctetString(byte[] r2, int r3) {
        this(r2, null, r3);
    }

    private BEROctetString(byte[] r1, ASN1OctetString[] r2, int r3) {
        super(r1);
        this.elements = r2;
        this.segmentLimit = r3;
    }

    public BEROctetString(ASN1OctetString[] r2) {
        this(r2, 1000);
    }

    public BEROctetString(ASN1OctetString[] r2, int r3) {
        this(flattenOctetStrings(r2), r2, r3);
    }

    static byte[] flattenOctetStrings(ASN1OctetString[] r7) {
        int r0 = r7.length;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L14;
        int r1 = 0;
        int r3 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r3 = r3 + r7[r1].string.length;
        r1 = r1 + 1;
        goto L7
    L9:
        byte[] r2 = new byte[r3];
        int r4 = 0;
        int r5 = 0;
    L10:
        if (r4 >= r0) goto L12;
        byte[] r6 = r7[r4].string;
        System.arraycopy(r6, 0, r2, r5, r6.length);
        r5 = r5 + r6.length;
        r4 = r4 + 1;
        goto L10
    L12:
        return r2;
    L14:
        return r7[0].string;
    L16:
        return EMPTY_OCTETS;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r5, boolean r6) {
        if (encodeConstructed() == true) goto L6;
        DEROctetString.encode(r5, r6, this.string, 0, this.string.length);
        return;
    L6:
        r5.writeIdentifier(r6, 36);
        r5.write(128);
        ASN1OctetString[] r7 = this.elements;
        if (r7 == null) goto L9;
        r5.writePrimitives(r7);
    L13:
        r5.write(0);
        r5.write(0);
        return;
    L9:
        int r8 = 0;
    L11:
        if (r8 >= this.string.length) goto L13;
        int r0 = Math.min(this.string.length - r8, this.segmentLimit);
        DEROctetString.encode(r5, true, this.string, r8, r0);
        r8 = r8 + r0;
        goto L11
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        if (this.elements == null) goto L5;
    L8:
        return true;
    L5:
        if (this.string.length > this.segmentLimit) goto L8;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r5) {
        if (encodeConstructed() == false) goto L5;
        if (r5 == false) goto L8;
        int r6 = 4;
    L10:
        if (this.elements == null) goto L15;
        int r0 = 0;
    L12:
        ASN1OctetString[] r2 = this.elements;
        if (r0 >= r2.length) goto L21;
        r6 = r6 + r2[r0].encodedLength(true);
        r0 = r0 + 1;
        goto L12
    L21:
        return r6;
    L15:
        int r1 = this.string.length;
        int r3 = this.segmentLimit;
        int r4 = r1 / r3;
        int r7 = r6 + (DEROctetString.encodedLength(true, r3) * r4);
        int r8 = this.string.length - (r4 * this.segmentLimit);
        if (r8 > 0) goto L18;
        return r7;
    L18:
        return r7 + DEROctetString.encodedLength(true, r8);
    L8:
        r6 = 3;
        goto L10
    L5:
        return DEROctetString.encodedLength(r5, this.string.length);
    }
}
