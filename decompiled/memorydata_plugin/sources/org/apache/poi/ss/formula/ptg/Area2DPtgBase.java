package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Area2DPtgBase extends AreaPtgBase {
    public Area2DPtgBase(int r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public Area2DPtgBase(Area2DPtgBase r1) {
        super(r1);
    }

    public Area2DPtgBase(AreaReference r1) {
        super(r1);
    }

    public Area2DPtgBase(LittleEndianInput r3) {
        readCoordinates((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 9;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getSid() + getPtgClass());
        writeCoordinates(r4);
    }
}
