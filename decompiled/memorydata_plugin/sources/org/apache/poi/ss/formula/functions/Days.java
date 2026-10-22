package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class Days implements FreeRefFunction {
    public static final Days instance = null;

    static {
        instance = new Days();
    }

    private Days() {
    }

    private static double evaluate(LocalDate r1, LocalDate r2) {
        return ChronoUnit.DAYS.between(r2, r1);
    }

    private ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        return new NumberEval(evaluate(getDate(r1, r2, r3), getDate(r6, r2, r3)));
    L6:
        e = move-exception;
        return e.getErrorEval();
    }

    private static LocalDate getDate(double r1) {
        return DateUtil.getJavaDate(r1, false).toInstant().atZone(LocaleUtil.getUserTimeZone().toZoneId()).toLocalDate();
    }

    static LocalDate getDate(ValueEval r2, int r3, int r4) {
        ValueEval r5 = OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
        return getDate(NumericFunction.singleOperandEvaluate(r5, r3, r4));
    L6:
        return DateParser.parseLocalDate(OperandResolver.coerceValueToString(r5));
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        if (r4.length == 2) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r5.getRowIndex(), r5.getColumnIndex(), r4[0], r4[1]);
    }
}
