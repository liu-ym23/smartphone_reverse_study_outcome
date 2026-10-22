package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Fixed3ArgFunction implements Function3Arg {
    public Fixed3ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r8, int r9, int r10) {
        if (r8.length == 3) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r9, r10, r8[0], r8[1], r8[2]);
    }
}
