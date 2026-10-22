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
public class DateValue extends Fixed1ArgFunction {
    private static final c LOG = null;

    static {
        LOG = b.a(DateValue.class);
    }

    public DateValue() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        String r1 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3));     // Catch: EvaluationException -> L12 DateTimeException -> L15
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        return new NumberEval(DateUtil.getExcelDate(DateParser.parseLocalDate(r1)));
    L11:
        return BlankEval.instance;
    L15:
        e = move-exception;
        LOG.atInfo().a("Failed to parse date", e);
        return ErrorEval.VALUE_INVALID;
    L12:
        e = move-exception;
        return e.getErrorEval();
    }
}
