package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
final class SXSSFEvaluationCell implements EvaluationCell {
    private final SXSSFCell _cell;
    private final EvaluationSheet _evalSheet;

    public SXSSFEvaluationCell(SXSSFCell r3) {
        this(r3, new SXSSFEvaluationSheet(r3.getSheet()));
    }

    public SXSSFEvaluationCell(SXSSFCell r1, SXSSFEvaluationSheet r2) {
        this._cell = r1;
        this._evalSheet = r2;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellRangeAddress getArrayFormulaRange() {
        return this._cell.getArrayFormulaRange();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean getBooleanCellValue() {
        return this._cell.getBooleanCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCachedFormulaResultType() {
        return this._cell.getCachedFormulaResultType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public CellType getCellType() {
        return this._cell.getCellType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getColumnIndex() {
        return this._cell.getColumnIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getErrorCellValue() {
        return this._cell.getErrorCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public Object getIdentityKey() {
        return this._cell;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public double getNumericCellValue() {
        return this._cell.getNumericCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getRowIndex() {
        return this._cell.getRowIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public EvaluationSheet getSheet() {
        return this._evalSheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public String getStringCellValue() {
        return this._cell.getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean isPartOfArrayFormulaGroup() {
        return this._cell.isPartOfArrayFormulaGroup();
    }
}
