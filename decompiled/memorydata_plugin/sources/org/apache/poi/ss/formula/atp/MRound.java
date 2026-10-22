package org.apache.poi.ss.formula.atp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.NumericFunction;

/* JADX INFO: loaded from: classes7.dex */
final class MRound implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new MRound();
    }

    private MRound() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r7, OperationEvaluationContext r8) {
        if (r7.length == 2) goto L20;
        return ErrorEval.VALUE_INVALID;
    L20:
        double r0 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r7[0], r8.getRowIndex(), r8.getColumnIndex()));     // Catch: EvaluationException -> L17
        double r9 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r7[1], r8.getRowIndex(), r8.getColumnIndex()));     // Catch: EvaluationException -> L17
        double r2 = 0.0d;
        if (r9 != 0.0d) goto L11;
    L13:
        NumericFunction.checkValue(r2);     // Catch: EvaluationException -> L17
        return new NumberEval(r2);
    L11:
        if ((r0 * r9) < 0.0d) goto L16;
        BigDecimal r10 = BigDecimal.valueOf(r9);     // Catch: EvaluationException -> L17
        r2 = r10.multiply(BigDecimal.valueOf(r0).divide(r10, 0, RoundingMode.HALF_UP)).doubleValue();     // Catch: EvaluationException -> L17
        goto L13
    L16:
        throw new EvaluationException(ErrorEval.NUM_ERROR);     // Catch: EvaluationException -> L17
    L17:
        e = move-exception;
        return e.getErrorEval();
    }
}
