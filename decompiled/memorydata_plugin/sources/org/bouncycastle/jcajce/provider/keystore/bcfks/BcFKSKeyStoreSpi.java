package org.bouncycastle.jcajce.provider.keystore.bcfks;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAKey;
import java.security.interfaces.RSAKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bc.EncryptedObjectStoreData;
import org.bouncycastle.asn1.bc.EncryptedPrivateKeyData;
import org.bouncycastle.asn1.bc.EncryptedSecretKeyData;
import org.bouncycastle.asn1.bc.ObjectData;
import org.bouncycastle.asn1.bc.ObjectDataSequence;
import org.bouncycastle.asn1.bc.ObjectStore;
import org.bouncycastle.asn1.bc.ObjectStoreData;
import org.bouncycastle.asn1.bc.ObjectStoreIntegrityCheck;
import org.bouncycastle.asn1.bc.PbkdMacIntegrityCheck;
import org.bouncycastle.asn1.bc.SecretKeyData;
import org.bouncycastle.asn1.bc.SignatureCheck;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.ScryptParams;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.nsri.NSRIObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.generators.SCrypt;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.PBKDF2Config;
import org.bouncycastle.crypto.util.PBKDFConfig;
import org.bouncycastle.crypto.util.ScryptConfig;
import org.bouncycastle.internal.asn1.cms.CCMParameters;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.bouncycastle.jcajce.BCFKSStoreParameter;
import org.bouncycastle.jcajce.BCLoadStoreParameter;
import org.bouncycastle.jcajce.provider.keystore.util.ParameterUtil;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
class BcFKSKeyStoreSpi extends KeyStoreSpi {
    private static final BigInteger CERTIFICATE = null;
    private static final BigInteger PRIVATE_KEY = null;
    private static final BigInteger PROTECTED_PRIVATE_KEY = null;
    private static final BigInteger PROTECTED_SECRET_KEY = null;
    private static final BigInteger SECRET_KEY = null;
    private static final Map<String, ASN1ObjectIdentifier> oidMap = null;
    private static final Map<ASN1ObjectIdentifier, String> publicAlgMap = null;
    private Date creationDate;
    private final Map<String, ObjectData> entries;
    private final JcaJceHelper helper;
    private AlgorithmIdentifier hmacAlgorithm;
    private KeyDerivationFunc hmacPkbdAlgorithm;
    private Date lastModifiedDate;
    private final Map<String, PrivateKey> privateKeyCache;
    private AlgorithmIdentifier signatureAlgorithm;
    private ASN1ObjectIdentifier storeEncryptionAlgorithm;
    private BCFKSLoadStoreParameter.CertChainValidator validator;
    private PublicKey verificationKey;

    private static class ExtKeyStoreException extends KeyStoreException {
        private final Throwable cause;

        ExtKeyStoreException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        HashMap r0 = new HashMap();
        oidMap = r0;
        HashMap r1 = new HashMap();
        publicAlgMap = r1;
        r0.put("DESEDE", OIWObjectIdentifiers.desEDE);
        r0.put("TRIPLEDES", OIWObjectIdentifiers.desEDE);
        r0.put("TDEA", OIWObjectIdentifiers.desEDE);
        r0.put("HMACSHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
        r0.put("HMACSHA224", PKCSObjectIdentifiers.id_hmacWithSHA224);
        r0.put("HMACSHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
        r0.put("HMACSHA384", PKCSObjectIdentifiers.id_hmacWithSHA384);
        r0.put("HMACSHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
        r0.put("SEED", KISAObjectIdentifiers.id_seedCBC);
        r0.put("CAMELLIA.128", NTTObjectIdentifiers.id_camellia128_cbc);
        r0.put("CAMELLIA.192", NTTObjectIdentifiers.id_camellia192_cbc);
        r0.put("CAMELLIA.256", NTTObjectIdentifiers.id_camellia256_cbc);
        r0.put("ARIA.128", NSRIObjectIdentifiers.id_aria128_cbc);
        r0.put("ARIA.192", NSRIObjectIdentifiers.id_aria192_cbc);
        r0.put("ARIA.256", NSRIObjectIdentifiers.id_aria256_cbc);
        r1.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        r1.put(X9ObjectIdentifiers.id_ecPublicKey, CryptoConst.ALGORITHM_EC);
        r1.put(OIWObjectIdentifiers.elGamalAlgorithm, "DH");
        r1.put(PKCSObjectIdentifiers.dhKeyAgreement, "DH");
        r1.put(X9ObjectIdentifiers.id_dsa, "DSA");
        CERTIFICATE = BigInteger.valueOf(0);
        PRIVATE_KEY = BigInteger.valueOf(1);
        SECRET_KEY = BigInteger.valueOf(2);
        PROTECTED_PRIVATE_KEY = BigInteger.valueOf(3);
        PROTECTED_SECRET_KEY = BigInteger.valueOf(4);
    }

    private byte[] calculateMac(byte[] r5, AlgorithmIdentifier r6, KeyDerivationFunc r7, char[] r8) {
        String r9 = r6.getAlgorithm().getId();
        Mac r0 = this.helper.createMac(r9);
    L10:
        e = move-exception;
        throw new IOException("Cannot set up MAC calculation: " + e.getMessage());
    L4:
        if (r8 != null) goto L7;
        r8 = new char[0];     // Catch: InvalidKeyException -> L10
    L7:
        r0.init(new SecretKeySpec(generateKey(r7, "INTEGRITY_CHECK", r8, -1), r9));     // Catch: InvalidKeyException -> L10
        return r0.doFinal(r5);
    }

    private Cipher createCipher(String r2, byte[] r3) {
        Cipher r1 = this.helper.createCipher(r2);
        r1.init(1, new SecretKeySpec(r3, CryptoConst.ALGORITHM_AES));
        return r1;
    }

    private EncryptedPrivateKeyData createPrivateKeySequence(EncryptedPrivateKeyInfo r3, Certificate[] r4) {
        org.bouncycastle.asn1.x509.Certificate[] r2 = new org.bouncycastle.asn1.x509.Certificate[r4.length];
        int r0 = 0;
    L4:
        if (r0 == r4.length) goto L7;
        r2[r0] = org.bouncycastle.asn1.x509.Certificate.getInstance(r4[r0].getEncoded());
        r0 = r0 + 1;
        goto L4
    L7:
        return new EncryptedPrivateKeyData(r3, r2);
    }

    private Certificate decodeCertificate(Object r3) {
        JcaJceHelper r2 = this.helper;
        if (r2 == null) goto L12;
        return r2.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(org.bouncycastle.asn1.x509.Certificate.getInstance(r3).getEncoded()));
    L6:
        return null;
    L12:
        return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(org.bouncycastle.asn1.x509.Certificate.getInstance(r3).getEncoded()));
    L9:
        return null;
    }

