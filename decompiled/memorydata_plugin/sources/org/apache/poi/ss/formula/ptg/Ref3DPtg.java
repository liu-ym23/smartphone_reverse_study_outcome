package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.ExternSheetReferenceToken;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class Ref3DPtg extends RefPtgBase implements ExternSheetReferenceToken, WorkbookDependentFormula {
    private int field_1_index_extern_sheet;

    public Ref3DPtg(Ref3DPtg r1) {
        super(r1);
        this.field_1_index_extern_sheet = r1.field_1_index_extern_sheet;
    }

    public Ref3DPtg(CellReference r1, int r2) {
        super(r1);
        setExternSheetIndex(r2);
    }

    public Ref3DPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_index_extern_sheet = r4.readShort();
        readCoordinates(r4);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public Ref3DPtg copy() {
        return new Ref3DPtg(this);
    }

    public int getExternSheetIndex() {
        return this.field_1_index_extern_sheet;
    }

    @Override // org.apache.poi.ss.formula.ptg.RefPtgBase, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$Ref3DPtg$WvWDQGSCxt2z6odZIxC2fJD7nRs(this), "externSheetIndex", new $$Lambda$JoSUGcN1G9sj0adVYg6PaqOmGOI(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 58;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$Ref3DPtg() {
        return super.getGenericProperties();
    }

    public void setExternSheetIndex(int r1) {
        this.field_1_index_extern_sheet = r1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
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
        r4.writeByte(getPtgClass() + 58);
        r4.writeShort(getExternSheetIndex());
        writeCoordinates(r4);
    }
}
