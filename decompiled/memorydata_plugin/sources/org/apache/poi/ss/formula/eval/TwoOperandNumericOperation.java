package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TwoOperandNumericOperation extends Fixed2ArgFunction implements ArrayFunction {
    public static final Function AddEval = null;
    public static final Function DivideEval = null;
    public static final Function MultiplyEval = null;
    public static final Function PowerEval = null;
    public static final Function SubtractEval = null;

    private static final class SubtractEvalClass extends TwoOperandNumericOperation {
        public SubtractEvalClass() {
        }

        @Override // org.apache.poi.ss.formula.eval.TwoOperandNumericOperation
        public double evaluate(double r1, double r3) {
            return r1 - r3;
        }
    }

    static {
        AddEval = new AnonymousClass1();
        DivideEval = new AnonymousClass2();
        MultiplyEval = new AnonymousClass3();
        PowerEval = new AnonymousClass4();
        SubtractEval = new SubtractEvalClass();
    }

    public TwoOperandNumericOperation() {
    }

    public abstract double evaluate(double r1, double r3);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        double r9 = evaluate(singleOperandEvaluate(r7, r3, r4), singleOperandEvaluate(r8, r3, r4));     // Catch: EvaluationException -> L18
        if (r9 != 0.0d) goto L10;
        if (ZeusTransformUtils.instanceOf(this, SubtractEvalClass.class) == true) goto L10;
        return NumberEval.ZERO;
    L10:
        if (Double.isNaN(r9) == true) goto L17;
        if (Double.isInfinite(r9) == true) goto L17;
        return new NumberEval(r9);
    L17:
        return ErrorEval.NUM_ERROR;
    L18:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] r8, int r9, int r10) {
        if (r8.length == 2) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluateTwoArrayArgs(r8[0], r8[1], r9, r10, new $$Lambda$TwoOperandNumericOperation$uEfruOmR9pWQdtPQSmeoOZFzzEM(this));
    }

    public /* synthetic */ ValueEval lambda$evaluateArray$0$TwoOperandNumericOperation(ValueEval r3, ValueEval r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        return new NumberEval(evaluate(OperandResolver.coerceValueToDouble(r5), OperandResolver.coerceValueToDouble(r6)));
    L5:
        e = move-exception;
        return e.getErrorEval();
    }

    public final double singleOperandEvaluate(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));
    }
}
