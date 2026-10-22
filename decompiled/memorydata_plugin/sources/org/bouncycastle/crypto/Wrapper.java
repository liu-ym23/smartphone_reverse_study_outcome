package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public interface Wrapper {
    String getAlgorithmName();

    void init(boolean r1, CipherParameters r2);

    byte[] unwrap(byte[] r1, int r2, int r3);

    byte[] wrap(byte[] r1, int r2, int r3);
}
