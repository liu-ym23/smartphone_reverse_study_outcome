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
public final class NormInv extends Fixed3ArgFunction implements FreeRefFunction {
    public static final NormInv instance = null;

    static {
        instance = new NormInv();
    }

    private NormInv() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    static double inverse(double r1, double r3, double r5) {
        return new NormalDistribution(r3, r5).inverseCumulativeProbability(r1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r7, int r8, ValueEval r9, ValueEval r10, ValueEval r11) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r10, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r13 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin");
        Double r14 = evaluateValue(r6, r7, r8);     // Catch: EvaluationException -> L28
        if (r14 != null) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r14.doubleValue() <= 0.0d) goto L27;
        if (r14.doubleValue() >= 1.0d) goto L27;
        Double r15 = evaluateValue(r12, r7, r8);     // Catch: EvaluationException -> L28
        if (r15 == null) goto L15;
        Double r16 = evaluateValue(r13, r7, r8);     // Catch: EvaluationException -> L28
        if (r16 != null) goto L21;
        return ErrorEval.VALUE_INVALID;
    L21:
        if (r16.doubleValue() > 0.0d) goto L25;
        return ErrorEval.NUM_ERROR;
    L25:
        return new NumberEval(inverse(r14.doubleValue(), r15.doubleValue(), r16.doubleValue()));
    L15:
        return ErrorEval.VALUE_INVALID;
    L27:
        return ErrorEval.NUM_ERROR;
    L28:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r9, OperationEvaluationContext r10) {
        if (r9.length != 3) goto L7;
        return evaluate(r10.getRowIndex(), r10.getColumnIndex(), r9[0], r9[1], r9[2]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
