package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class HashCode$LongHashCode extends j implements Serializable {
    private static final long serialVersionUID = 0;
    final long hash;

    public HashCode$LongHashCode(long r5) {
        this.hash = r5;
    }

    @Override // com.google.common.hash.j
    public byte[] asBytes() {
        long r5 = this.hash;
        return new byte[]{(byte) r5, (byte) (r5 >> 8), (byte) (r5 >> 16), (byte) (r5 >> 24), (byte) (r5 >> 32), (byte) (r5 >> 40), (byte) (r5 >> 48), (byte) (r5 >> 56)};
    }

    @Override // com.google.common.hash.j
    public int asInt() {
        return (int) this.hash;
    }

    @Override // com.google.common.hash.j
    public long asLong() {
        return this.hash;
    }

    @Override // com.google.common.hash.j
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.j
    public boolean equalsSameBits(j r5) {
        if (this.hash != r5.asLong()) goto L5;
        return true;
    L5:
        return false;
    }

    public long padToLong() {
        return this.hash;
    }

    @Override // com.google.common.hash.j
    public void writeBytesToImpl(byte[] r10, int r11, int r12) {
        int r5 = 0;
    L3:
        if (r5 >= r12) goto L5;
        r10[r11 + r5] = (byte) (this.hash >> (r5 * 8));
        r5 = r5 + 1;
        goto L3
    }
}
