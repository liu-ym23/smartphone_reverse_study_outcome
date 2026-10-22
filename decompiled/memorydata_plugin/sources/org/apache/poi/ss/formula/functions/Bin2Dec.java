package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class Bin2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Bin2Dec();
    }

    public Bin2Dec() {
    }

    private int getDecimalValue(String r11) {
        int r10 = r11.length();
        int r0 = r10 - 1;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r10) goto L5;
        int r3 = r1 + 1;
        r2 = r2 + ((int) (((double) Integer.parseInt(r11.substring(r1, r3))) * Math.pow(2.0d, r0)));
        r0 = r0 - 1;
        r1 = r3;
        goto L3
    L5:
        return r2;
    }

    private static String toggleBits(String r7) {
        StringBuilder r2 = new StringBuilder(Long.toBinaryString(Long.parseLong(r7, 2) ^ ((1 << r7.length()) - 1)));
        int r8 = r7.length() - r2.length();
        if (r8 <= 0) goto L6;
        r2.insert(0, StringUtil.repeat('0', r8));
    L6:
        return r2.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, RefEval.class) == false) goto L5;
        RefEval r6 = (RefEval) ZeusTransformUtils.preCheckCast(r5, RefEval.class, "com.obric.memorydata.plugin");
        r5 = r6.getInnerValueEval(r6.getFirstSheetIndex());
    L5:
        String r7 = OperandResolver.coerceValueToString(r5);
        if (r7.length() <= 10) goto L10;
        return ErrorEval.NUM_ERROR;
    L10:
        if (r7.length() >= 10) goto L12;
        String r8 = r7;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L15;
        String r1 = String.valueOf(getDecimalValue(r8));     // Catch: NumberFormatException -> L18
    L16:
        return new NumberEval(Long.parseLong(r1));
    L15:
        r1 = "-" + (getDecimalValue(toggleBits(r8)) + 1);     // Catch: NumberFormatException -> L18
    L19:
        return ErrorEval.NUM_ERROR;
    L12:
        r8 = r7.substring(1);
        r9 = r7.startsWith("0");
        goto L20
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    }
}
