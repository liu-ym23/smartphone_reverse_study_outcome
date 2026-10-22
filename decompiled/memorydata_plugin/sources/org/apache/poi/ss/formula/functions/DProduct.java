package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DProduct implements IDStarAlgorithm {
    private boolean initDone;
    private double product;

    public DProduct() {
        this.initDone = false;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        return new NumberEval(this.product);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, NumericValueEval.class) == true) goto L5;
    L8:
        return true;
    L5:
        if (this.initDone == false) goto L7;
        this.product *= ((NumericValueEval) ZeusTransformUtils.preCheckCast(r7, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        goto L8
    L7:
        this.product = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r7, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        this.initDone = true;
        goto L8
    }
}
