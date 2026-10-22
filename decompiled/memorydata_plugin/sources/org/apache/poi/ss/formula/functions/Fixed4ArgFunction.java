package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Fixed4ArgFunction implements Function4Arg {
    public Fixed4ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r9, int r10, int r11) {
        if (r9.length == 4) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r10, r11, r9[0], r9[1], r9[2], r9[3]);
    }
}
