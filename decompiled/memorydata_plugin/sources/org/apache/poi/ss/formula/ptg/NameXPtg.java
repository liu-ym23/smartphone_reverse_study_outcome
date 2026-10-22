package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class NameXPtg extends OperandPtg implements WorkbookDependentFormula {
    private final int _nameNumber;
    private final int _reserved;
    private final int _sheetRefIndex;

    public NameXPtg(int r2, int r3) {
        this(r2, r3 + 1, 0);
    }

    private NameXPtg(int r1, int r2, int r3) {
        this._sheetRefIndex = r1;
        this._nameNumber = r2;
        this._reserved = r3;
    }

    public NameXPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this(r4.readUShort(), r4.readUShort(), r4.readUShort());
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public NameXPtg copy() {
        return this;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperandPtg
    public /* bridge */ /* synthetic */ OperandPtg copy() {
        return copy();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("sheetRefIndex", new $$Lambda$A2UpM3ipNF5nXQZ9Fe9XOo99yY(this), "nameIndex", new $$Lambda$jR9jLGUQ5pHKPRv9zJHmeNBRmY(this));
    }

    public int getNameIndex() {
        return this._nameNumber - 1;
    }

    public int getSheetRefIndex() {
        return this._sheetRefIndex;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 57;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 7;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("3D references need a workbook to determine formula text");
    }

    @Override // org.apache.poi.ss.formula.WorkbookDependentFormula
    public String toFormulaString(FormulaRenderingWorkbook r3) {
        return ((FormulaRenderingWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, FormulaRenderingWorkbook.class, "com.obric.memorydata.plugin")).resolveNameXText(this);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 57);
        r4.writeShort(this._sheetRefIndex);
        r4.writeShort(this._nameNumber);
        r4.writeShort(this._reserved);
    }
}
