package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public interface Digest {
    int doFinal(byte[] r1, int r2);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte r1);

    void update(byte[] r1, int r2, int r3);
}
