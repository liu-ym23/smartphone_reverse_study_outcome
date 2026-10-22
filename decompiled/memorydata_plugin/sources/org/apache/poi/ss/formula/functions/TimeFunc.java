package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class TimeFunc extends Fixed3ArgFunction {
    public TimeFunc() {
    }

    private static int evalArg(ValueEval r2, int r3, int r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 != MissingArgEval.instance) goto L7;
        return 0;
    L7:
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r5, r3, r4));
    }

    private static double evaluate(int r2, int r3, int r4) {
        if (r2 > 32767) goto L13;
        if (r3 > 32767) goto L13;
        if (r4 > 32767) goto L13;
        int r5 = ((r2 * 3600) + (r3 * 60)) + r4;
        if (r5 < 0) goto L11;
        return ((double) (r5 % 86400)) / 86400.0d;
    L11:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L13:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        return new NumberEval(evaluate(evalArg(r1, r2, r3), evalArg(r7, r2, r3), evalArg(r8, r2, r3)));
    L6:
        e = move-exception;
        return e.getErrorEval();
    }
}
