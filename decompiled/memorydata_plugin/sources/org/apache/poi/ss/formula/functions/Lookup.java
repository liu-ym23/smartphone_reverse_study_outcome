package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Lookup extends Var2or3ArgFunction {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public Lookup() {
    }

    private static LookupUtils.ValueVector createVector(TwoDEval r2) {
        LookupUtils.ValueVector r3 = LookupUtils.createVector((TwoDEval) ZeusTransformUtils.wrapperContextForParams(r2, TwoDEval.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L6;
        return r3;
    L6:
        throw new RuntimeException("non-vector lookup or result areas not supported yet");
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = OperandResolver.getSingleValue(r1, r2, r3);     // Catch: EvaluationException -> L10
        TwoDEval r8 = LookupUtils.resolveTableArrayArg(r6);     // Catch: EvaluationException -> L10
        if (r8.getWidth() <= r8.getHeight()) goto L7;
        LookupUtils.ValueVector r9 = createVector(r8.getRow(0));     // Catch: EvaluationException -> L10
        TwoDEval r10 = r8.getRow(r8.getHeight() - 1);     // Catch: EvaluationException -> L10
    L6:
        LookupUtils.ValueVector r11 = createVector(r10);     // Catch: EvaluationException -> L10
        return r11.getItem(LookupUtils.lookupFirstIndexOfValue(r7, r9, true));
    L7:
        r9 = createVector(r8.getColumn(0));     // Catch: EvaluationException -> L10
        r10 = r8.getColumn(r8.getWidth() - 1);     // Catch: EvaluationException -> L10
    L10:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5, ValueEval r6) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = OperandResolver.getSingleValue(r1, r2, r3);     // Catch: EvaluationException -> L9
        TwoDEval r10 = LookupUtils.resolveTableArrayArg(r7);     // Catch: EvaluationException -> L9
        TwoDEval r11 = LookupUtils.resolveTableArrayArg(r8);     // Catch: EvaluationException -> L9
        LookupUtils.ValueVector r12 = createVector(r10);     // Catch: EvaluationException -> L9
        LookupUtils.ValueVector r13 = createVector(r11);     // Catch: EvaluationException -> L9
        if (r12.getSize() > r13.getSize()) goto L8;
        return r13.getItem(LookupUtils.lookupFirstIndexOfValue(r9, r12, true));
    L8:
        throw new RuntimeException("Lookup vector and result vector of differing sizes not supported yet");     // Catch: EvaluationException -> L9
    L9:
        e = move-exception;
        return e.getErrorEval();
    }
}
