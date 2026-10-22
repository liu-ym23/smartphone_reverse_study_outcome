package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.jcajce.spec.HybridValueParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map<String, ASN1ObjectIdentifier> defaultOids = null;
    private static final Hashtable des = null;
    private static final Map<String, Integer> keySizes = null;
    private static final Map<String, String> nameTable = null;
    private static final Hashtable oids = null;
    private HybridValueParameterSpec hybridSpec;
    protected final String kaAlgorithm;
    protected final DerivationFunction kdf;
    protected byte[] ukmParameters;

    static {
        HashMap r0 = new HashMap();
        defaultOids = r0;
        HashMap r1 = new HashMap();
        keySizes = r1;
        HashMap r2 = new HashMap();
        nameTable = r2;
        Hashtable r3 = new Hashtable();
        oids = r3;
        Hashtable r4 = new Hashtable();
        des = r4;
        Integer r5 = Integers.valueOf(64);
        Integer r6 = Integers.valueOf(128);
        Integer r7 = Integers.valueOf(192);
        Integer r8 = Integers.valueOf(256);
        r1.put("DES", r5);
        r1.put("DESEDE", r7);
        r1.put("BLOWFISH", r6);
        r1.put(CryptoConst.ALGORITHM_AES, r8);
        r1.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), r8);
        r1.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), r6);
        r1.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), r7);
        r1.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), r8);
        r1.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), r6);
        r1.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), r7);
        r1.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), r8);
        r1.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), r6);
        r1.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), r7);
        r1.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), r7);
        r1.put(OIWObjectIdentifiers.desCBC.getId(), r5);
        r1.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), r8);
        r1.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.getId(), r8);
        r1.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId(), r8);
        r1.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), Integers.valueOf(160));
        r1.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), r8);
        r1.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), Integers.valueOf(384));
        r1.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), Integers.valueOf(512));
        r0.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
        r0.put(CryptoConst.ALGORITHM_AES, NISTObjectIdentifiers.id_aes256_CBC);
        r0.put("CAMELLIA", NTTObjectIdentifiers.id_camellia256_cbc);
        r0.put("SEED", KISAObjectIdentifiers.id_seedCBC);
        r0.put("DES", OIWObjectIdentifiers.desCBC);
        r2.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        r2.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        r2.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        r2.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        r2.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        r2.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        r2.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        r2.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
        r2.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        r2.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        r2.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        r2.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DESede");
        r2.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DESede");
        r2.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        r2.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), "HmacSHA1");
        r2.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        r2.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), "HmacSHA256");
        r2.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), "HmacSHA384");
        r2.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), "HmacSHA512");
        r2.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        r2.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        r2.put(NTTObjectIdentifiers.id_camellia256_cbc.getId(), "Camellia");
        r2.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), "Camellia");
        r2.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), "Camellia");
        r2.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), "Camellia");
        r2.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), "SEED");
        r2.put(KISAObjectIdentifiers.id_seedCBC.getId(), "SEED");
        r2.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        r2.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), "GOST28147");
        r2.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), CryptoConst.ALGORITHM_AES);
        r2.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), CryptoConst.ALGORITHM_AES);
        r2.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), CryptoConst.ALGORITHM_AES);
        r3.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
        r3.put(CryptoConst.ALGORITHM_AES, NISTObjectIdentifiers.id_aes256_CBC);
        r3.put("DES", OIWObjectIdentifiers.desCBC);
        r4.put("DES", "DES");
        r4.put("DESEDE", "DES");
        r4.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
        r4.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DES");
        r4.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DES");
    }

    private byte[] calcSecret() {
        if (this.hybridSpec == null) goto L7;
        byte[] r0 = doCalcSecret();
        byte[] r1 = Arrays.concatenate(r0, this.hybridSpec.getT());
        Arrays.clear(r0);
        return r1;
    L7:
        return doCalcSecret();
    }

    public static String getAlgorithm(String r3) {
        if (r3.indexOf(91) <= 0) goto L7;
        return r3.substring(0, r3.indexOf(91));
    L7:
        if (r3.startsWith(NISTObjectIdentifiers.aes.getId()) == false) goto L11;
        return CryptoConst.ALGORITHM_AES;
    L11:
        if (r3.startsWith(GNUObjectIdentifiers.Serpent.getId()) == false) goto L14;
        return "Serpent";
    L14:
        String r0 = (String) ZeusTransformUtils.preCheckCast(nameTable.get(Strings.toUpperCase(r3)), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L17;
        return r0;
    L17:
        return r3;
    }

    public static int getKeySize(String r2) {
        if (r2.indexOf(91) > 0) goto L5;
        String r3 = Strings.toUpperCase(r2);
        Map<String, Integer> r0 = keySizes;
        if (r0.containsKey(r3) == true) goto L11;
        return -1;
    L11:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        return Integer.parseInt(r2.substring(r2.indexOf(91) + 1, r2.indexOf(93)));
    }

    private byte[] getSharedSecretBytes(byte[] r6, String r7, int r8) {
        DerivationFunction r0 = this.kdf;
        if (r0 == null) goto L19;
        if (r8 < 0) goto L18;
        int r2 = r8 / 8;
        byte[] r3 = new byte[r2];
        if (ZeusTransformUtils.instanceOf(r0, DHKEKGenerator.class) == false) goto L14;
        if (r7 == null) goto L13;
        DerivationParameters r9 = new DHKDFParameters(new ASN1ObjectIdentifier(r7), r8, r6, this.ukmParameters);
    L15:
        this.kdf.init(r9);
        this.kdf.generateBytes(r3, 0, r2);
        Arrays.clear(r6);
        return r3;
    L11:
        throw new NoSuchAlgorithmException("no OID for algorithm: " + r7);
    L13:
        throw new NoSuchAlgorithmException("algorithm OID is null");
    L14:
        r9 = new KDFParameters(r6, this.ukmParameters);
        goto L15
    L18:
        throw new NoSuchAlgorithmException("unknown algorithm encountered: " + r7);
    L19:
        if (r8 <= 0) goto L22;
        int r10 = r8 / 8;
        byte[] r5 = new byte[r10];
        System.arraycopy(r6, 0, r5, 0, r10);
        Arrays.clear(r6);
        return r5;
    L22:
        return r6;
    }

    public abstract byte[] doCalcSecret();

    public abstract void doInitFromKey(Key r1, AlgorithmParameterSpec r2, SecureRandom r3);

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] r4, int r5) {
        byte[] r0 = engineGenerateSecret();
        if ((r4.length - r5) < r0.length) goto L7;
        System.arraycopy(r0, 0, r4, r5, r0.length);
        return r0.length;
    L7:
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + r0.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String r4) {
        String r0 = Strings.toUpperCase(r4);
        Hashtable r1 = oids;
        if (r1.containsKey(r0) == false) goto L5;
        String r2 = ((ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r1.get(r0), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin")).getId();
    L6:
        int r3 = getKeySize(r2);
        byte[] r5 = getSharedSecretBytes(calcSecret(), r2, r3);
        String r6 = getAlgorithm(r4);
        if (des.containsKey(r6) == false) goto L10;
        DESParameters.setOddParity(r5);
    L10:
        return new SecretKeySpec(r5, r6);
    L5:
        r2 = r4;
        goto L6
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        if (this.kdf == null) goto L11;
        byte[] r0 = calcSecret();
        return getSharedSecretBytes(r0, null, r0.length * 8);
    L7:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    L11:
        return calcSecret();
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key r3, SecureRandom r4) {
        doInitFromKey((Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin"), null, r4);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key r3, AlgorithmParameterSpec r4, SecureRandom r5) {
        Key r6 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        AlgorithmParameterSpec r7 = (AlgorithmParameterSpec) ZeusTransformUtils.wrapperContextForParams(r4, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, HybridValueParameterSpec.class) == false) goto L5;
        HybridValueParameterSpec r8 = (HybridValueParameterSpec) ZeusTransformUtils.preCheckCast(r7, HybridValueParameterSpec.class, "com.obric.memorydata.plugin");
        this.hybridSpec = r8;
        r7 = r8.getBaseParameterSpec();
    L6:
        doInitFromKey(r6, r7, r5);
        return;
    L5:
        this.hybridSpec = null;
        goto L6
    }
}
