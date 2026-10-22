package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Null extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;

    static {
        final Class<ASN1Null> r1 = ASN1Null.class;
        final int r2 = 5;
        TYPE = new AnonymousClass1(r1, r2);
    }

    ASN1Null() {
    }

    static ASN1Null createPrimitive(byte[] r1) {
        if (r1.length != 0) goto L7;
        return DERNull.INSTANCE;
    L7:
        throw new IllegalStateException("malformed NULL encoding encountered");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r1) {
        if (ZeusTransformUtils.instanceOf(r1, ASN1Null.class) == true) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
