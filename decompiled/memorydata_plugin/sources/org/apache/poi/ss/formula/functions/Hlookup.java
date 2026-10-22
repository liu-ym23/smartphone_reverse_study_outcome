package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Hlookup extends Var3or4ArgFunction {
    private static final ValueEval DEFAULT_ARG3 = null;

    static {
        DEFAULT_ARG3 = BoolEval.TRUE;
    }

    public Hlookup() {
    }

    private LookupUtils.ValueVector createResultColumnVector(TwoDEval r2, int r3) {
        TwoDEval r1 = (TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin");
        if (r3 >= r1.getHeight()) goto L7;
        return LookupUtils.createRowVector(r1, r3);
    L7:
        throw EvaluationException.invalidRef();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r10, int r11, ValueEval r12, ValueEval r13, ValueEval r14) {
        return evaluate(r10, r11, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r13, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r14, ValueEval.class, "com.obric.memorydata.plugin"), DEFAULT_ARG3);
    }

    @Override // org.apache.poi.ss.formula.functions.Function4Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6, ValueEval r7, ValueEval r8) {
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r13 = OperandResolver.getSingleValue(r9, r3, r4);     // Catch: EvaluationException -> L5
        TwoDEval r14 = LookupUtils.resolveTableArrayArg(r10);     // Catch: EvaluationException -> L5
        boolean r15 = LookupUtils.resolveRangeLookupArg(r12, r3, r4);     // Catch: EvaluationException -> L5
        int r16 = LookupUtils.lookupFirstIndexOfValue(r13, LookupUtils.createRowVector(r14, 0), r15);     // Catch: EvaluationException -> L5
        return createResultColumnVector(r14, LookupUtils.resolveRowOrColIndexArg(r11, r3, r4)).getItem(r16);
    L5:
        e = move-exception;
        return e.getErrorEval();
    }
}
