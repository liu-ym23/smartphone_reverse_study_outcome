package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.NumberPtg;

/* JADX INFO: loaded from: classes7.dex */
public final class Areas implements Function {
    public Areas() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r3, int r4, int r5) {
        if (r3.length != 0) goto L14;
        return ErrorEval.VALUE_INVALID;
    L14:
        ValueEval r2 = r3[0];     // Catch: Exception -> L12
        int r6 = 1;
        if (ZeusTransformUtils.instanceOf(r2, RefListEval.class) == false) goto L10;
        r6 = ((RefListEval) ZeusTransformUtils.preCheckCast(r2, RefListEval.class, "com.obric.memorydata.plugin")).getList().size();     // Catch: Exception -> L12
    L10:
        return new NumberEval(new NumberPtg(r6));
    L13:
        return ErrorEval.VALUE_INVALID;
    }
}
