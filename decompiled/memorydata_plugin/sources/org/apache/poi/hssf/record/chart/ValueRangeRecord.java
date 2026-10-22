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
public final class ValueRangeRecord extends StandardRecord {
    private static final BitField automaticCategoryCrossing = null;
    private static final BitField automaticMajor = null;
    private static final BitField automaticMaximum = null;
    private static final BitField automaticMinimum = null;
    private static final BitField automaticMinor = null;
    private static final BitField crossCategoryAxisAtMaximum = null;
    private static final BitField logarithmicScale = null;
    private static final BitField reserved = null;
    private static final BitField valuesInReverse = null;
    private double field_1_minimumAxisValue;
    private double field_2_maximumAxisValue;
    private double field_3_majorIncrement;
    private double field_4_minorIncrement;
    private double field_5_categoryAxisCross;
    private short field_6_options;

    static {
        automaticMinimum = BitFieldFactory.getInstance(1);
        automaticMaximum = BitFieldFactory.getInstance(2);
        automaticMajor = BitFieldFactory.getInstance(4);
        automaticMinor = BitFieldFactory.getInstance(8);
        automaticCategoryCrossing = BitFieldFactory.getInstance(16);
        logarithmicScale = BitFieldFactory.getInstance(32);
        valuesInReverse = BitFieldFactory.getInstance(64);
        crossCategoryAxisAtMaximum = BitFieldFactory.getInstance(128);
        reserved = BitFieldFactory.getInstance(256);
    }

    public ValueRangeRecord() {
    }

    public ValueRangeRecord(RecordInputStream r3) {
        this.field_1_minimumAxisValue = r3.readDouble();
        this.field_2_maximumAxisValue = r3.readDouble();
        this.field_3_majorIncrement = r3.readDouble();
        this.field_4_minorIncrement = r3.readDouble();
        this.field_5_categoryAxisCross = r3.readDouble();
        this.field_6_options = r3.readShort();
    }

    public double getCategoryAxisCross() {
        return this.field_5_categoryAxisCross;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 42;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("minimumAxisValue", new $$Lambda$P7fM9W40U4lmaCzY9zyccWgZxNk(this), "maximumAxisValue", new $$Lambda$bel81S96k19eWwEmXy0kJCZYqOI(this), "majorIncrement", new $$Lambda$nth1waxiaaTXqotf8PtjySI_1bc(this), "minorIncrement", new $$Lambda$XA7Cktae9CtlaRImovPhg00YfY(this), "categoryAxisCross", new $$Lambda$PlFC3yNg2K4X7A5510ZZfHqjE6Q(this), "options", GenericRecordUtil.getBitsAsString(new $$Lambda$rmQBWadE8sRR4ftfHZiW3SyC_sM(this), new BitField[]{automaticMinimum, automaticMaximum, automaticMajor, automaticMinor, automaticCategoryCrossing, logarithmicScale, valuesInReverse, crossCategoryAxisAtMaximum, reserved}, new String[]{"AUTOMATIC_MINIMUM", "AUTOMATIC_MAXIMUM", "AUTOMATIC_MAJOR", "AUTOMATIC_MINOR", "AUTOMATIC_CATEGORY_CROSSING", "LOGARITHMIC_SCALE", "VALUES_IN_REVERSE", "CROSS_CATEGORY_AXIS_AT_MAXIMUM", "RESERVED"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VALUE_RANGE;
    }

    public double getMajorIncrement() {
        return this.field_3_majorIncrement;
    }

    public double getMaximumAxisValue() {
        return this.field_2_maximumAxisValue;
    }

    public double getMinimumAxisValue() {
        return this.field_1_minimumAxisValue;
    }

    public double getMinorIncrement() {
        return this.field_4_minorIncrement;
    }

    public short getOptions() {
        return this.field_6_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4127;
    }
}
