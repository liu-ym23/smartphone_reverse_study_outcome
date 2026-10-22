package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class ParityFunction implements FreeRefFunction {
    public static final FreeRefFunction IS_EVEN = null;
    public static final FreeRefFunction IS_ODD = null;
    private final int _desiredParity;

    static {
        IS_EVEN = new ParityFunction(0);
        IS_ODD = new ParityFunction(1);
    }

    private ParityFunction(int r1) {
        this._desiredParity = r1;
    }

    private static int evaluateArgParity(ValueEval r2, int r3, int r4) {
        double r5 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, (short) r4));
        if (r5 >= 0.0d) goto L6;
        r5 = -r5;
    L6:
        return Math.toIntExact(((long) Math.floor(r5)) & 1);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        boolean r1 = true;
        if (r4.length == 1) goto L17;
        return ErrorEval.VALUE_INVALID;
    L17:
        if (evaluateArgParity(r4[0], r5.getRowIndex(), r5.getColumnIndex()) == this._desiredParity) goto L13;
        r1 = false;
    L13:
        return BoolEval.valueOf(r1);
    L14:
        e = move-exception;
        return e.getErrorEval();
    }
}
