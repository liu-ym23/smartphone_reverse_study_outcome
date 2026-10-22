package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class FinanceFunction implements Function3Arg, Function4Arg {
    private static final ValueEval DEFAULT_ARG3 = null;
    private static final ValueEval DEFAULT_ARG4 = null;
    public static final Function FV = null;
    public static final Function NPER = null;
    public static final Function PMT = null;
    public static final Function PV = null;

    static {
        DEFAULT_ARG3 = NumberEval.ZERO;
        DEFAULT_ARG4 = BoolEval.FALSE;
        FV = new AnonymousClass1();
        NPER = new AnonymousClass2();
        PMT = new AnonymousClass3();
        PV = new AnonymousClass4();
    }

    public FinanceFunction() {
    }

    public abstract double evaluate(double r1, double r3, double r5, double r7, boolean r9);

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r10, int r11, ValueEval r12, ValueEval r13, ValueEval r14) {
        return evaluate(r10, r11, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r14, ValueEval.class, "com.obric.memorydata.plugin"), DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r11, int r12, ValueEval r13, ValueEval r14, ValueEval r15, ValueEval r16) {
        return evaluate(r11, r12, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r14, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r15, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r16, ValueEval.class, "com.obric.memorydata.plugin"), DEFAULT_ARG4);
    }

    public ValueEval evaluate(int r18, int r19, ValueEval r20, ValueEval r21, ValueEval r22, ValueEval r23, ValueEval r24) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r20, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r21, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r22, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r23, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r24, ValueEval.class, "com.obric.memorydata.plugin");
        double r8 = NumericFunction.singleOperandEvaluate(r2, r18, r19);     // Catch: EvaluationException -> L10
        double r10 = NumericFunction.singleOperandEvaluate(r4, r18, r19);     // Catch: EvaluationException -> L10
        double r12 = NumericFunction.singleOperandEvaluate(r5, r18, r19);     // Catch: EvaluationException -> L10
        double r14 = NumericFunction.singleOperandEvaluate(r6, r18, r19);     // Catch: EvaluationException -> L10
        if (NumericFunction.singleOperandEvaluate(r3, r18, r19) == 0.0d) goto L6;
        boolean r0 = true;
    L7:
        double r1 = evaluate(r8, r10, r12, r14, r0);     // Catch: EvaluationException -> L10
        NumericFunction.checkValue(r1);     // Catch: EvaluationException -> L10
        return new NumberEval(r1);
    L6:
        r0 = false;
    L10:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r16, int r17, int r18) {
        int r1 = r16.length;
        if (r1 == 3) goto L24;
        if (r1 != 4) goto L7;
        ValueEval r2 = r16[3];
        if (r2 != MissingArgEval.instance) goto L21;
        r2 = DEFAULT_ARG3;
    L21:
        ValueEval r8 = r16[0];
        ValueEval r9 = r16[1];
        ValueEval r10 = r16[2];
        return evaluate(r17, r18, r8, r9, r10, r2, DEFAULT_ARG4);
    L7:
        if (r1 != 5) goto L9;
        ValueEval r3 = r16[3];
        if (r3 != MissingArgEval.instance) goto L13;
        r3 = DEFAULT_ARG3;
    L13:
        ValueEval r13 = r3;
        ValueEval r4 = r16[4];
        if (r4 != MissingArgEval.instance) goto L16;
        r4 = DEFAULT_ARG4;
    L16:
        ValueEval r11 = r16[0];
        ValueEval r12 = r16[1];
        ValueEval r14 = r16[2];
        return evaluate(r17, r18, r11, r12, r14, r13, r4);
    L9:
        return ErrorEval.VALUE_INVALID;
    L24:
        return evaluate(r17, r18, r16[0], r16[1], r16[2], DEFAULT_ARG3, DEFAULT_ARG4);
    }
}
