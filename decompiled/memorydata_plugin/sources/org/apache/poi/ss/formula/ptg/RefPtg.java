package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class RefPtg extends Ref2DPtgBase {
    public RefPtg(int r1, int r2, boolean r3, boolean r4) {
        super(r1, r2, r3, r4);
    }

    public RefPtg(RefPtg r1) {
        super(r1);
    }

    public RefPtg(CellReference r1) {
        super(r1);
    }

    public RefPtg(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public RefPtg copy() {
        return new RefPtg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 36;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ref2DPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public /* synthetic */ void write(LittleEndianOutput r3) {
        super.write((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin"));
    }
}
