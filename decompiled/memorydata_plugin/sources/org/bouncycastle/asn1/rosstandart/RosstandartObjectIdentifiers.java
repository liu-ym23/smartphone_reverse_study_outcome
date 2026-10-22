package org.bouncycastle.asn1.rosstandart;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface RosstandartObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_tc26 = null;
    public static final ASN1ObjectIdentifier id_tc26_agreement = null;
    public static final ASN1ObjectIdentifier id_tc26_agreement_gost_3410_12_256 = null;
    public static final ASN1ObjectIdentifier id_tc26_agreement_gost_3410_12_512 = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_28147_param_Z = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256 = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSet = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_256_paramSetA = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512 = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSet = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetA = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetB = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3410_12_512_paramSetC = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_256 = null;
    public static final ASN1ObjectIdentifier id_tc26_gost_3411_12_512 = null;
    public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_256 = null;
    public static final ASN1ObjectIdentifier id_tc26_hmac_gost_3411_12_512 = null;
    public static final ASN1ObjectIdentifier id_tc26_signwithdigest_gost_3410_12_256 = null;
    public static final ASN1ObjectIdentifier id_tc26_signwithdigest_gost_3410_12_512 = null;
    public static final ASN1ObjectIdentifier rosstandart = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.2.643.7");
        rosstandart = r0;
        ASN1ObjectIdentifier r1 = r0.branch("1");
        id_tc26 = r1;
        id_tc26_gost_3411_12_256 = r1.branch("1.2.2");
        id_tc26_gost_3411_12_512 = r1.branch("1.2.3");
        id_tc26_hmac_gost_3411_12_256 = r1.branch("1.4.1");
        id_tc26_hmac_gost_3411_12_512 = r1.branch("1.4.2");
        id_tc26_gost_3410_12_256 = r1.branch("1.1.1");
        id_tc26_gost_3410_12_512 = r1.branch("1.1.2");
        id_tc26_signwithdigest_gost_3410_12_256 = r1.branch("1.3.2");
        id_tc26_signwithdigest_gost_3410_12_512 = r1.branch("1.3.3");
        ASN1ObjectIdentifier r2 = r1.branch("1.6");
        id_tc26_agreement = r2;
        id_tc26_agreement_gost_3410_12_256 = r2.branch("1");
        id_tc26_agreement_gost_3410_12_512 = r2.branch("2");
        ASN1ObjectIdentifier r3 = r1.branch("2.1.1");
        id_tc26_gost_3410_12_256_paramSet = r3;
        id_tc26_gost_3410_12_256_paramSetA = r3.branch("1");
        ASN1ObjectIdentifier r4 = r1.branch("2.1.2");
        id_tc26_gost_3410_12_512_paramSet = r4;
        id_tc26_gost_3410_12_512_paramSetA = r4.branch("1");
        id_tc26_gost_3410_12_512_paramSetB = r4.branch("2");
        id_tc26_gost_3410_12_512_paramSetC = r4.branch("3");
        id_tc26_gost_28147_param_Z = r1.branch("2.5.1.1");
    }
}
