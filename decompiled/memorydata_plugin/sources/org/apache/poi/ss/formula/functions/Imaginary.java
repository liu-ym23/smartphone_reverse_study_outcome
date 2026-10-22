package org.apache.poi.ss.formula.functions;

import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class Imaginary extends Fixed1ArgFunction implements FreeRefFunction {
    public static final Pattern COMPLEX_NUMBER_PATTERN = null;
    public static final FreeRefFunction instance = null;

    static {
        instance = new Imaginary();
        COMPLEX_NUMBER_PATTERN = Pattern.compile("([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([+-]?)([0-9]+\\.[0-9]+|[0-9]*)([ij]?)");
    }

    public Imaginary() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4) {
        Matcher r1 = COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin"), r2, r3)));
        if (r1.matches() == false) goto L32;
        String r5 = r1.group(5);
        if (r5.equals("i") == false) goto L9;
    L12:
        boolean r6 = true;
    L14:
        if (r5.length() == 0) goto L16;
        String r7 = "";
        if (r6 == false) goto L30;
        String r8 = r1.group(3);
        if (r8.length() != 0) goto L22;
    L24:
        String r9 = r1.group(4);
        if (r9.length() == 0) goto L27;
        StringBuilder r10 = new StringBuilder().append(r7).append(r9);
    L28:
        r7 = r10.toString();
        goto L30
    L27:
        r10 = new StringBuilder().append(r7).append("1");
        goto L28
    L22:
        if (r8.equals(Marker.ANY_NON_NULL_MARKER) == true) goto L24;
        r7 = r8;
    L30:
        return new StringEval(r7);
    L16:
        return new StringEval(String.valueOf(0));
    L9:
        if (r5.equals(o.j) == true) goto L12;
        r6 = false;
        goto L14
    L32:
        return ErrorEval.NUM_ERROR;
    L33:
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
