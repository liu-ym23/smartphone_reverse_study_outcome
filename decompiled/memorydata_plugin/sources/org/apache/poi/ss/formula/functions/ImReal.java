package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class ImReal extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new ImReal();
    }

    public ImReal() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        Matcher r1 = Imaginary.COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3)));
        if (r1.matches() == true) goto L9;
        return ErrorEval.NUM_ERROR;
    L9:
        if (r1.group(2).isEmpty() == true) goto L11;
        String r5 = r1.group(1);
        String r6 = r1.group(2);
        if (Marker.ANY_NON_NULL_MARKER.equals(r5) == false) goto L16;
        r5 = "";
    L16:
        if (r6.isEmpty() == false) goto L19;
        r6 = "1";
    L19:
        return new StringEval(r5 + r6);
    L11:
        return new StringEval("0");
    L20:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    }
}
