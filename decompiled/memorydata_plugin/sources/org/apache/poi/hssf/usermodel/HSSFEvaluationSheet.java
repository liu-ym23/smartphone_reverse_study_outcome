package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;

/* JADX INFO: loaded from: classes7.dex */
final class HSSFEvaluationSheet implements EvaluationSheet {
    private final HSSFSheet _hs;

    public HSSFEvaluationSheet(HSSFSheet r1) {
        this._hs = r1;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int r2, int r3) {
        HSSFRow r4 = this._hs.getRow(r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        HSSFCell r5 = r4.getCell(r3);
        if (r5 != null) goto L9;
        return null;
    L9:
        return new HSSFEvaluationCell(r5, this);
    }

    public HSSFSheet getHSSFSheet() {
        return this._hs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public int getLastRowNum() {
        return this._hs.getLastRowNum();
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public boolean isRowHidden(int r1) {
        HSSFRow r0 = this._hs.getRow(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getZeroHeight();
    }
}
