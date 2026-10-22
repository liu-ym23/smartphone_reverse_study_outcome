package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DSum implements IDStarAlgorithm {
    private double totalValue;

    public DSum() {
        this.totalValue = 0.0d;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        return new NumberEval(this.totalValue);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, NumericValueEval.class) == false) goto L7;
        this.totalValue += ((NumericValueEval) ZeusTransformUtils.preCheckCast(r6, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        return true;
    L7:
        return true;
    }
}
