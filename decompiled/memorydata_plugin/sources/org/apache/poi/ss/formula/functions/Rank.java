package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Rank extends Var2or3ArgFunction {
    public Rank() {
    }

    private static AreaEval convertRangeArg(ValueEval r2) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AreaEval.class) == false) goto L7;
        return (AreaEval) ZeusTransformUtils.preCheckCast(r3, AreaEval.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L11;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin")).offset(0, 0, 0, 0);
    L11:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static ValueEval eval(double r9, AreaEval r11, boolean r12) {
        AreaEval r13 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r11, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r13.getHeight();
        int r1 = r13.getWidth();
        int r3 = 1;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L19;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L17;
        Double r6 = getValue(r13, r4, r5);
        if (r6 == null) goto L16;
        if (r12 == true) goto L11;
    L12:
        if (r12 == true) goto L16;
        if (r6.doubleValue() >= r9) goto L16;
    L15:
        r3 = r3 + 1;
        goto L16
    L11:
        if (r6.doubleValue() > r9) goto L15;
    L16:
        r5 = r5 + 1;
        goto L5
    L17:
        r4 = r4 + 1;
        goto L3
    L19:
        return new NumberEval(r3);
    }

    private static ValueEval eval(double r5, RefListEval r7, boolean r8) {
        Iterator<ValueEval> r9 = r7.getList().iterator();
        int r0 = 1;
    L4:
        if (r9.hasNext() == false) goto L19;
        ValueEval r1 = (ValueEval) ZeusTransformUtils.preCheckCast(r9.next(), ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, RefEval.class) == false) goto L9;
        r1 = ((RefEval) ZeusTransformUtils.preCheckCast(r1, RefEval.class, "com.obric.memorydata.plugin")).getInnerValueEval(((RefEval) ZeusTransformUtils.preCheckCast(r1, RefEval.class, "com.obric.memorydata.plugin")).getFirstSheetIndex());
    L9:
        if (ZeusTransformUtils.instanceOf(r1, NumberEval.class) == false) goto L4;
        double r2 = ((NumberEval) ZeusTransformUtils.preCheckCast(r1, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        if (r8 == true) goto L13;
    L14:
        if (r8 == true) goto L4;
        if (r2 >= r5) goto L4;
    L17:
        r0 = r0 + 1;
        goto L4
    L13:
        if (r2 > r5) goto L17;
    L19:
        return new NumberEval(r0);
    }

    private static Double getValue(AreaEval r2, int r3, int r4) {
        ValueEval r5 = ((AreaEval) ZeusTransformUtils.wrapperContextForParams(r2, AreaEval.class, "com.obric.memorydata.plugin")).getRelativeValue(r3, r4);
        if (ZeusTransformUtils.instanceOf(r5, NumberEval.class) == true) goto L5;
        return null;
    L5:
        return Double.valueOf(((NumberEval) ZeusTransformUtils.preCheckCast(r5, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        double r7 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r1, r2, r3));     // Catch: EvaluationException -> L15
        if (Double.isNaN(r7) == true) goto L14;
        if (Double.isInfinite(r7) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r6, RefListEval.class) == false) goto L12;
        return eval(r7, (RefListEval) ZeusTransformUtils.preCheckCast(r6, RefListEval.class, "com.obric.memorydata.plugin"), true);
    L12:
        return eval(r7, convertRangeArg(r6), true);
    L14:
        throw new EvaluationException(ErrorEval.NUM_ERROR);     // Catch: EvaluationException -> L15
    L15:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r4, int r5, ValueEval r6, ValueEval r7, ValueEval r8) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        double r1 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r3, r4, r5));     // Catch: EvaluationException -> L22
        if (Double.isNaN(r1) == true) goto L21;
        if (Double.isInfinite(r1) == true) goto L21;
        int r11 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r10, r4, r5));     // Catch: EvaluationException -> L22
        boolean r12 = true;
        if (r11 == 0) goto L13;
        if (r11 != 1) goto L19;
        r12 = false;
        goto L13
    L19:
        throw new EvaluationException(ErrorEval.NUM_ERROR);     // Catch: EvaluationException -> L22
    L13:
        if (ZeusTransformUtils.instanceOf(r9, RefListEval.class) == false) goto L17;
        return eval(r1, (RefListEval) ZeusTransformUtils.preCheckCast(r9, RefListEval.class, "com.obric.memorydata.plugin"), r12);
    L17:
        return eval(r1, convertRangeArg(r9), r12);
    L21:
        throw new EvaluationException(ErrorEval.NUM_ERROR);     // Catch: EvaluationException -> L22
    L22:
        e = move-exception;
        return e.getErrorEval();
    }
}
