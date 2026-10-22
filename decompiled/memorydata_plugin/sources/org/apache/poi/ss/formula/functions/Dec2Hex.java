package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Dec2Hex extends Var1or2ArgFunction implements FreeRefFunction {
    private static final long MAX_VALUE = 0;
    private static final long MIN_VALUE = 0;
    public static final FreeRefFunction instance = null;

    static {
        instance = new Dec2Hex();
        MIN_VALUE = Long.parseLong("-549755813888");
        MAX_VALUE = Long.parseLong("549755813887");
    }

    public Dec2Hex() {
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
        if (r10.longValue() < MIN_VALUE) goto L39;
        if (r10.longValue() > MAX_VALUE) goto L39;
        if (r10.doubleValue() >= 0.0d) goto L16;
        int r11 = 10;
    L30:
        if (r11 == 0) goto L32;
        String r12 = String.format(Locale.ROOT, "%0" + r11 + "X", new Object[]{Integer.valueOf(r10.intValue())});
    L34:
        if (r10.doubleValue() >= 0.0d) goto L37;
        r12 = "FF" + r12.substring(2);
    L37:
        return new StringEval(r12.toUpperCase(Locale.ROOT));
    L32:
        r12 = Long.toHexString(r10.longValue());
        goto L34
    L16:
        if (r9 != null) goto L43;
        r11 = 0;
        goto L30
    L43:
        Double r13 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r9, r5, r6)));
        if (r13 == null) goto L21;
        r11 = r13.intValue();
        if (r11 >= 0) goto L30;
        return ErrorEval.NUM_ERROR;
    L21:
        return ErrorEval.VALUE_INVALID;
    L26:
        e = move-exception;
        return e.getErrorEval();
    L39:
        return ErrorEval.NUM_ERROR;
    L40:
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
