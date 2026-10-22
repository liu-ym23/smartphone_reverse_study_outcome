package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class SheetRangeEvaluator implements SheetRange {
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private final SheetRefEvaluator[] _sheetEvaluators;

    public SheetRangeEvaluator(int r3, int r4, SheetRefEvaluator[] r5) {
        if (r3 < 0) goto L10;
        if (r4 < r3) goto L8;
        this._firstSheetIndex = r3;
        this._lastSheetIndex = r4;
        this._sheetEvaluators = (SheetRefEvaluator[]) ZeusTransformUtils.preCheckCast(r5.clone(), SheetRefEvaluator[].class, "com.obric.memorydata.plugin");
        return;
    L8:
        throw new IllegalArgumentException("Invalid lastSheetIndex: " + r4 + " for firstSheetIndex: " + r3 + ".");
    L10:
        throw new IllegalArgumentException("Invalid firstSheetIndex: " + r3 + ".");
    }

    public SheetRangeEvaluator(int r3, SheetRefEvaluator r4) {
        this(r3, r3, new SheetRefEvaluator[]{r4});
    }

    public int adjustRowNumber(int r6) {
        int r0 = this._firstSheetIndex;
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r0 > this._lastSheetIndex) goto L9;
        if (r6 < this._sheetEvaluators[r0 - this._firstSheetIndex].getMaxRowNum()) goto L8;
        r2 = true;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r2 == true) goto L11;
        return r6;
    L11:
        int r3 = this._firstSheetIndex;
    L13:
        if (r3 > this._lastSheetIndex) goto L16;
        r1 = Math.max(r1, this._sheetEvaluators[r3 - this._firstSheetIndex].getLastRowNum());
        r3 = r3 + 1;
        goto L13
    L16:
        return Math.min(r6, r1);
    }

    public ValueEval getEvalForCell(int r1, int r2, int r3) {
        return getSheetEvaluator(r1).getEvalForCell(r2, r3);
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    public SheetRefEvaluator getSheetEvaluator(int r4) {
        int r0 = this._firstSheetIndex;
        if (r4 < r0) goto L9;
        if (r4 > this._lastSheetIndex) goto L9;
        return this._sheetEvaluators[r4 - r0];
    L9:
        throw new IllegalArgumentException("Invalid SheetIndex: " + r4 + " - Outside range " + this._firstSheetIndex + " : " + this._lastSheetIndex);
    }

    public String getSheetName(int r1) {
        return getSheetEvaluator(r1).getSheetName();
    }

    public String getSheetNameRange() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getSheetName(this._firstSheetIndex));
        if (this._firstSheetIndex == this._lastSheetIndex) goto L6;
        r0.append(':');
        r0.append(getSheetName(this._lastSheetIndex));
    L6:
        return r0.toString();
    }
}
