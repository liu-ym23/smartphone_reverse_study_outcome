package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StshifAbstractType {
    private static final BitField fHasOriginalStyle = null;
    private static final BitField fReserved = null;
    protected int field_1_cstd;
    protected int field_2_cbSTDBaseInFile;
    protected int field_3_info3;
    protected int field_4_stiMaxWhenSaved;
    protected int field_5_istdMaxFixedWhenSaved;
    protected int field_6_nVerBuiltInNamesWhenSaved;
    protected short field_7_ftcAsci;
    protected short field_8_ftcFE;
    protected short field_9_ftcOther;

    static {
        fHasOriginalStyle = new BitField(1);
        fReserved = new BitField(65534);
    }

    public StshifAbstractType() {
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_cstd = LittleEndian.getShort(r2, r3 + 0);
        this.field_2_cbSTDBaseInFile = LittleEndian.getShort(r2, r3 + 2);
        this.field_3_info3 = LittleEndian.getShort(r2, r3 + 4);
        this.field_4_stiMaxWhenSaved = LittleEndian.getShort(r2, r3 + 6);
        this.field_5_istdMaxFixedWhenSaved = LittleEndian.getShort(r2, r3 + 8);
        this.field_6_nVerBuiltInNamesWhenSaved = LittleEndian.getShort(r2, r3 + 10);
        this.field_7_ftcAsci = LittleEndian.getShort(r2, r3 + 12);
        this.field_8_ftcFE = LittleEndian.getShort(r2, r3 + 14);
        this.field_9_ftcOther = LittleEndian.getShort(r2, r3 + 16);
    }

    public int getCbSTDBaseInFile() {
        return this.field_2_cbSTDBaseInFile;
    }

    public int getCstd() {
        return this.field_1_cstd;
    }

    public short getFReserved() {
        return (short) fReserved.getValue(this.field_3_info3);
    }

    public short getFtcAsci() {
        return this.field_7_ftcAsci;
    }

    public short getFtcFE() {
        return this.field_8_ftcFE;
    }

    public short getFtcOther() {
        return this.field_9_ftcOther;
    }

    public int getInfo3() {
        return this.field_3_info3;
    }

    public int getIstdMaxFixedWhenSaved() {
        return this.field_5_istdMaxFixedWhenSaved;
    }

    public int getNVerBuiltInNamesWhenSaved() {
        return this.field_6_nVerBuiltInNamesWhenSaved;
    }

    public int getStiMaxWhenSaved() {
        return this.field_4_stiMaxWhenSaved;
    }

    public boolean isFHasOriginalStyle() {
        return fHasOriginalStyle.isSet(this.field_3_info3);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[Stshif]\n");
        r0.append("    .cstd                 = ");
        r0.append(" (").append(getCstd()).append(" )\n");
        r0.append("    .cbSTDBaseInFile      = ");
        r0.append(" (").append(getCbSTDBaseInFile()).append(" )\n");
        r0.append("    .info3                = ");
        r0.append(" (").append(getInfo3()).append(" )\n");
        r0.append("         .fHasOriginalStyle        = ").append(isFHasOriginalStyle()).append('\n');
        r0.append("         .fReserved                = ").append(getFReserved()).append('\n');
        r0.append("    .stiMaxWhenSaved      = ");
        r0.append(" (").append(getStiMaxWhenSaved()).append(" )\n");
        r0.append("    .istdMaxFixedWhenSaved = ");
        r0.append(" (").append(getIstdMaxFixedWhenSaved()).append(" )\n");
        r0.append("    .nVerBuiltInNamesWhenSaved = ");
        r0.append(" (").append(getNVerBuiltInNamesWhenSaved()).append(" )\n");
        r0.append("    .ftcAsci              = ");
        r0.append(" (").append(getFtcAsci()).append(" )\n");
        r0.append("    .ftcFE                = ");
        r0.append(" (").append(getFtcFE()).append(" )\n");
        r0.append("    .ftcOther             = ");
        r0.append(" (").append(getFtcOther()).append(" )\n");
        r0.append("[/Stshif]\n");
        return r0.toString();
    }
}
