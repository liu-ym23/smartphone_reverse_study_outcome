package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public interface LittleEndianInput {
    int available();

    byte readByte();

    double readDouble();

    void readFully(byte[] r1);

    void readFully(byte[] r1, int r2, int r3);

    int readInt();

    long readLong();

    void readPlain(byte[] r1, int r2, int r3);

    short readShort();

    int readUByte();

    int readUShort();
}
