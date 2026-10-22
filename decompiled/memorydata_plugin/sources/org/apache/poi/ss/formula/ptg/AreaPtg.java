package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class AreaPtg extends Area2DPtgBase {
    public AreaPtg(int r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public AreaPtg(AreaPtg r1) {
        super(r1);
    }

    public AreaPtg(AreaReference r1) {
        super(r1);
    }

    public AreaPtg(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public AreaPtg copy() {
        return new AreaPtg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 37;
    }
}
