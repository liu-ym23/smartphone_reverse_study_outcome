package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class AreaErrPtg extends OperandPtg {
    private final int unused1;
    private final int unused2;

    public AreaErrPtg() {
        this.unused1 = 0;
        this.unused2 = 0;
    }

    public AreaErrPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.unused1 = r4.readInt();
        this.unused2 = r4.readInt();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public AreaErrPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("unused1", new $$Lambda$AreaErrPtg$GwfhbBf23VwW9zM5ciUEQTLOAOI(this), "unused2", new $$Lambda$AreaErrPtg$8ghza540m99hUCD6XBlhPSJ_UxE(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 43;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 9;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$AreaErrPtg() {
        return Integer.valueOf(this.unused1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$AreaErrPtg() {
        return Integer.valueOf(this.unused2);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return FormulaError.REF.getString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 43);
        r4.writeInt(this.unused1);
        r4.writeInt(this.unused2);
    }
}
