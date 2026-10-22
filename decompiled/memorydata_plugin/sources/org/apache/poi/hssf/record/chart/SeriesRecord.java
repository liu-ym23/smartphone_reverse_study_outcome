package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SeriesRecord extends StandardRecord {
    private short field_1_categoryDataType;
    private short field_2_valuesDataType;
    private short field_3_numCategories;
    private short field_4_numValues;
    private short field_5_bubbleSeriesType;
    private short field_6_numBubbleValues;

    public SeriesRecord() {
    }

    public SeriesRecord(RecordInputStream r2) {
        this.field_1_categoryDataType = r2.readShort();
        this.field_2_valuesDataType = r2.readShort();
        this.field_3_numCategories = r2.readShort();
        this.field_4_numValues = r2.readShort();
        this.field_5_bubbleSeriesType = r2.readShort();
        this.field_6_numBubbleValues = r2.readShort();
    }

    public short getBubbleSeriesType() {
        return this.field_5_bubbleSeriesType;
    }

    public short getCategoryDataType() {
        return this.field_1_categoryDataType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("categoryDataType", new $$Lambda$MNF9r0OKY_eIdtzW7ZmHU6gag(this), "valuesDataType", new $$Lambda$xFnHQRB78AYPwFl_shZp4iqbgLs(this), "numCategories", new $$Lambda$Te9VREX85EiS3i_9FOaIz5cbJHE(this), "numValues", new $$Lambda$9f7p3X3qZd101IOzKw3Oub1vG8Y(this), "bubbleSeriesType", new $$Lambda$nkfCn5gvyVekkhwLDIJps82qAuA(this), "numBubbleValues", new $$Lambda$85ybifr9uOIwuYUcfAFCdeb3TOg(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES;
    }

    public short getNumBubbleValues() {
        return this.field_6_numBubbleValues;
    }

    public short getNumCategories() {
        return this.field_3_numCategories;
    }

    public short getNumValues() {
        return this.field_4_numValues;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4099;
    }

    public short getValuesDataType() {
        return this.field_2_valuesDataType;
    }
}
