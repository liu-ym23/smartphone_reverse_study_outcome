package org.apache.poi.ss.formula.eval;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.NumberToTextConverter;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberEval implements NumericValueEval, StringValueEval {
    public static final NumberEval ZERO = null;
    private String _stringValue;
    private final double _value;

    static {
        ZERO = new NumberEval(0.0d);
    }

    public NumberEval(double r1) {
        this._value = r1;
    }

    public NumberEval(Ptg r3) {
        if (r3 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r3, IntPtg.class) == false) goto L9;
        double r0 = ((IntPtg) ZeusTransformUtils.preCheckCast(r3, IntPtg.class, "com.obric.memorydata.plugin")).getValue();
    L7:
        this._value = r0;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, NumberPtg.class) == false) goto L13;
        r0 = ((NumberPtg) ZeusTransformUtils.preCheckCast(r3, NumberPtg.class, "com.obric.memorydata.plugin")).getValue();
        goto L7
    L13:
        throw new IllegalArgumentException("bad argument type (" + r3.getClass().getName() + ")");
    L15:
        throw new IllegalArgumentException("ptg must not be null");
    }

    @Override // org.apache.poi.ss.formula.eval.NumericValueEval
    public double getNumberValue() {
        return this._value;
    }

    @Override // org.apache.poi.ss.formula.eval.StringValueEval
    public String getStringValue() {
        if (this._stringValue != null) goto L6;
        this._stringValue = NumberToTextConverter.toText(this._value);
    L6:
        return this._stringValue;
    }

    public final String toString() {
        return getClass().getName() + " [" + getStringValue() + "]";
    }
}
