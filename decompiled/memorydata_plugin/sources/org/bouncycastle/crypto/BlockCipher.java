package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean r1, CipherParameters r2);

    int processBlock(byte[] r1, int r2, byte[] r3, int r4);
}
