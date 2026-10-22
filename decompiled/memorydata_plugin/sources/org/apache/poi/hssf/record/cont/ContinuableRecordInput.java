package org.apache.poi.hssf.record.cont;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class ContinuableRecordInput implements LittleEndianInput {
    private final RecordInputStream _in;

    public ContinuableRecordInput(RecordInputStream r1) {
        this._in = r1;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return this._in.available();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return this._in.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return this._in.readDouble();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r1) {
        this._in.readFully(r1);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] r1, int r2, int r3) {
        this._in.readFully(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        int r0 = this._in.readUByte();
        int r1 = this._in.readUByte();
        int r2 = this._in.readUByte();
        return (((this._in.readUByte() << 24) + (r2 << 16)) + (r1 << 8)) + r0;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        int r0 = this._in.readUByte();
        int r1 = this._in.readUByte();
        int r2 = this._in.readUByte();
        int r3 = this._in.readUByte();
        int r4 = this._in.readUByte();
        int r5 = this._in.readUByte();
        int r6 = this._in.readUByte();
        return (((((((((long) this._in.readUByte()) << 56) + (((long) r6) << 48)) + (((long) r5) << 40)) + (((long) r4) << 32)) + (((long) r3) << 24)) + (((long) r2) << 16)) + (((long) r1) << 8)) + ((long) r0);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] r1, int r2, int r3) {
        readFully(r1, r2, r3);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return this._in.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return this._in.readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        int r0 = readUByte();
        return (readUByte() << 8) + r0;
    }
}
