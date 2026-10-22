package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.io.encoding.Base64;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class DeletedArea3DPtg extends OperandPtg implements WorkbookDependentFormula {
    private final int field_1_index_extern_sheet;
    private final int unused1;
    private final int unused2;

    public DeletedArea3DPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_index_extern_sheet = r4.readUShort();
        this.unused1 = r4.readInt();
        this.unused2 = r4.readInt();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public DeletedArea3DPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    public int getExternSheetIndex() {
        return this.field_1_index_extern_sheet;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("externSheetIndex", new $$Lambda$XEqnouk2PoDk04gJsGFlsk3XROU(this), "unused1", new $$Lambda$DeletedArea3DPtg$LgpXQMu0kHh3DN59CJ4wpLvXl4(this), "unused2", new $$Lambda$DeletedArea3DPtg$0F_7VZp6KlJTyBuWuqPvVEIUN8(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return Base64.padSymbol;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 11;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DeletedArea3DPtg() {
        return Integer.valueOf(this.unused1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DeletedArea3DPtg() {
        return Integer.valueOf(this.unused2);
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
        r4.writeByte(getPtgClass() + Base64.padSymbol);
        r4.writeShort(this.field_1_index_extern_sheet);
        r4.writeInt(this.unused1);
        r4.writeInt(this.unused2);
    }
}
