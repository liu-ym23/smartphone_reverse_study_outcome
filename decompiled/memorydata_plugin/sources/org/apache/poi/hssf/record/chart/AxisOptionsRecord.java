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
public final class AxisOptionsRecord extends StandardRecord {
    private static final int[] FLAG_MASKS = null;
    private static final String[] FLAG_NAMES = null;
    private static final BitField defaultBase = null;
    private static final BitField defaultCross = null;
    private static final BitField defaultDateSettings = null;
    private static final BitField defaultMajor = null;
    private static final BitField defaultMaximum = null;
    private static final BitField defaultMinimum = null;
    private static final BitField defaultMinorUnit = null;
    private static final BitField isDate = null;
    private short field_1_minimumCategory;
    private short field_2_maximumCategory;
    private short field_3_majorUnitValue;
    private short field_4_majorUnit;
    private short field_5_minorUnitValue;
    private short field_6_minorUnit;
    private short field_7_baseUnit;
    private short field_8_crossingPoint;
    private short field_9_options;

    static {
        defaultMinimum = BitFieldFactory.getInstance(1);
        defaultMaximum = BitFieldFactory.getInstance(2);
        defaultMajor = BitFieldFactory.getInstance(4);
        defaultMinorUnit = BitFieldFactory.getInstance(8);
        isDate = BitFieldFactory.getInstance(16);
        defaultBase = BitFieldFactory.getInstance(32);
        defaultCross = BitFieldFactory.getInstance(64);
        defaultDateSettings = BitFieldFactory.getInstance(128);
        FLAG_MASKS = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        FLAG_NAMES = new String[]{"DEFAULT_MINIMUM", "DEFAULT_MAXIMUM", "DEFAULT_MAJOR", "DEFAULT_MINOR_UNIT", "IS_DATE", "DEFAULT_BASE", "DEFAULT_CROSS", "DEFAULT_DATE_SETTINGS"};
    }

    public AxisOptionsRecord() {
    }

    public AxisOptionsRecord(RecordInputStream r2) {
        this.field_1_minimumCategory = r2.readShort();
        this.field_2_maximumCategory = r2.readShort();
        this.field_3_majorUnitValue = r2.readShort();
        this.field_4_majorUnit = r2.readShort();
        this.field_5_minorUnitValue = r2.readShort();
        this.field_6_minorUnit = r2.readShort();
        this.field_7_baseUnit = r2.readShort();
        this.field_8_crossingPoint = r2.readShort();
        this.field_9_options = r2.readShort();
    }

    public short getBaseUnit() {
        return this.field_7_baseUnit;
    }

    public short getCrossingPoint() {
        return this.field_8_crossingPoint;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("minimumCategory", new $$Lambda$0xGwxJ0kPBtWOMYfxxcI2875gs(this), "maximumCategory", new $$Lambda$ewpx8VisdD7UaWdFgFDfppr68dg(this), "majorUnitValue", new $$Lambda$hyOUufbySyvkbBlnqKQgo0UgQg(this), "majorUnit", new $$Lambda$P6O4NZVY230SUcbYRbFAdotDDFU(this), "minorUnitValue", new $$Lambda$LY1Cbg2dZPsgKDq1RGq9vcZSjc(this), "minorUnit", new $$Lambda$eZvJdUoMuf9EoS7eztyWZjtuAEk(this), "baseUnit", new $$Lambda$ucWn3D8Lcr3HTGDinth2dqKoXPU(this), "crossingPoint", new $$Lambda$UInatei7lWtSJ3O46cgnWJZUXM(this), "options", GenericRecordUtil.getBitsAsString(new $$Lambda$Q3yGs55fXWEefn1wkLom8DTHLQ(this), FLAG_MASKS, FLAG_NAMES));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS_OPTIONS;
    }

    public short getMajorUnit() {
        return this.field_4_majorUnit;
    }

    public short getMajorUnitValue() {
        return this.field_3_majorUnitValue;
    }

    public short getMaximumCategory() {
        return this.field_2_maximumCategory;
    }

    public short getMinimumCategory() {
        return this.field_1_minimumCategory;
    }

    public short getMinorUnit() {
        return this.field_6_minorUnit;
    }

    public short getMinorUnitValue() {
        return this.field_5_minorUnitValue;
    }

    public short getOptions() {
        return this.field_9_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4194;
    }
}
