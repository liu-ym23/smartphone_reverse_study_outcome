package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class PercentEval extends Fixed1ArgFunction {
    public static final Function instance = null;

    static {
        instance = new PercentEval();
    }

    private PercentEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5) {
        double r2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: EvaluationException -> L10
        if (r2 != 0.0d) goto L9;
        return NumberEval.ZERO;
    L9:
        return new NumberEval(r2 / 100.0d);
    L10:
        e = move-exception;
        return e.getErrorEval();
    }
}
