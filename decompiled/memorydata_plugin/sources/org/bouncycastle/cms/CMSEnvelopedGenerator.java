package org.bouncycastle.cms;

import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public class CMSEnvelopedGenerator {
    public static final String AES128_CBC = null;
    public static final String AES128_WRAP = null;
    public static final String AES192_CBC = null;
    public static final String AES192_WRAP = null;
    public static final String AES256_CBC = null;
    public static final String AES256_WRAP = null;
    public static final String CAMELLIA128_CBC = null;
    public static final String CAMELLIA128_WRAP = null;
    public static final String CAMELLIA192_CBC = null;
    public static final String CAMELLIA192_WRAP = null;
    public static final String CAMELLIA256_CBC = null;
    public static final String CAMELLIA256_WRAP = null;
    public static final String DES_EDE3_CBC = null;
    public static final String DES_EDE3_WRAP = null;
    public static final String ECDH_SHA1KDF = null;
    public static final String ECMQV_SHA1KDF = null;
    public static final String RC2_CBC = null;
    public static final String SEED_CBC = null;
    public static final String SEED_WRAP = null;

    static {
        DES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.getId();
        RC2_CBC = PKCSObjectIdentifiers.RC2_CBC.getId();
        AES128_CBC = NISTObjectIdentifiers.id_aes128_CBC.getId();
        AES192_CBC = NISTObjectIdentifiers.id_aes192_CBC.getId();
        AES256_CBC = NISTObjectIdentifiers.id_aes256_CBC.getId();
        CAMELLIA128_CBC = NTTObjectIdentifiers.id_camellia128_cbc.getId();
        CAMELLIA192_CBC = NTTObjectIdentifiers.id_camellia192_cbc.getId();
        CAMELLIA256_CBC = NTTObjectIdentifiers.id_camellia256_cbc.getId();
        SEED_CBC = KISAObjectIdentifiers.id_seedCBC.getId();
        DES_EDE3_WRAP = PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId();
        AES128_WRAP = NISTObjectIdentifiers.id_aes128_wrap.getId();
        AES192_WRAP = NISTObjectIdentifiers.id_aes192_wrap.getId();
        AES256_WRAP = NISTObjectIdentifiers.id_aes256_wrap.getId();
        CAMELLIA128_WRAP = NTTObjectIdentifiers.id_camellia128_wrap.getId();
        CAMELLIA192_WRAP = NTTObjectIdentifiers.id_camellia192_wrap.getId();
        CAMELLIA256_WRAP = NTTObjectIdentifiers.id_camellia256_wrap.getId();
        SEED_WRAP = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId();
        ECDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme.getId();
        ECMQV_SHA1KDF = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme.getId();
    }
}
