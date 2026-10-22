package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class BesselJ extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new BesselJ();
    }

    public BesselJ() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        Double r7 = evaluateValue(r1, r2, r3);     // Catch: EvaluationException -> L17
        if (r7 == null) goto L6;
        Double r8 = evaluateValue(r6, r2, r3);     // Catch: EvaluationException -> L17
        if (r8 == null) goto L10;
        int r9 = r8.intValue();     // Catch: EvaluationException -> L17
        if (r9 >= 0) goto L16;
        return ErrorEval.NUM_ERROR;
    L16:
        return new NumberEval(org.apache.commons.math3.special.BesselJ.value(r9, r7.doubleValue()));
    L10:
        return ErrorEval.VALUE_INVALID;
    L6:
        return ErrorEval.VALUE_INVALID;
    L17:
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
