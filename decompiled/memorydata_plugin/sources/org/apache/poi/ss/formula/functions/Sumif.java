package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Sumif extends Var2or3ArgFunction {
    public Sumif() {
    }

    private static double accumulate(AreaEval r4, CountUtils.I_MatchPredicate r5, AreaEval r6, int r7, int r8) {
        AreaEval r9 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r4, AreaEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r10 = (CountUtils.I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r5, CountUtils.I_MatchPredicate.class, "com.obric.memorydata.plugin");
        AreaEval r11 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r6, AreaEval.class, "com.obric.memorydata.plugin");
        if (r10.matches(r9.getRelativeValue(r7, r8)) == true) goto L5;
        return 0.0d;
    L5:
        ValueEval r12 = r11.getRelativeValue(r7, r8);
        if (ZeusTransformUtils.instanceOf(r12, NumberEval.class) == false) goto L10;
        return ((NumberEval) ZeusTransformUtils.preCheckCast(r12, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r12, ErrorEval.class) == true) goto L13;
        return 0.0d;
    L13:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r12, ErrorEval.class, "com.obric.memorydata.plugin"));
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

    private static AreaEval createSumRange(ValueEval r3, AreaEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r6 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r4, AreaEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, AreaEval.class) == false) goto L7;
        return ((AreaEval) ZeusTransformUtils.preCheckCast(r5, AreaEval.class, "com.obric.memorydata.plugin")).offset(0, r6.getHeight() - 1, 0, r6.getWidth() - 1);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, RefEval.class) == false) goto L11;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r5, RefEval.class, "com.obric.memorydata.plugin")).offset(0, r6.getHeight() - 1, 0, r6.getWidth() - 1);
    L11:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static ValueEval eval(int r2, int r3, ValueEval r4, AreaEval r5, AreaEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r8 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r5, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r9 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r6, AreaEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r10 = Countif.createCriteriaPredicate(r7, r2, r3);
        if (r10 == null) goto L5;
        return new NumberEval(sumMatchingCells(r8, r10, r9));
    L8:
        e = move-exception;
        return e.getErrorEval();
    L5:
        return NumberEval.ZERO;
    }

    private static double sumMatchingCells(AreaEval r9, CountUtils.I_MatchPredicate r10, AreaEval r11) {
        AreaEval r12 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r9, AreaEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r13 = (CountUtils.I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r10, CountUtils.I_MatchPredicate.class, "com.obric.memorydata.plugin");
        AreaEval r14 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r11, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r12.getHeight();
        int r1 = r12.getWidth();
        double r3 = 0.0d;
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L7;
        r3 = r3 + accumulate(r12, r13, r14, r5, r6);
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return r3;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r7 = convertRangeArg(r1);     // Catch: EvaluationException -> L6
        return eval(r2, r3, r6, r7, r7);
    L6:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r9 = convertRangeArg(r1);     // Catch: EvaluationException -> L6
        return eval(r2, r3, r7, r9, createSumRange(r8, r9));
    L6:
        e = move-exception;
        return e.getErrorEval();
    }
}
