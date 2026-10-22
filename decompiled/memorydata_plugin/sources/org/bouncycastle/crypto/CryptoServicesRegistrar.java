package org.bouncycastle.crypto;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.Permission;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes7.dex */
public final class CryptoServicesRegistrar {
    private static final Permission CanSetConstraints = null;
    private static final Permission CanSetDefaultProperty = null;
    private static final Permission CanSetDefaultRandom = null;
    private static final Permission CanSetThreadProperty = null;
    private static final Logger LOG = null;
    private static final SecureRandomProvider defaultRandomProviderImpl = null;
    private static final AtomicReference<SecureRandomProvider> defaultSecureRandomProvider = null;
    private static final Map<String, Object[]> globalProperties = null;
    private static final CryptoServicesConstraints noConstraintsImpl = null;
    private static final boolean preconfiguredConstraints = false;
    private static final AtomicReference<CryptoServicesConstraints> servicesConstraints = null;
    private static final ThreadLocal<Map<String, Object[]>> threadProperties = null;

    public static final class Property {
        public static final Property DH_DEFAULT_PARAMS = null;
        public static final Property DSA_DEFAULT_PARAMS = null;
        public static final Property EC_IMPLICITLY_CA = null;
        private final String name;
        private final Class type;

        static {
            EC_IMPLICITLY_CA = new Property("ecImplicitlyCA", X9ECParameters.class);
            DH_DEFAULT_PARAMS = new Property("dhDefaultParams", DHParameters.class);
            DSA_DEFAULT_PARAMS = new Property("dsaDefaultParams", DSAParameters.class);
        }

        private Property(String r1, Class r2) {
            this.name = r1;
            this.type = r2;
        }

        static /* synthetic */ String access$000(Property r0) {
            return r0.name;
        }

        static /* synthetic */ Class access$100(Property r0) {
            return r0.type;
        }
    }

    static {
        LOG = Logger.getLogger(CryptoServicesRegistrar.class.getName());
        CanSetDefaultProperty = new CryptoServicesPermission(CryptoServicesPermission.GLOBAL_CONFIG);
        CanSetThreadProperty = new CryptoServicesPermission(CryptoServicesPermission.THREAD_LOCAL_CONFIG);
        CanSetDefaultRandom = new CryptoServicesPermission(CryptoServicesPermission.DEFAULT_RANDOM);
        CanSetConstraints = new CryptoServicesPermission(CryptoServicesPermission.CONSTRAINTS);
        threadProperties = new ThreadLocal();
        globalProperties = Collections.synchronizedMap(new HashMap());
        defaultRandomProviderImpl = new AnonymousClass1();
        CryptoServicesConstraints r0 = new AnonymousClass2();
        noConstraintsImpl = r0;
        defaultSecureRandomProvider = new AtomicReference();
        AtomicReference<CryptoServicesConstraints> r1 = new AtomicReference();
        servicesConstraints = r1;
        DSAParameters r2 = new DSAParameters(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new DSAValidationParameters(Hex.decodeStrict("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
        DSAParameters r3 = new DSAParameters(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new DSAValidationParameters(Hex.decodeStrict("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
        DSAParameters r4 = new DSAParameters(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new DSAValidationParameters(Hex.decodeStrict("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
        DSAParameters r6 = new DSAParameters(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new DSAValidationParameters(Hex.decodeStrict("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
        boolean r9 = false;
        localSetGlobalProperty(Property.DSA_DEFAULT_PARAMS, new DSAParameters[]{r2, r3, r4, r6});
        localSetGlobalProperty(Property.DH_DEFAULT_PARAMS, new DHParameters[]{toDH(r2), toDH(r3), toDH(r4), toDH(r6)});
        r1.set(getDefaultConstraints());
        if (r1.get() == r0) goto L5;
        r9 = true;
    L5:
        preconfiguredConstraints = r9;
    }

    private CryptoServicesRegistrar() {
    }

    public static void checkConstraints(CryptoServiceProperties r3) {
        CryptoServiceProperties r4 = (CryptoServiceProperties) ZeusTransformUtils.wrapperContextForParams(r3, CryptoServiceProperties.class, "com.obric.memorydata.plugin");
        ((CryptoServicesConstraints) ZeusTransformUtils.preCheckCast(servicesConstraints.get(), CryptoServicesConstraints.class, "com.obric.memorydata.plugin")).check(r4);
    }

    private static int chooseLowerBound(int r1) {
        if (r1 > 1024) goto L5;
        return 160;
    L5:
        if (r1 > 2048) goto L8;
        return 224;
    L8:
        if (r1 > 3072) goto L11;
        return 256;
    L11:
        if (r1 > 7680) goto L13;
        return 384;
    L13:
        return 512;
    }

    private static CryptoServicesConstraints getDefaultConstraints() {
        return noConstraintsImpl;
    }

    public static SecureRandom getSecureRandom() {
        AtomicReference<SecureRandomProvider> r0 = defaultSecureRandomProvider;
        r0.compareAndSet(null, defaultRandomProviderImpl);
        return ((SecureRandomProvider) ZeusTransformUtils.preCheckCast(r0.get(), SecureRandomProvider.class, "com.obric.memorydata.plugin")).get();
    }

    public static SecureRandom getSecureRandom(SecureRandom r0) {
        if (r0 == null) goto L4;
        return r0;
    L4:
        return getSecureRandom();
    }

    private static <T> void localSetGlobalProperty(Property r2, T... r3) {
        if (Property.access$100(r2).isAssignableFrom(r3[0].getClass()) == false) goto L7;
        localSetThread(r2, r3);
        globalProperties.put(Property.access$000(r2), r3);
        return;
    L7:
        throw new IllegalArgumentException("Bad property value passed");
    }

    private static <T> void localSetThread(Property r4, T[] r5) {
        ThreadLocal<Map<String, Object[]>> r0 = threadProperties;
        Map<String, Object[]> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new HashMap();
        r0.set(r1);
    L5:
        r1.put(Property.access$000(r4), r5);
    }

    private static DHParameters toDH(DSAParameters r9) {
        int r5 = chooseLowerBound(r9.getP().bitLength());
        return new DHParameters(r9.getP(), r9.getG(), r9.getQ(), r5, 0, null, new DHValidationParameters(r9.getValidationParameters().getSeed(), r9.getValidationParameters().getCounter()));
    }
}
