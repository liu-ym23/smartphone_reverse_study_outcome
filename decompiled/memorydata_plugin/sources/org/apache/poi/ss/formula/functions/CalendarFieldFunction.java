package org.apache.poi.ss.formula.functions;

import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CalendarFieldFunction extends Fixed1ArgFunction {
    public static final Function DAY = null;
    public static final Function HOUR = null;
    public static final Function MINUTE = null;
    public static final Function MONTH = null;
    public static final Function SECOND = null;
    public static final Function YEAR = null;
    private final int _dateFieldId;

    static {
        YEAR = new CalendarFieldFunction(1);
        MONTH = new CalendarFieldFunction(2);
        DAY = new CalendarFieldFunction(5);
        HOUR = new CalendarFieldFunction(11);
        MINUTE = new CalendarFieldFunction(12);
        SECOND = new CalendarFieldFunction(13);
    }

    private CalendarFieldFunction(int r1) {
        this._dateFieldId = r1;
    }

    private int getCalField(double r6) {
        if (((int) r6) != 0) goto L14;
        int r0 = this._dateFieldId;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L8;
        return 1;
    L8:
        if (r0 != 5) goto L14;
        return 0;
    L12:
        return ODatePickerView.YEAR_FROM;
    L14:
        int r7 = DateUtil.getJavaCalendarUTC(r6 + 5.78125E-6d, false).get(this._dateFieldId);
        if (this._dateFieldId == 2) goto L17;
        return r7;
    L17:
        return r7 + 1;
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public final ValueEval evaluate(int r3, int r4, ValueEval r5) {
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: EvaluationException -> L10
        if (r6 >= 0.0d) goto L9;
        return ErrorEval.NUM_ERROR;
    L9:
        return new NumberEval(getCalField(r6));
    L10:
        e = move-exception;
        return e.getErrorEval();
    }
}
