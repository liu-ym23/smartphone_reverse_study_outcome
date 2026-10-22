package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSplitMenuColorsRecord;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BackupRecord;
import org.apache.poi.hssf.record.BookBoolRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.CodepageRecord;
import org.apache.poi.hssf.record.CountryRecord;
import org.apache.poi.hssf.record.DSFRecord;
import org.apache.poi.hssf.record.DateWindow1904Record;
import org.apache.poi.hssf.record.DrawingGroupRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.ExtSSTRecord;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FileSharingRecord;
import org.apache.poi.hssf.record.FnGroupCountRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.hssf.record.HideObjRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.InterfaceEndRecord;
import org.apache.poi.hssf.record.InterfaceHdrRecord;
import org.apache.poi.hssf.record.MMSRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.PasswordRev4Record;
import org.apache.poi.hssf.record.PrecisionRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.ProtectionRev4Record;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RefreshAllRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.TabIdRecord;
import org.apache.poi.hssf.record.UseSelFSRecord;
import org.apache.poi.hssf.record.WindowOneRecord;
import org.apache.poi.hssf.record.WindowProtectRecord;
import org.apache.poi.hssf.record.WriteAccessRecord;
import org.apache.poi.hssf.record.WriteProtectRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class InternalWorkbook {
    private static final c LOG = null;
    public static final List<String> WORKBOOK_DIR_ENTRY_NAMES = null;
    private final List<BoundSheetRecord> boundsheets;
    private final Map<String, NameCommentRecord> commentRecords;
    private DrawingManager2 drawingManager;
    private final List<EscherBSERecord> escherBSERecords;
    private FileSharingRecord fileShare;
    private final List<FormatRecord> formats;
    private final List<HyperlinkRecord> hyperlinks;
    private LinkTable linkTable;
    private int maxformatid;
    private int numfonts;
    private int numxfs;
    private final WorkbookRecordList records;
    protected SSTRecord sst;
    private boolean uses1904datewindowing;
    private WindowOneRecord windowOne;
    private WriteAccessRecord writeAccess;
    private WriteProtectRecord writeProtect;

    static {
        WORKBOOK_DIR_ENTRY_NAMES = Collections.unmodifiableList(Arrays.asList(new String[]{"Workbook", "WORKBOOK", "BOOK", "WorkBook"}));
        LOG = b.a(InternalWorkbook.class);
    }

    private InternalWorkbook() {
        this.records = new WorkbookRecordList();
        this.boundsheets = new ArrayList();
        this.formats = new ArrayList();
        this.hyperlinks = new ArrayList();
        this.numxfs = 0;
        this.numfonts = 0;
        this.maxformatid = -1;
        this.uses1904datewindowing = false;
        this.escherBSERecords = new ArrayList();
        this.commentRecords = new LinkedHashMap();
    }

    private void checkSheets(int r4) {
        if (this.boundsheets.size() <= r4) goto L5;
        return;
    L5:
        if ((this.boundsheets.size() + 1) <= r4) goto L8;
        BoundSheetRecord r0 = createBoundSheet(r4);
        WorkbookRecordList r1 = this.records;
        r1.add(r1.getBspos() + 1, r0);
        WorkbookRecordList r2 = this.records;
        r2.setBspos(r2.getBspos() + 1);
        this.boundsheets.add(r0);
        getOrCreateLinkTable().checkExternSheet(r4);
        fixTabIdRecord();
        return;
    L8:
        throw new RuntimeException("Sheet number out of bounds!");
    }

    private static BOFRecord createBOF() {
        BOFRecord r0 = new BOFRecord();
        r0.setVersion(1536);
        r0.setType(5);
        r0.setBuild(4307);
        r0.setBuildYear(1996);
        r0.setHistoryBitMask(65);
        r0.setRequiredVersion(6);
        return r0;
    }

    private static BackupRecord createBackup() {
        BackupRecord r0 = new BackupRecord();
        r0.setBackup(0);
        return r0;
    }

    private static BookBoolRecord createBookBool() {
        BookBoolRecord r0 = new BookBoolRecord();
        r0.setSaveLinkValues(0);
        return r0;
    }

    private static BoundSheetRecord createBoundSheet(int r3) {
        return new BoundSheetRecord("Sheet" + (r3 + 1));
    }

    private static CodepageRecord createCodepage() {
        CodepageRecord r0 = new CodepageRecord();
        r0.setCodepage(1200);
        return r0;
    }

    private static CountryRecord createCountry() {
        CountryRecord r0 = new CountryRecord();
        short r1 = 1;
        r0.setDefaultCountry(1);
        if ("ru_RU".equals(LocaleUtil.getUserLocale().toString()) == false) goto L5;
        r1 = 7;
    L5:
        r0.setCurrentCountry(r1);
        return r0;
    }

    private static DSFRecord createDSF() {
        return new DSFRecord(false);
    }

    private static DateWindow1904Record createDateWindow1904() {
        DateWindow1904Record r0 = new DateWindow1904Record();
        r0.setWindowing(0);
        return r0;
    }

    private static ExtendedFormatRecord createExtendedFormat(int r8) {
        switch(r8) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L29;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            case 13: goto L29;
            case 14: goto L29;
            case 15: goto L27;
            case 16: goto L25;
            case 17: goto L23;
            case 18: goto L21;
            case 19: goto L19;
            case 20: goto L17;
            case 21: goto L15;
            case 22: goto L13;
            case 23: goto L11;
            case 24: goto L9;
            case 25: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("Unrecognized format id: " + r8);
    L7:
        return createExtendedFormat(6, 8, 1, 23552);
    L9:
        return createExtendedFormat(0, 8, 1, 23552);
    L11:
        return createExtendedFormat(0, 49, 1, 23552);
    L13:
        return createExtendedFormat(6, 0, 1, 23552);
    L15:
        return createExtendedFormat(5, 0, 1, 2048);
    L17:
        return createExtendedFormat(1, 9, -11, -2048);
    L19:
        return createExtendedFormat(1, 42, -11, -2048);
    L21:
        return createExtendedFormat(1, 44, -11, -2048);
    L23:
        return createExtendedFormat(1, 41, -11, -2048);
    L25:
        return createExtendedFormat(1, 43, -11, -2048);
    L27:
        return createExtendedFormat(0, 0, 1, 0);
    L29:
        return createExtendedFormat(0, 0, -11, -3072);
    L31:
        return createExtendedFormat(2, 0, -11, -3072);
    L33:
        return createExtendedFormat(1, 0, -11, -3072);
    L35:
        return createExtendedFormat(0, 0, -11, 0);
    }

    private static ExtendedFormatRecord createExtendedFormat(int r1, int r2, int r3, int r4) {
        ExtendedFormatRecord r0 = new ExtendedFormatRecord();
        r0.setFontIndex((short) r1);
        r0.setFormatIndex((short) r2);
        r0.setCellOptions((short) r3);
        r0.setAlignmentOptions(32);
        r0.setIndentionOptions((short) r4);
        r0.setBorderOptions(0);
        r0.setPaletteOptions(0);
        r0.setAdtlPaletteOptions(0);
        r0.setFillPaletteOptions(8384);
        return r0;
    }

    private static ExtSSTRecord createExtendedSST() {
        ExtSSTRecord r0 = new ExtSSTRecord();
        r0.setNumStringsPerBucket(8);
        return r0;
    }

    private static FnGroupCountRecord createFnGroupCount() {
        FnGroupCountRecord r0 = new FnGroupCountRecord();
        r0.setCount(14);
        return r0;
    }

    private static FontRecord createFont() {
        FontRecord r0 = new FontRecord();
        r0.setFontHeight(200);
        r0.setAttributes(0);
        r0.setColorPaletteIndex(ShortCompanionObject.MAX_VALUE);
        r0.setBoldWeight(400);
        r0.setFontName("Arial");
        return r0;
    }

    private static FormatRecord createFormat(int r3) {
        int[] r1 = {5, 6, 7, 8, 42, 41, 44, 43};
        if (r3 < 0) goto L8;
        if (r3 >= 8) goto L8;
        return new FormatRecord(r1[r3], BuiltinFormats.getBuiltinFormat(r1[r3]));
    L8:
        throw new IllegalArgumentException("Unexpected id " + r3);
    }

    private static HideObjRecord createHideObj() {
        HideObjRecord r0 = new HideObjRecord();
        r0.setHideObj(0);
        return r0;
    }

    private static MMSRecord createMMS() {
        MMSRecord r0 = new MMSRecord();
        r0.setAddMenuCount((byte) 0);
        r0.setDelMenuCount((byte) 0);
        return r0;
    }

    private static PasswordRecord createPassword() {
        return new PasswordRecord(0);
    }

    private static PasswordRev4Record createPasswordRev4() {
        return new PasswordRev4Record(0);
    }

    private static PrecisionRecord createPrecision() {
        PrecisionRecord r0 = new PrecisionRecord();
        r0.setFullPrecision(true);
        return r0;
    }

    private static ProtectRecord createProtect() {
        return new ProtectRecord(false);
    }

    private static ProtectionRev4Record createProtectionRev4() {
        return new ProtectionRev4Record(false);
    }

    private static RefreshAllRecord createRefreshAll() {
        return new RefreshAllRecord(false);
    }

    private static StyleRecord createStyle(int r7) {
        int[][] r1 = {new int[]{16, 3}, new int[]{17, 6}, new int[]{18, 4}, new int[]{19, 7}, new int[]{0, 0}, new int[]{20, 5}};
        if (r7 < 0) goto L8;
        if (r7 >= 6) goto L8;
        StyleRecord r0 = new StyleRecord();
        r0.setOutlineStyleLevel(-1);
        r0.setXFIndex(r1[r7][0]);
        r0.setBuiltinStyle(r1[r7][1]);
        return r0;
    L8:
        throw new IllegalArgumentException("Unexpected style id " + r7);
    }

    private static TabIdRecord createTabId() {
        return new TabIdRecord();
    }

    private static UseSelFSRecord createUseSelFS() {
        return new UseSelFSRecord(false);
    }

    private static WindowOneRecord createWindowOne() {
        WindowOneRecord r0 = new WindowOneRecord();
        r0.setHorizontalHold(360);
        r0.setVerticalHold(270);
        r0.setWidth(14940);
        r0.setHeight(9150);
        r0.setOptions(56);
        r0.setActiveSheetIndex(0);
        r0.setFirstVisibleTab(0);
        r0.setNumSelectedTabs(1);
        r0.setTabWidthRatio(600);
        return r0;
    }

    private static WindowProtectRecord createWindowProtect() {
        return new WindowProtectRecord(false);
    }

    public static InternalWorkbook createWorkbook() {
        LOG.atDebug().a("creating new workbook from scratch");
        InternalWorkbook r0 = new InternalWorkbook();
        ArrayList r1 = new ArrayList(30);
        r0.records.setRecords(r1);
        List<FormatRecord> r2 = r0.formats;
        r1.add(createBOF());
        r1.add(new InterfaceHdrRecord(1200));
        r1.add(createMMS());
        r1.add(InterfaceEndRecord.instance);
        r0.getWriteAccess();
        r1.add(createCodepage());
        r1.add(createDSF());
        r1.add(createTabId());
        r0.records.setTabpos(r1.size() - 1);
        r1.add(createFnGroupCount());
        r1.add(createWindowProtect());
        r1.add(createProtect());
        r0.records.setProtpos(r1.size() - 1);
        r1.add(createPassword());
        r1.add(createProtectionRev4());
        r1.add(createPasswordRev4());
        WindowOneRecord r3 = createWindowOne();
        r0.windowOne = r3;
        r1.add(r3);
        r1.add(createBackup());
        r0.records.setBackuppos(r1.size() - 1);
        r1.add(createHideObj());
        r1.add(createDateWindow1904());
        r1.add(createPrecision());
        r1.add(createRefreshAll());
        r1.add(createBookBool());
        r1.add(createFont());
        r1.add(createFont());
        r1.add(createFont());
        r1.add(createFont());
        r0.records.setFontpos(r1.size() - 1);
        r0.numfonts = 4;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r5 > 7) goto L6;
        FormatRecord r6 = createFormat(r5);
        r0.maxformatid = Math.max(r0.maxformatid, r6.getIndexCode());
        r2.add(r6);
        r1.add(r6);
        r5 = r5 + 1;
        goto L4
    L6:
        int r7 = 0;
    L8:
        if (r7 >= 21) goto L10;
        r1.add(createExtendedFormat(r7));
        r0.numxfs++;
        r7 = r7 + 1;
        goto L8
    L10:
        r0.records.setXfpos(r1.size() - 1);
        int r8 = 0;
    L12:
        if (r8 >= 6) goto L14;
        r1.add(createStyle(r8));
        r8 = r8 + 1;
        goto L12
    L14:
        r1.add(createUseSelFS());
        int r9 = 0;
    L15:
        if (r9 >= 1) goto L17;
        BoundSheetRecord r10 = createBoundSheet(r9);
        r1.add(r10);
        r0.boundsheets.add(r10);
        r0.records.setBspos(r1.size() - 1);
        r9 = r9 + 1;
        goto L15
    L17:
        r1.add(createCountry());
    L18:
        if (r4 >= 1) goto L20;
        r0.getOrCreateLinkTable().checkExternSheet(r4);
        r4 = r4 + 1;
        goto L18
    L20:
        SSTRecord r11 = new SSTRecord();
        r0.sst = r11;
        r1.add(r11);
        r1.add(createExtendedSST());
        r1.add(EOFRecord.instance);
        LOG.atDebug().a("exit create new workbook from scratch");
        return r0;
    }

    public static InternalWorkbook createWorkbook(List<Record> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        LOG.atDebug().a("Workbook (readfile) created with reclen={}", v.a(r13.size()));
        InternalWorkbook r0 = new InternalWorkbook();
        ArrayList r2 = new ArrayList(r13.size() / 3);
        r0.records.setRecords(r2);
        int r4 = 0;
        boolean r5 = false;
    L4:
        if (r4 >= r13.size()) goto L39;
        Record r6 = (Record) ZeusTransformUtils.preCheckCast(r13.get(r4), Record.class, "com.obric.memorydata.plugin");
        switch(r6.getSid()) {
            case 10: goto L31;
            case 18: goto L30;
            case 23: goto L29;
            case 24: goto L27;
            case 34: goto L23;
            case 49: goto L21;
            case 61: goto L20;
            case 64: goto L19;
            case 91: goto L18;
            case 92: goto L17;
            case 133: goto L16;
            case 134: goto L15;
            case 146: goto L14;
            case 224: goto L13;
            case 252: goto L12;
            case 317: goto L11;
            case 430: goto L27;
            case 440: goto L10;
            case 1054: goto L9;
            case 2196: goto L8;
            default: goto L7;
        };
    L7:
        String r7 = "(sid=" + r6.getSid() + ")";
    L32:
        if (r5 == true) goto L34;
        r2.add(r6);
    L34:
        LOG.atTrace().a("found {} record at {}", r7, v.a(r4));
        if (r6.getSid() != 10) goto L37;
        r5 = true;
    L37:
        r4 = r4 + 1;
        goto L4
    L8:
        NameCommentRecord r8 = (NameCommentRecord) ZeusTransformUtils.preCheckCast(r6, NameCommentRecord.class, "com.obric.memorydata.plugin");
        r0.commentRecords.put(r8.getNameText(), r8);
        r7 = "NameComment";
        goto L32
    L9:
        FormatRecord r9 = (FormatRecord) ZeusTransformUtils.preCheckCast(r6, FormatRecord.class, "com.obric.memorydata.plugin");
        r0.formats.add(r9);
        r0.maxformatid = Math.max(r0.maxformatid, r9.getIndexCode());
        r7 = "format";
        goto L32
    L10:
        r0.hyperlinks.add((HyperlinkRecord) ZeusTransformUtils.preCheckCast(r6, HyperlinkRecord.class, "com.obric.memorydata.plugin"));
        r7 = "Hyperlink";
        goto L32
    L11:
        r0.records.setTabpos(r4);
        r7 = "tabid";
        goto L32
    L12:
        r0.sst = (SSTRecord) ZeusTransformUtils.preCheckCast(r6, SSTRecord.class, "com.obric.memorydata.plugin");
        r7 = "sst";
        goto L32
    L13:
        r0.records.setXfpos(r4);
        r0.numxfs++;
        r7 = "XF";
        goto L32
    L14:
        r0.records.setPalettepos(r4);
        r7 = "palette";
        goto L32
    L15:
        r0.writeProtect = (WriteProtectRecord) ZeusTransformUtils.preCheckCast(r6, WriteProtectRecord.class, "com.obric.memorydata.plugin");
        r7 = "WriteProtect";
        goto L32
    L16:
        r0.boundsheets.add((BoundSheetRecord) ZeusTransformUtils.preCheckCast(r6, BoundSheetRecord.class, "com.obric.memorydata.plugin"));
        r0.records.setBspos(r4);
        r7 = "boundsheet";
        goto L32
    L17:
        r0.writeAccess = (WriteAccessRecord) ZeusTransformUtils.preCheckCast(r6, WriteAccessRecord.class, "com.obric.memorydata.plugin");
        r7 = "WriteAccess";
        goto L32
    L18:
        r0.fileShare = (FileSharingRecord) ZeusTransformUtils.preCheckCast(r6, FileSharingRecord.class, "com.obric.memorydata.plugin");
        r7 = "FileSharing";
        goto L32
    L19:
        r0.records.setBackuppos(r4);
        r7 = "backup";
        goto L32
    L20:
        r0.windowOne = (WindowOneRecord) ZeusTransformUtils.preCheckCast(r6, WindowOneRecord.class, "com.obric.memorydata.plugin");
        r7 = "WindowOneRecord";
        goto L32
    L21:
        r0.records.setFontpos(r4);
        r0.numfonts++;
        r7 = "font";
        goto L32
    L27:
        LOG.atDebug().a("found SupBook record at {}", v.a(r4));
        LinkTable r10 = new LinkTable(r13, r4, r0.records, r0.commentRecords);
        r0.linkTable = r10;
        r4 = r4 + (r10.getRecordCount() - 1);
        goto L37
    L30:
        r0.records.setProtpos(r4);
        r7 = "protect";
        goto L32
    L31:
        r7 = "workbook eof";
        goto L32
    L23:
        if (((DateWindow1904Record) ZeusTransformUtils.preCheckCast(r6, DateWindow1904Record.class, "com.obric.memorydata.plugin")).getWindowing() != 1) goto L25;
        boolean r11 = true;
    L26:
        r0.uses1904datewindowing = r11;
        r7 = "datewindow1904";
        goto L32
    L25:
        r11 = false;
        goto L26
    L29:
        throw new RecordFormatException("Extern sheet is part of LinkTable");
    L39:
        if (r0.windowOne != null) goto L41;
        r0.windowOne = createWindowOne();
    L41:
        LOG.atDebug().a("exit create workbook from existing file function");
        return r0;
    }

    private static WriteAccessRecord createWriteAccess() {
        WriteAccessRecord r0 = new WriteAccessRecord();
        String r2 = System.getProperty("user.name");     // Catch: AccessControlException -> L8
        if (r2 != null) goto L6;
        r2 = "POI";
    L6:
        r0.setUsername(r2);     // Catch: AccessControlException -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        LOG.atWarn().a(e).a("can't determine user.name");
        r0.setUsername("POI");
        goto L10
    }

    private static DrawingManager2 findDrawingManager(DrawingGroupRecord r7, List<EscherBSERecord> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return null;
    L5:
        EscherContainerRecord r10 = r7.getEscherContainer();
        if (r10 != null) goto L8;
        return null;
    L8:
        Iterator<EscherRecord> r11 = r10.iterator();
        EscherDggRecord r2 = null;
        EscherContainerRecord r3 = null;
    L10:
        if (r11.hasNext() == false) goto L17;
        EscherRecord r4 = (EscherRecord) ZeusTransformUtils.preCheckCast(r11.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, EscherDggRecord.class) == true) goto L13;
        if (r4.getRecordId() != EscherContainerRecord.BSTORE_CONTAINER) goto L10;
        r3 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r4, EscherContainerRecord.class, "com.obric.memorydata.plugin");
        goto L10
    L13:
        r2 = (EscherDggRecord) ZeusTransformUtils.preCheckCast(r4, EscherDggRecord.class, "com.obric.memorydata.plugin");
        goto L10
    L17:
        if (r2 != null) goto L19;
        return null;
    L19:
        DrawingManager2 r12 = new DrawingManager2(r2);
        if (r3 == null) goto L27;
        Iterator<EscherRecord> r0 = r3.iterator();
    L23:
        if (r0.hasNext() == false) goto L27;
        EscherRecord r5 = (EscherRecord) ZeusTransformUtils.preCheckCast(r0.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, EscherBSERecord.class) == false) goto L23;
        r9.add((EscherBSERecord) ZeusTransformUtils.preCheckCast(r5, EscherBSERecord.class, "com.obric.memorydata.plugin"));
    L27:
        return r12;
    }

    private String findSheetNameFromIndex(int r3) {
        if (r3 >= 0) goto L6;
        return "";
    L6:
        if (r3 < this.boundsheets.size()) goto L9;
        return "";
    L9:
        return getSheetName(r3);
    }

    private void fixTabIdRecord() {
        if (this.records.getTabpos() > 0) goto L5;
        return;
    L5:
        WorkbookRecordList r0 = this.records;
        TabIdRecord r1 = (TabIdRecord) ZeusTransformUtils.preCheckCast(r0.get(r0.getTabpos()), TabIdRecord.class, "com.obric.memorydata.plugin");
        int r3 = this.boundsheets.size();
        short[] r2 = new short[r3];
        short r4 = 0;
    L6:
        if (r4 >= r3) goto L8;
        r2[r4] = r4;
        r4 = (short) (r4 + 1);
        goto L6
    L8:
        r1.setTabIdArray(r2);
    }

    private BoundSheetRecord getBoundSheetRec(int r2) {
        return (BoundSheetRecord) ZeusTransformUtils.preCheckCast(this.boundsheets.get(r2), BoundSheetRecord.class, "com.obric.memorydata.plugin");
    }

    private LinkTable getOrCreateLinkTable() {
        if (this.linkTable != null) goto L6;
        this.linkTable = new LinkTable((short) getNumSheets(), this.records);
    L6:
        return this.linkTable;
    }

    public NameRecord addName(NameRecord r1) {
        getOrCreateLinkTable().addName(r1);
        return r1;
    }

    public int addSSTString(UnicodeString r3) {
        LOG.atDebug().a("insert to sst string='{}'", r3);
        if (this.sst != null) goto L6;
        insertSST();
    L6:
        return this.sst.addString(r3);
    }

    public short checkExternSheet(int r1, int r2) {
        return (short) getOrCreateLinkTable().checkExternSheet(r1, r2);
    }

    public void createDrawingGroup() {
        if (this.drawingManager != null) goto L19;
        EscherContainerRecord r0 = new EscherContainerRecord();
        EscherDggRecord r1 = new EscherDggRecord();
        EscherOptRecord r2 = new EscherOptRecord();
        EscherSplitMenuColorsRecord r3 = new EscherSplitMenuColorsRecord();
        r0.setRecordId(-4096);
        r0.setOptions(15);
        r1.setRecordId(EscherDggRecord.RECORD_ID);
        r1.setOptions(0);
        r1.setShapeIdMax(1024);
        r1.setNumShapesSaved(0);
        r1.setDrawingsSaved(0);
        r1.setFileIdClusters(new EscherDggRecord.FileIdCluster[0]);
        this.drawingManager = new DrawingManager2(r1);
        EscherContainerRecord r5 = null;
        if (this.escherBSERecords.isEmpty() == true) goto L10;
        r5 = new EscherContainerRecord();
        r5.setRecordId(EscherContainerRecord.BSTORE_CONTAINER);
        r5.setOptions((short) (15 | (this.escherBSERecords.size() << 4)));
        Iterator<EscherBSERecord> r4 = this.escherBSERecords.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r5.addChildRecord((EscherRecord) ZeusTransformUtils.preCheckCast(r4.next(), EscherRecord.class, "com.obric.memorydata.plugin"));
    L10:
        r2.setRecordId(-4085);
        r2.setOptions(51);
        r2.addEscherProperty(new EscherBoolProperty(EscherPropertyTypes.TEXT__SIZE_TEXT_TO_FIT_SHAPE, 524296));
        r2.addEscherProperty(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLCOLOR, 134217793));
        r2.addEscherProperty(new EscherRGBProperty(EscherPropertyTypes.LINESTYLE__COLOR, 134217792));
        r3.setRecordId(-3810);
        r3.setOptions(64);
        r3.setColor1(134217741);
        r3.setColor2(134217740);
        r3.setColor3(134217751);
        r3.setColor4(268435703);
        r0.addChildRecord(r1);
        if (r5 == null) goto L13;
        r0.addChildRecord(r5);
    L13:
        r0.addChildRecord(r2);
        r0.addChildRecord(r3);
        int r6 = findFirstRecordLocBySid(235);
        if (r6 != (-1)) goto L16;
        DrawingGroupRecord r7 = new DrawingGroupRecord();
        r7.addEscherRecord(r0);
        int r8 = findFirstRecordLocBySid(140);
        getRecords().add(r8 + 1, r7);
        return;
    L16:
        DrawingGroupRecord r9 = new DrawingGroupRecord();
        r9.addEscherRecord(r0);
        getRecords().set(r6, r9);
        return;
    }

    public NameRecord createName() {
        return addName(new NameRecord());
    }

    public boolean doesContainsSheetName(String r7, int r8) {
        if (r7.length() <= 31) goto L5;
        r7 = r7.substring(0, 31);
    L5:
        Iterator<BoundSheetRecord> r6 = this.boundsheets.iterator();
        int r0 = 0;
    L7:
        if (r6.hasNext() == false) goto L19;
        BoundSheetRecord r3 = (BoundSheetRecord) ZeusTransformUtils.preCheckCast(r6.next(), BoundSheetRecord.class, "com.obric.memorydata.plugin");
        int r4 = r0 + 1;
        if (r8 == r0) goto L18;
        String r1 = r3.getSheetname();
        if (r1.length() <= 31) goto L15;
        r1 = r1.substring(0, 31);
    L15:
        if (r7.equalsIgnoreCase(r1) == false) goto L18;
        return true;
    L18:
        r0 = r4;
        goto L7
    L19:
        return false;
    }

    public DrawingManager2 findDrawingGroup() {
        DrawingManager2 r0 = this.drawingManager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Iterator<Record> r1 = this.records.getRecords().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Record r2 = (Record) ZeusTransformUtils.preCheckCast(r1.next(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, DrawingGroupRecord.class) == false) goto L7;
        DrawingGroupRecord r3 = (DrawingGroupRecord) ZeusTransformUtils.preCheckCast(r2, DrawingGroupRecord.class, "com.obric.memorydata.plugin");
        r3.decode();
        DrawingManager2 r4 = findDrawingManager(r3, this.escherBSERecords);
        this.drawingManager = r4;
        if (r4 == null) goto L7;
        return r4;
    L14:
        DrawingManager2 r5 = findDrawingManager((DrawingGroupRecord) ZeusTransformUtils.preCheckCast(findFirstRecordBySid(235), DrawingGroupRecord.class, "com.obric.memorydata.plugin"), this.escherBSERecords);
        this.drawingManager = r5;
        return r5;
    }

    public Record findFirstRecordBySid(short r4) {
        Iterator<Record> r3 = this.records.getRecords().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Record r0 = (Record) ZeusTransformUtils.preCheckCast(r3.next(), Record.class, "com.obric.memorydata.plugin");
        if (r0.getSid() != r4) goto L4;
        return r0;
    L8:
        return null;
    }

    public int findFirstRecordLocBySid(short r5) {
        Iterator<Record> r4 = this.records.getRecords().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (((Record) ZeusTransformUtils.preCheckCast(r4.next(), Record.class, "com.obric.memorydata.plugin")).getSid() == r5) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public String findSheetFirstNameFromExternSheet(int r2) {
        return findSheetNameFromIndex(this.linkTable.getFirstInternalSheetIndexForExtIndex(r2));
    }

    public String findSheetLastNameFromExternSheet(int r2) {
        return findSheetNameFromIndex(this.linkTable.getLastInternalSheetIndexForExtIndex(r2));
    }

    public DrawingManager2 getDrawingManager() {
        return this.drawingManager;
    }

    public ExtendedFormatRecord getExFormatAt(int r3) {
        return (ExtendedFormatRecord) ZeusTransformUtils.preCheckCast(this.records.get((this.records.getXfpos() - (this.numxfs - 1)) + r3), ExtendedFormatRecord.class, "com.obric.memorydata.plugin");
    }

    public EvaluationWorkbook.ExternalName getExternalName(int r2, int r3) {
        String r0 = this.linkTable.resolveNameXText(r2, r3, this);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new EvaluationWorkbook.ExternalName(r0, r3, this.linkTable.resolveNameXIx(r2, r3));
    }

    public EvaluationWorkbook.ExternalSheet getExternalSheet(int r4) {
        String[] r3 = this.linkTable.getExternalBookAndSheetName(r4);
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.length != 2) goto L11;
        return new EvaluationWorkbook.ExternalSheet(r3[0], r3[1]);
    L11:
        return new EvaluationWorkbook.ExternalSheetRange(r3[0], r3[1], r3[2]);
    }

    public int getExternalSheetIndex(String r1, String r2, String r3) {
        return getOrCreateLinkTable().getExternalSheetIndex(r1, r2, r3);
    }

    public int getFirstSheetIndexFromExternSheetIndex(int r1) {
        return this.linkTable.getFirstInternalSheetIndexForExtIndex(r1);
    }

    public FontRecord getFontRecordAt(int r4) {
        if (r4 <= 4) goto L5;
        int r0 = r4 - 1;
    L7:
        if (r0 > (this.numfonts - 1)) goto L11;
        WorkbookRecordList r5 = this.records;
        return (FontRecord) ZeusTransformUtils.preCheckCast(r5.get((r5.getFontpos() - (this.numfonts - 1)) + r0), FontRecord.class, "com.obric.memorydata.plugin");
    L11:
        throw new ArrayIndexOutOfBoundsException("There are only " + this.numfonts + " font records, but you asked for index " + r4);
    L5:
        r0 = r4;
        goto L7
    }

    public List<FormatRecord> getFormats() {
        return this.formats;
    }

    public int getLastSheetIndexFromExternSheetIndex(int r1) {
        return this.linkTable.getLastInternalSheetIndexForExtIndex(r1);
    }

    public NameCommentRecord getNameCommentRecord(NameRecord r2) {
        return (NameCommentRecord) ZeusTransformUtils.preCheckCast(this.commentRecords.get(r2.getNameText()), NameCommentRecord.class, "com.obric.memorydata.plugin");
    }

    public NameRecord getNameRecord(int r1) {
        return this.linkTable.getNameRecord(r1);
    }

    public NameXPtg getNameXPtg(String r3, int r4, UDFFinder r5) {
        UDFFinder r6 = (UDFFinder) ZeusTransformUtils.wrapperContextForParams(r5, UDFFinder.class, "com.obric.memorydata.plugin");
        LinkTable r2 = getOrCreateLinkTable();
        NameXPtg r7 = r2.getNameXPtg(r3, r4);
        if (r7 == null) goto L5;
        return r7;
    L5:
        if (r6.findFunction(r3) != null) goto L7;
        return r7;
    L7:
        return r2.addNameXPtg(r3);
    }

    public int getNumNames() {
        LinkTable r0 = this.linkTable;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getNumNames();
    }

    public int getNumRecords() {
        return this.records.size();
    }

    public int getNumSheets() {
        LOG.atDebug().a("getNumSheets={}", v.a(this.boundsheets.size()));
        return this.boundsheets.size();
    }

    public List<Record> getRecords() {
        return this.records.getRecords();
    }

    public UnicodeString getSSTString(int r3) {
        if (this.sst != null) goto L5;
        insertSST();
    L5:
        UnicodeString r2 = this.sst.getString(r3);
        LOG.atTrace().a("Returning SST for index={} String= {}", v.a(r3), r2);
        return r2;
    }

    public int getSheetIndex(String r4) {
        int r0 = this.boundsheets.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (getSheetName(r1).equalsIgnoreCase(r4) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    public String getSheetName(int r1) {
        return getBoundSheetRec(r1).getSheetname();
    }

    public WindowOneRecord getWindowOne() {
        return this.windowOne;
    }

    public WriteAccessRecord getWriteAccess() {
        if (this.writeAccess != null) goto L6;
        this.writeAccess = createWriteAccess();
        int r0 = findFirstRecordLocBySid(226);
        this.records.add(r0 + 1, this.writeAccess);
    L6:
        return this.writeAccess;
    }

    public void insertSST() {
        LOG.atDebug().a("creating new SST via insertSST!");
        this.sst = new SSTRecord();
        WorkbookRecordList r0 = this.records;
        r0.add(r0.size() - 1, createExtendedSST());
        WorkbookRecordList r1 = this.records;
        r1.add(r1.size() - 2, this.sst);
    }

    public boolean isUsing1904DateWindowing() {
        return this.uses1904datewindowing;
    }

    public String resolveNameXText(int r2, int r3) {
        return this.linkTable.resolveNameXText(r2, r3, this);
    }

    public void setSheetName(int r3, String r4) {
        checkSheets(r3);
        if (r4.length() <= 31) goto L5;
        r4 = r4.substring(0, 31);
    L5:
        ((BoundSheetRecord) ZeusTransformUtils.preCheckCast(this.boundsheets.get(r3), BoundSheetRecord.class, "com.obric.memorydata.plugin")).setSheetname(r4);
    }

    public void updateNameCommentRecordCache(NameCommentRecord r6) {
        if (this.commentRecords.containsValue(r6) == false) goto L10;
        Iterator<Map.Entry<String, NameCommentRecord>> r0 = this.commentRecords.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((NameCommentRecord) ZeusTransformUtils.preCheckCast(r1.getValue(), NameCommentRecord.class, "com.obric.memorydata.plugin")).equals(r6) == false) goto L6;
        this.commentRecords.remove(r1.getKey());
    L10:
        this.commentRecords.put(r6.getNameText(), r6);
    }
}
