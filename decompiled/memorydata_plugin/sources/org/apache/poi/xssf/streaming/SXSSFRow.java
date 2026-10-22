package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: loaded from: classes7.dex */
public class SXSSFRow implements Comparable<SXSSFRow>, Row {
    private static final Boolean UNDEFINED = null;
    private final SortedMap<Integer, SXSSFCell> _cells;
    private Boolean _collapsed;
    private short _height;
    private Boolean _hidden;
    private int _outlineLevel;
    private int _rowNum;
    private final SXSSFSheet _sheet;
    private short _style;
    private boolean _zHeight;

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SXSSFRow$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = null;

        static {
            int[] r0 = new int[Row.MissingCellPolicy.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = r0;
            r0[Row.MissingCellPolicy.RETURN_NULL_AND_BLANK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.RETURN_BLANK_AS_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.CREATE_NULL_AS_BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class CellIterator implements Iterator<Cell> {
        final int maxColumn;
        int pos;
        final /* synthetic */ SXSSFRow this$0;

        public CellIterator(SXSSFRow r1) {
            this.this$0 = r1;
            this.maxColumn = r1.getLastCellNum();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pos >= this.maxColumn) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Cell next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Cell next2() {
            if (hasNext() == false) goto L7;
            SortedMap r0 = SXSSFRow.access$000(this.this$0);
            int r1 = this.pos;
            this.pos = r1 + 1;
            return (Cell) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r1)), Cell.class, "com.obric.memorydata.plugin");
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class FilledCellIterator implements Iterator<Cell> {
        private final Iterator<SXSSFCell> iter;
        final /* synthetic */ SXSSFRow this$0;

        public FilledCellIterator(SXSSFRow r1) {
            this.this$0 = r1;
            this.iter = SXSSFRow.access$000(r1).values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Cell next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Cell next2() {
            return (Cell) ZeusTransformUtils.preCheckCast(this.iter.next(), Cell.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
    }

    public SXSSFRow(SXSSFSheet r2) {
        this._cells = new TreeMap();
        this._style = -1;
        this._height = -1;
        Boolean r0 = UNDEFINED;
        this._hidden = r0;
        this._collapsed = r0;
        this._sheet = r2;
    }

    static /* synthetic */ SortedMap access$000(SXSSFRow r0) {
        return r0._cells;
    }

    private static void checkBounds(int r5) {
        SpreadsheetVersion r0 = SpreadsheetVersion.EXCEL2007;
        int r1 = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        if (r5 < 0) goto L7;
        if (r5 > r1) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid column index (" + r5 + ").  Allowable column range for " + r0.name() + " is (0.." + r1 + ") or ('A'..'" + r0.getLastColumnName() + "')");
    }

    public Iterator<Cell> allCellsIterator() {
        return new CellIterator(this);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return new FilledCellIterator(this);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(SXSSFRow r3) {
        return compareTo2((SXSSFRow) ZeusTransformUtils.preCheckCast(r3, SXSSFRow.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SXSSFRow r3) {
        if (getSheet() != r3.getSheet()) goto L7;
        return Integer.compare(getRowNum(), r3.getRowNum());
    L7:
        throw new IllegalArgumentException("The compared rows must belong to the same sheet");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell createCell(int r1) {
        return createCell(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell createCell(int r2) {
        return createCell(r2, CellType.BLANK);
    }

    public SXSSFCell createCell(int r2, CellType r3) {
        checkBounds(r2);
        SXSSFCell r0 = new SXSSFCell(this, r3);
        this._cells.put(Integer.valueOf(r2), r0);
        this._sheet.trackNewCell(r0);
        return r0;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SXSSFRow.class) == true) goto L5;
        return false;
    L5:
        SXSSFRow r5 = (SXSSFRow) ZeusTransformUtils.preCheckCast(r4, SXSSFRow.class, "com.obric.memorydata.plugin");
        if (getRowNum() == r5.getRowNum()) goto L8;
        return false;
    L8:
        if (getSheet() != r5.getSheet()) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell getCell(int r1) {
        return getCell(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell getCell(int r1, Row.MissingCellPolicy r2) {
        return getCell(r1, r2);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int r2) {
        return getCell(r2, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFCell getCell(int r5, Row.MissingCellPolicy r6) {
        checkBounds(r5);
        SXSSFCell r0 = (SXSSFCell) ZeusTransformUtils.preCheckCast(this._cells.get(Integer.valueOf(r5)), SXSSFCell.class, "com.obric.memorydata.plugin");
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[r6.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L5;
        return r0;
    L5:
        if (r1 != 2) goto L7;
        if (r0 != null) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L23;
        return null;
    L23:
        return r0;
    L15:
        if (r0.getCellType() != CellType.BLANK) goto L17;
    L7:
        if (r1 != 3) goto L12;
        if (r0 == null) goto L10;
        return r0;
    L10:
        return createCell(r5, CellType.BLANK);
    L12:
        throw new IllegalArgumentException("Illegal policy " + r6);
    }

    int getCellIndex(SXSSFCell r4) {
        Iterator<Map.Entry<Integer, SXSSFCell>> r3 = this._cells.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0.getValue() != r4) goto L4;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L9:
        return -1;
    }

    public Boolean getCollapsed() {
        return this._collapsed;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        return ((Integer) ZeusTransformUtils.preCheckCast(this._cells.firstKey(), Integer.class, "com.obric.memorydata.plugin")).shortValue();
    L4:
        return -1;
    }

    public float getHeightInPoints() {
        short r0 = this._height;
        if (r0 != (-1)) goto L5;
        double r1 = getSheet().getDefaultRowHeightInPoints();
    L7:
        return (float) r1;
    L5:
        r1 = ((double) r0) / 20.0d;
        goto L7
    }

    public Boolean getHidden() {
        return this._hidden;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this._cells.isEmpty() == false) goto L6;
        return -1;
    L6:
        return (short) (((Integer) ZeusTransformUtils.preCheckCast(this._cells.lastKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() + 1);
    }

    public int getOutlineLevel() {
        return this._outlineLevel;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this._rowNum;
    }

    int getRowStyleIndex() {
        return this._style;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Sheet getSheet() {
        return getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public SXSSFSheet getSheet() {
        return this._sheet;
    }

    public boolean getZeroHeight() {
        return this._zHeight;
    }

    public boolean hasCustomHeight() {
        if (this._height == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this._cells.hashCode();
    }

    public boolean isFormatted() {
        if (this._style <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    void setRowNumWithoutUpdatingSheet(int r1) {
        this._rowNum = r1;
    }

    @Override // org.apache.poi.ss.usermodel.Row, java.lang.Iterable
    public Spliterator<Cell> spliterator() {
        return this._cells.values().spliterator();
    }
}
