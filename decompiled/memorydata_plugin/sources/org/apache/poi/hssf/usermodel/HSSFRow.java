package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.Configurator;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFRow implements Comparable<HSSFRow>, Row {
    public static final int INITIAL_CAPACITY = 0;
    private final HSSFWorkbook book;
    private HSSFCell[] cells;
    private final RowRecord row;
    private int rowNum;
    private final HSSFSheet sheet;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFRow$1, reason: invalid class name */
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

    private class CellIterator implements Iterator<Cell> {
        int nextId;
        final /* synthetic */ HSSFRow this$0;
        int thisId;

        public CellIterator(HSSFRow r1) {
            this.this$0 = r1;
            this.thisId = -1;
            this.nextId = -1;
            findNext();
        }

        private void findNext() {
            int r0 = this.nextId;
        L3:
            r0 = r0 + 1;
            if (r0 >= HSSFRow.access$000(this.this$0).length) goto L7;
            if (HSSFRow.access$000(this.this$0)[r0] == null) goto L3;
        L7:
            this.nextId = r0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextId >= HSSFRow.access$000(this.this$0).length) goto L5;
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
            HSSFCell[] r0 = HSSFRow.access$000(this.this$0);
            int r1 = this.nextId;
            HSSFCell r2 = r0[r1];
            this.thisId = r1;
            findNext();
            return r2;
        L7:
            throw new NoSuchElementException("At last element");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.thisId == (-1)) goto L7;
            HSSFRow.access$000(this.this$0)[this.thisId] = null;
            return;
        L7:
            throw new IllegalStateException("remove() called before next()");
        }
    }

    static {
        INITIAL_CAPACITY = Configurator.getIntValue("HSSFRow.ColInitialCapacity", 5);
    }

    HSSFRow(HSSFWorkbook r2, HSSFSheet r3, int r4) {
        this(r2, r3, new RowRecord(r4));
    }

    HSSFRow(HSSFWorkbook r1, HSSFSheet r2, RowRecord r3) {
        this.book = r1;
        this.sheet = r2;
        this.row = r3;
        setRowNum(r3.getRowNumber());
        if (r3.getLastCol() < 0) goto L9;
        int r4 = INITIAL_CAPACITY;
        if (r4 < 0) goto L9;
        this.cells = new HSSFCell[r3.getLastCol() + r4];
        r3.setEmpty();
        return;
    L9:
        throw new IllegalArgumentException("Had invalid column counts: " + r3.getLastCol() + " and " + INITIAL_CAPACITY);
    }

    static /* synthetic */ HSSFCell[] access$000(HSSFRow r0) {
        return r0.cells;
    }

    private void addCell(HSSFCell r6) {
        int r0 = r6.getColumnIndex();
        HSSFCell[] r1 = this.cells;
        if (r0 < r1.length) goto L8;
        int r2 = ((r1.length * 3) / 2) + 1;
        if (r2 >= (r0 + 1)) goto L7;
        r2 = INITIAL_CAPACITY + r0;
    L7:
        HSSFCell[] r3 = new HSSFCell[r2];
        this.cells = r3;
        System.arraycopy(r1, 0, r3, 0, r1.length);
    L8:
        this.cells[r0] = r6;
        if (this.row.isEmpty() == false) goto L11;
    L12:
        this.row.setFirstCol((short) r0);
    L14:
        if (this.row.isEmpty() == false) goto L16;
    L17:
        this.row.setLastCol((short) (r0 + 1));
        return;
    L16:
        if (r0 >= this.row.getLastCol()) goto L17;
        return;
    L11:
        if (r0 >= this.row.getFirstCol()) goto L14;
        goto L12
    }

    private HSSFCell retrieveCell(int r2) {
        if (r2 < 0) goto L8;
        HSSFCell[] r1 = this.cells;
        if (r2 < r1.length) goto L7;
        return null;
    L7:
        return r1[r2];
    L8:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return new CellIterator(this);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(HSSFRow r3) {
        return compareTo2((HSSFRow) ZeusTransformUtils.preCheckCast(r3, HSSFRow.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HSSFRow r3) {
        if (getSheet() != r3.getSheet()) goto L7;
        return Integer.compare(getRowNum(), r3.getRowNum());
    L7:
        throw new IllegalArgumentException("The compared rows must belong to the same sheet");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell createCell(int r2) {
        return createCell(r2, CellType.BLANK);
    }

    public HSSFCell createCell(int r8, CellType r9) {
        short r0 = (short) r8;
        if (r8 <= 32767) goto L5;
        r0 = (short) (65535 - r8);
    L5:
        HSSFWorkbook r2 = this.book;
        HSSFSheet r3 = this.sheet;
        int r4 = getRowNum();
        HSSFCell r10 = new HSSFCell(r2, r3, r4, r0, r9);
        addCell(r10);
        this.sheet.getSheet().addValueRecord(getRowNum(), r10.getCellValueRecord());
        return r10;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell createCell(int r1) {
        return createCell(r1);
    }

    HSSFCell createCellFromRecord(CellValueRecordInterface r4) {
        CellValueRecordInterface r5 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        HSSFCell r0 = new HSSFCell(this.book, this.sheet, r5);
        addCell(r0);
        short r6 = r5.getColumn();
        if (this.row.isEmpty() == false) goto L7;
        this.row.setFirstCol(r6);
    L5:
        this.row.setLastCol(r6 + 1);
    L12:
        return r0;
    L7:
        if (r6 >= this.row.getFirstCol()) goto L10;
        this.row.setFirstCol(r6);
        goto L12
    L10:
        if (r6 <= this.row.getLastCol()) goto L12;
        goto L12
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, HSSFRow.class) == true) goto L5;
        return false;
    L5:
        HSSFRow r5 = (HSSFRow) ZeusTransformUtils.preCheckCast(r4, HSSFRow.class, "com.obric.memorydata.plugin");
        if (getRowNum() == r5.getRowNum()) goto L8;
        return false;
    L8:
        if (getSheet() != r5.getSheet()) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int r2) {
        return getCell(r2, this.book.getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFCell getCell(int r5, Row.MissingCellPolicy r6) {
        HSSFCell r0 = retrieveCell(r5);
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

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell getCell(int r1) {
        return getCell(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Cell getCell(int r1, Row.MissingCellPolicy r2) {
        return getCell(r1, r2);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        if (this.row.isEmpty() == false) goto L7;
        return -1;
    L7:
        return (short) this.row.getFirstCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this.row.isEmpty() == false) goto L7;
        return -1;
    L7:
        return (short) this.row.getLastCol();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        HSSFCell[] r4 = this.cells;
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4[r1] == null) goto L7;
        r2 = r2 + 1;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return this.rowNum;
    }

    public RowRecord getRowRecord() {
        return this.row;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public HSSFSheet getSheet() {
        return this.sheet;
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Sheet getSheet() {
        return getSheet();
    }

    public boolean getZeroHeight() {
        return this.row.getZeroHeight();
    }

    public int hashCode() {
        return this.row.hashCode();
    }

    public void setHeight(short r3) {
        if (r3 != (-1)) goto L5;
        this.row.setHeight(-32513);
        this.row.setBadFontHeight(false);
        return;
    L5:
        this.row.setBadFontHeight(true);
        this.row.setHeight(r3);
    }

    public void setRowNum(int r4) {
        int r0 = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (r4 < 0) goto L10;
        if (r4 > r0) goto L10;
        this.rowNum = r4;
        RowRecord r3 = this.row;
        if (r3 == null) goto L11;
        r3.setRowNumber(r4);
        return;
    L11:
        return;
    L10:
        throw new IllegalArgumentException("Invalid row number (" + r4 + ") outside allowable range (0.." + r0 + ")");
    }
}
