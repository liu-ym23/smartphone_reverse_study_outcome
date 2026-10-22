package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.OoxmlSheetExtensions;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFVMLDrawing;

/* JADX INFO: loaded from: classes7.dex */
public class SXSSFSheet implements Sheet, OoxmlSheetExtensions {
    private static final c LOG = null;
    protected AutoSizeColumnTracker _autoSizeColumnTracker;
    private int _randomAccessWindowSize;
    private final TreeMap<Integer, SXSSFRow> _rows;
    final XSSFSheet _sh;
    protected final SXSSFWorkbook _workbook;
    protected SheetDataWriter _writer;
    private boolean allFlushed;
    private int lastFlushedRowNumber;
    private int leftMostColumn;
    private int rightMostColumn;

    static {
        LOG = b.a(SXSSFSheet.class);
    }

    public SXSSFSheet(SXSSFWorkbook r2, XSSFSheet r3) {
        this._rows = new TreeMap();
        this._randomAccessWindowSize = 100;
        this.lastFlushedRowNumber = -1;
        this.leftMostColumn = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        this._workbook = r2;
        this._sh = r3;
        this._writer = r2.createSheetDataWriter();
        setRandomAccessWindowSize(r2.getRandomAccessWindowSize());
        this._autoSizeColumnTracker = new AutoSizeColumnTracker(this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LOG.atWarn().a("Failed to create AutoSizeColumnTracker, possibly due to fonts not being installed in your OS", e);
    }

    private void flushOneRow() {
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this._rows.firstKey(), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L12;
        int r1 = r0.intValue();
        SXSSFRow r2 = (SXSSFRow) ZeusTransformUtils.preCheckCast(this._rows.get(r0), SXSSFRow.class, "com.obric.memorydata.plugin");
        AutoSizeColumnTracker r3 = this._autoSizeColumnTracker;
        if (r3 == null) goto L7;
        r3.updateColumnWidths(r2);
    L7:
        SheetDataWriter r4 = this._writer;
        if (r4 == null) goto L10;
        r4.writeRow(r1, r2);
    L10:
        this._rows.remove(r0);
        this.lastFlushedRowNumber = r1;
        return;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row createRow(int r1) {
        return createRow(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFRow createRow(int r6) {
        int r0 = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (r6 < 0) goto L30;
        if (r6 > r0) goto L30;
        SheetDataWriter r1 = this._writer;
        if (r1 == null) goto L13;
        if (r6 > r1.getLastFlushedRow()) goto L13;
        throw new IllegalArgumentException("Attempting to write a row[" + r6 + "] in the range [0," + this._writer.getLastFlushedRow() + "] that is already written to disk.");
    L13:
        if (this._sh.getPhysicalNumberOfRows() > 0) goto L15;
    L19:
        SXSSFRow r2 = new SXSSFRow(this);
        r2.setRowNumWithoutUpdatingSheet(r6);
        this._rows.put(Integer.valueOf(r6), r2);
        this.allFlushed = false;
        if (this._randomAccessWindowSize < 0) goto L28;
        int r7 = this._rows.size();
        int r3 = this._randomAccessWindowSize;
        if (r7 <= r3) goto L28;
        flushRows(r3);     // Catch: IOException -> L25
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    L28:
        return r2;
    L15:
        if (r6 > this._sh.getLastRowNum()) goto L19;
        throw new IllegalArgumentException("Attempting to write a row[" + r6 + "] in the range [0," + this._sh.getLastRowNum() + "] that is already written to disk.");
    L30:
        throw new IllegalArgumentException("Invalid row number (" + r6 + ") outside allowable range (0.." + r0 + ")");
    }

    public void flushRows(int r2) {
    L3:
        if (this._rows.size() <= r2) goto L5;
        flushOneRow();
        goto L3
    L5:
        if (r2 != 0) goto L9;
        this.allFlushed = true;
        return;
    }

    public CellStyle getColumnStyle(int r1) {
        return this._sh.getColumnStyle(r1);
    }

    public float getDefaultRowHeightInPoints() {
        return this._sh.getDefaultRowHeightInPoints();
    }

    public int getLastFlushedRowNum() {
        return this.lastFlushedRowNumber;
    }

    public int getLastRowNum() {
        if (this._rows.isEmpty() == false) goto L6;
        return -1;
    L6:
        return ((Integer) ZeusTransformUtils.preCheckCast(this._rows.lastKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        return this._sh.getMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        return this._sh.getNumMergedRegions();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size() + this._writer.getNumberOfFlushedRows();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row getRow(int r1) {
        return getRow(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFRow getRow(int r2) {
        return (SXSSFRow) ZeusTransformUtils.preCheckCast(this._rows.get(Integer.valueOf(r2)), SXSSFRow.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SheetConditionalFormatting getSheetConditionalFormatting() {
        return this._sh.getSheetConditionalFormatting();
    }

    SheetDataWriter getSheetDataWriter() {
        return this._writer;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this._sh.getSheetName();
    }

    @Override // org.apache.poi.xssf.usermodel.OoxmlSheetExtensions
    public XSSFVMLDrawing getVMLDrawing(boolean r2) {
        XSSFSheet r1 = getWorkbook().getXSSFSheet(this);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getVMLDrawing(r2);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Workbook getWorkbook() {
        return getWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public SXSSFWorkbook getWorkbook() {
        return this._workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<? extends Cell> removeArrayFormula(Cell r2) {
        Cell r1 = (Cell) ZeusTransformUtils.wrapperContextForParams(r2, Cell.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Not Implemented");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    public void setRandomAccessWindowSize(int r2) {
        if (r2 == 0) goto L8;
        if (r2 < (-1)) goto L8;
        this._randomAccessWindowSize = r2;
        return;
    L8:
        throw new IllegalArgumentException("RandomAccessWindowSize must be either -1 or a positive integer");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }

    void trackNewCell(SXSSFCell r3) {
        this.leftMostColumn = Math.min(r3.getColumnIndex(), this.leftMostColumn);
        this.rightMostColumn = Math.max(r3.getColumnIndex(), this.rightMostColumn);
    }
}
