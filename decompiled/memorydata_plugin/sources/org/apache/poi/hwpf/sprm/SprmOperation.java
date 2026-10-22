package org.apache.poi.hwpf.sprm;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.UShort;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SprmOperation {
    private static final BitField BITFIELD_OP = null;
    private static final BitField BITFIELD_SIZECODE = null;
    private static final BitField BITFIELD_SPECIAL = null;
    private static final BitField BITFIELD_TYPE = null;
    private int _gOffset;
    private final byte[] _grpprl;
    private final int _offset;
    private final int _size;
    private final short _value;

    static {
        BITFIELD_OP = BitFieldFactory.getInstance(FrameMetricsAggregator.EVERY_DURATION);
        BITFIELD_SIZECODE = BitFieldFactory.getInstance(57344);
        BITFIELD_SPECIAL = BitFieldFactory.getInstance(512);
        BITFIELD_TYPE = BitFieldFactory.getInstance(7168);
    }

    public SprmOperation(byte[] r1, int r2) {
        this._grpprl = r1;
        short r3 = LittleEndian.getShort(r1, r2);
        this._value = r3;
        this._offset = r2;
        this._gOffset = r2 + 2;
        this._size = initSize(r3);
    }

    private int initSize(short r4) {
        switch(getSizeCode()) {
            case 0: goto L21;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L8:
        int r0 = this._gOffset;
        if (r4 != (-10744)) goto L11;
    L15:
        int r5 = (65535 & LittleEndian.getShort(this._grpprl, r0)) + 3;
        this._gOffset += 2;
        return r5;
    L11:
        if (r4 == (-14827)) goto L15;
        byte[] r6 = this._grpprl;
        this._gOffset = r0 + 1;
        return (r6[r0] & 255) + 3;
    L17:
        return 6;
    L19:
        return 4;
    L21:
        return 3;
    L5:
        throw new IllegalArgumentException("SPRM contains an invalid size code");
    }

    public byte[] getGrpprl() {
        return this._grpprl;
    }

    public int getGrpprlOffset() {
        return this._gOffset;
    }

    public int getOperand() {
        switch(getSizeCode()) {
            case 0: goto L21;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        byte[] r1 = this._grpprl;
        int r8 = this._gOffset;
        return LittleEndian.getInt(new byte[]{r1[r8], r1[r8 + 1], r1[r8 + 2], 0}, 0);
    L8:
        byte r0 = this._grpprl[this._gOffset + 1];
        byte[] r2 = new byte[4];
        int r3 = 0;
    L9:
        if (r3 >= r0) goto L15;
        int r4 = this._gOffset;
        int r5 = r4 + r3;
        byte[] r6 = this._grpprl;
        if (r5 >= r6.length) goto L13;
        r2[r3] = r6[(r4 + 1) + r3];
    L13:
        r3 = r3 + 1;
        goto L9
    L15:
        return LittleEndian.getInt(r2, 0);
    L5:
        throw new IllegalArgumentException("SPRM contains an invalid size code");
    L17:
        return LittleEndian.getInt(this._grpprl, this._gOffset);
    L19:
        return LittleEndian.getShort(this._grpprl, this._gOffset);
    L21:
        return this._grpprl[this._gOffset];
    }

    public short getOperandShortSigned() {
        int r0 = getSizeCode();
        if (r0 == 2) goto L12;
        if (r0 == 4) goto L12;
        if (r0 == 5) goto L12;
        throw new UnsupportedOperationException("Current SPRM doesn't have signed short operand: " + this);
    L12:
        return LittleEndian.getShort(this._grpprl, this._gOffset);
    }

    public int getOperation() {
        return BITFIELD_OP.getValue(this._value);
    }

    public int getSizeCode() {
        return BITFIELD_SIZECODE.getValue(this._value);
    }

    public int getType() {
        return BITFIELD_TYPE.getValue(this._value);
    }

    public int size() {
        return this._size;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[SPRM] (0x");
        r0.append(Integer.toHexString(this._value & UShort.MAX_VALUE));
        r0.append("): ");
        r0.append(getOperand());     // Catch: Exception -> L5
    L7:
        return r0.toString();
    L5:
        r0.append("(error)");
        goto L7
    }
}
