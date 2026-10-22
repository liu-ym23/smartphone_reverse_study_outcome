package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.RefEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class LazyRefEval extends RefEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyRefEval(int r1, int r2, SheetRangeEvaluator r3) {
        super(r3, r1, r2);
        this._evaluator = r3;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public ValueEval getInnerValueEval(int r3) {
        return this._evaluator.getEvalForCell(r3, getRow(), getColumn());
    }

    public boolean isRowHidden() {
        SheetRangeEvaluator r0 = this._evaluator;
        return r0.getSheetEvaluator(r0.getFirstSheetIndex()).isRowHidden(getRow());
    }

    public boolean isSubTotal() {
        return this._evaluator.getSheetEvaluator(getFirstSheetIndex()).isSubTotal(getRow(), getColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public AreaEval offset(int r9, int r10, int r11, int r12) {
        return new LazyAreaEval(new AreaI.OffsetArea(getRow(), getColumn(), r9, r10, r11, r12), this._evaluator);
    }

    public String toString() {
        return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + new CellReference(getRow(), getColumn()).formatAsString() + "]";
    }
}
