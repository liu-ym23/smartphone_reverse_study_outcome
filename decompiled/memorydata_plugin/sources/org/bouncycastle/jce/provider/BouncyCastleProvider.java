package org.bouncycastle.jce.provider;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CryptoServiceConstraintsException;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.provider.falcon.FalconKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.picnic.PicnicKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.sphincsplus.SPHINCSPlusKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;

/* JADX INFO: loaded from: classes7.dex */
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    private static final String[] ASYMMETRIC_CIPHERS = null;
    private static final String[] ASYMMETRIC_GENERIC = null;
    private static final String ASYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.asymmetric.";
    public static final ProviderConfiguration CONFIGURATION = null;
    private static final String[] DIGESTS = null;
    private static final String DIGEST_PACKAGE = "org.bouncycastle.jcajce.provider.digest.";
    private static final String[] KEYSTORES = null;
    private static final String KEYSTORE_PACKAGE = "org.bouncycastle.jcajce.provider.keystore.";
    private static final Logger LOG = null;
    public static final String PROVIDER_NAME = "BC";
    private static final String[] SECURE_RANDOMS = null;
    private static final String SECURE_RANDOM_PACKAGE = "org.bouncycastle.jcajce.provider.drbg.";
    private static final CryptoServiceProperties[] SYMMETRIC_CIPHERS = null;
    private static final String[] SYMMETRIC_GENERIC = null;
    private static final String[] SYMMETRIC_MACS = null;
    private static final String SYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.symmetric.";
    private static String info;
    private static final Map keyInfoConverters = null;
    private static final Class revChkClass = null;

    private static class JcaCryptoService implements CryptoServiceProperties {
        private final int bitsOfSecurity;
        private final String name;

        JcaCryptoService(String r1, int r2) {
            this.name = r1;
            this.bitsOfSecurity = r2;
        }

        @Override // org.bouncycastle.crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.name;
        }
    }

    static {
        LOG = Logger.getLogger(BouncyCastleProvider.class.getName());
        info = "BouncyCastle Security Provider v1.72";
        CONFIGURATION = new BouncyCastleProviderConfiguration();
        keyInfoConverters = new HashMap();
        revChkClass = ClassUtil.loadClass(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");
        SYMMETRIC_GENERIC = new String[]{"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
        SYMMETRIC_MACS = new String[]{"SipHash", "SipHash128", "Poly1305"};
        SYMMETRIC_CIPHERS = new CryptoServiceProperties[]{service(CryptoConst.ALGORITHM_AES, 256), service("ARC4", 20), service("ARIA", 256), service("Blowfish", 128), service("Camellia", 256), service("CAST5", 128), service("CAST6", 256), service("ChaCha", 128), service("DES", 56), service("DESede", 112), service("GOST28147", 128), service("Grainv1", 128), service("Grain128", 128), service("HC128", 128), service("HC256", 256), service("IDEA", 128), service("Noekeon", 128), service("RC2", 128), service("RC5", 128), service("RC6", 256), service("Rijndael", 256), service("Salsa20", 128), service("SEED", 128), service("Serpent", 256), service("Shacal2", 128), service("Skipjack", 80), service("SM4", 128), service("TEA", 128), service("Twofish", 256), service("Threefish", 128), service("VMPC", 128), service("VMPCKSA3", 128), service("XTEA", 128), service("XSalsa20", 128), service("OpenSSLPBKDF", 128), service("DSTU7624", 256), service("GOST3412_2015", 256), service("Zuc", 128)};
        ASYMMETRIC_GENERIC = new String[]{"X509", "IES", "COMPOSITE", "EXTERNAL"};
        ASYMMETRIC_CIPHERS = new String[]{"DSA", "DH", CryptoConst.ALGORITHM_EC, "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC", "LMS", "SPHINCSPlus"};
        DIGESTS = new String[]{"GOST3411", "Keccak", "MD2", "MD4", CryptoConst.ALGORITHM_MD5, "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka", "Blake3"};
        KEYSTORES = new String[]{PROVIDER_NAME, "BCFKS", "PKCS12"};
        SECURE_RANDOMS = new String[]{"DRBG"};
    }

    public BouncyCastleProvider() {
        super(PROVIDER_NAME, 1.72d, info);
        AccessController.doPrivileged(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(BouncyCastleProvider r0) {
        r0.setup();
    }

    private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier r3) {
        Map r0 = keyInfoConverters;
        monitor-enter(r0);
        AsymmetricKeyInfoConverter r4 = (AsymmetricKeyInfoConverter) ZeusTransformUtils.preCheckCast(r0.get(r3), AsymmetricKeyInfoConverter.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo r1) {
        AsymmetricKeyInfoConverter r0 = getAsymmetricKeyInfoConverter(r1.getPrivateKeyAlgorithm().getAlgorithm());
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.generatePrivate(r1);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo r2) {
        if (r2.getAlgorithm().getAlgorithm().on(BCObjectIdentifiers.picnic_key) == true) goto L5;
        AsymmetricKeyInfoConverter r0 = getAsymmetricKeyInfoConverter(r2.getAlgorithm().getAlgorithm());
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.generatePublic(r2);
    L5:
        return new PicnicKeyFactorySpi().generatePublic(r2);
    }

    private void loadAlgorithms(String r3, String[] r4) {
        int r0 = 0;
    L4:
        if (r0 == r4.length) goto L6;
        loadServiceClass(r3, r4[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private void loadAlgorithms(String r6, CryptoServiceProperties[] r7) {
        int r0 = 0;
    L4:
        if (r0 == r7.length) goto L12;
        CryptoServiceProperties r1 = r7[r0];
        CryptoServicesRegistrar.checkConstraints(r1);     // Catch: CryptoServiceConstraintsException -> L8
        loadServiceClass(r6, r1.getServiceName());     // Catch: CryptoServiceConstraintsException -> L8
    L11:
        r0 = r0 + 1;
    L8:
        Logger r2 = LOG;
        if (r2.isLoggable(Level.FINE) == false) goto L11;
        r2.fine("service for " + r1.getServiceName() + " ignored due to constraints");
        goto L11
    }

    private void loadPQCKeys() {
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha_256, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha_512, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new Sphincs256KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.newHope, new NHKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcEliece, new McElieceKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.mcElieceCca2, new McElieceCCA2KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.rainbow, new RainbowKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_I, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.qTESLA_p_III, new QTESLAKeyFactorySpi());
        addKeyInfoConverter(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.picnic_key, new PicnicKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.falcon_512, new FalconKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.falcon_1024, new FalconKeyFactorySpi());
    }

    private void loadServiceClass(String r4, String r5) {
        Class r0 = ClassUtil.loadClass(BouncyCastleProvider.class, r4 + r5 + "$Mappings");
        if (r0 != null) goto L10;
        return;
    L10:
        ((AlgorithmProvider) ZeusTransformUtils.preCheckCast(r0.newInstance(), AlgorithmProvider.class, "com.obric.memorydata.plugin")).configure(this);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r4 + r5 + "$Mappings : " + e);
    }

    private static CryptoServiceProperties service(String r1, int r2) {
        return new JcaCryptoService(r1, r2);
    }

    private void setup() {
        loadAlgorithms(DIGEST_PACKAGE, DIGESTS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_GENERIC);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_MACS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_CIPHERS);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_GENERIC);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_CIPHERS);
        loadAlgorithms(KEYSTORE_PACKAGE, KEYSTORES);
        loadAlgorithms(SECURE_RANDOM_PACKAGE, SECURE_RANDOMS);
        loadPQCKeys();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class r0 = revChkClass;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (r0 == null) goto L5;
        String r1 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
        String r4 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
    L6:
        put("CertPathBuilder.RFC3280", r4);
        put("CertPathValidator.PKIX", r1);
        put("CertPathBuilder.PKIX", r4);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
        return;
    L5:
        r1 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        r4 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        goto L6
    }

    public void addAlgorithm(String r2, String r3) {
        if (containsKey(r2) == true) goto L7;
        put(r2, r3);
        return;
    L7:
        throw new IllegalStateException("duplicate provider key (" + r2 + ") found");
    }

    public void addAlgorithm(String r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        addAlgorithm(r3, r4);
        addAttributes(r3, r6);
    }

    public void addAlgorithm(String r3, ASN1ObjectIdentifier r4, String r5) {
        addAlgorithm(r3 + "." + r4, r5);
        addAlgorithm(r3 + ".OID." + r4, r5);
    }

    public void addAlgorithm(String r3, ASN1ObjectIdentifier r4, String r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        addAlgorithm(r3, r4, r5);
        addAttributes(r3 + "." + r4, r7);
        addAttributes(r3 + ".OID." + r4, r7);
    }

    public void addAttributes(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        put(r6 + " ImplementedIn", ExifInterface.TAG_SOFTWARE);
        Iterator r0 = r8.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        String r3 = r6 + " " + r2;
        if (containsKey(r3) == true) goto L9;
        put(r3, r8.get(r2));
        goto L4
    L9:
        throw new IllegalStateException("duplicate provider attribute key (" + r3 + ") found");
    }

    public void addKeyInfoConverter(ASN1ObjectIdentifier r2, AsymmetricKeyInfoConverter r3) {
        AsymmetricKeyInfoConverter r1 = (AsymmetricKeyInfoConverter) ZeusTransformUtils.wrapperContextForParams(r3, AsymmetricKeyInfoConverter.class, "com.obric.memorydata.plugin");
        Map r4 = keyInfoConverters;
        monitor-enter(r4);
        r4.put(r2, r1);     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier r2) {
        return (AsymmetricKeyInfoConverter) ZeusTransformUtils.preCheckCast(keyInfoConverters.get(r2), AsymmetricKeyInfoConverter.class, "com.obric.memorydata.plugin");
    }

    public boolean hasAlgorithm(String r4, String r5) {
        if (containsKey(r4 + "." + r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (containsKey("Alg.Alias." + r4 + "." + r5) == true) goto L8;
        return false;
    }

    public void setParameter(String r3, Object r4) {
        ProviderConfiguration r2 = CONFIGURATION;
        monitor-enter(r2);
        ((BouncyCastleProviderConfiguration) ZeusTransformUtils.preCheckCast(r2, BouncyCastleProviderConfiguration.class, "com.obric.memorydata.plugin")).setParameter(r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
