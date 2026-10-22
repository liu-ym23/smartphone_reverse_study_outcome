package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public interface ThreeDEval extends SheetRange, TwoDEval {
    ValueEval getValue(int r1, int r2, int r3);
}
