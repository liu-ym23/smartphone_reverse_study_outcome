package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DefaultRowHeightRecord extends StandardRecord {
    private short field_1_option_flags;
    private short field_2_row_height;

    public DefaultRowHeightRecord() {
        this.field_1_option_flags = 0;
        this.field_2_row_height = 255;
    }

    public DefaultRowHeightRecord(RecordInputStream r2) {
        this.field_1_option_flags = r2.readShort();
        this.field_2_row_height = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("optionFlags", new $$Lambda$3gKI1nibKolqIhI0AAliJVGI3tc(this), "rowHeight", new $$Lambda$MQAWLJLd6uksqJnWPzQlhGSfeCE(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DEFAULT_ROW_HEIGHT;
    }

    public short getOptionFlags() {
        return this.field_1_option_flags;
    }

    public short getRowHeight() {
        return this.field_2_row_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 549;
    }

    public void setOptionFlags(short r1) {
        this.field_1_option_flags = r1;
    }

    public void setRowHeight(short r1) {
        this.field_2_row_height = r1;
    }
}
