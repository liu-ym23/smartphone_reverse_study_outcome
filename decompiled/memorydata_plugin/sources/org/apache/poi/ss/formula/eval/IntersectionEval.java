package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class IntersectionEval extends Fixed2ArgFunction {
    public static final Function instance = null;

    static {
        instance = new IntersectionEval();
    }

    private IntersectionEval() {
    }

    private static AreaEval evaluateRef(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AreaEval.class) == false) goto L7;
        return (AreaEval) ZeusTransformUtils.preCheckCast(r4, AreaEval.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L11;
        return ((RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin")).offset(0, 0, 0, 0);
    L11:
        if (ZeusTransformUtils.instanceOf(r4, ErrorEval.class) == false) goto L15;
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin"));
    L15:
        throw new IllegalArgumentException("Unexpected ref arg class (" + r4.getClass().getName() + ")");
    }

    private static AreaEval resolveRange(AreaEval r7, AreaEval r8) {
        AreaEval r9 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r7, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r10 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r8, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r9.getFirstRow();
        int r1 = r9.getFirstColumn();
        int r2 = r10.getLastColumn();
        if (r1 <= r2) goto L5;
        return null;
    L5:
        int r4 = r10.getFirstColumn();
        if (r4 <= r9.getLastColumn()) goto L8;
        return null;
    L8:
        int r5 = r10.getLastRow();
        if (r0 <= r5) goto L11;
        return null;
    L11:
        int r11 = r10.getFirstRow();
        int r6 = r9.getLastRow();
        if (r11 <= r6) goto L14;
        return null;
    L14:
        int r12 = Math.max(r0, r11);
        int r3 = Math.min(r6, r5);
        int r13 = Math.max(r1, r4);
        return r9.offset(r12 - r0, r3 - r0, r13 - r1, Math.min(r9.getLastColumn(), r2) - r1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r6 = resolveRange(evaluateRef(r0), evaluateRef(r5));     // Catch: EvaluationException -> L7
        if (r6 != null) goto L12;
        return ErrorEval.NULL_INTERSECTION;
    L12:
        return r6;
    L7:
        e = move-exception;
        return e.getErrorEval();
    }
}
