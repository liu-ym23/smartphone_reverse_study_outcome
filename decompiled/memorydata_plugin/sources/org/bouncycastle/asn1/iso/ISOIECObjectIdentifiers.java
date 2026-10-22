package org.bouncycastle.asn1.iso;

import com.bytedance.bdlocation.exception.BDLocationException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface ISOIECObjectIdentifiers {
    public static final ASN1ObjectIdentifier hash_algorithms = null;
    public static final ASN1ObjectIdentifier id_ac_generic_hybrid = null;
    public static final ASN1ObjectIdentifier id_kem_rsa = null;
    public static final ASN1ObjectIdentifier is18033_2 = null;
    public static final ASN1ObjectIdentifier iso_encryption_algorithms = null;
    public static final ASN1ObjectIdentifier ripemd128 = null;
    public static final ASN1ObjectIdentifier ripemd160 = null;
    public static final ASN1ObjectIdentifier whirlpool = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.0.10118");
        iso_encryption_algorithms = r0;
        ASN1ObjectIdentifier r1 = r0.branch("3.0");
        hash_algorithms = r1;
        ripemd160 = r1.branch("49");
        ripemd128 = r1.branch(BDLocationException.ERROR_BYTE_SCAN_RESULT_IS_EMPTY);
        whirlpool = r1.branch("55");
        ASN1ObjectIdentifier r2 = new ASN1ObjectIdentifier("1.0.18033.2");
        is18033_2 = r2;
        id_ac_generic_hybrid = r2.branch("1.2");
        id_kem_rsa = r2.branch("2.4");
    }
}
