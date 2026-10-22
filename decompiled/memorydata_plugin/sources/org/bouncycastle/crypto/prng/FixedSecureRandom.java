package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes7.dex */
public class FixedSecureRandom extends SecureRandom {
    private byte[] _data;
    private int _index;
    private int _intPad;

    public FixedSecureRandom(boolean r3, byte[] r4) {
        this(r3, new byte[][]{r4});
    }

    public FixedSecureRandom(boolean r4, byte[][] r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = 0;
    L4:
        if (r1 == r5.length) goto L9;
        r0.write(r5[r1]);     // Catch: IOException -> L7
        r1 = r1 + 1;
    L8:
        throw new IllegalArgumentException("can't save value array.");
    L9:
        byte[] r6 = r0.toByteArray();
        this._data = r6;
        if (r4 == false) goto L16;
        this._intPad = r6.length % 4;
        return;
    }

    public FixedSecureRandom(byte[] r3) {
        this(false, new byte[][]{r3});
    }

    public FixedSecureRandom(byte[][] r2) {
        this(false, r2);
    }

    private int nextValue() {
        byte[] r0 = this._data;
        int r1 = this._index;
        this._index = r1 + 1;
        return r0[r1] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int r1) {
        byte[] r2 = new byte[r1];
        nextBytes(r2);
        return r2;
    }

    public boolean isExhausted() {
        if (this._index != this._data.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] r5) {
        System.arraycopy(this._data, this._index, r5, 0, r5.length);
        this._index += r5.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int r0 = ((nextValue() << 24) | 0) | (nextValue() << 16);
        int r1 = this._intPad;
        if (r1 != 2) goto L5;
        this._intPad = r1 - 1;
    L6:
        int r2 = this._intPad;
        if (r2 != 1) goto L10;
        this._intPad = r2 - 1;
        return r0;
    L10:
        return r0 | nextValue();
    L5:
        r0 = r0 | (nextValue() << 8);
        goto L6
    }

    @Override // java.util.Random
    public long nextLong() {
        return ((((((((((long) nextValue()) << 56) | 0) | (((long) nextValue()) << 48)) | (((long) nextValue()) << 40)) | (((long) nextValue()) << 32)) | (((long) nextValue()) << 24)) | (((long) nextValue()) << 16)) | (((long) nextValue()) << 8)) | ((long) nextValue());
    }
}
