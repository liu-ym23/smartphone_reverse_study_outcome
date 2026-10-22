package org.apache.poi.util;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class LittleEndianInputStream extends FilterInputStream implements LittleEndianInput {
    private int markIndex;
    private int readIndex;

    public LittleEndianInputStream(InputStream r3) {
        if (r3.markSupported() == true) goto L6;
        r3 = new BufferedInputStream(r3, 8096);
    L6:
        super(r3);
        this.readIndex = 0;
        this.markIndex = -1;
    }

    private int _read(byte[] r4, int r5, int r6) {
        int r0 = r6;
    L3:
        if (r0 <= 0) goto L9;
        int r1 = read(r4, (r6 - r0) + r5, r0);
        if ((-1) == r1) goto L9;
        r0 = r0 - r1;
    L9:
        return r6 - r0;
    }

    private static void checkEOF(int r1, int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        if (r1 == (-1)) goto L8;
        if (r1 != r2) goto L8;
        return;
    L8:
        throw new RuntimeException("Unexpected end-of-file");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return super.available();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        monitor-enter(this);
        super.mark(r1);     // Catch: Throwable -> L6
        this.markIndex = this.readIndex;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r1, int r2, int r3) {
        int r4 = super.read(r1, r2, r3);
        this.readIndex += Math.max(0, r4);
        return r4;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return (byte) readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r3) {
        readFully(r3, 0, r3.length);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r1, int r2, int r3) {
        checkEOF(_read(r1, r2, r3), r3);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        byte[] r1 = new byte[4];
        checkEOF(read(r1), 4);     // Catch: IOException -> L6
        return LittleEndian.getInt(r1);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        byte[] r1 = new byte[8];
        checkEOF(read(r1), 8);     // Catch: IOException -> L6
        return LittleEndian.getLong(r1);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void readPlain(byte[] r1, int r2, int r3) {
        readFully(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return (short) readUShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        byte[] r1 = new byte[1];
        checkEOF(read(r1), 1);     // Catch: IOException -> L6
        return LittleEndian.getUByte(r1);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        byte[] r1 = new byte[2];
        checkEOF(read(r1), 2);     // Catch: IOException -> L6
        return LittleEndian.getUShort(r1);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L8
        int r0 = this.markIndex;     // Catch: Throwable -> L8
        if (r0 <= (-1)) goto L6;
        this.readIndex = r0;     // Catch: Throwable -> L8
        this.markIndex = -1;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void skipFully(int r5) {
        if (r5 != 0) goto L4;
        return;
    L4:
        long r0 = IOUtils.skipFully(this, r5);
        if (r0 > 2147483647L) goto L9;
        checkEOF((int) r0, r5);
        return;
    L9:
        throw new IOException("can't skip further than 2147483647");
    }
}
