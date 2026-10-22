package org.apache.poi.hwpf.model.types;

import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PICFAbstractType {
    protected int field_10_padding2;
    protected short field_11_dxaGoal;
    protected short field_12_dyaGoal;
    protected int field_13_mx;
    protected int field_14_my;
    protected short field_15_dxaReserved1;
    protected short field_16_dyaReserved1;
    protected short field_17_dxaReserved2;
    protected short field_18_dyaReserved2;
    protected byte field_19_fReserved;
    protected int field_1_lcb;
    protected byte field_20_bpp;
    protected byte[] field_21_brcTop80;
    protected byte[] field_22_brcLeft80;
    protected byte[] field_23_brcBottom80;
    protected byte[] field_24_brcRight80;
    protected short field_25_dxaReserved3;
    protected short field_26_dyaReserved3;
    protected short field_27_cProps;
    protected int field_2_cbHeader;
    protected short field_3_mm;
    protected short field_4_xExt;
    protected short field_5_yExt;
    protected short field_6_swHMF;
    protected int field_7_grf;
    protected int field_8_padding;
    protected int field_9_mmPM;

    public PICFAbstractType() {
        this.field_21_brcTop80 = new byte[4];
        this.field_22_brcLeft80 = new byte[4];
        this.field_23_brcBottom80 = new byte[4];
        this.field_24_brcRight80 = new byte[4];
    }

    public static int getSize() {
        return 68;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_lcb = LittleEndian.getInt(r3, r4 + 0);
        this.field_2_cbHeader = LittleEndian.getShort(r3, r4 + 4);
        this.field_3_mm = LittleEndian.getShort(r3, r4 + 6);
        this.field_4_xExt = LittleEndian.getShort(r3, r4 + 8);
        this.field_5_yExt = LittleEndian.getShort(r3, r4 + 10);
        this.field_6_swHMF = LittleEndian.getShort(r3, r4 + 12);
        this.field_7_grf = LittleEndian.getInt(r3, r4 + 14);
        this.field_8_padding = LittleEndian.getInt(r3, r4 + 18);
        this.field_9_mmPM = LittleEndian.getShort(r3, r4 + 22);
        this.field_10_padding2 = LittleEndian.getInt(r3, r4 + 24);
        this.field_11_dxaGoal = LittleEndian.getShort(r3, r4 + 28);
        this.field_12_dyaGoal = LittleEndian.getShort(r3, r4 + 30);
        this.field_13_mx = LittleEndian.getShort(r3, r4 + 32);
        this.field_14_my = LittleEndian.getShort(r3, r4 + 34);
        this.field_15_dxaReserved1 = LittleEndian.getShort(r3, r4 + 36);
        this.field_16_dyaReserved1 = LittleEndian.getShort(r3, r4 + 38);
        this.field_17_dxaReserved2 = LittleEndian.getShort(r3, r4 + 40);
        this.field_18_dyaReserved2 = LittleEndian.getShort(r3, r4 + 42);
        this.field_19_fReserved = r3[r4 + 44];
        this.field_20_bpp = r3[r4 + 45];
        int r0 = r4 + 46;
        this.field_21_brcTop80 = Arrays.copyOfRange(r3, r0, r0 + 4);
        int r1 = r4 + 50;
        this.field_22_brcLeft80 = Arrays.copyOfRange(r3, r1, r1 + 4);
        int r2 = r4 + 54;
        this.field_23_brcBottom80 = Arrays.copyOfRange(r3, r2, r2 + 4);
        int r5 = r4 + 58;
        this.field_24_brcRight80 = Arrays.copyOfRange(r3, r5, r5 + 4);
        this.field_25_dxaReserved3 = LittleEndian.getShort(r3, r4 + 62);
        this.field_26_dyaReserved3 = LittleEndian.getShort(r3, r4 + 64);
        this.field_27_cProps = LittleEndian.getShort(r3, r4 + 66);
    }

    public byte getBpp() {
        return this.field_20_bpp;
    }

    public byte[] getBrcBottom80() {
        return this.field_23_brcBottom80;
    }

    public byte[] getBrcLeft80() {
        return this.field_22_brcLeft80;
    }

    public byte[] getBrcRight80() {
        return this.field_24_brcRight80;
    }

    public byte[] getBrcTop80() {
        return this.field_21_brcTop80;
    }

    public short getCProps() {
        return this.field_27_cProps;
    }

    public int getCbHeader() {
        return this.field_2_cbHeader;
    }

    public short getDxaGoal() {
        return this.field_11_dxaGoal;
    }

    public short getDxaReserved1() {
        return this.field_15_dxaReserved1;
    }

    public short getDxaReserved2() {
        return this.field_17_dxaReserved2;
    }

    public short getDxaReserved3() {
        return this.field_25_dxaReserved3;
    }

    public short getDyaGoal() {
        return this.field_12_dyaGoal;
    }

    public short getDyaReserved1() {
        return this.field_16_dyaReserved1;
    }

    public short getDyaReserved2() {
        return this.field_18_dyaReserved2;
    }

    public short getDyaReserved3() {
        return this.field_26_dyaReserved3;
    }

    public byte getFReserved() {
        return this.field_19_fReserved;
    }

    public int getGrf() {
        return this.field_7_grf;
    }

    public int getLcb() {
        return this.field_1_lcb;
    }

    public short getMm() {
        return this.field_3_mm;
    }

    public int getMmPM() {
        return this.field_9_mmPM;
    }

    public int getMx() {
        return this.field_13_mx;
    }

    public int getMy() {
        return this.field_14_my;
    }

    public int getPadding() {
        return this.field_8_padding;
    }

    public int getPadding2() {
        return this.field_10_padding2;
    }

    public short getSwHMF() {
        return this.field_6_swHMF;
    }

    public short getXExt() {
        return this.field_4_xExt;
    }

    public short getYExt() {
        return this.field_5_yExt;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[PICF]\n");
        r0.append("    .lcb                  = ");
        r0.append(" (").append(getLcb()).append(" )\n");
        r0.append("    .cbHeader             = ");
        r0.append(" (").append(getCbHeader()).append(" )\n");
        r0.append("    .mm                   = ");
        r0.append(" (").append(getMm()).append(" )\n");
        r0.append("    .xExt                 = ");
        r0.append(" (").append(getXExt()).append(" )\n");
        r0.append("    .yExt                 = ");
        r0.append(" (").append(getYExt()).append(" )\n");
        r0.append("    .swHMF                = ");
        r0.append(" (").append(getSwHMF()).append(" )\n");
        r0.append("    .grf                  = ");
        r0.append(" (").append(getGrf()).append(" )\n");
        r0.append("    .padding              = ");
        r0.append(" (").append(getPadding()).append(" )\n");
        r0.append("    .mmPM                 = ");
        r0.append(" (").append(getMmPM()).append(" )\n");
        r0.append("    .padding2             = ");
        r0.append(" (").append(getPadding2()).append(" )\n");
        r0.append("    .dxaGoal              = ");
        r0.append(" (").append(getDxaGoal()).append(" )\n");
        r0.append("    .dyaGoal              = ");
        r0.append(" (").append(getDyaGoal()).append(" )\n");
        r0.append("    .mx                   = ");
        r0.append(" (").append(getMx()).append(" )\n");
        r0.append("    .my                   = ");
        r0.append(" (").append(getMy()).append(" )\n");
        r0.append("    .dxaReserved1         = ");
        r0.append(" (").append(getDxaReserved1()).append(" )\n");
        r0.append("    .dyaReserved1         = ");
        r0.append(" (").append(getDyaReserved1()).append(" )\n");
        r0.append("    .dxaReserved2         = ");
        r0.append(" (").append(getDxaReserved2()).append(" )\n");
        r0.append("    .dyaReserved2         = ");
        r0.append(" (").append(getDyaReserved2()).append(" )\n");
        r0.append("    .fReserved            = ");
        r0.append(" (").append(getFReserved()).append(" )\n");
        r0.append("    .bpp                  = ");
        r0.append(" (").append(getBpp()).append(" )\n");
        r0.append("    .brcTop80             = ");
        r0.append(" (").append(Arrays.toString(getBrcTop80())).append(" )\n");
        r0.append("    .brcLeft80            = ");
        r0.append(" (").append(Arrays.toString(getBrcLeft80())).append(" )\n");
        r0.append("    .brcBottom80          = ");
        r0.append(" (").append(Arrays.toString(getBrcBottom80())).append(" )\n");
        r0.append("    .brcRight80           = ");
        r0.append(" (").append(Arrays.toString(getBrcRight80())).append(" )\n");
        r0.append("    .dxaReserved3         = ");
        r0.append(" (").append(getDxaReserved3()).append(" )\n");
        r0.append("    .dyaReserved3         = ");
        r0.append(" (").append(getDyaReserved3()).append(" )\n");
        r0.append("    .cProps               = ");
        r0.append(" (").append(getCProps()).append(" )\n");
        r0.append("[/PICF]\n");
        return r0.toString();
    }
}
