package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class RangeEval extends Fixed2ArgFunction {
    public static final Function instance = null;

    static {
        instance = new RangeEval();
    }

    private RangeEval() {
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

    private static AreaEval resolveRange(AreaEval r6, AreaEval r7) {
        AreaEval r8 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r6, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r9 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r7, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r8.getFirstRow();
        int r1 = r8.getFirstColumn();
        int r2 = Math.min(r0, r9.getFirstRow());
        int r3 = Math.max(r8.getLastRow(), r9.getLastRow());
        int r4 = Math.min(r1, r9.getFirstColumn());
        return r8.offset(r2 - r0, r3 - r0, r4 - r1, Math.max(r8.getLastColumn(), r9.getLastColumn()) - r1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        return resolveRange(evaluateRef(r0), evaluateRef(r5));
    L5:
        e = move-exception;
        return e.getErrorEval();
    }
}
