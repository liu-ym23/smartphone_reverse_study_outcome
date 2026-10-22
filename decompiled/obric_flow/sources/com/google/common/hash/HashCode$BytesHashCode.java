package com.google.common.hash;

import java.io.Serializable;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class HashCode$BytesHashCode extends j implements Serializable {
    private static final long serialVersionUID = 0;
    final byte[] bytes;

    public HashCode$BytesHashCode(byte[] r5) {
        r5.getClass();
        this.bytes = r5;
    }

    @Override // com.google.common.hash.j
    public byte[] asBytes() {
        return (byte[]) this.bytes.clone();
    }

    @Override // com.google.common.hash.j
    public int asInt() {
        byte[] r5 = this.bytes;
        if (r5.length < 4) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.q(r5.length, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", r10);
        byte[] r11 = this.bytes;
        return ((r11[3] & UByte.MAX_VALUE) << 24) | (((r11[0] & UByte.MAX_VALUE) | ((r11[1] & UByte.MAX_VALUE) << 8)) | ((r11[2] & UByte.MAX_VALUE) << 16));
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.google.common.hash.j
    public long asLong() {
        byte[] r5 = this.bytes;
        if (r5.length < 8) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.q(r5.length, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", r10);
        return padToLong();
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.google.common.hash.j
    public int bits() {
        return this.bytes.length * 8;
    }

    @Override // com.google.common.hash.j
    public boolean equalsSameBits(j r10) {
        if (this.bytes.length == r10.getBytesInternal().length) goto L5;
        return false;
    L5:
        boolean r5 = true;
        int r11 = 0;
    L6:
        byte[] r12 = this.bytes;
        if (r11 >= r12.length) goto L13;
        if (r12[r11] != r10.getBytesInternal()[r11]) goto L11;
        boolean r13 = true;
    L12:
        r5 = r5 & r13;
        r11 = r11 + 1;
        goto L6
    L11:
        r13 = false;
        goto L12
    L13:
        return r5;
    }

    @Override // com.google.common.hash.j
    public byte[] getBytesInternal() {
        return this.bytes;
    }

    public long padToLong() {
        long r5 = this.bytes[0] & UByte.MAX_VALUE;
        int r10 = 1;
    L4:
        if (r10 >= Math.min(this.bytes.length, 8)) goto L6;
        r5 = r5 | ((((long) this.bytes[r10]) & 255) << (r10 * 8));
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    @Override // com.google.common.hash.j
    public void writeBytesToImpl(byte[] r5, int r10, int r11) {
        System.arraycopy(this.bytes, 0, r5, r10, r11);
    }
}
