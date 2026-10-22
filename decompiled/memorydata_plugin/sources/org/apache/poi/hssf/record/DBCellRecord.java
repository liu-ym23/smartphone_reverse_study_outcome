package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DBCellRecord extends StandardRecord {
    private final int field_1_row_offset;
    private final short[] field_2_cell_offsets;

    public DBCellRecord(int r1, short[] r2) {
        this.field_1_row_offset = r1;
        this.field_2_cell_offsets = r2;
    }

    public DBCellRecord(RecordInputStream r4) {
        this.field_1_row_offset = r4.readUShort();
        this.field_2_cell_offsets = new short[r4.remaining() / 2];
        int r0 = 0;
    L3:
        short[] r1 = this.field_2_cell_offsets;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r4.readShort();
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.field_2_cell_offsets.length * 2) + 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rowOffset", new $$Lambda$DBCellRecord$GUhp8B9n4KZjecl0z3qSkgNvgA(this), "cellOffsets", new $$Lambda$DBCellRecord$ZZLRqIvRfnLPuTvSiaAP10OdAbg(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DB_CELL;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 215;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DBCellRecord() {
        return Integer.valueOf(this.field_1_row_offset);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DBCellRecord() {
        return this.field_2_cell_offsets;
    }
}
