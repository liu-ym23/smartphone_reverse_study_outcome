package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Forecast extends Fixed3ArgFunction implements FreeRefFunction {
    public static final Forecast instance = null;

    static {
        instance = new Forecast();
    }

    private Forecast() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r18, int r19, ValueEval r20, ValueEval r21, ValueEval r22) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r20, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r21, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r22, ValueEval.class, "com.obric.memorydata.plugin");
        Double r1 = evaluateValue(r0, r18, r19);     // Catch: Exception -> L21 EvaluationException -> L23
        if (r1 == null) goto L20;
        if (r1.isNaN() == true) goto L20;
        if (r1.isInfinite() == true) goto L20;
        List<DoubleList> r4 = ArrayFunctionUtils.getNumberArrays(r2, r3);     // Catch: Exception -> L21 EvaluationException -> L23
        int r5 = 0;
        double[] r6 = ((DoubleList) ZeusTransformUtils.preCheckCast(r4.get(0), DoubleList.class, "com.obric.memorydata.plugin")).toArray();     // Catch: Exception -> L21 EvaluationException -> L23
        double[] r7 = ((DoubleList) ZeusTransformUtils.preCheckCast(r4.get(1), DoubleList.class, "com.obric.memorydata.plugin")).toArray();     // Catch: Exception -> L21 EvaluationException -> L23
        double r8 = MathX.average(r6);     // Catch: Exception -> L21 EvaluationException -> L23
        double r9 = MathX.average(r7);     // Catch: Exception -> L21 EvaluationException -> L23
        int r10 = r6.length;     // Catch: Exception -> L21 EvaluationException -> L23
        double r11 = 0.0d;
        double r13 = 0.0d;
    L11:
        if (r5 >= r10) goto L14;
        double r12 = r7[r5] - r9;     // Catch: Exception -> L21 EvaluationException -> L23
        r13 = r13 + ((r6[r5] - r8) * r12);     // Catch: Exception -> L21 EvaluationException -> L23
        double[] r110 = r7;
        r11 = r11 + Math.pow(r12, 2.0d);     // Catch: Exception -> L21 EvaluationException -> L23
        r5 = r5 + 1;     // Catch: Exception -> L21 EvaluationException -> L23
        r7 = r110;
        r10 = r10;
        goto L11
    L14:
        if (r11 == 0.0d) goto L16;
        double r14 = r13 / r11;     // Catch: Exception -> L21 EvaluationException -> L23
        return new NumberEval((r8 - (r9 * r14)) + (r14 * r1.doubleValue()));
    L16:
        return ErrorEval.DIV_ZERO;
    L20:
        return ErrorEval.VALUE_INVALID;
    L23:
        e = move-exception;
        return e.getErrorEval();
    L22:
        return ErrorEval.NA;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r7, OperationEvaluationContext r8) {
        if (r7.length == 3) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r8.getRowIndex(), r8.getColumnIndex(), r7[0], r7[1], r7[2]);
    }
}
