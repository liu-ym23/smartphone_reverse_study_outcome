package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class TextJoinFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;
    private ArgumentsEvaluator evaluator;

    static {
        instance = new TextJoinFunction(ArgumentsEvaluator.instance);
    }

    private TextJoinFunction(ArgumentsEvaluator r1) {
        this.evaluator = r1;
    }

    private List<ValueEval> getValues(ValueEval r2, int r3, int r4, boolean r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AreaEval.class) == false) goto L17;
        AreaEval r6 = (AreaEval) ZeusTransformUtils.preCheckCast(r1, AreaEval.class, "com.obric.memorydata.plugin");
        ArrayList r7 = new ArrayList();
        if (r5 == false) goto L7;
        int r8 = r6.getLastRow();
    L9:
        if (r8 > r6.getLastRow()) goto L15;
        int r9 = r6.getFirstColumn();
    L12:
        if (r9 > r6.getLastColumn()) goto L14;
        r7.add(OperandResolver.getSingleValue(r6.getAbsoluteValue(r8, r9), r8, r9));
        r9 = r9 + 1;
        goto L12
    L14:
        r8 = r8 + 1;
        goto L9
    L15:
        return r7;
    L7:
        r8 = r6.getFirstRow();
        goto L9
    L17:
        return Collections.singletonList(OperandResolver.getSingleValue(r1, r3, r4));
    }

    private String laxValueToString(ValueEval r2) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MissingArgEval.class) == false) goto L6;
        return "";
    L6:
        return OperandResolver.coerceValueToString(r1);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r12, OperationEvaluationContext r13) {
        if (r12.length < 3) goto L46;
        if (r12.length > 254) goto L46;
        int r0 = r13.getRowIndex();
        int r14 = r13.getColumnIndex();
        int r1 = 0;
        List<ValueEval> r2 = getValues(r12[0], r0, r14, true);     // Catch: EvaluationException -> L42
        boolean r4 = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(r12[1], r0, r14), false).booleanValue();     // Catch: EvaluationException -> L42
        ArrayList r5 = new ArrayList();     // Catch: EvaluationException -> L42
        int r6 = 2;
    L11:
        if (r6 >= r12.length) goto L23;
        Iterator<ValueEval> r7 = getValues(r12[r6], r0, r14, false).iterator();     // Catch: EvaluationException -> L42
    L14:
        if (r7.hasNext() == false) goto L21;
        String r9 = OperandResolver.coerceValueToString((ValueEval) ZeusTransformUtils.preCheckCast(r7.next(), ValueEval.class, "com.obric.memorydata.plugin"));     // Catch: EvaluationException -> L42
        if (r4 == false) goto L20;
        if (r9 == null) goto L14;
        if (r9.length() <= 0) goto L14;
    L20:
        r5.add(r9);     // Catch: EvaluationException -> L42
        goto L14
    L21:
        r6 = r6 + 1;     // Catch: EvaluationException -> L42
        goto L11
    L23:
        if (r2.isEmpty() == false) goto L27;
        return new StringEval(String.join("", r5));
    L27:
        if (r2.size() == 1) goto L29;
        ArrayList r15 = new ArrayList();     // Catch: EvaluationException -> L42
        Iterator<ValueEval> r16 = r2.iterator();     // Catch: EvaluationException -> L42
    L32:
        if (r16.hasNext() == false) goto L34;
        r15.add(laxValueToString((ValueEval) ZeusTransformUtils.preCheckCast(r16.next(), ValueEval.class, "com.obric.memorydata.plugin")));     // Catch: EvaluationException -> L42
        goto L32
    L34:
        StringBuilder r11 = new StringBuilder();     // Catch: EvaluationException -> L42
    L36:
        if (r1 >= r5.size()) goto L41;
        if (r1 <= 0) goto L39;
        r11.append((String) ZeusTransformUtils.preCheckCast(r15.get((r1 - 1) % r15.size()), String.class, "com.obric.memorydata.plugin"));     // Catch: EvaluationException -> L42
    L39:
        r11.append((String) ZeusTransformUtils.preCheckCast(r5.get(r1), String.class, "com.obric.memorydata.plugin"));     // Catch: EvaluationException -> L42
        r1 = r1 + 1;     // Catch: EvaluationException -> L42
        goto L36
    L41:
        return new StringEval(r11.toString());
    L29:
        return new StringEval(String.join(laxValueToString((ValueEval) ZeusTransformUtils.preCheckCast(r2.get(0), ValueEval.class, "com.obric.memorydata.plugin")), r5));
    L42:
        e = move-exception;
        return e.getErrorEval();
    L46:
        return ErrorEval.VALUE_INVALID;
    }
}
