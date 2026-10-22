package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class BERSet extends ASN1Set {
    public BERSet() {
    }

    public BERSet(ASN1EncodableVector r2) {
        super(r2, false);
    }

    BERSet(boolean r1, ASN1Encodable[] r2) {
        super(r1, r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingIL(r3, 49, this.elements);
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
}
