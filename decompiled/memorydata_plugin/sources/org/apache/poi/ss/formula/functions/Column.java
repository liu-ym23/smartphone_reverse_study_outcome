package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class Column {
    public static ValueEval evaluate(ValueEval[] r2, int r3, int r4) {
        if (r2.length <= 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        if (r2.length == 0) goto L16;
        if (ZeusTransformUtils.instanceOf(r2[0], AreaEval.class) == false) goto L13;
        r4 = ((AreaEval) ZeusTransformUtils.preCheckCast(r2[0], AreaEval.class, "com.obric.memorydata.plugin")).getFirstColumn();
        goto L16
    L13:
        if (ZeusTransformUtils.instanceOf(r2[0], RefEval.class) == false) goto L18;
        r4 = ((RefEval) ZeusTransformUtils.preCheckCast(r2[0], RefEval.class, "com.obric.memorydata.plugin")).getColumn();
        goto L16
    L18:
        return ErrorEval.VALUE_INVALID;
    L16:
        return new NumberEval(((double) r4) + 1.0d);
    }
}
