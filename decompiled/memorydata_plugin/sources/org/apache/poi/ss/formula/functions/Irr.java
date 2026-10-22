package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Irr implements Function {
    private static final c LOGGER = null;

    static {
        LOGGER = b.a(Irr.class);
    }

    public Irr() {
    }

    public static double irr(double[] r22, double r23) {
        char r1 = 0;
        double r2 = r23;
        int r4 = 0;
    L4:
        if (r4 >= 1000) goto L22;
        double r8 = 1.0d + r2;
        if (r8 == 0.0d) goto L7;
        double r12 = r22[r1];
        int r5 = 1;
        double r16 = r8;
        double r14 = 0.0d;
    L11:
        if (r5 >= r22.length) goto L14;
        double r18 = r22[r5];
        r12 = r12 + (r18 / r16);
        r16 = r16 * r8;
        r14 = r14 - ((((double) r5) * r18) / r16);
        r5 = r5 + 1;
        goto L11
    L14:
        if (r14 == 0.0d) goto L15;
        double r6 = r2 - (r12 / r14);
        if (Math.abs(r6 - r2) <= 1.0E-7d) goto L20;
        r4 = r4 + 1;
        r2 = r6;
        r1 = 0;
        goto L4
    L20:
        return r6;
    L15:
        LOGGER.atWarn().a("Returning NaN because IRR has found an fDerivative of 0");
        return Double.NaN;
    L7:
        LOGGER.atWarn().a("Returning NaN because IRR has found an denominator of 0");
        return Double.NaN;
    L22:
        LOGGER.atWarn().a("Returning NaN because IRR has reached max number of iterations allowed: {}", 1000);
        return Double.NaN;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r5, int r6, int r7) {
        if (r5.length == 0) goto L18;
        if (r5.length > 2) goto L18;
        double[] r1 = AggregateFunction.ValueCollector.collectValues(new ValueEval[]{r5[0]});     // Catch: EvaluationException -> L14
        if (r5.length != 2) goto L11;
        double r4 = NumericFunction.singleOperandEvaluate(r5[1], r6, r7);     // Catch: EvaluationException -> L14
    L12:
        double r8 = irr(r1, r4);     // Catch: EvaluationException -> L14
        NumericFunction.checkValue(r8);     // Catch: EvaluationException -> L14
        return new NumberEval(r8);
    L11:
        r4 = 0.1d;
    L14:
        e = move-exception;
        return e.getErrorEval();
    L18:
        return ErrorEval.VALUE_INVALID;
    }
}
