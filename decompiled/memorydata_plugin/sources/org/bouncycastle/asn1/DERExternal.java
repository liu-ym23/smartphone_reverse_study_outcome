package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DERExternal extends ASN1External {
    public DERExternal(ASN1ObjectIdentifier r1, ASN1Integer r2, ASN1Primitive r3, int r4, ASN1Primitive r5) {
        super(r1, r2, r3, r4, r5);
    }

    public DERExternal(DERSequence r1) {
        super(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1External
    ASN1Sequence buildSequence() {
        ASN1EncodableVector r0 = new ASN1EncodableVector(4);
        if (this.directReference == null) goto L6;
        r0.add(this.directReference);
    L6:
        if (this.indirectReference == null) goto L9;
        r0.add(this.indirectReference);
    L9:
        if (this.dataValueDescriptor == null) goto L12;
        r0.add(this.dataValueDescriptor.toDERObject());
    L12:
        if (this.encoding != 0) goto L14;
        boolean r2 = true;
    L15:
        r0.add(new DERTaggedObject(r2, this.encoding, this.externalContent));
        return new DERSequence(r0);
    L14:
        r2 = false;
        goto L15
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
