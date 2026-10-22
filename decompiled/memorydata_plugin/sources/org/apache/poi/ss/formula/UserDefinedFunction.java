package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class UserDefinedFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new UserDefinedFunction();
    }

    private UserDefinedFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r6, OperationEvaluationContext r7) {
        int r5 = r6.length;
        if (r5 < 1) goto L20;
        ValueEval r2 = r6[0];
        if (ZeusTransformUtils.instanceOf(r2, FunctionNameEval.class) == false) goto L18;
        String r3 = ((FunctionNameEval) ZeusTransformUtils.preCheckCast(r2, FunctionNameEval.class, "com.obric.memorydata.plugin")).getFunctionName();
        FreeRefFunction r4 = r7.findUserDefinedFunction(r3);
        if (r4 == null) goto L16;
        int r8 = r5 - 1;
        ValueEval[] r9 = new ValueEval[r8];
        System.arraycopy(r6, 1, r9, 0, r8);
        if (ZeusTransformUtils.instanceOf(r4, ArrayFunction.class) == false) goto L14;
        ValueEval r10 = OperationEvaluatorFactory.evaluateArrayFunction((ArrayFunction) ZeusTransformUtils.preCheckCast(r4, ArrayFunction.class, "com.obric.memorydata.plugin"), r9, r7);
        if (r10 == null) goto L14;
        return r10;
    L14:
        return r4.evaluate(r9, r7);
    L16:
        throw new NotImplementedFunctionException(r3);
    L18:
        throw new RuntimeException("First argument should be a NameEval, but got (" + r2.getClass().getName() + ")");
    L20:
        throw new RuntimeException("function name argument missing");
    }
}
