package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PrecisionRecord extends StandardRecord {
    private short field_1_precision;

    public PrecisionRecord() {
    }

    public PrecisionRecord(RecordInputStream r1) {
        this.field_1_precision = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public boolean getFullPrecision() {
        if (this.field_1_precision == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("precision", new $$Lambda$WXS3a0IBT7EOsGJw0iJcwBPWqs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PRECISION;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 14;
    }

    public void setFullPrecision(boolean r1) {
        this.field_1_precision = r1 ? 1 : 0;
    }
}
