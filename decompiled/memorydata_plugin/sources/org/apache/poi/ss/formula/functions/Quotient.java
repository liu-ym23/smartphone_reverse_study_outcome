package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Quotient extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Quotient();
    }

    public Quotient() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        double r0 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r2, r3, r4));     // Catch: EvaluationException -> L13
        double r8 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r7, r3, r4));     // Catch: EvaluationException -> L11
        if (r8 != 0.0d) goto L10;
        return ErrorEval.DIV_ZERO;
    L10:
        return new NumberEval((int) (r0 / r8));
    L12:
        return ErrorEval.VALUE_INVALID;
    L14:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        if (r4.length == 2) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r5.getRowIndex(), r5.getColumnIndex(), r4[0], r4[1]);
    }
}
