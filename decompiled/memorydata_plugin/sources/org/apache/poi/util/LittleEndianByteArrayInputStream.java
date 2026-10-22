package org.apache.poi.util;

import java.io.ByteArrayInputStream;
import kotlin.UShort;

/* JADX INFO: loaded from: classes7.dex */
public class LittleEndianByteArrayInputStream extends ByteArrayInputStream implements LittleEndianInput {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public LittleEndianByteArrayInputStream(byte[] r1) {
        super(r1);
    }

    public LittleEndianByteArrayInputStream(byte[] r2, int r3) {
        this(r2, r3, r2.length - r3);
    }

    public LittleEndianByteArrayInputStream(byte[] r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    public void checkPosition(int r4) {
        if (r4 > (this.count - this.pos)) goto L6;
        return;
    L6:
        throw new IllegalStateException("Buffer overrun, having " + this.count + " bytes in the stream and position is at " + this.pos + ", but trying to increment position by " + r4);
    }

    public int getReadIndex() {
        return this.pos;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        checkPosition(1);
        return (byte) read();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r3) {
        checkPosition(r3.length);
        read(r3, 0, r3.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r1, int r2, int r3) {
        checkPosition(r3);
        read(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        checkPosition(4);
        int r0 = LittleEndian.getInt(this.buf, this.pos);
        super.skip(4);
        return r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        checkPosition(8);
        long r0 = LittleEndian.getLong(this.buf, this.pos);
        super.skip(8);
        return r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r1, int r2, int r3) {
        readFully(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        checkPosition(2);
        short r0 = LittleEndian.getShort(this.buf, this.pos);
        super.skip(2);
        return r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return readByte() & 255;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return readShort() & UShort.MAX_VALUE;
    }
}
