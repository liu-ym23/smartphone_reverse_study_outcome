package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FibRgW97AbstractType {

    @Deprecated
    protected short field_10_reserved10;

    @Deprecated
    protected short field_11_reserved11;

    @Deprecated
    protected short field_12_reserved12;

    @Deprecated
    protected short field_13_reserved13;
    protected short field_14_lidFE;

    @Deprecated
    protected short field_1_reserved1;

    @Deprecated
    protected short field_2_reserved2;

    @Deprecated
    protected short field_3_reserved3;

    @Deprecated
    protected short field_4_reserved4;

    @Deprecated
    protected short field_5_reserved5;

    @Deprecated
    protected short field_6_reserved6;

    @Deprecated
    protected short field_7_reserved7;

    @Deprecated
    protected short field_8_reserved8;

    @Deprecated
    protected short field_9_reserved9;

    public FibRgW97AbstractType() {
    }

    public static int getSize() {
        return 28;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_reserved1 = LittleEndian.getShort(r2, r3 + 0);
        this.field_2_reserved2 = LittleEndian.getShort(r2, r3 + 2);
        this.field_3_reserved3 = LittleEndian.getShort(r2, r3 + 4);
        this.field_4_reserved4 = LittleEndian.getShort(r2, r3 + 6);
        this.field_5_reserved5 = LittleEndian.getShort(r2, r3 + 8);
        this.field_6_reserved6 = LittleEndian.getShort(r2, r3 + 10);
        this.field_7_reserved7 = LittleEndian.getShort(r2, r3 + 12);
        this.field_8_reserved8 = LittleEndian.getShort(r2, r3 + 14);
        this.field_9_reserved9 = LittleEndian.getShort(r2, r3 + 16);
        this.field_10_reserved10 = LittleEndian.getShort(r2, r3 + 18);
        this.field_11_reserved11 = LittleEndian.getShort(r2, r3 + 20);
        this.field_12_reserved12 = LittleEndian.getShort(r2, r3 + 22);
        this.field_13_reserved13 = LittleEndian.getShort(r2, r3 + 24);
        this.field_14_lidFE = LittleEndian.getShort(r2, r3 + 26);
    }

    public short getLidFE() {
        return this.field_14_lidFE;
    }

    public short getReserved1() {
        return this.field_1_reserved1;
    }

    public short getReserved10() {
        return this.field_10_reserved10;
    }

    public short getReserved11() {
        return this.field_11_reserved11;
    }

    public short getReserved12() {
        return this.field_12_reserved12;
    }

    public short getReserved13() {
        return this.field_13_reserved13;
    }

    public short getReserved2() {
        return this.field_2_reserved2;
    }

    public short getReserved3() {
        return this.field_3_reserved3;
    }

    public short getReserved4() {
        return this.field_4_reserved4;
    }

    public short getReserved5() {
        return this.field_5_reserved5;
    }

    public short getReserved6() {
        return this.field_6_reserved6;
    }

    public short getReserved7() {
        return this.field_7_reserved7;
    }

    public short getReserved8() {
        return this.field_8_reserved8;
    }

    public short getReserved9() {
        return this.field_9_reserved9;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FibRgW97]\n");
        r0.append("    .reserved1            = ");
        r0.append(" (").append(getReserved1()).append(" )\n");
        r0.append("    .reserved2            = ");
        r0.append(" (").append(getReserved2()).append(" )\n");
        r0.append("    .reserved3            = ");
        r0.append(" (").append(getReserved3()).append(" )\n");
        r0.append("    .reserved4            = ");
        r0.append(" (").append(getReserved4()).append(" )\n");
        r0.append("    .reserved5            = ");
        r0.append(" (").append(getReserved5()).append(" )\n");
        r0.append("    .reserved6            = ");
        r0.append(" (").append(getReserved6()).append(" )\n");
        r0.append("    .reserved7            = ");
        r0.append(" (").append(getReserved7()).append(" )\n");
        r0.append("    .reserved8            = ");
        r0.append(" (").append(getReserved8()).append(" )\n");
        r0.append("    .reserved9            = ");
        r0.append(" (").append(getReserved9()).append(" )\n");
        r0.append("    .reserved10           = ");
        r0.append(" (").append(getReserved10()).append(" )\n");
        r0.append("    .reserved11           = ");
        r0.append(" (").append(getReserved11()).append(" )\n");
        r0.append("    .reserved12           = ");
        r0.append(" (").append(getReserved12()).append(" )\n");
        r0.append("    .reserved13           = ");
        r0.append(" (").append(getReserved13()).append(" )\n");
        r0.append("    .lidFE                = ");
        r0.append(" (").append(getLidFE()).append(" )\n");
        r0.append("[/FibRgW97]\n");
        return r0.toString();
    }
}
