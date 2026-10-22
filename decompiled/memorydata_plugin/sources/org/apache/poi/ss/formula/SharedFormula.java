package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* JADX INFO: loaded from: classes7.dex */
public class SharedFormula {
    private final int _columnWrappingMask;
    private final int _rowWrappingMask;

    public SharedFormula(SpreadsheetVersion r2) {
        this._columnWrappingMask = r2.getLastColumnIndex();
        this._rowWrappingMask = r2.getLastRowIndex();
    }

    private int fixupRelativeColumn(int r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        int r0 = this._columnWrappingMask;
        return r0 & (r2 + r1);
    L5:
        return r2;
    }

    private int fixupRelativeRow(int r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        int r0 = this._rowWrappingMask;
        return r0 & (r2 + r1);
    L5:
        return r2;
    }

    public Ptg[] convertSharedFormulas(Ptg[] r18, int r19, int r20) {
        Ptg[] r4 = new Ptg[r18.length];
        int r5 = 0;
    L4:
        if (r5 >= r18.length) goto L18;
        Ptg r6 = r18[r5];
        byte r7 = -1;
        if (r6.isBaseToken() == true) goto L9;
        r7 = r6.getPtgClass();
    L9:
        if (ZeusTransformUtils.instanceOf(r6, RefPtgBase.class) == false) goto L12;
        RefPtgBase r8 = (RefPtgBase) ZeusTransformUtils.preCheckCast(r6, RefPtgBase.class, "com.obric.memorydata.plugin");
        RefPtg r9 = new RefPtg(fixupRelativeRow(r19, r8.getRow(), r8.isRowRelative()), fixupRelativeColumn(r20, r8.getColumn(), r8.isColRelative()), r8.isRowRelative(), r8.isColRelative());
        r9.setClass(r7);
        r6 = r9;
    L17:
        r4[r5] = r6;
        r5 = r5 + 1;
        goto L4
    L12:
        if (ZeusTransformUtils.instanceOf(r6, AreaPtgBase.class) == false) goto L15;
        AreaPtgBase r10 = (AreaPtgBase) ZeusTransformUtils.preCheckCast(r6, AreaPtgBase.class, "com.obric.memorydata.plugin");
        AreaPtg r15 = new AreaPtg(fixupRelativeRow(r19, r10.getFirstRow(), r10.isFirstRowRelative()), fixupRelativeRow(r19, r10.getLastRow(), r10.isLastRowRelative()), fixupRelativeColumn(r20, r10.getFirstColumn(), r10.isFirstColRelative()), fixupRelativeColumn(r20, r10.getLastColumn(), r10.isLastColRelative()), r10.isFirstRowRelative(), r10.isLastRowRelative(), r10.isFirstColRelative(), r10.isLastColRelative());
        r15.setClass(r7);
        r6 = r15;
        goto L17
    L15:
        if (ZeusTransformUtils.instanceOf(r6, OperandPtg.class) == false) goto L17;
        r6 = ((OperandPtg) ZeusTransformUtils.preCheckCast(r6, OperandPtg.class, "com.obric.memorydata.plugin")).copy();
        goto L17
    L18:
        return r4;
    }
}
