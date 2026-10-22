package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hssf.model.DrawingManager2;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.util.Configurator;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFSheet implements Sheet {
    public static final int INITIAL_CAPACITY = 0;
    private static final c LOGGER = null;
    protected final InternalWorkbook _book;
    private int _firstrow;
    private int _lastrow;
    private HSSFPatriarch _patriarch;
    private final TreeMap<Integer, HSSFRow> _rows;
    private final InternalSheet _sheet;
    protected final HSSFWorkbook _workbook;

    static {
        LOGGER = b.a(HSSFSheet.class);
        INITIAL_CAPACITY = Configurator.getIntValue("HSSFSheet.RowInitialCapacity", 20);
    }

    public HSSFSheet(HSSFWorkbook r2) {
        this._firstrow = -1;
        this._lastrow = -1;
        this._sheet = InternalSheet.createSheet();
        this._rows = new TreeMap();
        this._workbook = r2;
        this._book = r2.getWorkbook();
    }

    public HSSFSheet(HSSFWorkbook r2, InternalSheet r3) {
        this._firstrow = -1;
        this._lastrow = -1;
        this._sheet = r3;
        this._rows = new TreeMap();
        this._workbook = r2;
        this._book = r2.getWorkbook();
        setPropertiesFromSheet(r3);
    }

    private void addRow(HSSFRow r3, boolean r4) {
        this._rows.put(Integer.valueOf(r3.getRowNum()), r3);
        if (r4 == false) goto L5;
        this._sheet.addRow(r3.getRowRecord());
    L5:
        boolean r0 = true;
        if (this._rows.size() == 1) goto L10;
        r0 = false;
    L10:
        if (r3.getRowNum() > getLastRowNum()) goto L12;
        if (r0 == true) goto L12;
    L14:
        if (r3.getRowNum() < getFirstRowNum()) goto L16;
        if (r0 == true) goto L16;
        return;
    L16:
        this._firstrow = r3.getRowNum();
        return;
    L12:
        this._lastrow = r3.getRowNum();
        goto L14
    }

    private HSSFRow createRowFromRecord(RowRecord r3) {
        HSSFRow r0 = new HSSFRow(this._workbook, this, r3);
        addRow(r0, false);
        return r0;
    }

    private CellRange<HSSFCell> getCellRange(CellRangeAddress r11) {
        int r0 = r11.getFirstRow();
        int r1 = r11.getFirstColumn();
        int r2 = r11.getLastRow();
        int r12 = r11.getLastColumn();
        int r3 = (r2 - r0) + 1;
        int r4 = (r12 - r1) + 1;
        ArrayList r5 = new ArrayList(r3 * r4);
        int r6 = r0;
    L3:
        if (r6 > r2) goto L15;
        int r7 = r1;
    L5:
        if (r7 > r12) goto L13;
        HSSFRow r8 = getRow(r6);
        if (r8 != null) goto L9;
        r8 = createRow(r6);
    L9:
        HSSFCell r9 = r8.getCell(r7);
        if (r9 != null) goto L12;
        r9 = r8.createCell(r7);
    L12:
        r5.add(r9);
        r7 = r7 + 1;
        goto L5
    L13:
        r6 = r6 + 1;
        goto L3
    L15:
        return SSCellRange.create(r0, r1, r3, r4, r5, HSSFCell.class);
    }

    private HSSFPatriarch getPatriarch(boolean r6) {
        HSSFPatriarch r0 = this._patriarch;
        if (r0 == null) goto L5;
        return r0;
    L5:
        DrawingManager2 r1 = this._book.findDrawingGroup();
        if (r1 != null) goto L10;
        if (r6 == true) goto L9;
        return null;
    L9:
        this._book.createDrawingGroup();
        r1 = this._book.getDrawingManager();
    L10:
        EscherAggregate r2 = (EscherAggregate) ZeusTransformUtils.preCheckCast(this._sheet.findFirstRecordBySid(9876), EscherAggregate.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L20;
        int r3 = this._sheet.aggregateDrawingRecords(r1, false);
        if ((-1) != r3) goto L18;
        if (r6 == false) goto L17;
        int r7 = this._sheet.aggregateDrawingRecords(r1, true);
        HSSFPatriarch r4 = new HSSFPatriarch(this, (EscherAggregate) ZeusTransformUtils.preCheckCast(this._sheet.getRecords().get(r7), EscherAggregate.class, "com.obric.memorydata.plugin"));
        r4.afterCreate();
        return r4;
    L17:
        return null;
    L18:
        r2 = (EscherAggregate) ZeusTransformUtils.preCheckCast(this._sheet.getRecords().get(r3), EscherAggregate.class, "com.obric.memorydata.plugin");
    L20:
        return new HSSFPatriarch(this, r2);
    }

    static /* synthetic */ Message lambda$setPropertiesFromSheet$0(CellValueRecordInterface r4) {
        CellValueRecordInterface r5 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Record.class) == false) goto L7;
        return new SimpleMessage("record id = " + Integer.toHexString(((Record) ZeusTransformUtils.preCheckCast(r5, Record.class, "com.obric.memorydata.plugin")).getSid()));
    L7:
        return new SimpleMessage("record = " + r5);
    }

    private void setPropertiesFromSheet(InternalSheet r13) {
    L2:
        RowRecord r0 = r13.getNextRow();
        if (r0 == null) goto L5;
        createRowFromRecord(r0);
        goto L2
    L5:
        Iterator<CellValueRecordInterface> r1 = r13.getCellValueIterator();
        long r2 = System.currentTimeMillis();
        LOGGER.atDebug().a("Time at start of cell creating in HSSF sheet = {}", v.a(r2));
        HSSFRow r3 = null;
    L7:
        if (r1.hasNext() == false) goto L17;
        final CellValueRecordInterface r4 = (CellValueRecordInterface) ZeusTransformUtils.preCheckCast(r1.next(), CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        if (r3 != null) goto L11;
    L12:
        r3 = getRow(r4.getRow());
        if (r3 != null) goto L15;
        RowRecord r7 = new RowRecord(r4.getRow());
        r13.addRow(r7);
        HSSFRow r8 = createRowFromRecord(r7);
        HSSFRow r9 = r3;
        r3 = r8;
    L16:
        c r10 = LOGGER;
        r10.atTrace().a(new $$Lambda$HSSFSheet$xvtA8aVcC735Slg3j0SS_XEgvyw(r4));
        r3.createCellFromRecord(r4);
        r10.atTrace().a("record took {}ms", v.a(System.currentTimeMillis() - r5));
        r3 = r9;
    L15:
        r9 = r3;
        goto L16
    L11:
        if (r3.getRowNum() == r4.getRow()) goto L15;
    L17:
        LOGGER.atDebug().a("total sheet cell creation took {}ms", v.a(System.currentTimeMillis() - r2));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow createRow(int r3) {
        HSSFRow r0 = new HSSFRow(this._workbook, this, r3);
        r0.setHeight(getDefaultRowHeight());
        r0.getRowRecord().setBadFontHeight(false);
        addRow(r0, true);
        return r0;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row createRow(int r1) {
        return createRow(r1);
    }

    public short getDefaultRowHeight() {
        return this._sheet.getDefaultRowHeight();
    }

    public HSSFPatriarch getDrawingPatriarch() {
        HSSFPatriarch r0 = getPatriarch(false);
        this._patriarch = r0;
        return r0;
    }

    public int getFirstRowNum() {
        return this._firstrow;
    }

    public int getLastRowNum() {
        return this._lastrow;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        ArrayList r0 = new ArrayList();
        int r1 = this._sheet.getNumMergedRegions();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(this._sheet.getMergedRegionAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sheet.getNumMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFRow getRow(int r2) {
        return (HSSFRow) ZeusTransformUtils.preCheckCast(this._rows.get(Integer.valueOf(r2)), HSSFRow.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row getRow(int r1) {
        return getRow(r1);
    }

    public InternalSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new HSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ SheetConditionalFormatting getSheetConditionalFormatting() {
        return getSheetConditionalFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        HSSFWorkbook r0 = getWorkbook();
        return r0.getSheetName(r0.getSheetIndex(this));
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public HSSFWorkbook getWorkbook() {
        return this._workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Workbook getWorkbook() {
        return getWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<HSSFCell> removeArrayFormula(Cell r4) {
        Cell r5 = (Cell) ZeusTransformUtils.wrapperContextForParams(r4, Cell.class, "com.obric.memorydata.plugin");
        if (r5.getSheet() != this) goto L14;
        CellValueRecordInterface r0 = ((HSSFCell) ZeusTransformUtils.preCheckCast(r5, HSSFCell.class, "com.obric.memorydata.plugin")).getCellValueRecord();
        if (ZeusTransformUtils.instanceOf(r0, FormulaRecordAggregate.class) == false) goto L12;
        CellRange<HSSFCell> r3 = getCellRange(((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(r0, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).removeArrayFormula(r5.getRowIndex(), r5.getColumnIndex()));
        Iterator<C> r6 = r3.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((Cell) ZeusTransformUtils.preCheckCast(r6.next(), Cell.class, "com.obric.memorydata.plugin")).setBlank();
        goto L8
    L10:
        return r3;
    L12:
        throw new IllegalArgumentException("Cell " + new CellReference(r5).formatAsString() + " is not part of an array formula.");
    L14:
        throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    public void setActive(boolean r1) {
        getSheet().getWindowTwo().setActive(r1);
    }

    public void setSelected(boolean r1) {
        getSheet().getWindowTwo().setSelected(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }
}
