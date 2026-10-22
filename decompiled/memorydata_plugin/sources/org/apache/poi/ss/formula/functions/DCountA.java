package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DCountA implements IDStarAlgorithm {
    private long count;

    public DCountA() {
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean allowEmptyMatchField() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        return new NumberEval(this.count);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r5) {
        if (ZeusTransformUtils.instanceOf((ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin"), BlankEval.class) == true) goto L7;
        this.count++;
        return true;
    L7:
        return true;
    }
}
