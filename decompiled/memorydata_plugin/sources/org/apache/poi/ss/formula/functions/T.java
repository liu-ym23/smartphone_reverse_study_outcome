package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class T extends Fixed1ArgFunction {
    public T() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, RefEval.class) == false) goto L6;
        RefEval r4 = (RefEval) ZeusTransformUtils.preCheckCast(r0, RefEval.class, "com.obric.memorydata.plugin");
        r0 = r4.getInnerValueEval(r4.getFirstSheetIndex());
    L9:
        if (ZeusTransformUtils.instanceOf(r0, StringEval.class) == false) goto L12;
        return r0;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, ErrorEval.class) == false) goto L15;
        return r0;
    L15:
        return StringEval.EMPTY_INSTANCE;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, AreaEval.class) == false) goto L9;
        r0 = ((AreaEval) ZeusTransformUtils.preCheckCast(r0, AreaEval.class, "com.obric.memorydata.plugin")).getRelativeValue(0, 0);
        goto L9
    }
}
