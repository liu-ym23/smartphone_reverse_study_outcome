package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DLExternal extends ASN1External {
    public DLExternal(ASN1EncodableVector r1) {
        this(DLFactory.createSequence(r1));
    }

    public DLExternal(ASN1ObjectIdentifier r1, ASN1Integer r2, ASN1Primitive r3, int r4, ASN1Primitive r5) {
        super(r1, r2, r3, r4, r5);
    }

    public DLExternal(DLSequence r1) {
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
        r0.add(this.dataValueDescriptor.toDLObject());
    L12:
        if (this.encoding != 0) goto L14;
        boolean r2 = true;
    L15:
        r0.add(new DLTaggedObject(r2, this.encoding, this.externalContent));
        return new DLSequence(r0);
    L14:
        r2 = false;
        goto L15
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
