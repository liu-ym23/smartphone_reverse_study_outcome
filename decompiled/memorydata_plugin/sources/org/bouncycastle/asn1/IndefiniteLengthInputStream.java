package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    IndefiniteLengthInputStream(InputStream r1, int r2) {
        super(r1, r2);
        this._eofReached = false;
        this._eofOn00 = true;
        this._b1 = r1.read();
        int r3 = r1.read();
        this._b2 = r3;
        if (r3 < 0) goto L7;
        checkForEof();
        return;
    L7:
        throw new EOFException();
    }

    private boolean checkForEof() {
        if (this._eofReached == true) goto L12;
        if (this._eofOn00 == false) goto L12;
        if (this._b1 != 0) goto L12;
        if (this._b2 != 0) goto L12;
        this._eofReached = true;
        setParentEofDetect(true);
    L12:
        return this._eofReached;
    }

    @Override // java.io.InputStream
    public int read() {
        if (checkForEof() == false) goto L6;
        return -1;
    L6:
        int r0 = this._in.read();
        if (r0 < 0) goto L11;
        int r1 = this._b1;
        this._b1 = this._b2;
        this._b2 = r0;
        return r1;
    L11:
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (this._eofOn00 == true) goto L22;
        if (r5 < 3) goto L22;
        if (this._eofReached == false) goto L11;
        return -1;
    L11:
        int r6 = this._in.read(r3, r4 + 2, r5 - 2);
        if (r6 < 0) goto L20;
        r3[r4] = (byte) this._b1;
        r3[r4 + 1] = (byte) this._b2;
        this._b1 = this._in.read();
        int r7 = this._in.read();
        this._b2 = r7;
        if (r7 < 0) goto L18;
        return r6 + 2;
    L18:
        throw new EOFException();
    L20:
        throw new EOFException();
    L22:
        return super.read(r3, r4, r5);
    }

    void setEofOn00(boolean r1) {
        this._eofOn00 = r1;
        checkForEof();
    }
}
