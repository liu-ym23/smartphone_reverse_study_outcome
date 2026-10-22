package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.CalcCountRecord;
import org.apache.poi.hssf.record.CalcModeRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.DefaultColWidthRecord;
import org.apache.poi.hssf.record.DefaultRowHeightRecord;
import org.apache.poi.hssf.record.DeltaRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.GridsetRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.IterationRecord;
import org.apache.poi.hssf.record.PrintGridlinesRecord;
import org.apache.poi.hssf.record.PrintHeadersRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RefModeRecord;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SaveRecalcRecord;
import org.apache.poi.hssf.record.SelectionRecord;
import org.apache.poi.hssf.record.WSBoolRecord;
import org.apache.poi.hssf.record.WindowTwoRecord;
import org.apache.poi.hssf.record.aggregates.ChartSubstreamRecordAggregate;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.RecordFormatException;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public final class InternalSheet {
    private static final c LOGGER = null;
    ColumnInfoRecordsAggregate _columnInfos;
    private DataValidityTable _dataValidityTable;
    private DimensionsRecord _dimensions;
    private GutsRecord _gutsRecord;
    protected boolean _isUncalced;
    private final MergedCellsTable _mergedCellsTable;
    private final WorksheetProtectionBlock _protectionBlock;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _records;
    protected final RowRecordsAggregate _rowsAggregate;
    protected SelectionRecord _selection;
    private ConditionalFormattingTable condFormatting;
    protected DefaultColWidthRecord defaultcolwidth;
    protected DefaultRowHeightRecord defaultrowheight;
    protected GridsetRecord gridset;
    protected PrintGridlinesRecord printGridlines;
    protected PrintHeadersRecord printHeaders;
    private Iterator<RowRecord> rowRecIterator;
    protected WindowTwoRecord windowTwo;

    public static class UnsupportedBOFType extends RecordFormatException {
        private final int type;

        public UnsupportedBOFType(int r3) {
            super("BOF not of a supported type, found " + r3);
            this.type = r3;
        }

        public int getType() {
            return this.type;
        }
    }

    static {
        LOGGER = b.a(InternalSheet.class);
    }

    private InternalSheet() {
        this.defaultcolwidth = new DefaultColWidthRecord();
        this.defaultrowheight = new DefaultRowHeightRecord();
        WorksheetProtectionBlock r0 = new WorksheetProtectionBlock();
        this._protectionBlock = r0;
        MergedCellsTable r1 = new MergedCellsTable();
        this._mergedCellsTable = r1;
        ArrayList r2 = new ArrayList(32);
        c r3 = LOGGER;
        r3.atDebug().a("Sheet createsheet from scratch called");
        r2.add(createBOF());
        r2.add(createCalcMode());
        r2.add(createCalcCount());
        r2.add(createRefMode());
        r2.add(createIteration());
        r2.add(createDelta());
        r2.add(createSaveRecalc());
        PrintHeadersRecord r4 = createPrintHeaders();
        this.printHeaders = r4;
        r2.add(r4);
        PrintGridlinesRecord r5 = createPrintGridlines();
        this.printGridlines = r5;
        r2.add(r5);
        GridsetRecord r6 = createGridset();
        this.gridset = r6;
        r2.add(r6);
        GutsRecord r7 = createGuts();
        this._gutsRecord = r7;
        r2.add(r7);
        DefaultRowHeightRecord r8 = createDefaultRowHeight();
        this.defaultrowheight = r8;
        r2.add(r8);
        r2.add(createWSBool());
        PageSettingsBlock r9 = new PageSettingsBlock();
        this._psBlock = r9;
        r2.add(r9);
        r2.add(r0);
        DefaultColWidthRecord r10 = createDefaultColWidth();
        this.defaultcolwidth = r10;
        r2.add(r10);
        ColumnInfoRecordsAggregate r11 = new ColumnInfoRecordsAggregate();
        r2.add(r11);
        this._columnInfos = r11;
        DimensionsRecord r12 = createDimensions();
        this._dimensions = r12;
        r2.add(r12);
        RowRecordsAggregate r13 = new RowRecordsAggregate();
        this._rowsAggregate = r13;
        r2.add(r13);
        WindowTwoRecord r14 = createWindowTwo();
        this.windowTwo = r14;
        r2.add(r14);
        SelectionRecord r15 = createSelection();
        this._selection = r15;
        r2.add(r15);
        r2.add(r1);
        r2.add(EOFRecord.instance);
        this._records = r2;
        r3.atDebug().a("Sheet createsheet from scratch exit");
    }

    private InternalSheet(RecordStream r12) {
        this.defaultcolwidth = new DefaultColWidthRecord();
        this.defaultrowheight = new DefaultRowHeightRecord();
        this._protectionBlock = new WorksheetProtectionBlock();
        this._mergedCellsTable = new MergedCellsTable();
        ArrayList r0 = new ArrayList(128);
        this._records = r0;
        if (r12.peekNextSid() != 2057) goto L117;
        BOFRecord r2 = (BOFRecord) ZeusTransformUtils.preCheckCast(r12.getNext(), BOFRecord.class, "com.obric.memorydata.plugin");
        if (r2.getType() != 16) goto L8;
    L19:
        r0.add(r2);
        RowRecordsAggregate r3 = null;
        int r4 = -1;
    L21:
        if (r12.hasNext() == false) goto L103;
        int r6 = r12.peekNextSid();
        if (r6 == 432) goto L100;
        if (r6 == 2169) goto L100;
        if (r6 == 125) goto L29;
        if (r6 == 434) goto L32;
        if (RecordOrderer.isRowBlockRecord(r6) == false) goto L40;
        if (r3 != null) goto L38;
        RowBlocksReader r5 = new RowBlocksReader(r12);
        this._mergedCellsTable.addRecords(r5.getLooseMergedCells());
        RowRecordsAggregate r7 = new RowRecordsAggregate(r5.getPlainRecordStream(), r5.getSharedFormulaManager());
        r0.add(r7);
        r3 = r7;
        goto L21
    L38:
        throw new RecordFormatException("row/cell records found in the wrong place");
    L40:
        if (CustomViewSettingsRecordAggregate.isBeginRecord(r6) == true) goto L41;
        if (PageSettingsBlock.isComponentRecord(r6) == true) goto L44;
        if (WorksheetProtectionBlock.isComponentRecord(r6) == true) goto L51;
        if (r6 == 229) goto L54;
        if (r6 == 2057) goto L56;
        Record r9 = r12.getNext();
        if (r6 == 523) goto L21;
        if (r6 == 94) goto L62;
        if (r6 != 2152) goto L66;
    L99:
        r0.add(r9);
        goto L21
    L66:
        if (r6 == 2151) goto L99;
        if (r6 == 10) goto L70;
        if (r6 != 512) goto L78;
        if (this._columnInfos != null) goto L76;
        ColumnInfoRecordsAggregate r8 = new ColumnInfoRecordsAggregate();
        this._columnInfos = r8;
        r0.add(r8);
    L76:
        this._dimensions = (DimensionsRecord) ZeusTransformUtils.preCheckCast(r9, DimensionsRecord.class, "com.obric.memorydata.plugin");
        r4 = r0.size();
        goto L99
    L78:
        if (r6 != 85) goto L81;
        this.defaultcolwidth = (DefaultColWidthRecord) ZeusTransformUtils.preCheckCast(r9, DefaultColWidthRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L81:
        if (r6 != 549) goto L84;
        this.defaultrowheight = (DefaultRowHeightRecord) ZeusTransformUtils.preCheckCast(r9, DefaultRowHeightRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L84:
        if (r6 != 43) goto L87;
        this.printGridlines = (PrintGridlinesRecord) ZeusTransformUtils.preCheckCast(r9, PrintGridlinesRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L87:
        if (r6 != 42) goto L90;
        this.printHeaders = (PrintHeadersRecord) ZeusTransformUtils.preCheckCast(r9, PrintHeadersRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L90:
        if (r6 != 130) goto L93;
        this.gridset = (GridsetRecord) ZeusTransformUtils.preCheckCast(r9, GridsetRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L93:
        if (r6 != 29) goto L95;
        this._selection = (SelectionRecord) ZeusTransformUtils.preCheckCast(r9, SelectionRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L95:
        if (r6 != 574) goto L97;
        this.windowTwo = (WindowTwoRecord) ZeusTransformUtils.preCheckCast(r9, WindowTwoRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L97:
        if (r6 != 128) goto L99;
        this._gutsRecord = (GutsRecord) ZeusTransformUtils.preCheckCast(r9, GutsRecord.class, "com.obric.memorydata.plugin");
        goto L99
    L70:
        r0.add(r9);
        goto L103
    L62:
        this._isUncalced = true;
        goto L21
    L56:
        spillAggregate(new ChartSubstreamRecordAggregate(r12), r0);
        goto L21
    L54:
        this._mergedCellsTable.read(r12);
        goto L21
    L51:
        this._protectionBlock.addRecords(r12);
        goto L21
    L44:
        PageSettingsBlock r10 = this._psBlock;
        if (r10 != null) goto L47;
        PageSettingsBlock r11 = new PageSettingsBlock(r12);
        this._psBlock = r11;
        r0.add(r11);
    L48:
        this._psBlock.positionRecords(r0);
        goto L21
    L47:
        r10.addLateRecords(r12);
        goto L48
    L41:
        Object r13 = new CustomViewSettingsRecordAggregate(r12);
    L101:
        r0.add(r13);
        goto L21
    L32:
        DataValidityTable r14 = new DataValidityTable(r12);
        this._dataValidityTable = r14;
        r13 = r14;
        goto L101
    L29:
        ColumnInfoRecordsAggregate r15 = new ColumnInfoRecordsAggregate(r12);
        this._columnInfos = r15;
        r13 = r15;
    L100:
        ConditionalFormattingTable r16 = new ConditionalFormattingTable(r12);
        this.condFormatting = r16;
        r13 = r16;
    L103:
        if (this.windowTwo == null) goto L115;
        if (this._dimensions != null) goto L110;
        if (r3 != null) goto L108;
        r3 = new RowRecordsAggregate();
    L109:
        r4 = findFirstRecordLocBySid(574);
        DimensionsRecord r17 = r3.createDimensions();
        this._dimensions = r17;
        r0.add(r4, r17);
        goto L110
    L108:
        LOGGER.atWarn().a("DIMENSION record not found even though row/cells present");
    L110:
        if (r3 != null) goto L112;
        r3 = new RowRecordsAggregate();
        r0.add(r4 + 1, r3);
    L112:
        this._rowsAggregate = r3;
        RecordOrderer.addNewSheetRecord(r0, this._mergedCellsTable);
        RecordOrderer.addNewSheetRecord(r0, this._protectionBlock);
        LOGGER.atDebug().a("sheet createSheet (existing file) exited");
        return;
    L115:
        throw new RecordFormatException("WINDOW2 was not found");
    L8:
        if (r2.getType() == 32) goto L19;
        if (r2.getType() == 64) goto L19;
    L13:
        if (r12.hasNext() == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r12.getNext(), EOFRecord.class) == false) goto L13;
    L18:
        throw new UnsupportedBOFType(r2.getType());
    L117:
        throw new RecordFormatException("BOF record expected");
    }

    static BOFRecord createBOF() {
        BOFRecord r0 = new BOFRecord();
        r0.setVersion(1536);
        r0.setType(16);
        r0.setBuild(3515);
        r0.setBuildYear(1996);
        r0.setHistoryBitMask(193);
        r0.setRequiredVersion(6);
        return r0;
    }

    private static CalcCountRecord createCalcCount() {
        CalcCountRecord r0 = new CalcCountRecord();
        r0.setIterations(100);
        return r0;
    }

    private static CalcModeRecord createCalcMode() {
        CalcModeRecord r0 = new CalcModeRecord();
        r0.setCalcMode(1);
        return r0;
    }

    private static DefaultColWidthRecord createDefaultColWidth() {
        DefaultColWidthRecord r0 = new DefaultColWidthRecord();
        r0.setColWidth(8);
        return r0;
    }

    private static DefaultRowHeightRecord createDefaultRowHeight() {
        DefaultRowHeightRecord r0 = new DefaultRowHeightRecord();
        r0.setOptionFlags(0);
        r0.setRowHeight(255);
        return r0;
    }

    private static DeltaRecord createDelta() {
        return new DeltaRecord(0.001d);
    }

    private static DimensionsRecord createDimensions() {
        DimensionsRecord r0 = new DimensionsRecord();
        r0.setFirstCol(0);
        r0.setLastRow(1);
        r0.setFirstRow(0);
        r0.setLastCol(1);
        return r0;
    }

    private static GridsetRecord createGridset() {
        GridsetRecord r0 = new GridsetRecord();
        r0.setGridset(true);
        return r0;
    }

    private static GutsRecord createGuts() {
        GutsRecord r0 = new GutsRecord();
        r0.setLeftRowGutter(0);
        r0.setTopColGutter(0);
        r0.setRowLevelMax(0);
        r0.setColLevelMax(0);
        return r0;
    }

    private static IterationRecord createIteration() {
        return new IterationRecord(false);
    }

    private static PrintGridlinesRecord createPrintGridlines() {
        PrintGridlinesRecord r0 = new PrintGridlinesRecord();
        r0.setPrintGridlines(false);
        return r0;
    }

    private static PrintHeadersRecord createPrintHeaders() {
        PrintHeadersRecord r0 = new PrintHeadersRecord();
        r0.setPrintHeaders(false);
        return r0;
    }

    private static RefModeRecord createRefMode() {
        RefModeRecord r0 = new RefModeRecord();
        r0.setMode(1);
        return r0;
    }

    private static SaveRecalcRecord createSaveRecalc() {
        SaveRecalcRecord r0 = new SaveRecalcRecord();
        r0.setRecalc(true);
        return r0;
    }

    private static SelectionRecord createSelection() {
        return new SelectionRecord(0, 0);
    }

    public static InternalSheet createSheet() {
        return new InternalSheet();
    }

    public static InternalSheet createSheet(RecordStream r1) {
        return new InternalSheet(r1);
    }

    private static WSBoolRecord createWSBool() {
        WSBoolRecord r0 = new WSBoolRecord();
        r0.setWSBool1((byte) 4);
        r0.setWSBool2(MessagePack.Code.NEVER_USED);
        return r0;
    }

    private static WindowTwoRecord createWindowTwo() {
        WindowTwoRecord r0 = new WindowTwoRecord();
        r0.setOptions(1718);
        r0.setTopRow(0);
        r0.setLeftCol(0);
        r0.setHeaderColor(64);
        r0.setPageBreakZoom(0);
        r0.setNormalZoom(0);
        return r0;
    }

    private MergedCellsTable getMergedRecords() {
        return this._mergedCellsTable;
    }

    private static void spillAggregate(RecordAggregate r2, List<RecordBase> r3) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r4.getClass();
        r2.visitContainedRecords(new $$Lambda$w93S1Su4JEwEZgf_kapgcrORa9c(r4));
    }

    public void addRow(RowRecord r5) {
        c r0 = LOGGER;
        r0.atDebug().a("addRow ");
        DimensionsRecord r1 = this._dimensions;
        if (r5.getRowNumber() < r1.getLastRow()) goto L6;
        r1.setLastRow(r5.getRowNumber() + 1);
    L6:
        if (r5.getRowNumber() >= r1.getFirstRow()) goto L8;
        r1.setFirstRow(r5.getRowNumber());
    L8:
        RowRecord r2 = this._rowsAggregate.getRow(r5.getRowNumber());
        if (r2 == null) goto L11;
        this._rowsAggregate.removeRow(r2);
    L11:
        this._rowsAggregate.insertRow(r5);
        r0.atDebug().a("exit addRow");
    }

    public void addValueRecord(int r3, CellValueRecordInterface r4) {
        CellValueRecordInterface r5 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        LOGGER.atDebug().a("add value record row{}", v.a(r3));
        DimensionsRecord r6 = this._dimensions;
        if (r5.getColumn() < r6.getLastCol()) goto L6;
        r6.setLastCol((short) (r5.getColumn() + 1));
    L6:
        if (r5.getColumn() >= r6.getFirstCol()) goto L8;
        r6.setFirstCol(r5.getColumn());
    L8:
        this._rowsAggregate.insertCell(r5);
    }

    public int aggregateDrawingRecords(DrawingManager2 r4, boolean r5) {
        int r6 = findFirstRecordLocBySid(236);
        if (r6 != (-1)) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L15;
        if (r5 == true) goto L9;
        return -1;
    L9:
        EscherAggregate r7 = new EscherAggregate(true);
        int r8 = findFirstRecordLocBySid(9876);
        if (r8 != (-1)) goto L12;
        r8 = findFirstRecordLocBySid(574);
    L13:
        getRecords().add(r8, r7);
        return r8;
    L12:
        getRecords().remove(r8);
        goto L13
    L15:
        EscherAggregate.createAggregate(getRecords(), r6);
        return r6;
    L5:
        r2 = false;
        goto L6
    }

    public Record findFirstRecordBySid(short r2) {
        int r3 = findFirstRecordLocBySid(r2);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return (Record) ZeusTransformUtils.preCheckCast(this._records.get(r3), Record.class, "com.obric.memorydata.plugin");
    }

    public int findFirstRecordLocBySid(short r6) {
        int r0 = this._records.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        RecordBase r2 = this._records.get(r1);
        if (ZeusTransformUtils.instanceOf(r2, Record.class) == false) goto L10;
        if (((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid() != r6) goto L10;
        return r1;
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return -1;
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._rowsAggregate.getCellValueIterator();
    }

    public ConditionalFormattingTable getConditionalFormattingTable() {
        if (this.condFormatting != null) goto L6;
        ConditionalFormattingTable r0 = new ConditionalFormattingTable();
        this.condFormatting = r0;
        RecordOrderer.addNewSheetRecord(this._records, r0);
    L6:
        return this.condFormatting;
    }

    public short getDefaultRowHeight() {
        return this.defaultrowheight.getRowHeight();
    }

    public CellRangeAddress getMergedRegionAt(int r2) {
        MergedCellsTable r1 = getMergedRecords();
        if (r2 < r1.getNumberOfMergedRegions()) goto L7;
        return null;
    L7:
        return r1.get(r2);
    }

    public RowRecord getNextRow() {
        if (this.rowRecIterator != null) goto L6;
        this.rowRecIterator = this._rowsAggregate.getIterator();
    L6:
        if (this.rowRecIterator.hasNext() == true) goto L10;
        return null;
    L10:
        return (RowRecord) ZeusTransformUtils.preCheckCast(this.rowRecIterator.next(), RowRecord.class, "com.obric.memorydata.plugin");
    }

    public int getNumMergedRegions() {
        return getMergedRecords().getNumberOfMergedRegions();
    }

    public List<RecordBase> getRecords() {
        return this._records;
    }

    public RowRecordsAggregate getRowsAggregate() {
        return this._rowsAggregate;
    }

    public WindowTwoRecord getWindowTwo() {
        return this.windowTwo;
    }

    public short getXFIndexForColAt(short r1) {
        ColumnInfoRecord r0 = this._columnInfos.findColumnInfo(r1);
        if (r0 != null) goto L5;
        return 15;
    L5:
        return (short) r0.getXFIndex();
    }

    public void replaceValueRecord(CellValueRecordInterface r3) {
        CellValueRecordInterface r4 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r3, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        LOGGER.atDebug().a("replaceValueRecord ");
        this._rowsAggregate.removeCell(r4);
        this._rowsAggregate.insertCell(r4);
    }
}
