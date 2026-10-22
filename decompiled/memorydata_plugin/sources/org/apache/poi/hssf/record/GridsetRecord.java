package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class GridsetRecord extends StandardRecord {
    private short field_1_gridset_flag;

    public GridsetRecord() {
    }

    public GridsetRecord(RecordInputStream r1) {
        this.field_1_gridset_flag = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("gridset", new $$Lambda$r2T0MnJweeWD4Z8FXDmE7TshLnQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.GRIDSET;
    }

    public boolean getGridset() {
        if (this.field_1_gridset_flag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 130;
    }

    public void setGridset(boolean r1) {
        if (r1 == false) goto L4;
        short r2 = 1;
    L5:
        this.field_1_gridset_flag = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }
}
