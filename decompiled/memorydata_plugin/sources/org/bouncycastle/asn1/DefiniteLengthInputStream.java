package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = null;
    private final int _originalLength;
    private int _remaining;

    static {
        EMPTY_BYTES = new byte[0];
    }

    DefiniteLengthInputStream(InputStream r1, int r2, int r3) {
        super(r1, r3);
        if (r2 > 0) goto L8;
        if (r2 < 0) goto L7;
        setParentEofDetect(true);
        goto L8
    L7:
        throw new IllegalArgumentException("negative lengths not allowed");
    L8:
        this._originalLength = r2;
        this._remaining = r2;
    }

    int getRemaining() {
        return this._remaining;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this._remaining != 0) goto L6;
        return -1;
    L6:
        int r0 = this._in.read();
        if (r0 < 0) goto L13;
        int r1 = this._remaining - 1;
        this._remaining = r1;
        if (r1 != 0) goto L11;
        setParentEofDetect(true);
    L11:
        return r0;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r0 = this._remaining;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r5 = this._in.read(r2, r3, Math.min(r4, r0));
        if (r5 < 0) goto L13;
        int r6 = this._remaining - r5;
        this._remaining = r6;
        if (r6 != 0) goto L11;
        setParentEofDetect(true);
    L11:
        return r5;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    void readAllIntoByteArray(byte[] r5) {
        int r0 = this._remaining;
        if (r0 != r5.length) goto L17;
        if (r0 != 0) goto L6;
        return;
    L6:
        int r1 = getLimit();
        int r2 = this._remaining;
        if (r2 >= r1) goto L15;
        int r3 = r2 - Streams.readFully(this._in, r5, 0, r5.length);
        this._remaining = r3;
        if (r3 != 0) goto L13;
        setParentEofDetect(true);
        return;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + r1);
    L17:
        throw new IllegalArgumentException("buffer length not right for data");
    }

    byte[] toByteArray() {
        if (this._remaining == 0) goto L5;
        int r0 = getLimit();
        int r1 = this._remaining;
        if (r1 >= r0) goto L15;
        byte[] r2 = new byte[r1];
        int r3 = r1 - Streams.readFully(this._in, r2, 0, r1);
        this._remaining = r3;
        if (r3 != 0) goto L13;
        setParentEofDetect(true);
        return r2;
    L13:
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    L15:
        throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + r0);
    L5:
        return EMPTY_BYTES;
    }
}
