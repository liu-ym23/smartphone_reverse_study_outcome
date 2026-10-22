package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public class X931SecureRandom extends SecureRandom {
    private final X931RNG drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    X931SecureRandom(SecureRandom r1, X931RNG r2, boolean r3) {
        this.randomSource = r1;
        this.drbg = r2;
        this.predictionResistant = r3;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r1) {
        return EntropyUtil.generateSeed(this.drbg.getEntropySource(), r1);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.drbg.generate(r3, this.predictionResistant) >= 0) goto L6;
        this.drbg.reseed();     // Catch: Throwable -> L8
        this.drbg.generate(r3, this.predictionResistant);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
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
