package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Rept extends Fixed2ArgFunction {
    public Rept() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r2, int r3, ValueEval r4, ValueEval r5) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        String r7 = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(r1, r2, r3));
        int r8 = (int) OperandResolver.coerceValueToDouble(r6);
        StringBuilder r9 = new StringBuilder(r7.length() * r8);
        int r10 = 0;
    L7:
        if (r10 >= r8) goto L10;
        r9.append(r7);
        r10 = r10 + 1;
        goto L7
    L10:
        if (r9.toString().length() <= 32767) goto L14;
        return ErrorEval.VALUE_INVALID;
    L14:
        return new StringEval(r9.toString());
    L16:
        return ErrorEval.VALUE_INVALID;
    L17:
        e = move-exception;
        return e.getErrorEval();
    }
}
