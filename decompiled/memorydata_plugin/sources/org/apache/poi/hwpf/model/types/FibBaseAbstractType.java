package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FibBaseAbstractType {
    private static final BitField cQuickSaves = null;
    private static final BitField fComplex = null;
    private static final BitField fDot = null;
    private static final BitField fEmptySpecial = null;
    private static final BitField fEncrypted = null;
    private static final BitField fExtChar = null;
    private static final BitField fFarEast = null;
    private static final BitField fGlsy = null;
    private static final BitField fHasPic = null;
    private static final BitField fLoadOverride = null;
    private static final BitField fLoadOverridePage = null;
    private static final BitField fMac = null;
    private static final BitField fObfuscated = null;
    private static final BitField fReadOnlyRecommended = null;
    private static final BitField fSpare0 = null;
    private static final BitField fWhichTblStm = null;
    private static final BitField fWriteReservation = null;
    private static final BitField reserved1 = null;
    private static final BitField reserved2 = null;
    protected byte field_10_flags2;

    @Deprecated
    protected short field_11_Chs;

    @Deprecated
    protected short field_12_chsTables;

    @Deprecated
    protected int field_13_fcMin;

    @Deprecated
    protected int field_14_fcMac;
    protected int field_1_wIdent;
    protected int field_2_nFib;
    protected int field_3_unused;
    protected int field_4_lid;
    protected int field_5_pnNext;
    protected short field_6_flags1;
    protected int field_7_nFibBack;
    protected int field_8_lKey;

    @Deprecated
    protected byte field_9_envr;

    static {
        fDot = new BitField(1);
        fGlsy = new BitField(2);
        fComplex = new BitField(4);
        fHasPic = new BitField(8);
        cQuickSaves = new BitField(240);
        fEncrypted = new BitField(256);
        fWhichTblStm = new BitField(512);
        fReadOnlyRecommended = new BitField(1024);
        fWriteReservation = new BitField(2048);
        fExtChar = new BitField(4096);
        fLoadOverride = new BitField(8192);
        fFarEast = new BitField(16384);
        fObfuscated = new BitField(32768);
        fMac = new BitField(1);
        fEmptySpecial = new BitField(2);
        fLoadOverridePage = new BitField(4);
        reserved1 = new BitField(8);
        reserved2 = new BitField(16);
        fSpare0 = new BitField(254);
    }

    public FibBaseAbstractType() {
    }

    public static int getSize() {
        return 32;
    }

    public void fillFields(byte[] r2, int r3) {
        this.field_1_wIdent = LittleEndian.getShort(r2, r3 + 0);
        this.field_2_nFib = LittleEndian.getShort(r2, r3 + 2);
        this.field_3_unused = LittleEndian.getShort(r2, r3 + 4);
        this.field_4_lid = LittleEndian.getShort(r2, r3 + 6);
        this.field_5_pnNext = LittleEndian.getShort(r2, r3 + 8);
        this.field_6_flags1 = LittleEndian.getShort(r2, r3 + 10);
        this.field_7_nFibBack = LittleEndian.getShort(r2, r3 + 12);
        this.field_8_lKey = LittleEndian.getInt(r2, r3 + 14);
        this.field_9_envr = r2[r3 + 18];
        this.field_10_flags2 = r2[r3 + 19];
        this.field_11_Chs = LittleEndian.getShort(r2, r3 + 20);
        this.field_12_chsTables = LittleEndian.getShort(r2, r3 + 22);
        this.field_13_fcMin = LittleEndian.getInt(r2, r3 + 24);
        this.field_14_fcMac = LittleEndian.getInt(r2, r3 + 28);
    }

    public byte getCQuickSaves() {
        return (byte) cQuickSaves.getValue(this.field_6_flags1);
    }

    public short getChs() {
        return this.field_11_Chs;
    }

    public short getChsTables() {
        return this.field_12_chsTables;
    }

    public byte getEnvr() {
        return this.field_9_envr;
    }

    @Deprecated
    public byte getFSpare0() {
        return (byte) fSpare0.getValue(this.field_10_flags2);
    }

    public int getFcMac() {
        return this.field_14_fcMac;
    }

    public int getFcMin() {
        return this.field_13_fcMin;
    }

    public short getFlags1() {
        return this.field_6_flags1;
    }

    public byte getFlags2() {
        return this.field_10_flags2;
    }

    public int getLKey() {
        return this.field_8_lKey;
    }

    public int getLid() {
        return this.field_4_lid;
    }

    public int getNFib() {
        return this.field_2_nFib;
    }

    public int getNFibBack() {
        return this.field_7_nFibBack;
    }

    public int getPnNext() {
        return this.field_5_pnNext;
    }

    public int getUnused() {
        return this.field_3_unused;
    }

    public int getWIdent() {
        return this.field_1_wIdent;
    }

    public boolean isFComplex() {
        return fComplex.isSet(this.field_6_flags1);
    }

    public boolean isFDot() {
        return fDot.isSet(this.field_6_flags1);
    }

    @Deprecated
    public boolean isFEmptySpecial() {
        return fEmptySpecial.isSet(this.field_10_flags2);
    }

    public boolean isFEncrypted() {
        return fEncrypted.isSet(this.field_6_flags1);
    }

    public boolean isFExtChar() {
        return fExtChar.isSet(this.field_6_flags1);
    }

    public boolean isFFarEast() {
        return fFarEast.isSet(this.field_6_flags1);
    }

    public boolean isFGlsy() {
        return fGlsy.isSet(this.field_6_flags1);
    }

    public boolean isFHasPic() {
        return fHasPic.isSet(this.field_6_flags1);
    }

    public boolean isFLoadOverride() {
        return fLoadOverride.isSet(this.field_6_flags1);
    }

    public boolean isFLoadOverridePage() {
        return fLoadOverridePage.isSet(this.field_10_flags2);
    }

    @Deprecated
    public boolean isFMac() {
        return fMac.isSet(this.field_10_flags2);
    }

    public boolean isFObfuscated() {
        return fObfuscated.isSet(this.field_6_flags1);
    }

    public boolean isFReadOnlyRecommended() {
        return fReadOnlyRecommended.isSet(this.field_6_flags1);
    }

    public boolean isFWhichTblStm() {
        return fWhichTblStm.isSet(this.field_6_flags1);
    }

    public boolean isFWriteReservation() {
        return fWriteReservation.isSet(this.field_6_flags1);
    }

    @Deprecated
    public boolean isReserved1() {
        return reserved1.isSet(this.field_10_flags2);
    }

    @Deprecated
    public boolean isReserved2() {
        return reserved2.isSet(this.field_10_flags2);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[FibBase]\n");
        r0.append("    .wIdent               = ");
        r0.append(" (").append(getWIdent()).append(" )\n");
        r0.append("    .nFib                 = ");
        r0.append(" (").append(getNFib()).append(" )\n");
        r0.append("    .unused               = ");
        r0.append(" (").append(getUnused()).append(" )\n");
        r0.append("    .lid                  = ");
        r0.append(" (").append(getLid()).append(" )\n");
        r0.append("    .pnNext               = ");
        r0.append(" (").append(getPnNext()).append(" )\n");
        r0.append("    .flags1               = ");
        r0.append(" (").append(getFlags1()).append(" )\n");
        r0.append("         .fDot                     = ").append(isFDot()).append('\n');
        r0.append("         .fGlsy                    = ").append(isFGlsy()).append('\n');
        r0.append("         .fComplex                 = ").append(isFComplex()).append('\n');
        r0.append("         .fHasPic                  = ").append(isFHasPic()).append('\n');
        r0.append("         .cQuickSaves              = ").append(getCQuickSaves()).append('\n');
        r0.append("         .fEncrypted               = ").append(isFEncrypted()).append('\n');
        r0.append("         .fWhichTblStm             = ").append(isFWhichTblStm()).append('\n');
        r0.append("         .fReadOnlyRecommended     = ").append(isFReadOnlyRecommended()).append('\n');
        r0.append("         .fWriteReservation        = ").append(isFWriteReservation()).append('\n');
        r0.append("         .fExtChar                 = ").append(isFExtChar()).append('\n');
        r0.append("         .fLoadOverride            = ").append(isFLoadOverride()).append('\n');
        r0.append("         .fFarEast                 = ").append(isFFarEast()).append('\n');
        r0.append("         .fObfuscated              = ").append(isFObfuscated()).append('\n');
        r0.append("    .nFibBack             = ");
        r0.append(" (").append(getNFibBack()).append(" )\n");
        r0.append("    .lKey                 = ");
        r0.append(" (").append(getLKey()).append(" )\n");
        r0.append("    .envr                 = ");
        r0.append(" (").append(getEnvr()).append(" )\n");
        r0.append("    .flags2               = ");
        r0.append(" (").append(getFlags2()).append(" )\n");
        r0.append("         .fMac                     = ").append(isFMac()).append('\n');
        r0.append("         .fEmptySpecial            = ").append(isFEmptySpecial()).append('\n');
        r0.append("         .fLoadOverridePage        = ").append(isFLoadOverridePage()).append('\n');
        r0.append("         .reserved1                = ").append(isReserved1()).append('\n');
        r0.append("         .reserved2                = ").append(isReserved2()).append('\n');
        r0.append("         .fSpare0                  = ").append(getFSpare0()).append('\n');
        r0.append("    .Chs                  = ");
        r0.append(" (").append(getChs()).append(" )\n");
        r0.append("    .chsTables            = ");
        r0.append(" (").append(getChsTables()).append(" )\n");
        r0.append("    .fcMin                = ");
        r0.append(" (").append(getFcMin()).append(" )\n");
        r0.append("    .fcMac                = ");
        r0.append(" (").append(getFcMac()).append(" )\n");
        r0.append("[/FibBase]\n");
        return r0.toString();
    }
}
