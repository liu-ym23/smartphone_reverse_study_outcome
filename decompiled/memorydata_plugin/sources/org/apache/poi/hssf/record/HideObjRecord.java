package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HideObjRecord extends StandardRecord {
    private short field_1_hide_obj;

    public HideObjRecord() {
    }

    public HideObjRecord(RecordInputStream r1) {
        this.field_1_hide_obj = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("hideObj", new $$Lambda$IdaiMtHRCo4fc7w27wPUUVD5B0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HIDE_OBJ;
    }

    public short getHideObj() {
        return this.field_1_hide_obj;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 141;
    }

    public void setHideObj(short r1) {
        this.field_1_hide_obj = r1;
    }
}
