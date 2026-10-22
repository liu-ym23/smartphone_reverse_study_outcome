package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class AreaNPtg extends Area2DPtgBase {
    public AreaNPtg(AreaNPtg r1) {
        super(r1);
    }

    public AreaNPtg(LittleEndianInput r3) {
        super((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public AreaNPtg copy() {
        return new AreaNPtg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 45;
    }
}
