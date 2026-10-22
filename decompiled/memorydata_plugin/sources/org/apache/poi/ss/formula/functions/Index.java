package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Index implements ArrayMode, Function2Arg, Function3Arg, Function4Arg {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public Index() {
    }

    private static TwoDEval convertFirstArg(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L7;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin")).offset(0, 0, 0, 0);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, TwoDEval.class) == false) goto L11;
        return (TwoDEval) ZeusTransformUtils.preCheckCast(r4, TwoDEval.class, "com.obric.memorydata.plugin");
    L11:
        throw new RuntimeException("Incomplete code - cannot handle first arg of type (" + r4.getClass().getName() + ")");
    }

    private static ValueEval getValueFromArea(TwoDEval r2, int r3, int r4) {
        TwoDEval r5 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin");
        if (r3 != 0) goto L5;
        TwoDEval r6 = r5;
    L10:
        if (r4 != 0) goto L12;
        return r6;
    L12:
        if (r4 > r5.getWidth()) goto L15;
        return r6.getColumn(r4 - 1);
    L15:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    L5:
        if (r3 > r5.getHeight()) goto L8;
        r6 = r5.getRow(r3 - 1);
        goto L10
    L8:
        throw new EvaluationException(ErrorEval.REF_INVALID);
    }

    private static int resolveIndexArg(ValueEval r2, int r3, int r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
        if (r5 != MissingArgEval.instance) goto L6;
        return 0;
    L6:
        if (r5 != BlankEval.instance) goto L8;
        return 0;
    L8:
        int r6 = OperandResolver.coerceValueToInt(r5);
        if (r6 < 0) goto L12;
        return r6;
    L12:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        TwoDEval r8 = convertFirstArg(r2);
        int r9 = resolveIndexArg(r7, r3, r4);     // Catch: EvaluationException -> L12
        int r10 = 0;
        if (r8.isColumn() == true) goto L11;
        if (r8.isRow() == false) goto L8;
        r10 = r9;
        r9 = 0;
        goto L11
    L8:
        return ErrorEval.REF_INVALID;
    L11:
        return getValueFromArea(r8, r9, r10);
    L12:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        TwoDEval r9 = convertFirstArg(r1);
        int r10 = resolveIndexArg(r8, r2, r3);     // Catch: EvaluationException -> L5
        return getValueFromArea(r9, resolveIndexArg(r7, r2, r3), r10);
    L5:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Incomplete code - don't know how to support the 'area_num' parameter yet)");
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r9, int r10, int r11) {
        int r0 = r9.length;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L11;
        return ErrorEval.VALUE_INVALID;
    L11:
        return evaluate(r10, r11, r9[0], r9[1], r9[2], r9[3]);
    L13:
        return evaluate(r10, r11, r9[0], r9[1], r9[2]);
    L15:
        return evaluate(r10, r11, r9[0], r9[1]);
    }
}
