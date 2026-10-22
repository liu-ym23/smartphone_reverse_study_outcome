package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DateTimeException;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.DateParser;

/* JADX INFO: loaded from: classes7.dex */
public class TimeValue extends Fixed1ArgFunction {
    private static final c LOG = null;

    static {
        LOG = b.a(TimeValue.class);
    }

    public TimeValue() {
    }

    private NumberEval parseTimeFromDateTime(String r5) {
        return new NumberEval(DateUtil.parseDateTime(r5).doubleValue() - DateUtil.getExcelDate(DateParser.parseLocalDate(r5)));
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5) {
        String r6 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: EvaluationException -> L16 DateTimeException -> L19
        if (r6 == null) goto L15;
        if (r6.isEmpty() == true) goto L15;
        return parseTimeFromDateTime(r6);
    L10:
        return parseTimeFromDateTime("1/01/2000 " + r6);
    L12:
        DateParser.parseLocalDate(r6);     // Catch: EvaluationException -> L16 DateTimeException -> L19
        return new NumberEval(0.0d);
    L15:
        return BlankEval.instance;
    L19:
        e = move-exception;
        LOG.atInfo().a("Failed to parse date/time", e);
        return ErrorEval.VALUE_INVALID;
    L16:
        e = move-exception;
        return e.getErrorEval();
    }
}
