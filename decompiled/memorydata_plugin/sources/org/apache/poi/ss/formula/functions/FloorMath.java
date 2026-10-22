package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.RoundingMode;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class FloorMath implements FreeRefFunction {
    public static final FloorMath instance = null;

    static {
        instance = new FloorMath();
    }

    private FloorMath() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r11, OperationEvaluationContext r12) {
        if (r11.length == 0) goto L5;
        boolean r10 = false;
        Double r0 = evaluateValue(r11[0], r12.getRowIndex(), r12.getColumnIndex());     // Catch: EvaluationException -> L47
        if (r0 != null) goto L12;
        return ErrorEval.VALUE_INVALID;
    L12:
        if (r11.length <= 1) goto L16;
        Double r1 = evaluateValue(r11[1], r12.getRowIndex(), r12.getColumnIndex());     // Catch: EvaluationException -> L47
        if (r1 == null) goto L16;
        double r5 = r1.doubleValue();     // Catch: EvaluationException -> L47
    L18:
        if (r11.length <= 2) goto L24;
        Double r13 = evaluateValue(r11[2], r12.getRowIndex(), r12.getColumnIndex());     // Catch: EvaluationException -> L47
        if (r13 == null) goto L24;
        if (r13.doubleValue() >= 0.0d) goto L24;
        r10 = true;
    L24:
        if (r10 == false) goto L38;
        if (r0.doubleValue() >= 0.0d) goto L38;
        if (r5 == 1.0d) goto L36;
        if (r5 >= 0.0d) goto L32;
        RoundingMode r14 = RoundingMode.FLOOR;     // Catch: EvaluationException -> L47
    L34:
        return new NumberEval(MathX.scaledRoundUsingBigDecimal(r0.doubleValue(), r5, r14));
    L32:
        r14 = RoundingMode.CEILING;     // Catch: EvaluationException -> L47
        goto L34
    L36:
        return new NumberEval(Math.ceil(r0.doubleValue()));
    L38:
        if (r5 == 1.0d) goto L46;
        if (r5 >= 0.0d) goto L42;
        RoundingMode r15 = RoundingMode.CEILING;     // Catch: EvaluationException -> L47
    L44:
        return new NumberEval(MathX.scaledRoundUsingBigDecimal(r0.doubleValue(), r5, r15));
    L42:
        r15 = RoundingMode.FLOOR;     // Catch: EvaluationException -> L47
        goto L44
    L46:
        return new NumberEval(Math.floor(r0.doubleValue()));
    L16:
        r5 = 1.0d;
    L47:
        e = move-exception;
        return e.getErrorEval();
    L5:
        return ErrorEval.VALUE_INVALID;
    }
}
