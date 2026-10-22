package org.apache.poi.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class LittleEndianOutputStream extends FilterOutputStream implements LittleEndianOutput {
    public LittleEndianOutputStream(OutputStream r1) {
        super(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r1) {
        super.write(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r1, int r2, int r3) {
        super.write(r1, r2, r3);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int r1) {
        this.out.write(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double r1) {
        writeLong(Double.doubleToLongBits(r1));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int r5) {
        int r0 = (r5 >>> 24) & 255;
        int r1 = (r5 >>> 16) & 255;
        int r2 = (r5 >>> 8) & 255;
        int r6 = r5 & 255;
        this.out.write(r6);     // Catch: IOException -> L5
        this.out.write(r2);     // Catch: IOException -> L5
        this.out.write(r1);     // Catch: IOException -> L5
        this.out.write(r0);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long r2) {
        writeInt((int) r2);
        writeInt((int) (r2 >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int r3) {
        int r0 = (r3 >>> 8) & 255;
        int r4 = r3 & 255;
        this.out.write(r4);     // Catch: IOException -> L5
        this.out.write(r0);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
