package org.apache.poi.xssf.streaming;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;

/* JADX INFO: loaded from: classes7.dex */
final class SXSSFEvaluationSheet implements EvaluationSheet {
    private final SXSSFSheet _xs;

    public SXSSFEvaluationSheet(SXSSFSheet r1) {
        this._xs = r1;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int r3, int r4) {
        SXSSFRow r0 = this._xs.getRow(r3);
        if (r0 == null) goto L5;
        SXSSFCell r5 = r0.getCell(r4);
        if (r5 != null) goto L13;
        return null;
    L13:
        return new SXSSFEvaluationCell(r5, this);
    L5:
        if (r3 <= this._xs.getLastFlushedRowNum()) goto L8;
        return null;
    L8:
        throw new SXSSFFormulaEvaluator.RowFlushedException(r3, this._xs.getLastFlushedRowNum());
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public int getLastRowNum() {
        return this._xs.getLastRowNum();
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public boolean isRowHidden(int r1) {
        SXSSFRow r0 = this._xs.getRow(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getZeroHeight();
    }
}
