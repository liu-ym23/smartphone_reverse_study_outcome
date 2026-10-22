package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: classes7.dex */
public final class PercentRank implements Function {
    public static final Function instance = null;

    static {
        instance = new PercentRank();
    }

    private PercentRank() {
    }

    private ValueEval calculateRank(List<Double> r16, double r17, int r19, boolean r20) {
        List<Double> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        double r2 = Double.MIN_VALUE;
        double r4 = Double.MAX_VALUE;
        if (r20 == false) goto L17;
        Iterator<Double> r6 = r0.iterator();
    L6:
        if (r6.hasNext() == false) goto L17;
        Double r7 = (Double) ZeusTransformUtils.preCheckCast(r6.next(), Double.class, "com.obric.memorydata.plugin");
        if (r7.doubleValue() > r17) goto L13;
        if (r7.doubleValue() <= r2) goto L13;
        r2 = r7.doubleValue();
    L13:
        if (r7.doubleValue() <= r17) goto L6;
        if (r7.doubleValue() >= r4) goto L6;
        r4 = r7.doubleValue();
    L17:
        double r9 = r2;
        double r11 = r4;
        if (r20 == true) goto L20;
    L36:
        Iterator<Double> r3 = r0.iterator();
        int r5 = 0;
        int r8 = 0;
    L38:
        if (r3.hasNext() == false) goto L46;
        Double r10 = (Double) ZeusTransformUtils.preCheckCast(r3.next(), Double.class, "com.obric.memorydata.plugin");
        if (r10.doubleValue() < r17) goto L41;
        if (r10.doubleValue() <= r17) goto L38;
        r5 = r5 + 1;
        goto L38
    L41:
        r8 = r8 + 1;
        goto L38
    L46:
        if (r5 == r0.size()) goto L57;
        if (r8 == r0.size()) goto L57;
        int r12 = r5 + r8;
        if (r12 != 0) goto L55;
        return new NumberEval(0.0d);
    L55:
        return new NumberEval(round(BigDecimal.valueOf(((double) r8) / ((double) r12)), r19));
    L57:
        return ErrorEval.NA;
    L20:
        if (r9 == r17) goto L36;
        if (r11 == r17) goto L36;
        if (r19 >= 5) goto L27;
        int r13 = 8;
    L28:
        int r14 = r13;
        ValueEval r15 = calculateRank(r0, r9, r14, false);
        if (ZeusTransformUtils.instanceOf(r15, NumberEval.class) == true) goto L31;
        return r15;
    L31:
        ValueEval r1 = calculateRank(r0, r11, r14, false);
        if (ZeusTransformUtils.instanceOf(r1, NumberEval.class) == true) goto L35;
        return r1;
    L35:
        return interpolate(r17, r9, r11, (NumberEval) ZeusTransformUtils.preCheckCast(r15, NumberEval.class, "com.obric.memorydata.plugin"), (NumberEval) ZeusTransformUtils.preCheckCast(r1, NumberEval.class, "com.obric.memorydata.plugin"), r19);
    L27:
        r13 = r19 + 3;
        goto L28
    }

    public static List<ValueEval> getValues(ValueEval r2, int r3, int r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, AreaEval.class) == false) goto L14;
        AreaEval r6 = (AreaEval) ZeusTransformUtils.preCheckCast(r5, AreaEval.class, "com.obric.memorydata.plugin");
        ArrayList r7 = new ArrayList();
        int r8 = r6.getFirstRow();
    L6:
        if (r8 > r6.getLastRow()) goto L12;
        int r0 = r6.getFirstColumn();
    L9:
        if (r0 > r6.getLastColumn()) goto L11;
        r7.add(OperandResolver.getSingleValue(r6.getAbsoluteValue(r8, r0), r8, r0));
        r0 = r0 + 1;
        goto L9
    L11:
        r8 = r8 + 1;
        goto L6
    L12:
        return r7;
    L14:
        return Collections.singletonList(OperandResolver.getSingleValue(r5, r3, r4));
    }

    public static NumberEval interpolate(double r4, double r6, double r8, NumberEval r10, NumberEval r11, int r12) {
        double r9 = r8 - r6;
        double r5 = r4 - r6;
        BigDecimal r7 = new BigDecimal(NumberToTextConverter.toText(r11.getNumberValue() - r10.getNumberValue()));
        return new NumberEval(round(BigDecimal.valueOf(r10.getNumberValue()).add(r7.multiply(BigDecimal.valueOf(r5 / r9))), r12));
    }

    public static double round(BigDecimal r2, int r3) {
        return r2.setScale(r3 + 3, RoundingMode.HALF_UP).setScale(r3, RoundingMode.DOWN).doubleValue();
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r10, int r11, int r12) {
        if (r10.length >= 2) goto L52;
        return ErrorEval.VALUE_INVALID;
    L52:
        double r5 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[1], r11, r12));     // Catch: EvaluationException -> L42
        ArrayList r4 = new ArrayList();
        Iterator<ValueEval> r2 = getValues(r10[0], r11, r12).iterator();     // Catch: EvaluationException -> L36
    L11:
        if (r2.hasNext() == false) goto L20;
        ValueEval r3 = (ValueEval) ZeusTransformUtils.preCheckCast(r2.next(), ValueEval.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L36
        if (ZeusTransformUtils.instanceOf(r3, BlankEval.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r3, MissingArgEval.class) == true) goto L11;
        r4.add(Double.valueOf(OperandResolver.coerceValueToDouble(r3)));     // Catch: EvaluationException -> L36
        goto L11
    L20:
        if (r4.isEmpty() == false) goto L24;
        return ErrorEval.NUM_ERROR;
    L24:
        if (r10.length > 2) goto L50;
        int r7 = 3;
    L35:
        return calculateRank(r4, r5, r7, true);
    L50:
        int r13 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r10[2], r11, r12));     // Catch: EvaluationException -> L30
        if (r13 >= 1) goto L29;
        return ErrorEval.NUM_ERROR;
    L29:
        r7 = r13;
    L30:
        e = move-exception;
        return e.getErrorEval();
    L36:
        e = move-exception;
        ErrorEval r9 = e.getErrorEval();
        if (r9 == ErrorEval.NA) goto L41;
        return r9;
    L41:
        return ErrorEval.NUM_ERROR;
    L42:
        e = move-exception;
        ErrorEval r14 = e.getErrorEval();
        if (r14 != ErrorEval.NUM_ERROR) goto L47;
        return r14;
    L47:
        return ErrorEval.NUM_ERROR;
    }
}
