package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
public class WeekNum extends Fixed2ArgFunction implements FreeRefFunction {
    private static final NumberEval DEFAULT_RETURN_TYPE = null;
    private static final HashSet<Integer> VALID_RETURN_TYPES = null;
    public static final FreeRefFunction instance = null;
    private WeekFields FRIDAY_START;
    private WeekFields MONDAY_START;
    private WeekFields SATURDAY_START;
    private WeekFields SUNDAY_START;
    private WeekFields THURSDAY_START;
    private WeekFields TUESDAY_START;
    private WeekFields WEDNESDAY_START;

    static {
        instance = new WeekNum();
        DEFAULT_RETURN_TYPE = new NumberEval(1.0d);
        VALID_RETURN_TYPES = new HashSet(Arrays.asList(new Integer[]{1, 2, 11, 12, 13, 14, 15, 16, 17, 21}));
    }

    public WeekNum() {
        this.SUNDAY_START = WeekFields.of(DayOfWeek.SUNDAY, 1);
        this.MONDAY_START = WeekFields.of(DayOfWeek.MONDAY, 1);
        this.TUESDAY_START = WeekFields.of(DayOfWeek.TUESDAY, 1);
        this.WEDNESDAY_START = WeekFields.of(DayOfWeek.WEDNESDAY, 1);
        this.THURSDAY_START = WeekFields.of(DayOfWeek.THURSDAY, 1);
        this.FRIDAY_START = WeekFields.of(DayOfWeek.FRIDAY, 1);
        this.SATURDAY_START = WeekFields.of(DayOfWeek.SATURDAY, 1);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        LocalDate r9 = DateUtil.getJavaDate(NumericFunction.singleOperandEvaluate(r7, r3, r4), false).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();     // Catch: Exception -> L18
        ValueEval r10 = OperandResolver.getSingleValue(r8, r3, r4);     // Catch: EvaluationException -> L16
        if (ZeusTransformUtils.instanceOf(r10, MissingArgEval.class) == false) goto L9;
        int r11 = (int) DEFAULT_RETURN_TYPE.getNumberValue();     // Catch: EvaluationException -> L16
    L11:
        if (VALID_RETURN_TYPES.contains(Integer.valueOf(r11)) == true) goto L15;
        return ErrorEval.NUM_ERROR;
    L15:
        return new NumberEval(getWeekNo(r9, r11));
    L9:
        r11 = OperandResolver.coerceValueToInt(r10);     // Catch: EvaluationException -> L16
        goto L11
    L17:
        return ErrorEval.NUM_ERROR;
    L19:
        return ErrorEval.NUM_ERROR;
    L21:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r5, OperationEvaluationContext r6) {
        if (r5.length != 1) goto L7;
        return evaluate(r6.getRowIndex(), r6.getColumnIndex(), r5[0], DEFAULT_RETURN_TYPE);
    L7:
        if (r5.length != 2) goto L11;
        return evaluate(r6.getRowIndex(), r6.getColumnIndex(), r5[0], r5[1]);
    L11:
        return ErrorEval.VALUE_INVALID;
    }

    public int getWeekNo(LocalDate r2, int r3) {
        if (r3 != 1) goto L5;
    L31:
        WeekFields r1 = this.SUNDAY_START;
    L16:
        return r2.get(r1.weekOfYear());
    L5:
        if (r3 == 17) goto L31;
        if (r3 != 2) goto L10;
    L30:
        r1 = this.MONDAY_START;
        goto L16
    L10:
        if (r3 == 11) goto L30;
        if (r3 != 12) goto L18;
        r1 = this.TUESDAY_START;
        goto L16
    L18:
        if (r3 != 13) goto L21;
        r1 = this.WEDNESDAY_START;
        goto L16
    L21:
        if (r3 != 14) goto L24;
        r1 = this.THURSDAY_START;
        goto L16
    L24:
        if (r3 != 15) goto L27;
        r1 = this.FRIDAY_START;
        goto L16
    L27:
        if (r3 != 16) goto L29;
        r1 = this.SATURDAY_START;
        goto L16
    L29:
        r1 = WeekFields.ISO;
        goto L16
    }
}
