package org.apache.poi.hwpf.model.types;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.poi.hwpf.model.Colorref;
import org.apache.poi.hwpf.model.Hyphenation;
import org.apache.poi.hwpf.usermodel.BorderCode;
import org.apache.poi.hwpf.usermodel.DateAndTime;
import org.apache.poi.hwpf.usermodel.ShadingDescriptor;
import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CHPAbstractType {
    private static final BitField fBiDi = null;
    private static final BitField fBold = null;
    private static final BitField fBoldBi = null;
    private static final BitField fBoldOther = null;
    private static final BitField fCalc = null;
    private static final BitField fCaps = null;
    private static final BitField fCellFitText = null;
    private static final BitField fChsDiff = null;
    private static final BitField fComplexScripts = null;
    private static final BitField fDStrike = null;
    private static final BitField fData = null;
    private static final BitField fEmboss = null;
    private static final BitField fFitText = null;
    private static final BitField fFldVanish = null;
    private static final BitField fFmtLineProp = null;
    private static final BitField fHighlight = null;
    private static final BitField fIcoBi = null;
    private static final BitField fImprint = null;
    private static final BitField fItalic = null;
    private static final BitField fItalicBi = null;
    private static final BitField fItalicOther = null;
    private static final BitField fKumimoji = null;
    private static final BitField fLSFitText = null;
    private static final BitField fLowerCase = null;
    private static final BitField fMacChs = null;
    private static final BitField fNoProof = null;
    private static final BitField fNonGlyph = null;
    private static final BitField fObj = null;
    private static final BitField fOle2 = null;
    private static final BitField fOutline = null;
    private static final BitField fRMark = null;
    private static final BitField fRMarkDel = null;
    private static final BitField fRuby = null;
    private static final BitField fShadow = null;
    private static final BitField fSmallCaps = null;
    private static final BitField fSpec = null;
    private static final BitField fStrike = null;
    private static final BitField fTNY = null;
    private static final BitField fTNYCompress = null;
    private static final BitField fTNYFetchTxm = null;
    private static final BitField fUsePgsuSettings = null;
    private static final BitField fVanish = null;
    private static final BitField fWarichu = null;
    private static final BitField fWarichuNoOpenBracket = null;
    private static final BitField fWebHidden = null;
    private static final BitField iWarichuBracket = null;
    private static final BitField icoHighlight = null;
    private static final BitField itypFELayout = null;
    private static final BitField spare = null;
    private static final BitField unused = null;
    protected int field_10_pctCharWidth;
    protected int field_11_lidDefault;
    protected int field_12_lidFE;
    protected byte field_13_kcd;
    protected boolean field_14_fUndetermine;
    protected byte field_15_iss;
    protected boolean field_16_fSpecSymbol;
    protected byte field_17_idct;
    protected byte field_18_idctHint;
    protected byte field_19_kul;
    protected int field_1_grpfChp;
    protected Hyphenation field_20_hresi;
    protected int field_21_hpsKern;
    protected short field_22_hpsPos;
    protected ShadingDescriptor field_23_shd;
    protected BorderCode field_24_brc;
    protected int field_25_ibstRMark;
    protected byte field_26_sfxtText;
    protected boolean field_27_fDblBdr;
    protected boolean field_28_fBorderWS;
    protected short field_29_ufel;
    protected int field_2_hps;
    protected byte field_30_copt;
    protected int field_31_hpsAsci;
    protected int field_32_hpsFE;
    protected int field_33_hpsBi;
    protected int field_34_ftcSym;
    protected int field_35_xchSym;
    protected int field_36_fcPic;
    protected int field_37_fcObj;
    protected int field_38_lTagObj;
    protected int field_39_fcData;
    protected int field_3_ftcAscii;
    protected Hyphenation field_40_hresiOld;
    protected int field_41_ibstRMarkDel;
    protected DateAndTime field_42_dttmRMark;
    protected DateAndTime field_43_dttmRMarkDel;
    protected int field_44_istd;
    protected int field_45_idslRMReason;
    protected int field_46_idslReasonDel;
    protected int field_47_cpg;
    protected short field_48_Highlight;
    protected short field_49_CharsetFlags;
    protected int field_4_ftcFE;
    protected short field_50_chse;
    protected boolean field_51_fPropRMark;
    protected int field_52_ibstPropRMark;
    protected DateAndTime field_53_dttmPropRMark;
    protected boolean field_54_fConflictOrig;
    protected boolean field_55_fConflictOtherDel;
    protected int field_56_wConflict;
    protected int field_57_IbstConflict;
    protected DateAndTime field_58_dttmConflict;
    protected boolean field_59_fDispFldRMark;
    protected int field_5_ftcOther;
    protected int field_60_ibstDispFldRMark;
    protected DateAndTime field_61_dttmDispFldRMark;
    protected byte[] field_62_xstDispFldRMark;
    protected int field_63_fcObjp;
    protected byte field_64_lbrCRJ;
    protected boolean field_65_fSpecVanish;
    protected boolean field_66_fHasOldProps;
    protected boolean field_67_fSdtVanish;
    protected int field_68_wCharScale;
    protected int field_6_ftcBi;
    protected int field_7_dxaSpace;
    protected Colorref field_8_cv;
    protected byte field_9_ico;

    static {
        fBold = new BitField(1);
        fItalic = new BitField(2);
        fRMarkDel = new BitField(4);
        fOutline = new BitField(8);
        fFldVanish = new BitField(16);
        fSmallCaps = new BitField(32);
        fCaps = new BitField(64);
        fVanish = new BitField(128);
        fRMark = new BitField(256);
        fSpec = new BitField(512);
        fStrike = new BitField(1024);
        fObj = new BitField(2048);
        fShadow = new BitField(4096);
        fLowerCase = new BitField(8192);
        fData = new BitField(16384);
        fOle2 = new BitField(32768);
        fEmboss = new BitField(65536);
        fImprint = new BitField(131072);
        fDStrike = new BitField(262144);
        fUsePgsuSettings = new BitField(524288);
        fBoldBi = new BitField(1048576);
        fComplexScripts = new BitField(1048576);
        fItalicBi = new BitField(2097152);
        fBiDi = new BitField(4194304);
        fIcoBi = new BitField(8388608);
        fNonGlyph = new BitField(16777216);
        fBoldOther = new BitField(33554432);
        fItalicOther = new BitField(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        fNoProof = new BitField(134217728);
        fWebHidden = new BitField(SQLiteDatabase.CREATE_IF_NECESSARY);
        fFitText = new BitField(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        fCalc = new BitField(1073741824);
        fFmtLineProp = new BitField(Integer.MIN_VALUE);
        itypFELayout = new BitField(255);
        fTNY = new BitField(256);
        fWarichu = new BitField(512);
        fKumimoji = new BitField(1024);
        fRuby = new BitField(2048);
        fLSFitText = new BitField(4096);
        spare = new BitField(57344);
        iWarichuBracket = new BitField(7);
        fWarichuNoOpenBracket = new BitField(8);
        fTNYCompress = new BitField(16);
        fTNYFetchTxm = new BitField(32);
        fCellFitText = new BitField(64);
        unused = new BitField(128);
        icoHighlight = new BitField(31);
        fHighlight = new BitField(32);
        fChsDiff = new BitField(1);
        fMacChs = new BitField(32);
    }

    public CHPAbstractType() {
        this.field_2_hps = 20;
        this.field_8_cv = new Colorref();
        this.field_11_lidDefault = 1024;
        this.field_12_lidFE = 1024;
        this.field_20_hresi = new Hyphenation();
        this.field_23_shd = new ShadingDescriptor();
        this.field_24_brc = new BorderCode();
        this.field_36_fcPic = -1;
        this.field_40_hresiOld = new Hyphenation();
        this.field_42_dttmRMark = new DateAndTime();
        this.field_43_dttmRMarkDel = new DateAndTime();
        this.field_44_istd = 10;
        this.field_53_dttmPropRMark = new DateAndTime();
        this.field_58_dttmConflict = new DateAndTime();
        this.field_61_dttmDispFldRMark = new DateAndTime();
        this.field_62_xstDispFldRMark = new byte[32];
        this.field_68_wCharScale = 100;
    }

    public CHPAbstractType(CHPAbstractType r4) {
        this.field_1_grpfChp = r4.field_1_grpfChp;
        this.field_2_hps = r4.field_2_hps;
        this.field_3_ftcAscii = r4.field_3_ftcAscii;
        this.field_4_ftcFE = r4.field_4_ftcFE;
        this.field_5_ftcOther = r4.field_5_ftcOther;
        this.field_6_ftcBi = r4.field_6_ftcBi;
        this.field_7_dxaSpace = r4.field_7_dxaSpace;
        Colorref r0 = r4.field_8_cv;
        byte[] r1 = null;
        if (r0 != null) goto L5;
        Colorref r2 = null;
    L6:
        this.field_8_cv = r2;
        this.field_9_ico = r4.field_9_ico;
        this.field_10_pctCharWidth = r4.field_10_pctCharWidth;
        this.field_11_lidDefault = r4.field_11_lidDefault;
        this.field_12_lidFE = r4.field_12_lidFE;
        this.field_13_kcd = r4.field_13_kcd;
        this.field_14_fUndetermine = r4.field_14_fUndetermine;
        this.field_15_iss = r4.field_15_iss;
        this.field_16_fSpecSymbol = r4.field_16_fSpecSymbol;
        this.field_17_idct = r4.field_17_idct;
        this.field_18_idctHint = r4.field_18_idctHint;
        this.field_19_kul = r4.field_19_kul;
        Hyphenation r3 = r4.field_20_hresi;
        if (r3 != null) goto L9;
        Hyphenation r5 = null;
    L10:
        this.field_20_hresi = r5;
        this.field_21_hpsKern = r4.field_21_hpsKern;
        this.field_22_hpsPos = r4.field_22_hpsPos;
        ShadingDescriptor r6 = r4.field_23_shd;
        if (r6 != null) goto L13;
        ShadingDescriptor r7 = null;
    L14:
        this.field_23_shd = r7;
        BorderCode r8 = r4.field_24_brc;
        if (r8 != null) goto L17;
        BorderCode r9 = null;
    L18:
        this.field_24_brc = r9;
        this.field_25_ibstRMark = r4.field_25_ibstRMark;
        this.field_26_sfxtText = r4.field_26_sfxtText;
        this.field_27_fDblBdr = r4.field_27_fDblBdr;
        this.field_28_fBorderWS = r4.field_28_fBorderWS;
        this.field_29_ufel = r4.field_29_ufel;
        this.field_30_copt = r4.field_30_copt;
        this.field_31_hpsAsci = r4.field_31_hpsAsci;
        this.field_32_hpsFE = r4.field_32_hpsFE;
        this.field_33_hpsBi = r4.field_33_hpsBi;
        this.field_34_ftcSym = r4.field_34_ftcSym;
        this.field_35_xchSym = r4.field_35_xchSym;
        this.field_36_fcPic = r4.field_36_fcPic;
        this.field_37_fcObj = r4.field_37_fcObj;
        this.field_38_lTagObj = r4.field_38_lTagObj;
        this.field_39_fcData = r4.field_39_fcData;
        Hyphenation r10 = r4.field_40_hresiOld;
        if (r10 != null) goto L21;
        Hyphenation r11 = null;
    L22:
        this.field_40_hresiOld = r11;
        this.field_41_ibstRMarkDel = r4.field_41_ibstRMarkDel;
        DateAndTime r12 = r4.field_42_dttmRMark;
        if (r12 != null) goto L25;
        DateAndTime r13 = null;
    L26:
        this.field_42_dttmRMark = r13;
        DateAndTime r14 = r4.field_43_dttmRMarkDel;
        if (r14 != null) goto L29;
        DateAndTime r15 = null;
    L30:
        this.field_43_dttmRMarkDel = r15;
        this.field_44_istd = r4.field_44_istd;
        this.field_45_idslRMReason = r4.field_45_idslRMReason;
        this.field_46_idslReasonDel = r4.field_46_idslReasonDel;
        this.field_47_cpg = r4.field_47_cpg;
        this.field_48_Highlight = r4.field_48_Highlight;
        this.field_49_CharsetFlags = r4.field_49_CharsetFlags;
        this.field_50_chse = r4.field_50_chse;
        this.field_51_fPropRMark = r4.field_51_fPropRMark;
        this.field_52_ibstPropRMark = r4.field_52_ibstPropRMark;
        DateAndTime r16 = r4.field_53_dttmPropRMark;
        if (r16 != null) goto L33;
        DateAndTime r17 = null;
    L34:
        this.field_53_dttmPropRMark = r17;
        this.field_54_fConflictOrig = r4.field_54_fConflictOrig;
        this.field_55_fConflictOtherDel = r4.field_55_fConflictOtherDel;
        this.field_56_wConflict = r4.field_56_wConflict;
        this.field_57_IbstConflict = r4.field_57_IbstConflict;
        DateAndTime r18 = r4.field_58_dttmConflict;
        if (r18 != null) goto L37;
        DateAndTime r19 = null;
    L38:
        this.field_58_dttmConflict = r19;
        this.field_59_fDispFldRMark = r4.field_59_fDispFldRMark;
        this.field_60_ibstDispFldRMark = r4.field_60_ibstDispFldRMark;
        DateAndTime r20 = r4.field_61_dttmDispFldRMark;
        if (r20 != null) goto L41;
        DateAndTime r21 = null;
    L42:
        this.field_61_dttmDispFldRMark = r21;
        byte[] r22 = r4.field_62_xstDispFldRMark;
        if (r22 == null) goto L46;
        r1 = (byte[]) ZeusTransformUtils.preCheckCast(r22.clone(), byte[].class, "com.obric.memorydata.plugin");
    L46:
        this.field_62_xstDispFldRMark = r1;
        this.field_63_fcObjp = r4.field_63_fcObjp;
        this.field_64_lbrCRJ = r4.field_64_lbrCRJ;
        this.field_65_fSpecVanish = r4.field_65_fSpecVanish;
        this.field_66_fHasOldProps = r4.field_66_fHasOldProps;
        this.field_67_fSdtVanish = r4.field_67_fSdtVanish;
        this.field_68_wCharScale = r4.field_68_wCharScale;
        return;
    L41:
        r21 = r20.copy();
        goto L42
    L37:
        r19 = r18.copy();
        goto L38
    L33:
        r17 = r16.copy();
        goto L34
    L29:
        r15 = r14.copy();
        goto L30
    L25:
        r13 = r12.copy();
        goto L26
    L21:
        r11 = r10.copy();
        goto L22
    L17:
        r9 = r8.copy();
        goto L18
    L13:
        r7 = r6.copy();
        goto L14
    L9:
        r5 = r3.copy();
        goto L10
    L5:
        r2 = r0.copy();
        goto L6
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
        CHPAbstractType r6 = (CHPAbstractType) ZeusTransformUtils.preCheckCast(r5, CHPAbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_grpfChp == r6.field_1_grpfChp) goto L15;
        return false;
    L15:
        if (this.field_2_hps == r6.field_2_hps) goto L18;
        return false;
    L18:
        if (this.field_3_ftcAscii == r6.field_3_ftcAscii) goto L21;
        return false;
    L21:
        if (this.field_4_ftcFE == r6.field_4_ftcFE) goto L24;
        return false;
    L24:
        if (this.field_5_ftcOther == r6.field_5_ftcOther) goto L27;
        return false;
    L27:
        if (this.field_6_ftcBi == r6.field_6_ftcBi) goto L30;
        return false;
    L30:
        if (this.field_7_dxaSpace == r6.field_7_dxaSpace) goto L32;
        return false;
    L32:
        Colorref r2 = this.field_8_cv;
        if (r2 != null) goto L38;
        if (r6.field_8_cv == null) goto L41;
        return false;
    L41:
        if (this.field_9_ico == r6.field_9_ico) goto L44;
        return false;
    L44:
        if (this.field_10_pctCharWidth == r6.field_10_pctCharWidth) goto L47;
        return false;
    L47:
        if (this.field_11_lidDefault == r6.field_11_lidDefault) goto L50;
        return false;
    L50:
        if (this.field_12_lidFE == r6.field_12_lidFE) goto L53;
        return false;
    L53:
        if (this.field_13_kcd == r6.field_13_kcd) goto L56;
        return false;
    L56:
        if (this.field_14_fUndetermine == r6.field_14_fUndetermine) goto L59;
        return false;
    L59:
        if (this.field_15_iss == r6.field_15_iss) goto L62;
        return false;
    L62:
        if (this.field_16_fSpecSymbol == r6.field_16_fSpecSymbol) goto L65;
        return false;
    L65:
        if (this.field_17_idct == r6.field_17_idct) goto L68;
        return false;
    L68:
        if (this.field_18_idctHint == r6.field_18_idctHint) goto L71;
        return false;
    L71:
        if (this.field_19_kul == r6.field_19_kul) goto L73;
        return false;
    L73:
        Hyphenation r3 = this.field_20_hresi;
        if (r3 != null) goto L79;
        if (r6.field_20_hresi == null) goto L82;
        return false;
    L82:
        if (this.field_21_hpsKern == r6.field_21_hpsKern) goto L85;
        return false;
    L85:
        if (this.field_22_hpsPos == r6.field_22_hpsPos) goto L87;
        return false;
    L87:
        ShadingDescriptor r4 = this.field_23_shd;
        if (r4 != null) goto L93;
        if (r6.field_23_shd == null) goto L95;
        return false;
    L95:
        BorderCode r7 = this.field_24_brc;
        if (r7 != null) goto L101;
        if (r6.field_24_brc == null) goto L104;
        return false;
    L104:
        if (this.field_25_ibstRMark == r6.field_25_ibstRMark) goto L107;
        return false;
    L107:
        if (this.field_26_sfxtText == r6.field_26_sfxtText) goto L110;
        return false;
    L110:
        if (this.field_27_fDblBdr == r6.field_27_fDblBdr) goto L113;
        return false;
    L113:
        if (this.field_28_fBorderWS == r6.field_28_fBorderWS) goto L116;
        return false;
    L116:
        if (this.field_29_ufel == r6.field_29_ufel) goto L119;
        return false;
    L119:
        if (this.field_30_copt == r6.field_30_copt) goto L122;
        return false;
    L122:
        if (this.field_31_hpsAsci == r6.field_31_hpsAsci) goto L125;
        return false;
    L125:
        if (this.field_32_hpsFE == r6.field_32_hpsFE) goto L128;
        return false;
    L128:
        if (this.field_33_hpsBi == r6.field_33_hpsBi) goto L131;
        return false;
    L131:
        if (this.field_34_ftcSym == r6.field_34_ftcSym) goto L134;
        return false;
    L134:
        if (this.field_35_xchSym == r6.field_35_xchSym) goto L137;
        return false;
    L137:
        if (this.field_36_fcPic == r6.field_36_fcPic) goto L140;
        return false;
    L140:
        if (this.field_37_fcObj == r6.field_37_fcObj) goto L143;
        return false;
    L143:
        if (this.field_38_lTagObj == r6.field_38_lTagObj) goto L146;
        return false;
    L146:
        if (this.field_39_fcData == r6.field_39_fcData) goto L148;
        return false;
    L148:
        Hyphenation r8 = this.field_40_hresiOld;
        if (r8 != null) goto L154;
        if (r6.field_40_hresiOld == null) goto L157;
        return false;
    L157:
        if (this.field_41_ibstRMarkDel == r6.field_41_ibstRMarkDel) goto L159;
        return false;
    L159:
        DateAndTime r9 = this.field_42_dttmRMark;
        if (r9 != null) goto L165;
        if (r6.field_42_dttmRMark == null) goto L167;
        return false;
    L167:
        DateAndTime r10 = this.field_43_dttmRMarkDel;
        if (r10 != null) goto L173;
        if (r6.field_43_dttmRMarkDel == null) goto L176;
        return false;
    L176:
        if (this.field_44_istd == r6.field_44_istd) goto L179;
        return false;
    L179:
        if (this.field_45_idslRMReason == r6.field_45_idslRMReason) goto L182;
        return false;
    L182:
        if (this.field_46_idslReasonDel == r6.field_46_idslReasonDel) goto L185;
        return false;
    L185:
        if (this.field_47_cpg == r6.field_47_cpg) goto L188;
        return false;
    L188:
        if (this.field_48_Highlight == r6.field_48_Highlight) goto L191;
        return false;
    L191:
        if (this.field_49_CharsetFlags == r6.field_49_CharsetFlags) goto L194;
        return false;
    L194:
        if (this.field_50_chse == r6.field_50_chse) goto L197;
        return false;
    L197:
        if (this.field_51_fPropRMark == r6.field_51_fPropRMark) goto L200;
        return false;
    L200:
        if (this.field_52_ibstPropRMark == r6.field_52_ibstPropRMark) goto L202;
        return false;
    L202:
        DateAndTime r11 = this.field_53_dttmPropRMark;
        if (r11 != null) goto L208;
        if (r6.field_53_dttmPropRMark == null) goto L211;
        return false;
    L211:
        if (this.field_54_fConflictOrig == r6.field_54_fConflictOrig) goto L214;
        return false;
    L214:
        if (this.field_55_fConflictOtherDel == r6.field_55_fConflictOtherDel) goto L217;
        return false;
    L217:
        if (this.field_56_wConflict == r6.field_56_wConflict) goto L220;
        return false;
    L220:
        if (this.field_57_IbstConflict == r6.field_57_IbstConflict) goto L222;
        return false;
    L222:
        DateAndTime r12 = this.field_58_dttmConflict;
        if (r12 != null) goto L228;
        if (r6.field_58_dttmConflict == null) goto L231;
        return false;
    L231:
        if (this.field_59_fDispFldRMark == r6.field_59_fDispFldRMark) goto L234;
        return false;
    L234:
        if (this.field_60_ibstDispFldRMark == r6.field_60_ibstDispFldRMark) goto L236;
        return false;
    L236:
        DateAndTime r13 = this.field_61_dttmDispFldRMark;
        if (r13 != null) goto L242;
        if (r6.field_61_dttmDispFldRMark == null) goto L245;
        return false;
    L245:
        if (Arrays.equals(this.field_62_xstDispFldRMark, r6.field_62_xstDispFldRMark) == true) goto L248;
        return false;
    L248:
        if (this.field_63_fcObjp == r6.field_63_fcObjp) goto L251;
        return false;
    L251:
        if (this.field_64_lbrCRJ == r6.field_64_lbrCRJ) goto L254;
        return false;
    L254:
        if (this.field_65_fSpecVanish == r6.field_65_fSpecVanish) goto L257;
        return false;
    L257:
        if (this.field_66_fHasOldProps == r6.field_66_fHasOldProps) goto L260;
        return false;
    L260:
        if (this.field_67_fSdtVanish == r6.field_67_fSdtVanish) goto L263;
        return false;
    L263:
        if (this.field_68_wCharScale == r6.field_68_wCharScale) goto L265;
        return false;
    L265:
        return true;
    L242:
        if (r13.equals(r6.field_61_dttmDispFldRMark) == true) goto L245;
        return false;
    L228:
        if (r12.equals(r6.field_58_dttmConflict) == true) goto L231;
        return false;
    L208:
        if (r11.equals(r6.field_53_dttmPropRMark) == true) goto L211;
        return false;
    L173:
        if (r10.equals(r6.field_43_dttmRMarkDel) == true) goto L176;
        return false;
    L165:
        if (r9.equals(r6.field_42_dttmRMark) == true) goto L167;
        return false;
    L154:
        if (r8.equals(r6.field_40_hresiOld) == true) goto L157;
        return false;
    L101:
        if (r7.equals(r6.field_24_brc) == true) goto L104;
        return false;
    L93:
        if (r4.equals(r6.field_23_shd) == true) goto L95;
        return false;
    L79:
        if (r3.equals(r6.field_20_hresi) == true) goto L82;
        return false;
    L38:
        if (r2.equals(r6.field_8_cv) == true) goto L41;
        return false;
    }

    public BorderCode getBrc() {
        return this.field_24_brc;
    }

    public short getCharsetFlags() {
        return this.field_49_CharsetFlags;
    }

    public short getChse() {
        return this.field_50_chse;
    }

    public byte getCopt() {
        return this.field_30_copt;
    }

    public int getCpg() {
        return this.field_47_cpg;
    }

    public Colorref getCv() {
        return this.field_8_cv;
    }

    public DateAndTime getDttmConflict() {
        return this.field_58_dttmConflict;
    }

    public DateAndTime getDttmDispFldRMark() {
        return this.field_61_dttmDispFldRMark;
    }

    public DateAndTime getDttmPropRMark() {
        return this.field_53_dttmPropRMark;
    }

    public DateAndTime getDttmRMark() {
        return this.field_42_dttmRMark;
    }

    public DateAndTime getDttmRMarkDel() {
        return this.field_43_dttmRMarkDel;
    }

    public int getDxaSpace() {
        return this.field_7_dxaSpace;
    }

    public boolean getFBorderWS() {
        return this.field_28_fBorderWS;
    }

    public boolean getFConflictOrig() {
        return this.field_54_fConflictOrig;
    }

    public boolean getFConflictOtherDel() {
        return this.field_55_fConflictOtherDel;
    }

    public boolean getFDblBdr() {
        return this.field_27_fDblBdr;
    }

    public boolean getFDispFldRMark() {
        return this.field_59_fDispFldRMark;
    }

    public boolean getFHasOldProps() {
        return this.field_66_fHasOldProps;
    }

    public boolean getFPropRMark() {
        return this.field_51_fPropRMark;
    }

    public boolean getFSdtVanish() {
        return this.field_67_fSdtVanish;
    }

    public boolean getFSpecSymbol() {
        return this.field_16_fSpecSymbol;
    }

    public boolean getFSpecVanish() {
        return this.field_65_fSpecVanish;
    }

    public boolean getFUndetermine() {
        return this.field_14_fUndetermine;
    }

    public int getFcData() {
        return this.field_39_fcData;
    }

    public int getFcObj() {
        return this.field_37_fcObj;
    }

    public int getFcObjp() {
        return this.field_63_fcObjp;
    }

    public int getFcPic() {
        return this.field_36_fcPic;
    }

    public int getFtcAscii() {
        return this.field_3_ftcAscii;
    }

    public int getFtcBi() {
        return this.field_6_ftcBi;
    }

    public int getFtcFE() {
        return this.field_4_ftcFE;
    }

    public int getFtcOther() {
        return this.field_5_ftcOther;
    }

    public int getFtcSym() {
        return this.field_34_ftcSym;
    }

    public int getGrpfChp() {
        return this.field_1_grpfChp;
    }

    public short getHighlight() {
        return this.field_48_Highlight;
    }

    public int getHps() {
        return this.field_2_hps;
    }

    public int getHpsAsci() {
        return this.field_31_hpsAsci;
    }

    public int getHpsBi() {
        return this.field_33_hpsBi;
    }

    public int getHpsFE() {
        return this.field_32_hpsFE;
    }

    public int getHpsKern() {
        return this.field_21_hpsKern;
    }

    public short getHpsPos() {
        return this.field_22_hpsPos;
    }

    public Hyphenation getHresi() {
        return this.field_20_hresi;
    }

    public Hyphenation getHresiOld() {
        return this.field_40_hresiOld;
    }

    public byte getIWarichuBracket() {
        return (byte) iWarichuBracket.getValue(this.field_30_copt);
    }

    public int getIbstConflict() {
        return this.field_57_IbstConflict;
    }

    public int getIbstDispFldRMark() {
        return this.field_60_ibstDispFldRMark;
    }

    public int getIbstPropRMark() {
        return this.field_52_ibstPropRMark;
    }

    public int getIbstRMark() {
        return this.field_25_ibstRMark;
    }

    public int getIbstRMarkDel() {
        return this.field_41_ibstRMarkDel;
    }

    public byte getIco() {
        return this.field_9_ico;
    }

    public byte getIcoHighlight() {
        return (byte) icoHighlight.getValue(this.field_48_Highlight);
    }

    public byte getIdct() {
        return this.field_17_idct;
    }

    public byte getIdctHint() {
        return this.field_18_idctHint;
    }

    public int getIdslRMReason() {
        return this.field_45_idslRMReason;
    }

    public int getIdslReasonDel() {
        return this.field_46_idslReasonDel;
    }

    public byte getIss() {
        return this.field_15_iss;
    }

    public int getIstd() {
        return this.field_44_istd;
    }

    public short getItypFELayout() {
        return (short) itypFELayout.getValue(this.field_29_ufel);
    }

    public byte getKcd() {
        return this.field_13_kcd;
    }

    public byte getKul() {
        return this.field_19_kul;
    }

    public int getLTagObj() {
        return this.field_38_lTagObj;
    }

    public byte getLbrCRJ() {
        return this.field_64_lbrCRJ;
    }

    public int getLidDefault() {
        return this.field_11_lidDefault;
    }

    public int getLidFE() {
        return this.field_12_lidFE;
    }

    public int getPctCharWidth() {
        return this.field_10_pctCharWidth;
    }

    public byte getSfxtText() {
        return this.field_26_sfxtText;
    }

    public ShadingDescriptor getShd() {
        return this.field_23_shd;
    }

    public byte getSpare() {
        return (byte) spare.getValue(this.field_29_ufel);
    }

    public short getUfel() {
        return this.field_29_ufel;
    }

    public int getWCharScale() {
        return this.field_68_wCharScale;
    }

    public int getWConflict() {
        return this.field_56_wConflict;
    }

    public int getXchSym() {
        return this.field_35_xchSym;
    }

    public byte[] getXstDispFldRMark() {
        return this.field_62_xstDispFldRMark;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this.field_1_grpfChp), Integer.valueOf(this.field_2_hps), Integer.valueOf(this.field_3_ftcAscii), Integer.valueOf(this.field_4_ftcFE), Integer.valueOf(this.field_5_ftcOther), Integer.valueOf(this.field_6_ftcBi), Integer.valueOf(this.field_7_dxaSpace), this.field_8_cv, Byte.valueOf(this.field_9_ico), Integer.valueOf(this.field_10_pctCharWidth), Integer.valueOf(this.field_11_lidDefault), Integer.valueOf(this.field_12_lidFE), Byte.valueOf(this.field_13_kcd), Boolean.valueOf(this.field_14_fUndetermine), Byte.valueOf(this.field_15_iss), Boolean.valueOf(this.field_16_fSpecSymbol), Byte.valueOf(this.field_17_idct), Byte.valueOf(this.field_18_idctHint), Byte.valueOf(this.field_19_kul), this.field_20_hresi, Integer.valueOf(this.field_21_hpsKern), Short.valueOf(this.field_22_hpsPos), this.field_23_shd, this.field_24_brc, Integer.valueOf(this.field_25_ibstRMark), Byte.valueOf(this.field_26_sfxtText), Boolean.valueOf(this.field_27_fDblBdr), Boolean.valueOf(this.field_28_fBorderWS), Short.valueOf(this.field_29_ufel), Byte.valueOf(this.field_30_copt), Integer.valueOf(this.field_31_hpsAsci), Integer.valueOf(this.field_32_hpsFE), Integer.valueOf(this.field_33_hpsBi), Integer.valueOf(this.field_34_ftcSym), Integer.valueOf(this.field_35_xchSym), Integer.valueOf(this.field_36_fcPic), Integer.valueOf(this.field_37_fcObj), Integer.valueOf(this.field_38_lTagObj), Integer.valueOf(this.field_39_fcData), this.field_40_hresiOld, Integer.valueOf(this.field_41_ibstRMarkDel), this.field_42_dttmRMark, this.field_43_dttmRMarkDel, Integer.valueOf(this.field_44_istd), Integer.valueOf(this.field_45_idslRMReason), Integer.valueOf(this.field_46_idslReasonDel), Integer.valueOf(this.field_47_cpg), Short.valueOf(this.field_48_Highlight), Short.valueOf(this.field_49_CharsetFlags), Short.valueOf(this.field_50_chse), Boolean.valueOf(this.field_51_fPropRMark), Integer.valueOf(this.field_52_ibstPropRMark), this.field_53_dttmPropRMark, Boolean.valueOf(this.field_54_fConflictOrig), Boolean.valueOf(this.field_55_fConflictOtherDel), Integer.valueOf(this.field_56_wConflict), Integer.valueOf(this.field_57_IbstConflict), this.field_58_dttmConflict, Boolean.valueOf(this.field_59_fDispFldRMark), Integer.valueOf(this.field_60_ibstDispFldRMark), this.field_61_dttmDispFldRMark, this.field_62_xstDispFldRMark, Integer.valueOf(this.field_63_fcObjp), Byte.valueOf(this.field_64_lbrCRJ), Boolean.valueOf(this.field_65_fSpecVanish), Boolean.valueOf(this.field_66_fHasOldProps), Boolean.valueOf(this.field_67_fSdtVanish), Integer.valueOf(this.field_68_wCharScale)});
    }

    public boolean isFBiDi() {
        return fBiDi.isSet(this.field_1_grpfChp);
    }

    public boolean isFBold() {
        return fBold.isSet(this.field_1_grpfChp);
    }

    public boolean isFBoldBi() {
        return fBoldBi.isSet(this.field_1_grpfChp);
    }

    public boolean isFBoldOther() {
        return fBoldOther.isSet(this.field_1_grpfChp);
    }

    public boolean isFCalc() {
        return fCalc.isSet(this.field_1_grpfChp);
    }

    public boolean isFCaps() {
        return fCaps.isSet(this.field_1_grpfChp);
    }

    public boolean isFCellFitText() {
        return fCellFitText.isSet(this.field_30_copt);
    }

    public boolean isFChsDiff() {
        return fChsDiff.isSet(this.field_49_CharsetFlags);
    }

    public boolean isFComplexScripts() {
        return fComplexScripts.isSet(this.field_1_grpfChp);
    }

    public boolean isFDStrike() {
        return fDStrike.isSet(this.field_1_grpfChp);
    }

    public boolean isFData() {
        return fData.isSet(this.field_1_grpfChp);
    }

    public boolean isFEmboss() {
        return fEmboss.isSet(this.field_1_grpfChp);
    }

    public boolean isFFitText() {
        return fFitText.isSet(this.field_1_grpfChp);
    }

    public boolean isFFldVanish() {
        return fFldVanish.isSet(this.field_1_grpfChp);
    }

    public boolean isFFmtLineProp() {
        return fFmtLineProp.isSet(this.field_1_grpfChp);
    }

    public boolean isFHighlight() {
        return fHighlight.isSet(this.field_48_Highlight);
    }

    public boolean isFIcoBi() {
        return fIcoBi.isSet(this.field_1_grpfChp);
    }

    public boolean isFImprint() {
        return fImprint.isSet(this.field_1_grpfChp);
    }

    public boolean isFItalic() {
        return fItalic.isSet(this.field_1_grpfChp);
    }

    public boolean isFItalicBi() {
        return fItalicBi.isSet(this.field_1_grpfChp);
    }

    public boolean isFItalicOther() {
        return fItalicOther.isSet(this.field_1_grpfChp);
    }

    public boolean isFKumimoji() {
        return fKumimoji.isSet(this.field_29_ufel);
    }

    public boolean isFLSFitText() {
        return fLSFitText.isSet(this.field_29_ufel);
    }

    public boolean isFLowerCase() {
        return fLowerCase.isSet(this.field_1_grpfChp);
    }

    public boolean isFMacChs() {
        return fMacChs.isSet(this.field_49_CharsetFlags);
    }

    public boolean isFNoProof() {
        return fNoProof.isSet(this.field_1_grpfChp);
    }

    public boolean isFNonGlyph() {
        return fNonGlyph.isSet(this.field_1_grpfChp);
    }

    public boolean isFObj() {
        return fObj.isSet(this.field_1_grpfChp);
    }

    public boolean isFOle2() {
        return fOle2.isSet(this.field_1_grpfChp);
    }

    public boolean isFOutline() {
        return fOutline.isSet(this.field_1_grpfChp);
    }

    public boolean isFRMark() {
        return fRMark.isSet(this.field_1_grpfChp);
    }

    public boolean isFRMarkDel() {
        return fRMarkDel.isSet(this.field_1_grpfChp);
    }

    public boolean isFRuby() {
        return fRuby.isSet(this.field_29_ufel);
    }

    public boolean isFShadow() {
        return fShadow.isSet(this.field_1_grpfChp);
    }

    public boolean isFSmallCaps() {
        return fSmallCaps.isSet(this.field_1_grpfChp);
    }

    public boolean isFSpec() {
        return fSpec.isSet(this.field_1_grpfChp);
    }

    public boolean isFStrike() {
        return fStrike.isSet(this.field_1_grpfChp);
    }

    public boolean isFTNY() {
        return fTNY.isSet(this.field_29_ufel);
    }

    public boolean isFTNYCompress() {
        return fTNYCompress.isSet(this.field_30_copt);
    }

    public boolean isFTNYFetchTxm() {
        return fTNYFetchTxm.isSet(this.field_30_copt);
    }

    public boolean isFUsePgsuSettings() {
        return fUsePgsuSettings.isSet(this.field_1_grpfChp);
    }

    public boolean isFVanish() {
        return fVanish.isSet(this.field_1_grpfChp);
    }

    public boolean isFWarichu() {
        return fWarichu.isSet(this.field_29_ufel);
    }

    public boolean isFWarichuNoOpenBracket() {
        return fWarichuNoOpenBracket.isSet(this.field_30_copt);
    }

    public boolean isFWebHidden() {
        return fWebHidden.isSet(this.field_1_grpfChp);
    }

    public boolean isUnused() {
        return unused.isSet(this.field_30_copt);
    }

    public void setBrc(BorderCode r1) {
        this.field_24_brc = r1;
    }

    public void setChse(short r1) {
        this.field_50_chse = r1;
    }

    public void setCv(Colorref r1) {
        this.field_8_cv = r1;
    }

    public void setDttmDispFldRMark(DateAndTime r1) {
        this.field_61_dttmDispFldRMark = r1;
    }

    public void setDttmPropRMark(DateAndTime r1) {
        this.field_53_dttmPropRMark = r1;
    }

    public void setDttmRMark(DateAndTime r1) {
        this.field_42_dttmRMark = r1;
    }

    public void setDttmRMarkDel(DateAndTime r1) {
        this.field_43_dttmRMarkDel = r1;
    }

    public void setDxaSpace(int r1) {
        this.field_7_dxaSpace = r1;
    }

    public void setFBold(boolean r3) {
        this.field_1_grpfChp = fBold.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFCaps(boolean r3) {
        this.field_1_grpfChp = fCaps.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFChsDiff(boolean r3) {
        this.field_49_CharsetFlags = (short) fChsDiff.setBoolean(this.field_49_CharsetFlags, r3);
    }

    public void setFDStrike(boolean r3) {
        this.field_1_grpfChp = fDStrike.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFData(boolean r3) {
        this.field_1_grpfChp = fData.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFDispFldRMark(boolean r1) {
        this.field_59_fDispFldRMark = r1;
    }

    public void setFEmboss(boolean r3) {
        this.field_1_grpfChp = fEmboss.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFFldVanish(boolean r3) {
        this.field_1_grpfChp = fFldVanish.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFHighlight(boolean r3) {
        this.field_48_Highlight = (short) fHighlight.setBoolean(this.field_48_Highlight, r3);
    }

    public void setFImprint(boolean r3) {
        this.field_1_grpfChp = fImprint.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFItalic(boolean r3) {
        this.field_1_grpfChp = fItalic.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFNoProof(boolean r3) {
        this.field_1_grpfChp = fNoProof.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFObj(boolean r3) {
        this.field_1_grpfChp = fObj.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFOle2(boolean r3) {
        this.field_1_grpfChp = fOle2.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFOutline(boolean r3) {
        this.field_1_grpfChp = fOutline.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFPropRMark(boolean r1) {
        this.field_51_fPropRMark = r1;
    }

    public void setFRMark(boolean r3) {
        this.field_1_grpfChp = fRMark.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFRMarkDel(boolean r3) {
        this.field_1_grpfChp = fRMarkDel.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFShadow(boolean r3) {
        this.field_1_grpfChp = fShadow.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFSmallCaps(boolean r3) {
        this.field_1_grpfChp = fSmallCaps.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFSpec(boolean r3) {
        this.field_1_grpfChp = fSpec.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFStrike(boolean r3) {
        this.field_1_grpfChp = fStrike.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFUsePgsuSettings(boolean r3) {
        this.field_1_grpfChp = fUsePgsuSettings.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFVanish(boolean r3) {
        this.field_1_grpfChp = fVanish.setBoolean(this.field_1_grpfChp, r3);
    }

    public void setFcObj(int r1) {
        this.field_37_fcObj = r1;
    }

    public void setFcPic(int r1) {
        this.field_36_fcPic = r1;
    }

    public void setFtcAscii(int r1) {
        this.field_3_ftcAscii = r1;
    }

    public void setFtcFE(int r1) {
        this.field_4_ftcFE = r1;
    }

    public void setFtcOther(int r1) {
        this.field_5_ftcOther = r1;
    }

    public void setFtcSym(int r1) {
        this.field_34_ftcSym = r1;
    }

    public void setHps(int r1) {
        this.field_2_hps = r1;
    }

    public void setHpsKern(int r1) {
        this.field_21_hpsKern = r1;
    }

    public void setHpsPos(short r1) {
        this.field_22_hpsPos = r1;
    }

    public void setHresi(Hyphenation r1) {
        this.field_20_hresi = r1;
    }

    public void setIbstDispFldRMark(int r1) {
        this.field_60_ibstDispFldRMark = r1;
    }

    public void setIbstPropRMark(int r1) {
        this.field_52_ibstPropRMark = r1;
    }

    public void setIbstRMark(int r1) {
        this.field_25_ibstRMark = r1;
    }

    public void setIbstRMarkDel(int r1) {
        this.field_41_ibstRMarkDel = r1;
    }

    public void setIco(byte r1) {
        this.field_9_ico = r1;
    }

    public void setIcoHighlight(byte r3) {
        this.field_48_Highlight = (short) icoHighlight.setValue(this.field_48_Highlight, r3);
    }

    public void setIdctHint(byte r1) {
        this.field_18_idctHint = r1;
    }

    public void setIss(byte r1) {
        this.field_15_iss = r1;
    }

    public void setIstd(int r1) {
        this.field_44_istd = r1;
    }

    public void setKul(byte r1) {
        this.field_19_kul = r1;
    }

    public void setLidDefault(int r1) {
        this.field_11_lidDefault = r1;
    }

    public void setLidFE(int r1) {
        this.field_12_lidFE = r1;
    }

    public void setSfxtText(byte r1) {
        this.field_26_sfxtText = r1;
    }

    public void setShd(ShadingDescriptor r1) {
        this.field_23_shd = r1;
    }

    public void setXchSym(int r1) {
        this.field_35_xchSym = r1;
    }

    public void setXstDispFldRMark(byte[] r1) {
        this.field_62_xstDispFldRMark = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[CHP]\n");
        r0.append("    .grpfChp              = ");
        r0.append(" (").append(getGrpfChp()).append(" )\n");
        r0.append("         .fBold                    = ").append(isFBold()).append('\n');
        r0.append("         .fItalic                  = ").append(isFItalic()).append('\n');
        r0.append("         .fRMarkDel                = ").append(isFRMarkDel()).append('\n');
        r0.append("         .fOutline                 = ").append(isFOutline()).append('\n');
        r0.append("         .fFldVanish               = ").append(isFFldVanish()).append('\n');
        r0.append("         .fSmallCaps               = ").append(isFSmallCaps()).append('\n');
        r0.append("         .fCaps                    = ").append(isFCaps()).append('\n');
        r0.append("         .fVanish                  = ").append(isFVanish()).append('\n');
        r0.append("         .fRMark                   = ").append(isFRMark()).append('\n');
        r0.append("         .fSpec                    = ").append(isFSpec()).append('\n');
        r0.append("         .fStrike                  = ").append(isFStrike()).append('\n');
        r0.append("         .fObj                     = ").append(isFObj()).append('\n');
        r0.append("         .fShadow                  = ").append(isFShadow()).append('\n');
        r0.append("         .fLowerCase               = ").append(isFLowerCase()).append('\n');
        r0.append("         .fData                    = ").append(isFData()).append('\n');
        r0.append("         .fOle2                    = ").append(isFOle2()).append('\n');
        r0.append("         .fEmboss                  = ").append(isFEmboss()).append('\n');
        r0.append("         .fImprint                 = ").append(isFImprint()).append('\n');
        r0.append("         .fDStrike                 = ").append(isFDStrike()).append('\n');
        r0.append("         .fUsePgsuSettings         = ").append(isFUsePgsuSettings()).append('\n');
        r0.append("         .fBoldBi                  = ").append(isFBoldBi()).append('\n');
        r0.append("         .fComplexScripts          = ").append(isFComplexScripts()).append('\n');
        r0.append("         .fItalicBi                = ").append(isFItalicBi()).append('\n');
        r0.append("         .fBiDi                    = ").append(isFBiDi()).append('\n');
        r0.append("         .fIcoBi                   = ").append(isFIcoBi()).append('\n');
        r0.append("         .fNonGlyph                = ").append(isFNonGlyph()).append('\n');
        r0.append("         .fBoldOther               = ").append(isFBoldOther()).append('\n');
        r0.append("         .fItalicOther             = ").append(isFItalicOther()).append('\n');
        r0.append("         .fNoProof                 = ").append(isFNoProof()).append('\n');
        r0.append("         .fWebHidden               = ").append(isFWebHidden()).append('\n');
        r0.append("         .fFitText                 = ").append(isFFitText()).append('\n');
        r0.append("         .fCalc                    = ").append(isFCalc()).append('\n');
        r0.append("         .fFmtLineProp             = ").append(isFFmtLineProp()).append('\n');
        r0.append("    .hps                  = ");
        r0.append(" (").append(getHps()).append(" )\n");
        r0.append("    .ftcAscii             = ");
        r0.append(" (").append(getFtcAscii()).append(" )\n");
        r0.append("    .ftcFE                = ");
        r0.append(" (").append(getFtcFE()).append(" )\n");
        r0.append("    .ftcOther             = ");
        r0.append(" (").append(getFtcOther()).append(" )\n");
        r0.append("    .ftcBi                = ");
        r0.append(" (").append(getFtcBi()).append(" )\n");
        r0.append("    .dxaSpace             = ");
        r0.append(" (").append(getDxaSpace()).append(" )\n");
        r0.append("    .cv                   = ");
        r0.append(" (").append(getCv()).append(" )\n");
        r0.append("    .ico                  = ");
        r0.append(" (").append(getIco()).append(" )\n");
        r0.append("    .pctCharWidth         = ");
        r0.append(" (").append(getPctCharWidth()).append(" )\n");
        r0.append("    .lidDefault           = ");
        r0.append(" (").append(getLidDefault()).append(" )\n");
        r0.append("    .lidFE                = ");
        r0.append(" (").append(getLidFE()).append(" )\n");
        r0.append("    .kcd                  = ");
        r0.append(" (").append(getKcd()).append(" )\n");
        r0.append("    .fUndetermine         = ");
        r0.append(" (").append(getFUndetermine()).append(" )\n");
        r0.append("    .iss                  = ");
        r0.append(" (").append(getIss()).append(" )\n");
        r0.append("    .fSpecSymbol          = ");
        r0.append(" (").append(getFSpecSymbol()).append(" )\n");
        r0.append("    .idct                 = ");
        r0.append(" (").append(getIdct()).append(" )\n");
        r0.append("    .idctHint             = ");
        r0.append(" (").append(getIdctHint()).append(" )\n");
        r0.append("    .kul                  = ");
        r0.append(" (").append(getKul()).append(" )\n");
        r0.append("    .hresi                = ");
        r0.append(" (").append(getHresi()).append(" )\n");
        r0.append("    .hpsKern              = ");
        r0.append(" (").append(getHpsKern()).append(" )\n");
        r0.append("    .hpsPos               = ");
        r0.append(" (").append(getHpsPos()).append(" )\n");
        r0.append("    .shd                  = ");
        r0.append(" (").append(getShd()).append(" )\n");
        r0.append("    .brc                  = ");
        r0.append(" (").append(getBrc()).append(" )\n");
        r0.append("    .ibstRMark            = ");
        r0.append(" (").append(getIbstRMark()).append(" )\n");
        r0.append("    .sfxtText             = ");
        r0.append(" (").append(getSfxtText()).append(" )\n");
        r0.append("    .fDblBdr              = ");
        r0.append(" (").append(getFDblBdr()).append(" )\n");
        r0.append("    .fBorderWS            = ");
        r0.append(" (").append(getFBorderWS()).append(" )\n");
        r0.append("    .ufel                 = ");
        r0.append(" (").append(getUfel()).append(" )\n");
        r0.append("         .itypFELayout             = ").append(getItypFELayout()).append('\n');
        r0.append("         .fTNY                     = ").append(isFTNY()).append('\n');
        r0.append("         .fWarichu                 = ").append(isFWarichu()).append('\n');
        r0.append("         .fKumimoji                = ").append(isFKumimoji()).append('\n');
        r0.append("         .fRuby                    = ").append(isFRuby()).append('\n');
        r0.append("         .fLSFitText               = ").append(isFLSFitText()).append('\n');
        r0.append("         .spare                    = ").append(getSpare()).append('\n');
        r0.append("    .copt                 = ");
        r0.append(" (").append(getCopt()).append(" )\n");
        r0.append("         .iWarichuBracket          = ").append(getIWarichuBracket()).append('\n');
        r0.append("         .fWarichuNoOpenBracket     = ").append(isFWarichuNoOpenBracket()).append('\n');
        r0.append("         .fTNYCompress             = ").append(isFTNYCompress()).append('\n');
        r0.append("         .fTNYFetchTxm             = ").append(isFTNYFetchTxm()).append('\n');
        r0.append("         .fCellFitText             = ").append(isFCellFitText()).append('\n');
        r0.append("         .unused                   = ").append(isUnused()).append('\n');
        r0.append("    .hpsAsci              = ");
        r0.append(" (").append(getHpsAsci()).append(" )\n");
        r0.append("    .hpsFE                = ");
        r0.append(" (").append(getHpsFE()).append(" )\n");
        r0.append("    .hpsBi                = ");
        r0.append(" (").append(getHpsBi()).append(" )\n");
        r0.append("    .ftcSym               = ");
        r0.append(" (").append(getFtcSym()).append(" )\n");
        r0.append("    .xchSym               = ");
        r0.append(" (").append(getXchSym()).append(" )\n");
        r0.append("    .fcPic                = ");
        r0.append(" (").append(getFcPic()).append(" )\n");
        r0.append("    .fcObj                = ");
        r0.append(" (").append(getFcObj()).append(" )\n");
        r0.append("    .lTagObj              = ");
        r0.append(" (").append(getLTagObj()).append(" )\n");
        r0.append("    .fcData               = ");
        r0.append(" (").append(getFcData()).append(" )\n");
        r0.append("    .hresiOld             = ");
        r0.append(" (").append(getHresiOld()).append(" )\n");
        r0.append("    .ibstRMarkDel         = ");
        r0.append(" (").append(getIbstRMarkDel()).append(" )\n");
        r0.append("    .dttmRMark            = ");
        r0.append(" (").append(getDttmRMark()).append(" )\n");
        r0.append("    .dttmRMarkDel         = ");
        r0.append(" (").append(getDttmRMarkDel()).append(" )\n");
        r0.append("    .istd                 = ");
        r0.append(" (").append(getIstd()).append(" )\n");
        r0.append("    .idslRMReason         = ");
        r0.append(" (").append(getIdslRMReason()).append(" )\n");
        r0.append("    .idslReasonDel        = ");
        r0.append(" (").append(getIdslReasonDel()).append(" )\n");
        r0.append("    .cpg                  = ");
        r0.append(" (").append(getCpg()).append(" )\n");
        r0.append("    .Highlight            = ");
        r0.append(" (").append(getHighlight()).append(" )\n");
        r0.append("         .icoHighlight             = ").append(getIcoHighlight()).append('\n');
        r0.append("         .fHighlight               = ").append(isFHighlight()).append('\n');
        r0.append("    .CharsetFlags         = ");
        r0.append(" (").append(getCharsetFlags()).append(" )\n");
        r0.append("         .fChsDiff                 = ").append(isFChsDiff()).append('\n');
        r0.append("         .fMacChs                  = ").append(isFMacChs()).append('\n');
        r0.append("    .chse                 = ");
        r0.append(" (").append(getChse()).append(" )\n");
        r0.append("    .fPropRMark           = ");
        r0.append(" (").append(getFPropRMark()).append(" )\n");
        r0.append("    .ibstPropRMark        = ");
        r0.append(" (").append(getIbstPropRMark()).append(" )\n");
        r0.append("    .dttmPropRMark        = ");
        r0.append(" (").append(getDttmPropRMark()).append(" )\n");
        r0.append("    .fConflictOrig        = ");
        r0.append(" (").append(getFConflictOrig()).append(" )\n");
        r0.append("    .fConflictOtherDel    = ");
        r0.append(" (").append(getFConflictOtherDel()).append(" )\n");
        r0.append("    .wConflict            = ");
        r0.append(" (").append(getWConflict()).append(" )\n");
        r0.append("    .IbstConflict         = ");
        r0.append(" (").append(getIbstConflict()).append(" )\n");
        r0.append("    .dttmConflict         = ");
        r0.append(" (").append(getDttmConflict()).append(" )\n");
        r0.append("    .fDispFldRMark        = ");
        r0.append(" (").append(getFDispFldRMark()).append(" )\n");
        r0.append("    .ibstDispFldRMark     = ");
        r0.append(" (").append(getIbstDispFldRMark()).append(" )\n");
        r0.append("    .dttmDispFldRMark     = ");
        r0.append(" (").append(getDttmDispFldRMark()).append(" )\n");
        r0.append("    .xstDispFldRMark      = ");
        r0.append(" (").append(Arrays.toString(getXstDispFldRMark())).append(" )\n");
        r0.append("    .fcObjp               = ");
        r0.append(" (").append(getFcObjp()).append(" )\n");
        r0.append("    .lbrCRJ               = ");
        r0.append(" (").append(getLbrCRJ()).append(" )\n");
        r0.append("    .fSpecVanish          = ");
        r0.append(" (").append(getFSpecVanish()).append(" )\n");
        r0.append("    .fHasOldProps         = ");
        r0.append(" (").append(getFHasOldProps()).append(" )\n");
        r0.append("    .fSdtVanish           = ");
        r0.append(" (").append(getFSdtVanish()).append(" )\n");
        r0.append("    .wCharScale           = ");
        r0.append(" (").append(getWCharScale()).append(" )\n");
        r0.append("[/CHP]\n");
        return r0.toString();
    }
}
