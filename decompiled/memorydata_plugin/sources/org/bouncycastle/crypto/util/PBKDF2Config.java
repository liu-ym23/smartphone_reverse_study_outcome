package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes7.dex */
public class PBKDF2Config extends PBKDFConfig {
    private static final Map PRFS_SALT = null;
    public static final AlgorithmIdentifier PRF_SHA1 = null;
    public static final AlgorithmIdentifier PRF_SHA256 = null;
    public static final AlgorithmIdentifier PRF_SHA3_256 = null;
    public static final AlgorithmIdentifier PRF_SHA3_512 = null;
    public static final AlgorithmIdentifier PRF_SHA512 = null;
    private final int iterationCount;
    private final AlgorithmIdentifier prf;
    private final int saltLength;

    static {
        PRF_SHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE);
        PRF_SHA256 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, DERNull.INSTANCE);
        PRF_SHA512 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
        PRF_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_256, DERNull.INSTANCE);
        PRF_SHA3_512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, DERNull.INSTANCE);
        HashMap r0 = new HashMap();
        PRFS_SALT = r0;
        r0.put(PKCSObjectIdentifiers.id_hmacWithSHA1, Integers.valueOf(20));
        r0.put(PKCSObjectIdentifiers.id_hmacWithSHA256, Integers.valueOf(32));
        r0.put(PKCSObjectIdentifiers.id_hmacWithSHA512, Integers.valueOf(64));
        r0.put(PKCSObjectIdentifiers.id_hmacWithSHA224, Integers.valueOf(28));
        r0.put(PKCSObjectIdentifiers.id_hmacWithSHA384, Integers.valueOf(48));
        r0.put(NISTObjectIdentifiers.id_hmacWithSHA3_224, Integers.valueOf(28));
        r0.put(NISTObjectIdentifiers.id_hmacWithSHA3_256, Integers.valueOf(32));
        r0.put(NISTObjectIdentifiers.id_hmacWithSHA3_384, Integers.valueOf(48));
        r0.put(NISTObjectIdentifiers.id_hmacWithSHA3_512, Integers.valueOf(64));
        r0.put(CryptoProObjectIdentifiers.gostR3411Hmac, Integers.valueOf(32));
        r0.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_256, Integers.valueOf(32));
        r0.put(RosstandartObjectIdentifiers.id_tc26_hmac_gost_3411_12_512, Integers.valueOf(64));
        r0.put(GMObjectIdentifiers.hmac_sm3, Integers.valueOf(32));
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmIdentifier getPRF() {
        return this.prf;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
