package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class ByteField {
    private final int _offset;
    private byte _value;

    public ByteField(int r2) {
        this(r2, (byte) 0);
    }

    public ByteField(int r1, byte r2) {
        if (r1 < 0) goto L7;
        this._offset = r1;
        set(r2);
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
    }

    public ByteField(int r1, byte[] r2) {
        this(r1);
        readFromBytes(r2);
    }

    public void readFromBytes(byte[] r2) {
        this._value = r2[this._offset];
    }

    public void set(byte r1) {
        this._value = r1;
    }

    public void set(byte r1, byte[] r2) {
        set(r1);
        writeToBytes(r2);
    }

    public String toString() {
        return String.valueOf(this._value);
    }

    public void writeToBytes(byte[] r2) {
        r2[this._offset] = this._value;
    }
}
