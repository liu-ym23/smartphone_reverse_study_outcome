package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
abstract class ASN1UniversalType extends ASN1Type {
    final ASN1Tag tag;

    ASN1UniversalType(Class r1, int r2) {
        super(r1);
        this.tag = ASN1Tag.create(0, r2);
    }

    final ASN1Primitive checkedCast(ASN1Primitive r3) {
        if (ZeusTransformUtils.instanceOf(this.javaClass, r3) == false) goto L6;
        return r3;
    L6:
        throw new IllegalStateException("unexpected object: " + r3.getClass().getName());
    }

    final ASN1Primitive fromByteArray(byte[] r1) {
        return checkedCast(ASN1Primitive.fromByteArray(r1));
    }

    ASN1Primitive fromImplicitConstructed(ASN1Sequence r1) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    ASN1Primitive fromImplicitPrimitive(DEROctetString r1) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    final ASN1Primitive getContextInstance(ASN1TaggedObject r3, boolean r4) {
        if (128 != r3.getTagClass()) goto L7;
        return checkedCast(r3.getBaseUniversal(r4, this));
    L7:
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }
}
