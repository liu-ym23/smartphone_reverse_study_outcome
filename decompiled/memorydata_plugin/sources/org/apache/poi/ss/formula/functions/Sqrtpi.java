package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: classes7.dex */
public class Sqrtpi implements FreeRefFunction {
    public static final Sqrtpi instance = null;

    static {
        instance = new Sqrtpi();
    }

    public Sqrtpi() {
    }

    private ValueEval evaluate(int r3, int r4, ValueEval r5) {
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: EvaluationException -> L9
        if (isInvalidInput(r6) == false) goto L8;
        return ErrorEval.NUM_ERROR;
    L8:
        return new NumberEval(Double.parseDouble(NumberToTextConverter.toText(Math.sqrt(r6 * 3.141592653589793d))));
    L9:
        e = move-exception;
        return e.getErrorEval();
    }

    private boolean isInvalidInput(double r3) {
        if (r3 >= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    }
}
