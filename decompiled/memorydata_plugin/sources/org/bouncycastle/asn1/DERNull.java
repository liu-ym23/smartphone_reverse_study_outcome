package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = null;
    private static final byte[] zeroBytes = null;

    static {
        INSTANCE = new DERNull();
        zeroBytes = new byte[0];
    }

    private DERNull() {
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 5, zeroBytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, 0);
    }
}
