package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class EDate implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new EDate();
    }

    public EDate() {
    }

    private double getValue(ValueEval r5) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, NumberEval.class) == false) goto L7;
    L5:
        return ((NumberEval) ZeusTransformUtils.preCheckCast(r4, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, BlankEval.class) == false) goto L10;
        return 0.0d;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, RefEval.class) == false) goto L22;
        RefEval r6 = (RefEval) ZeusTransformUtils.preCheckCast(r4, RefEval.class, "com.obric.memorydata.plugin");
        if (r6.getNumberOfSheets() > 1) goto L20;
        r4 = r6.getInnerValueEval(r6.getFirstSheetIndex());
        if (ZeusTransformUtils.instanceOf(r4, NumberEval.class) == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r4, BlankEval.class) == false) goto L22;
        return 0.0d;
    L20:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L22:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r4, OperationEvaluationContext r5) {
        if (r4.length == 2) goto L16;
        return ErrorEval.VALUE_INVALID;
    L16:
        double r1 = getValue(r4[0]);     // Catch: EvaluationException -> L13
        int r3 = (int) getValue(r4[1]);     // Catch: EvaluationException -> L13
        Date r6 = DateUtil.getJavaDate(r1);     // Catch: EvaluationException -> L13
        if (r6 == null) goto L10;
        Calendar r7 = LocaleUtil.getLocaleCalendar();     // Catch: EvaluationException -> L13
        r7.setTime(r6);     // Catch: EvaluationException -> L13
        r7.add(2, r3);     // Catch: EvaluationException -> L13
        return new NumberEval(DateUtil.getExcelDate(r7.getTime()));
    L10:
        return ErrorEval.VALUE_INVALID;
    L13:
        e = move-exception;
        return e.getErrorEval();
    }
}
