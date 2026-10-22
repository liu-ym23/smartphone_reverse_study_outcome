package org.apache.poi.ss.formula.functions;

import com.loc.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class Complex extends Var2or3ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Complex();
    }

    public Complex() {
    }

    private boolean isDoubleAnInt(double r3) {
        if (r3 == Math.floor(r3)) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(r3) == true) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r9, int r10, ValueEval r11, ValueEval r12) {
        return evaluate(r9, r10, (ValueEval) ZeusTransformUtils.wrapperContextForParams(r11, ValueEval.class, "com.obric.memorydata.plugin"), (ValueEval) ZeusTransformUtils.wrapperContextForParams(r12, ValueEval.class, "com.obric.memorydata.plugin"), new StringEval("i"));
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r5, int r6, ValueEval r7, ValueEval r8, ValueEval r9) {
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r12 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        double r0 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r10, r5, r6));     // Catch: EvaluationException -> L51
        double r13 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r11, r5, r6));     // Catch: EvaluationException -> L46
        String r14 = OperandResolver.coerceValueToString(r12);
        if (r14.length() != 0) goto L11;
        r14 = "i";
    L11:
        if (r14.equals("i".toUpperCase(Locale.ROOT)) == true) goto L45;
        if (r14.equals(o.j.toUpperCase(Locale.ROOT)) == true) goto L45;
        if (r14.equals("i") == false) goto L18;
    L21:
        StringBuilder r15 = new StringBuilder();
        if (r0 == 0.0d) goto L28;
        if (isDoubleAnInt(r0) == false) goto L26;
        r15.append((int) r0);
        goto L28
    L26:
        r15.append(r0);
    L28:
        if (r13 == 0.0d) goto L43;
        if (r15.length() == 0) goto L34;
        if (r13 <= 0.0d) goto L34;
        r15.append(Marker.ANY_NON_NULL_MARKER);
    L34:
        if (r13 != 1.0d) goto L36;
    L41:
        r15.append(r14);
        goto L43
    L36:
        if (r13 == (-1.0d)) goto L41;
        if (isDoubleAnInt(r13) == false) goto L40;
        r15.append((int) r13);
        goto L41
    L40:
        r15.append(r13);
    L43:
        return new StringEval(r15.toString());
    L18:
        if (r14.equals(o.j) == true) goto L21;
        return ErrorEval.VALUE_INVALID;
    L45:
        return ErrorEval.VALUE_INVALID;
    L47:
        return ErrorEval.VALUE_INVALID;
    L48:
        e = move-exception;
        return e.getErrorEval();
    L52:
        return ErrorEval.VALUE_INVALID;
    L53:
        e = move-exception;
        return e.getErrorEval();
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r12, OperationEvaluationContext r13) {
        if (r12.length != 2) goto L7;
        return evaluate(r13.getRowIndex(), r13.getColumnIndex(), r12[0], r12[1]);
    L7:
        if (r12.length != 3) goto L11;
        return evaluate(r13.getRowIndex(), r13.getColumnIndex(), r12[0], r12[1], r12[2]);
    L11:
        return ErrorEval.VALUE_INVALID;
    }
}
