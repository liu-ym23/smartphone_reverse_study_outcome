package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    DLApplicationSpecific(ASN1TaggedObject r1) {
        super(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1ApplicationSpecific, org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
