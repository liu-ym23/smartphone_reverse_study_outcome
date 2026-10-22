package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RelationalOperationEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* JADX INFO: loaded from: classes7.dex */
public final class Switch implements FreeRefFunction {
    public static final FreeRefFunction instance = null;

    static {
        instance = new Switch();
    }

    private Switch() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] r9, OperationEvaluationContext r10) {
        if (r9.length >= 3) goto L26;
        return ErrorEval.NA;
    L26:
        ValueEval r0 = OperandResolver.getSingleValue(r9[0], r10.getRowIndex(), r10.getColumnIndex());     // Catch: Exception -> L24
        int r2 = 1;
    L10:
        if (r2 >= r9.length) goto L23;
        ValueEval r3 = OperandResolver.getSingleValue(r9[r2], r10.getRowIndex(), r10.getColumnIndex());     // Catch: EvaluationException -> L20
        ValueEval r4 = r9[r2 + 1];     // Catch: EvaluationException -> L20
        ValueEval r5 = RelationalOperationEval.EqualEval.evaluate(new ValueEval[]{r0, r3}, r10.getRowIndex(), r10.getColumnIndex());     // Catch: EvaluationException -> L20
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == false) goto L16;
        if (((BoolEval) ZeusTransformUtils.preCheckCast(r5, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue() == false) goto L16;
        return r4;
    L16:
        r2 = r2 + 2;
        if (r2 != (r9.length - 1)) goto L10;
        return r9[r9.length - 1];
    L21:
        return ErrorEval.NA;
    L23:
        return ErrorEval.NA;
    L25:
        return ErrorEval.NA;
    }
}
