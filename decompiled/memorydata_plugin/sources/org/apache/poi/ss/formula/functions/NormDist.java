package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class NormDist extends Fixed4ArgFunction implements FreeRefFunction {
    public static final NormDist instance = null;

    static {
        instance = new NormDist();
    }

    private NormDist() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    static double probability(double r1, double r3, double r5, boolean r7) {
        NormalDistribution r0 = new NormalDistribution(r3, r5);
        if (r7 == false) goto L6;
        return r0.cumulativeProbability(r1);
    L6:
        return r0.density(r1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r8, int r9, ValueEval r10, ValueEval r11, ValueEval r12, ValueEval r13) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r10, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r14 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r15 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r16 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin");
        Double r17 = evaluateValue(r7, r8, r9);     // Catch: EvaluationException -> L25
        if (r17 == null) goto L6;
        Double r18 = evaluateValue(r14, r8, r9);     // Catch: EvaluationException -> L25
        if (r18 == null) goto L10;
        Double r19 = evaluateValue(r15, r8, r9);     // Catch: EvaluationException -> L25
        if (r19 != null) goto L16;
        return ErrorEval.VALUE_INVALID;
    L16:
        if (r19.doubleValue() <= 0.0d) goto L18;
        Boolean r20 = OperandResolver.coerceValueToBoolean(r16, false);     // Catch: EvaluationException -> L25
        if (r20 != null) goto L24;
        return ErrorEval.VALUE_INVALID;
    L24:
        return new NumberEval(probability(r17.doubleValue(), r18.doubleValue(), r19.doubleValue(), r20.booleanValue()));
    L18:
        return ErrorEval.NUM_ERROR;
    L10:
        return ErrorEval.VALUE_INVALID;
    L6:
        return ErrorEval.VALUE_INVALID;
    L25:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r10, OperationEvaluationContext r11) {
        if (r10.length != 4) goto L7;
        return evaluate(r11.getRowIndex(), r11.getColumnIndex(), r10[0], r10[1], r10[2], r10[3]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
