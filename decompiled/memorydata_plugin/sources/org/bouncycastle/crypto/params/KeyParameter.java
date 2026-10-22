package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes7.dex */
public class KeyParameter implements CipherParameters {
    private byte[] key;

    public KeyParameter(byte[] r3) {
        this(r3, 0, r3.length);
    }

    public KeyParameter(byte[] r2, int r3, int r4) {
        byte[] r0 = new byte[r4];
        this.key = r0;
        System.arraycopy(r2, r3, r0, 0, r4);
    }

    public byte[] getKey() {
        return this.key;
    }
}
