package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
final class ASN1Tag {
    private final int tagClass;
    private final int tagNumber;

    private ASN1Tag(int r1, int r2) {
        this.tagClass = r1;
        this.tagNumber = r2;
    }

    static ASN1Tag create(int r1, int r2) {
        return new ASN1Tag(r1, r2);
    }
}
