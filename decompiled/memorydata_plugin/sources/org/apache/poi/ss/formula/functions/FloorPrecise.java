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
public final class FloorPrecise implements FreeRefFunction {
    public static final FloorPrecise instance = null;

    static {
        instance = new FloorPrecise();
    }

    private FloorPrecise() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r5, OperationEvaluationContext r6) {
        if (r5.length != 0) goto L26;
        return ErrorEval.VALUE_INVALID;
    L26:
        Double r4 = evaluateValue(r5[0], r6.getRowIndex(), r6.getColumnIndex());     // Catch: EvaluationException -> L23
        if (r4 != null) goto L12;
        return ErrorEval.VALUE_INVALID;
    L12:
        if (r5.length <= 1) goto L16;
        Double r7 = evaluateValue(r5[1], r6.getRowIndex(), r6.getColumnIndex());     // Catch: EvaluationException -> L23
        if (r7 == null) goto L16;
        double r8 = Math.abs(r7.doubleValue());     // Catch: EvaluationException -> L23
    L18:
        if (r8 == 1.0d) goto L22;
        return new NumberEval(MathX.scaledRoundUsingBigDecimal(r4.doubleValue(), r8, RoundingMode.FLOOR));
    L22:
        return new NumberEval(Math.floor(r4.doubleValue()));
    L16:
        r8 = 1.0d;
    L23:
        e = move-exception;
        return e.getErrorEval();
    }
}