    private byte[] decryptData(String r5, AlgorithmIdentifier r6, char[] r7, byte[] r8) {
        if (r6.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBES2) == false) goto L25;
        PBES2Parameters r9 = PBES2Parameters.getInstance(r6.getParameters());
        EncryptionScheme r0 = r9.getEncryptionScheme();
    L22:
        e = move-exception;
        throw e;
    L19:
        e = move-exception;
        throw new IOException(e.toString());
    L6:
        if (r0.getAlgorithm().equals(NISTObjectIdentifiers.id_aes256_CCM) == false) goto L9;
        Cipher r1 = this.helper.createCipher("AES/CCM/NoPadding");     // Catch: Exception -> L19 IOException -> L22
        AlgorithmParameters r2 = this.helper.createAlgorithmParameters("CCM");     // Catch: Exception -> L19 IOException -> L22
        r2.init(CCMParameters.getInstance(r0.getParameters()).getEncoded());     // Catch: Exception -> L19 IOException -> L22
    L11:
        KeyDerivationFunc r10 = r9.getKeyDerivationFunc();     // Catch: Exception -> L19 IOException -> L22
        if (r7 != null) goto L15;
        r7 = new char[0];     // Catch: Exception -> L19 IOException -> L22
    L15:
        r1.init(2, new SecretKeySpec(generateKey(r10, r5, r7, 32), CryptoConst.ALGORITHM_AES), r2);     // Catch: Exception -> L19 IOException -> L22
        return r1.doFinal(r8);
    L9:
        if (r0.getAlgorithm().equals(NISTObjectIdentifiers.id_aes256_wrap_pad) == false) goto L18;
        r1 = this.helper.createCipher("AESKWP");     // Catch: Exception -> L19 IOException -> L22
        r2 = null;
        goto L11
    L18:
        throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");     // Catch: Exception -> L19 IOException -> L22
    L25:
        throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
    }

    private Date extractCreationDate(ObjectData r1, Date r2) {
        return r1.getCreationDate().getDate();
    L7:
        return r2;
    }

