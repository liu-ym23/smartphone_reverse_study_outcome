package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class EvaluationTracker {
    private final EvaluationCache _cache;
    private final Set<FormulaCellCacheEntry> _currentlyEvaluatingCells;
    private final List<CellEvaluationFrame> _evaluationFrames;

    public EvaluationTracker(EvaluationCache r1) {
        this._cache = r1;
        this._evaluationFrames = new ArrayList();
        this._currentlyEvaluatingCells = new HashSet();
    }

    public void acceptFormulaDependency(CellCacheEntry r3) {
        int r0 = this._evaluationFrames.size() - 1;
        if (r0 < 0) goto L7;
        ((CellEvaluationFrame) ZeusTransformUtils.preCheckCast(this._evaluationFrames.get(r0), CellEvaluationFrame.class, "com.obric.memorydata.plugin")).addSensitiveInputCell(r3);
        return;
    }

    public void acceptPlainValueDependency(EvaluationWorkbook r12, int r13, int r14, int r15, int r16, ValueEval r17) {
        EvaluationWorkbook r4 = (EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r12, EvaluationWorkbook.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r17, ValueEval.class, "com.obric.memorydata.plugin");
        int r1 = this._evaluationFrames.size() - 1;
        if (r1 < 0) goto L11;
        CellEvaluationFrame r3 = (CellEvaluationFrame) ZeusTransformUtils.preCheckCast(this._evaluationFrames.get(r1), CellEvaluationFrame.class, "com.obric.memorydata.plugin");
        if (r10 != BlankEval.instance) goto L8;
        r3.addUsedBlankCell(r4, r13, r14, r15, r16);
        return;
    L8:
        r3.addSensitiveInputCell(this._cache.getPlainValueEntry(r13, r14, r15, r16, r10));
        return;
    }

    public void endEvaluate(CellCacheEntry r5) {
        int r0 = this._evaluationFrames.size();
        if (r0 < 1) goto L11;
        int r1 = r0 - 1;
        if (r5 != ((CellEvaluationFrame) ZeusTransformUtils.preCheckCast(this._evaluationFrames.get(r1), CellEvaluationFrame.class, "com.obric.memorydata.plugin")).getCCE()) goto L9;
        this._evaluationFrames.remove(r1);
        this._currentlyEvaluatingCells.remove(r5);
        return;
    L9:
        throw new IllegalStateException("Wrong cell specified. ");
    L11:
        throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
    }

    public boolean startEvaluate(FormulaCellCacheEntry r2) {
        if (r2 == null) goto L10;
        if (this._currentlyEvaluatingCells.contains(r2) == false) goto L7;
        return false;
    L7:
        this._currentlyEvaluatingCells.add(r2);
        this._evaluationFrames.add(new CellEvaluationFrame(r2));
        return true;
    L10:
        throw new IllegalArgumentException("cellLoc must not be null");
    }

    public void updateCacheResult(ValueEval r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        int r0 = this._evaluationFrames.size();
        if (r0 < 1) goto L11;
        CellEvaluationFrame r4 = (CellEvaluationFrame) ZeusTransformUtils.preCheckCast(this._evaluationFrames.get(r0 - 1), CellEvaluationFrame.class, "com.obric.memorydata.plugin");
        if (r6 != ErrorEval.CIRCULAR_REF_ERROR) goto L8;
        if (r0 <= 1) goto L8;
        return;
    L8:
        r4.updateFormulaResult(r6);
        return;
    L11:
        throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
    }
}
