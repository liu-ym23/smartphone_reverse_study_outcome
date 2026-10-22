package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.hwpf.model.Grfhic;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class LVLFAbstractType {
    private static final BitField fConverted = null;
    private static final BitField fIndentSav = null;
    private static final BitField fLegal = null;
    private static final BitField fNoRestart = null;
    private static final BitField fTentative = null;
    private static final BitField jc = null;
    private static final BitField unused1 = null;
    protected short field_10_ilvlRestartLim;
    protected Grfhic field_11_grfhic;
    protected int field_1_iStartAt;
    protected byte field_2_nfc;
    protected byte field_3_info;
    protected byte[] field_4_rgbxchNums;
    protected byte field_5_ixchFollow;
    protected int field_6_dxaIndentSav;
    protected int field_7_unused2;
    protected short field_8_cbGrpprlChpx;
    protected short field_9_cbGrpprlPapx;

    static {
        jc = new BitField(3);
        fLegal = new BitField(4);
        fNoRestart = new BitField(8);
        fIndentSav = new BitField(16);
        fConverted = new BitField(32);
        unused1 = new BitField(64);
        fTentative = new BitField(128);
    }

    public LVLFAbstractType() {
        this.field_4_rgbxchNums = new byte[9];
        this.field_11_grfhic = new Grfhic();
    }

    public static int getSize() {
        return 28;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        LVLFAbstractType r6 = (LVLFAbstractType) ZeusTransformUtils.preCheckCast(r5, LVLFAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_iStartAt == r6.field_1_iStartAt) goto L15;
        return false;
    L15:
        if (this.field_2_nfc == r6.field_2_nfc) goto L18;
        return false;
    L18:
        if (this.field_3_info == r6.field_3_info) goto L21;
        return false;
    L21:
        if (Arrays.equals(this.field_4_rgbxchNums, r6.field_4_rgbxchNums) == true) goto L24;
        return false;
    L24:
        if (this.field_5_ixchFollow == r6.field_5_ixchFollow) goto L27;
        return false;
    L27:
        if (this.field_6_dxaIndentSav == r6.field_6_dxaIndentSav) goto L30;
        return false;
    L30:
        if (this.field_7_unused2 == r6.field_7_unused2) goto L33;
        return false;
    L33:
        if (this.field_8_cbGrpprlChpx == r6.field_8_cbGrpprlChpx) goto L36;
        return false;
    L36:
        if (this.field_9_cbGrpprlPapx == r6.field_9_cbGrpprlPapx) goto L39;
        return false;
    L39:
        if (this.field_10_ilvlRestartLim == r6.field_10_ilvlRestartLim) goto L41;
        return false;
    L41:
        Grfhic r4 = this.field_11_grfhic;
        if (r4 != null) goto L47;
        if (r6.field_11_grfhic == null) goto L49;
        return false;
    L49:
        return true;
    L47:
        if (r4.equals(r6.field_11_grfhic) == true) goto L49;
        return false;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_iStartAt = LittleEndian.getInt(r3, r4 + 0);
        this.field_2_nfc = r3[r4 + 4];
        this.field_3_info = r3[r4 + 5];
        int r0 = r4 + 6;
        this.field_4_rgbxchNums = Arrays.copyOfRange(r3, r0, r0 + 9);
        this.field_5_ixchFollow = r3[r4 + 15];
        this.field_6_dxaIndentSav = LittleEndian.getInt(r3, r4 + 16);
        this.field_7_unused2 = LittleEndian.getInt(r3, r4 + 20);
        this.field_8_cbGrpprlChpx = LittleEndian.getUByte(r3, r4 + 24);
        this.field_9_cbGrpprlPapx = LittleEndian.getUByte(r3, r4 + 25);
        this.field_10_ilvlRestartLim = LittleEndian.getUByte(r3, r4 + 26);
        this.field_11_grfhic = new Grfhic(r3, r4 + 27);
    }

    public short getCbGrpprlChpx() {
        return this.field_8_cbGrpprlChpx;
    }

    public short getCbGrpprlPapx() {
        return this.field_9_cbGrpprlPapx;
    }

    public int getDxaIndentSav() {
        return this.field_6_dxaIndentSav;
    }

    public Grfhic getGrfhic() {
        return this.field_11_grfhic;
    }

    public int getIStartAt() {
        return this.field_1_iStartAt;
    }

    public short getIlvlRestartLim() {
        return this.field_10_ilvlRestartLim;
    }

    public byte getInfo() {
        return this.field_3_info;
    }

    public byte getIxchFollow() {
        return this.field_5_ixchFollow;
    }

    public byte getJc() {
        return (byte) jc.getValue(this.field_3_info);
    }

    public byte getNfc() {
        return this.field_2_nfc;
    }

    public byte[] getRgbxchNums() {
        return this.field_4_rgbxchNums;
    }

    public int getUnused2() {
        return this.field_7_unused2;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this.field_1_iStartAt), Byte.valueOf(this.field_2_nfc), Byte.valueOf(this.field_3_info), this.field_4_rgbxchNums, Byte.valueOf(this.field_5_ixchFollow), Integer.valueOf(this.field_6_dxaIndentSav), Integer.valueOf(this.field_7_unused2), Short.valueOf(this.field_8_cbGrpprlChpx), Short.valueOf(this.field_9_cbGrpprlPapx), Short.valueOf(this.field_10_ilvlRestartLim), this.field_11_grfhic});
    }

    public boolean isFConverted() {
        return fConverted.isSet(this.field_3_info);
    }

    public boolean isFIndentSav() {
        return fIndentSav.isSet(this.field_3_info);
    }

    public boolean isFLegal() {
        return fLegal.isSet(this.field_3_info);
    }

    public boolean isFNoRestart() {
        return fNoRestart.isSet(this.field_3_info);
    }

    public boolean isFTentative() {
        return fTentative.isSet(this.field_3_info);
    }

    @Deprecated
    public boolean isUnused1() {
        return unused1.isSet(this.field_3_info);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[LVLF]\n");
        r0.append("    .iStartAt             = ");
        r0.append(" (").append(getIStartAt()).append(" )\n");
        r0.append("    .nfc                  = ");
        r0.append(" (").append(getNfc()).append(" )\n");
        r0.append("    .info                 = ");
        r0.append(" (").append(getInfo()).append(" )\n");
        r0.append("         .jc                       = ").append(getJc()).append('\n');
        r0.append("         .fLegal                   = ").append(isFLegal()).append('\n');
        r0.append("         .fNoRestart               = ").append(isFNoRestart()).append('\n');
        r0.append("         .fIndentSav               = ").append(isFIndentSav()).append('\n');
        r0.append("         .fConverted               = ").append(isFConverted()).append('\n');
        r0.append("         .unused1                  = ").append(isUnused1()).append('\n');
        r0.append("         .fTentative               = ").append(isFTentative()).append('\n');
        r0.append("    .rgbxchNums           = ");
        r0.append(" (").append(Arrays.toString(getRgbxchNums())).append(" )\n");
        r0.append("    .ixchFollow           = ");
        r0.append(" (").append(getIxchFollow()).append(" )\n");
        r0.append("    .dxaIndentSav         = ");
        r0.append(" (").append(getDxaIndentSav()).append(" )\n");
        r0.append("    .unused2              = ");
        r0.append(" (").append(getUnused2()).append(" )\n");
        r0.append("    .cbGrpprlChpx         = ");
        r0.append(" (").append(getCbGrpprlChpx()).append(" )\n");
        r0.append("    .cbGrpprlPapx         = ");
        r0.append(" (").append(getCbGrpprlPapx()).append(" )\n");
        r0.append("    .ilvlRestartLim       = ");
        r0.append(" (").append(getIlvlRestartLim()).append(" )\n");
        r0.append("    .grfhic               = ");
        r0.append(" (").append(getGrfhic()).append(" )\n");
        r0.append("[/LVLF]\n");
        return r0.toString();
    }
}
