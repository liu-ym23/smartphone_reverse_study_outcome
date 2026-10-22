package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public final class TblPtg extends ControlPtg {
    private final int field_1_first_row;
    private final int field_2_first_col;

    public TblPtg(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_first_row = r4.readUShort();
        this.field_2_first_col = r4.readUShort();
    }

    public int getColumn() {
        return this.field_2_first_col;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$90NwyiZbU7Oi9nGPV9nidbqw5zs(this), "column", new $$Lambda$QtuqTSR7O8FAHwghuC3aLBALM7I(this));
    }

    public int getRow() {
        return this.field_1_first_row;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 5;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        throw new RuntimeException("Table and Arrays are not yet supported");
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(getPtgClass() + 2);
        r4.writeShort(this.field_1_first_row);
        r4.writeShort(this.field_2_first_col);
    }
}
