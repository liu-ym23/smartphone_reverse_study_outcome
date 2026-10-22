package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: loaded from: classes7.dex */
final class XSSFEvaluationSheet implements EvaluationSheet {
    private Map<CellKey, EvaluationCell> _cellCache;
    private final XSSFSheet _xs;

    private static class CellKey {
        private final int _col;
        private int _hash;
        private final int _row;

        public CellKey(int r2, int r3) {
            this._hash = -1;
            this._row = r2;
            this._col = r3;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, CellKey.class) == true) goto L5;
            return false;
        L5:
            CellKey r5 = (CellKey) ZeusTransformUtils.preCheckCast(r4, CellKey.class, "com.obric.memorydata.plugin");
            if (this._row == r5._row) goto L8;
            return false;
        L8:
            if (this._col != r5._col) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            if (this._hash != (-1)) goto L6;
            this._hash = ((this._row + 629) * 37) + this._col;
        L6:
            return this._hash;
        }
    }

    public XSSFEvaluationSheet(XSSFSheet r1) {
        this._xs = r1;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int r10, int r11) {
        if (r10 <= getLastRowNum()) goto L6;
        return null;
    L6:
        if (this._cellCache != null) goto L14;
        this._cellCache = new HashMap(this._xs.getLastRowNum() * 3);
        Iterator<Row> r0 = this._xs.iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        Row r3 = (Row) ZeusTransformUtils.preCheckCast(r0.next(), Row.class, "com.obric.memorydata.plugin");
        int r4 = r3.getRowNum();
        Iterator<Cell> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L9;
        Cell r6 = (Cell) ZeusTransformUtils.preCheckCast(r5.next(), Cell.class, "com.obric.memorydata.plugin");
        CellKey r7 = new CellKey(r4, r6.getColumnIndex());
        XSSFEvaluationCell r8 = new XSSFEvaluationCell((XSSFCell) ZeusTransformUtils.preCheckCast(r6, XSSFCell.class, "com.obric.memorydata.plugin"), this);
        this._cellCache.put(r7, r8);
    L14:
        CellKey r1 = new CellKey(r10, r11);
        EvaluationCell r2 = (EvaluationCell) ZeusTransformUtils.preCheckCast(this._cellCache.get(r1), EvaluationCell.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L26;
        XSSFRow r12 = this._xs.getRow(r10);
        if (r12 != null) goto L19;
        return null;
    L19:
        XSSFCell r13 = r12.getCell(r11);
        if (r13 != null) goto L22;
        return null;
    L22:
        XSSFEvaluationCell r9 = new XSSFEvaluationCell(r13, this);
        this._cellCache.put(r1, r9);
        return r9;
    L26:
        return r2;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public int getLastRowNum() {
        return this._xs.getLastRowNum();
    }

    public XSSFSheet getXSSFSheet() {
        return this._xs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public boolean isRowHidden(int r1) {
        XSSFRow r0 = this._xs.getRow(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getZeroHeight();
    }
}
