package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
final class LazyAreaEval extends AreaEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyAreaEval(int r7, int r8, int r9, int r10, SheetRangeEvaluator r11) {
        super(r11, r7, r8, r11.adjustRowNumber(r9), r10);
        this._evaluator = r11;
    }

    LazyAreaEval(AreaI r3, SheetRangeEvaluator r4) {
        super((AreaI) ZeusTransformUtils.wrapperContextForParams(r3, AreaI.class, "com.obric.memorydata.plugin"), r4);
        this._evaluator = r4;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getColumn(int r8) {
        if (r8 >= getWidth()) goto L7;
        int r5 = getFirstColumn() + r8;
        return new LazyAreaEval(getFirstRow(), r5, getLastRow(), r5, this._evaluator);
    L7:
        throw new IllegalArgumentException("Invalid columnIndex " + r8 + ".  Allowable range is (0.." + getWidth() + ").");
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public /* bridge */ /* synthetic */ TwoDEval getColumn(int r1) {
        return getColumn(r1);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int r2, int r3) {
        return getRelativeValue(getFirstSheetIndex(), r2, r3);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int r2, int r3, int r4) {
        int r5 = r3 + getFirstRow();
        int r6 = r4 + getFirstColumn();
        return this._evaluator.getEvalForCell(r2, r5, r6);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getRow(int r8) {
        if (r8 >= getHeight()) goto L7;
        int r4 = getFirstRow() + r8;
        return new LazyAreaEval(r4, getFirstColumn(), r4, getLastColumn(), this._evaluator);
    L7:
        throw new IllegalArgumentException("Invalid rowIndex " + r8 + ".  Allowable range is (0.." + getHeight() + ").");
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public /* bridge */ /* synthetic */ TwoDEval getRow(int r1) {
        return getRow(r1);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isRowHidden(int r3) {
        SheetRangeEvaluator r0 = this._evaluator;
        return r0.getSheetEvaluator(r0.getFirstSheetIndex()).isRowHidden(getFirstRow() + r3);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isSubTotal(int r3, int r4) {
        SheetRangeEvaluator r0 = this._evaluator;
        return r0.getSheetEvaluator(r0.getFirstSheetIndex()).isSubTotal(getFirstRow() + r3, getFirstColumn() + r4);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int r9, int r10, int r11, int r12) {
        return new LazyAreaEval(new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), r9, r10, r11, r12), this._evaluator);
    }

    public String toString() {
        return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + new CellReference(getFirstRow(), getFirstColumn()).formatAsString() + ':' + new CellReference(getLastRow(), getLastColumn()).formatAsString() + "]";
    }
}
