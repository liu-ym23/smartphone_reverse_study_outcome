package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class CacheAreaEval extends AreaEvalBase {
    private final ValueEval[] _values;

    public CacheAreaEval(int r1, int r2, int r3, int r4, ValueEval[] r5) {
        super(r1, r2, r3, r4);
        this._values = r5;
    }

    public CacheAreaEval(AreaI r3, ValueEval[] r4) {
        super((AreaI) ZeusTransformUtils.wrapperContextForParams(r3, AreaI.class, "com.obric.memorydata.plugin"));
        this._values = r4;
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public TwoDEval getColumn(int r8) {
        if (r8 >= getWidth()) goto L10;
        int r5 = getFirstColumn() + r8;
        int r0 = getHeight();
        ValueEval[] r6 = new ValueEval[r0];
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        r6[r1] = getRelativeValue(r1, r8);
        r1 = r1 + 1;
        goto L5
    L8:
        return new CacheAreaEval(getFirstRow(), r5, getLastRow(), r5, r6);
    L10:
        throw new IllegalArgumentException("Invalid columnIndex " + r8 + ".  Allowable range is (0.." + getWidth() + ").");
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int r2, int r3) {
        return getRelativeValue(-1, r2, r3);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int r1, int r2, int r3) {
        int r4 = (r2 * getWidth()) + r3;
        return this._values[r4];
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public TwoDEval getRow(int r8) {
        if (r8 >= getHeight()) goto L10;
        int r4 = getFirstRow() + r8;
        int r0 = getWidth();
        ValueEval[] r6 = new ValueEval[r0];
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L8;
        r6[r1] = getRelativeValue(r8, r1);
        r1 = r1 + 1;
        goto L5
    L8:
        return new CacheAreaEval(r4, getFirstColumn(), r4, getLastColumn(), r6);
    L10:
        throw new IllegalArgumentException("Invalid rowIndex " + r8 + ".  Allowable range is (0.." + getHeight() + ").");
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int r10, int r11, int r12, int r13) {
        AreaI.OffsetArea r7 = new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), r10, r11, r12, r13);
        int r14 = (r7.getLastRow() - r7.getFirstRow()) + 1;
        int r15 = (r7.getLastColumn() - r7.getFirstColumn()) + 1;
        ValueEval[] r16 = new ValueEval[r14 * r15];
        int r17 = r7.getFirstRow() - getFirstRow();
        int r0 = r7.getFirstColumn() - getFirstColumn();
        int r2 = 0;
    L3:
        if (r2 >= r14) goto L16;
        int r3 = 0;
    L5:
        if (r3 >= r15) goto L14;
        int r4 = r17 + r2;
        if (r4 > getLastRow()) goto L12;
        int r5 = r0 + r3;
        if (r5 > getLastColumn()) goto L12;
        ValueEval r6 = this._values[(r4 * getWidth()) + r5];
    L13:
        r16[(r2 * r15) + r3] = r6;
        r3 = r3 + 1;
    L12:
        r6 = BlankEval.instance;
        goto L13
    L14:
        r2 = r2 + 1;
        goto L3
    L16:
        return new CacheAreaEval(r7, r16);
    }

    public String toString() {
        return getClass().getName() + "[" + new CellReference(getFirstRow(), getFirstColumn()).formatAsString() + ':' + new CellReference(getLastRow(), getLastColumn()).formatAsString() + "]";
    }
}
