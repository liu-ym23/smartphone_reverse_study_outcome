package org.apache.poi.util;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class LittleEndianByteArrayOutputStream extends OutputStream implements DelayableLittleEndianOutput {
    private final byte[] _buf;
    private final int _endIndex;
    private int _writeIndex;

    public LittleEndianByteArrayOutputStream(byte[] r2, int r3) {
        this(r2, r3, r2.length - r3);
    }

    public LittleEndianByteArrayOutputStream(byte[] r4, int r5, int r6) {
        if (r5 < 0) goto L14;
        if (r5 > r4.length) goto L14;
        this._buf = r4;
        this._writeIndex = r5;
        int r7 = r6 + r5;
        this._endIndex = r7;
        if (r7 < r5) goto L12;
        if (r7 > r4.length) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("calculated end index (" + r7 + ") is out of allowable range (" + this._writeIndex + ".." + r4.length + ")");
    L14:
        throw new IllegalArgumentException("Specified startOffset (" + r5 + ") is out of allowable range (0.." + r4.length + ")");
    }

    private void checkPosition(int r2) {
        if (r2 > (this._endIndex - this._writeIndex)) goto L6;
        return;
    L6:
        throw new RuntimeException("Buffer overrun");
    }

    @Override // org.apache.poi.util.DelayableLittleEndianOutput
    public LittleEndianOutput createDelayedOutput(int r4) {
        checkPosition(r4);
        LittleEndianByteArrayOutputStream r0 = new LittleEndianByteArrayOutputStream(this._buf, this._writeIndex, r4);
        this._writeIndex += r4;
        return r0;
    }

    public int getWriteIndex() {
        return this._writeIndex;
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        writeByte(r1);
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r5) {
        int r0 = r5.length;
        checkPosition(r0);
        System.arraycopy(r5, 0, this._buf, this._writeIndex, r0);
        this._writeIndex += r0;
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r3, int r4, int r5) {
        checkPosition(r5);
        System.arraycopy(r3, r4, this._buf, this._writeIndex, r5);
        this._writeIndex += r5;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int r4) {
        checkPosition(1);
        byte[] r0 = this._buf;
        int r1 = this._writeIndex;
        this._writeIndex = r1 + 1;
        r0[r1] = (byte) r4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double r1) {
        writeLong(Double.doubleToLongBits(r1));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int r5) {
        checkPosition(4);
        int r0 = this._writeIndex;
        byte[] r1 = this._buf;
        int r2 = r0 + 1;
        r1[r0] = (byte) ((r5 >>> 0) & 255);
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r5 >>> 8) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r5 >>> 16) & 255);
        r1[r4] = (byte) ((r5 >>> 24) & 255);
        this._writeIndex = r4 + 1;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long r3) {
        writeInt((int) (r3 >> 0));
        writeInt((int) (r3 >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int r5) {
        checkPosition(2);
        int r0 = this._writeIndex;
        byte[] r1 = this._buf;
        int r2 = r0 + 1;
        r1[r0] = (byte) ((r5 >>> 0) & 255);
        r1[r2] = (byte) ((r5 >>> 8) & 255);
        this._writeIndex = r2 + 1;
    }
}
