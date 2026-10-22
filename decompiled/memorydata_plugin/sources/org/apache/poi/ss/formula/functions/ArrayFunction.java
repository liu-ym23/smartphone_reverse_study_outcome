package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.BiFunction;
import org.apache.poi.ss.formula.CacheAreaEval;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public interface ArrayFunction {
    static ValueEval _evaluateOneArrayArg(ValueEval r18, int r19, int r20, java.util.function.Function<ValueEval, ValueEval> r21) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r18, ValueEval.class, "com.obric.memorydata.plugin");
        java.util.function.Function r3 = (java.util.function.Function) ZeusTransformUtils.wrapperContextForParams(r21, java.util.function.Function.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AreaEval.class) == false) goto L6;
        AreaEval r0 = (AreaEval) ZeusTransformUtils.preCheckCast(r2, AreaEval.class, "com.obric.memorydata.plugin");
        int r6 = r0.getWidth();
        int r7 = r0.getHeight();
        int r8 = r0.getFirstColumn();
        int r9 = r0.getFirstRow();
        int r1 = r6;
    L9:
        int r10 = Math.max(r1, 1);
        int r11 = Math.max(r7, 1);
        int r12 = r11 * r10;
        ValueEval[] r15 = new ValueEval[r12];
        int r4 = 0;
        int r13 = 0;
    L10:
        if (r13 >= r11) goto L26;
        int r14 = r4;
        int r16 = 0;
    L12:
        if (r16 >= r10) goto L25;
        ValueEval r5 = OperandResolver.getSingleValue(r2, r9 + r13, r8 + r16);     // Catch: RuntimeException -> L16 EvaluationException -> L21 FormulaParseException -> L31
    L24:
        r15[r14] = (ValueEval) ZeusTransformUtils.preCheckCast(r3.apply(r5), ValueEval.class, "com.obric.memorydata.plugin");
        r16 = r16 + 1;
        r14 = r14 + 1;
    L16:
        e = move-exception;
        if (e.getMessage().startsWith("Don't know how to evaluate name") == true) goto L23;
        throw e;
    L21:
        e = move-exception;
        r5 = e.getErrorEval();
    L23:
        r5 = ErrorEval.NAME_INVALID;
        goto L24
    L25:
        r13 = r13 + 1;
        r4 = r14;
        goto L10
    L26:
        if (r12 != 1) goto L30;
        return r15[0];
    L30:
        return new CacheAreaEval(r19, r20, (r19 + r11) - 1, (r20 + r10) - 1, r15);
    L6:
        if (ZeusTransformUtils.instanceOf(r2, RefEval.class) == false) goto L8;
        RefEval r17 = (RefEval) ZeusTransformUtils.preCheckCast(r2, RefEval.class, "com.obric.memorydata.plugin");
        r8 = r17.getColumn();
        r9 = r17.getRow();
        r1 = 1;
        r7 = 1;
        goto L9
    L8:
        r1 = 1;
        r7 = 1;
        r9 = 0;
        r8 = 0;
        goto L9
    }

    static ValueEval _evaluateTwoArrayArgs(ValueEval r22, ValueEval r23, int r24, int r25, BiFunction<ValueEval, ValueEval, ValueEval> r26) {
        ValueEval r3 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r22, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r23, ValueEval.class, "com.obric.memorydata.plugin");
        BiFunction r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r26, BiFunction.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AreaEval.class) == false) goto L6;
        AreaEval r0 = (AreaEval) ZeusTransformUtils.preCheckCast(r3, AreaEval.class, "com.obric.memorydata.plugin");
        int r8 = r0.getWidth();
        int r9 = r0.getHeight();
        int r10 = r0.getFirstColumn();
        int r11 = r0.getFirstRow();
        int r1 = r8;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L13;
        AreaEval r12 = (AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin");
        int r13 = r12.getWidth();
        int r14 = r12.getHeight();
        int r15 = r12.getFirstColumn();
        int r16 = r12.getFirstRow();
    L16:
        int r17 = Math.max(r1, r13);
        int r18 = Math.max(r9, r14);
        int r19 = r18 * r17;
        ValueEval[] r110 = new ValueEval[r19];
        int r2 = 0;
        int r6 = 0;
    L17:
        if (r6 >= r18) goto L53;
        int r111 = r2;
        int r7 = 0;
    L19:
        if (r7 >= r17) goto L51;
        int r27 = r11;
        ValueEval r20 = OperandResolver.getSingleValue(r3, r11 + r6, r10 + r7);     // Catch: RuntimeException -> L23 EvaluationException -> L28 FormulaParseException -> L59
    L22:
        ValueEval r21 = r20;
        ValueEval r112 = r3;
        ValueEval r28 = OperandResolver.getSingleValue(r4, r16 + r6, r15 + r7);     // Catch: RuntimeException -> L34 EvaluationException -> L39 FormulaParseException -> L58
    L43:
        if (ZeusTransformUtils.instanceOf(r21, ErrorEval.class) == false) goto L46;
        r110[r111] = r21;
        r111 = r111 + 1;
    L50:
        r7 = r7 + 1;
        r11 = r27;
        r3 = r112;
        goto L19
    L46:
        if (ZeusTransformUtils.instanceOf(r28, ErrorEval.class) == false) goto L48;
        int r29 = r111 + 1;
        r110[r111] = r28;
    L49:
        r111 = r29;
        goto L50
    L48:
        r29 = r111 + 1;
        r110[r111] = (ValueEval) ZeusTransformUtils.preCheckCast(r5.apply(r21, r28), ValueEval.class, "com.obric.memorydata.plugin");
    L34:
        e = move-exception;
        if (e.getMessage().startsWith("Don't know how to evaluate name") == true) goto L41;
        throw e;
    L39:
        e = move-exception;
        r28 = e.getErrorEval();
    L41:
        r28 = ErrorEval.NAME_INVALID;
        goto L43
    L23:
        e = move-exception;
        if (e.getMessage().startsWith("Don't know how to evaluate name") == true) goto L30;
        throw e;
    L28:
        e = move-exception;
        r20 = e.getErrorEval();
    L30:
        r20 = ErrorEval.NAME_INVALID;
        goto L22
    L51:
        r6 = r6 + 1;
        r2 = r111;
        goto L17
    L53:
        if (r19 != 1) goto L57;
        return r110[0];
    L57:
        return new CacheAreaEval(r24, r25, (r24 + r18) - 1, (r25 + r17) - 1, r110);
    L13:
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L15;
        RefEval r113 = (RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin");
        r15 = r113.getColumn();
        r16 = r113.getRow();
        r13 = 1;
        r14 = 1;
        goto L16
    L15:
        r16 = 0;
        r13 = 1;
        r14 = 1;
        r15 = 0;
        goto L16
    L6:
        if (ZeusTransformUtils.instanceOf(r3, RefEval.class) == false) goto L8;
        RefEval r30 = (RefEval) ZeusTransformUtils.preCheckCast(r3, RefEval.class, "com.obric.memorydata.plugin");
        r10 = r30.getColumn();
        r11 = r30.getRow();
        r1 = 1;
        r9 = 1;
        goto L10
    L8:
        r1 = 1;
        r11 = 0;
        r9 = 1;
        r10 = 0;
        goto L10
    }

    ValueEval evaluateArray(ValueEval[] r1, int r2, int r3);

    default ValueEval evaluateOneArrayArg(ValueEval r2, int r3, int r4, java.util.function.Function<ValueEval, ValueEval> r5) {
        return _evaluateOneArrayArg((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4, (java.util.function.Function) ZeusTransformUtils.wrapperContextForParams(r5, java.util.function.Function.class, "com.obric.memorydata.plugin"));
    }

    default ValueEval evaluateTwoArrayArgs(ValueEval r2, ValueEval r3, int r4, int r5, BiFunction<ValueEval, ValueEval, ValueEval> r6) {
        return _evaluateTwoArrayArgs((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), r4, r5, (BiFunction) ZeusTransformUtils.wrapperContextForParams(r6, BiFunction.class, "com.obric.memorydata.plugin"));
    }
}
