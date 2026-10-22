package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* JADX INFO: loaded from: classes7.dex */
public interface RefEval extends SheetRange, ValueEval {
    int getColumn();

    @Override // org.apache.poi.ss.formula.SheetRange
    int getFirstSheetIndex();

    ValueEval getInnerValueEval(int r1);

    @Override // org.apache.poi.ss.formula.SheetRange
    int getLastSheetIndex();

    int getNumberOfSheets();

    int getRow();

    AreaEval offset(int r1, int r2, int r3, int r4);
}
