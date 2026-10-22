package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class RandBetween implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new RandBetween();
    }

    private RandBetween() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r7, OperationEvaluationContext r8) {
        if (r7.length == 2) goto L18;
        return ErrorEval.VALUE_INVALID;
    L18:
        double r0 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r7[0], r8.getRowIndex(), r8.getColumnIndex()));     // Catch: EvaluationException -> L16
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r7[1], r8.getRowIndex(), r8.getColumnIndex()));     // Catch: EvaluationException -> L16
        if (r0 <= r6) goto L11;
        return ErrorEval.NUM_ERROR;
    L11:
        double r1 = Math.ceil(r0);
        double r9 = Math.floor(r6);
        if (r1 <= r9) goto L15;
        r9 = r1;
    L15:
        return new NumberEval(r1 + ((long) (Math.random() * ((r9 - r1) + 1.0d))));
    L17:
        return ErrorEval.VALUE_INVALID;
    }
}
