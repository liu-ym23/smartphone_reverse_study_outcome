package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Poisson implements FreeRefFunction {
    public static final Poisson instance = null;

    static {
        instance = new Poisson();
    }

    public Poisson() {
    }

    private static void checkArgument(double r2) {
        NumericFunction.checkValue(r2);
        if (r2 < 0.0d) goto L6;
        return;
    L6:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    public static ValueEval evaluate(ValueEval[] r4, int r5, int r6) {
        if (r4.length != 3) goto L5;
        ValueEval r0 = r4[0];
        ValueEval r1 = r4[1];
        ValueEval r7 = r4[2];
        double r2 = NumericFunction.singleOperandEvaluate(r0, r5, r6);     // Catch: EvaluationException -> L18
        double r8 = NumericFunction.singleOperandEvaluate(r1, r5, r6);     // Catch: EvaluationException -> L20
        if (isDefaultResult(r2, r8) == true) goto L11;
        checkArgument(r2);     // Catch: EvaluationException -> L20
        checkArgument(r8);     // Catch: EvaluationException -> L20
        boolean r9 = ((BoolEval) ZeusTransformUtils.preCheckCast(r7, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue();     // Catch: EvaluationException -> L20
        PoissonDistribution r3 = new PoissonDistribution(r8);     // Catch: EvaluationException -> L20
        if (r9 == false) goto L15;
        double r10 = r3.cumulativeProbability((int) r2);     // Catch: EvaluationException -> L20
    L16:
        NumericFunction.checkValue(r10);     // Catch: EvaluationException -> L20
        return new NumberEval(r10);
    L15:
        r10 = r3.probability((int) r2);     // Catch: EvaluationException -> L20
        goto L16
    L11:
        return new NumberEval(1.0d);
    L20:
        e = move-exception;
        return e.getErrorEval();
    L19:
        return ErrorEval.VALUE_INVALID;
    L5:
        return ErrorEval.VALUE_INVALID;
    }

    private static boolean isDefaultResult(double r2, double r4) {
        if (r2 == 0.0d) goto L5;
    L7:
        return false;
    L5:
        if (r4 != 0.0d) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r1, OperationEvaluationContext r2) {
        return evaluate(r1, r2.getRowIndex(), r2.getColumnIndex());
    }
}
