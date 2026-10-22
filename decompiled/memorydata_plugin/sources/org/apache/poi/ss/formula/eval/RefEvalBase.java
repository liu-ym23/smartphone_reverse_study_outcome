package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RefEvalBase implements RefEval {
    private final int _columnIndex;
    private final int _firstSheetIndex;
    private final int _lastSheetIndex;
    private final int _rowIndex;

    public RefEvalBase(SheetRange r3, int r4, int r5) {
        SheetRange r6 = (SheetRange) ZeusTransformUtils.wrapperContextForParams(r3, SheetRange.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        this._firstSheetIndex = r6.getFirstSheetIndex();
        this._lastSheetIndex = r6.getLastSheetIndex();
        this._rowIndex = r4;
        this._columnIndex = r5;
        return;
    L7:
        throw new IllegalArgumentException("sheetRange must not be null");
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getColumn() {
        return this._columnIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getFirstSheetIndex() {
        return this._firstSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval, org.apache.poi.ss.formula.SheetRange
    public int getLastSheetIndex() {
        return this._lastSheetIndex;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public int getNumberOfSheets() {
        return (this._lastSheetIndex - this._firstSheetIndex) + 1;
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public final int getRow() {
        return this._rowIndex;
    }
}
