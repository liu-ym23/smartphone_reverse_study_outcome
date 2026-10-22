package org.bouncycastle.asn1.bsi;

import com.tencent.wcdb.BuildConfig;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier algorithm = null;
    public static final ASN1ObjectIdentifier bsi_de = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_224 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_256 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_384 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA3_512 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512 = null;
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures = null;
    public static final ASN1ObjectIdentifier ecka_eg = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_3DES = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES128 = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES192 = null;
    public static final ASN1ObjectIdentifier ecka_eg_SessionKDF_AES256 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_RIPEMD160 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA1 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA224 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA256 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA384 = null;
    public static final ASN1ObjectIdentifier ecka_eg_X963kdf_SHA512 = null;
    public static final ASN1ObjectIdentifier id_ecc = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = r0;
        ASN1ObjectIdentifier r1 = r0.branch(BuildConfig.VERSION_NAME);
        id_ecc = r1;
        ASN1ObjectIdentifier r2 = r1.branch("4.1");
        ecdsa_plain_signatures = r2;
        ecdsa_plain_SHA1 = r2.branch("1");
        ecdsa_plain_SHA224 = r2.branch("2");
        ecdsa_plain_SHA256 = r2.branch("3");
        ecdsa_plain_SHA384 = r2.branch("4");
        ecdsa_plain_SHA512 = r2.branch("5");
        ecdsa_plain_RIPEMD160 = r2.branch("6");
        ecdsa_plain_SHA3_224 = r2.branch("8");
        ecdsa_plain_SHA3_256 = r2.branch("9");
        ecdsa_plain_SHA3_384 = r2.branch("10");
        ecdsa_plain_SHA3_512 = r2.branch("11");
        algorithm = r0.branch("1");
        ASN1ObjectIdentifier r3 = r1.branch("5.1");
        ecka_eg = r3;
        ASN1ObjectIdentifier r4 = r3.branch("1");
        ecka_eg_X963kdf = r4;
        ecka_eg_X963kdf_SHA1 = r4.branch("1");
        ecka_eg_X963kdf_SHA224 = r4.branch("2");
        ecka_eg_X963kdf_SHA256 = r4.branch("3");
        ecka_eg_X963kdf_SHA384 = r4.branch("4");
        ecka_eg_X963kdf_SHA512 = r4.branch("5");
        ecka_eg_X963kdf_RIPEMD160 = r4.branch("6");
        ASN1ObjectIdentifier r5 = r3.branch("2");
        ecka_eg_SessionKDF = r5;
        ecka_eg_SessionKDF_3DES = r5.branch("1");
        ecka_eg_SessionKDF_AES128 = r5.branch("2");
        ecka_eg_SessionKDF_AES192 = r5.branch("3");
        ecka_eg_SessionKDF_AES256 = r5.branch("4");
    }
}
