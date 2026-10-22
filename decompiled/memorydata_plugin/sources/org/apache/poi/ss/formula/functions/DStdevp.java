package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: classes7.dex */
public final class DStdevp implements IDStarAlgorithm {
    private final ArrayList<NumericValueEval> values;

    public DStdevp() {
        this.values = new ArrayList();
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        double[] r0 = new double[this.values.size()];
        Iterator<NumericValueEval> r6 = this.values.iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L7;
        r0[r1] = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r6.next(), NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        r1 = r1 + 1;
        goto L4
    L7:
        return new NumberEval(new BigDecimal(NumberToTextConverter.toText(StatsLib.stdevp(r0))).doubleValue());
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == false) goto L7;
        this.values.add((NumericValueEval) ZeusTransformUtils.preCheckCast(r4, NumericValueEval.class, "com.obric.memorydata.plugin"));
        return true;
    L7:
        return true;
    }
}
