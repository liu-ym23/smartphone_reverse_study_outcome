package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class NormSInv extends Fixed1ArgFunction implements FreeRefFunction {
    public static final NormSInv instance = null;

    static {
        instance = new NormSInv();
    }

    private NormSInv() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r7, int r8, ValueEval r9) {
        Double r6 = evaluateValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin"), r7, r8);     // Catch: EvaluationException -> L16
        if (r6 != null) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r6.doubleValue() <= 0.0d) goto L15;
        if (r6.doubleValue() >= 1.0d) goto L15;
        return new NumberEval(NormInv.inverse(r6.doubleValue(), 0.0d, 1.0d));
    L15:
        return ErrorEval.NUM_ERROR;
    L16:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length != 1) goto L7;
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
