package org.apache.poi.ss.formula.functions;

import java.text.DecimalFormatSymbols;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberValueFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new NumberValueFunction();
    }

    private NumberValueFunction() {
    }

    private static void checkValue(double r1) {
        if (Double.isNaN(r1) == true) goto L8;
        if (Double.isInfinite(r1) == true) goto L8;
        return;
    L8:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r8, OperationEvaluationContext r9) {
        DecimalFormatSymbols r7 = DecimalFormatSymbols.getInstance(LocaleUtil.getUserLocale());
        String r0 = String.valueOf(r7.getDecimalSeparator());
        String r10 = String.valueOf(r7.getGroupingSeparator());
    L44:
        e = move-exception;
        return e.getErrorEval();
    L4:
        if (r8.length != 1) goto L7;
        String r11 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r8[0], r9.getRowIndex(), r9.getColumnIndex()));     // Catch: EvaluationException -> L44
    L15:
        if ("".equals(r11) == true) goto L17;
        if (r11 == null) goto L17;
    L18:
        String r12 = r11.replace(" ", "");
        String[] r1 = r12.split("[" + r0 + "]");
        if (r1.length <= 2) goto L23;
        return ErrorEval.VALUE_INVALID;
    L23:
        if (r1.length <= 1) goto L30;
        String r13 = r1[0];
        String r2 = r1[1];
        if (r2.contains(r10) == true) goto L27;
        r12 = r13.replace(r10, "") + "." + r2;
    L32:
        int r14 = 0;
    L34:
        if (r12.endsWith("%") == false) goto L48;
        r14 = r14 + 1;
        r12 = r12.substring(0, r12.length() - 1);
        goto L34
    L48:
        double r15 = Double.parseDouble(r12) / Math.pow(100.0d, r14);     // Catch: Exception -> L39 EvaluationException -> L41
        checkValue(r15);     // Catch: Exception -> L39 EvaluationException -> L41
        goto L40
    L38:
        return new NumberEval(r15);
    L41:
        e = move-exception;
        return e.getErrorEval();
    L40:
        return ErrorEval.VALUE_INVALID;
    L27:
        return ErrorEval.VALUE_INVALID;
    L30:
        if (r1.length <= 0) goto L32;
        r12 = r1[0].replace(r10, "");
    L17:
        r11 = "0";
        goto L18
    L7:
        if (r8.length != 2) goto L10;
        ValueEval r3 = OperandResolver.getSingleValue(r8[0], r9.getRowIndex(), r9.getColumnIndex());     // Catch: EvaluationException -> L44
        ValueEval r16 = OperandResolver.getSingleValue(r8[1], r9.getRowIndex(), r9.getColumnIndex());     // Catch: EvaluationException -> L44
        String r17 = OperandResolver.coerceValueToString(r3);     // Catch: EvaluationException -> L44
        r0 = OperandResolver.coerceValueToString(r16).substring(0, 1);     // Catch: EvaluationException -> L44
        r11 = r17;
        goto L15
    L10:
        if (r8.length != 3) goto L13;
        ValueEval r18 = OperandResolver.getSingleValue(r8[0], r9.getRowIndex(), r9.getColumnIndex());     // Catch: EvaluationException -> L44
        ValueEval r4 = OperandResolver.getSingleValue(r8[1], r9.getRowIndex(), r9.getColumnIndex());     // Catch: EvaluationException -> L44
        ValueEval r19 = OperandResolver.getSingleValue(r8[2], r9.getRowIndex(), r9.getColumnIndex());     // Catch: EvaluationException -> L44
        String r20 = OperandResolver.coerceValueToString(r18);     // Catch: EvaluationException -> L44
        r0 = OperandResolver.coerceValueToString(r4).substring(0, 1);     // Catch: EvaluationException -> L44
        String r21 = OperandResolver.coerceValueToString(r19).substring(0, 1);     // Catch: EvaluationException -> L44
        r11 = r20;
        r10 = r21;
        goto L15
    L13:
        r11 = null;
        goto L15
    }
}
