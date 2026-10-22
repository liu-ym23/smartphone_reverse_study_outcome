package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class NormSDist extends Fixed1ArgFunction implements FreeRefFunction {
    public static final NormSDist instance = null;

    static {
        instance = new NormSDist();
    }

    private NormSDist() {
    }

    private static Double evaluateValue(ValueEval r2, int r3, int r4) {
        return OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r8, int r9, ValueEval r10) {
        Double r7 = evaluateValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r10, ValueEval.class, "com.obric.memorydata.plugin"), r8, r9);     // Catch: EvaluationException -> L13
        if (r7 != null) goto L8;
        return ErrorEval.VALUE_INVALID;
    L8:
        if (r7.doubleValue() >= 0.0d) goto L12;
        return ErrorEval.NUM_ERROR;
    L12:
        return new NumberEval(NormDist.probability(r7.doubleValue(), 0.0d, 1.0d, true));
    L13:
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
