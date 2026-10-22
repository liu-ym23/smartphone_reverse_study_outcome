package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.util.HashMap;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class FactDouble extends Fixed1ArgFunction implements FreeRefFunction {
    static HashMap<Integer, BigInteger> cache;
    public static final FreeRefFunction instance = null;

    static {
        instance = new FactDouble();
        cache = new HashMap();
    }

    public FactDouble() {
    }

    public static BigInteger factorial(int r2) {
        if (r2 == 0) goto L12;
        if (r2 < 0) goto L12;
        if (cache.containsKey(Integer.valueOf(r2)) == true) goto L8;
        BigInteger r0 = BigInteger.valueOf(r2).multiply(factorial(r2 - 2));
        cache.put(Integer.valueOf(r2), r0);
        return r0;
    L8:
        return (BigInteger) ZeusTransformUtils.preCheckCast(cache.get(Integer.valueOf(r2)), BigInteger.class, "com.obric.memorydata.plugin");
    L12:
        return BigInteger.ONE;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3) {
        int r0 = OperandResolver.coerceValueToInt((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"));     // Catch: EvaluationException -> L9
        if (r0 >= 0) goto L8;
        return ErrorEval.NUM_ERROR;
    L8:
        return new NumberEval(factorial(r0).longValue());
    L10:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    }
}
