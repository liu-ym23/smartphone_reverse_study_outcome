package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.poi.ss.formula.LazyRefEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Subtotal implements Function {
    public Subtotal() {
    }

    private static Function findFunction(int r1) {
        boolean r0 = true;
        switch(r1) {
            case 1: goto L22;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L8;
            default: goto L4;
        };
    L4:
        r0 = false;
        switch(r1) {
            case 101: goto L22;
            case 102: goto L21;
            case 103: goto L19;
            case 104: goto L17;
            case 105: goto L16;
            case 106: goto L15;
            case 107: goto L14;
            case 108: goto L13;
            case 109: goto L12;
            case 110: goto L11;
            case 111: goto L8;
            default: goto L7;
        };
    L7:
        throw EvaluationException.invalidValue();
    L19:
        return Counta.subtotalInstance(false);
    L21:
        return Count.subtotalInstance(false);
    L8:
        Function r2 = AggregateFunction.VARP;
    L10:
        return AggregateFunction.subtotalInstance(r2, r0);
    L11:
        r2 = AggregateFunction.VAR;
    L12:
        r2 = AggregateFunction.SUM;
    L13:
        r2 = AggregateFunction.STDEVP;
    L14:
        r2 = AggregateFunction.STDEV;
    L15:
        r2 = AggregateFunction.PRODUCT;
    L16:
        r2 = AggregateFunction.MIN;
    L17:
        r2 = AggregateFunction.MAX;
    L22:
        r2 = AggregateFunction.AVERAGE;
        goto L10
    L24:
        return Counta.subtotalInstance(true);
    L26:
        return Count.subtotalInstance(true);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r7, int r8, int r9) {
        if ((r7.length - 1) >= 1) goto L26;
        return ErrorEval.VALUE_INVALID;
    L26:
        int r1 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(r7[0], r8, r9));     // Catch: EvaluationException -> L23
        Function r2 = findFunction(r1);     // Catch: EvaluationException -> L23
        ArrayList r3 = new ArrayList(Arrays.asList(r7).subList(1, r7.length));
        Iterator r10 = r3.iterator();
    L10:
        if (r10.hasNext() == false) goto L22;
        ValueEval r0 = (ValueEval) ZeusTransformUtils.preCheckCast(r10.next(), ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, LazyRefEval.class) == false) goto L10;
        LazyRefEval r4 = (LazyRefEval) ZeusTransformUtils.preCheckCast(r0, LazyRefEval.class, "com.obric.memorydata.plugin");
        if (r4.isSubTotal() == false) goto L17;
        r10.remove();
    L17:
        if (r1 <= 100) goto L10;
        if (r4.isRowHidden() == false) goto L10;
        r10.remove();
        goto L10
    L22:
        return r2.evaluate((ValueEval[]) ZeusTransformUtils.preCheckCast(r3.toArray(new ValueEval[0]), ValueEval[].class, "com.obric.memorydata.plugin"), r8, r9);
    L23:
        e = move-exception;
        return e.getErrorEval();
    }
}
