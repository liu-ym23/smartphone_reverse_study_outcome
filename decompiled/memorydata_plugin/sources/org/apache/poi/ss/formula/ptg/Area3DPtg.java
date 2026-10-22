package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.ExternSheetReferenceToken;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class Area3DPtg extends AreaPtgBase implements ExternSheetReferenceToken, WorkbookDependentFormula {
    private int field_1_index_extern_sheet;

    public Area3DPtg(Area3DPtg r1) {
        super(r1);
        this.field_1_index_extern_sheet = r1.field_1_index_extern_sheet;
    }

    public Area3DPtg(AreaReference r1, int r2) {
        super(r1);
        setExternSheetIndex(r2);
    }

    public Area3DPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_index_extern_sheet = r4.readShort();
        readCoordinates(r4);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public Area3DPtg copy() {
        return new Area3DPtg(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    public int getExternSheetIndex() {
        return this.field_1_index_extern_sheet;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$Area3DPtg$MBNdyz_5C59P6AQ2YfXhEVhDHFY(this), "externSheetIndex", new $$Lambda$eOMRbZuhXII0lwUtO94p0I5h5Hg(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 59;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 11;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$Area3DPtg() {
        return super.getGenericProperties();
    }

    public void setExternSheetIndex(int r1) {
        this.field_1_index_extern_sheet = r1;
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaPtgBase, org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook r3) {
        return ExternSheetNameResolver.prependSheetName((FormulaRenderingWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, FormulaRenderingWorkbook.class, "com.obric.memorydata.plugin"), this.field_1_index_extern_sheet, formatReferenceAsString());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 59);
        r4.writeShort(this.field_1_index_extern_sheet);
        writeCoordinates(r4);
    }
}
