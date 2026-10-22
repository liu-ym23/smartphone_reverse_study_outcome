package org.bouncycastle.asn1;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
class DEROutputStream extends DLOutputStream {
    DEROutputStream(OutputStream r1) {
        super(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    DEROutputStream getDERSubStream() {
        return this;
    }

    @Override // org.bouncycastle.asn1.DLOutputStream, org.bouncycastle.asn1.ASN1OutputStream
    void writeElements(ASN1Encodable[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5[r1].toASN1Primitive().toDERObject().encode(this, true);
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.bouncycastle.asn1.DLOutputStream, org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitive(ASN1Primitive r1, boolean r2) {
        r1.toDERObject().encode(this, r2);
    }

    @Override // org.bouncycastle.asn1.DLOutputStream, org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitives(ASN1Primitive[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5[r1].toDERObject().encode(this, true);
        r1 = r1 + 1;
        goto L3
    }
}