    private byte[] generateKey(KeyDerivationFunc r7, String r8, char[] r9, int r10) {
        byte[] r6 = PBEParametersGenerator.PKCS12PasswordToBytes(r9);
        byte[] r11 = PBEParametersGenerator.PKCS12PasswordToBytes(r8.toCharArray());
        if (MiscObjectIdentifiers.id_scrypt.equals(r7.getAlgorithm()) == false) goto L13;
        ScryptParams r12 = ScryptParams.getInstance(r7.getParameters());
        if (r12.getKeyLength() == null) goto L7;
        r10 = r12.getKeyLength().intValue();
    L9:
        return SCrypt.generate(Arrays.concatenate(r6, r11), r12.getSalt(), r12.getCostParameter().intValue(), r12.getBlockSize().intValue(), r12.getBlockSize().intValue(), r10);
    L7:
        if (r10 != (-1)) goto L9;
        throw new IOException("no keyLength found in ScryptParams");
    L13:
        if (r7.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBKDF2) == false) goto L31;
        PBKDF2Params r13 = PBKDF2Params.getInstance(r7.getParameters());
        if (r13.getKeyLength() == null) goto L17;
        r10 = r13.getKeyLength().intValue();
    L19:
        if (r13.getPrf().getAlgorithm().equals(PKCSObjectIdentifiers.id_hmacWithSHA512) == false) goto L23;
        PKCS5S2ParametersGenerator r14 = new PKCS5S2ParametersGenerator(new SHA512Digest());
        r14.init(Arrays.concatenate(r6, r11), r13.getSalt(), r13.getIterationCount().intValue());
        return ((KeyParameter) ZeusTransformUtils.preCheckCast(r14.generateDerivedParameters(r10 * 8), KeyParameter.class, "com.obric.memorydata.plugin")).getKey();
    L23:
        if (r13.getPrf().getAlgorithm().equals(NISTObjectIdentifiers.id_hmacWithSHA3_512) == false) goto L27;
        PKCS5S2ParametersGenerator r15 = new PKCS5S2ParametersGenerator(new SHA3Digest(512));
        r15.init(Arrays.concatenate(r6, r11), r13.getSalt(), r13.getIterationCount().intValue());
        return ((KeyParameter) ZeusTransformUtils.preCheckCast(r15.generateDerivedParameters(r10 * 8), KeyParameter.class, "com.obric.memorydata.plugin")).getKey();
    L27:
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF: " + r13.getPrf().getAlgorithm());
    L17:
        if (r10 != (-1)) goto L19;
        throw new IOException("no keyLength found in PBKDF2Params");
    L31:
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(ASN1ObjectIdentifier r7, int r8) {
        byte[] r0 = new byte[64];
        getDefaultSecureRandom().nextBytes(r0);
        if (PKCSObjectIdentifiers.id_PBKDF2.equals(r7) == false) goto L7;
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(r0, 51200, r8, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE)));
    L7:
        throw new IllegalStateException("unknown derivation algorithm: " + r7);
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(KeyDerivationFunc r8, int r9) {
        boolean r0 = MiscObjectIdentifiers.id_scrypt.equals(r8.getAlgorithm());
        ASN1Encodable r10 = r8.getParameters();
        if (r0 == false) goto L6;
        ScryptParams r11 = ScryptParams.getInstance(r10);
        byte[] r2 = new byte[r11.getSalt().length];
        getDefaultSecureRandom().nextBytes(r2);
        return new KeyDerivationFunc(MiscObjectIdentifiers.id_scrypt, new ScryptParams(r2, r11.getCostParameter(), r11.getBlockSize(), r11.getParallelizationParameter(), BigInteger.valueOf(r9)));
    L6:
        PBKDF2Params r12 = PBKDF2Params.getInstance(r10);
        byte[] r1 = new byte[r12.getSalt().length];
        getDefaultSecureRandom().nextBytes(r1);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(r1, r12.getIterationCount().intValue(), r9, r12.getPrf()));
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(PBKDFConfig r8, int r9) {
        if (MiscObjectIdentifiers.id_scrypt.equals(r8.getAlgorithm()) == false) goto L6;
        ScryptConfig r10 = (ScryptConfig) ZeusTransformUtils.preCheckCast(r8, ScryptConfig.class, "com.obric.memorydata.plugin");
        byte[] r2 = new byte[r10.getSaltLength()];
        getDefaultSecureRandom().nextBytes(r2);
        ScryptParams r7 = new ScryptParams(r2, r10.getCostParameter(), r10.getBlockSize(), r10.getParallelizationParameter(), r9);
        return new KeyDerivationFunc(MiscObjectIdentifiers.id_scrypt, r7);
    L6:
        PBKDF2Config r11 = (PBKDF2Config) ZeusTransformUtils.preCheckCast(r8, PBKDF2Config.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[r11.getSaltLength()];
        getDefaultSecureRandom().nextBytes(r0);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(r0, r11.getIterationCount(), r9, r11.getPRF()));
    }

    private AlgorithmIdentifier generateSignatureAlgId(Key r2, BCFKSLoadStoreParameter.SignatureAlgorithm r3) {
        Key r1 = (Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, ECKey.class) == false) goto L17;
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withECDSA) goto L13;
        return new AlgorithmIdentifier(X9ObjectIdentifiers.ecdsa_with_SHA512);
    L13:
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withECDSA) goto L17;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_ecdsa_with_sha3_512);
    L17:
        if (ZeusTransformUtils.instanceOf(r1, DSAKey.class) == false) goto L27;
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withDSA) goto L23;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.dsa_with_sha512);
    L23:
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withDSA) goto L27;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_dsa_with_sha3_512);
    L27:
        if (ZeusTransformUtils.instanceOf(r1, RSAKey.class) == false) goto L37;
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withRSA) goto L33;
        return new AlgorithmIdentifier(PKCSObjectIdentifiers.sha512WithRSAEncryption, DERNull.INSTANCE);
    L33:
        if (r3 != BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withRSA) goto L37;
        return new AlgorithmIdentifier(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512, DERNull.INSTANCE);
    L37:
        throw new IOException("unknown signature algorithm");
    }

    private SecureRandom getDefaultSecureRandom() {
        return CryptoServicesRegistrar.getSecureRandom();
    }

    private EncryptedObjectStoreData getEncryptedObjectStoreData(AlgorithmIdentifier r10, char[] r11) {
        ObjectData[] r0 = (ObjectData[]) ZeusTransformUtils.preCheckCast((ObjectData[]) ZeusTransformUtils.preCheckCast(this.entries.values().toArray(new ObjectData[this.entries.size()]), ObjectData[].class, "com.obric.memorydata.plugin"), ObjectData[].class, "com.obric.memorydata.plugin");
        KeyDerivationFunc r1 = generatePkbdAlgorithmIdentifier(this.hmacPkbdAlgorithm, 32);
        if (r11 != null) goto L6;
        r11 = new char[0];
    L6:
        byte[] r12 = generateKey(r1, "STORE_ENCRYPTION", r11, 32);
        ObjectStoreData r8 = new ObjectStoreData(r10, this.creationDate, this.lastModifiedDate, new ObjectDataSequence(r0), null);
    L16:
        e = move-exception;
        throw new IOException(e.toString());
    L13:
        e = move-exception;
        throw new IOException(e.toString());
    L22:
        e = move-exception;
        throw new IOException(e.toString());
    L19:
        e = move-exception;
        throw new IOException(e.toString());
    L25:
        e = move-exception;
        throw new NoSuchAlgorithmException(e.toString());
    L8:
        if (this.storeEncryptionAlgorithm.equals(NISTObjectIdentifiers.id_aes256_CCM) == false) goto L10;
        Cipher r9 = createCipher("AES/CCM/NoPadding", r12);     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        byte[] r13 = r9.doFinal(r8.getEncoded());     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        AlgorithmParameters r14 = r9.getParameters();     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        PBES2Parameters r15 = new PBES2Parameters(r1, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(r14.getEncoded())));     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        return new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, r15), r13);
    L10:
        byte[] r16 = createCipher("AESKWP", r12).doFinal(r8.getEncoded());     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        PBES2Parameters r17 = new PBES2Parameters(r1, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad));     // Catch: NoSuchProviderException -> L13 InvalidKeyException -> L16 IllegalBlockSizeException -> L19 BadPaddingException -> L22 NoSuchPaddingException -> L25
        return new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, r17), r16);
    }

    private static String getPublicKeyAlg(ASN1ObjectIdentifier r3) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(publicAlgMap.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return r3.getId();
    }

    private boolean isSimilarHmacPbkd(PBKDFConfig r3, KeyDerivationFunc r4) {
        if (r3.getAlgorithm().equals(r4.getAlgorithm()) == true) goto L6;
        return false;
    L6:
        if (MiscObjectIdentifiers.id_scrypt.equals(r4.getAlgorithm()) == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r3, ScryptConfig.class) == true) goto L10;
        return false;
    L10:
        ScryptConfig r2 = (ScryptConfig) ZeusTransformUtils.preCheckCast(r3, ScryptConfig.class, "com.obric.memorydata.plugin");
        ScryptParams r5 = ScryptParams.getInstance(r4.getParameters());
        if (r2.getSaltLength() == r5.getSalt().length) goto L13;
    L18:
        return false;
    L13:
        if (r2.getBlockSize() != r5.getBlockSize().intValue()) goto L18;
        if (r2.getCostParameter() != r5.getCostParameter().intValue()) goto L18;
        if (r2.getParallelizationParameter() != r5.getParallelizationParameter().intValue()) goto L18;
        return true;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, PBKDF2Config.class) == true) goto L22;
        return false;
    L22:
        PBKDF2Config r6 = (PBKDF2Config) ZeusTransformUtils.preCheckCast(r3, PBKDF2Config.class, "com.obric.memorydata.plugin");
        PBKDF2Params r7 = PBKDF2Params.getInstance(r4.getParameters());
        if (r6.getSaltLength() == r7.getSalt().length) goto L25;
    L29:
        return false;
    L25:
        if (r6.getIterationCount() != r7.getIterationCount().intValue()) goto L29;
        return true;
    }

    private void verifyMac(byte[] r3, PbkdMacIntegrityCheck r4, char[] r5) {
        if (Arrays.constantTimeAreEqual(calculateMac(r3, r4.getMacAlgorithm(), r4.getPbkdAlgorithm(), r5), r4.getMac()) == false) goto L6;
        return;
    L6:
        throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed");
    }

    private void verifySig(ASN1Encodable r3, SignatureCheck r4, PublicKey r5) {
        ASN1Encodable r6 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        PublicKey r7 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r5, PublicKey.class, "com.obric.memorydata.plugin");
        Signature r2 = this.helper.createSignature(r4.getSignatureAlgorithm().getAlgorithm().getId());
        r2.initVerify(r7);
        r2.update(r6.toASN1Primitive().getEncoded("DER"));
        if (r2.verify(r4.getSignature().getOctets()) == false) goto L6;
        return;
    L6:
        throw new IOException("BCFKS KeyStore corrupted: signature calculation failed");
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        final Iterator r0 = new HashSet(this.entries.keySet()).iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String r2) {
        Objects.requireNonNull(r2, "alias value is null");
        return this.entries.containsKey(r2);
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String r4) {
        if (((ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r4), ObjectData.class, "com.obric.memorydata.plugin")) != null) goto L5;
        return;
    L5:
        this.privateKeyCache.remove(r4);
        this.entries.remove(r4);
        this.lastModifiedDate = new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String r3) {
        ObjectData r4 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r3), ObjectData.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.getType().equals(PRIVATE_KEY) == true) goto L14;
        if (r4.getType().equals(PROTECTED_PRIVATE_KEY) == true) goto L14;
        if (r4.getType().equals(CERTIFICATE) == true) goto L12;
        return null;
    L12:
        return decodeCertificate(r4.getData());
    L14:
        return decodeCertificate(EncryptedPrivateKeyData.getInstance(r4.getData()).getCertificateChain()[0]);
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate r7) {
        if (r7 != null) goto L26;
        return null;
    L26:
        byte[] r8 = r7.getEncoded();     // Catch: CertificateEncodingException -> L23
        Iterator<String> r1 = this.entries.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L21;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        ObjectData r3 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r2), ObjectData.class, "com.obric.memorydata.plugin");
        if (r3.getType().equals(CERTIFICATE) == true) goto L12;
        if (r3.getType().equals(PRIVATE_KEY) == false) goto L17;
    L24:
        if (Arrays.areEqual(EncryptedPrivateKeyData.getInstance(r3.getData()).getCertificateChain()[0].toASN1Primitive().getEncoded(), r8) == false) goto L8;
        return r2;
    L17:
        if (r3.getType().equals(PROTECTED_PRIVATE_KEY) == false) goto L8;
    L12:
        if (Arrays.areEqual(r3.getData(), r8) == false) goto L8;
        return r2;
    L21:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String r5) {
        ObjectData r6 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r5), ObjectData.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.getType().equals(PRIVATE_KEY) == false) goto L7;
    L8:
        org.bouncycastle.asn1.x509.Certificate[] r7 = EncryptedPrivateKeyData.getInstance(r6.getData()).getCertificateChain();
        int r0 = r7.length;
        X509Certificate[] r1 = new X509Certificate[r0];
        int r2 = 0;
    L9:
        if (r2 == r0) goto L11;
        r1[r2] = decodeCertificate(r7[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        return r1;
    L7:
        if (r6.getType().equals(PROTECTED_PRIVATE_KEY) == true) goto L8;
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String r2) {
        ObjectData r1 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r2), ObjectData.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getLastModifiedDate().getDate();
    L7:
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String r6, char[] r7) {
        ObjectData r0 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r6), ObjectData.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getType().equals(PRIVATE_KEY) == false) goto L7;
    L22:
        PrivateKey r1 = (PrivateKey) ZeusTransformUtils.preCheckCast(this.privateKeyCache.get(r6), PrivateKey.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L25;
        return r1;
    L25:
        EncryptedPrivateKeyInfo r2 = EncryptedPrivateKeyInfo.getInstance(EncryptedPrivateKeyData.getInstance(r0.getData()).getEncryptedPrivateKeyInfo());
        PrivateKeyInfo r8 = PrivateKeyInfo.getInstance(decryptData("PRIVATE_KEY_ENCRYPTION", r2.getEncryptionAlgorithm(), r7, r2.getEncryptedData()));     // Catch: Exception -> L28
        PrivateKey r9 = this.helper.createKeyFactory(getPublicKeyAlg(r8.getPrivateKeyAlgorithm().getAlgorithm())).generatePrivate(new PKCS8EncodedKeySpec(r8.getEncoded()));     // Catch: Exception -> L28
        this.privateKeyCache.put(r6, r9);     // Catch: Exception -> L28
        return r9;
    L28:
        e = move-exception;
        throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover private key (" + r6 + "): " + e.getMessage());
    L7:
        if (r0.getType().equals(PROTECTED_PRIVATE_KEY) == true) goto L22;
        if (r0.getType().equals(SECRET_KEY) == false) goto L12;
    L16:
        EncryptedSecretKeyData r3 = EncryptedSecretKeyData.getInstance(r0.getData());
        SecretKeyData r10 = SecretKeyData.getInstance(decryptData("SECRET_KEY_ENCRYPTION", r3.getKeyEncryptionAlgorithm(), r7, r3.getEncryptedKeyData()));     // Catch: Exception -> L19
        return this.helper.createSecretKeyFactory(r10.getKeyAlgorithm().getId()).generateSecret(new SecretKeySpec(r10.getKeyBytes(), r10.getKeyAlgorithm().getId()));
    L19:
        e = move-exception;
        throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + r6 + "): " + e.getMessage());
    L12:
        if (r0.getType().equals(PROTECTED_SECRET_KEY) == true) goto L16;
        throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + r6 + "): type not recognized");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String r2) {
        ObjectData r1 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r2), ObjectData.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        return r1.getType().equals(CERTIFICATE);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String r2) {
        ObjectData r1 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r2), ObjectData.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L14;
        BigInteger r3 = r1.getType();
        if (r3.equals(PRIVATE_KEY) == false) goto L7;
    L12:
        return true;
    L7:
        if (r3.equals(SECRET_KEY) == true) goto L12;
        if (r3.equals(PROTECTED_PRIVATE_KEY) == true) goto L12;
        if (r3.equals(PROTECTED_SECRET_KEY) == true) goto L12;
        return false;
    L14:
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream r12, char[] r13) {
        this.entries.clear();
        this.privateKeyCache.clear();
        this.creationDate = null;
        this.lastModifiedDate = null;
        this.hmacAlgorithm = null;
        if (r12 != null) goto L62;
        Date r14 = new Date();
        this.creationDate = r14;
        this.lastModifiedDate = r14;
        this.verificationKey = null;
        this.validator = null;
        this.hmacAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 64);
        return;
    L62:
        ObjectStore r15 = ObjectStore.getInstance(new ASN1InputStream(r12).readObject());     // Catch: Exception -> L56
        ObjectStoreIntegrityCheck r0 = r15.getIntegrityCheck();
        if (r0.getType() != 0) goto L17;
        PbkdMacIntegrityCheck r1 = PbkdMacIntegrityCheck.getInstance(r0.getIntegrityCheck());
        this.hmacAlgorithm = r1.getMacAlgorithm();
        this.hmacPkbdAlgorithm = r1.getPbkdAlgorithm();
        AlgorithmIdentifier r2 = this.hmacAlgorithm;
        verifyMac(r15.getStoreData().toASN1Primitive().getEncoded(), r1, r13);     // Catch: NoSuchProviderException -> L13
    L35:
        ASN1Encodable r16 = r15.getStoreData();
        if (ZeusTransformUtils.instanceOf(r16, EncryptedObjectStoreData.class) == false) goto L38;
        EncryptedObjectStoreData r17 = (EncryptedObjectStoreData) ZeusTransformUtils.preCheckCast(r16, EncryptedObjectStoreData.class, "com.obric.memorydata.plugin");
        ObjectStoreData r18 = ObjectStoreData.getInstance(decryptData("STORE_ENCRYPTION", r17.getEncryptionAlgorithm(), r13, r17.getEncryptedContent().getOctets()));
    L64:
        this.creationDate = r18.getCreationDate().getDate();     // Catch: ParseException -> L49
        this.lastModifiedDate = r18.getLastModifiedDate().getDate();     // Catch: ParseException -> L49
        if (r18.getIntegrityAlgorithm().equals(r2) == false) goto L48;
        Iterator<ASN1Encodable> r19 = r18.getObjectDataSequence().iterator();
    L44:
        if (r19.hasNext() == false) goto L46;
        ObjectData r110 = ObjectData.getInstance(r19.next());
        this.entries.put(r110.getIdentifier(), r110);
        goto L44
    L46:
        return;
    L48:
        throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
    L50:
        throw new IOException("BCFKS KeyStore unable to parse store data information.");
    L38:
        r18 = ObjectStoreData.getInstance(r16);
    L13:
        e = move-exception;
        throw new IOException(e.getMessage());
    L17:
        if (r0.getType() != 1) goto L55;
        SignatureCheck r3 = SignatureCheck.getInstance(r0.getIntegrityCheck());
        r2 = r3.getSignatureAlgorithm();
        org.bouncycastle.asn1.x509.Certificate[] r4 = r3.getCertificates();     // Catch: GeneralSecurityException -> L51
        if (this.validator == null) goto L33;
        if (r4 == null) goto L32;
        CertificateFactory r5 = this.helper.createCertificateFactory("X.509");     // Catch: GeneralSecurityException -> L51
        int r6 = r4.length;     // Catch: GeneralSecurityException -> L51
        X509Certificate[] r7 = new X509Certificate[r6];     // Catch: GeneralSecurityException -> L51
        int r8 = 0;
    L23:
        if (r8 == r6) goto L26;
        r7[r8] = (X509Certificate) ZeusTransformUtils.preCheckCast(r5.generateCertificate(new ByteArrayInputStream(r4[r8].getEncoded())), X509Certificate.class, "com.obric.memorydata.plugin");     // Catch: GeneralSecurityException -> L51
        r8 = r8 + 1;     // Catch: GeneralSecurityException -> L51
        goto L23
    L26:
        if (this.validator.isValid(r7) == false) goto L30;
        ASN1Encodable r9 = r15.getStoreData();     // Catch: GeneralSecurityException -> L51
        PublicKey r10 = r7[0].getPublicKey();     // Catch: GeneralSecurityException -> L51
    L28:
        verifySig(r9, r3, r10);     // Catch: GeneralSecurityException -> L51
        goto L35
    L30:
        throw new IOException("certificate chain in key store signature not valid");     // Catch: GeneralSecurityException -> L51
    L32:
        throw new IOException("validator specified but no certifcates in store");     // Catch: GeneralSecurityException -> L51
    L33:
        r9 = r15.getStoreData();     // Catch: GeneralSecurityException -> L51
        r10 = this.verificationKey;     // Catch: GeneralSecurityException -> L51
    L51:
        e = move-exception;
        throw new IOException("error verifying signature: " + e.getMessage(), e);
    L55:
        throw new IOException("BCFKS KeyStore unable to recognize integrity check.");
    L56:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter r6) {
        KeyStore.LoadStoreParameter r7 = (KeyStore.LoadStoreParameter) ZeusTransformUtils.wrapperContextForParams(r6, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        engineLoad(null, null);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, BCFKSLoadStoreParameter.class) == false) goto L25;
        BCFKSLoadStoreParameter r8 = (BCFKSLoadStoreParameter) ZeusTransformUtils.preCheckCast(r7, BCFKSLoadStoreParameter.class, "com.obric.memorydata.plugin");
        char[] r0 = ParameterUtil.extractPassword(r8);
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(r8.getStorePBKDFConfig(), 64);
        if (r8.getStoreEncryptionAlgorithm() != BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM) goto L10;
        ASN1ObjectIdentifier r2 = NISTObjectIdentifiers.id_aes256_CCM;
    L11:
        this.storeEncryptionAlgorithm = r2;
        if (r8.getStoreMacAlgorithm() != BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512) goto L14;
        AlgorithmIdentifier r3 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
    L15:
        this.hmacAlgorithm = r3;
        this.verificationKey = (PublicKey) ZeusTransformUtils.preCheckCast(r8.getStoreSignatureKey(), PublicKey.class, "com.obric.memorydata.plugin");
        this.validator = r8.getCertChainValidator();
        this.signatureAlgorithm = generateSignatureAlgId(this.verificationKey, r8.getStoreSignatureAlgorithm());
        ASN1ObjectIdentifier r1 = this.storeEncryptionAlgorithm;
        InputStream r4 = r8.getInputStream();
        engineLoad(r4, r0);
        if (r4 != null) goto L18;
        return;
    L18:
        if (isSimilarHmacPbkd(r8.getStorePBKDFConfig(), this.hmacPkbdAlgorithm) == false) goto L23;
        if (r1.equals(this.storeEncryptionAlgorithm) == false) goto L23;
        return;
    L23:
        throw new IOException("configuration parameters do not match existing store");
    L14:
        r3 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, DERNull.INSTANCE);
        goto L15
    L10:
        r2 = NISTObjectIdentifiers.id_aes256_wrap_pad;
        goto L11
    L25:
        if (ZeusTransformUtils.instanceOf(r7, BCLoadStoreParameter.class) == false) goto L29;
        engineLoad(((BCLoadStoreParameter) ZeusTransformUtils.preCheckCast(r7, BCLoadStoreParameter.class, "com.obric.memorydata.plugin")).getInputStream(), ParameterUtil.extractPassword(r7));
        return;
    L29:
        throw new IllegalArgumentException("no support for 'parameter' of type " + r7.getClass().getName());
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String r11, Certificate r12) {
        ObjectData r0 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r11), ObjectData.class, "com.obric.memorydata.plugin");
        Date r8 = new Date();
        if (r0 != null) goto L5;
        Date r4 = r8;
    L16:
        this.entries.put(r11, new ObjectData(CERTIFICATE, r11, r4, r8, r12.getEncoded(), null));     // Catch: CertificateEncodingException -> L13
        this.lastModifiedDate = r8;
        return;
    L13:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore unable to handle certificate: " + e.getMessage(), e);
    L5:
        if (r0.getType().equals(CERTIFICATE) == false) goto L8;
        r4 = extractCreationDate(r0, r8);
        goto L16
    L8:
        throw new KeyStoreException("BCFKS KeyStore already has a key entry with alias " + r11);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r11, Key r12, char[] r13, Certificate[] r14) {
        Key r15 = (Key) ZeusTransformUtils.wrapperContextForParams(r12, Key.class, "com.obric.memorydata.plugin");
        Date r0 = new Date();
        ObjectData r2 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r11), ObjectData.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        Date r5 = extractCreationDate(r2, r0);
    L6:
        this.privateKeyCache.remove(r11);
        if (ZeusTransformUtils.instanceOf(r15, PrivateKey.class) == false) goto L25;
        if (r14 == null) goto L23;
        byte[] r16 = r15.getEncoded();     // Catch: Exception -> L19
        KeyDerivationFunc r1 = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 32);     // Catch: Exception -> L19
        if (r13 != null) goto L13;
        r13 = new char[0];     // Catch: Exception -> L19
    L13:
        byte[] r17 = generateKey(r1, "PRIVATE_KEY_ENCRYPTION", r13, 32);     // Catch: Exception -> L19
        if (this.storeEncryptionAlgorithm.equals(NISTObjectIdentifiers.id_aes256_CCM) == false) goto L16;
        Cipher r18 = createCipher("AES/CCM/NoPadding", r17);     // Catch: Exception -> L19
        EncryptedPrivateKeyInfo r19 = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(r1, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(r18.getParameters().getEncoded())))), r18.doFinal(r16));     // Catch: Exception -> L19
    L17:
        this.entries.put(r11, new ObjectData(PRIVATE_KEY, r11, r5, r0, createPrivateKeySequence(r19, r14).getEncoded(), null));     // Catch: Exception -> L19
    L45:
        this.lastModifiedDate = r0;
        return;
    L16:
        r19 = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(r1, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad))), createCipher("AESKWP", r17).doFinal(r16));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e.toString(), e);
    L23:
        throw new KeyStoreException("BCFKS KeyStore requires a certificate chain for private key storage.");
    L25:
        if (ZeusTransformUtils.instanceOf(r15, SecretKey.class) == false) goto L55;
        if (r14 != null) goto L53;
        byte[] r110 = r15.getEncoded();     // Catch: Exception -> L49
        KeyDerivationFunc r3 = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 32);     // Catch: Exception -> L49
        if (r13 != null) goto L31;
        r13 = new char[0];     // Catch: Exception -> L49
    L31:
        byte[] r111 = generateKey(r3, "SECRET_KEY_ENCRYPTION", r13, 32);     // Catch: Exception -> L49
        String r112 = Strings.toUpperCase(r15.getAlgorithm());     // Catch: Exception -> L49
        if (r112.indexOf(CryptoConst.ALGORITHM_AES) <= (-1)) goto L34;
        SecretKeyData r113 = new SecretKeyData(NISTObjectIdentifiers.aes, r110);     // Catch: Exception -> L49
    L41:
        if (this.storeEncryptionAlgorithm.equals(NISTObjectIdentifiers.id_aes256_CCM) == false) goto L43;
        Cipher r114 = createCipher("AES/CCM/NoPadding", r111);     // Catch: Exception -> L49
        EncryptedSecretKeyData r115 = new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(r3, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(r114.getParameters().getEncoded())))), r114.doFinal(r113.getEncoded()));     // Catch: Exception -> L49
    L44:
        this.entries.put(r11, new ObjectData(SECRET_KEY, r11, r5, r0, r115.getEncoded(), null));     // Catch: Exception -> L49
        goto L45
    L43:
        r115 = new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(r3, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad))), createCipher("AESKWP", r111).doFinal(r113.getEncoded()));     // Catch: Exception -> L49
        goto L44
    L34:
        Map<String, ASN1ObjectIdentifier> r6 = oidMap;     // Catch: Exception -> L49
        ASN1ObjectIdentifier r7 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.get(r112), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L49
        if (r7 == null) goto L37;
        r113 = new SecretKeyData(r7, r110);     // Catch: Exception -> L49
        goto L41
    L37:
        ASN1ObjectIdentifier r4 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r6.get(r112 + "." + (r110.length * 8)), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L49
        if (r4 == null) goto L48;
        r113 = new SecretKeyData(r4, r110);     // Catch: Exception -> L49
        goto L41
    L48:
        throw new KeyStoreException("BCFKS KeyStore cannot recognize secret key (" + r112 + ") for storage.");     // Catch: Exception -> L49
    L49:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e.toString(), e);
    L53:
        throw new KeyStoreException("BCFKS KeyStore cannot store certificate chain with secret key.");
    L55:
        throw new KeyStoreException("BCFKS KeyStore unable to recognize key.");
    L5:
        r5 = r0;
        goto L6
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String r12, byte[] r13, Certificate[] r14) {
        Date r7 = new Date();
        ObjectData r0 = (ObjectData) ZeusTransformUtils.preCheckCast(this.entries.get(r12), ObjectData.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        Date r3 = extractCreationDate(r0, r7);
    L7:
        if (r14 == null) goto L25;
        EncryptedPrivateKeyInfo r15 = EncryptedPrivateKeyInfo.getInstance(r13);     // Catch: Exception -> L14
        this.privateKeyCache.remove(r12);     // Catch: Exception -> L11
        this.entries.put(r12, new ObjectData(PROTECTED_PRIVATE_KEY, r12, r3, r7, createPrivateKeySequence(r15, r14).getEncoded(), null));     // Catch: Exception -> L11
    L18:
        this.lastModifiedDate = r7;
        return;
    L11:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e.toString(), e);
    L14:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", e);
    L25:
        this.entries.put(r12, new ObjectData(PROTECTED_SECRET_KEY, r12, r3, r7, r13, null));     // Catch: Exception -> L20
    L20:
        e = move-exception;
        throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e.toString(), e);
    L5:
        r3 = r7;
        goto L7
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.entries.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream r6, char[] r7) {
        if (this.creationDate == null) goto L16;
        EncryptedObjectStoreData r0 = getEncryptedObjectStoreData(this.hmacAlgorithm, r7);
        if (MiscObjectIdentifiers.id_scrypt.equals(this.hmacPkbdAlgorithm.getAlgorithm()) == false) goto L7;
        ScryptParams r1 = ScryptParams.getInstance(this.hmacPkbdAlgorithm.getParameters());
        KeyDerivationFunc r2 = this.hmacPkbdAlgorithm;
        BigInteger r3 = r1.getKeyLength();
    L8:
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(r2, r3.intValue());
        r6.write(new ObjectStore(r0, new ObjectStoreIntegrityCheck(new PbkdMacIntegrityCheck(this.hmacAlgorithm, this.hmacPkbdAlgorithm, calculateMac(r0.getEncoded(), this.hmacAlgorithm, this.hmacPkbdAlgorithm, r7)))).getEncoded());
        r6.flush();
        return;
    L12:
        e = move-exception;
        throw new IOException("cannot calculate mac: " + e.getMessage());
    L7:
        PBKDF2Params r4 = PBKDF2Params.getInstance(this.hmacPkbdAlgorithm.getParameters());
        r2 = this.hmacPkbdAlgorithm;
        r3 = r4.getKeyLength();
        goto L8
    L16:
        throw new IOException("KeyStore not initialized");
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter r8) {
        KeyStore.LoadStoreParameter r9 = (KeyStore.LoadStoreParameter) ZeusTransformUtils.wrapperContextForParams(r8, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L48;
        if (ZeusTransformUtils.instanceOf(r9, BCFKSStoreParameter.class) == false) goto L8;
        BCFKSStoreParameter r0 = (BCFKSStoreParameter) ZeusTransformUtils.preCheckCast(r9, BCFKSStoreParameter.class, "com.obric.memorydata.plugin");
        char[] r10 = ParameterUtil.extractPassword(r9);
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(r0.getStorePBKDFConfig(), 64);
        engineStore(r0.getOutputStream(), r10);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r9, BCFKSLoadStoreParameter.class) == false) goto L42;
        BCFKSLoadStoreParameter r11 = (BCFKSLoadStoreParameter) ZeusTransformUtils.preCheckCast(r9, BCFKSLoadStoreParameter.class, "com.obric.memorydata.plugin");
        if (r11.getStoreSignatureKey() == null) goto L32;
        this.signatureAlgorithm = generateSignatureAlgId(r11.getStoreSignatureKey(), r11.getStoreSignatureAlgorithm());
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(r11.getStorePBKDFConfig(), 64);
        if (r11.getStoreEncryptionAlgorithm() != BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM) goto L14;
        ASN1ObjectIdentifier r1 = NISTObjectIdentifiers.id_aes256_CCM;
    L15:
        this.storeEncryptionAlgorithm = r1;
        if (r11.getStoreMacAlgorithm() != BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512) goto L18;
        AlgorithmIdentifier r2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
    L19:
        this.hmacAlgorithm = r2;
        EncryptedObjectStoreData r3 = getEncryptedObjectStoreData(this.signatureAlgorithm, ParameterUtil.extractPassword(r11));
        Signature r4 = this.helper.createSignature(this.signatureAlgorithm.getAlgorithm().getId());     // Catch: GeneralSecurityException -> L29
        r4.initSign((PrivateKey) ZeusTransformUtils.preCheckCast(r11.getStoreSignatureKey(), PrivateKey.class, "com.obric.memorydata.plugin"));     // Catch: GeneralSecurityException -> L29
        r4.update(r3.getEncoded());     // Catch: GeneralSecurityException -> L29
        X509Certificate[] r5 = r11.getStoreCertificates();     // Catch: GeneralSecurityException -> L29
        if (r5 == null) goto L26;
        int r6 = r5.length;     // Catch: GeneralSecurityException -> L29
        org.bouncycastle.asn1.x509.Certificate[] r7 = new org.bouncycastle.asn1.x509.Certificate[r6];     // Catch: GeneralSecurityException -> L29
        int r12 = 0;
    L23:
        if (r12 == r6) goto L25;
        r7[r12] = org.bouncycastle.asn1.x509.Certificate.getInstance(r5[r12].getEncoded());     // Catch: GeneralSecurityException -> L29
        r12 = r12 + 1;     // Catch: GeneralSecurityException -> L29
        goto L23
    L25:
        SignatureCheck r13 = new SignatureCheck(this.signatureAlgorithm, r7, r4.sign());     // Catch: GeneralSecurityException -> L29
    L27:
        r11.getOutputStream().write(new ObjectStore(r3, new ObjectStoreIntegrityCheck(r13)).getEncoded());     // Catch: GeneralSecurityException -> L29
        r11.getOutputStream().flush();     // Catch: GeneralSecurityException -> L29
        return;
    L26:
        r13 = new SignatureCheck(this.signatureAlgorithm, r4.sign());     // Catch: GeneralSecurityException -> L29
    L29:
        e = move-exception;
        throw new IOException("error creating signature: " + e.getMessage(), e);
    L18:
        r2 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, DERNull.INSTANCE);
        goto L19
    L14:
        r1 = NISTObjectIdentifiers.id_aes256_wrap_pad;
        goto L15
    L32:
        char[] r14 = ParameterUtil.extractPassword(r11);
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(r11.getStorePBKDFConfig(), 64);
        if (r11.getStoreEncryptionAlgorithm() != BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM) goto L35;
        ASN1ObjectIdentifier r15 = NISTObjectIdentifiers.id_aes256_CCM;
    L36:
        this.storeEncryptionAlgorithm = r15;
        if (r11.getStoreMacAlgorithm() != BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512) goto L39;
        AlgorithmIdentifier r16 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
    L40:
        this.hmacAlgorithm = r16;
        engineStore(r11.getOutputStream(), r14);
        return;
    L39:
        r16 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, DERNull.INSTANCE);
        goto L40
    L35:
        r15 = NISTObjectIdentifiers.id_aes256_wrap_pad;
        goto L36
    L42:
        if (ZeusTransformUtils.instanceOf(r9, BCLoadStoreParameter.class) == false) goto L46;
        engineStore(((BCLoadStoreParameter) ZeusTransformUtils.preCheckCast(r9, BCLoadStoreParameter.class, "com.obric.memorydata.plugin")).getOutputStream(), ParameterUtil.extractPassword(r9));
        return;
    L46:
        throw new IllegalArgumentException("no support for 'parameter' of type " + r9.getClass().getName());
    L48:
        throw new IllegalArgumentException("'parameter' arg cannot be null");
    }
}
