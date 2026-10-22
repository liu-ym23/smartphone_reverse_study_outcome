package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public final class DAverage implements IDStarAlgorithm {
    private long count;
    private double total;

    public DAverage() {
    }

    private static double divide(double r0, long r2) {
        return BigDecimal.valueOf(r0).divide(BigDecimal.valueOf(r2), MathContext.DECIMAL128).doubleValue();
    }

    private double getAverage() {
        return divide(this.total, this.count);
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        if (this.count != 0) goto L6;
        return NumberEval.ZERO;
    L6:
        return new NumberEval(getAverage());
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r7) {
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, NumericValueEval.class) == false) goto L7;
        this.count++;
        this.total += ((NumericValueEval) ZeusTransformUtils.preCheckCast(r8, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        return true;
    L7:
        return true;
    }
}
