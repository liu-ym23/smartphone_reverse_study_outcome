package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public class Address implements Function {
    public Address() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r9, int r10, int r11) {
        if (r9.length < 2) goto L42;
        if (r9.length > 5) goto L42;
        boolean r8 = false;
        int r2 = (int) NumericFunction.singleOperandEvaluate(r9[0], r10, r11);     // Catch: EvaluationException -> L38
        int r4 = (int) NumericFunction.singleOperandEvaluate(r9[1], r10, r11);     // Catch: EvaluationException -> L38
        if (r9.length > 2) goto L11;
    L13:
        int r5 = 1;
    L15:
        if (r5 == 1) goto L25;
        if (r5 != 2) goto L18;
        boolean r0 = false;
        r8 = true;
    L27:
        String r7 = null;
        if (r9.length != 5) goto L33;
        ValueEval r12 = OperandResolver.getSingleValue(r9[4], r10, r11);     // Catch: EvaluationException -> L38
        if (r12 == MissingArgEval.instance) goto L33;
        r7 = OperandResolver.coerceValueToString(r12);     // Catch: EvaluationException -> L38
    L33:
        CellReference r13 = new CellReference(r2 - 1, r4 - 1, r8, r0);     // Catch: EvaluationException -> L38
        StringBuilder r14 = new StringBuilder(32);     // Catch: EvaluationException -> L38
        if (r7 == null) goto L36;
        SheetNameFormatter.appendFormat(r14, r7);     // Catch: EvaluationException -> L38
        r14.append('!');     // Catch: EvaluationException -> L38
    L36:
        r14.append(r13.formatAsString());     // Catch: EvaluationException -> L38
        return new StringEval(r14.toString());
    L18:
        if (r5 == 3) goto L23;
        if (r5 != 4) goto L22;
    L26:
        r0 = r8;
        goto L27
    L22:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);     // Catch: EvaluationException -> L38
    L23:
        r0 = true;
        goto L27
    L25:
        r8 = true;
        goto L26
    L11:
        if (r9[2] == MissingArgEval.instance) goto L13;
        r5 = (int) NumericFunction.singleOperandEvaluate(r9[2], r10, r11);     // Catch: EvaluationException -> L38
    L38:
        e = move-exception;
        return e.getErrorEval();
    L42:
        return ErrorEval.VALUE_INVALID;
    }
}
