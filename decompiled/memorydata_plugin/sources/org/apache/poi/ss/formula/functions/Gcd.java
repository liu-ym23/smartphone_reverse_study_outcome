package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Gcd implements FreeRefFunction {
    private static final long MAX_INPUT = 0;
    public static final Gcd instance = null;

    static {
        instance = new Gcd();
        MAX_INPUT = (long) Math.pow(2.0d, 53.0d);
    }

    public Gcd() {
    }

    private boolean isInvalidInput(double r3) {
        if (r3 >= 0.0d) goto L5;
    L8:
        return true;
    L5:
        if (r3 > MAX_INPUT) goto L8;
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r10, OperationEvaluationContext r11) {
        int r2 = 1;
        if (r10.length >= 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        if (r10.length == 1) goto L32;
        ArrayList r1 = new ArrayList();     // Catch: EvaluationException -> L29
        int r4 = r10.length;     // Catch: EvaluationException -> L29
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L23;
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[r5], r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L29
        if (isInvalidInput(r6) == true) goto L21;
        r1.add(Long.valueOf((long) r6));     // Catch: EvaluationException -> L29
        r5 = r5 + 1;     // Catch: EvaluationException -> L29
        goto L17
    L21:
        return ErrorEval.NUM_ERROR;
    L23:
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(r1.get(0), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: EvaluationException -> L29
    L25:
        if (r2 >= r1.size()) goto L28;
        r9 = ArithmeticUtils.gcd(r9, ((Long) ZeusTransformUtils.preCheckCast(r1.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: EvaluationException -> L29
        r2 = r2 + 1;     // Catch: EvaluationException -> L29
        goto L25
    L28:
        return new NumberEval(r9);
    L30:
        return ErrorEval.VALUE_INVALID;
    L32:
        double r12 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[0], r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L14
        if (isInvalidInput(r12) == false) goto L13;
        return ErrorEval.NUM_ERROR;
    L13:
        return new NumberEval((long) r12);
    L15:
        return ErrorEval.VALUE_INVALID;
    }
}
