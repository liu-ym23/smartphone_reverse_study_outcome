package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

/* JADX INFO: loaded from: classes7.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter;
    protected ECFieldElement f;

    static {
        converter = new X9IntegerConverter();
    }

    public X9FieldElement(ECFieldElement r1) {
        this.f = r1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int r0 = converter.getByteLength(this.f);
        return new DEROctetString(converter.integerToBytes(this.f.toBigInteger(), r0));
    }
}
