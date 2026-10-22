package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
final class WorkdayIntlFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new WorkdayIntlFunction(ArgumentsEvaluator.instance);
    }

    private WorkdayIntlFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r12, OperationEvaluationContext r13) {
        if (r12.length < 2) goto L26;
        if (r12.length > 4) goto L26;
        int r0 = r13.getRowIndex();
        int r14 = r13.getColumnIndex();
        double r6 = this.evaluator.evaluateDateArg(r12[0], r0, r14);     // Catch: EvaluationException -> L23
        int r4 = 1;
        int r8 = (int) Math.floor(this.evaluator.evaluateNumberArg(r12[1], r0, r14));     // Catch: EvaluationException -> L23
        if (r12.length >= 3) goto L11;
    L17:
        int r9 = r4;
        if (r12.length < 4) goto L20;
        ValueEval r15 = r12[3];     // Catch: EvaluationException -> L23
    L21:
        double[] r10 = this.evaluator.evaluateDatesArg(r15, r0, r14);     // Catch: EvaluationException -> L23
        return new NumberEval(DateUtil.getExcelDate(WorkdayCalculator.instance.calculateWorkdays(r6, r8, r9, r10)));
    L20:
        r15 = null;
        goto L21
    L11:
        if (r12[2] == BlankEval.instance) goto L14;
        r4 = (int) this.evaluator.evaluateNumberArg(r12[2], r0, r14);     // Catch: EvaluationException -> L23
    L14:
        if (WorkdayCalculator.instance.getValidWeekendTypes().contains(Integer.valueOf(r4)) == true) goto L17;
        return ErrorEval.NUM_ERROR;
    L24:
        return ErrorEval.VALUE_INVALID;
    L26:
        return ErrorEval.VALUE_INVALID;
    }
}
