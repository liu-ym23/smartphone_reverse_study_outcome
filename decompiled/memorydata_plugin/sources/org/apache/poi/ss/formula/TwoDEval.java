package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public interface TwoDEval extends ValueEval {
    TwoDEval getColumn(int r1);

    int getHeight();

    TwoDEval getRow(int r1);

    ValueEval getValue(int r1, int r2);

    int getWidth();

    boolean isColumn();

    default boolean isRow() {
        return false;
    }

    boolean isRowHidden(int r1);

    boolean isSubTotal(int r1, int r2);
}
