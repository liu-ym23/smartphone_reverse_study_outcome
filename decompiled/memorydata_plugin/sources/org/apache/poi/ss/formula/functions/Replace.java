package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Replace extends Fixed4ArgFunction {
    public Replace() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6, ValueEval r7) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        String r11 = TextFunction.evaluateStringArg(r1, r2, r3);     // Catch: EvaluationException -> L20
        int r12 = TextFunction.evaluateIntArg(r8, r2, r3);     // Catch: EvaluationException -> L20
        int r13 = TextFunction.evaluateIntArg(r9, r2, r3);     // Catch: EvaluationException -> L20
        String r14 = TextFunction.evaluateStringArg(r10, r2, r3);     // Catch: EvaluationException -> L20
        if (r12 < 1) goto L19;
        if (r13 < 0) goto L19;
        StringBuilder r15 = new StringBuilder(r11);
        if (r12 > r11.length()) goto L13;
        if (r13 == 0) goto L13;
        int r16 = r12 - 1;
        r15.delete(r16, r13 + r16);
    L13:
        if (r12 <= r15.length()) goto L15;
        r15.append(r14);
    L17:
        return new StringEval(r15.toString());
    L15:
        r15.insert(r12 - 1, r14);
    L19:
        return ErrorEval.VALUE_INVALID;
    L20:
        e = move-exception;
        return e.getErrorEval();
    }
}
