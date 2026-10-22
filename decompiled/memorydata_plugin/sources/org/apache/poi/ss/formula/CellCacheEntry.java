package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
abstract class CellCacheEntry implements IEvaluationListener.ICacheEntry {
    public static final CellCacheEntry[] EMPTY_ARRAY = null;
    private final FormulaCellCacheEntrySet _consumingCells;
    private ValueEval _value;

    static {
        EMPTY_ARRAY = new CellCacheEntry[0];
    }

    public CellCacheEntry() {
        this._consumingCells = new FormulaCellCacheEntrySet();
    }

    private static boolean areValuesEqual(ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return false;
    L5:
        Class<?> r2 = r7.getClass();
        if (r2 == r8.getClass()) goto L9;
        return false;
    L9:
        if (r7 != BlankEval.instance) goto L14;
        if (r8 == r7) goto L12;
        return false;
    L12:
        return true;
    L14:
        if (r2 != NumberEval.class) goto L20;
        if (((NumberEval) ZeusTransformUtils.preCheckCast(r7, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue() == ((NumberEval) ZeusTransformUtils.preCheckCast(r8, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue()) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (r2 != StringEval.class) goto L24;
        return ((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue().equals(((StringEval) ZeusTransformUtils.preCheckCast(r8, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
    L24:
        if (r2 != BoolEval.class) goto L30;
        if (((BoolEval) ZeusTransformUtils.preCheckCast(r7, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue() == ((BoolEval) ZeusTransformUtils.preCheckCast(r8, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue()) goto L28;
        return false;
    L28:
        return true;
    L30:
        if (r2 != ErrorEval.class) goto L36;
        if (((ErrorEval) ZeusTransformUtils.preCheckCast(r7, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode() == ((ErrorEval) ZeusTransformUtils.preCheckCast(r8, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode()) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new IllegalStateException("Unexpected value class (" + r2.getName() + ")");
    }

    public final void addConsumingCell(FormulaCellCacheEntry r1) {
        this._consumingCells.add(r1);
    }

    public final void clearConsumingCell(FormulaCellCacheEntry r1) {
        if (this._consumingCells.remove(r1) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Specified formula cell is not consumed by this cell");
    }

    public final ValueEval getValue() {
        return this._value;
    }

    public final boolean updateValue(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        boolean r0 = !areValuesEqual(this._value, r4);
        this._value = r4;
        return r0;
    L7:
        throw new IllegalArgumentException("Did not expect to update to null");
    }
}
