package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BooleanFunction implements ArrayFunction, Function {
    public static final Function AND = null;
    public static final Function FALSE = null;
    public static final Function NOT = null;
    public static final Function OR = null;
    public static final Function TRUE = null;

    static {
        AND = new AnonymousClass1();
        OR = new AnonymousClass2();
        FALSE = $$Lambda$BooleanFunction$UvXtkh7izfbEu2cHZXSf5FpVUqU.INSTANCE;
        TRUE = $$Lambda$BooleanFunction$1g6gsdRJPvCwgGPCVPim7xhD8DQ.INSTANCE;
        NOT = $$Lambda$BooleanFunction$Fo1fe1yTqB3_E9PbPt1lKt6w8Tc.INSTANCE;
    }

    public BooleanFunction() {
    }

    private boolean calculate(ValueEval[] r13) {
        boolean r0 = getInitialResultValue();
        int r1 = r13.length;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r1) goto L30;
        ValueEval r5 = r13[r3];
        if (ZeusTransformUtils.instanceOf(r5, TwoDEval.class) == false) goto L16;
        TwoDEval r6 = (TwoDEval) ZeusTransformUtils.preCheckCast(r5, TwoDEval.class, "com.obric.memorydata.plugin");
        int r7 = r6.getHeight();
        int r8 = r6.getWidth();
        int r9 = 0;
    L7:
        if (r9 >= r7) goto L29;
        int r10 = 0;
    L9:
        if (r10 >= r8) goto L14;
        Boolean r11 = OperandResolver.coerceValueToBoolean(r6.getValue(r9, r10), true);
        if (r11 == null) goto L13;
        r0 = partialEvaluate(r0, r11.booleanValue());
        r4 = true;
    L13:
        r10 = r10 + 1;
        goto L9
    L14:
        r9 = r9 + 1;
    L29:
        r3 = r3 + 1;
        goto L3
    L16:
        if (ZeusTransformUtils.instanceOf(r5, RefEval.class) == false) goto L24;
        RefEval r12 = (RefEval) ZeusTransformUtils.preCheckCast(r5, RefEval.class, "com.obric.memorydata.plugin");
        int r14 = r12.getFirstSheetIndex();
        int r15 = r12.getLastSheetIndex();
    L18:
        if (r14 > r15) goto L29;
        Boolean r16 = OperandResolver.coerceValueToBoolean(r12.getInnerValueEval(r14), true);
        if (r16 == null) goto L22;
        r0 = partialEvaluate(r0, r16.booleanValue());
        r4 = true;
    L22:
        r14 = r14 + 1;
        goto L18
    L24:
        if (r5 != MissingArgEval.instance) goto L26;
        Boolean r17 = false;
    L27:
        if (r17 == null) goto L29;
        r0 = partialEvaluate(r0, r17.booleanValue());
        r4 = true;
        goto L29
    L26:
        r17 = OperandResolver.coerceValueToBoolean(r5, false);
        goto L27
    L30:
        if (r4 == false) goto L33;
        return r0;
    L33:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static ValueEval evaluateFalse(ValueEval[] r0, int r1, int r2) {
        if (r0.length == 0) goto L6;
        return ErrorEval.VALUE_INVALID;
    L6:
        return BoolEval.FALSE;
    }

    private static ValueEval evaluateNot(ValueEval[] r2, final int r3, final int r4) {
        if (r2.length != 1) goto L5;
        java.util.function.Function r0 = new $$Lambda$BooleanFunction$URxzqKQXacUS4KhDUA53hHx8fLc(r3, r4);
        return ArrayFunction._evaluateOneArrayArg(r2[0], r3, r4, r0);
    L5:
        return ErrorEval.VALUE_INVALID;
    }

    private static ValueEval evaluateTrue(ValueEval[] r0, int r1, int r2) {
        if (r0.length == 0) goto L6;
        return ErrorEval.VALUE_INVALID;
    L6:
        return BoolEval.TRUE;
    }

    public static /* synthetic */ ValueEval lambda$1g6gsdRJPvCwgGPCVPim7xhD8DQ(ValueEval[] r0, int r1, int r2) {
        return evaluateTrue(r0, r1, r2);
    }

    public static /* synthetic */ ValueEval lambda$Fo1fe1yTqB3_E9PbPt1lKt6w8Tc(ValueEval[] r0, int r1, int r2) {
        return evaluateNot(r0, r1, r2);
    }

    public static /* synthetic */ ValueEval lambda$UvXtkh7izfbEu2cHZXSf5FpVUqU(ValueEval[] r0, int r1, int r2) {
        return evaluateFalse(r0, r1, r2);
    }

    static /* synthetic */ ValueEval lambda$evaluateNot$0(int r2, int r3, ValueEval r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3);     // Catch: EvaluationException -> L13
        boolean r6 = false;
        Boolean r7 = OperandResolver.coerceValueToBoolean(r5, false);     // Catch: EvaluationException -> L13
        if (r7 != null) goto L6;
    L8:
        boolean r8 = false;
    L9:
        if (r8 == true) goto L11;
        r6 = true;
    L11:
        return BoolEval.valueOf(r6);
    L6:
        if (r7.booleanValue() == false) goto L8;
        r8 = true;
    L13:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r1, int r2, int r3) {
        if (r1.length < 1) goto L5;
        return BoolEval.valueOf(calculate(r1));
    L9:
        e = move-exception;
        return e.getErrorEval();
    L5:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r1, int r2, int r3) {
        return evaluate(r1, r2, r3);
    }

    public abstract boolean getInitialResultValue();

    public abstract boolean partialEvaluate(boolean r1, boolean r2);
}
