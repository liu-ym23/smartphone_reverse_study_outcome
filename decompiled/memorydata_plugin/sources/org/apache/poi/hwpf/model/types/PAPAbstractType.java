package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.stream.Stream;
import org.apache.poi.hwpf.model.TabDescriptor;
import org.apache.poi.hwpf.usermodel.BorderCode;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.apache.poi.hwpf.usermodel.DropCapSpecifier;
import org.apache.poi.hwpf.usermodel.LineSpacingDescriptor;
import org.apache.poi.hwpf.usermodel.ShadingDescriptor;
import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class PAPAbstractType {
    private static final BitField fBackward = null;
    private static final BitField fRotateFont = null;
    private static final BitField fVertical = null;
    protected boolean field_10_fNoLnn;
    protected LineSpacingDescriptor field_11_lspd;
    protected int field_12_dyaBefore;
    protected int field_13_dyaAfter;
    protected boolean field_14_fInTable;
    protected boolean field_15_finTableW97;
    protected boolean field_16_fTtp;
    protected int field_17_dxaAbs;
    protected int field_18_dyaAbs;
    protected int field_19_dxaWidth;
    protected int field_1_istd;
    protected boolean field_20_fBrLnAbove;
    protected boolean field_21_fBrLnBelow;
    protected byte field_22_pcVert;
    protected byte field_23_pcHorz;
    protected byte field_24_wr;
    protected boolean field_25_fNoAutoHyph;
    protected int field_26_dyaHeight;
    protected boolean field_27_fMinHeight;
    protected DropCapSpecifier field_28_dcs;
    protected int field_29_dyaFromText;
    protected boolean field_2_fSideBySide;
    protected int field_30_dxaFromText;
    protected boolean field_31_fLocked;
    protected boolean field_32_fWidowControl;
    protected boolean field_33_fKinsoku;
    protected boolean field_34_fWordWrap;
    protected boolean field_35_fOverflowPunct;
    protected boolean field_36_fTopLinePunct;
    protected boolean field_37_fAutoSpaceDE;
    protected boolean field_38_fAutoSpaceDN;
    protected int field_39_wAlignFont;
    protected boolean field_3_fKeep;
    protected short field_40_fontAlign;
    protected byte field_41_lvl;
    protected boolean field_42_fBiDi;
    protected boolean field_43_fNumRMIns;
    protected boolean field_44_fCrLf;
    protected boolean field_45_fUsePgsuSettings;
    protected boolean field_46_fAdjustRight;
    protected int field_47_itap;
    protected boolean field_48_fInnerTableCell;
    protected boolean field_49_fOpenTch;
    protected boolean field_4_fKeepFollow;
    protected boolean field_50_fTtpEmbedded;
    protected short field_51_dxcRight;
    protected short field_52_dxcLeft;
    protected short field_53_dxcLeft1;
    protected boolean field_54_fDyaBeforeAuto;
    protected boolean field_55_fDyaAfterAuto;
    protected int field_56_dxaRight;
    protected int field_57_dxaLeft;
    protected int field_58_dxaLeft1;
    protected byte field_59_jc;
    protected boolean field_5_fPageBreakBefore;
    protected BorderCode field_60_brcTop;
    protected BorderCode field_61_brcLeft;
    protected BorderCode field_62_brcBottom;
    protected BorderCode field_63_brcRight;
    protected BorderCode field_64_brcBetween;
    protected BorderCode field_65_brcBar;
    protected ShadingDescriptor field_66_shd;
    protected byte[] field_67_anld;
    protected byte[] field_68_phe;
    protected boolean field_69_fPropRMark;
    protected byte field_6_brcl;
    protected int field_70_ibstPropRMark;
    protected DateAndTime field_71_dttmPropRMark;
    protected int field_72_itbdMac;
    protected int[] field_73_rgdxaTab;
    protected TabDescriptor[] field_74_rgtbd;
    protected byte[] field_75_numrm;
    protected byte[] field_76_ptap;
    protected boolean field_77_fNoAllowOverlap;
    protected long field_78_ipgp;
    protected long field_79_rsid;
    protected byte field_7_brcp;
    protected byte field_8_ilvl;
    protected int field_9_ilfo;

    static {
        fVertical = new BitField(1);
        fBackward = new BitField(2);
        fRotateFont = new BitField(4);
    }

    public PAPAbstractType() {
        this.field_11_lspd = new LineSpacingDescriptor();
        this.field_11_lspd = new LineSpacingDescriptor();
        this.field_28_dcs = new DropCapSpecifier();
        this.field_32_fWidowControl = true;
        this.field_41_lvl = 9;
        this.field_60_brcTop = new BorderCode();
        this.field_61_brcLeft = new BorderCode();
        this.field_62_brcBottom = new BorderCode();
        this.field_63_brcRight = new BorderCode();
        this.field_64_brcBetween = new BorderCode();
        this.field_65_brcBar = new BorderCode();
        this.field_66_shd = new ShadingDescriptor();
        this.field_67_anld = new byte[0];
        this.field_68_phe = new byte[0];
        this.field_71_dttmPropRMark = new DateAndTime();
        this.field_73_rgdxaTab = new int[0];
        this.field_74_rgtbd = new TabDescriptor[0];
        this.field_75_numrm = new byte[0];
        this.field_76_ptap = new byte[0];
    }

    public PAPAbstractType(PAPAbstractType r6) {
        this.field_1_istd = r6.field_1_istd;
        this.field_2_fSideBySide = r6.field_2_fSideBySide;
        this.field_3_fKeep = r6.field_3_fKeep;
        this.field_4_fKeepFollow = r6.field_4_fKeepFollow;
        this.field_5_fPageBreakBefore = r6.field_5_fPageBreakBefore;
        this.field_6_brcl = r6.field_6_brcl;
        this.field_7_brcp = r6.field_7_brcp;
        this.field_8_ilvl = r6.field_8_ilvl;
        this.field_9_ilfo = r6.field_9_ilfo;
        this.field_10_fNoLnn = r6.field_10_fNoLnn;
        LineSpacingDescriptor r1 = r6.field_11_lspd;
        byte[] r2 = null;
        if (r1 != null) goto L5;
        LineSpacingDescriptor r3 = null;
    L6:
        this.field_11_lspd = r3;
        this.field_12_dyaBefore = r6.field_12_dyaBefore;
        this.field_13_dyaAfter = r6.field_13_dyaAfter;
        this.field_14_fInTable = r6.field_14_fInTable;
        this.field_15_finTableW97 = r6.field_15_finTableW97;
        this.field_16_fTtp = r6.field_16_fTtp;
        this.field_17_dxaAbs = r6.field_17_dxaAbs;
        this.field_18_dyaAbs = r6.field_18_dyaAbs;
        this.field_19_dxaWidth = r6.field_19_dxaWidth;
        this.field_20_fBrLnAbove = r6.field_20_fBrLnAbove;
        this.field_21_fBrLnBelow = r6.field_21_fBrLnBelow;
        this.field_22_pcVert = r6.field_22_pcVert;
        this.field_23_pcHorz = r6.field_23_pcHorz;
        this.field_24_wr = r6.field_24_wr;
        this.field_25_fNoAutoHyph = r6.field_25_fNoAutoHyph;
        this.field_26_dyaHeight = r6.field_26_dyaHeight;
        this.field_27_fMinHeight = r6.field_27_fMinHeight;
        DropCapSpecifier r4 = r6.field_28_dcs;
        if (r4 != null) goto L9;
        DropCapSpecifier r5 = null;
    L10:
        this.field_28_dcs = r5;
        this.field_29_dyaFromText = r6.field_29_dyaFromText;
        this.field_30_dxaFromText = r6.field_30_dxaFromText;
        this.field_31_fLocked = r6.field_31_fLocked;
        this.field_32_fWidowControl = r6.field_32_fWidowControl;
        this.field_33_fKinsoku = r6.field_33_fKinsoku;
        this.field_34_fWordWrap = r6.field_34_fWordWrap;
        this.field_35_fOverflowPunct = r6.field_35_fOverflowPunct;
        this.field_36_fTopLinePunct = r6.field_36_fTopLinePunct;
        this.field_37_fAutoSpaceDE = r6.field_37_fAutoSpaceDE;
        this.field_38_fAutoSpaceDN = r6.field_38_fAutoSpaceDN;
        this.field_39_wAlignFont = r6.field_39_wAlignFont;
        this.field_40_fontAlign = r6.field_40_fontAlign;
        this.field_41_lvl = r6.field_41_lvl;
        this.field_42_fBiDi = r6.field_42_fBiDi;
        this.field_43_fNumRMIns = r6.field_43_fNumRMIns;
        this.field_44_fCrLf = r6.field_44_fCrLf;
        this.field_45_fUsePgsuSettings = r6.field_45_fUsePgsuSettings;
        this.field_46_fAdjustRight = r6.field_46_fAdjustRight;
        this.field_47_itap = r6.field_47_itap;
        this.field_48_fInnerTableCell = r6.field_48_fInnerTableCell;
        this.field_49_fOpenTch = r6.field_49_fOpenTch;
        this.field_50_fTtpEmbedded = r6.field_50_fTtpEmbedded;
        this.field_51_dxcRight = r6.field_51_dxcRight;
        this.field_52_dxcLeft = r6.field_52_dxcLeft;
        this.field_53_dxcLeft1 = r6.field_53_dxcLeft1;
        this.field_54_fDyaBeforeAuto = r6.field_54_fDyaBeforeAuto;
        this.field_55_fDyaAfterAuto = r6.field_55_fDyaAfterAuto;
        this.field_56_dxaRight = r6.field_56_dxaRight;
        this.field_57_dxaLeft = r6.field_57_dxaLeft;
        this.field_58_dxaLeft1 = r6.field_58_dxaLeft1;
        this.field_59_jc = r6.field_59_jc;
        BorderCode r7 = r6.field_60_brcTop;
        if (r7 != null) goto L13;
        BorderCode r8 = null;
    L14:
        this.field_60_brcTop = r8;
        BorderCode r9 = r6.field_61_brcLeft;
        if (r9 != null) goto L17;
        BorderCode r10 = null;
    L18:
        this.field_61_brcLeft = r10;
        BorderCode r11 = r6.field_62_brcBottom;
        if (r11 != null) goto L21;
        BorderCode r12 = null;
    L22:
        this.field_62_brcBottom = r12;
        BorderCode r13 = r6.field_63_brcRight;
        if (r13 != null) goto L25;
        BorderCode r14 = null;
    L26:
        this.field_63_brcRight = r14;
        BorderCode r15 = r6.field_64_brcBetween;
        if (r15 != null) goto L29;
        BorderCode r16 = null;
    L30:
        this.field_64_brcBetween = r16;
        BorderCode r17 = r6.field_65_brcBar;
        if (r17 != null) goto L33;
        BorderCode r18 = null;
    L34:
        this.field_65_brcBar = r18;
        ShadingDescriptor r19 = r6.field_66_shd;
        if (r19 != null) goto L37;
        ShadingDescriptor r20 = null;
    L38:
        this.field_66_shd = r20;
        byte[] r21 = r6.field_67_anld;
        if (r21 != null) goto L41;
        byte[] r22 = null;
    L42:
        this.field_67_anld = r22;
        byte[] r23 = r6.field_68_phe;
        if (r23 != null) goto L45;
        byte[] r24 = null;
    L46:
        this.field_68_phe = r24;
        this.field_69_fPropRMark = r6.field_69_fPropRMark;
        this.field_70_ibstPropRMark = r6.field_70_ibstPropRMark;
        DateAndTime r25 = r6.field_71_dttmPropRMark;
        if (r25 != null) goto L49;
        DateAndTime r26 = null;
    L50:
        this.field_71_dttmPropRMark = r26;
        this.field_72_itbdMac = r6.field_72_itbdMac;
        int[] r27 = r6.field_73_rgdxaTab;
        if (r27 != null) goto L53;
        int[] r28 = null;
    L54:
        this.field_73_rgdxaTab = r28;
        TabDescriptor[] r29 = r6.field_74_rgtbd;
        if (r29 != null) goto L57;
        TabDescriptor[] r30 = null;
    L58:
        this.field_74_rgtbd = r30;
        byte[] r31 = r6.field_75_numrm;
        if (r31 != null) goto L61;
        byte[] r32 = null;
    L62:
        this.field_75_numrm = r32;
        byte[] r33 = r6.field_76_ptap;
        if (r33 == null) goto L66;
        r2 = (byte[]) ZeusTransformUtils.preCheckCast(r33.clone(), byte[].class, "com.obric.memorydata.plugin");
    L66:
        this.field_76_ptap = r2;
        this.field_77_fNoAllowOverlap = r6.field_77_fNoAllowOverlap;
        this.field_78_ipgp = r6.field_78_ipgp;
        this.field_79_rsid = r6.field_79_rsid;
        return;
    L61:
        r32 = (byte[]) ZeusTransformUtils.preCheckCast(r31.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L62
    L57:
        r30 = (TabDescriptor[]) ZeusTransformUtils.preCheckCast(Stream.of(r29).map($$Lambda$KzhkxJnc6fpYQ1OEenfaebHXyWk.INSTANCE).toArray($$Lambda$PAPAbstractType$ZixWocubYJV8TvG0nrPMU4skf0Y.INSTANCE), TabDescriptor[].class, "com.obric.memorydata.plugin");
        goto L58
    L53:
        r28 = (int[]) ZeusTransformUtils.preCheckCast(r27.clone(), int[].class, "com.obric.memorydata.plugin");
        goto L54
    L49:
        r26 = r25.copy();
        goto L50
    L45:
        r24 = (byte[]) ZeusTransformUtils.preCheckCast(r23.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L46
    L41:
        r22 = (byte[]) ZeusTransformUtils.preCheckCast(r21.clone(), byte[].class, "com.obric.memorydata.plugin");
        goto L42
    L37:
        r20 = r19.copy();
        goto L38
    L33:
        r18 = r17.copy();
        goto L34
    L29:
        r16 = r15.copy();
        goto L30
    L25:
        r14 = r13.copy();
        goto L26
    L21:
        r12 = r11.copy();
        goto L22
    L17:
        r10 = r9.copy();
        goto L18
    L13:
        r8 = r7.copy();
        goto L14
    L9:
        r5 = r4.copy();
        goto L10
    L5:
        r3 = r1.copy();
        goto L6
    }

    static /* synthetic */ TabDescriptor[] lambda$new$0(int r0) {
        return new TabDescriptor[r0];
    }

    public byte[] getAnld() {
        return this.field_67_anld;
    }

    public BorderCode getBrcBar() {
        return this.field_65_brcBar;
    }

    public BorderCode getBrcBetween() {
        return this.field_64_brcBetween;
    }

    public BorderCode getBrcBottom() {
        return this.field_62_brcBottom;
    }

    public BorderCode getBrcLeft() {
        return this.field_61_brcLeft;
    }

    public BorderCode getBrcRight() {
        return this.field_63_brcRight;
    }

    public BorderCode getBrcTop() {
        return this.field_60_brcTop;
    }

    public byte getBrcl() {
        return this.field_6_brcl;
    }

    public byte getBrcp() {
        return this.field_7_brcp;
    }

    public DropCapSpecifier getDcs() {
        return this.field_28_dcs;
    }

    public DateAndTime getDttmPropRMark() {
        return this.field_71_dttmPropRMark;
    }

    public int getDxaAbs() {
        return this.field_17_dxaAbs;
    }

    public int getDxaFromText() {
        return this.field_30_dxaFromText;
    }

    public int getDxaLeft() {
        return this.field_57_dxaLeft;
    }

    public int getDxaLeft1() {
        return this.field_58_dxaLeft1;
    }

    public int getDxaRight() {
        return this.field_56_dxaRight;
    }

    public int getDxaWidth() {
        return this.field_19_dxaWidth;
    }

    public short getDxcLeft() {
        return this.field_52_dxcLeft;
    }

    public short getDxcLeft1() {
        return this.field_53_dxcLeft1;
    }

    public short getDxcRight() {
        return this.field_51_dxcRight;
    }

    public int getDyaAbs() {
        return this.field_18_dyaAbs;
    }

    public int getDyaAfter() {
        return this.field_13_dyaAfter;
    }

    public int getDyaBefore() {
        return this.field_12_dyaBefore;
    }

    public int getDyaFromText() {
        return this.field_29_dyaFromText;
    }

    public int getDyaHeight() {
        return this.field_26_dyaHeight;
    }

    public boolean getFAdjustRight() {
        return this.field_46_fAdjustRight;
    }

    public boolean getFAutoSpaceDE() {
        return this.field_37_fAutoSpaceDE;
    }

    public boolean getFAutoSpaceDN() {
        return this.field_38_fAutoSpaceDN;
    }

    public boolean getFBiDi() {
        return this.field_42_fBiDi;
    }

    public boolean getFBrLnAbove() {
        return this.field_20_fBrLnAbove;
    }

    public boolean getFBrLnBelow() {
        return this.field_21_fBrLnBelow;
    }

    public boolean getFCrLf() {
        return this.field_44_fCrLf;
    }

    public boolean getFDyaAfterAuto() {
        return this.field_55_fDyaAfterAuto;
    }

    public boolean getFDyaBeforeAuto() {
        return this.field_54_fDyaBeforeAuto;
    }

    public boolean getFInTable() {
        return this.field_14_fInTable;
    }

    public boolean getFInnerTableCell() {
        return this.field_48_fInnerTableCell;
    }

    public boolean getFKeep() {
        return this.field_3_fKeep;
    }

    public boolean getFKeepFollow() {
        return this.field_4_fKeepFollow;
    }

    public boolean getFKinsoku() {
        return this.field_33_fKinsoku;
    }

    public boolean getFLocked() {
        return this.field_31_fLocked;
    }

    public boolean getFMinHeight() {
        return this.field_27_fMinHeight;
    }

    public boolean getFNoAllowOverlap() {
        return this.field_77_fNoAllowOverlap;
    }

    public boolean getFNoAutoHyph() {
        return this.field_25_fNoAutoHyph;
    }

    public boolean getFNoLnn() {
        return this.field_10_fNoLnn;
    }

    public boolean getFNumRMIns() {
        return this.field_43_fNumRMIns;
    }

    public boolean getFOpenTch() {
        return this.field_49_fOpenTch;
    }

    public boolean getFOverflowPunct() {
        return this.field_35_fOverflowPunct;
    }

    public boolean getFPageBreakBefore() {
        return this.field_5_fPageBreakBefore;
    }

    public boolean getFPropRMark() {
        return this.field_69_fPropRMark;
    }

    public boolean getFSideBySide() {
        return this.field_2_fSideBySide;
    }

    public boolean getFTopLinePunct() {
        return this.field_36_fTopLinePunct;
    }

    public boolean getFTtp() {
        return this.field_16_fTtp;
    }

    public boolean getFTtpEmbedded() {
        return this.field_50_fTtpEmbedded;
    }

    public boolean getFUsePgsuSettings() {
        return this.field_45_fUsePgsuSettings;
    }

    public boolean getFWidowControl() {
        return this.field_32_fWidowControl;
    }

    public boolean getFWordWrap() {
        return this.field_34_fWordWrap;
    }

    public boolean getFinTableW97() {
        return this.field_15_finTableW97;
    }

    public short getFontAlign() {
        return this.field_40_fontAlign;
    }

    public int getIbstPropRMark() {
        return this.field_70_ibstPropRMark;
    }

    public int getIlfo() {
        return this.field_9_ilfo;
    }

    public byte getIlvl() {
        return this.field_8_ilvl;
    }

    public long getIpgp() {
        return this.field_78_ipgp;
    }

    public int getIstd() {
        return this.field_1_istd;
    }

    public int getItap() {
        return this.field_47_itap;
    }

    public int getItbdMac() {
        return this.field_72_itbdMac;
    }

    public byte getJc() {
        return this.field_59_jc;
    }

    public LineSpacingDescriptor getLspd() {
        return this.field_11_lspd;
    }

    public byte getLvl() {
        return this.field_41_lvl;
    }

    public byte[] getNumrm() {
        return this.field_75_numrm;
    }

    public byte getPcHorz() {
        return this.field_23_pcHorz;
    }

    public byte getPcVert() {
        return this.field_22_pcVert;
    }

    public byte[] getPhe() {
        return this.field_68_phe;
    }

    public byte[] getPtap() {
        return this.field_76_ptap;
    }

    public int[] getRgdxaTab() {
        return this.field_73_rgdxaTab;
    }

    public TabDescriptor[] getRgtbd() {
        return this.field_74_rgtbd;
    }

    public long getRsid() {
        return this.field_79_rsid;
    }

    public ShadingDescriptor getShd() {
        return this.field_66_shd;
    }

    public int getWAlignFont() {
        return this.field_39_wAlignFont;
    }

    public byte getWr() {
        return this.field_24_wr;
    }

    public boolean isFBackward() {
        return fBackward.isSet(this.field_40_fontAlign);
    }

    public boolean isFRotateFont() {
        return fRotateFont.isSet(this.field_40_fontAlign);
    }

    public boolean isFVertical() {
        return fVertical.isSet(this.field_40_fontAlign);
    }

    public void setAnld(byte[] r1) {
        this.field_67_anld = r1;
    }

    public void setBrcBar(BorderCode r1) {
        this.field_65_brcBar = r1;
    }

    public void setBrcBetween(BorderCode r1) {
        this.field_64_brcBetween = r1;
    }

    public void setBrcBottom(BorderCode r1) {
        this.field_62_brcBottom = r1;
    }

    public void setBrcLeft(BorderCode r1) {
        this.field_61_brcLeft = r1;
    }

    public void setBrcRight(BorderCode r1) {
        this.field_63_brcRight = r1;
    }

    public void setBrcTop(BorderCode r1) {
        this.field_60_brcTop = r1;
    }

    public void setBrcl(byte r1) {
        this.field_6_brcl = r1;
    }

    public void setBrcp(byte r1) {
        this.field_7_brcp = r1;
    }

    public void setDcs(DropCapSpecifier r1) {
        this.field_28_dcs = r1;
    }

    public void setDttmPropRMark(DateAndTime r1) {
        this.field_71_dttmPropRMark = r1;
    }

    public void setDxaAbs(int r1) {
        this.field_17_dxaAbs = r1;
    }

    public void setDxaFromText(int r1) {
        this.field_30_dxaFromText = r1;
    }

    public void setDxaLeft(int r1) {
        this.field_57_dxaLeft = r1;
    }

    public void setDxaLeft1(int r1) {
        this.field_58_dxaLeft1 = r1;
    }

    public void setDxaRight(int r1) {
        this.field_56_dxaRight = r1;
    }

    public void setDxaWidth(int r1) {
        this.field_19_dxaWidth = r1;
    }

    public void setDyaAbs(int r1) {
        this.field_18_dyaAbs = r1;
    }

    public void setDyaAfter(int r1) {
        this.field_13_dyaAfter = r1;
    }

    public void setDyaBefore(int r1) {
        this.field_12_dyaBefore = r1;
    }

    public void setDyaFromText(int r1) {
        this.field_29_dyaFromText = r1;
    }

    public void setDyaHeight(int r1) {
        this.field_26_dyaHeight = r1;
    }

    public void setFAdjustRight(boolean r1) {
        this.field_46_fAdjustRight = r1;
    }

    public void setFAutoSpaceDE(boolean r1) {
        this.field_37_fAutoSpaceDE = r1;
    }

    public void setFAutoSpaceDN(boolean r1) {
        this.field_38_fAutoSpaceDN = r1;
    }

    public void setFBiDi(boolean r1) {
        this.field_42_fBiDi = r1;
    }

    public void setFInTable(boolean r1) {
        this.field_14_fInTable = r1;
    }

    public void setFInnerTableCell(boolean r1) {
        this.field_48_fInnerTableCell = r1;
    }

    public void setFKeep(boolean r1) {
        this.field_3_fKeep = r1;
    }

    public void setFKeepFollow(boolean r1) {
        this.field_4_fKeepFollow = r1;
    }

    public void setFKinsoku(boolean r1) {
        this.field_33_fKinsoku = r1;
    }

    public void setFLocked(boolean r1) {
        this.field_31_fLocked = r1;
    }

    public void setFNoAutoHyph(boolean r1) {
        this.field_25_fNoAutoHyph = r1;
    }

    public void setFNoLnn(boolean r1) {
        this.field_10_fNoLnn = r1;
    }

    public void setFNumRMIns(boolean r1) {
        this.field_43_fNumRMIns = r1;
    }

    public void setFOverflowPunct(boolean r1) {
        this.field_35_fOverflowPunct = r1;
    }

    public void setFPageBreakBefore(boolean r1) {
        this.field_5_fPageBreakBefore = r1;
    }

    public void setFPropRMark(boolean r1) {
        this.field_69_fPropRMark = r1;
    }

    public void setFSideBySide(boolean r1) {
        this.field_2_fSideBySide = r1;
    }

    public void setFTopLinePunct(boolean r1) {
        this.field_36_fTopLinePunct = r1;
    }

    public void setFTtp(boolean r1) {
        this.field_16_fTtp = r1;
    }

    public void setFTtpEmbedded(boolean r1) {
        this.field_50_fTtpEmbedded = r1;
    }

    public void setFUsePgsuSettings(boolean r1) {
        this.field_45_fUsePgsuSettings = r1;
    }

    public void setFWidowControl(boolean r1) {
        this.field_32_fWidowControl = r1;
    }

    public void setFWordWrap(boolean r1) {
        this.field_34_fWordWrap = r1;
    }

    public void setFontAlign(short r1) {
        this.field_40_fontAlign = r1;
    }

    public void setIbstPropRMark(int r1) {
        this.field_70_ibstPropRMark = r1;
    }

    public void setIlfo(int r1) {
        this.field_9_ilfo = r1;
    }

    public void setIlvl(byte r1) {
        this.field_8_ilvl = r1;
    }

    public void setIstd(int r1) {
        this.field_1_istd = r1;
    }

    public void setItap(int r1) {
        this.field_47_itap = r1;
    }

    public void setJc(byte r1) {
        this.field_59_jc = r1;
    }

    public void setLspd(LineSpacingDescriptor r1) {
        this.field_11_lspd = r1;
    }

    public void setLvl(byte r1) {
        this.field_41_lvl = r1;
    }

    public void setNumrm(byte[] r1) {
        this.field_75_numrm = r1;
    }

    public void setPcHorz(byte r1) {
        this.field_23_pcHorz = r1;
    }

    public void setPcVert(byte r1) {
        this.field_22_pcVert = r1;
    }

    public void setPhe(byte[] r1) {
        this.field_68_phe = r1;
    }

    public void setRgdxaTab(int[] r1) {
        this.field_73_rgdxaTab = r1;
    }

    public void setRgtbd(TabDescriptor[] r1) {
        this.field_74_rgtbd = r1;
    }

    public void setRsid(long r1) {
        this.field_79_rsid = r1;
    }

    public void setShd(ShadingDescriptor r1) {
        this.field_66_shd = r1;
    }

    public void setWAlignFont(int r1) {
        this.field_39_wAlignFont = r1;
    }

    public void setWr(byte r1) {
        this.field_24_wr = r1;
    }

    public String toString() {
        return "[PAP]\n    .istd                 =  (" + getIstd() + " )\n    .fSideBySide          =  (" + getFSideBySide() + " )\n    .fKeep                =  (" + getFKeep() + " )\n    .fKeepFollow          =  (" + getFKeepFollow() + " )\n    .fPageBreakBefore     =  (" + getFPageBreakBefore() + " )\n    .brcl                 =  (" + getBrcl() + " )\n    .brcp                 =  (" + getBrcp() + " )\n    .ilvl                 =  (" + getIlvl() + " )\n    .ilfo                 =  (" + getIlfo() + " )\n    .fNoLnn               =  (" + getFNoLnn() + " )\n    .lspd                 =  (" + getLspd() + " )\n    .dyaBefore            =  (" + getDyaBefore() + " )\n    .dyaAfter             =  (" + getDyaAfter() + " )\n    .fInTable             =  (" + getFInTable() + " )\n    .finTableW97          =  (" + getFinTableW97() + " )\n    .fTtp                 =  (" + getFTtp() + " )\n    .dxaAbs               =  (" + getDxaAbs() + " )\n    .dyaAbs               =  (" + getDyaAbs() + " )\n    .dxaWidth             =  (" + getDxaWidth() + " )\n    .fBrLnAbove           =  (" + getFBrLnAbove() + " )\n    .fBrLnBelow           =  (" + getFBrLnBelow() + " )\n    .pcVert               =  (" + getPcVert() + " )\n    .pcHorz               =  (" + getPcHorz() + " )\n    .wr                   =  (" + getWr() + " )\n    .fNoAutoHyph          =  (" + getFNoAutoHyph() + " )\n    .dyaHeight            =  (" + getDyaHeight() + " )\n    .fMinHeight           =  (" + getFMinHeight() + " )\n    .dcs                  =  (" + getDcs() + " )\n    .dyaFromText          =  (" + getDyaFromText() + " )\n    .dxaFromText          =  (" + getDxaFromText() + " )\n    .fLocked              =  (" + getFLocked() + " )\n    .fWidowControl        =  (" + getFWidowControl() + " )\n    .fKinsoku             =  (" + getFKinsoku() + " )\n    .fWordWrap            =  (" + getFWordWrap() + " )\n    .fOverflowPunct       =  (" + getFOverflowPunct() + " )\n    .fTopLinePunct        =  (" + getFTopLinePunct() + " )\n    .fAutoSpaceDE         =  (" + getFAutoSpaceDE() + " )\n    .fAutoSpaceDN         =  (" + getFAutoSpaceDN() + " )\n    .wAlignFont           =  (" + getWAlignFont() + " )\n    .fontAlign            =  (" + getFontAlign() + " )\n         .fVertical                = " + isFVertical() + "\n         .fBackward                = " + isFBackward() + "\n         .fRotateFont              = " + isFRotateFont() + "\n    .lvl                  =  (" + getLvl() + " )\n    .fBiDi                =  (" + getFBiDi() + " )\n    .fNumRMIns            =  (" + getFNumRMIns() + " )\n    .fCrLf                =  (" + getFCrLf() + " )\n    .fUsePgsuSettings     =  (" + getFUsePgsuSettings() + " )\n    .fAdjustRight         =  (" + getFAdjustRight() + " )\n    .itap                 =  (" + getItap() + " )\n    .fInnerTableCell      =  (" + getFInnerTableCell() + " )\n    .fOpenTch             =  (" + getFOpenTch() + " )\n    .fTtpEmbedded         =  (" + getFTtpEmbedded() + " )\n    .dxcRight             =  (" + getDxcRight() + " )\n    .dxcLeft              =  (" + getDxcLeft() + " )\n    .dxcLeft1             =  (" + getDxcLeft1() + " )\n    .fDyaBeforeAuto       =  (" + getFDyaBeforeAuto() + " )\n    .fDyaAfterAuto        =  (" + getFDyaAfterAuto() + " )\n    .dxaRight             =  (" + getDxaRight() + " )\n    .dxaLeft              =  (" + getDxaLeft() + " )\n    .dxaLeft1             =  (" + getDxaLeft1() + " )\n    .jc                   =  (" + getJc() + " )\n    .brcTop               =  (" + getBrcTop() + " )\n    .brcLeft              =  (" + getBrcLeft() + " )\n    .brcBottom            =  (" + getBrcBottom() + " )\n    .brcRight             =  (" + getBrcRight() + " )\n    .brcBetween           =  (" + getBrcBetween() + " )\n    .brcBar               =  (" + getBrcBar() + " )\n    .shd                  =  (" + getShd() + " )\n    .anld                 =  (" + Arrays.toString(getAnld()) + " )\n    .phe                  =  (" + Arrays.toString(getPhe()) + " )\n    .fPropRMark           =  (" + getFPropRMark() + " )\n    .ibstPropRMark        =  (" + getIbstPropRMark() + " )\n    .dttmPropRMark        =  (" + getDttmPropRMark() + " )\n    .itbdMac              =  (" + getItbdMac() + " )\n    .rgdxaTab             =  (" + Arrays.toString(getRgdxaTab()) + " )\n    .rgtbd                =  (" + Arrays.toString(getRgtbd()) + " )\n    .numrm                =  (" + Arrays.toString(getNumrm()) + " )\n    .ptap                 =  (" + Arrays.toString(getPtap()) + " )\n    .fNoAllowOverlap      =  (" + getFNoAllowOverlap() + " )\n    .ipgp                 =  (" + getIpgp() + " )\n    .rsid                 =  (" + getRsid() + " )\n[/PAP]\n";
    }
}
