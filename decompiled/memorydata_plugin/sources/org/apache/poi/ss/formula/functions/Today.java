package org.apache.poi.ss.formula.functions;

import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class Today {
    public static ValueEval evaluate(ValueEval[] r2, int r3, int r4) {
        if (r2.length != 0) goto L5;
        Calendar r5 = LocaleUtil.getLocaleCalendar();
        r5.clear(10);
        r5.set(11, 0);
        r5.clear(12);
        r5.clear(13);
        r5.clear(14);
        return new NumberEval(DateUtil.getExcelDate(r5.getTime()));
    L5:
        return ErrorEval.VALUE_INVALID;
    }
}
