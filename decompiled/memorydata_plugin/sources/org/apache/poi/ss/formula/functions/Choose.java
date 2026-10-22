package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Choose implements Function {
    public Choose() {
    }

    public static int evaluateFirstArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r2, int r3, int r4) {
        if (r2.length >= 2) goto L21;
        return ErrorEval.VALUE_INVALID;
    L21:
        int r1 = evaluateFirstArg(r2[0], r3, r4);     // Catch: EvaluationException -> L18
        if (r1 < 1) goto L17;
        if (r1 >= r2.length) goto L17;
        ValueEval r5 = OperandResolver.getSingleValue(r2[r1], r3, r4);     // Catch: EvaluationException -> L18
        if (r5 == MissingArgEval.instance) goto L15;
        return r5;
    L15:
        return BlankEval.instance;
    L17:
        return ErrorEval.VALUE_INVALID;
    L18:
        e = move-exception;
        return e.getErrorEval();
    }
}
