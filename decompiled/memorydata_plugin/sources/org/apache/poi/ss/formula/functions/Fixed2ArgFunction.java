package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Fixed2ArgFunction implements Function2Arg {
    public Fixed2ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r3, int r4, int r5) {
        if (r3.length == 2) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4, r5, r3[0], r3[1]);
    }
}
