package org.bouncycastle.pqc.jcajce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes7.dex */
public class BouncyCastlePQCProvider extends Provider implements ConfigurableProvider {
    private static final String[] ALGORITHMS = null;
    private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
    public static final ProviderConfiguration CONFIGURATION = null;
    public static String PROVIDER_NAME = "BCPQC";
    private static String info = "BouncyCastle Post-Quantum Security Provider v1.72";
    private static final Map keyInfoConverters = null;

    static {
        keyInfoConverters = new HashMap();
        ALGORITHMS = new String[]{"SPHINCS", "LMS", "NH", "XMSS", "SPHINCSPlus", "CMCE", "Frodo", "SABER", "Picnic", "NTRU", "Falcon", "Kyber", "Dilithium", "NTRUPrime", "BIKE", "HQC"};
    }

    public BouncyCastlePQCProvider() {
        super(PROVIDER_NAME, 1.72d, info);
        AccessController.doPrivileged(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(BouncyCastlePQCProvider r0) {
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

    public static PublicKey getPublicKey(SubjectPublicKeyInfo r1) {
        AsymmetricKeyInfoConverter r0 = getAsymmetricKeyInfoConverter(r1.getAlgorithm().getAlgorithm());
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.generatePublic(r1);
    }

    private void loadAlgorithms(String r5, String[] r6) {
        int r0 = 0;
    L4:
        if (r0 == r6.length) goto L13;
        Class r1 = loadClass(BouncyCastlePQCProvider.class, r5 + r6[r0] + "$Mappings");
        if (r1 == null) goto L12;
        ((AlgorithmProvider) ZeusTransformUtils.preCheckCast(r1.newInstance(), AlgorithmProvider.class, "com.obric.memorydata.plugin")).configure(this);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r5 + r6[r0] + "$Mappings : " + e);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    static Class loadClass(Class r1, final String r2) {
        ClassLoader r3 = r1.getClassLoader();     // Catch: ClassNotFoundException -> L8
        if (r3 == null) goto L7;
        return r3.loadClass(r2);
    L7:
        return (Class) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass2(r2)), Class.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    private void setup() {
        loadAlgorithms(ALGORITHM_PACKAGE, ALGORITHMS);
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
        if (containsKey(r3 + "." + r5) == false) goto L7;
        addAlgorithm(r3 + "." + r4, r5);
        addAlgorithm(r3 + ".OID." + r4, r5);
        return;
    L7:
        throw new IllegalStateException("primary key (" + r3 + "." + r5 + ") not found");
    }

    public void addAlgorithm(String r3, ASN1ObjectIdentifier r4, String r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        addAlgorithm(r3, r4, r5);
        addAttributes(r3 + "." + r4, r7);
        addAttributes(r3 + ".OID." + r4, r7);
    }

    public void addAttributes(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
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

    public void setParameter(String r1, Object r2) {
        ProviderConfiguration r0 = CONFIGURATION;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
