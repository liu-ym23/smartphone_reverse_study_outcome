package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Standardize extends Fixed3ArgFunction implements FreeRefFunction {
    public static final Standardize instance = null;

    static {
        instance = new Standardize();
    }

    public Standardize() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6, ValueEval r7) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        Double r10 = evaluateValue(r2, r3, r4);     // Catch: EvaluationException -> L21
        if (r10 == null) goto L6;
        Double r11 = evaluateValue(r8, r3, r4);     // Catch: EvaluationException -> L21
        if (r11 == null) goto L10;
        Double r12 = evaluateValue(r9, r3, r4);     // Catch: EvaluationException -> L21
        if (r12 != null) goto L16;
        return ErrorEval.VALUE_INVALID;
    L16:
        if (r12.doubleValue() > 0.0d) goto L20;
        return ErrorEval.NUM_ERROR;
    L20:
        return new NumberEval(BigDecimal.valueOf(r10.doubleValue() - r11.doubleValue()).divide(BigDecimal.valueOf(r12.doubleValue()), MathContext.DECIMAL128).doubleValue());
    L10:
        return ErrorEval.VALUE_INVALID;
    L6:
        return ErrorEval.VALUE_INVALID;
    L21:
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
