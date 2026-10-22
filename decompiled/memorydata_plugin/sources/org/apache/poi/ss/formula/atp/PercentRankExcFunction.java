package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.PercentRank;

/* JADX INFO: loaded from: classes7.dex */
final class PercentRankExcFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new PercentRankExcFunction(ArgumentsEvaluator.instance);
    }

    private PercentRankExcFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    private ValueEval calculateRank(List<Double> r16, double r17, int r19, boolean r20) {
        List<Double> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        double r2 = Double.MAX_VALUE;
        if (r20 == false) goto L31;
        Iterator<Double> r6 = r0.iterator();
        double r9 = Double.MIN_VALUE;
        double r11 = Double.MIN_VALUE;
        double r4 = Double.MAX_VALUE;
    L6:
        if (r6.hasNext() == false) goto L24;
        Double r7 = (Double) ZeusTransformUtils.preCheckCast(r6.next(), Double.class, "com.obric.memorydata.plugin");
        if (r7.doubleValue() > r17) goto L13;
        if (r7.doubleValue() <= r11) goto L13;
        r11 = r7.doubleValue();
    L13:
        if (r7.doubleValue() <= r17) goto L18;
        if (r7.doubleValue() >= r4) goto L18;
        r4 = r7.doubleValue();
    L18:
        if (r7.doubleValue() >= r2) goto L21;
        r2 = r7.doubleValue();
    L21:
        if (r7.doubleValue() <= r9) goto L6;
        r9 = r7.doubleValue();
        goto L6
    L24:
        if (r17 < r2) goto L30;
        if (r17 > r9) goto L30;
        double r10 = r4;
    L32:
        if (r20 == true) goto L34;
    L50:
        int r3 = 0;
        Iterator<Double> r5 = r0.iterator();
    L52:
        if (r5.hasNext() == false) goto L57;
        if (((Double) ZeusTransformUtils.preCheckCast(r5.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue() >= r17) goto L52;
        r3 = r3 + 1;
        goto L52
    L57:
        return new NumberEval(PercentRank.round(BigDecimal.valueOf(((double) (r3 + 1)) / ((double) (r0.size() + 1))), r19));
    L34:
        if (r11 == r17) goto L50;
        if (r10 == r17) goto L50;
        if (r19 >= 5) goto L41;
        int r8 = 8;
    L42:
        int r13 = r8;
        ValueEval r14 = calculateRank(r0, r11, r13, false);
        if (ZeusTransformUtils.instanceOf(r14, NumberEval.class) == true) goto L45;
        return r14;
    L45:
        ValueEval r1 = calculateRank(r0, r10, r13, false);
        if (ZeusTransformUtils.instanceOf(r1, NumberEval.class) == true) goto L49;
        return r1;
    L49:
        return PercentRank.interpolate(r17, r11, r10, (NumberEval) ZeusTransformUtils.preCheckCast(r14, NumberEval.class, "com.obric.memorydata.plugin"), (NumberEval) ZeusTransformUtils.preCheckCast(r1, NumberEval.class, "com.obric.memorydata.plugin"), r19);
    L41:
        r8 = r19 + 3;
    L30:
        return ErrorEval.NA;
    L31:
        r10 = Double.MAX_VALUE;
        r11 = Double.MIN_VALUE;
        goto L32
    }

    private ValueEval evaluate(ValueEval[] r10, int r11, int r12) {
        if (r10.length >= 2) goto L52;
        return ErrorEval.VALUE_INVALID;
    L52:
        double r5 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[1], r11, r12));     // Catch: EvaluationException -> L42
        ArrayList r4 = new ArrayList();
        Iterator<ValueEval> r2 = PercentRank.getValues(r10[0], r11, r12).iterator();     // Catch: EvaluationException -> L36
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

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        return evaluate(r2, r3.getRowIndex(), r3.getColumnIndex());
    }
}
