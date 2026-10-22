package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
abstract class Ref2DPtgBase extends RefPtgBase {
    public Ref2DPtgBase(int r1, int r2, boolean r3, boolean r4) {
        setRow(r1);
        setColumn(r2);
        setRowRelative(r3);
        setColRelative(r4);
    }

    public Ref2DPtgBase(Ref2DPtgBase r1) {
        super(r1);
    }

    public Ref2DPtgBase(CellReference r1) {
        super(r1);
    }

    public Ref2DPtgBase(LittleEndianInput r3) {
        readCoordinates((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final int getSize() {
        return 5;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toFormulaString() {
        return formatReferenceAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getSid() + getPtgClass());
        writeCoordinates(r4);
    }
}
