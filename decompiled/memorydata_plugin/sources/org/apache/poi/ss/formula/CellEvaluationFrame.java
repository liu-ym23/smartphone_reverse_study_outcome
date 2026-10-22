package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class CellEvaluationFrame {
    private final FormulaCellCacheEntry _cce;
    private final Set<CellCacheEntry> _sensitiveInputCells;
    private FormulaUsedBlankCellSet _usedBlankCellGroup;

    public CellEvaluationFrame(FormulaCellCacheEntry r1) {
        this._cce = r1;
        this._sensitiveInputCells = new HashSet();
    }

    private CellCacheEntry[] getSensitiveInputCells() {
        int r0 = this._sensitiveInputCells.size();
        if (r0 < 1) goto L5;
        CellCacheEntry[] r1 = new CellCacheEntry[r0];
        this._sensitiveInputCells.toArray(r1);
        return r1;
    L5:
        return CellCacheEntry.EMPTY_ARRAY;
    }

    public void addSensitiveInputCell(CellCacheEntry r1) {
        this._sensitiveInputCells.add(r1);
    }

    public void addUsedBlankCell(EvaluationWorkbook r7, int r8, int r9, int r10, int r11) {
        EvaluationWorkbook r1 = (EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r7, EvaluationWorkbook.class, "com.obric.memorydata.plugin");
        if (this._usedBlankCellGroup != null) goto L5;
        this._usedBlankCellGroup = new FormulaUsedBlankCellSet();
    L5:
        this._usedBlankCellGroup.addCell(r1, r8, r9, r10, r11);
    }

    public CellCacheEntry getCCE() {
        return this._cce;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        r0.append(getClass().getName()).append(" [");
        r0.append(']');
        return r0.toString();
    }

    public void updateFormulaResult(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        this._cce.updateFormulaResult(r4, getSensitiveInputCells(), this._usedBlankCellGroup);
    }
}
