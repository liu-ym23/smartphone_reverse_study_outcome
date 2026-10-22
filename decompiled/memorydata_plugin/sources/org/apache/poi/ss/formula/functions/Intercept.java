package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Intercept extends Fixed2ArgFunction {
    private final LinearRegressionFunction func;

    public Intercept() {
        this.func = new LinearRegressionFunction(LinearRegressionFunction.FUNCTION.INTERCEPT);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        return this.func.evaluate(r3, r4, r7, r8);
    }
}
