package org.bouncycastle.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultSecretKeySizeProvider implements SecretKeySizeProvider {
    public static final SecretKeySizeProvider INSTANCE = null;
    private static final Map KEY_SIZES = null;

    static {
        INSTANCE = new DefaultSecretKeySizeProvider();
        HashMap r0 = new HashMap();
        r0.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
        r0.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
        r0.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, Integers.valueOf(192));
        r0.put(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, Integers.valueOf(64));
        r0.put(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, Integers.valueOf(64));
        r0.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
        r0.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
        r0.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
        r0.put(NISTObjectIdentifiers.id_aes128_GCM, Integers.valueOf(128));
        r0.put(NISTObjectIdentifiers.id_aes192_GCM, Integers.valueOf(192));
        r0.put(NISTObjectIdentifiers.id_aes256_GCM, Integers.valueOf(256));
        r0.put(NISTObjectIdentifiers.id_aes128_CCM, Integers.valueOf(128));
        r0.put(NISTObjectIdentifiers.id_aes192_CCM, Integers.valueOf(192));
        r0.put(NISTObjectIdentifiers.id_aes256_CCM, Integers.valueOf(256));
        r0.put(NISTObjectIdentifiers.id_aes128_wrap, Integers.valueOf(128));
        r0.put(NISTObjectIdentifiers.id_aes192_wrap, Integers.valueOf(192));
        r0.put(NISTObjectIdentifiers.id_aes256_wrap, Integers.valueOf(256));
        r0.put(NISTObjectIdentifiers.id_aes128_wrap_pad, Integers.valueOf(128));
        r0.put(NISTObjectIdentifiers.id_aes192_wrap_pad, Integers.valueOf(192));
        r0.put(NISTObjectIdentifiers.id_aes256_wrap_pad, Integers.valueOf(256));
        r0.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
        r0.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
        r0.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
        r0.put(NTTObjectIdentifiers.id_camellia128_wrap, Integers.valueOf(128));
        r0.put(NTTObjectIdentifiers.id_camellia192_wrap, Integers.valueOf(192));
        r0.put(NTTObjectIdentifiers.id_camellia256_wrap, Integers.valueOf(256));
        r0.put(KISAObjectIdentifiers.id_seedCBC, Integers.valueOf(128));
        r0.put(OIWObjectIdentifiers.desCBC, Integers.valueOf(64));
        r0.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
        KEY_SIZES = Collections.unmodifiableMap(r0);
    }

    public DefaultSecretKeySizeProvider() {
    }

    public int getKeySize(ASN1ObjectIdentifier r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(KEY_SIZES.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.intValue();
    }

    @Override // org.bouncycastle.operator.SecretKeySizeProvider
    public int getKeySize(AlgorithmIdentifier r1) {
        int r0 = getKeySize(r1.getAlgorithm());
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return -1;
    }
}
