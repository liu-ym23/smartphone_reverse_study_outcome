package org.apache.poi.ss.formula.functions;

import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DateFunc extends Fixed3ArgFunction {
    public static final Function instance = null;

    static {
        instance = new DateFunc();
    }

    private DateFunc() {
    }

    private static double evaluate(int r3, int r4, int r5) {
        if (r3 < 0) goto L32;
    L3:
        if (r4 >= 0) goto L6;
        r3 = r3 - 1;
        r4 = r4 + 12;
        goto L3
    L6:
        if (r3 != 1900) goto L12;
        if (r4 != 1) goto L12;
        if (r5 != 29) goto L12;
        return 60.0d;
    L12:
        if (r3 != 1900) goto L20;
        if (r4 == 0) goto L15;
    L16:
        if (r4 != 1) goto L20;
        if (r5 < 30) goto L20;
    L19:
        int r2 = r5 - 1;
    L21:
        Calendar r6 = LocaleUtil.getLocaleCalendar(r3, r4, r2);
        if (r5 >= 0) goto L30;
        if (r6.get(1) != 1900) goto L30;
        if (r4 <= 1) goto L30;
        if (r6.get(2) >= 2) goto L30;
        r6.add(5, 1);
    L30:
        return DateUtil.getExcelDate(r6.getTime(), false);
    L15:
        if (r5 >= 60) goto L19;
    L20:
        r2 = r5;
        goto L21
    L32:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static int getYear(double r0) {
        int r1 = (int) r0;
        if (r1 >= 0) goto L7;
        return -1;
    L7:
        if (r1 < 1900) goto L9;
        return r1;
    L9:
        return r1 + ODatePickerView.YEAR_FROM;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8, ValueEval r9) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        double r0 = NumericFunction.singleOperandEvaluate(r4, r5, r6);     // Catch: EvaluationException -> L6
        double r2 = NumericFunction.singleOperandEvaluate(r10, r5, r6);     // Catch: EvaluationException -> L6
        double r12 = NumericFunction.singleOperandEvaluate(r11, r5, r6);     // Catch: EvaluationException -> L6
        double r13 = evaluate(getYear(r0), (int) (r2 - 1.0d), (int) r12);     // Catch: EvaluationException -> L6
        NumericFunction.checkValue(r13);     // Catch: EvaluationException -> L6
        return new NumberEval(r13);
    L6:
        e = move-exception;
        return e.getErrorEval();
    }
}
