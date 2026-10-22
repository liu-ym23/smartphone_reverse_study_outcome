package org.bouncycastle.asn1.x500;

/* JADX INFO: loaded from: classes7.dex */
public interface X500NameStyle {
    boolean areEqual(X500Name r1, X500Name r2);

    int calculateHashCode(X500Name r1);

    String toString(X500Name r1);
}
