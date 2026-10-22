package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RefPtgBase extends OperandPtg {
    private static final BitField colRelative = null;
    private static final BitField column = null;
    private static final BitField rowRelative = null;
    private int field_1_row;
    private int field_2_col;

    static {
        column = BitFieldFactory.getInstance(16383);
        rowRelative = BitFieldFactory.getInstance(32768);
        colRelative = BitFieldFactory.getInstance(16384);
    }

    public RefPtgBase() {
    }

    public RefPtgBase(RefPtgBase r2) {
        super(r2);
        this.field_1_row = r2.field_1_row;
        this.field_2_col = r2.field_2_col;
    }

    public RefPtgBase(CellReference r2) {
        setRow(r2.getRow());
        setColumn(r2.getCol());
        setColRelative(!r2.isColAbsolute());
        setRowRelative(!r2.isRowAbsolute());
    }

    public String formatReferenceAsString() {
        return new CellReference(getRow(), getColumn(), !isRowRelative(), !isColRelative()).formatAsString();
    }

    public final int getColumn() {
        return column.getValue(this.field_2_col);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$aUJG5coemsGcGQ_hSNeW1kfaxY(this), "rowRelative", new $$Lambda$uEIFipiOUSqrtBCxb2rL0CKyig(this), "column", new $$Lambda$lo1YmfLajWJp7eC9YOKjnRej088(this), "colRelative", new $$Lambda$IwYG7KFVY8kCdgTmjPPHTrGaWOU(this), "formatReference", new $$Lambda$464AjJckh3b4Zu0rT8kTG03Huds(this));
    }

    public final int getRow() {
        return this.field_1_row;
    }

    public final boolean isColRelative() {
        return colRelative.isSet(this.field_2_col);
    }

    public final boolean isRowRelative() {
        return rowRelative.isSet(this.field_2_col);
    }

    public final void readCoordinates(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_row = r4.readUShort();
        this.field_2_col = r4.readUShort();
    }

    public final void setColRelative(boolean r3) {
        this.field_2_col = colRelative.setBoolean(this.field_2_col, r3);
    }

    public final void setColumn(int r3) {
        this.field_2_col = column.setValue(this.field_2_col, r3);
    }

    public final void setRow(int r1) {
        this.field_1_row = r1;
    }

    public final void setRowRelative(boolean r3) {
        this.field_2_col = rowRelative.setBoolean(this.field_2_col, r3);
    }

    public final void writeCoordinates(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeShort(this.field_1_row);
        r4.writeShort(this.field_2_col);
    }
}
