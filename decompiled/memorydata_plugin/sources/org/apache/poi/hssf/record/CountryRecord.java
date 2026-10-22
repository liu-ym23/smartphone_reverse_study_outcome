package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CountryRecord extends StandardRecord {
    private short field_1_default_country;
    private short field_2_current_country;

    public CountryRecord() {
    }

    public CountryRecord(RecordInputStream r2) {
        this.field_1_default_country = r2.readShort();
        this.field_2_current_country = r2.readShort();
    }

    public short getCurrentCountry() {
        return this.field_2_current_country;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    public short getDefaultCountry() {
        return this.field_1_default_country;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("defaultCountry", new $$Lambda$dNPv2dWnVFmWPnK_GJP63sUa0(this), "currentCountry", new $$Lambda$HS3LUkqoLCxIH2DxPJGbIJFKQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.COUNTRY;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 140;
    }

    public void setCurrentCountry(short r1) {
        this.field_2_current_country = r1;
    }

    public void setDefaultCountry(short r1) {
        this.field_1_default_country = r1;
    }
}
