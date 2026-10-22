package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Rows extends Fixed1ArgFunction {
    public Rows() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, TwoDEval.class) == false) goto L6;
        int r4 = ((TwoDEval) ZeusTransformUtils.preCheckCast(r0, TwoDEval.class, "com.obric.memorydata.plugin")).getHeight();
    L9:
        return new NumberEval(r4);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, RefEval.class) == false) goto L11;
        r4 = 1;
        goto L9
    L11:
        return ErrorEval.VALUE_INVALID;
    }
}
