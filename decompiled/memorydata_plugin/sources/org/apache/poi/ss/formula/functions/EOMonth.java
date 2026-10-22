package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class EOMonth implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new EOMonth();
    }

    public EOMonth() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r7, OperationEvaluationContext r8) {
        if (r7.length == 2) goto L17;
        return ErrorEval.VALUE_INVALID;
    L17:
        double r1 = NumericFunction.singleOperandEvaluate(r7[0], r8.getRowIndex(), r8.getColumnIndex());     // Catch: EvaluationException -> L14
        int r9 = (int) NumericFunction.singleOperandEvaluate(r7[1], r8.getRowIndex(), r8.getColumnIndex());     // Catch: EvaluationException -> L14
        if (r1 >= 0.0d) goto L10;
    L12:
        Date r10 = DateUtil.getJavaDate(r1, false);     // Catch: EvaluationException -> L14
        Calendar r2 = LocaleUtil.getLocaleCalendar();     // Catch: EvaluationException -> L14
        r2.setTime(r10);     // Catch: EvaluationException -> L14
        r2.clear(10);     // Catch: EvaluationException -> L14
        r2.set(11, 0);     // Catch: EvaluationException -> L14
        r2.clear(12);     // Catch: EvaluationException -> L14
        r2.clear(13);     // Catch: EvaluationException -> L14
        r2.clear(14);     // Catch: EvaluationException -> L14
        r2.add(2, r9 + 1);     // Catch: EvaluationException -> L14
        r2.set(5, 1);     // Catch: EvaluationException -> L14
        r2.add(5, -1);     // Catch: EvaluationException -> L14
        return new NumberEval(DateUtil.getExcelDate(r2.getTime()));
    L10:
        if (r1 >= 1.0d) goto L12;
        r1 = 1.0d;
    L14:
        e = move-exception;
        return e.getErrorEval();
    }
}
