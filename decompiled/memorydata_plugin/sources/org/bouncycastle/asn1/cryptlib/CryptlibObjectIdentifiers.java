package org.bouncycastle.asn1.cryptlib;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public class CryptlibObjectIdentifiers {
    public static final ASN1ObjectIdentifier cryptlib = null;
    public static final ASN1ObjectIdentifier curvey25519 = null;
    public static final ASN1ObjectIdentifier ecc = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.3.6.1.4.1.3029");
        cryptlib = r0;
        ASN1ObjectIdentifier r1 = r0.branch("1").branch("5");
        ecc = r1;
        curvey25519 = r1.branch("1");
    }
}
