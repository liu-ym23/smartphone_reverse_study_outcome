package org.bouncycastle.crypto.prng;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.HashSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class SP800SecureRandomBuilder {
    private int entropyBitsRequired;
    private final EntropySourceProvider entropySourceProvider;
    private byte[] personalizationString;
    private final SecureRandom random;
    private int securityStrength;

    private static class HMacDRBGProvider implements DRBGProvider {
        private final Mac hMac;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HMacDRBGProvider(Mac r3, byte[] r4, byte[] r5, int r6) {
            this.hMac = (Mac) ZeusTransformUtils.wrapperContextForParams(r3, Mac.class, "com.obric.memorydata.plugin");
            this.nonce = r4;
            this.personalizationString = r5;
            this.securityStrength = r6;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource r7) {
            EntropySource r3 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r7, EntropySource.class, "com.obric.memorydata.plugin");
            return new HMacSP800DRBG(this.hMac, this.securityStrength, r3, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            if (ZeusTransformUtils.instanceOf(this.hMac, HMac.class) == false) goto L7;
            StringBuilder r0 = new StringBuilder().append("HMAC-DRBG-");
            String r3 = SP800SecureRandomBuilder.access$000(((HMac) ZeusTransformUtils.preCheckCast(this.hMac, HMac.class, "com.obric.memorydata.plugin")).getUnderlyingDigest());
        L6:
            return r0.append(r3).toString();
        L7:
            r0 = new StringBuilder().append("HMAC-DRBG-");
            r3 = this.hMac.getAlgorithmName();
            goto L6
        }
    }

    private static class HashDRBGProvider implements DRBGProvider {
        private final Digest digest;
        private final byte[] nonce;
        private final byte[] personalizationString;
        private final int securityStrength;

        public HashDRBGProvider(Digest r3, byte[] r4, byte[] r5, int r6) {
            this.digest = (Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin");
            this.nonce = r4;
            this.personalizationString = r5;
            this.securityStrength = r6;
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public SP80090DRBG get(EntropySource r7) {
            EntropySource r3 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r7, EntropySource.class, "com.obric.memorydata.plugin");
            return new HashSP800DRBG(this.digest, this.securityStrength, r3, this.personalizationString, this.nonce);
        }

        @Override // org.bouncycastle.crypto.prng.DRBGProvider
        public String getAlgorithm() {
            return "HASH-DRBG-" + SP800SecureRandomBuilder.access$000(this.digest);
        }
    }

    public SP800SecureRandomBuilder() {
        this(CryptoServicesRegistrar.getSecureRandom(), false);
    }

    public SP800SecureRandomBuilder(SecureRandom r2, boolean r3) {
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = r2;
        this.entropySourceProvider = new BasicEntropySourceProvider(r2, r3);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider r3) {
        EntropySourceProvider r4 = (EntropySourceProvider) ZeusTransformUtils.wrapperContextForParams(r3, EntropySourceProvider.class, "com.obric.memorydata.plugin");
        this.securityStrength = 256;
        this.entropyBitsRequired = 256;
        this.random = null;
        this.entropySourceProvider = r4;
    }

    static /* synthetic */ String access$000(Digest r2) {
        return getSimplifiedName((Digest) ZeusTransformUtils.wrapperContextForParams(r2, Digest.class, "com.obric.memorydata.plugin"));
    }

    private static String getSimplifiedName(Digest r3) {
        String r4 = ((Digest) ZeusTransformUtils.wrapperContextForParams(r3, Digest.class, "com.obric.memorydata.plugin")).getAlgorithmName();
        int r0 = r4.indexOf(45);
        if (r0 > 0) goto L5;
        return r4;
    L5:
        if (r4.startsWith("SHA3") == false) goto L7;
        return r4;
    L7:
        return r4.substring(0, r0) + r4.substring(r0 + 1);
    }

    public SP800SecureRandom buildHMAC(Mac r6, byte[] r7, boolean r8) {
        Mac r9 = (Mac) ZeusTransformUtils.wrapperContextForParams(r6, Mac.class, "com.obric.memorydata.plugin");
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HMacDRBGProvider(r9, r7, this.personalizationString, this.securityStrength), r8);
    }

    public SP800SecureRandom buildHash(Digest r6, byte[] r7, boolean r8) {
        Digest r9 = (Digest) ZeusTransformUtils.wrapperContextForParams(r6, Digest.class, "com.obric.memorydata.plugin");
        return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HashDRBGProvider(r9, r7, this.personalizationString, this.securityStrength), r8);
    }

    public SP800SecureRandomBuilder setPersonalizationString(byte[] r1) {
        this.personalizationString = Arrays.clone(r1);
        return this;
    }
}
