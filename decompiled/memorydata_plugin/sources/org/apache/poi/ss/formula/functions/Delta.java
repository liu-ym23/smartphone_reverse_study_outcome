package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Delta extends Fixed2ArgFunction implements FreeRefFunction {
    private static final NumberEval ONE = null;
    private static final NumberEval ZERO = null;
    public static final FreeRefFunction instance = null;

    static {
        instance = new Delta();
        ONE = new NumberEval(1.0d);
        ZERO = new NumberEval(0.0d);
    }

    public Delta() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        Double r7 = evaluateValue(r1, r2, r3);     // Catch: EvaluationException -> L16
        if (r7 == null) goto L6;
        Double r8 = evaluateValue(r6, r2, r3);     // Catch: EvaluationException -> L16
        if (r8 != null) goto L12;
        return ErrorEval.VALUE_INVALID;
    L12:
        if (r7.compareTo(r8) != 0) goto L15;
        return ONE;
    L15:
        return ZERO;
    L6:
        return ErrorEval.VALUE_INVALID;
    L16:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        if (r4.length != 2) goto L7;
        return evaluate(r5.getRowIndex(), r5.getColumnIndex(), r4[0], r4[1]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
