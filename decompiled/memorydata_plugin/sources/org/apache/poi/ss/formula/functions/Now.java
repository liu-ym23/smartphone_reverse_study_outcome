package org.apache.poi.ss.formula.functions;

import java.util.Date;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class Now {
    public static ValueEval evaluate(ValueEval[] r2, int r3, int r4) {
        if (r2.length == 0) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return new NumberEval(DateUtil.getExcelDate(new Date(System.currentTimeMillis())));
    }
}
