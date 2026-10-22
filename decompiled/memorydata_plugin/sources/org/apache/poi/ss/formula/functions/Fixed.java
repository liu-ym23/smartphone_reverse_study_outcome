package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Fixed implements Function1Arg, Function2Arg, Function3Arg {
    public Fixed() {
    }

    private ValueEval fixed(ValueEval r4, ValueEval r5, ValueEval r6, int r7, int r8) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        BigDecimal r11 = BigDecimal.valueOf(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r3, r7, r8)));     // Catch: EvaluationException -> L12
        int r12 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r9, r7, r8));     // Catch: EvaluationException -> L12
        Boolean r13 = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(r10, r7, r8), false);     // Catch: EvaluationException -> L12
        BigDecimal r14 = r11.setScale(r12, RoundingMode.HALF_UP);     // Catch: EvaluationException -> L12
        DecimalFormat r15 = (DecimalFormat) ZeusTransformUtils.preCheckCast(NumberFormat.getNumberInstance(Locale.US), DecimalFormat.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L12
        if (r13 != null) goto L6;
    L9:
        boolean r16 = true;
    L10:
        r15.setGroupingUsed(r16);     // Catch: EvaluationException -> L12
        r15.setMinimumFractionDigits(Math.max(r12, 0));     // Catch: EvaluationException -> L12
        r15.setMaximumFractionDigits(Math.max(r12, 0));     // Catch: EvaluationException -> L12
        return new StringEval(r15.format(r14.doubleValue()));
    L6:
        if (r13.booleanValue() == false) goto L9;
        r16 = false;
    L12:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r7, int r8, ValueEval r9) {
        return fixed((ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin"), new NumberEval(2.0d), BoolEval.FALSE, r7, r8);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r9, int r10, ValueEval r11, ValueEval r12) {
        return fixed((ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), BoolEval.FALSE, r9, r10);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r9, int r10, ValueEval r11, ValueEval r12, ValueEval r13) {
        return fixed((ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin"), r9, r10);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r7, int r8, int r9) {
        int r0 = r7.length;
        if (r0 != 1) goto L5;
        ValueEval r1 = r7[0];
        ValueEval r2 = new NumberEval(2.0d);
    L14:
        ValueEval r3 = BoolEval.FALSE;
    L12:
        return fixed(r1, r2, r3, r8, r9);
    L5:
        if (r0 != 2) goto L7;
        r1 = r7[0];
        r2 = r7[1];
        goto L14
    L7:
        if (r0 != 3) goto L9;
        r1 = r7[0];
        r2 = r7[1];
        r3 = r7[2];
        goto L12
    L9:
        return ErrorEval.VALUE_INVALID;
    }
}
