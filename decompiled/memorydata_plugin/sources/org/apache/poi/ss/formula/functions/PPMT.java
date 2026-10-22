package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class PPMT extends NumericFunction {
    public PPMT() {
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction
    public double eval(ValueEval[] r9, int r10, int r11) {
        if (r9.length < 4) goto L7;
        ValueEval r8 = OperandResolver.getSingleValue(r9[0], r10, r11);
        ValueEval r0 = OperandResolver.getSingleValue(r9[1], r10, r11);
        ValueEval r1 = OperandResolver.getSingleValue(r9[2], r10, r11);
        ValueEval r12 = OperandResolver.getSingleValue(r9[3], r10, r11);
        double r13 = Finance.ppmt(OperandResolver.coerceValueToDouble(r8), OperandResolver.coerceValueToInt(r0), OperandResolver.coerceValueToInt(r1), OperandResolver.coerceValueToDouble(r12));
        checkValue(r13);
        return r13;
    L7:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
