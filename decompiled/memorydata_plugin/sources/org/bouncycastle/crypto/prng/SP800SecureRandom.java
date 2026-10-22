package org.bouncycastle.crypto.prng;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

/* JADX INFO: loaded from: classes7.dex */
public class SP800SecureRandom extends SecureRandom {
    private SP80090DRBG drbg;
    private final DRBGProvider drbgProvider;
    private final EntropySource entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    SP800SecureRandom(SecureRandom r3, EntropySource r4, DRBGProvider r5, boolean r6) {
        EntropySource r7 = (EntropySource) ZeusTransformUtils.wrapperContextForParams(r4, EntropySource.class, "com.obric.memorydata.plugin");
        DRBGProvider r8 = (DRBGProvider) ZeusTransformUtils.wrapperContextForParams(r5, DRBGProvider.class, "com.obric.memorydata.plugin");
        this.randomSource = r3;
        this.entropySource = r7;
        this.drbgProvider = r8;
        this.predictionResistant = r6;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r1) {
        return EntropyUtil.generateSeed(this.entropySource, r1);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg != null) goto L7;
        this.drbg = this.drbgProvider.get(this.entropySource);     // Catch: Throwable -> L11
    L7:
        if (this.drbg.generate(r4, null, this.predictionResistant) >= 0) goto L9;
        this.drbg.reseed(null);     // Catch: Throwable -> L11
        this.drbg.generate(r4, null, this.predictionResistant);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    public void reseed(byte[] r3) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg != null) goto L6;
        this.drbg = this.drbgProvider.get(this.entropySource);     // Catch: Throwable -> L9
    L6:
        this.drbg.reseed(r3);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long r2) {
        monitor-enter(this);
        SecureRandom r0 = this.randomSource;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.setSeed(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] r2) {
        monitor-enter(this);
        SecureRandom r0 = this.randomSource;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.setSeed(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
