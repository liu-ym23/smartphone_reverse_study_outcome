package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class ConcatEval extends Fixed2ArgFunction {
    public static final Function instance = null;

    static {
        instance = new ConcatEval();
    }

    private ConcatEval() {
    }

    private Object getText(ValueEval r3) {
        ValueEval r2 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, StringValueEval.class) == false) goto L7;
        return ((StringValueEval) ZeusTransformUtils.preCheckCast(r2, StringValueEval.class, "com.obric.memorydata.plugin")).getStringValue();
    L7:
        if (r2 != BlankEval.instance) goto L11;
        return "";
    L11:
        throw new IllegalAccessError("Unexpected value type (" + r2.getClass().getName() + ")");
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = OperandResolver.getSingleValue(r7, r3, r4);     // Catch: EvaluationException -> L6
        ValueEval r10 = OperandResolver.getSingleValue(r8, r3, r4);     // Catch: EvaluationException -> L6
        StringBuilder r11 = new StringBuilder();
        r11.append(getText(r9));
        r11.append(getText(r10));
        return new StringEval(r11.toString());
    L6:
        e = move-exception;
        return e.getErrorEval();
    }
}
