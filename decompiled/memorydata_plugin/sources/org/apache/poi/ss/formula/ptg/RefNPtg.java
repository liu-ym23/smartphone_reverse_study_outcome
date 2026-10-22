package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class RefNPtg extends Ref2DPtgBase {
    public RefNPtg(RefNPtg r1) {
        super(r1);
    }

    public RefNPtg(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public RefNPtg copy() {
        return new RefNPtg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.RefPtgBase
    public final String formatReferenceAsString() {
        StringBuilder r0 = new StringBuilder();
        if (isRowRelative() == false) goto L5;
        r0.append("RowOffset: ").append(getRow()).append(" ");
    L7:
        if (isColRelative() == false) goto L9;
        r0.append(" ColOffset: ").append(getColumn());
    L11:
        return r0.toString();
    L9:
        r0.append(CellReference.convertNumToColString(getColumn()));
        goto L11
    L5:
        r0.append(getRow() + 1);
        goto L7
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 44;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public /* synthetic */ void write(LittleEndianOutput r3) {
        super.write((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin"));
    }
}
