package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dz;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.p;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFRow implements Comparable<XSSFRow>, Row {
    private final TreeMap<Integer, XSSFCell> _cells;
    private final dz _row;
    private final XSSFSheet _sheet;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFRow$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = null;

        static {
            int[] r0 = new int[Row.MissingCellPolicy.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy = r0;
            r0[Row.MissingCellPolicy.RETURN_NULL_AND_BLANK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.RETURN_BLANK_AS_NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[Row.MissingCellPolicy.CREATE_NULL_AS_BLANK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r3;
            r3[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public XSSFRow(dz r7, XSSFSheet r8) {
        dz r9 = (dz) ZeusTransformUtils.wrapperContextForParams(r7, dz.class, "com.obric.memorydata.plugin");
        this._row = r9;
        this._sheet = r8;
        this._cells = new TreeMap();
        p[] r0 = r9.getCArray();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        XSSFCell r4 = new XSSFCell(this, r0[r2]);
        this._cells.put(Integer.valueOf(r4.getColumnIndex()), r4);
        r8.onReadCell(r4);
        r2 = r2 + 1;
        goto L3
    L6:
        if (r9.isSetR() == true) goto L15;
        int r6 = r8.getLastRowNum() + 2;
        if (r6 == 2) goto L10;
    L12:
        r9.setR(r6);
        return;
    L10:
        if (r8.getPhysicalNumberOfRows() != 0) goto L12;
        r6 = 1;
        goto L12
    }

    private void fixupCTCells(p[] r11) {
        p[] r0 = new p[r11.length];
        IdentityHashMap r1 = new IdentityHashMap(this._cells.size());
        int r2 = r11.length;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= r2) goto L6;
        p r7 = r11[r4];
        r0[r5] = (p) ZeusTransformUtils.preCheckCast(r7.copy(), p.class, "com.obric.memorydata.plugin");
        r1.put(r7, Integer.valueOf(r5));
        r5 = r5 + 1;
        r4 = r4 + 1;
        goto L4
    L6:
        Iterator<XSSFCell> r6 = this._cells.values().iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        XSSFCell r8 = (XSSFCell) ZeusTransformUtils.preCheckCast(r6.next(), XSSFCell.class, "com.obric.memorydata.plugin");
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r1.get(r8.getCTCell()), Integer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r9, "Should find CTCell in _row");
        if (r9.intValue() == r3) goto L12;
        this._row.setCArray(r3, r0[r9.intValue()]);
        r8.setCTCell(this._row.getCArray(r3));
    L12:
        r3 = r3 + 1;
    L14:
        if (r11.length <= this._cells.size()) goto L16;
        this._row.removeC(this._cells.size());
        goto L14
    }

    private static void setDefaultValue(XSSFCell r2, CellType r3) {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r3.ordinal()];
        if (r0 != 1) goto L5;
        r2.setCellValue(0.0d);
        return;
    L5:
        if (r0 != 2) goto L7;
        r2.setCellValue("");
        return;
    L7:
        if (r0 != 3) goto L9;
        r2.setCellValue(false);
        return;
    L9:
        if (r0 != 4) goto L12;
        r2.setCellErrorValue(FormulaError._NO_ERROR);
        return;
    L12:
        throw new AssertionError("Unknown cell-type specified: " + r3);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public Iterator<Cell> cellIterator() {
        return this._cells.values().iterator();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(XSSFRow r3) {
        return compareTo2((XSSFRow) ZeusTransformUtils.preCheckCast(r3, XSSFRow.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(XSSFRow r3) {
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
    public XSSFCell createCell(int r2) {
        return createCell(r2, CellType.BLANK);
    }

    public XSSFCell createCell(int r6, CellType r7) {
        Integer r0 = Integer.valueOf(r6);
        XSSFCell r1 = (XSSFCell) ZeusTransformUtils.preCheckCast(this._cells.get(r0), XSSFCell.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        p r2 = r1.getCTCell();
        r2.set((XmlObject) ZeusTransformUtils.preCheckCast(p.f19779a.newInstance(), XmlObject.class, "com.obric.memorydata.plugin"));
    L6:
        XSSFCell r3 = new XSSFCell(this, r2);
        r3.setCellNum(r6);     // Catch: IllegalArgumentException -> L15
        if (r7 != CellType.BLANK) goto L11;
    L13:
        this._cells.put(r0, r3);
        return r3;
    L11:
        if (r7 == CellType.FORMULA) goto L13;
        setDefaultValue(r3, r7);
    L15:
        e = move-exception;
        this._row.removeC(this._row.getCList().size() - 1);
        throw e;
    L5:
        r2 = this._row.addNewC();
        goto L6
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFRow.class) == true) goto L5;
        return false;
    L5:
        XSSFRow r5 = (XSSFRow) ZeusTransformUtils.preCheckCast(r4, XSSFRow.class, "com.obric.memorydata.plugin");
        if (getRowNum() == r5.getRowNum()) goto L8;
        return false;
    L8:
        if (getSheet() != r5.getSheet()) goto L12;
        return true;
    L12:
        return false;
    }

    public dz getCTRow() {
        return this._row;
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
    public XSSFCell getCell(int r2) {
        return getCell(r2, this._sheet.getWorkbook().getMissingCellPolicy());
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFCell getCell(int r5, Row.MissingCellPolicy r6) {
        if (r5 < 0) goto L23;
        XSSFCell r0 = (XSSFCell) ZeusTransformUtils.preCheckCast(this._cells.get(Integer.valueOf(r5)), XSSFCell.class, "com.obric.memorydata.plugin");
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$Row$MissingCellPolicy[r6.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L6;
        return r0;
    L6:
        if (r1 != 2) goto L8;
        if (r0 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L26;
        return null;
    L26:
        return r0;
    L16:
        if (r0.getCellType() != CellType.BLANK) goto L18;
    L8:
        if (r1 != 3) goto L13;
        if (r0 == null) goto L11;
        return r0;
    L11:
        return createCell(r5, CellType.BLANK);
    L13:
        throw new IllegalArgumentException("Illegal policy " + r6);
    L23:
        throw new IllegalArgumentException("Cell index must be >= 0");
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getFirstCellNum() {
        if (this._cells.isEmpty() == false) goto L5;
        int r2 = -1;
    L7:
        return (short) r2;
    L5:
        r2 = ((Integer) ZeusTransformUtils.preCheckCast(this._cells.firstKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L7
    }

    public float getHeightInPoints() {
        if (this._row.isSetHt() == false) goto L7;
        return (float) this._row.getHt();
    L7:
        return this._sheet.getDefaultRowHeightInPoints();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public short getLastCellNum() {
        if (this._cells.isEmpty() == false) goto L5;
        int r2 = -1;
    L7:
        return (short) r2;
    L5:
        r2 = ((Integer) ZeusTransformUtils.preCheckCast(this._cells.lastKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() + 1;
        goto L7
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getPhysicalNumberOfCells() {
        return this._cells.size();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public int getRowNum() {
        return Math.toIntExact(this._row.getR() - 1);
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public /* bridge */ /* synthetic */ Sheet getSheet() {
        return getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Row
    public XSSFSheet getSheet() {
        return this._sheet;
    }

    public boolean getZeroHeight() {
        return this._row.getHidden();
    }

    public int hashCode() {
        return this._row.hashCode();
    }

    public void onDocumentWrite() {
        p[] r0 = this._row.getCArray();
        if (r0.length != this._cells.size()) goto L13;
        Iterator<XSSFCell> r1 = this._cells.values().iterator();
        int r2 = r0.length;
        boolean r3 = false;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L10;
        p r5 = r0[r4];
        XSSFCell r6 = (XSSFCell) ZeusTransformUtils.preCheckCast(r1.next(), XSSFCell.class, "com.obric.memorydata.plugin");
        r6.applyDefaultCellStyleIfNecessary();
        if (r5 != r6.getCTCell()) goto L11;
        r4 = r4 + 1;
    L11:
        if (r3 == false) goto L13;
        return;
    L10:
        r3 = true;
    L13:
        fixupCTCells(r0);
    }

    public void removeCell(Cell r7) {
        Cell r8 = (Cell) ZeusTransformUtils.wrapperContextForParams(r7, Cell.class, "com.obric.memorydata.plugin");
        if (r8.getRow() != this) goto L22;
        if (this._cells.containsValue(r8) == false) goto L20;
        XSSFCell r0 = (XSSFCell) ZeusTransformUtils.preCheckCast(r8, XSSFCell.class, "com.obric.memorydata.plugin");
        if (r0.isPartOfArrayFormulaGroup() == false) goto L10;
        r0.setCellFormula(null);
    L10:
        if (r8.getCellType() != CellType.FORMULA) goto L12;
        this._sheet.getWorkbook().onDeleteFormula(r0);
    L12:
        XSSFCell r9 = (XSSFCell) ZeusTransformUtils.preCheckCast(this._cells.remove(Integer.valueOf(r8.getColumnIndex())), XSSFCell.class, "com.obric.memorydata.plugin");
        p[] r1 = this._row.getCArray();
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L13:
        if (r3 >= r2) goto L18;
        if (r1[r3] != r9.getCTCell()) goto L17;
        this._row.removeC(r4);
    L17:
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L13
    L18:
        return;
    L20:
        throw new IllegalArgumentException("the row does not contain this cell");
    L22:
        throw new IllegalArgumentException("Specified cell does not belong to this row");
    }

    public void setRowNum(int r5) {
        int r0 = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        if (r5 < 0) goto L8;
        if (r5 > r0) goto L8;
        this._row.setR(((long) r5) + 1);
        return;
    L8:
        throw new IllegalArgumentException("Invalid row number (" + r5 + ") outside allowable range (0.." + r0 + ")");
    }

    @Override // org.apache.poi.ss.usermodel.Row, java.lang.Iterable
    public Spliterator<Cell> spliterator() {
        return this._cells.values().spliterator();
    }

    public String toString() {
        return this._row.toString();
    }
}
