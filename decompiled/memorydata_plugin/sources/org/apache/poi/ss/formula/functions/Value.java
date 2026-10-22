package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class Value extends Fixed1ArgFunction implements ArrayFunction {
    private static final Double ZERO = null;

    static {
        ZERO = Double.valueOf(0.0d);
    }

    public Value() {
    }

    public static Double convertTextToNumber(String r14) {
        int r0 = r14.length();
        boolean r1 = false;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
    L4:
        if (r2 >= r0) goto L31;
        char r10 = r14.charAt(r2);
        if (Character.isDigit(r10) == true) goto L31;
        if (r10 == '.') goto L31;
        if (r10 == ' ') goto L30;
        if (r10 != '$') goto L13;
        if (r3 == true) goto L28;
        r3 = true;
        goto L30
    L28:
        return null;
    L13:
        if (r10 != '+') goto L15;
        if (r4 == true) goto L26;
        if (r5 == true) goto L26;
        r5 = true;
    L26:
        return null;
    L15:
        if (r10 != '-') goto L16;
        if (r4 == true) goto L21;
        if (r5 == true) goto L21;
        r4 = true;
    L21:
        return null;
    L16:
        return null;
    L30:
        r2 = r2 + 1;
    L31:
        if (r2 < r0) goto L39;
        if (r3 == true) goto L38;
        if (r4 == true) goto L38;
        if (r5 == true) goto L38;
        return ZERO;
    L38:
        return null;
    L39:
        StringBuilder r6 = new StringBuilder(r0);
        int r11 = -32768;
        int r7 = r2;
        boolean r8 = false;
    L41:
        if (r7 >= r0) goto L80;
        char r12 = r14.charAt(r7);
        if (Character.isDigit(r12) == false) goto L45;
        r6.append(r12);
    L79:
        r7 = r7 + 1;
        goto L41
    L45:
        if (r12 != ' ') goto L47;
        String r13 = r14.substring(r7).trim();
        if (r13.equals("%") == false) goto L77;
    L72:
        r8 = true;
        goto L79
    L77:
        if (r13.length() <= 0) goto L79;
        return null;
    L47:
        if (r12 == '%') goto L72;
        if (r12 == ',') goto L66;
        if (r12 != '.') goto L52;
        if (r1 == true) goto L61;
        if ((r7 - r11) < 4) goto L64;
        r6.append('.');
        r1 = true;
        goto L79
    L64:
        return null;
    L61:
        return null;
    L52:
        if (r12 == 'E') goto L57;
        if (r12 == 'e') goto L57;
        return null;
    L57:
        if ((r7 - r11) < 4) goto L58;
        r6.append(r14.substring(r7));
        r7 = r0;
        goto L79
    L58:
        return null;
    L66:
        if (r1 == true) goto L67;
        if ((r7 - r11) < 4) goto L70;
        r11 = r7;
        goto L79
    L70:
        return null;
    L67:
        return null;
    L80:
        if (r1 == false) goto L82;
    L92:
        double r9 = Double.parseDouble(r6.toString());     // Catch: NumberFormatException -> L91
        if (r4 == false) goto L87;
        r9 = -r9;
    L87:
        if (r8 == false) goto L90;
        r9 = r9 / 100.0d;
    L90:
        return Double.valueOf(r9);
    L91:
        return null;
    L82:
        if ((r7 - r11) >= 4) goto L92;
        return null;
    }

    public static Double parseDateTime(String r0) {
        return DateUtil.parseDateTime(r0);
    L4:
        return null;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        String r1 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3));
        if (StringUtil.isBlank(r1) == true) goto L7;
        Double r5 = convertTextToNumber(r1);
        if (r5 != null) goto L11;
        r5 = parseDateTime(r1);
    L11:
        if (r5 != null) goto L15;
        return ErrorEval.VALUE_INVALID;
    L15:
        return new NumberEval(r5.doubleValue());
    L7:
        return ErrorEval.VALUE_INVALID;
    L16:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r3, final int r4, final int r5) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluateOneArrayArg(r3[0], r4, r5, new $$Lambda$Value$i9nyMepwAiewnCFalgNGqT_mmsA(this, r4, r5));
    }

    public /* synthetic */ ValueEval lambda$evaluateArray$0$Value(int r3, int r4, ValueEval r5) {
        return evaluate(r3, r4, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"));
    }
}
