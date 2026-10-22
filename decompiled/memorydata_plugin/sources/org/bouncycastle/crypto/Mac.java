package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public interface Mac {
    int doFinal(byte[] r1, int r2);

    String getAlgorithmName();

    int getMacSize();

    void init(CipherParameters r1);

    void update(byte r1);

    void update(byte[] r1, int r2, int r3);
}
