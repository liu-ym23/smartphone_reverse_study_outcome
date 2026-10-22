package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.Calendar;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class Days360 extends Var2or3ArgFunction {
    public Days360() {
    }

    private static double evaluate(double r9, double r11, boolean r13) {
        Calendar r10 = getDate(r9);
        Calendar r12 = getDate(r11);
        int[] r14 = getStartingDate(r10, r13);
        int[] r15 = getEndingDate(r12, r14, r13);
        return (((((double) r15[0]) * 360.0d) + (((double) r15[1]) * 30.0d)) + ((double) r15[2])) - (((((double) r14[0]) * 360.0d) + (((double) r14[1]) * 30.0d)) + ((double) r14[2]));
    }

    private static Calendar getDate(double r2) {
        Calendar r0 = LocaleUtil.getLocaleCalendar();
        r0.setTime(DateUtil.getJavaDate(r2, false));
        return r0;
    }

    private static int[] getEndingDate(Calendar r8, int[] r9, boolean r10) {
        int r1 = r8.get(1);
        int r3 = r8.get(2);
        int r6 = 30;
        int r5 = Math.min(30, r8.get(5));
        if (r10 == false) goto L5;
    L9:
        r6 = r5;
    L11:
        return new int[]{r1, r3, r6};
    L5:
        if (r8.get(5) != 31) goto L9;
        if (r9[2] >= 30) goto L11;
        r8.set(5, 1);
        r8.add(2, 1);
        r1 = r8.get(1);
        r3 = r8.get(2);
        r6 = 1;
        goto L11
    }

    private static int[] getStartingDate(Calendar r6, boolean r7) {
        int r1 = r6.get(1);
        int r3 = r6.get(2);
        int r5 = 30;
        int r4 = Math.min(30, r6.get(5));
        if (r7 == false) goto L5;
    L7:
        r5 = r4;
    L9:
        return new int[]{r1, r3, r5};
    L5:
        if (isLastDayOfMonth(r6) == false) goto L7;
        goto L7
    }

    private static boolean isLastDayOfMonth(Calendar r2) {
        if (r2.get(5) != r2.getActualMaximum(5)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        LocalDate r7 = Days.getDate(r1, r2, r3);     // Catch: EvaluationException -> L5
        LocalDate r8 = Days.getDate(r6, r2, r3);     // Catch: EvaluationException -> L5
        return new NumberEval(evaluate(DateUtil.getExcelDate(r7), DateUtil.getExcelDate(r8), false));
    L5:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8, ValueEval r9) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        LocalDate r12 = Days.getDate(r4, r5, r6);     // Catch: EvaluationException -> L10
        LocalDate r13 = Days.getDate(r10, r5, r6);     // Catch: EvaluationException -> L10
        ValueEval r14 = OperandResolver.getSingleValue(r11, r5, r6);     // Catch: EvaluationException -> L10
        boolean r15 = false;
        Boolean r16 = OperandResolver.coerceValueToBoolean(r14, false);     // Catch: EvaluationException -> L10
        double r0 = DateUtil.getExcelDate(r12);     // Catch: EvaluationException -> L10
        double r2 = DateUtil.getExcelDate(r13);     // Catch: EvaluationException -> L10
        if (r16 != null) goto L6;
    L8:
        return new NumberEval(evaluate(r0, r2, r15));
    L6:
        if (r16.booleanValue() == false) goto L8;
        r15 = true;
    L10:
        e = move-exception;
        return e.getErrorEval();
    }
}
