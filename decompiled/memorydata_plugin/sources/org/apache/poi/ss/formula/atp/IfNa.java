package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public final class IfNa implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new IfNa();
    }

    private IfNa() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 2) goto L19;
        return ErrorEval.VALUE_INVALID;
    L19:
        return OperandResolver.getSingleValue(r3[0], r4.getRowIndex(), r4.getColumnIndex());
    L9:
        e = move-exception;
        ErrorEval r2 = e.getErrorEval();
        if (r2 == ErrorEval.NA) goto L21;
        return r2;
    L21:
        return OperandResolver.getSingleValue(r3[1], r4.getRowIndex(), r4.getColumnIndex());
    L16:
        e = move-exception;
        return e.getErrorEval();
    }
}
