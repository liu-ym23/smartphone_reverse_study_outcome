package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Table;

/* JADX INFO: loaded from: classes7.dex */
public final class Indirect implements FreeRefFunction {
    private static final c LOGGER = null;
    public static final FreeRefFunction instance = null;

    static {
        LOGGER = b.a(Indirect.class);
        instance = new Indirect();
    }

    private Indirect() {
    }

    private static boolean canTrim(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r4.length() - 1;
        if (r0 >= 0) goto L6;
        return false;
    L6:
        if (Character.isWhitespace(r4.charAt(0)) == false) goto L9;
        return true;
    L9:
        return Character.isWhitespace(r4.charAt(r0));
    }

    private static boolean evaluateBooleanArg(ValueEval r2, OperationEvaluationContext r3) {
        ValueEval r4 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3.getRowIndex(), r3.getColumnIndex());
        if (r4 != BlankEval.instance) goto L5;
    L9:
        return false;
    L5:
        if (r4 == MissingArgEval.instance) goto L9;
        return OperandResolver.coerceValueToBoolean(r4, false).booleanValue();
    }

    private static ValueEval evaluateIndirect(OperationEvaluationContext r10, String r11, boolean r12) {
        int r0 = r11.lastIndexOf(33);
        if (r0 >= 0) goto L5;
        String r1 = r11;
        String r5 = null;
        String r6 = null;
    L10:
        if (r12 == true) goto L12;
    L18:
        int r4 = r1.indexOf(58);
        if (r4 >= 0) goto L21;
        String r7 = r1.trim();
        String r8 = null;
    L28:
        return r10.getDynamicReference(r5, r6, r7, r8, r12);
    L25:
        e = move-exception;
        LOGGER.atWarn().a("Indirect function: failed to parse reference {}", r11, e);
        return ErrorEval.REF_INVALID;
    L21:
        String r2 = r1.substring(0, r4).trim();
        r8 = r1.substring(r4 + 1).trim();
        r7 = r2;
        goto L28
    L12:
        if (Table.isStructuredReference.matcher(r1).matches() == false) goto L18;
        return r10.getArea3DEval(FormulaParser.parseStructuredReference(r1, (FormulaParsingWorkbook) ZeusTransformUtils.preCheckCast(r10.getWorkbook(), FormulaParsingWorkbook.class, "com.obric.memorydata.plugin"), r10.getRowIndex()));
    L17:
        return ErrorEval.REF_INVALID;
    L5:
        String[] r9 = parseWorkbookAndSheetName(r11.subSequence(0, r0));
        if (r9 == null) goto L8;
        r5 = r9[0];
        String r13 = r9[1];
        r1 = r11.substring(r0 + 1);
        r6 = r13;
        goto L10
    L8:
        return ErrorEval.REF_INVALID;
    }

    private static String[] parseWorkbookAndSheetName(CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r10.length() - 1;
        if (r0 >= 0) goto L6;
        return null;
    L6:
        if (canTrim(r10) == false) goto L8;
        return null;
    L8:
        char r4 = r10.charAt(0);
        if (Character.isWhitespace(r4) == false) goto L12;
        return null;
    L12:
        if (r4 == '\'') goto L14;
        if (r4 != '[') goto L49;
        int r1 = r10.toString().lastIndexOf(93);
        if (r1 >= 0) goto L40;
        return null;
    L40:
        CharSequence r5 = r10.subSequence(1, r1);
        if (canTrim(r5) == false) goto L43;
        return null;
    L43:
        CharSequence r11 = r10.subSequence(r1 + 1, r10.length());
        if (canTrim(r11) == false) goto L47;
        return null;
    L47:
        return new String[]{r5.toString(), r11.toString()};
    L49:
        return new String[]{null, r10.toString()};
    L14:
        if (r10.charAt(r0) == '\'') goto L16;
        return null;
    L16:
        char r6 = r10.charAt(1);
        if (Character.isWhitespace(r6) == false) goto L19;
        return null;
    L19:
        if (r6 != '[') goto L30;
        int r7 = r10.toString().lastIndexOf(93);
        if (r7 >= 0) goto L23;
        return null;
    L23:
        String r8 = unescapeString(r10.subSequence(2, r7));
        if (r8 != null) goto L26;
    L29:
        return null;
    L26:
        if (canTrim(r8) == true) goto L29;
        int r12 = r7 + 1;
    L31:
        String r13 = unescapeString(r10.subSequence(r12, r0));
        if (r13 != null) goto L35;
        return null;
    L35:
        return new String[]{r8, r13};
    L30:
        r12 = 1;
        r8 = null;
        goto L31
    }

    private static String unescapeString(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r7.length();
        StringBuilder r1 = new StringBuilder(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        char r3 = r7.charAt(r2);
        if (r3 != '\'') goto L13;
        r2 = r2 + 1;
        if (r2 >= r0) goto L8;
        char r5 = r7.charAt(r2);
        if (r5 != '\'') goto L11;
        r3 = r5;
        goto L13
    L11:
        return null;
    L8:
        return null;
    L13:
        r1.append(r3);
        r2 = r2 + 1;
        goto L3
    L15:
        return r1.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        boolean r0 = true;
        if (r4.length >= 1) goto L19;
        return ErrorEval.VALUE_INVALID;
    L19:
        String r3 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r4[0], r5.getRowIndex(), r5.getColumnIndex()));     // Catch: EvaluationException -> L16
        int r1 = r4.length;     // Catch: EvaluationException -> L16
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L12;
        r0 = evaluateBooleanArg(r4[1], r5);     // Catch: EvaluationException -> L16
        goto L15
    L12:
        return ErrorEval.VALUE_INVALID;
    L15:
        return evaluateIndirect(r5, r3, r0);
    L16:
        e = move-exception;
        return e.getErrorEval();
    }
}
