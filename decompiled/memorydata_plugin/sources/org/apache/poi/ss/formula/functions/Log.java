package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Log {
    private static final double LOG_10_TO_BASE_e = 0.0d;

    static {
        LOG_10_TO_BASE_e = Math.log(10.0d);
    }

    public static ValueEval evaluate(ValueEval[] r4, int r5, int r6) {
        if (r4.length == 1) goto L21;
        if (r4.length == 2) goto L21;
        return ErrorEval.VALUE_INVALID;
    L21:
        double r2 = NumericFunction.singleOperandEvaluate(r4[0], r5, r6);     // Catch: EvaluationException -> L18
        if (r4.length != 1) goto L12;
        double r7 = Math.log(r2) / LOG_10_TO_BASE_e;     // Catch: EvaluationException -> L18
    L16:
        NumericFunction.checkValue(r7);     // Catch: EvaluationException -> L18
        return new NumberEval(r7);
    L12:
        double r8 = NumericFunction.singleOperandEvaluate(r4[1], r5, r6);     // Catch: EvaluationException -> L18
        double r0 = Math.log(r2);     // Catch: EvaluationException -> L18
        if (Double.compare(r8, 2.718281828459045d) != 0) goto L15;
    L14:
        r7 = r0;
        goto L16
    L15:
        r0 = r0 / Math.log(r8);     // Catch: EvaluationException -> L18
    L18:
        e = move-exception;
        return e.getErrorEval();
    }
}
