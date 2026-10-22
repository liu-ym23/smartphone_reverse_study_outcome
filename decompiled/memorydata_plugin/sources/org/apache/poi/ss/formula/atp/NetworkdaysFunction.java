package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class NetworkdaysFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new NetworkdaysFunction(ArgumentsEvaluator.instance);
    }

    private NetworkdaysFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r12, OperationEvaluationContext r13) {
        if (r12.length < 2) goto L21;
        if (r12.length > 3) goto L21;
        int r0 = r13.getRowIndex();
        int r14 = r13.getColumnIndex();
        double r6 = this.evaluator.evaluateDateArg(r12[0], r0, r14);     // Catch: EvaluationException -> L18
        double r8 = this.evaluator.evaluateDateArg(r12[1], r0, r14);     // Catch: EvaluationException -> L18
        if (r6 <= r8) goto L13;
        return ErrorEval.NAME_INVALID;
    L13:
        if (r12.length != 3) goto L15;
        ValueEval r15 = r12[2];     // Catch: EvaluationException -> L18
    L17:
        return new NumberEval(WorkdayCalculator.instance.calculateWorkdays(r6, r8, this.evaluator.evaluateDatesArg(r15, r0, r14)));
    L15:
        r15 = null;
        goto L17
    L19:
        return ErrorEval.VALUE_INVALID;
    L21:
        return ErrorEval.VALUE_INVALID;
    }
}
