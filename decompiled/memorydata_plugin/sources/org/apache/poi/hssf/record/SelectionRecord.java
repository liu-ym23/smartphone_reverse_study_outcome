package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SelectionRecord extends StandardRecord {
    private byte field_1_pane;
    private int field_2_row_active_cell;
    private int field_3_col_active_cell;
    private int field_4_active_cell_ref_index;
    private CellRangeAddress8Bit[] field_6_refs;

    public SelectionRecord(int r4, int r5) {
        this.field_1_pane = 3;
        this.field_2_row_active_cell = r4;
        this.field_3_col_active_cell = r5;
        this.field_4_active_cell_ref_index = 0;
        this.field_6_refs = new CellRangeAddress8Bit[]{new CellRangeAddress8Bit(r4, r4, r5, r5)};
    }

    public SelectionRecord(RecordInputStream r4) {
        this.field_1_pane = r4.readByte();
        this.field_2_row_active_cell = r4.readUShort();
        this.field_3_col_active_cell = r4.readShort();
        this.field_4_active_cell_ref_index = r4.readShort();
        this.field_6_refs = new CellRangeAddress8Bit[r4.readUShort()];
        int r0 = 0;
    L3:
        CellRangeAddress8Bit[] r1 = this.field_6_refs;
        if (r0 >= r1.length) goto L6;
        r1[r0] = new CellRangeAddress8Bit(r4);
        r0 = r0 + 1;
        goto L3
    }

    public int getActiveCellCol() {
        return this.field_3_col_active_cell;
    }

    public int getActiveCellRef() {
        return this.field_4_active_cell_ref_index;
    }

    public int getActiveCellRow() {
        return this.field_2_row_active_cell;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CellRangeAddress8Bit.getEncodedSize(this.field_6_refs.length) + 9;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("pane", new $$Lambda$yXqA2fTpvgR0o2CUm0W6OzMxpRE(this), "activeCellRow", new $$Lambda$m8O7V8_kfw9hOXi0SCvhw0x0cpU(this), "activeCellCol", new $$Lambda$wXpWHgqt8CRAB3v21y2GLumf0(this), "activeCellRef", new $$Lambda$a5e_5m3OmVNKF9SktsnqVfvK4gw(this), "refs", new $$Lambda$SelectionRecord$cey0o9OVCqw9BS3BSbIBn8sk4uA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SELECTION;
    }

    public byte getPane() {
        return this.field_1_pane;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 29;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$SelectionRecord() {
        return this.field_6_refs;
    }
}
