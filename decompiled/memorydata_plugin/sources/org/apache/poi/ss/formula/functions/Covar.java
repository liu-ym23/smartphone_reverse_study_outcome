package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Covar extends Fixed2ArgFunction implements FreeRefFunction {
    public static final Covar instanceP = null;
    public static final Covar instanceS = null;
    private final boolean sampleBased;

    static {
        instanceP = new Covar(false);
        instanceS = new Covar(true);
    }

    private Covar(boolean r1) {
        this.sampleBased = r1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        List<DoubleList> r6 = ArrayFunctionUtils.getNumberArrays((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5 EvaluationException -> L7
        return new NumberEval(new Covariance().covariance(((DoubleList) ZeusTransformUtils.preCheckCast(r6.get(0), DoubleList.class, "com.obric.memorydata.plugin")).toArray(), ((DoubleList) ZeusTransformUtils.preCheckCast(r6.get(1), DoubleList.class, "com.obric.memorydata.plugin")).toArray(), this.sampleBased));
    L7:
        e = move-exception;
        return e.getErrorEval();
    L6:
        return ErrorEval.NA;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        if (r4.length == 2) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r5.getRowIndex(), r5.getColumnIndex(), r4[0], r4[1]);
    }
}
