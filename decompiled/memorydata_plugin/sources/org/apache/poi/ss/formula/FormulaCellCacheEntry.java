package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
final class FormulaCellCacheEntry extends CellCacheEntry {
    private CellCacheEntry[] _sensitiveInputCells;
    private FormulaUsedBlankCellSet _usedBlankCellGroup;

    public FormulaCellCacheEntry() {
    }

    private void changeConsumingCells(CellCacheEntry[] r7) {
        CellCacheEntry[] r0 = this._sensitiveInputCells;
        int r1 = r7.length;
        int r2 = r7.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r7[r4].addConsumingCell(this);
        r4 = r4 + 1;
        goto L3
    L5:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length >= 1) goto L10;
        return;
    L10:
        if (r1 >= 1) goto L12;
        Set r8 = Collections.emptySet();
    L13:
        int r5 = r0.length;
    L14:
        if (r3 >= r5) goto L19;
        CellCacheEntry r6 = r0[r3];
        if (r8.contains(r6) == true) goto L18;
        r6.clearConsumingCell(this);
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        return;
    L12:
        HashSet r9 = new HashSet((r1 * 3) / 2);
        r9.addAll(Arrays.asList(r7).subList(0, r1));
        r8 = r9;
        goto L13
    }

    public boolean isInputSensitive() {
        CellCacheEntry[] r0 = this._sensitiveInputCells;
        if (r0 != null) goto L5;
    L7:
        FormulaUsedBlankCellSet r2 = this._usedBlankCellGroup;
        if (r2 != null) goto L11;
    L12:
        return false;
    L11:
        if (r2.isEmpty() == true) goto L12;
        return true;
    L5:
        if (r0.length <= 0) goto L7;
        return true;
    }

    public void setSensitiveInputCells(CellCacheEntry[] r3) {
        if (r3 != null) goto L4;
        this._sensitiveInputCells = null;
        changeConsumingCells(CellCacheEntry.EMPTY_ARRAY);
        return;
    L4:
        CellCacheEntry[] r4 = (CellCacheEntry[]) ZeusTransformUtils.preCheckCast(r3.clone(), CellCacheEntry[].class, "com.obric.memorydata.plugin");
        this._sensitiveInputCells = r4;
        changeConsumingCells(r4);
    }

    public void updateFormulaResult(ValueEval r3, CellCacheEntry[] r4, FormulaUsedBlankCellSet r5) {
        updateValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin"));
        setSensitiveInputCells(r4);
        this._usedBlankCellGroup = r5;
    }
}
