package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes7.dex */
public class ParSet extends ASN1Object {
    private int[] h;
    private int[] k;
    private int t;
    private int[] w;

    public ParSet(int r1, int[] r2, int[] r3, int[] r4) {
        this.t = r1;
        this.h = r2;
        this.w = r3;
        this.k = r4;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r0 = new ASN1EncodableVector();
        ASN1EncodableVector r1 = new ASN1EncodableVector();
        ASN1EncodableVector r2 = new ASN1EncodableVector();
        int r3 = 0;
    L4:
        if (r3 >= this.h.length) goto L6;
        r0.add(new ASN1Integer(this.h[r3]));
        r1.add(new ASN1Integer(this.w[r3]));
        r2.add(new ASN1Integer(this.k[r3]));
        r3 = r3 + 1;
        goto L4
    L6:
        ASN1EncodableVector r4 = new ASN1EncodableVector();
        r4.add(new ASN1Integer(this.t));
        r4.add(new DERSequence(r0));
        r4.add(new DERSequence(r1));
        r4.add(new DERSequence(r2));
        return new DERSequence(r4);
    }
}
