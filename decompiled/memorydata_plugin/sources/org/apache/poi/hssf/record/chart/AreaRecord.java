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
public final class AreaRecord extends StandardRecord {
    private static final BitField displayAsPercentage = null;
    private static final BitField shadow = null;
    private static final BitField stacked = null;
    private short field_1_formatFlags;

    static {
        stacked = BitFieldFactory.getInstance(1);
        displayAsPercentage = BitFieldFactory.getInstance(2);
        shadow = BitFieldFactory.getInstance(4);
    }

    public AreaRecord() {
    }

    public AreaRecord(RecordInputStream r1) {
        this.field_1_formatFlags = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public short getFormatFlags() {
        return this.field_1_formatFlags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("formatFlags", new $$Lambda$ySCZjFl0hFPR0qHZXNk0OihNFlg(this), "stacked", new $$Lambda$d34BkuNlDCR7qqTWyuEtyZwDsus(this), "displayAsPercentage", new $$Lambda$_B2x_L9bswQAe8Lvy5ozpRpbvt4(this), "shadow", new $$Lambda$kj35NjSsvmDDFxRjZxbsFZ6gyg(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AREA;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4122;
    }

    public boolean isDisplayAsPercentage() {
        return displayAsPercentage.isSet(this.field_1_formatFlags);
    }

    public boolean isShadow() {
        return shadow.isSet(this.field_1_formatFlags);
    }

    public boolean isStacked() {
        return stacked.isSet(this.field_1_formatFlags);
    }
}
