package org.bouncycastle.cms.jcajce;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.PasswordRecipient;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

/* JADX INFO: loaded from: classes7.dex */
public class EnvelopedDataHelper {
    protected static final Map BASE_CIPHER_NAMES = null;
    protected static final Map CIPHER_ALG_NAMES = null;
    protected static final SecretKeySizeProvider KEY_SIZE_PROVIDER = null;
    protected static final Map MAC_ALG_NAMES = null;
    private static final Map PBKDF2_ALG_NAMES = null;
    private static final Set authEnvelopedAlgorithms = null;
    private static final short[] rc2Ekb = null;
    private static final short[] rc2Table = null;
    private JcaJceExtHelper helper;

    interface JCECallback {
        Object doInJCE();
    }

    static {
        KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
        HashSet r0 = new HashSet();
        authEnvelopedAlgorithms = r0;
        HashMap r1 = new HashMap();
        BASE_CIPHER_NAMES = r1;
        HashMap r2 = new HashMap();
        CIPHER_ALG_NAMES = r2;
        HashMap r3 = new HashMap();
        MAC_ALG_NAMES = r3;
        HashMap r4 = new HashMap();
        PBKDF2_ALG_NAMES = r4;
        r1.put(CMSAlgorithm.DES_CBC, "DES");
        r1.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE");
        r1.put(CMSAlgorithm.AES128_CBC, CryptoConst.ALGORITHM_AES);
        r1.put(CMSAlgorithm.AES192_CBC, CryptoConst.ALGORITHM_AES);
        r1.put(CMSAlgorithm.AES256_CBC, CryptoConst.ALGORITHM_AES);
        r1.put(CMSAlgorithm.RC2_CBC, "RC2");
        r1.put(CMSAlgorithm.CAST5_CBC, "CAST5");
        r1.put(CMSAlgorithm.CAMELLIA128_CBC, "Camellia");
        r1.put(CMSAlgorithm.CAMELLIA192_CBC, "Camellia");
        r1.put(CMSAlgorithm.CAMELLIA256_CBC, "Camellia");
        r1.put(CMSAlgorithm.SEED_CBC, "SEED");
        r1.put(PKCSObjectIdentifiers.rc4, "RC4");
        r1.put(CryptoProObjectIdentifiers.gostR28147_gcfb, "GOST28147");
        r2.put(CMSAlgorithm.DES_CBC, "DES/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.RC2_CBC, "RC2/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.AES128_CBC, "AES/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.AES192_CBC, "AES/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.AES256_CBC, "AES/CBC/PKCS5Padding");
        r2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        r2.put(CMSAlgorithm.CAST5_CBC, "CAST5/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.CAMELLIA128_CBC, "Camellia/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.CAMELLIA192_CBC, "Camellia/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.CAMELLIA256_CBC, "Camellia/CBC/PKCS5Padding");
        r2.put(CMSAlgorithm.SEED_CBC, "SEED/CBC/PKCS5Padding");
        r2.put(PKCSObjectIdentifiers.rc4, "RC4");
        r3.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDEMac");
        r3.put(CMSAlgorithm.AES128_CBC, "AESMac");
        r3.put(CMSAlgorithm.AES192_CBC, "AESMac");
        r3.put(CMSAlgorithm.AES256_CBC, "AESMac");
        r3.put(CMSAlgorithm.RC2_CBC, "RC2Mac");
        r4.put(PasswordRecipient.PRF.HMacSHA1.getAlgorithmID(), "PBKDF2WITHHMACSHA1");
        r4.put(PasswordRecipient.PRF.HMacSHA224.getAlgorithmID(), "PBKDF2WITHHMACSHA224");
        r4.put(PasswordRecipient.PRF.HMacSHA256.getAlgorithmID(), "PBKDF2WITHHMACSHA256");
        r4.put(PasswordRecipient.PRF.HMacSHA384.getAlgorithmID(), "PBKDF2WITHHMACSHA384");
        r4.put(PasswordRecipient.PRF.HMacSHA512.getAlgorithmID(), "PBKDF2WITHHMACSHA512");
        r0.add(NISTObjectIdentifiers.id_aes128_GCM);
        r0.add(NISTObjectIdentifiers.id_aes192_GCM);
        r0.add(NISTObjectIdentifiers.id_aes256_GCM);
        r0.add(NISTObjectIdentifiers.id_aes128_CCM);
        r0.add(NISTObjectIdentifiers.id_aes192_CCM);
        r0.add(NISTObjectIdentifiers.id_aes256_CCM);
        rc2Table = new short[]{189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
        rc2Ekb = new short[]{93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};
    }

    EnvelopedDataHelper(JcaJceExtHelper r3) {
        this.helper = (JcaJceExtHelper) ZeusTransformUtils.wrapperContextForParams(r3, JcaJceExtHelper.class, "com.obric.memorydata.plugin");
    }

    static Object execute(JCECallback r2) {
        return ((JCECallback) ZeusTransformUtils.wrapperContextForParams(r2, JCECallback.class, "com.obric.memorydata.plugin")).doInJCE();
    L8:
        e = move-exception;
        throw new CMSException("algorithm parameters invalid.", e);
    L17:
        e = move-exception;
        throw new CMSException("key invalid in message.", e);
    L20:
        e = move-exception;
        throw new CMSException("can't find algorithm.", e);
    L14:
        e = move-exception;
        throw new CMSException("can't find provider.", e);
    L5:
        e = move-exception;
        throw new CMSException("MAC algorithm parameter spec invalid.", e);
    L11:
        e = move-exception;
        throw new CMSException("required padding not supported.", e);
    }

    AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(BASE_CIPHER_NAMES.get(r4), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return this.helper.createAlgorithmParameters(r0);
    L7:
        return this.helper.createAlgorithmParameters(r4.getId());
    }

    public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier r3, PrivateKey r4) {
        PrivateKey r5 = CMSUtils.cleanPrivateKey((PrivateKey) ZeusTransformUtils.wrapperContextForParams(r4, PrivateKey.class, "com.obric.memorydata.plugin"));
        return this.helper.createAsymmetricUnwrapper(r3, r5);
    }

    Cipher createCipher(ASN1ObjectIdentifier r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(CIPHER_ALG_NAMES.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L8
        if (r0 == null) goto L7;
        return this.helper.createCipher(r0);
    L7:
        return this.helper.createCipher(r4.getId());
    L8:
        e = move-exception;
        throw new CMSException("cannot create cipher: " + e.getMessage(), e);
    }

    public Cipher createContentCipher(Key r3, final AlgorithmIdentifier r4) {
        final Key r5 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        return (Cipher) ZeusTransformUtils.preCheckCast(execute(new AnonymousClass1(this, r4, r5)), Cipher.class, "com.obric.memorydata.plugin");
    }

    KeyAgreement createKeyAgreement(ASN1ObjectIdentifier r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(BASE_CIPHER_NAMES.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L8
        if (r0 == null) goto L7;
        return this.helper.createKeyAgreement(r0);
    L7:
        return this.helper.createKeyAgreement(r4.getId());
    L8:
        e = move-exception;
        throw new CMSException("cannot create key agreement: " + e.getMessage(), e);
    }

    public KeyFactory createKeyFactory(ASN1ObjectIdentifier r4) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(BASE_CIPHER_NAMES.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L8
        if (r0 == null) goto L7;
        return this.helper.createKeyFactory(r0);
    L7:
        return this.helper.createKeyFactory(r4.getId());
    L8:
        e = move-exception;
        throw new CMSException("cannot create key factory: " + e.getMessage(), e);
    }

    String getBaseCipherName(ASN1ObjectIdentifier r3) {
        String r2 = (String) ZeusTransformUtils.preCheckCast(BASE_CIPHER_NAMES.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return r3.getId();
    }

    public Key getJceKey(ASN1ObjectIdentifier r4, GenericKey r5) {
        if (ZeusTransformUtils.instanceOf(r5.getRepresentation(), Key.class) == false) goto L7;
        return (Key) ZeusTransformUtils.preCheckCast(r5.getRepresentation(), Key.class, "com.obric.memorydata.plugin");
    L7:
        if ((r5.getRepresentation() instanceof byte[]) == false) goto L11;
        return new SecretKeySpec((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5.getRepresentation(), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"), getBaseCipherName(r4));
    L11:
        throw new IllegalArgumentException("unknown generic key type");
    }

    public void keySizeCheck(AlgorithmIdentifier r2, Key r3) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin");
        int r4 = KEY_SIZE_PROVIDER.getKeySize(r2);
        if (r4 <= 0) goto L12;
        byte[] r5 = null;
        r5 = r1.getEncoded();     // Catch: Exception -> L13
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if ((r5.length * 8) != r4) goto L11;
        return;
    L11:
        throw new CMSException("Expected key size for algorithm OID not found in recipient.");
    }
}
