package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class DeletedRef3DPtg extends OperandPtg implements WorkbookDependentFormula {
    private final int field_1_index_extern_sheet;
    private final int unused1;

    public DeletedRef3DPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_index_extern_sheet = r4.readUShort();
        this.unused1 = r4.readInt();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public DeletedRef3DPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("externSheetIndex", new $$Lambda$DeletedRef3DPtg$O4z2lp3aFHukH3snr7ZgvsVLcUc(this), "unused1", new $$Lambda$DeletedRef3DPtg$ssdSJMZAUyqzRrW02nfZmFegKI(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 60;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DeletedRef3DPtg() {
        return Integer.valueOf(this.field_1_index_extern_sheet);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DeletedRef3DPtg() {
        return Integer.valueOf(this.unused1);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook r3) {
        return ExternSheetNameResolver.prependSheetName((FormulaRenderingWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, FormulaRenderingWorkbook.class, "com.obric.memorydata.plugin"), this.field_1_index_extern_sheet, FormulaError.REF.getString());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 60);
        r4.writeShort(this.field_1_index_extern_sheet);
        r4.writeInt(this.unused1);
    }
}
