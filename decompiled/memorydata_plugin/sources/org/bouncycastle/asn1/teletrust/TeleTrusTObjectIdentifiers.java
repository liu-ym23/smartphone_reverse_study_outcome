package org.bouncycastle.asn1.teletrust;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP160t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP192r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP192t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP224r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP224t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP256r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP256t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP320r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP320t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP384r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP384t1 = null;
    public static final ASN1ObjectIdentifier brainpoolP512r1 = null;
    public static final ASN1ObjectIdentifier brainpoolP512t1 = null;
    public static final ASN1ObjectIdentifier ecSign = null;
    public static final ASN1ObjectIdentifier ecSignWithRipemd160 = null;
    public static final ASN1ObjectIdentifier ecSignWithSha1 = null;
    public static final ASN1ObjectIdentifier ecc_brainpool = null;
    public static final ASN1ObjectIdentifier ellipticCurve = null;
    public static final ASN1ObjectIdentifier ripemd128 = null;
    public static final ASN1ObjectIdentifier ripemd160 = null;
    public static final ASN1ObjectIdentifier ripemd256 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd128 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd160 = null;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd256 = null;
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm = null;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm = null;
    public static final ASN1ObjectIdentifier versionOne = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.3.36.3");
        teleTrusTAlgorithm = r0;
        ripemd160 = r0.branch("2.1");
        ripemd128 = r0.branch("2.2");
        ripemd256 = r0.branch("2.3");
        ASN1ObjectIdentifier r1 = r0.branch("3.1");
        teleTrusTRSAsignatureAlgorithm = r1;
        rsaSignatureWithripemd160 = r1.branch("2");
        rsaSignatureWithripemd128 = r1.branch("3");
        rsaSignatureWithripemd256 = r1.branch("4");
        ASN1ObjectIdentifier r2 = r0.branch("3.2");
        ecSign = r2;
        ecSignWithSha1 = r2.branch("1");
        ecSignWithRipemd160 = r2.branch("2");
        ASN1ObjectIdentifier r3 = r0.branch("3.2.8");
        ecc_brainpool = r3;
        ASN1ObjectIdentifier r4 = r3.branch("1");
        ellipticCurve = r4;
        ASN1ObjectIdentifier r5 = r4.branch("1");
        versionOne = r5;
        brainpoolP160r1 = r5.branch("1");
        brainpoolP160t1 = r5.branch("2");
        brainpoolP192r1 = r5.branch("3");
        brainpoolP192t1 = r5.branch("4");
        brainpoolP224r1 = r5.branch("5");
        brainpoolP224t1 = r5.branch("6");
        brainpoolP256r1 = r5.branch("7");
        brainpoolP256t1 = r5.branch("8");
        brainpoolP320r1 = r5.branch("9");
        brainpoolP320t1 = r5.branch("10");
        brainpoolP384r1 = r5.branch("11");
        brainpoolP384t1 = r5.branch("12");
        brainpoolP512r1 = r5.branch("13");
        brainpoolP512t1 = r5.branch("14");
    }
}
