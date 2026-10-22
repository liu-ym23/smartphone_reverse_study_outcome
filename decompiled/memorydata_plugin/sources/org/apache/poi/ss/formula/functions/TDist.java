package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class TDist extends Fixed3ArgFunction implements FreeRefFunction {
    public static final TDist instance = null;

    static {
        instance = new TDist();
    }

    public TDist() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    static double tdistOneTail(double r3, int r5) {
        return 1.0d - new TDistribution(null, r5).cumulativeProbability(r3);
    }

    static double tdistTwoTails(double r2, int r4) {
        return tdistOneTail(r2, r4) * 2.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8, ValueEval r9) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        Double r12 = evaluateValue(r4, r5, r6);     // Catch: EvaluationException -> L33
        if (r12 != null) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r12.doubleValue() < 0.0d) goto L10;
        Double r13 = evaluateValue(r10, r5, r6);     // Catch: EvaluationException -> L33
        if (r13 == null) goto L14;
        int r14 = r13.intValue();     // Catch: EvaluationException -> L33
        if (r14 < 1) goto L18;
        Double r15 = evaluateValue(r11, r5, r6);     // Catch: EvaluationException -> L33
        if (r15 == null) goto L22;
        int r16 = r15.intValue();     // Catch: EvaluationException -> L33
        if (r16 == 1) goto L28;
        if (r16 == 2) goto L28;
        return ErrorEval.NUM_ERROR;
    L28:
        if (r16 != 2) goto L32;
        return new NumberEval(tdistTwoTails(r12.doubleValue(), r14));
    L32:
        return new NumberEval(tdistOneTail(r12.doubleValue(), r14));
    L22:
        return ErrorEval.VALUE_INVALID;
    L18:
        return ErrorEval.NUM_ERROR;
    L14:
        return ErrorEval.VALUE_INVALID;
    L10:
        return ErrorEval.NUM_ERROR;
    L33:
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
