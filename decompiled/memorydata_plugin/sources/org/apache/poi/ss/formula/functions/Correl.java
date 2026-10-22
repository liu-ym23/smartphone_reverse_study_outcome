package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Correl extends Fixed2ArgFunction {
    public static final Correl instance = null;

    static {
        instance = new Correl();
    }

    private Correl() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3, ValueEval r4) {
        List<DoubleList> r0 = ArrayFunctionUtils.getNumberArrays((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5 EvaluationException -> L7
        return new NumberEval(new PearsonsCorrelation().correlation(((DoubleList) ZeusTransformUtils.preCheckCast(r0.get(0), DoubleList.class, "com.obric.memorydata.plugin")).toArray(), ((DoubleList) ZeusTransformUtils.preCheckCast(r0.get(1), DoubleList.class, "com.obric.memorydata.plugin")).toArray()));
    L7:
        e = move-exception;
        return e.getErrorEval();
    L6:
        return ErrorEval.NA;
    }
}
