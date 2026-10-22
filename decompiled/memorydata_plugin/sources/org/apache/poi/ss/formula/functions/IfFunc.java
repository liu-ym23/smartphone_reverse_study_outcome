package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class IfFunc extends Var2or3ArgFunction implements ArrayFunction {
    public IfFunc() {
    }

    public static boolean evaluateFirstArg(ValueEval r2, int r3, int r4) {
        Boolean r5 = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4), false);
        if (r5 != null) goto L6;
        return false;
    L6:
        return r5.booleanValue();
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        if (evaluateFirstArg(r1, r2, r3) == false) goto L11;
        if (r6 == MissingArgEval.instance) goto L8;
        return r6;
    L8:
        return BlankEval.instance;
    L11:
        return BoolEval.FALSE;
    L12:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        if (evaluateFirstArg(r1, r2, r3) == false) goto L11;
        if (r7 == MissingArgEval.instance) goto L8;
        return r7;
    L8:
        return BlankEval.instance;
    L11:
        if (r8 == MissingArgEval.instance) goto L13;
        return r8;
    L13:
        return BlankEval.instance;
    L15:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r9, int r10, int r11) {
        if (r9.length < 2) goto L14;
        if (r9.length > 3) goto L14;
        ValueEval r3 = r9[0];
        ValueEval r4 = r9[1];
        if (r9.length != 2) goto L10;
        ValueEval r12 = BoolEval.FALSE;
    L12:
        return evaluateArrayArgs(r3, r4, r12, r10, r11);
    L10:
        r12 = r9[2];
    L14:
        return ErrorEval.VALUE_INVALID;
    }

    ValueEval evaluateArrayArgs(ValueEval r23, ValueEval r24, ValueEval r25, int r26, int r27) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r23, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r24, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r25, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AreaEval.class) == false) goto L6;
        AreaEval r0 = (AreaEval) ZeusTransformUtils.preCheckCast(r2, AreaEval.class, "com.obric.memorydata.plugin");
        int r7 = r0.getWidth();
        int r8 = r0.getHeight();
        int r9 = r0.getFirstColumn();
        int r10 = r0.getFirstRow();
        int r1 = r7;
    L10:
        if (ZeusTransformUtils.instanceOf(r3, AreaEval.class) == false) goto L13;
        AreaEval r11 = (AreaEval) ZeusTransformUtils.preCheckCast(r3, AreaEval.class, "com.obric.memorydata.plugin");
        int r12 = r11.getWidth();
        int r13 = r11.getHeight();
        int r14 = r11.getFirstColumn();
        int r15 = r11.getFirstRow();
    L17:
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L20;
        AreaEval r5 = (AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin");
        int r16 = r5.getFirstColumn();
        int r6 = r5.getFirstRow();
    L23:
        int r17 = Math.max(r1, r12);
        int r18 = Math.max(r8, r13);
        int r19 = r18 * r17;
        ValueEval[] r110 = new ValueEval[r19];
        int r20 = 0;
        int r21 = 0;
    L24:
        if (r21 >= r18) goto L66;
        int r111 = r20;
        int r22 = 0;
    L26:
        if (r22 >= r17) goto L64;
        int r28 = r10;
        ValueEval r29 = OperandResolver.getSingleValue(r2, r10 + r21, r9 + r22);     // Catch: EvaluationException -> L30 FormulaParseException -> L32
    L29:
        ValueEval r30 = r29;
        ValueEval r112 = r2;
        ValueEval r31 = OperandResolver.getSingleValue(r3, r15 + r21, r14 + r22);     // Catch: EvaluationException -> L36 FormulaParseException -> L38
    L35:
        ValueEval r32 = r31;
        int r210 = r6;
        ValueEval r33 = OperandResolver.getSingleValue(r4, r6 + r21, r16 + r22);     // Catch: EvaluationException -> L42 FormulaParseException -> L44
    L46:
        if (ZeusTransformUtils.instanceOf(r30, ErrorEval.class) == false) goto L71;
        r110[r111] = r30;
        r111 = r111 + 1;
    L63:
        r22 = r22 + 1;
        r10 = r28;
        r6 = r210;
        r2 = r112;
        goto L26
    L71:
        Boolean r34 = OperandResolver.coerceValueToBoolean(r30, false);     // Catch: EvaluationException -> L60
        int r35 = r111 + 1;
        if (r34 != null) goto L73;
    L57:
        r32 = r33;
    L58:
        r110[r111] = r32;     // Catch: EvaluationException -> L55
    L62:
        r111 = r35;
        goto L63
    L73:
        if (r34.booleanValue() == false) goto L57;
    L55:
        e = e;
        r111 = r35;
    L61:
        r35 = r111 + 1;
        r110[r111] = e.getErrorEval();
    L60:
        e = e;
    L44:
        r33 = ErrorEval.NAME_INVALID;
    L42:
        e = move-exception;
        r33 = e.getErrorEval();
        goto L46
    L38:
        r31 = ErrorEval.NAME_INVALID;
    L36:
        e = move-exception;
        r31 = e.getErrorEval();
        goto L35
    L32:
        r29 = ErrorEval.NAME_INVALID;
    L30:
        e = move-exception;
        r29 = e.getErrorEval();
        goto L29
    L64:
        r21 = r21 + 1;
        r20 = r111;
        goto L24
    L66:
        if (r19 != 1) goto L70;
        return r110[0];
    L70:
        return new CacheAreaEval(r26, r27, (r26 + r18) - 1, (r27 + r17) - 1, r110);
    L20:
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L22;
        RefEval r36 = (RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin");
        r16 = r36.getColumn();
        r6 = r36.getRow();
        goto L23
    L22:
        r6 = 0;
        r16 = 0;
        goto L23
    L13:
        if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L15;
        RefEval r113 = (RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin");
        r14 = r113.getColumn();
        r15 = r113.getRow();
        r12 = 1;
        r13 = 1;
        goto L17
    L15:
        r15 = 0;
        r12 = 1;
        r13 = 1;
        r14 = 0;
        goto L17
    L6:
        if (ZeusTransformUtils.instanceOf(r2, RefEval.class) == false) goto L8;
        RefEval r37 = (RefEval) ZeusTransformUtils.preCheckCast(r2, RefEval.class, "com.obric.memorydata.plugin");
        r9 = r37.getColumn();
        r10 = r37.getRow();
        r1 = 1;
        r8 = 1;
        goto L10
    L8:
        r1 = 1;
        r10 = 0;
        r8 = 1;
        r9 = 0;
        goto L10
    }
}
