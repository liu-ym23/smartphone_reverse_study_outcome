package org.bouncycastle.asn1.cms;

import com.bytedance.bdlocation.exception.BDLocationException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier authEnvelopedData = null;
    public static final ASN1ObjectIdentifier authenticatedData = null;
    public static final ASN1ObjectIdentifier compressedData = null;
    public static final ASN1ObjectIdentifier data = null;
    public static final ASN1ObjectIdentifier digestedData = null;
    public static final ASN1ObjectIdentifier encryptedData = null;
    public static final ASN1ObjectIdentifier envelopedData = null;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE128 = null;
    public static final ASN1ObjectIdentifier id_RSASSA_PSS_SHAKE256 = null;
    public static final ASN1ObjectIdentifier id_alg = null;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake128 = null;
    public static final ASN1ObjectIdentifier id_ecdsa_with_shake256 = null;
    public static final ASN1ObjectIdentifier id_ri = null;
    public static final ASN1ObjectIdentifier id_ri_ocsp_response = null;
    public static final ASN1ObjectIdentifier id_ri_scvp = null;
    public static final ASN1ObjectIdentifier signedAndEnvelopedData = null;
    public static final ASN1ObjectIdentifier signedData = null;
    public static final ASN1ObjectIdentifier timestampedData = null;

    static {
        data = PKCSObjectIdentifiers.data;
        signedData = PKCSObjectIdentifiers.signedData;
        envelopedData = PKCSObjectIdentifiers.envelopedData;
        signedAndEnvelopedData = PKCSObjectIdentifiers.signedAndEnvelopedData;
        digestedData = PKCSObjectIdentifiers.digestedData;
        encryptedData = PKCSObjectIdentifiers.encryptedData;
        authenticatedData = PKCSObjectIdentifiers.id_ct_authData;
        compressedData = PKCSObjectIdentifiers.id_ct_compressedData;
        authEnvelopedData = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
        timestampedData = PKCSObjectIdentifiers.id_ct_timestampedData;
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
        id_ri = r0;
        id_ri_ocsp_response = r0.branch("2");
        id_ri_scvp = r0.branch("4");
        ASN1ObjectIdentifier r1 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.6");
        id_alg = r1;
        id_RSASSA_PSS_SHAKE128 = r1.branch(BDLocationException.ERROR_SDK_NO_PERMISSION);
        id_RSASSA_PSS_SHAKE256 = r1.branch("31");
        id_ecdsa_with_shake128 = r1.branch(BDLocationException.ERROR_CONNECT_GOOGLE_FAIL);
        id_ecdsa_with_shake256 = r1.branch("33");
    }
}
