package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IntList;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class IndexRecord extends StandardRecord {
    private int field_2_first_row;
    private int field_3_last_row_add1;
    private int field_4_zero;
    private IntList field_5_dbcells;

    public IndexRecord() {
    }

    public IndexRecord(RecordInputStream r5) {
        int r0 = r5.readInt();
        if (r0 != 0) goto L9;
        this.field_2_first_row = r5.readInt();
        this.field_3_last_row_add1 = r5.readInt();
        this.field_4_zero = r5.readInt();
        int r1 = r5.remaining() / 4;
        this.field_5_dbcells = new IntList(r1);
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        this.field_5_dbcells.add(r5.readInt());
        r2 = r2 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new RecordFormatException("Expected zero for field 1 but got " + r0);
    }

    static /* synthetic */ Object lambda$getGenericProperties$0() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (getNumDbcells() * 4) + 16;
    }

    public int getFirstRow() {
        return this.field_2_first_row;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        Supplier r1 = new $$Lambda$ZgUUDJKOBhLFlrraSXdvKuhX94k(this);
        Supplier r3 = new $$Lambda$w_jbTw7AYl1w3dhUsJYX1bjcDM(this);
        final IntList r6 = this.field_5_dbcells;
        if (r6 != null) goto L5;
        Supplier r5 = $$Lambda$IndexRecord$B0BvswNs5mJ0smwVPo5ybM0ONi0.INSTANCE;
    L7:
        return GenericRecordUtil.getGenericProperties("firstRow", r1, "lastRowAdd1", r3, "dbcell_", r5);
    L5:
        r6.getClass();
        r5 = new $$Lambda$vy26o9M2d7omgxpQHgB8TYDDJw8(r6);
        goto L7
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.INDEX;
    }

    public int getLastRowAdd1() {
        return this.field_3_last_row_add1;
    }

    public int getNumDbcells() {
        IntList r0 = this.field_5_dbcells;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 523;
    }
}
