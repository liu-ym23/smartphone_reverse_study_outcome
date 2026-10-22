package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public interface LittleEndianOutput {
    void write(byte[] r1);

    void write(byte[] r1, int r2, int r3);

    void writeByte(int r1);

    void writeDouble(double r1);

    void writeInt(int r1);

    void writeLong(long r1);

    void writeShort(int r1);
}
