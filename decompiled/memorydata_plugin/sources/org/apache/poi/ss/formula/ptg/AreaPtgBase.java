package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AreaPtgBase extends OperandPtg implements AreaI {
    private static final BitField colRelative = null;
    private static final BitField columnMask = null;
    private static final BitField rowRelative = null;
    private int field_1_first_row;
    private int field_2_last_row;
    private int field_3_first_column;
    private int field_4_last_column;

    static {
        rowRelative = BitFieldFactory.getInstance(32768);
        colRelative = BitFieldFactory.getInstance(16384);
        columnMask = BitFieldFactory.getInstance(16383);
    }

    public AreaPtgBase() {
    }

    public AreaPtgBase(int r1, int r2, int r3, int r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        if (r2 < r1) goto L5;
        setFirstRow(r1);
        setLastRow(r2);
        setFirstRowRelative(r5);
        setLastRowRelative(r6);
    L6:
        if (r4 < r3) goto L8;
        setFirstColumn(r3);
        setLastColumn(r4);
        setFirstColRelative(r7);
        setLastColRelative(r8);
        return;
    L8:
        setFirstColumn(r4);
        setLastColumn(r3);
        setFirstColRelative(r8);
        setLastColRelative(r7);
        return;
    L5:
        setFirstRow(r2);
        setLastRow(r1);
        setFirstRowRelative(r6);
        setLastRowRelative(r5);
        goto L6
    }

    public AreaPtgBase(AreaPtgBase r2) {
        super(r2);
        this.field_1_first_row = r2.field_1_first_row;
        this.field_2_last_row = r2.field_2_last_row;
        this.field_3_first_column = r2.field_3_first_column;
        this.field_4_last_column = r2.field_4_last_column;
    }

    public AreaPtgBase(AreaReference r4) {
        CellReference r0 = r4.getFirstCell();
        CellReference r5 = r4.getLastCell();
        setFirstRow(r0.getRow());
        if (r0.getCol() != (-1)) goto L5;
        short r1 = 0;
    L6:
        setFirstColumn(r1);
        setLastRow(r5.getRow());
        if (r5.getCol() != (-1)) goto L9;
        short r2 = 255;
    L10:
        setLastColumn(r2);
        setFirstColRelative(!r0.isColAbsolute());
        setLastColRelative(!r5.isColAbsolute());
        setFirstRowRelative(!r0.isRowAbsolute());
        setLastRowRelative(!r5.isRowAbsolute());
        return;
    L9:
        r2 = r5.getCol();
        goto L10
    L5:
        r1 = r0.getCol();
        goto L6
    }

    public final String formatReferenceAsString() {
        CellReference r0 = new CellReference(getFirstRow(), getFirstColumn(), !isFirstRowRelative(), !isFirstColRelative());
        CellReference r1 = new CellReference(getLastRow(), getLastColumn(), !isLastRowRelative(), !isLastColRelative());
        if (AreaReference.isWholeColumnReference(SpreadsheetVersion.EXCEL97, r0, r1) == false) goto L7;
        return new AreaReference(r0, r1, SpreadsheetVersion.EXCEL97).formatAsString();
    L7:
        if (AreaReference.isWholeColumnReference(SpreadsheetVersion.EXCEL2007, r0, r1) == false) goto L11;
        return new AreaReference(r0, r1, SpreadsheetVersion.EXCEL2007).formatAsString();
    L11:
        return r0.formatAsString() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r1.formatAsString();
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstColumn() {
        return columnMask.getValue(this.field_3_first_column);
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getFirstRow() {
        return this.field_1_first_row;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("firstRow", new $$Lambda$oRJ8E_nfLQinZWnYfJfe1XP0o7c(this), "firstRowRelative", new $$Lambda$C7txC9fzMsn_61hYU5Zdttf91Ec(this), "firstColumn", new $$Lambda$RtSQ5dn4lYTQLvI6Z1T4PgtYtQQ(this), "firstColRelative", new $$Lambda$kTV3vnTucd6ZLwqnK7WNi24j84(this), "lastRow", new $$Lambda$8ZfH6RYABAebiv70oC8t_PZYcKY(this), "lastRowRelative", new $$Lambda$OFDxVQgYhD86vkUOwel3SHzmzs(this), "lastColumn", new $$Lambda$Mxo2KUrAjwGKm9P0xxGZaqCBWpk(this), "lastColRelative", new $$Lambda$dK5tlssXIr8UVEW3spVmWp0PM(this), "formatReference", new $$Lambda$jdGKC8TVv4nKj7ZAkyWlA229D7M(this));
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastColumn() {
        return columnMask.getValue(this.field_4_last_column);
    }

    @Override // org.apache.poi.ss.formula.ptg.AreaI
    public final int getLastRow() {
        return this.field_2_last_row;
    }

    public final boolean isFirstColRelative() {
        return colRelative.isSet(this.field_3_first_column);
    }

    public final boolean isFirstRowRelative() {
        return rowRelative.isSet(this.field_3_first_column);
    }

    public final boolean isLastColRelative() {
        return colRelative.isSet(this.field_4_last_column);
    }

    public final boolean isLastRowRelative() {
        return rowRelative.isSet(this.field_4_last_column);
    }

    public final void readCoordinates(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.field_1_first_row = r4.readUShort();
        this.field_2_last_row = r4.readUShort();
        this.field_3_first_column = r4.readUShort();
        this.field_4_last_column = r4.readUShort();
    }

    public final void setFirstColRelative(boolean r3) {
        this.field_3_first_column = colRelative.setBoolean(this.field_3_first_column, r3);
    }

    public final void setFirstColumn(int r3) {
        this.field_3_first_column = columnMask.setValue(this.field_3_first_column, r3);
    }

    public final void setFirstRow(int r1) {
        this.field_1_first_row = r1;
    }

    public final void setFirstRowRelative(boolean r3) {
        this.field_3_first_column = rowRelative.setBoolean(this.field_3_first_column, r3);
    }

    public final void setLastColRelative(boolean r3) {
        this.field_4_last_column = colRelative.setBoolean(this.field_4_last_column, r3);
    }

    public final void setLastColumn(int r3) {
        this.field_4_last_column = columnMask.setValue(this.field_4_last_column, r3);
    }

    public final void setLastRow(int r1) {
        this.field_2_last_row = r1;
    }

    public final void setLastRowRelative(boolean r3) {
        this.field_4_last_column = rowRelative.setBoolean(this.field_4_last_column, r3);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return formatReferenceAsString();
    }

    public final void writeCoordinates(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeShort(this.field_1_first_row);
        r4.writeShort(this.field_2_last_row);
        r4.writeShort(this.field_3_first_column);
        r4.writeShort(this.field_4_last_column);
    }
}
