package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
abstract class Var2or3ArgFunction implements Function2Arg, Function3Arg {
    Var2or3ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r7, int r8, int r9) {
        int r0 = r7.length;
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L9;
        return ErrorEval.VALUE_INVALID;
    L9:
        return evaluate(r8, r9, r7[0], r7[1], r7[2]);
    L11:
        return evaluate(r8, r9, r7[0], r7[1]);
    }
}
