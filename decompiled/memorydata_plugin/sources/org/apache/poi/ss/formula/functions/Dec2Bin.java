package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Dec2Bin extends Var1or2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Dec2Bin();
    }

    public Dec2Bin() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5) {
        return evaluate(r3, r4, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        Double r10 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r4, r5, r6)));
        if (r10 != null) goto L9;
        return ErrorEval.VALUE_INVALID;
    L9:
        if (r10.longValue() < (-512)) goto L41;
        if (r10.longValue() > 511) goto L41;
        if (r10.doubleValue() < 0.0d) goto L30;
        if (r9 == null) goto L30;
        Double r11 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r9, r5, r6)));
        if (r11 == null) goto L21;
        int r12 = r11.intValue();
        if (r12 < 0) goto L26;
        if (r12 == 0) goto L26;
    L31:
        String r13 = Integer.toBinaryString(r10.intValue());
        if (r13.length() <= 10) goto L35;
        r13 = r13.substring(r13.length() - 10);
    L35:
        if (r13.length() <= r12) goto L39;
        return ErrorEval.NUM_ERROR;
    L39:
        return new StringEval(r13);
    L26:
        return ErrorEval.NUM_ERROR;
    L21:
        return ErrorEval.VALUE_INVALID;
    L27:
        e = move-exception;
        return e.getErrorEval();
    L30:
        r12 = 10;
    L41:
        return ErrorEval.NUM_ERROR;
    L42:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r5, OperationEvaluationContext r6) {
        if (r5.length != 1) goto L7;
        return evaluate(r6.getRowIndex(), r6.getColumnIndex(), r5[0]);
    L7:
        if (r5.length != 2) goto L11;
        return evaluate(r6.getRowIndex(), r6.getColumnIndex(), r5[0], r5[1]);
    L11:
        return ErrorEval.VALUE_INVALID;
    }
}
