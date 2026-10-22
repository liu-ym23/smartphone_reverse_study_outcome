package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DGet implements IDStarAlgorithm {
    private ValueEval result;

    public DGet() {
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval r0 = this.result;
        if (r0 != null) goto L7;
        return ErrorEval.VALUE_INVALID;
    L7:
        if (ZeusTransformUtils.instanceOf(r0, BlankEval.class) == true) goto L9;
    L16:
        e = move-exception;
        return e.getErrorEval();
    L11:
        if (OperandResolver.coerceValueToString(OperandResolver.getSingleValue(this.result, 0, 0)).isEmpty() == false) goto L15;
        return ErrorEval.VALUE_INVALID;
    L15:
        return this.result;
    L9:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r0 = this.result;
        if (r0 != null) goto L6;
    L4:
        this.result = r4;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, BlankEval.class) == true) goto L4;
        if (ZeusTransformUtils.instanceOf(r4, BlankEval.class) == true) goto L14;
        this.result = ErrorEval.NUM_ERROR;
        return false;
    L14:
        return true;
    }
}
