package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Substitute extends Var3or4ArgFunction {
    public Substitute() {
    }

    private static String replaceAllOccurrences(String r3, String r4, String r5) {
        if (r4.length() >= 1) goto L5;
        return r3;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L6:
        int r2 = r3.indexOf(r4, r1);
        if (r2 < 0) goto L8;
        r0.append(r3, r1, r2);
        r0.append(r5);
        r1 = r4.length() + r2;
        goto L6
    L8:
        r0.append(r3.substring(r1));
        return r0.toString();
    }

    private static String replaceOneOccurrence(String r5, String r6, String r7, int r8) {
        if (r6.length() >= 1) goto L5;
        return r5;
    L5:
        int r2 = 0;
        int r3 = 0;
    L6:
        int r4 = r5.indexOf(r6, r2);
        if (r4 < 0) goto L8;
        r3 = r3 + 1;
        if (r3 == r8) goto L12;
        r2 = r4 + r6.length();
        goto L6
    L12:
        return r5.substring(0, r4) + r7 + r5.substring(r4 + r6.length());
    L8:
        return r5;
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        return new StringEval(replaceAllOccurrences(TextFunction.evaluateStringArg(r1, r2, r3), TextFunction.evaluateStringArg(r7, r2, r3), TextFunction.evaluateStringArg(r8, r2, r3)));
    L6:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6, ValueEval r7) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        String r11 = TextFunction.evaluateStringArg(r1, r2, r3);     // Catch: EvaluationException -> L10
        String r12 = TextFunction.evaluateStringArg(r8, r2, r3);     // Catch: EvaluationException -> L10
        String r13 = TextFunction.evaluateStringArg(r9, r2, r3);     // Catch: EvaluationException -> L10
        int r14 = TextFunction.evaluateIntArg(r10, r2, r3);     // Catch: EvaluationException -> L10
        if (r14 >= 1) goto L9;
        return ErrorEval.VALUE_INVALID;
    L9:
        return new StringEval(replaceOneOccurrence(r11, r12, r13, r14));
    L10:
        e = move-exception;
        return e.getErrorEval();
    }
}
