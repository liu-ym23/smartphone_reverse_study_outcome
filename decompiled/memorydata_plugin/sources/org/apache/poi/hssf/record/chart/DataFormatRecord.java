package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DataFormatRecord extends StandardRecord {
    private static final BitField useExcel4Colors = null;
    private short field_1_pointNumber;
    private short field_2_seriesIndex;
    private short field_3_seriesNumber;
    private short field_4_formatFlags;

    static {
        useExcel4Colors = BitFieldFactory.getInstance(1);
    }

    public DataFormatRecord() {
    }

    public DataFormatRecord(RecordInputStream r2) {
        this.field_1_pointNumber = r2.readShort();
        this.field_2_seriesIndex = r2.readShort();
        this.field_3_seriesNumber = r2.readShort();
        this.field_4_formatFlags = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    public short getFormatFlags() {
        return this.field_4_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("pointNumber", new $$Lambda$IxwftOj72AKCwMRVCISdluMwwag(this), "seriesIndex", new $$Lambda$faqdJos3l3TwG37AyBgCA9NUTU8(this), "seriesNumber", new $$Lambda$_zJDGILQjChUYoq9ThLd_6mxTkY(this), "formatFlags", new $$Lambda$ji6RlQ4H5N4A3HX5FWJO_WJTkDg(this), "useExcel4Colors", new $$Lambda$OK8xi4UKYIUebH4AhIw0rtryvM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DATA_FORMAT;
    }

    public short getPointNumber() {
        return this.field_1_pointNumber;
    }

    public short getSeriesIndex() {
        return this.field_2_seriesIndex;
    }

    public short getSeriesNumber() {
        return this.field_3_seriesNumber;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4102;
    }

    public boolean isUseExcel4Colors() {
        return useExcel4Colors.isSet(this.field_4_formatFlags);
    }
}
