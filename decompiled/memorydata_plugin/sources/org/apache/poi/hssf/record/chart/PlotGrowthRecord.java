package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PlotGrowthRecord extends StandardRecord {
    private int field_1_horizontalScale;
    private int field_2_verticalScale;

    public PlotGrowthRecord() {
    }

    public PlotGrowthRecord(RecordInputStream r2) {
        this.field_1_horizontalScale = r2.readInt();
        this.field_2_verticalScale = r2.readInt();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("horizontalScale", new $$Lambda$e7lPxtejQWK7eoG9nnNod6THEI4(this), "verticalScale", new $$Lambda$SyFymOsaQM9YYyh5zyOXW1kSwWM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PLOT_GROWTH;
    }

    public int getHorizontalScale() {
        return this.field_1_horizontalScale;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4196;
    }

    public int getVerticalScale() {
        return this.field_2_verticalScale;
    }
}
