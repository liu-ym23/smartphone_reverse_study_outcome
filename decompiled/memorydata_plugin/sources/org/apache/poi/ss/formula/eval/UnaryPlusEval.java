package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public final class UnaryPlusEval extends Fixed1ArgFunction implements ArrayFunction {
    public static final Function instance = null;

    static {
        instance = new UnaryPlusEval();
    }

    private UnaryPlusEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        ValueEval r1 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3);     // Catch: EvaluationException -> L9
        if (ZeusTransformUtils.instanceOf(r1, StringEval.class) == false) goto L6;
        return r1;
    L6:
        return new NumberEval(OperandResolver.coerceValueToDouble(r1));
    L9:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r3, final int r4, final int r5) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluateOneArrayArg(r3[0], r4, r5, new $$Lambda$UnaryPlusEval$6P1oUKZ6HL7Af7pQxieAkEPd2X4(this, r4, r5));
    }

    public /* synthetic */ ValueEval lambda$evaluateArray$0$UnaryPlusEval(int r3, int r4, ValueEval r5) {
        return evaluate(r3, r4, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"));
    }
}
