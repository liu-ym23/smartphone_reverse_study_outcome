package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class IntegerField {
    private final int _offset;
    private int _value;

    public IntegerField(int r1) {
        if (r1 < 0) goto L7;
        this._offset = r1;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("negative offset");
    }

    public IntegerField(int r1, int r2, byte[] r3) {
        this(r1);
        set(r2, r3);
    }

    public IntegerField(int r1, byte[] r2) {
        this(r1);
        readFromBytes(r2);
    }

    public int get() {
        return this._value;
    }

    public void readFromBytes(byte[] r2) {
        this._value = LittleEndian.getInt(r2, this._offset);
    }

    public void set(int r1, byte[] r2) {
        this._value = r1;
        writeToBytes(r2);
    }

    public String toString() {
        return String.valueOf(this._value);
    }

    public void writeToBytes(byte[] r2) {
        LittleEndian.putInt(r2, this._offset, this._value);
    }
}
