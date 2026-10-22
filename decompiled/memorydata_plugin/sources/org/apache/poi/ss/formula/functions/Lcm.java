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
public class Lcm implements FreeRefFunction {
    private static final long MAX_OUTPUT = 0;
    public static final Lcm instance = null;

    static {
        instance = new Lcm();
        MAX_OUTPUT = (long) Math.pow(2.0d, 53.0d);
    }

    public Lcm() {
    }

    private boolean isInvalidInput(double r3) {
        if (r3 >= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r10, OperationEvaluationContext r11) {
        int r2 = 1;
        if (r10.length >= 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        if (r10.length == 1) goto L36;
        ArrayList r1 = new ArrayList();     // Catch: EvaluationException -> L33
        int r4 = r10.length;     // Catch: EvaluationException -> L33
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L23;
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[r5], r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L33
        if (isInvalidInput(r6) == true) goto L21;
        r1.add(Long.valueOf((long) r6));     // Catch: EvaluationException -> L33
        r5 = r5 + 1;     // Catch: EvaluationException -> L33
        goto L17
    L21:
        return ErrorEval.NUM_ERROR;
    L23:
        long r9 = ((Long) ZeusTransformUtils.preCheckCast(r1.get(0), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: EvaluationException -> L33
    L25:
        if (r2 >= r1.size()) goto L32;
        r9 = ArithmeticUtils.lcm(r9, ((Long) ZeusTransformUtils.preCheckCast(r1.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: EvaluationException -> L33
        if (r9 > MAX_OUTPUT) goto L29;
        r2 = r2 + 1;     // Catch: EvaluationException -> L33
        goto L25
    L29:
        return ErrorEval.NUM_ERROR;
    L32:
        return new NumberEval(r9);
    L34:
        return ErrorEval.VALUE_INVALID;
    L36:
        double r12 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10[0], r11.getRowIndex(), r11.getColumnIndex()));     // Catch: EvaluationException -> L14
        if (isInvalidInput(r12) == false) goto L13;
        return ErrorEval.NUM_ERROR;
    L13:
        return new NumberEval((long) r12);
    L15:
        return ErrorEval.VALUE_INVALID;
    }
}
