package org.bouncycastle.crypto.prng.drbg;

/* JADX INFO: loaded from: classes7.dex */
public interface SP80090DRBG {
    int generate(byte[] r1, byte[] r2, boolean r3);

    void reseed(byte[] r1);
}
