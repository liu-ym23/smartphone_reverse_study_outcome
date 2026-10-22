package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class EvaluationCache {
    final IEvaluationListener _evaluationListener;
    private final FormulaCellCache _formulaCellCache;
    private final PlainCellCache _plainCellCache;

    private boolean areValuesEqual(ValueEval r5, ValueEval r6) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return false;
    L5:
        Class<?> r1 = r4.getClass();
        if (r1 == r7.getClass()) goto L9;
        return false;
    L9:
        if (r4 != BlankEval.instance) goto L14;
        if (r7 == r4) goto L12;
        return false;
    L12:
        return true;
    L14:
        if (r1 != NumberEval.class) goto L20;
        if (((NumberEval) ZeusTransformUtils.preCheckCast(r4, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue() == ((NumberEval) ZeusTransformUtils.preCheckCast(r7, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue()) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (r1 != StringEval.class) goto L24;
        return ((StringEval) ZeusTransformUtils.preCheckCast(r4, StringEval.class, "com.obric.memorydata.plugin")).getStringValue().equals(((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
    L24:
        if (r1 != BoolEval.class) goto L30;
        if (((BoolEval) ZeusTransformUtils.preCheckCast(r4, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue() == ((BoolEval) ZeusTransformUtils.preCheckCast(r7, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue()) goto L28;
        return false;
    L28:
        return true;
    L30:
        if (r1 != ErrorEval.class) goto L36;
        if (((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode() == ((ErrorEval) ZeusTransformUtils.preCheckCast(r7, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode()) goto L34;
        return false;
    L34:
        return true;
    L36:
        throw new IllegalStateException("Unexpected value class (" + r1.getName() + ")");
    }

    public FormulaCellCacheEntry getOrCreateFormulaCellEntry(EvaluationCell r3) {
        EvaluationCell r4 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationCell.class, "com.obric.memorydata.plugin");
        FormulaCellCacheEntry r0 = this._formulaCellCache.get(r4);
        if (r0 != null) goto L6;
        FormulaCellCacheEntry r1 = new FormulaCellCacheEntry();
        this._formulaCellCache.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    public PlainValueCellCacheEntry getPlainValueEntry(int r3, int r4, int r5, int r6, ValueEval r7) {
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        PlainCellCache.Loc r0 = new PlainCellCache.Loc(r3, r4, r5, r6);
        PlainValueCellCacheEntry r9 = this._plainCellCache.get(r0);
        if (r9 != null) goto L8;
        r9 = new PlainValueCellCacheEntry(r8);
        this._plainCellCache.put(r0, r9);
        IEvaluationListener r2 = this._evaluationListener;
        if (r2 == null) goto L12;
        r2.onReadPlainValue(r4, r5, r6, r9);
    L12:
        return r9;
    L8:
        if (areValuesEqual(r9.getValue(), r8) == false) goto L14;
        IEvaluationListener r10 = this._evaluationListener;
        if (r10 == null) goto L12;
        r10.onCacheHit(r4, r5, r6, r8);
        goto L12
    L14:
        throw new IllegalStateException("value changed");
    }
}
