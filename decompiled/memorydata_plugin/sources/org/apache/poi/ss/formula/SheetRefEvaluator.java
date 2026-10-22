package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;

/* JADX INFO: loaded from: classes7.dex */
final class SheetRefEvaluator {
    private final WorkbookEvaluator _bookEvaluator;
    private EvaluationSheet _sheet;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;

    public SheetRefEvaluator(WorkbookEvaluator r1, EvaluationTracker r2, int r3) {
        if (r3 < 0) goto L7;
        this._bookEvaluator = r1;
        this._tracker = r2;
        this._sheetIndex = r3;
        return;
    L7:
        throw new IllegalArgumentException("Invalid sheetIndex: " + r3 + ".");
    }

    private EvaluationSheet getSheet() {
        if (this._sheet != null) goto L6;
        this._sheet = this._bookEvaluator.getSheet(this._sheetIndex);
    L6:
        return this._sheet;
    }

    public ValueEval getEvalForCell(int r7, int r8) {
        return this._bookEvaluator.evaluateReference(getSheet(), this._sheetIndex, r7, r8, this._tracker);
    }

    public int getLastRowNum() {
        return getSheet().getLastRowNum();
    }

    public int getMaxRowNum() {
        return this._bookEvaluator.getWorkbook().getSpreadsheetVersion().getLastRowIndex();
    }

    public String getSheetName() {
        return this._bookEvaluator.getSheetName(this._sheetIndex);
    }

    public boolean isRowHidden(int r1) {
        return getSheet().isRowHidden(r1);
    }

    public boolean isSubTotal(int r5, int r6) {
        EvaluationCell r7 = getSheet().getCell(r5, r6);
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.getCellType() != CellType.FORMULA) goto L19;
        Ptg[] r4 = this._bookEvaluator.getWorkbook().getFormulaTokens(r7);
        int r8 = r4.length;
        int r0 = 0;
    L7:
        if (r0 >= r8) goto L21;
        Ptg r1 = r4[r0];
        if (ZeusTransformUtils.instanceOf(r1, FuncVarPtg.class) == false) goto L13;
        if ("SUBTOTAL".equals(((FuncVarPtg) ZeusTransformUtils.preCheckCast(r1, FuncVarPtg.class, "com.obric.memorydata.plugin")).getName()) == false) goto L13;
        return true;
    L13:
        r0 = r0 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    }
}
