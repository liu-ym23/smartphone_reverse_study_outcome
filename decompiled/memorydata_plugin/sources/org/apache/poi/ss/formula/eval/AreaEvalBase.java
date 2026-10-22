package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.SheetRange;
import org.apache.poi.ss.formula.ptg.AreaI;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AreaEvalBase implements AreaEval {
    private final int _firstColumn;
    private final int _firstRow;
    private final int _firstSheet;
    private final int _lastColumn;
    private final int _lastRow;
    private final int _lastSheet;
    private final int _nColumns;
    private final int _nRows;

    public AreaEvalBase(int r7, int r8, int r9, int r10) {
        this(null, r7, r8, r9, r10);
    }

    public AreaEvalBase(SheetRange r3, int r4, int r5, int r6, int r7) {
        SheetRange r8 = (SheetRange) ZeusTransformUtils.wrapperContextForParams(r3, SheetRange.class, "com.obric.memorydata.plugin");
        this._firstColumn = r5;
        this._firstRow = r4;
        this._lastColumn = r7;
        this._lastRow = r6;
        this._nColumns = (r7 - r5) + 1;
        this._nRows = (r6 - r4) + 1;
        if (r8 == null) goto L5;
        this._firstSheet = r8.getFirstSheetIndex();
        int r9 = r8.getLastSheetIndex();
    L6:
        this._lastSheet = r9;
        return;
    L5:
        r9 = -1;
        this._firstSheet = -1;
        goto L6
    }

    public AreaEvalBase(AreaI r3) {
        this((AreaI) ZeusTransformUtils.wrapperContextForParams(r3, AreaI.class, "com.obric.memorydata.plugin"), null);
    }

    public AreaEvalBase(AreaI r7, SheetRange r8) {
        AreaI r9 = (AreaI) ZeusTransformUtils.wrapperContextForParams(r7, AreaI.class, "com.obric.memorydata.plugin");
        this((SheetRange) ZeusTransformUtils.wrapperContextForParams(r8, SheetRange.class, "com.obric.memorydata.plugin"), r9.getFirstRow(), r9.getFirstColumn(), r9.getLastRow(), r9.getLastColumn());
    }

    public final boolean contains(int r2, int r3) {
        if (this._firstRow <= r2) goto L5;
    L11:
        return false;
    L5:
        if (this._lastRow < r2) goto L11;
        if (this._firstColumn > r3) goto L11;
        if (this._lastColumn < r3) goto L11;
        return true;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final boolean containsColumn(int r2) {
        if (this._firstColumn <= r2) goto L5;
    L7:
        return false;
    L5:
        if (this._lastColumn < r2) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final boolean containsRow(int r2) {
        if (this._firstRow <= r2) goto L5;
    L7:
        return false;
    L5:
        if (this._lastRow < r2) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final ValueEval getAbsoluteValue(int r7, int r8) {
        int r0 = r7 - this._firstRow;
        int r1 = r8 - this._firstColumn;
        if (r0 < 0) goto L14;
        if (r0 >= this._nRows) goto L14;
        if (r1 < 0) goto L12;
        if (r1 >= this._nColumns) goto L12;
        return getRelativeValue(r0, r1);
    L12:
        throw new IllegalArgumentException("Specified column index (" + r8 + ") is outside the allowed range (" + this._firstColumn + ".." + r8 + ")");
    L14:
        throw new IllegalArgumentException("Specified row index (" + r7 + ") is outside the allowed range (" + this._firstRow + ".." + this._lastRow + ")");
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getFirstColumn() {
        return this._firstColumn;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getFirstRow() {
        return this._firstRow;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheet;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
    public int getHeight() {
        return (this._lastRow - this._firstRow) + 1;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getLastColumn() {
        return this._lastColumn;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public final int getLastRow() {
        return this._lastRow;
    }

    @Override // org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheet;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public abstract ValueEval getRelativeValue(int r1, int r2);

    public abstract ValueEval getRelativeValue(int r1, int r2, int r3);

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final ValueEval getValue(int r1, int r2) {
        return getRelativeValue(r1, r2);
    }

    @Override // org.apache.poi.ss.formula.ThreeDEval
    public final ValueEval getValue(int r1, int r2, int r3) {
        return getRelativeValue(r1, r2, r3);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
    public int getWidth() {
        return (this._lastColumn - this._firstColumn) + 1;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final boolean isColumn() {
        if (this._firstColumn != this._lastColumn) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public final boolean isRow() {
        if (this._firstRow != this._lastRow) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRowHidden(int r1) {
        return false;
    }

    public boolean isSubTotal(int r1, int r2) {
        return false;
    }
}
