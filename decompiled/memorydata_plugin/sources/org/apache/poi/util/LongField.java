package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class LongField {
    private final int _offset;
    private long _value;

    public LongField(int r3) {
        if (r3 < 0) goto L7;
        this._offset = r3;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + r3);
    }

    public LongField(int r1, long r2, byte[] r4) {
        this(r1);
        set(r2, r4);
    }

    public void set(long r1, byte[] r3) {
        this._value = r1;
        writeToBytes(r3);
    }

    public String toString() {
        return String.valueOf(this._value);
    }

    public void writeToBytes(byte[] r4) {
        LittleEndian.putLong(r4, this._offset, this._value);
    }
}
