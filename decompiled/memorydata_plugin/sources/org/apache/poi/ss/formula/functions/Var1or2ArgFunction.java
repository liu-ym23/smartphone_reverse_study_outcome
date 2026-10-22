package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
abstract class Var1or2ArgFunction implements Function1Arg, Function2Arg {
    Var1or2ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r5, int r6, int r7) {
        int r0 = r5.length;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L9;
        return ErrorEval.VALUE_INVALID;
    L9:
        return evaluate(r6, r7, r5[0], r5[1]);
    L11:
        return evaluate(r6, r7, r5[0]);
    }
}
