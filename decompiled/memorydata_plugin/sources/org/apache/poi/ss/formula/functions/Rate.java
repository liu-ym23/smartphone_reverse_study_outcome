package org.apache.poi.ss.formula.functions;

import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Rate implements Function {
    private static final c LOG = null;

    static {
        LOG = b.a(Rate.class);
    }

    public Rate() {
    }

    private static double _g_div_gp(double r16, double r18, double r20, double r22, double r24, double r26) {
        double r6 = r16 + 1.0d;
        double r8 = Math.pow(r6, r18);
        double r7 = Math.pow(r6, r18 - 1.0d);
        double r10 = r24 + (r8 * r22);
        double r9 = (r8 - 1.0d) * r20;
        double r12 = (r16 * r26) + 1.0d;
        double r4 = r9 * r12;
        return (r10 + (r4 / r16)) / (((r18 * r7) * r22) - (r4 / ((Math.pow(r16, 2.0d) + ((((r18 * r20) * r7) * r12) / r16)) + ((r9 * r26) / r16))));
    }

    static double calculateRate(double r16, double r18, double r20, double r22, double r24, double r26) {
        double r13 = r26;
        boolean r1 = false;
        int r15 = 0;
    L4:
        if (r15 >= 100.0d) goto L11;
        if (r1 == true) goto L11;
        double r2 = r13 - _g_div_gp(r13, r16, r18, r20, r22, r24);
        if (Math.abs(r2 - r13) >= 1.0E-8d) goto L9;
        boolean r3 = true;
    L10:
        r15 = r15 + 1;
        r13 = r2;
        r1 = r3;
        goto L4
    L9:
        r3 = false;
    L11:
        if (r1 == true) goto L14;
        return Double.NaN;
    L14:
        return r13;
    }

    static void checkValue(double r1) {
        if (Double.isNaN(r1) == true) goto L8;
        if (Double.isInfinite(r1) == true) goto L8;
        return;
    L8:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r28, int r29, int r30) {
        if (r28.length < 3) goto L5;
        double r5 = 0.1d;
        ValueEval r3 = OperandResolver.getSingleValue(r28[0], r29, r30);     // Catch: EvaluationException -> L32
        ValueEval r7 = OperandResolver.getSingleValue(r28[1], r29, r30);     // Catch: EvaluationException -> L32
        ValueEval r8 = OperandResolver.getSingleValue(r28[2], r29, r30);     // Catch: EvaluationException -> L32
        ValueEval r11 = null;
        if (r28.length < 4) goto L10;
        ValueEval r4 = OperandResolver.getSingleValue(r28[3], r29, r30);     // Catch: EvaluationException -> L32
    L12:
        if (r28.length < 5) goto L14;
        ValueEval r9 = OperandResolver.getSingleValue(r28[4], r29, r30);     // Catch: EvaluationException -> L32
    L16:
        if (r28.length < 6) goto L18;
        r11 = OperandResolver.getSingleValue(r28[5], r29, r30);     // Catch: EvaluationException -> L32
    L18:
        double r15 = OperandResolver.coerceValueToDouble(r3);     // Catch: EvaluationException -> L32
        double r17 = OperandResolver.coerceValueToDouble(r7);     // Catch: EvaluationException -> L32
        double r19 = OperandResolver.coerceValueToDouble(r8);     // Catch: EvaluationException -> L32
        if (r28.length < 4) goto L21;
        double r21 = OperandResolver.coerceValueToDouble(r4);     // Catch: EvaluationException -> L32
    L23:
        if (r28.length < 5) goto L25;
        double r23 = OperandResolver.coerceValueToDouble(r9);     // Catch: EvaluationException -> L32
    L27:
        if (r28.length < 6) goto L29;
        r5 = OperandResolver.coerceValueToDouble(r11);     // Catch: EvaluationException -> L32
    L29:
        double r0 = calculateRate(r15, r17, r19, r21, r23, r5);     // Catch: EvaluationException -> L32
        checkValue(r0);     // Catch: EvaluationException -> L32
        return new NumberEval(r0);
    L25:
        r23 = 0.0d;
        goto L27
    L21:
        r21 = 0.0d;
        goto L23
    L14:
        r9 = null;
        goto L16
    L10:
        r4 = null;
    L32:
        e = move-exception;
        LOG.atError().a(e).a("Can't evaluate rate function");
        return e.getErrorEval();
    L5:
        return ErrorEval.VALUE_INVALID;
    }
}
