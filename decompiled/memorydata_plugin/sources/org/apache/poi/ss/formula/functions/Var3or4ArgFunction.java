package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
abstract class Var3or4ArgFunction implements Function3Arg, Function4Arg {
    Var3or4ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r8, int r9, int r10) {
        int r0 = r8.length;
        if (r0 == 3) goto L11;
        if (r0 == 4) goto L9;
        return ErrorEval.VALUE_INVALID;
    L9:
        return evaluate(r9, r10, r8[0], r8[1], r8[2], r8[3]);
    L11:
        return evaluate(r9, r10, r8[0], r8[1], r8[2]);
    }
}
