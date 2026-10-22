package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
final class WorkdayFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new WorkdayFunction(ArgumentsEvaluator.instance);
    }

    private WorkdayFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r8, OperationEvaluationContext r9) {
        if (r8.length < 2) goto L17;
        if (r8.length > 3) goto L17;
        int r0 = r9.getRowIndex();
        int r10 = r9.getColumnIndex();
        double r3 = this.evaluator.evaluateDateArg(r8[0], r0, r10);     // Catch: EvaluationException -> L14
        int r5 = (int) Math.floor(this.evaluator.evaluateNumberArg(r8[1], r0, r10));     // Catch: EvaluationException -> L14
        if (r8.length != 3) goto L11;
        ValueEval r11 = r8[2];     // Catch: EvaluationException -> L14
    L12:
        double[] r7 = this.evaluator.evaluateDatesArg(r11, r0, r10);     // Catch: EvaluationException -> L14
        return new NumberEval(DateUtil.getExcelDate(WorkdayCalculator.instance.calculateWorkdays(r3, r5, r7)));
    L11:
        r11 = null;
    L15:
        return ErrorEval.VALUE_INVALID;
    L17:
        return ErrorEval.VALUE_INVALID;
    }
}
