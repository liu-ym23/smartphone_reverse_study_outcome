package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class TDist2t extends Fixed2ArgFunction implements FreeRefFunction {
    public static final TDist2t instance = null;

    static {
        instance = new TDist2t();
    }

    public TDist2t() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        Double r10 = evaluateValue(r4, r5, r6);     // Catch: EvaluationException -> L21
        if (r10 != null) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r10.doubleValue() < 0.0d) goto L10;
        Double r11 = evaluateValue(r9, r5, r6);     // Catch: EvaluationException -> L21
        if (r11 == null) goto L14;
        int r12 = r11.intValue();     // Catch: EvaluationException -> L21
        if (r12 >= 1) goto L20;
        return ErrorEval.NUM_ERROR;
    L20:
        return new NumberEval(TDist.tdistTwoTails(Math.abs(r10.doubleValue()), r12));
    L14:
        return ErrorEval.VALUE_INVALID;
    L10:
        return ErrorEval.NUM_ERROR;
    L21:
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
