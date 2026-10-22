package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
abstract class ASN1Type {
    final Class javaClass;

    ASN1Type(Class r1) {
        this.javaClass = r1;
    }

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
