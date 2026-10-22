package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes7.dex */
public interface EntropySource {
    int entropySize();

    byte[] getEntropy();
}
