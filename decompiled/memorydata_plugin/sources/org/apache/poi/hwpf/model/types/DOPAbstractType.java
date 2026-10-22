package org.apache.poi.hwpf.model.types;

import com.ss.bduploader.BDAbstractUpload;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import java.util.Arrays;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class DOPAbstractType {
    private static final BitField KeyVirusSession30 = null;
    private static final BitField epc = null;
    private static final BitField fAutoHyphen = null;
    private static final BitField fAutoVersions = null;
    private static final BitField fBackup = null;
    private static final BitField fConvMailMergeEsc = null;
    private static final BitField fDfltTrueType = null;
    private static final BitField fDispFormFldSel = null;
    private static final BitField fEmbedFonts = null;
    private static final BitField fExactCWords = null;
    private static final BitField fFacingPages = null;
    private static final BitField fForcePageSizePag = null;
    private static final BitField fFormNoFields = null;
    private static final BitField fGramAllClean = null;
    private static final BitField fGramAllDone = null;
    private static final BitField fHaveVersions = null;
    private static final BitField fHideLastVersion = null;
    private static final BitField fHtmlDoc = null;
    private static final BitField fHyphCapitals = null;
    private static final BitField fIncludeFooter = null;
    private static final BitField fIncludeHeader = null;
    private static final BitField fLabelDoc = null;
    private static final BitField fLinkStyles = null;
    private static final BitField fLockAtn = null;
    private static final BitField fLockRev = null;
    private static final BitField fMWSmallCaps = null;
    private static final BitField fMapPrintTextColor = null;
    private static final BitField fMinFontSizePag = null;
    private static final BitField fMirrorMargins = null;
    private static final BitField fNoColumnBalance = null;
    private static final BitField fNoLeading = null;
    private static final BitField fNoSpaceRaiseLower = null;
    private static final BitField fNoTabForInd = null;
    private static final BitField fOnlyMacPics = null;
    private static final BitField fOnlyWinPics = null;
    private static final BitField fOrigWordTableRules = null;
    private static final BitField fPMHMainDoc = null;
    private static final BitField fPagHidden = null;
    private static final BitField fPagResults = null;
    private static final BitField fPagSupressTopSpacing = null;
    private static final BitField fPrintBodyBeforeHdr = null;
    private static final BitField fPrintFormData = null;
    private static final BitField fProtEnabled = null;
    private static final BitField fRMPrint = null;
    private static final BitField fRMView = null;
    private static final BitField fRevMarking = null;
    private static final BitField fRotateFontW6 = null;
    private static final BitField fSaveFormData = null;
    private static final BitField fShadeFormData = null;
    private static final BitField fShowBreaksInFrames = null;
    private static final BitField fSnapBorder = null;
    private static final BitField fSubsetFonts = null;
    private static final BitField fSuppressTopSPacingMac5 = null;
    private static final BitField fSupressSpdfAfterPageBreak = null;
    private static final BitField fSupressTopSpacing = null;
    private static final BitField fSwapBordersFacingPgs = null;
    private static final BitField fTransparentMetafiles = null;
    private static final BitField fTruncDxaExpand = null;
    private static final BitField fVirusLoadSafe = null;
    private static final BitField fVirusPrompted = null;
    private static final BitField fWCFtnEdn = null;
    private static final BitField fWidowControl = null;
    private static final BitField fWrapTrailSpaces = null;
    private static final BitField fpc = null;
    private static final BitField grfSupression = null;
    private static final BitField iGutterPos = null;
    private static final BitField lvl = null;
    private static final BitField nEdn = null;
    private static final BitField nFtn = null;
    private static final BitField nfcEdnRef1 = null;
    private static final BitField nfcFtnRef1 = null;
    private static final BitField oldfConvMailMergeEsc = null;
    private static final BitField oldfMapPrintTextColor = null;
    private static final BitField oldfNoColumnBalance = null;
    private static final BitField oldfNoSpaceRaiseLower = null;
    private static final BitField oldfNoTabForInd = null;
    private static final BitField oldfOrigWordTableRules = null;
    private static final BitField oldfShowBreaksInFrames = null;
    private static final BitField oldfSuppressSpbfAfterPageBreak = null;
    private static final BitField oldfSupressTopSpacing = null;
    private static final BitField oldfSwapBordersFacingPgs = null;
    private static final BitField oldfTransparentMetafiles = null;
    private static final BitField oldfWrapTrailSpaces = null;
    private static final BitField rncEdn = null;
    private static final BitField rncFtn = null;
    private static final BitField unused1 = null;
    private static final BitField unused3 = null;
    private static final BitField unused4 = null;
    private static final BitField unused5 = null;
    private static final BitField wScaleSaved = null;
    private static final BitField wvkSaved = null;
    private static final BitField zkSaved = null;
    protected int field_10_wSpare;
    protected int field_11_dxaHotz;
    protected int field_12_cConsexHypLim;
    protected int field_13_wSpare2;
    protected int field_14_dttmCreated;
    protected int field_15_dttmRevised;
    protected int field_16_dttmLastPrint;
    protected int field_17_nRevision;
    protected int field_18_tmEdited;
    protected int field_19_cWords;
    protected byte field_1_formatFlags;
    protected int field_20_cCh;
    protected int field_21_cPg;
    protected int field_22_cParas;
    protected short field_23_Edn;
    protected short field_24_Edn1;
    protected int field_25_cLines;
    protected int field_26_cWordsFtnEnd;
    protected int field_27_cChFtnEdn;
    protected short field_28_cPgFtnEdn;
    protected int field_29_cParasFtnEdn;
    protected byte field_2_unused2;
    protected int field_30_cLinesFtnEdn;
    protected int field_31_lKeyProtDoc;
    protected short field_32_view;
    protected int field_33_docinfo4;
    protected short field_34_adt;
    protected byte[] field_35_doptypography;
    protected byte[] field_36_dogrid;
    protected short field_37_docinfo5;
    protected short field_38_docinfo6;
    protected byte[] field_39_asumyi;
    protected short field_3_footnoteInfo;
    protected int field_40_cChWS;
    protected int field_41_cChWSFtnEdn;
    protected int field_42_grfDocEvents;
    protected int field_43_virusinfo;
    protected byte[] field_44_Spare;
    protected int field_45_reserved1;
    protected int field_46_reserved2;
    protected int field_47_cDBC;
    protected int field_48_cDBCFtnEdn;
    protected int field_49_reserved;
    protected byte field_4_fOutlineDirtySave;
    protected short field_50_nfcFtnRef;
    protected short field_51_nfcEdnRef;
    protected short field_52_hpsZoonFontPag;
    protected short field_53_dywDispPag;
    protected byte field_5_docinfo;
    protected byte field_6_docinfo1;
    protected byte field_7_docinfo2;
    protected short field_8_docinfo3;
    protected int field_9_dxaTab;

    static {
        fFacingPages = new BitField(1);
        fWidowControl = new BitField(2);
        fPMHMainDoc = new BitField(4);
        grfSupression = new BitField(24);
        fpc = new BitField(96);
        unused1 = new BitField(128);
        rncFtn = new BitField(3);
        nFtn = new BitField(65532);
        fOnlyMacPics = new BitField(1);
        fOnlyWinPics = new BitField(2);
        fLabelDoc = new BitField(4);
        fHyphCapitals = new BitField(8);
        fAutoHyphen = new BitField(16);
        fFormNoFields = new BitField(32);
        fLinkStyles = new BitField(64);
        fRevMarking = new BitField(128);
        fBackup = new BitField(1);
        fExactCWords = new BitField(2);
        fPagHidden = new BitField(4);
        fPagResults = new BitField(8);
        fLockAtn = new BitField(16);
        fMirrorMargins = new BitField(32);
        unused3 = new BitField(64);
        fDfltTrueType = new BitField(128);
        fPagSupressTopSpacing = new BitField(1);
        fProtEnabled = new BitField(2);
        fDispFormFldSel = new BitField(4);
        fRMView = new BitField(8);
        fRMPrint = new BitField(16);
        unused4 = new BitField(32);
        fLockRev = new BitField(64);
        fEmbedFonts = new BitField(128);
        oldfNoTabForInd = new BitField(1);
        oldfNoSpaceRaiseLower = new BitField(2);
        oldfSuppressSpbfAfterPageBreak = new BitField(4);
        oldfWrapTrailSpaces = new BitField(8);
        oldfMapPrintTextColor = new BitField(16);
        oldfNoColumnBalance = new BitField(32);
        oldfConvMailMergeEsc = new BitField(64);
        oldfSupressTopSpacing = new BitField(128);
        oldfOrigWordTableRules = new BitField(256);
        oldfTransparentMetafiles = new BitField(512);
        oldfShowBreaksInFrames = new BitField(1024);
        oldfSwapBordersFacingPgs = new BitField(2048);
        unused5 = new BitField(61440);
        rncEdn = new BitField(3);
        nEdn = new BitField(65532);
        epc = new BitField(3);
        nfcFtnRef1 = new BitField(60);
        nfcEdnRef1 = new BitField(960);
        fPrintFormData = new BitField(1024);
        fSaveFormData = new BitField(2048);
        fShadeFormData = new BitField(4096);
        fWCFtnEdn = new BitField(32768);
        wvkSaved = new BitField(7);
        wScaleSaved = new BitField(4088);
        zkSaved = new BitField(12288);
        fRotateFontW6 = new BitField(16384);
        iGutterPos = new BitField(32768);
        fNoTabForInd = new BitField(1);
        fNoSpaceRaiseLower = new BitField(2);
        fSupressSpdfAfterPageBreak = new BitField(4);
        fWrapTrailSpaces = new BitField(8);
        fMapPrintTextColor = new BitField(16);
        fNoColumnBalance = new BitField(32);
        fConvMailMergeEsc = new BitField(64);
        fSupressTopSpacing = new BitField(128);
        fOrigWordTableRules = new BitField(256);
        fTransparentMetafiles = new BitField(512);
        fShowBreaksInFrames = new BitField(1024);
        fSwapBordersFacingPgs = new BitField(2048);
        fSuppressTopSPacingMac5 = new BitField(65536);
        fTruncDxaExpand = new BitField(131072);
        fPrintBodyBeforeHdr = new BitField(262144);
        fNoLeading = new BitField(524288);
        fMWSmallCaps = new BitField(2097152);
        lvl = new BitField(30);
        fGramAllDone = new BitField(32);
        fGramAllClean = new BitField(64);
        fSubsetFonts = new BitField(128);
        fHideLastVersion = new BitField(256);
        fHtmlDoc = new BitField(512);
        fSnapBorder = new BitField(2048);
        fIncludeHeader = new BitField(4096);
        fIncludeFooter = new BitField(8192);
        fForcePageSizePag = new BitField(16384);
        fMinFontSizePag = new BitField(32768);
        fHaveVersions = new BitField(1);
        fAutoVersions = new BitField(2);
        fVirusPrompted = new BitField(1);
        fVirusLoadSafe = new BitField(2);
        KeyVirusSession30 = new BitField(-4);
    }

    public DOPAbstractType() {
        this.field_35_doptypography = new byte[0];
        this.field_36_dogrid = new byte[0];
        this.field_39_asumyi = new byte[0];
        this.field_44_Spare = new byte[0];
    }

    public static int getSize() {
        return 500;
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_formatFlags = r3[r4 + 0];
        this.field_2_unused2 = r3[r4 + 1];
        this.field_3_footnoteInfo = LittleEndian.getShort(r3, r4 + 2);
        this.field_4_fOutlineDirtySave = r3[r4 + 4];
        this.field_5_docinfo = r3[r4 + 5];
        this.field_6_docinfo1 = r3[r4 + 6];
        this.field_7_docinfo2 = r3[r4 + 7];
        this.field_8_docinfo3 = LittleEndian.getShort(r3, r4 + 8);
        this.field_9_dxaTab = LittleEndian.getShort(r3, r4 + 10);
        this.field_10_wSpare = LittleEndian.getShort(r3, r4 + 12);
        this.field_11_dxaHotz = LittleEndian.getShort(r3, r4 + 14);
        this.field_12_cConsexHypLim = LittleEndian.getShort(r3, r4 + 16);
        this.field_13_wSpare2 = LittleEndian.getShort(r3, r4 + 18);
        this.field_14_dttmCreated = LittleEndian.getInt(r3, r4 + 20);
        this.field_15_dttmRevised = LittleEndian.getInt(r3, r4 + 24);
        this.field_16_dttmLastPrint = LittleEndian.getInt(r3, r4 + 28);
        this.field_17_nRevision = LittleEndian.getShort(r3, r4 + 32);
        this.field_18_tmEdited = LittleEndian.getInt(r3, r4 + 34);
        this.field_19_cWords = LittleEndian.getInt(r3, r4 + 38);
        this.field_20_cCh = LittleEndian.getInt(r3, r4 + 42);
        this.field_21_cPg = LittleEndian.getShort(r3, r4 + 46);
        this.field_22_cParas = LittleEndian.getInt(r3, r4 + 48);
        this.field_23_Edn = LittleEndian.getShort(r3, r4 + 52);
        this.field_24_Edn1 = LittleEndian.getShort(r3, r4 + 54);
        this.field_25_cLines = LittleEndian.getInt(r3, r4 + 56);
        this.field_26_cWordsFtnEnd = LittleEndian.getInt(r3, r4 + 60);
        this.field_27_cChFtnEdn = LittleEndian.getInt(r3, r4 + 64);
        this.field_28_cPgFtnEdn = LittleEndian.getShort(r3, r4 + 68);
        this.field_29_cParasFtnEdn = LittleEndian.getInt(r3, r4 + 70);
        this.field_30_cLinesFtnEdn = LittleEndian.getInt(r3, r4 + 74);
        this.field_31_lKeyProtDoc = LittleEndian.getInt(r3, r4 + 78);
        this.field_32_view = LittleEndian.getShort(r3, r4 + 82);
        this.field_33_docinfo4 = LittleEndian.getInt(r3, r4 + 84);
        this.field_34_adt = LittleEndian.getShort(r3, r4 + 88);
        int r0 = r4 + 90;
        this.field_35_doptypography = Arrays.copyOfRange(r3, r0, r0 + 310);
        int r1 = r4 + 400;
        this.field_36_dogrid = Arrays.copyOfRange(r3, r1, r1 + 10);
        this.field_37_docinfo5 = LittleEndian.getShort(r3, r4 + 410);
        this.field_38_docinfo6 = LittleEndian.getShort(r3, r4 + BDVideoUploaderBase.KeyIsExternalReaderMode);
        int r2 = r4 + BDVideoUploaderBase.KeyIsPrivateVideo;
        this.field_39_asumyi = Arrays.copyOfRange(r3, r2, r2 + 12);
        this.field_40_cChWS = LittleEndian.getInt(r3, r4 + BDAbstractUpload.KeyIsSDKMaxRetryCount);
        this.field_41_cChWSFtnEdn = LittleEndian.getInt(r3, r4 + BDAbstractUpload.KeyIsCustomHttpHeaders);
        this.field_42_grfDocEvents = LittleEndian.getInt(r3, r4 + BDAbstractUpload.KeyIsRetryStatesOption);
        this.field_43_virusinfo = LittleEndian.getInt(r3, r4 + 438);
        int r5 = r4 + UploadKeys.KeyIsGetVideoURI;
        this.field_44_Spare = Arrays.copyOfRange(r3, r5, r5 + 30);
        this.field_45_reserved1 = LittleEndian.getInt(r3, r4 + 472);
        this.field_46_reserved2 = LittleEndian.getInt(r3, r4 + 476);
        this.field_47_cDBC = LittleEndian.getInt(r3, r4 + 480);
        this.field_48_cDBCFtnEdn = LittleEndian.getInt(r3, r4 + 484);
        this.field_49_reserved = LittleEndian.getInt(r3, r4 + 488);
        this.field_50_nfcFtnRef = LittleEndian.getShort(r3, r4 + 492);
        this.field_51_nfcEdnRef = LittleEndian.getShort(r3, r4 + 494);
        this.field_52_hpsZoonFontPag = LittleEndian.getShort(r3, r4 + 496);
        this.field_53_dywDispPag = LittleEndian.getShort(r3, r4 + 498);
    }

    public short getAdt() {
        return this.field_34_adt;
    }

    public byte[] getAsumyi() {
        return this.field_39_asumyi;
    }

    public int getCCh() {
        return this.field_20_cCh;
    }

    public int getCChFtnEdn() {
        return this.field_27_cChFtnEdn;
    }

    public int getCChWS() {
        return this.field_40_cChWS;
    }

    public int getCChWSFtnEdn() {
        return this.field_41_cChWSFtnEdn;
    }

    public int getCConsexHypLim() {
        return this.field_12_cConsexHypLim;
    }

    public int getCDBC() {
        return this.field_47_cDBC;
    }

    public int getCDBCFtnEdn() {
        return this.field_48_cDBCFtnEdn;
    }

    public int getCLines() {
        return this.field_25_cLines;
    }

    public int getCLinesFtnEdn() {
        return this.field_30_cLinesFtnEdn;
    }

    public int getCParas() {
        return this.field_22_cParas;
    }

    public int getCParasFtnEdn() {
        return this.field_29_cParasFtnEdn;
    }

    public int getCPg() {
        return this.field_21_cPg;
    }

    public short getCPgFtnEdn() {
        return this.field_28_cPgFtnEdn;
    }

    public int getCWords() {
        return this.field_19_cWords;
    }

    public int getCWordsFtnEnd() {
        return this.field_26_cWordsFtnEnd;
    }

    public byte getDocinfo() {
        return this.field_5_docinfo;
    }

    public byte getDocinfo1() {
        return this.field_6_docinfo1;
    }

    public byte getDocinfo2() {
        return this.field_7_docinfo2;
    }

    public short getDocinfo3() {
        return this.field_8_docinfo3;
    }

    public int getDocinfo4() {
        return this.field_33_docinfo4;
    }

    public short getDocinfo5() {
        return this.field_37_docinfo5;
    }

    public short getDocinfo6() {
        return this.field_38_docinfo6;
    }

    public byte[] getDogrid() {
        return this.field_36_dogrid;
    }

    public byte[] getDoptypography() {
        return this.field_35_doptypography;
    }

    public int getDttmCreated() {
        return this.field_14_dttmCreated;
    }

    public int getDttmLastPrint() {
        return this.field_16_dttmLastPrint;
    }

    public int getDttmRevised() {
        return this.field_15_dttmRevised;
    }

    public int getDxaHotz() {
        return this.field_11_dxaHotz;
    }

    public int getDxaTab() {
        return this.field_9_dxaTab;
    }

    public short getDywDispPag() {
        return this.field_53_dywDispPag;
    }

    public short getEdn() {
        return this.field_23_Edn;
    }

    public short getEdn1() {
        return this.field_24_Edn1;
    }

    public byte getEpc() {
        return (byte) epc.getValue(this.field_24_Edn1);
    }

    public byte getFOutlineDirtySave() {
        return this.field_4_fOutlineDirtySave;
    }

    public short getFootnoteInfo() {
        return this.field_3_footnoteInfo;
    }

    public byte getFormatFlags() {
        return this.field_1_formatFlags;
    }

    public byte getFpc() {
        return (byte) fpc.getValue(this.field_1_formatFlags);
    }

    public int getGrfDocEvents() {
        return this.field_42_grfDocEvents;
    }

    public byte getGrfSupression() {
        return (byte) grfSupression.getValue(this.field_1_formatFlags);
    }

    public short getHpsZoonFontPag() {
        return this.field_52_hpsZoonFontPag;
    }

    public int getKeyVirusSession30() {
        return KeyVirusSession30.getValue(this.field_43_virusinfo);
    }

    public int getLKeyProtDoc() {
        return this.field_31_lKeyProtDoc;
    }

    public byte getLvl() {
        return (byte) lvl.getValue(this.field_37_docinfo5);
    }

    public short getNEdn() {
        return (short) nEdn.getValue(this.field_23_Edn);
    }

    public short getNFtn() {
        return (short) nFtn.getValue(this.field_3_footnoteInfo);
    }

    public int getNRevision() {
        return this.field_17_nRevision;
    }

    public short getNfcEdnRef() {
        return this.field_51_nfcEdnRef;
    }

    public byte getNfcEdnRef1() {
        return (byte) nfcEdnRef1.getValue(this.field_24_Edn1);
    }

    public short getNfcFtnRef() {
        return this.field_50_nfcFtnRef;
    }

    public byte getNfcFtnRef1() {
        return (byte) nfcFtnRef1.getValue(this.field_24_Edn1);
    }

    public int getReserved() {
        return this.field_49_reserved;
    }

    public int getReserved1() {
        return this.field_45_reserved1;
    }

    public int getReserved2() {
        return this.field_46_reserved2;
    }

    public byte getRncEdn() {
        return (byte) rncEdn.getValue(this.field_23_Edn);
    }

    public byte getRncFtn() {
        return (byte) rncFtn.getValue(this.field_3_footnoteInfo);
    }

    public byte[] getSpare() {
        return this.field_44_Spare;
    }

    public int getTmEdited() {
        return this.field_18_tmEdited;
    }

    public byte getUnused2() {
        return this.field_2_unused2;
    }

    public byte getUnused5() {
        return (byte) unused5.getValue(this.field_8_docinfo3);
    }

    public short getView() {
        return this.field_32_view;
    }

    public int getVirusinfo() {
        return this.field_43_virusinfo;
    }

    public short getWScaleSaved() {
        return (short) wScaleSaved.getValue(this.field_32_view);
    }

    public int getWSpare() {
        return this.field_10_wSpare;
    }

    public int getWSpare2() {
        return this.field_13_wSpare2;
    }

    public byte getWvkSaved() {
        return (byte) wvkSaved.getValue(this.field_32_view);
    }

    public byte getZkSaved() {
        return (byte) zkSaved.getValue(this.field_32_view);
    }

    public boolean isFAutoHyphen() {
        return fAutoHyphen.isSet(this.field_5_docinfo);
    }

    public boolean isFAutoVersions() {
        return fAutoVersions.isSet(this.field_38_docinfo6);
    }

    public boolean isFBackup() {
        return fBackup.isSet(this.field_6_docinfo1);
    }

    public boolean isFConvMailMergeEsc() {
        return fConvMailMergeEsc.isSet(this.field_33_docinfo4);
    }

    public boolean isFDfltTrueType() {
        return fDfltTrueType.isSet(this.field_6_docinfo1);
    }

    public boolean isFDispFormFldSel() {
        return fDispFormFldSel.isSet(this.field_7_docinfo2);
    }

    public boolean isFEmbedFonts() {
        return fEmbedFonts.isSet(this.field_7_docinfo2);
    }

    public boolean isFExactCWords() {
        return fExactCWords.isSet(this.field_6_docinfo1);
    }

    public boolean isFFacingPages() {
        return fFacingPages.isSet(this.field_1_formatFlags);
    }

    public boolean isFForcePageSizePag() {
        return fForcePageSizePag.isSet(this.field_37_docinfo5);
    }

    public boolean isFFormNoFields() {
        return fFormNoFields.isSet(this.field_5_docinfo);
    }

    public boolean isFGramAllClean() {
        return fGramAllClean.isSet(this.field_37_docinfo5);
    }

    public boolean isFGramAllDone() {
        return fGramAllDone.isSet(this.field_37_docinfo5);
    }

    public boolean isFHaveVersions() {
        return fHaveVersions.isSet(this.field_38_docinfo6);
    }

    public boolean isFHideLastVersion() {
        return fHideLastVersion.isSet(this.field_37_docinfo5);
    }

    public boolean isFHtmlDoc() {
        return fHtmlDoc.isSet(this.field_37_docinfo5);
    }

    public boolean isFHyphCapitals() {
        return fHyphCapitals.isSet(this.field_5_docinfo);
    }

    public boolean isFIncludeFooter() {
        return fIncludeFooter.isSet(this.field_37_docinfo5);
    }

    public boolean isFIncludeHeader() {
        return fIncludeHeader.isSet(this.field_37_docinfo5);
    }

    public boolean isFLabelDoc() {
        return fLabelDoc.isSet(this.field_5_docinfo);
    }

    public boolean isFLinkStyles() {
        return fLinkStyles.isSet(this.field_5_docinfo);
    }

    public boolean isFLockAtn() {
        return fLockAtn.isSet(this.field_6_docinfo1);
    }

    public boolean isFLockRev() {
        return fLockRev.isSet(this.field_7_docinfo2);
    }

    public boolean isFMWSmallCaps() {
        return fMWSmallCaps.isSet(this.field_33_docinfo4);
    }

    public boolean isFMapPrintTextColor() {
        return fMapPrintTextColor.isSet(this.field_33_docinfo4);
    }

    public boolean isFMinFontSizePag() {
        return fMinFontSizePag.isSet(this.field_37_docinfo5);
    }

    public boolean isFMirrorMargins() {
        return fMirrorMargins.isSet(this.field_6_docinfo1);
    }

    public boolean isFNoColumnBalance() {
        return fNoColumnBalance.isSet(this.field_33_docinfo4);
    }

    public boolean isFNoLeading() {
        return fNoLeading.isSet(this.field_33_docinfo4);
    }

    public boolean isFNoSpaceRaiseLower() {
        return fNoSpaceRaiseLower.isSet(this.field_33_docinfo4);
    }

    public boolean isFNoTabForInd() {
        return fNoTabForInd.isSet(this.field_33_docinfo4);
    }

    public boolean isFOnlyMacPics() {
        return fOnlyMacPics.isSet(this.field_5_docinfo);
    }

    public boolean isFOnlyWinPics() {
        return fOnlyWinPics.isSet(this.field_5_docinfo);
    }

    public boolean isFOrigWordTableRules() {
        return fOrigWordTableRules.isSet(this.field_33_docinfo4);
    }

    public boolean isFPMHMainDoc() {
        return fPMHMainDoc.isSet(this.field_1_formatFlags);
    }

    public boolean isFPagHidden() {
        return fPagHidden.isSet(this.field_6_docinfo1);
    }

    public boolean isFPagResults() {
        return fPagResults.isSet(this.field_6_docinfo1);
    }

    public boolean isFPagSupressTopSpacing() {
        return fPagSupressTopSpacing.isSet(this.field_7_docinfo2);
    }

    public boolean isFPrintBodyBeforeHdr() {
        return fPrintBodyBeforeHdr.isSet(this.field_33_docinfo4);
    }

    public boolean isFPrintFormData() {
        return fPrintFormData.isSet(this.field_24_Edn1);
    }

    public boolean isFProtEnabled() {
        return fProtEnabled.isSet(this.field_7_docinfo2);
    }

    public boolean isFRMPrint() {
        return fRMPrint.isSet(this.field_7_docinfo2);
    }

    public boolean isFRMView() {
        return fRMView.isSet(this.field_7_docinfo2);
    }

    public boolean isFRevMarking() {
        return fRevMarking.isSet(this.field_5_docinfo);
    }

    public boolean isFRotateFontW6() {
        return fRotateFontW6.isSet(this.field_32_view);
    }

    public boolean isFSaveFormData() {
        return fSaveFormData.isSet(this.field_24_Edn1);
    }

    public boolean isFShadeFormData() {
        return fShadeFormData.isSet(this.field_24_Edn1);
    }

    public boolean isFShowBreaksInFrames() {
        return fShowBreaksInFrames.isSet(this.field_33_docinfo4);
    }

    public boolean isFSnapBorder() {
        return fSnapBorder.isSet(this.field_37_docinfo5);
    }

    public boolean isFSubsetFonts() {
        return fSubsetFonts.isSet(this.field_37_docinfo5);
    }

    public boolean isFSuppressTopSPacingMac5() {
        return fSuppressTopSPacingMac5.isSet(this.field_33_docinfo4);
    }

    public boolean isFSupressSpdfAfterPageBreak() {
        return fSupressSpdfAfterPageBreak.isSet(this.field_33_docinfo4);
    }

    public boolean isFSupressTopSpacing() {
        return fSupressTopSpacing.isSet(this.field_33_docinfo4);
    }

    public boolean isFSwapBordersFacingPgs() {
        return fSwapBordersFacingPgs.isSet(this.field_33_docinfo4);
    }

    public boolean isFTransparentMetafiles() {
        return fTransparentMetafiles.isSet(this.field_33_docinfo4);
    }

    public boolean isFTruncDxaExpand() {
        return fTruncDxaExpand.isSet(this.field_33_docinfo4);
    }

    public boolean isFVirusLoadSafe() {
        return fVirusLoadSafe.isSet(this.field_43_virusinfo);
    }

    public boolean isFVirusPrompted() {
        return fVirusPrompted.isSet(this.field_43_virusinfo);
    }

    public boolean isFWCFtnEdn() {
        return fWCFtnEdn.isSet(this.field_24_Edn1);
    }

    public boolean isFWidowControl() {
        return fWidowControl.isSet(this.field_1_formatFlags);
    }

    public boolean isFWrapTrailSpaces() {
        return fWrapTrailSpaces.isSet(this.field_33_docinfo4);
    }

    public boolean isIGutterPos() {
        return iGutterPos.isSet(this.field_32_view);
    }

    public boolean isOldfConvMailMergeEsc() {
        return oldfConvMailMergeEsc.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfMapPrintTextColor() {
        return oldfMapPrintTextColor.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfNoColumnBalance() {
        return oldfNoColumnBalance.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfNoSpaceRaiseLower() {
        return oldfNoSpaceRaiseLower.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfNoTabForInd() {
        return oldfNoTabForInd.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfOrigWordTableRules() {
        return oldfOrigWordTableRules.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfShowBreaksInFrames() {
        return oldfShowBreaksInFrames.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfSuppressSpbfAfterPageBreak() {
        return oldfSuppressSpbfAfterPageBreak.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfSupressTopSpacing() {
        return oldfSupressTopSpacing.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfSwapBordersFacingPgs() {
        return oldfSwapBordersFacingPgs.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfTransparentMetafiles() {
        return oldfTransparentMetafiles.isSet(this.field_8_docinfo3);
    }

    public boolean isOldfWrapTrailSpaces() {
        return oldfWrapTrailSpaces.isSet(this.field_8_docinfo3);
    }

    public boolean isUnused1() {
        return unused1.isSet(this.field_1_formatFlags);
    }

    public boolean isUnused3() {
        return unused3.isSet(this.field_6_docinfo1);
    }

    public boolean isUnused4() {
        return unused4.isSet(this.field_7_docinfo2);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[DOP]\n");
        r0.append("    .formatFlags          = ");
        r0.append(" (").append(getFormatFlags()).append(" )\n");
        r0.append("         .fFacingPages             = ").append(isFFacingPages()).append('\n');
        r0.append("         .fWidowControl            = ").append(isFWidowControl()).append('\n');
        r0.append("         .fPMHMainDoc              = ").append(isFPMHMainDoc()).append('\n');
        r0.append("         .grfSupression            = ").append(getGrfSupression()).append('\n');
        r0.append("         .fpc                      = ").append(getFpc()).append('\n');
        r0.append("         .unused1                  = ").append(isUnused1()).append('\n');
        r0.append("    .unused2              = ");
        r0.append(" (").append(getUnused2()).append(" )\n");
        r0.append("    .footnoteInfo         = ");
        r0.append(" (").append(getFootnoteInfo()).append(" )\n");
        r0.append("         .rncFtn                   = ").append(getRncFtn()).append('\n');
        r0.append("         .nFtn                     = ").append(getNFtn()).append('\n');
        r0.append("    .fOutlineDirtySave    = ");
        r0.append(" (").append(getFOutlineDirtySave()).append(" )\n");
        r0.append("    .docinfo              = ");
        r0.append(" (").append(getDocinfo()).append(" )\n");
        r0.append("         .fOnlyMacPics             = ").append(isFOnlyMacPics()).append('\n');
        r0.append("         .fOnlyWinPics             = ").append(isFOnlyWinPics()).append('\n');
        r0.append("         .fLabelDoc                = ").append(isFLabelDoc()).append('\n');
        r0.append("         .fHyphCapitals            = ").append(isFHyphCapitals()).append('\n');
        r0.append("         .fAutoHyphen              = ").append(isFAutoHyphen()).append('\n');
        r0.append("         .fFormNoFields            = ").append(isFFormNoFields()).append('\n');
        r0.append("         .fLinkStyles              = ").append(isFLinkStyles()).append('\n');
        r0.append("         .fRevMarking              = ").append(isFRevMarking()).append('\n');
        r0.append("    .docinfo1             = ");
        r0.append(" (").append(getDocinfo1()).append(" )\n");
        r0.append("         .fBackup                  = ").append(isFBackup()).append('\n');
        r0.append("         .fExactCWords             = ").append(isFExactCWords()).append('\n');
        r0.append("         .fPagHidden               = ").append(isFPagHidden()).append('\n');
        r0.append("         .fPagResults              = ").append(isFPagResults()).append('\n');
        r0.append("         .fLockAtn                 = ").append(isFLockAtn()).append('\n');
        r0.append("         .fMirrorMargins           = ").append(isFMirrorMargins()).append('\n');
        r0.append("         .unused3                  = ").append(isUnused3()).append('\n');
        r0.append("         .fDfltTrueType            = ").append(isFDfltTrueType()).append('\n');
        r0.append("    .docinfo2             = ");
        r0.append(" (").append(getDocinfo2()).append(" )\n");
        r0.append("         .fPagSupressTopSpacing     = ").append(isFPagSupressTopSpacing()).append('\n');
        r0.append("         .fProtEnabled             = ").append(isFProtEnabled()).append('\n');
        r0.append("         .fDispFormFldSel          = ").append(isFDispFormFldSel()).append('\n');
        r0.append("         .fRMView                  = ").append(isFRMView()).append('\n');
        r0.append("         .fRMPrint                 = ").append(isFRMPrint()).append('\n');
        r0.append("         .unused4                  = ").append(isUnused4()).append('\n');
        r0.append("         .fLockRev                 = ").append(isFLockRev()).append('\n');
        r0.append("         .fEmbedFonts              = ").append(isFEmbedFonts()).append('\n');
        r0.append("    .docinfo3             = ");
        r0.append(" (").append(getDocinfo3()).append(" )\n");
        r0.append("         .oldfNoTabForInd          = ").append(isOldfNoTabForInd()).append('\n');
        r0.append("         .oldfNoSpaceRaiseLower     = ").append(isOldfNoSpaceRaiseLower()).append('\n');
        r0.append("         .oldfSuppressSpbfAfterPageBreak     = ").append(isOldfSuppressSpbfAfterPageBreak()).append('\n');
        r0.append("         .oldfWrapTrailSpaces      = ").append(isOldfWrapTrailSpaces()).append('\n');
        r0.append("         .oldfMapPrintTextColor     = ").append(isOldfMapPrintTextColor()).append('\n');
        r0.append("         .oldfNoColumnBalance      = ").append(isOldfNoColumnBalance()).append('\n');
        r0.append("         .oldfConvMailMergeEsc     = ").append(isOldfConvMailMergeEsc()).append('\n');
        r0.append("         .oldfSupressTopSpacing     = ").append(isOldfSupressTopSpacing()).append('\n');
        r0.append("         .oldfOrigWordTableRules     = ").append(isOldfOrigWordTableRules()).append('\n');
        r0.append("         .oldfTransparentMetafiles     = ").append(isOldfTransparentMetafiles()).append('\n');
        r0.append("         .oldfShowBreaksInFrames     = ").append(isOldfShowBreaksInFrames()).append('\n');
        r0.append("         .oldfSwapBordersFacingPgs     = ").append(isOldfSwapBordersFacingPgs()).append('\n');
        r0.append("         .unused5                  = ").append(getUnused5()).append('\n');
        r0.append("    .dxaTab               = ");
        r0.append(" (").append(getDxaTab()).append(" )\n");
        r0.append("    .wSpare               = ");
        r0.append(" (").append(getWSpare()).append(" )\n");
        r0.append("    .dxaHotz              = ");
        r0.append(" (").append(getDxaHotz()).append(" )\n");
        r0.append("    .cConsexHypLim        = ");
        r0.append(" (").append(getCConsexHypLim()).append(" )\n");
        r0.append("    .wSpare2              = ");
        r0.append(" (").append(getWSpare2()).append(" )\n");
        r0.append("    .dttmCreated          = ");
        r0.append(" (").append(getDttmCreated()).append(" )\n");
        r0.append("    .dttmRevised          = ");
        r0.append(" (").append(getDttmRevised()).append(" )\n");
        r0.append("    .dttmLastPrint        = ");
        r0.append(" (").append(getDttmLastPrint()).append(" )\n");
        r0.append("    .nRevision            = ");
        r0.append(" (").append(getNRevision()).append(" )\n");
        r0.append("    .tmEdited             = ");
        r0.append(" (").append(getTmEdited()).append(" )\n");
        r0.append("    .cWords               = ");
        r0.append(" (").append(getCWords()).append(" )\n");
        r0.append("    .cCh                  = ");
        r0.append(" (").append(getCCh()).append(" )\n");
        r0.append("    .cPg                  = ");
        r0.append(" (").append(getCPg()).append(" )\n");
        r0.append("    .cParas               = ");
        r0.append(" (").append(getCParas()).append(" )\n");
        r0.append("    .Edn                  = ");
        r0.append(" (").append(getEdn()).append(" )\n");
        r0.append("         .rncEdn                   = ").append(getRncEdn()).append('\n');
        r0.append("         .nEdn                     = ").append(getNEdn()).append('\n');
        r0.append("    .Edn1                 = ");
        r0.append(" (").append(getEdn1()).append(" )\n");
        r0.append("         .epc                      = ").append(getEpc()).append('\n');
        r0.append("         .nfcFtnRef1               = ").append(getNfcFtnRef1()).append('\n');
        r0.append("         .nfcEdnRef1               = ").append(getNfcEdnRef1()).append('\n');
        r0.append("         .fPrintFormData           = ").append(isFPrintFormData()).append('\n');
        r0.append("         .fSaveFormData            = ").append(isFSaveFormData()).append('\n');
        r0.append("         .fShadeFormData           = ").append(isFShadeFormData()).append('\n');
        r0.append("         .fWCFtnEdn                = ").append(isFWCFtnEdn()).append('\n');
        r0.append("    .cLines               = ");
        r0.append(" (").append(getCLines()).append(" )\n");
        r0.append("    .cWordsFtnEnd         = ");
        r0.append(" (").append(getCWordsFtnEnd()).append(" )\n");
        r0.append("    .cChFtnEdn            = ");
        r0.append(" (").append(getCChFtnEdn()).append(" )\n");
        r0.append("    .cPgFtnEdn            = ");
        r0.append(" (").append(getCPgFtnEdn()).append(" )\n");
        r0.append("    .cParasFtnEdn         = ");
        r0.append(" (").append(getCParasFtnEdn()).append(" )\n");
        r0.append("    .cLinesFtnEdn         = ");
        r0.append(" (").append(getCLinesFtnEdn()).append(" )\n");
        r0.append("    .lKeyProtDoc          = ");
        r0.append(" (").append(getLKeyProtDoc()).append(" )\n");
        r0.append("    .view                 = ");
        r0.append(" (").append(getView()).append(" )\n");
        r0.append("         .wvkSaved                 = ").append(getWvkSaved()).append('\n');
        r0.append("         .wScaleSaved              = ").append(getWScaleSaved()).append('\n');
        r0.append("         .zkSaved                  = ").append(getZkSaved()).append('\n');
        r0.append("         .fRotateFontW6            = ").append(isFRotateFontW6()).append('\n');
        r0.append("         .iGutterPos               = ").append(isIGutterPos()).append('\n');
        r0.append("    .docinfo4             = ");
        r0.append(" (").append(getDocinfo4()).append(" )\n");
        r0.append("         .fNoTabForInd             = ").append(isFNoTabForInd()).append('\n');
        r0.append("         .fNoSpaceRaiseLower       = ").append(isFNoSpaceRaiseLower()).append('\n');
        r0.append("         .fSupressSpdfAfterPageBreak     = ").append(isFSupressSpdfAfterPageBreak()).append('\n');
        r0.append("         .fWrapTrailSpaces         = ").append(isFWrapTrailSpaces()).append('\n');
        r0.append("         .fMapPrintTextColor       = ").append(isFMapPrintTextColor()).append('\n');
        r0.append("         .fNoColumnBalance         = ").append(isFNoColumnBalance()).append('\n');
        r0.append("         .fConvMailMergeEsc        = ").append(isFConvMailMergeEsc()).append('\n');
        r0.append("         .fSupressTopSpacing       = ").append(isFSupressTopSpacing()).append('\n');
        r0.append("         .fOrigWordTableRules      = ").append(isFOrigWordTableRules()).append('\n');
        r0.append("         .fTransparentMetafiles     = ").append(isFTransparentMetafiles()).append('\n');
        r0.append("         .fShowBreaksInFrames      = ").append(isFShowBreaksInFrames()).append('\n');
        r0.append("         .fSwapBordersFacingPgs     = ").append(isFSwapBordersFacingPgs()).append('\n');
        r0.append("         .fSuppressTopSPacingMac5     = ").append(isFSuppressTopSPacingMac5()).append('\n');
        r0.append("         .fTruncDxaExpand          = ").append(isFTruncDxaExpand()).append('\n');
        r0.append("         .fPrintBodyBeforeHdr      = ").append(isFPrintBodyBeforeHdr()).append('\n');
        r0.append("         .fNoLeading               = ").append(isFNoLeading()).append('\n');
        r0.append("         .fMWSmallCaps             = ").append(isFMWSmallCaps()).append('\n');
        r0.append("    .adt                  = ");
        r0.append(" (").append(getAdt()).append(" )\n");
        r0.append("    .doptypography        = ");
        r0.append(" (").append(Arrays.toString(getDoptypography())).append(" )\n");
        r0.append("    .dogrid               = ");
        r0.append(" (").append(Arrays.toString(getDogrid())).append(" )\n");
        r0.append("    .docinfo5             = ");
        r0.append(" (").append(getDocinfo5()).append(" )\n");
        r0.append("         .lvl                      = ").append(getLvl()).append('\n');
        r0.append("         .fGramAllDone             = ").append(isFGramAllDone()).append('\n');
        r0.append("         .fGramAllClean            = ").append(isFGramAllClean()).append('\n');
        r0.append("         .fSubsetFonts             = ").append(isFSubsetFonts()).append('\n');
        r0.append("         .fHideLastVersion         = ").append(isFHideLastVersion()).append('\n');
        r0.append("         .fHtmlDoc                 = ").append(isFHtmlDoc()).append('\n');
        r0.append("         .fSnapBorder              = ").append(isFSnapBorder()).append('\n');
        r0.append("         .fIncludeHeader           = ").append(isFIncludeHeader()).append('\n');
        r0.append("         .fIncludeFooter           = ").append(isFIncludeFooter()).append('\n');
        r0.append("         .fForcePageSizePag        = ").append(isFForcePageSizePag()).append('\n');
        r0.append("         .fMinFontSizePag          = ").append(isFMinFontSizePag()).append('\n');
        r0.append("    .docinfo6             = ");
        r0.append(" (").append(getDocinfo6()).append(" )\n");
        r0.append("         .fHaveVersions            = ").append(isFHaveVersions()).append('\n');
        r0.append("         .fAutoVersions            = ").append(isFAutoVersions()).append('\n');
        r0.append("    .asumyi               = ");
        r0.append(" (").append(Arrays.toString(getAsumyi())).append(" )\n");
        r0.append("    .cChWS                = ");
        r0.append(" (").append(getCChWS()).append(" )\n");
        r0.append("    .cChWSFtnEdn          = ");
        r0.append(" (").append(getCChWSFtnEdn()).append(" )\n");
        r0.append("    .grfDocEvents         = ");
        r0.append(" (").append(getGrfDocEvents()).append(" )\n");
        r0.append("    .virusinfo            = ");
        r0.append(" (").append(getVirusinfo()).append(" )\n");
        r0.append("         .fVirusPrompted           = ").append(isFVirusPrompted()).append('\n');
        r0.append("         .fVirusLoadSafe           = ").append(isFVirusLoadSafe()).append('\n');
        r0.append("         .KeyVirusSession30        = ").append(getKeyVirusSession30()).append('\n');
        r0.append("    .Spare                = ");
        r0.append(" (").append(Arrays.toString(getSpare())).append(" )\n");
        r0.append("    .reserved1            = ");
        r0.append(" (").append(getReserved1()).append(" )\n");
        r0.append("    .reserved2            = ");
        r0.append(" (").append(getReserved2()).append(" )\n");
        r0.append("    .cDBC                 = ");
        r0.append(" (").append(getCDBC()).append(" )\n");
        r0.append("    .cDBCFtnEdn           = ");
        r0.append(" (").append(getCDBCFtnEdn()).append(" )\n");
        r0.append("    .reserved             = ");
        r0.append(" (").append(getReserved()).append(" )\n");
        r0.append("    .nfcFtnRef            = ");
        r0.append(" (").append(getNfcFtnRef()).append(" )\n");
        r0.append("    .nfcEdnRef            = ");
        r0.append(" (").append(getNfcEdnRef()).append(" )\n");
        r0.append("    .hpsZoonFontPag       = ");
        r0.append(" (").append(getHpsZoonFontPag()).append(" )\n");
        r0.append("    .dywDispPag           = ");
        r0.append(" (").append(getDywDispPag()).append(" )\n");
        r0.append("[/DOP]\n");
        return r0.toString();
    }
}
