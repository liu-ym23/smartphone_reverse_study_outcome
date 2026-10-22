package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DLBitString extends ASN1BitString {
    DLBitString(byte[] r1, boolean r2) {
        super(r1, r2);
    }

    static void encode(ASN1OutputStream r7, boolean r8, byte r9, byte[] r10, int r11, int r12) {
        r7.writeEncodingDL(r8, 3, r9, r10, r11, r12);
    }

    static void encode(ASN1OutputStream r6, boolean r7, byte[] r8, int r9, int r10) {
        r6.writeEncodingDL(r7, 3, r8, r9, r10);
    }

    static int encodedLength(boolean r0, int r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r0, r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 3, this.contents);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, this.contents.length);
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
