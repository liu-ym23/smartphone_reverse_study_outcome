package org.bouncycastle.jcajce.provider.symmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

/* JADX INFO: loaded from: classes7.dex */
public interface PBE {

    public static class Util {
        private static PBEParametersGenerator makePBEGenerator(int r3, int r4) {
            if (r3 != 0) goto L5;
        L44:
            if (r4 == 0) goto L52;
            if (r4 == 1) goto L80;
            if (r4 != 5) goto L49;
            return new PKCS5S1ParametersGenerator(new MD2Digest());
        L49:
            throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
        L80:
            return new PKCS5S1ParametersGenerator(DigestFactory.createSHA1());
        L52:
            return new PKCS5S1ParametersGenerator(DigestFactory.createMD5());
        L5:
            if (r3 == 4) goto L44;
            if (r3 == 1) goto L26;
            if (r3 == 5) goto L26;
            if (r3 != 2) goto L63;
            switch(r4) {
                case 0: goto L62;
                case 1: goto L61;
                case 2: goto L60;
                case 3: goto L59;
                case 4: goto L58;
                case 5: goto L57;
                case 6: goto L56;
                case 7: goto L55;
                case 8: goto L54;
                case 9: goto L53;
                default: goto L14;
            };
        L14:
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        L53:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA512PRF());
        L54:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA384PRF());
        L55:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA224PRF());
        L56:
            return new PKCS12ParametersGenerator(new GOST3411Digest(CryptoServicePurpose.PRF));
        L57:
            return new PKCS12ParametersGenerator(new MD2Digest(CryptoServicePurpose.PRF));
        L58:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA256PRF());
        L59:
            return new PKCS12ParametersGenerator(new TigerDigest(CryptoServicePurpose.PRF));
        L60:
            return new PKCS12ParametersGenerator(new RIPEMD160Digest(CryptoServicePurpose.PRF));
        L61:
            return new PKCS12ParametersGenerator(DigestFactory.createSHA1PRF());
        L62:
            return new PKCS12ParametersGenerator(DigestFactory.createMD5PRF());
        L63:
            return new OpenSSLPBEParametersGenerator();
        L26:
            switch(r4) {
                case 0: goto L78;
                case 1: goto L77;
                case 2: goto L76;
                case 3: goto L75;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L66;
                case 13: goto L65;
                case 14: goto L64;
                default: goto L28;
            };
        L28:
            throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
        L64:
            return new PKCS5S2ParametersGenerator(new SM3Digest(CryptoServicePurpose.PRF));
        L65:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_512PRF());
        L66:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_384PRF());
        L67:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_256PRF());
        L68:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_224PRF());
        L69:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512PRF());
        L70:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA384PRF());
        L71:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA224PRF());
        L72:
            return new PKCS5S2ParametersGenerator(new GOST3411Digest(CryptoServicePurpose.PRF));
        L73:
            return new PKCS5S2ParametersGenerator(new MD2Digest(CryptoServicePurpose.PRF));
        L74:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA256PRF());
        L75:
            return new PKCS5S2ParametersGenerator(new TigerDigest(CryptoServicePurpose.PRF));
        L76:
            return new PKCS5S2ParametersGenerator(new RIPEMD160Digest(CryptoServicePurpose.PRF));
        L77:
            return new PKCS5S2ParametersGenerator(DigestFactory.createSHA1PRF());
        L78:
            return new PKCS5S2ParametersGenerator(DigestFactory.createMD5PRF());
        }

        public static CipherParameters makePBEParameters(BCPBEKey r4, AlgorithmParameterSpec r5, String r6) {
            AlgorithmParameterSpec r7 = (AlgorithmParameterSpec) ZeusTransformUtils.wrapperContextForParams(r5, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L21;
            if (ZeusTransformUtils.instanceOf(r7, PBEParameterSpec.class) == false) goto L21;
            PBEParameterSpec r8 = (PBEParameterSpec) ZeusTransformUtils.preCheckCast(r7, PBEParameterSpec.class, "com.obric.memorydata.plugin");
            PBEParametersGenerator r0 = makePBEGenerator(r4.getType(), r4.getDigest());
            byte[] r2 = r4.getEncoded();
            if (r4.shouldTryWrongPKCS12() == false) goto L9;
            r2 = new byte[2];
        L9:
            r0.init(r2, r8.getSalt(), r8.getIterationCount());
            if (r4.getIvSize() == 0) goto L12;
            CipherParameters r9 = r0.generateDerivedParameters(r4.getKeySize(), r4.getIvSize());
        L14:
            if (r6.startsWith("DES") == true) goto L16;
        L19:
            return r9;
        L16:
            if (ZeusTransformUtils.instanceOf(r9, ParametersWithIV.class) == false) goto L18;
            DESParameters.setOddParity(((KeyParameter) ZeusTransformUtils.preCheckCast(((ParametersWithIV) ZeusTransformUtils.preCheckCast(r9, ParametersWithIV.class, "com.obric.memorydata.plugin")).getParameters(), KeyParameter.class, "com.obric.memorydata.plugin")).getKey());
            goto L19
        L18:
            DESParameters.setOddParity(((KeyParameter) ZeusTransformUtils.preCheckCast(r9, KeyParameter.class, "com.obric.memorydata.plugin")).getKey());
            goto L19
        L12:
            r9 = r0.generateDerivedParameters(r4.getKeySize());
        L21:
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }
    }
}
