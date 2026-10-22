package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public interface DerivationFunction {
    int generateBytes(byte[] r1, int r2, int r3);

    void init(DerivationParameters r1);
}
