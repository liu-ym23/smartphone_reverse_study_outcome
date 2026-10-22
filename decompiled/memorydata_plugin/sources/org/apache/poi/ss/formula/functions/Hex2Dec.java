package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public class Hex2Dec extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Hex2Dec();
    }

    public Hex2Dec() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int r1, int r2, ValueEval r3) {
        ValueEval r0 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, RefEval.class) == false) goto L10;
        RefEval r4 = (RefEval) ZeusTransformUtils.preCheckCast(r0, RefEval.class, "com.obric.memorydata.plugin");
        r0 = r4.getInnerValueEval(r4.getFirstSheetIndex());
    L10:
        return new NumberEval(BaseNumberUtils.convertToDecimal(OperandResolver.coerceValueToString(r0), 16, 10));
    L9:
        return ErrorEval.NUM_ERROR;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r3, OperationEvaluationContext r4) {
        if (r3.length == 1) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        return evaluate(r4.getRowIndex(), r4.getColumnIndex(), r3[0]);
    }
}
