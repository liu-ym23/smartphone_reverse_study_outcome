package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Single implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Single();
    }

    private Single() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r7, OperationEvaluationContext r8) {
        int r6 = r8.getColumnIndex();
        int r9 = r8.getRowIndex();
        int r0 = r7.length;
        ValueEval r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        ValueEval r3 = r7[r2];
        if (ZeusTransformUtils.instanceOf(r3, AreaEvalBase.class) == false) goto L24;
        AreaEvalBase r4 = (AreaEvalBase) ZeusTransformUtils.preCheckCast(r3, AreaEvalBase.class, "com.obric.memorydata.plugin");
        if (r4.contains(r9, r6) == false) goto L13;
        if (r1 != null) goto L10;
        r1 = r4.getAbsoluteValue(r9, r6);
        goto L24
    L10:
        return ErrorEval.VALUE_INVALID;
    L13:
        if (r4.containsRow(r9) == false) goto L19;
        if (r1 != null) goto L16;
        r1 = r4.getAbsoluteValue(r9, r4.getFirstColumn());
        goto L24
    L16:
        return ErrorEval.VALUE_INVALID;
    L19:
        if (r4.containsColumn(r6) == false) goto L24;
        if (r1 != null) goto L22;
        r1 = r4.getAbsoluteValue(r4.getFirstRow(), r6);
        goto L24
    L22:
        return ErrorEval.VALUE_INVALID;
    L24:
        r2 = r2 + 1;
        goto L3
    L25:
        if (r1 == null) goto L28;
        return r1;
    L28:
        return ErrorEval.VALUE_INVALID;
    }
}
