package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Npv implements Function {
    public Npv() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r3, int r4, int r5) {
        if (r3.length >= 2) goto L12;
        return ErrorEval.VALUE_INVALID;
    L12:
        double r2 = FinanceLib.npv(NumericFunction.singleOperandEvaluate(r3[0], r4, r5), AggregateFunction.ValueCollector.collectValues((ValueEval[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r3, 1, r3.length, ValueEval[].class), ValueEval[].class, "com.obric.memorydata.plugin")));     // Catch: EvaluationException -> L9
        NumericFunction.checkValue(r2);     // Catch: EvaluationException -> L9
        return new NumberEval(r2);
    L9:
        e = move-exception;
        return e.getErrorEval();
    }
}
