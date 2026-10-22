package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;

/* JADX INFO: loaded from: classes7.dex */
final class YearFrac implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new YearFrac();
    }

    private YearFrac() {
    }

    private static double evaluateDateArg(ValueEval r2, int r3, int r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, (short) r4);
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == false) goto L11;
        String r6 = ((StringEval) ZeusTransformUtils.preCheckCast(r5, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        Double r7 = OperandResolver.parseDouble(r6);
        if (r7 == null) goto L9;
        return r7.doubleValue();
    L9:
        return DateUtil.getExcelDate(DateParser.parseLocalDate(r6), false);
    L11:
        return OperandResolver.coerceValueToDouble(r5);
    }

    private static int evaluateIntArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, (short) r4));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r5, OperationEvaluationContext r6) {
        int r4 = r6.getRowIndex();
        int r7 = r6.getColumnIndex();
        int r0 = r5.length;     // Catch: EvaluationException -> L14
        if (r0 != 2) goto L6;
        int r1 = 0;
    L13:
        return new NumberEval(YearFracCalculator.calculate(evaluateDateArg(r5[0], r4, r7), evaluateDateArg(r5[1], r4, r7), r1));
    L6:
        if (r0 != 3) goto L8;
        r1 = evaluateIntArg(r5[2], r4, r7);     // Catch: EvaluationException -> L14
        goto L13
    L8:
        return ErrorEval.VALUE_INVALID;
    L14:
        e = move-exception;
        return e.getErrorEval();
    }
}
