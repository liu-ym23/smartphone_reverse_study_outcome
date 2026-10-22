package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes7.dex */
public abstract class DefaultMultiBlockCipher implements MultiBlockCipher {
    public DefaultMultiBlockCipher() {
    }

    @Override // org.bouncycastle.crypto.MultiBlockCipher
    public int getMultiBlockSize() {
        return getBlockSize();
    }
}
