package org.apache.poi.util;

/* JADX INFO: loaded from: classes7.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int r3) {
        this._mask = r3;
        int r0 = 0;
        if (r3 != 0) goto L5;
    L7:
        this._shift_count = r0;
        return;
    L5:
        if ((r3 & 1) != 0) goto L7;
        r0 = r0 + 1;
        r3 = r3 >> 1;
        goto L5
    }

    public int clear(int r1) {
        return (~this._mask) & r1;
    }

    public byte clearByte(byte r1) {
        return (byte) clear(r1);
    }

    public short clearShort(short r1) {
        return (short) clear(r1);
    }

    public int getMask() {
        return this._mask;
    }

    public int getRawValue(int r1) {
        return this._mask & r1;
    }

    public short getShortValue(short r1) {
        return (short) getValue(r1);
    }

    public int getValue(int r1) {
        return getRawValue(r1) >>> this._shift_count;
    }

    public boolean isAllSet(int r1) {
        int r0 = this._mask;
        if ((r1 & r0) != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSet(int r1) {
        if ((this._mask & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int set(int r1) {
        return this._mask | r1;
    }

    public int setBoolean(int r1, boolean r2) {
        if (r2 == false) goto L5;
        return set(r1);
    L5:
        return clear(r1);
    }

    public byte setByte(byte r1) {
        return (byte) set(r1);
    }

    public short setShort(short r1) {
        return (short) set(r1);
    }

    public short setShortBoolean(short r1, boolean r2) {
        if (r2 == false) goto L5;
        return setShort(r1);
    L5:
        return clearShort(r1);
    }

    public short setShortValue(short r1, short r2) {
        return (short) setValue(r1, r2);
    }

    public int setValue(int r3, int r4) {
        int r0 = this._mask;
        int r5 = r3 & (~r0);
        return ((r4 << this._shift_count) & r0) | r5;
    }
}
