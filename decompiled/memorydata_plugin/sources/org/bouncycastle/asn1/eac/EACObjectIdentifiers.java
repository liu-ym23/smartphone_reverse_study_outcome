package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface EACObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de = null;
    public static final ASN1ObjectIdentifier id_CA = null;
    public static final ASN1ObjectIdentifier id_CA_DH = null;
    public static final ASN1ObjectIdentifier id_CA_DH_3DES_CBC_CBC = null;
    public static final ASN1ObjectIdentifier id_CA_ECDH = null;
    public static final ASN1ObjectIdentifier id_CA_ECDH_3DES_CBC_CBC = null;
    public static final ASN1ObjectIdentifier id_EAC_ePassport = null;
    public static final ASN1ObjectIdentifier id_PK = null;
    public static final ASN1ObjectIdentifier id_PK_DH = null;
    public static final ASN1ObjectIdentifier id_PK_ECDH = null;
    public static final ASN1ObjectIdentifier id_TA = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_224 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_384 = null;
    public static final ASN1ObjectIdentifier id_TA_ECDSA_SHA_512 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_PSS_SHA_512 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_1 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_256 = null;
    public static final ASN1ObjectIdentifier id_TA_RSA_v1_5_SHA_512 = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = r0;
        ASN1ObjectIdentifier r1 = r0.branch("2.2.1");
        id_PK = r1;
        id_PK_DH = r1.branch("1");
        id_PK_ECDH = r1.branch("2");
        ASN1ObjectIdentifier r2 = r0.branch("2.2.3");
        id_CA = r2;
        ASN1ObjectIdentifier r4 = r2.branch("1");
        id_CA_DH = r4;
        id_CA_DH_3DES_CBC_CBC = r4.branch("1");
        ASN1ObjectIdentifier r3 = r2.branch("2");
        id_CA_ECDH = r3;
        id_CA_ECDH_3DES_CBC_CBC = r3.branch("1");
        ASN1ObjectIdentifier r5 = r0.branch("2.2.2");
        id_TA = r5;
        ASN1ObjectIdentifier r6 = r5.branch("1");
        id_TA_RSA = r6;
        id_TA_RSA_v1_5_SHA_1 = r6.branch("1");
        id_TA_RSA_v1_5_SHA_256 = r6.branch("2");
        id_TA_RSA_PSS_SHA_1 = r6.branch("3");
        id_TA_RSA_PSS_SHA_256 = r6.branch("4");
        id_TA_RSA_v1_5_SHA_512 = r6.branch("5");
        id_TA_RSA_PSS_SHA_512 = r6.branch("6");
        ASN1ObjectIdentifier r7 = r5.branch("2");
        id_TA_ECDSA = r7;
        id_TA_ECDSA_SHA_1 = r7.branch("1");
        id_TA_ECDSA_SHA_224 = r7.branch("2");
        id_TA_ECDSA_SHA_256 = r7.branch("3");
        id_TA_ECDSA_SHA_384 = r7.branch("4");
        id_TA_ECDSA_SHA_512 = r7.branch("5");
        id_EAC_ePassport = r0.branch("3.1.2.1");
    }
}
