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
public final class DollarDe extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new DollarDe();
    }

    public DollarDe() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r9, int r10, ValueEval r11, ValueEval r12) {
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r13 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin");
        Double r14 = evaluateValue(r8, r9, r10);     // Catch: EvaluationException -> L30
        if (r14 == null) goto L6;
        Double r15 = evaluateValue(r13, r9, r10);     // Catch: EvaluationException -> L30
        if (r15 == null) goto L10;
        int r16 = r15.intValue();     // Catch: EvaluationException -> L30
        if (r16 < 0) goto L14;
        if (r16 == 0) goto L17;
        int r17 = String.valueOf(r16).length();     // Catch: EvaluationException -> L30
        boolean r18 = false;
        long r0 = r14.longValue();     // Catch: EvaluationException -> L30
        if (r0 >= 0) goto L21;
        r18 = true;
        r0 = -r0;
        r14 = Double.valueOf(-r14.doubleValue());     // Catch: EvaluationException -> L30
    L21:
        double r4 = r0;
        double r2 = r14.doubleValue() - r4;     // Catch: EvaluationException -> L30
        if (r2 == 0.0d) goto L24;
        BigDecimal r19 = BigDecimal.valueOf(r2).multiply(BigDecimal.valueOf(Math.pow(10.0d, r17))).divide(BigDecimal.valueOf(r16), MathContext.DECIMAL128).add(BigDecimal.valueOf(r0));     // Catch: EvaluationException -> L30
        if (r18 == false) goto L29;
        r19 = r19.multiply(BigDecimal.valueOf(-1));     // Catch: EvaluationException -> L30
    L29:
        return new NumberEval(r19.doubleValue());
    L24:
        return new NumberEval(r4);
    L17:
        return ErrorEval.DIV_ZERO;
    L14:
        return ErrorEval.NUM_ERROR;
    L10:
        return ErrorEval.VALUE_INVALID;
    L6:
        return ErrorEval.VALUE_INVALID;
    L30:
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
