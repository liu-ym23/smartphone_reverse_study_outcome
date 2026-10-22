package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HCenterRecord extends StandardRecord {
    private short field_1_hcenter;

    public HCenterRecord() {
    }

    public HCenterRecord(RecordInputStream r1) {
        this.field_1_hcenter = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("hcenter", new $$Lambda$WTgLW_p78GV7QCV9gcRnmuliLAQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.H_CENTER;
    }

    public boolean getHCenter() {
        if (this.field_1_hcenter == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 131;
    }

    public void setHCenter(boolean r1) {
        this.field_1_hcenter = r1 ? 1 : 0;
    }
}
