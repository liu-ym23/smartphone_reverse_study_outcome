package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ThreeDEval;

/* JADX INFO: loaded from: classes7.dex */
public interface AreaEval extends ThreeDEval {
    boolean containsColumn(int r1);

    boolean containsRow(int r1);

    ValueEval getAbsoluteValue(int r1, int r2);

    int getFirstColumn();

    int getFirstRow();

    int getHeight();

    int getLastColumn();

    int getLastRow();

    ValueEval getRelativeValue(int r1, int r2);

    int getWidth();

    AreaEval offset(int r1, int r2, int r3, int r4);
}
