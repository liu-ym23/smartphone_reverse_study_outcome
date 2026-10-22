package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SeriesChartGroupIndexRecord extends StandardRecord {
    private short field_1_chartGroupIndex;

    public SeriesChartGroupIndexRecord() {
    }

    public SeriesChartGroupIndexRecord(RecordInputStream r1) {
        this.field_1_chartGroupIndex = r1.readShort();
    }

    public short getChartGroupIndex() {
        return this.field_1_chartGroupIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("chartGroupIndex", new $$Lambda$zDcH20_L30RMKX8jUCS074kvPQs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES_CHART_GROUP_INDEX;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4165;
    }
}
