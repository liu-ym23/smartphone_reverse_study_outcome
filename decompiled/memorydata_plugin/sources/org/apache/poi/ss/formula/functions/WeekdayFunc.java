package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WeekdayFunc implements Function {
    public static final Function instance = null;

    static {
        instance = new WeekdayFunc();
    }

    private WeekdayFunc() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r6, int r7, int r8) {
    L39:
        e = move-exception;
        return e.getErrorEval();
    L3:
        if (r6.length < 1) goto L38;
        if (r6.length > 2) goto L38;
        double r2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r6[0], r7, r8));     // Catch: EvaluationException -> L39
        if (DateUtil.isValidExcelDate(r2) == false) goto L10;
        int r5 = DateUtil.getJavaCalendar(r2, false).get(7);     // Catch: EvaluationException -> L39
        if (r6.length != 2) goto L23;
        ValueEval r9 = OperandResolver.getSingleValue(r6[1], r7, r8);     // Catch: EvaluationException -> L39
        if (r9 == MissingArgEval.instance) goto L22;
        if (r9 == BlankEval.instance) goto L22;
        int r10 = OperandResolver.coerceValueToInt(r9);     // Catch: EvaluationException -> L39
        if (r10 != 2) goto L24;
        r10 = 11;
    L24:
        if (r10 != 1) goto L27;
    L25:
        double r11 = r5;
    L34:
        return new NumberEval(r11);
    L27:
        if (r10 != 3) goto L29;
        r5 = ((r5 + 6) - 1) % 7;     // Catch: EvaluationException -> L39
        goto L25
    L29:
        if (r10 < 11) goto L36;
        if (r10 > 17) goto L36;
        r11 = ((double) (((r5 + 6) - (r10 - 10)) % 7)) + 1.0d;     // Catch: EvaluationException -> L39
    L36:
        return ErrorEval.NUM_ERROR;
    L22:
        return ErrorEval.NUM_ERROR;
    L23:
        r10 = 1;
        goto L24
    L10:
        return ErrorEval.NUM_ERROR;
    L38:
        return ErrorEval.VALUE_INVALID;
    }
}
