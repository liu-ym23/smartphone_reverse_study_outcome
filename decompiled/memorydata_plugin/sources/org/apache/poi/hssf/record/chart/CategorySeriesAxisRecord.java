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
public final class CategorySeriesAxisRecord extends StandardRecord {
    private static final BitField crossesFarRight = null;
    private static final BitField reversed = null;
    private static final BitField valueAxisCrossing = null;
    private short field_1_crossingPoint;
    private short field_2_labelFrequency;
    private short field_3_tickMarkFrequency;
    private short field_4_options;

    static {
        valueAxisCrossing = BitFieldFactory.getInstance(1);
        crossesFarRight = BitFieldFactory.getInstance(2);
        reversed = BitFieldFactory.getInstance(4);
    }

    public CategorySeriesAxisRecord() {
    }

    public CategorySeriesAxisRecord(RecordInputStream r2) {
        this.field_1_crossingPoint = r2.readShort();
        this.field_2_labelFrequency = r2.readShort();
        this.field_3_tickMarkFrequency = r2.readShort();
        this.field_4_options = r2.readShort();
    }

    public short getCrossingPoint() {
        return this.field_1_crossingPoint;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("crossingPoint", new $$Lambda$UbzHLm00ucyTyY7dmyjHOji2X4(this), "labelFrequency", new $$Lambda$Q8mihz9X7pKkf3EzK6hTNxzHepM(this), "tickMarkFrequency", new $$Lambda$HpJ4UY_0YhqWxI0hL55En1tWqPs(this), "options", new $$Lambda$d1mVmwIi8IPSuTRe5UA_L_q9JQw(this), "valueAxisCrossing", new $$Lambda$zn0KQMYkFvmNEcTp9WHeht8oAS0(this), "crossesFarRight", new $$Lambda$dRPCCxhGw09F8gR1pK0KrIGgFQc(this), "reversed", new $$Lambda$4u8YJ4rSZQ6kBK4CMzD7en4Pn8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CATEGORY_SERIES_AXIS;
    }

    public short getLabelFrequency() {
        return this.field_2_labelFrequency;
    }

    public short getOptions() {
        return this.field_4_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4128;
    }

    public short getTickMarkFrequency() {
        return this.field_3_tickMarkFrequency;
    }

    public boolean isCrossesFarRight() {
        return crossesFarRight.isSet(this.field_4_options);
    }

    public boolean isReversed() {
        return reversed.isSet(this.field_4_options);
    }

    public boolean isValueAxisCrossing() {
        return valueAxisCrossing.isSet(this.field_4_options);
    }
}
