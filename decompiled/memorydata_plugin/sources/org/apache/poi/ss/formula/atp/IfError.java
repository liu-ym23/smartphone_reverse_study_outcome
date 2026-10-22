package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class IfError implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new IfError();
    }

    private IfError() {
    }

    private static ValueEval evaluateInternal(ValueEval r2, ValueEval r3, int r4, int r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = WorkbookEvaluator.dereferenceResult(r6, r4, r5);
        if (ZeusTransformUtils.instanceOf(r8, ErrorEval.class) == false) goto L5;
        return r7;
    L5:
        return r8;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r2, OperationEvaluationContext r3) {
        if (r2.length == 2) goto L12;
        return ErrorEval.VALUE_INVALID;
    L12:
        return evaluateInternal(r2[0], r2[1], r3.getRowIndex(), r3.getColumnIndex());
    L9:
        e = move-exception;
        return e.getErrorEval();
    }
}
