package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SCLRecord extends StandardRecord {
    private short field_1_numerator;
    private short field_2_denominator;

    public SCLRecord() {
    }

    public SCLRecord(RecordInputStream r2) {
        this.field_1_numerator = r2.readShort();
        this.field_2_denominator = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public short getDenominator() {
        return this.field_2_denominator;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("numerator", new $$Lambda$p5SZjMlmGIyVFIWxCxj4T4gw94(this), "denominator", new $$Lambda$eMiYlLU4t5h83K25BUftEvYyP6E(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SCL;
    }

    public short getNumerator() {
        return this.field_1_numerator;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 160;
    }
}
