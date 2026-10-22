package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
final class Ifs implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Ifs();
    }

    private Ifs() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if ((r3.length % 2) != 0) goto L5;
        int r2 = 0;
    L8:
        if (r2 >= r3.length) goto L15;
        if (((BoolEval) ZeusTransformUtils.preCheckCast(r3[r2], BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue() == true) goto L12;
        r2 = r2 + 2;
        goto L8
    L12:
        return r3[r2 + 1];
    L15:
        return ErrorEval.NA;
    L5:
        return ErrorEval.VALUE_INVALID;
    }
}
