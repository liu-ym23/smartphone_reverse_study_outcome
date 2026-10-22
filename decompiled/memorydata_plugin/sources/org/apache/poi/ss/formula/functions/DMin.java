package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DMin implements IDStarAlgorithm {
    private ValueEval minimumValue;

    public DMin() {
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval r0 = this.minimumValue;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return NumberEval.ZERO;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, NumericValueEval.class) == true) goto L5;
        return true;
    L5:
        if (this.minimumValue != null) goto L8;
    L6:
        this.minimumValue = r7;
        return true;
    L8:
        if (((NumericValueEval) ZeusTransformUtils.preCheckCast(r7, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue() < ((NumericValueEval) ZeusTransformUtils.preCheckCast(this.minimumValue, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue()) goto L6;
        return true;
    }
}
