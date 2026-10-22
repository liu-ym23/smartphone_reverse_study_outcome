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
public final class TDistLt extends Fixed3ArgFunction implements FreeRefFunction {
    public static final TDistLt instance = null;

    static {
        instance = new TDistLt();
    }

    public TDistLt() {
    }

    private static Boolean evaluateBoolean(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4), false);
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    private static double tdistCumulative(double r3, int r5) {
        return new TDistribution(null, r5).cumulativeProbability(r3);
    }

    private static double tdistDensity(double r3, int r5) {
        return new TDistribution(null, r5).density(r3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        Double r9 = evaluateValue(r1, r2, r3);     // Catch: EvaluationException -> L25
        if (r9 == null) goto L6;
        Double r10 = evaluateValue(r7, r2, r3);     // Catch: EvaluationException -> L25
        if (r10 == null) goto L10;
        int r11 = r10.intValue();     // Catch: EvaluationException -> L25
        if (r11 < 1) goto L14;
        Boolean r12 = evaluateBoolean(r8, r2, r3);     // Catch: EvaluationException -> L25
        if (r12 != null) goto L20;
        return ErrorEval.VALUE_INVALID;
    L20:
        if (r12.booleanValue() == false) goto L24;
        return new NumberEval(tdistCumulative(r9.doubleValue(), r11));
    L24:
        return new NumberEval(tdistDensity(r9.doubleValue(), r11));
    L14:
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
    public ValueEval evaluate(ValueEval[] r9, OperationEvaluationContext r10) {
        if (r9.length != 3) goto L7;
        return evaluate(r10.getRowIndex(), r10.getColumnIndex(), r9[0], r9[1], r9[2]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
