package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Na {
    public static ValueEval evaluate(ValueEval[] r0, int r1, int r2) {
        if (r0.length == 0) goto L6;
        return ErrorEval.VALUE_INVALID;
    L6:
        return ErrorEval.NA;
    }
}
