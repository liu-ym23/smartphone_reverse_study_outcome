package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class HashCode$IntHashCode extends j implements Serializable {
    private static final long serialVersionUID = 0;
    final int hash;

    public HashCode$IntHashCode(int r5) {
        this.hash = r5;
    }

    @Override // com.google.common.hash.j
    public byte[] asBytes() {
        int r5 = this.hash;
        return new byte[]{(byte) r5, (byte) (r5 >> 8), (byte) (r5 >> 16), (byte) (r5 >> 24)};
    }

    @Override // com.google.common.hash.j
    public int asInt() {
        return this.hash;
    }

    @Override // com.google.common.hash.j
    public long asLong() {
        throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }

    @Override // com.google.common.hash.j
    public int bits() {
        return 32;
    }

    @Override // com.google.common.hash.j
    public boolean equalsSameBits(j r5) {
        if (this.hash != r5.asInt()) goto L5;
        return true;
    L5:
        return false;
    }

    public long padToLong() {
        return ((long) this.hash) & 4294967295L;
    }

    @Override // com.google.common.hash.j
    public void writeBytesToImpl(byte[] r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5[r10 + r12] = (byte) (this.hash >> (r12 * 8));
        r12 = r12 + 1;
        goto L3
    }
}
