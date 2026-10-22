package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TBDAbstractType {
    private static final BitField jc = null;
    private static final BitField reserved = null;
    private static final BitField tlc = null;
    protected byte field_1_value;

    static {
        jc = new BitField(7);
        tlc = new BitField(56);
        reserved = new BitField(192);
    }

    public TBDAbstractType() {
    }

    public TBDAbstractType(TBDAbstractType r1) {
        this.field_1_value = r1.field_1_value;
    }

    public static int getSize() {
        return 1;
    }

    public void fillFields(byte[] r1, int r2) {
        this.field_1_value = r1[r2 + 0];
    }

    public byte getJc() {
        return (byte) jc.getValue(this.field_1_value);
    }

    public byte getReserved() {
        return (byte) reserved.getValue(this.field_1_value);
    }

    public byte getTlc() {
        return (byte) tlc.getValue(this.field_1_value);
    }

    public byte getValue() {
        return this.field_1_value;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[TBD]\n");
        r0.append("    .value                = ");
        r0.append(" (").append(getValue()).append(" )\n");
        r0.append("         .jc                       = ").append(getJc()).append('\n');
        r0.append("         .tlc                      = ").append(getTlc()).append('\n');
        r0.append("         .reserved                 = ").append(getReserved()).append('\n');
        r0.append("[/TBD]\n");
        return r0.toString();
    }
}
