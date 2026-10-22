package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class VCenterRecord extends StandardRecord {
    private int field_1_vcenter;

    public VCenterRecord() {
    }

    public VCenterRecord(RecordInputStream r1) {
        this.field_1_vcenter = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("vcenter", new $$Lambda$6WvwTSGZ9VLVGP3E3WubyrFfH0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.V_CENTER;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 132;
    }

    public boolean getVCenter() {
        if (this.field_1_vcenter == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void setVCenter(boolean r1) {
        this.field_1_vcenter = r1 ? 1 : 0;
    }
}
