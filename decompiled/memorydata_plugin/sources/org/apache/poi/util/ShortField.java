package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class ShortField {
    private final int _offset;
    private short _value;

    public ShortField(int r3) {
        if (r3 < 0) goto L7;
        this._offset = r3;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + r3);
    }

    public ShortField(int r1, short r2, byte[] r3) {
        this(r1);
        set(r2, r3);
    }

    public ShortField(int r1, byte[] r2) {
        this(r1);
        readFromBytes(r2);
    }

    public short get() {
        return this._value;
    }

    public void readFromBytes(byte[] r2) {
        this._value = LittleEndian.getShort(r2, this._offset);
    }

    public void set(short r1, byte[] r2) {
        this._value = r1;
        writeToBytes(r2);
    }

    public String toString() {
        return String.valueOf(this._value);
    }

    public void writeToBytes(byte[] r2) {
        LittleEndian.putShort(r2, this._offset, this._value);
    }
}
