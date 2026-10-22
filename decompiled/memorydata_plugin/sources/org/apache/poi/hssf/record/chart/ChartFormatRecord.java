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
public final class ChartFormatRecord extends StandardRecord {
    private static final BitField varyDisplayPattern = null;
    private int field1_x_position;
    private int field2_y_position;
    private int field3_width;
    private int field4_height;
    private int field5_grbit;
    private int field6_unknown;

    static {
        varyDisplayPattern = BitFieldFactory.getInstance(1);
    }

    public ChartFormatRecord() {
    }

    public ChartFormatRecord(RecordInputStream r2) {
        this.field1_x_position = r2.readInt();
        this.field2_y_position = r2.readInt();
        this.field3_width = r2.readInt();
        this.field4_height = r2.readInt();
        this.field5_grbit = r2.readUShort();
        this.field6_unknown = r2.readUShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 20;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("x", new $$Lambda$1TnsivMbvvKVwBH8J6ac0V4_uk(this), "y", new $$Lambda$04mlxvhKkECeZsH0dInzbCvYSog(this), "width", new $$Lambda$0wVi4czhza8bDt2DtgJ_wtcwcV0(this), "height", new $$Lambda$JP7mTCHMVfiqRatOBHQmTqzbMtU(this), "grbit", new $$Lambda$ChartFormatRecord$30ZZMHkgQKUG5Gz_41MvRlK9iGg(this), "varyDisplayPattern", new $$Lambda$3kVLQ0Nr75D_0EdwkwRrljQGzk(this), "unknown", new $$Lambda$ChartFormatRecord$o9n2KDvcJ8DZcq4sQl73emJTM(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_FORMAT;
    }

    public int getHeight() {
        return this.field4_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4116;
    }

    public boolean getVaryDisplayPattern() {
        return varyDisplayPattern.isSet(this.field5_grbit);
    }

    public int getWidth() {
        return this.field3_width;
    }

    public int getXPosition() {
        return this.field1_x_position;
    }

    public int getYPosition() {
        return this.field2_y_position;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ChartFormatRecord() {
        return Integer.valueOf(this.field5_grbit);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartFormatRecord() {
        return Integer.valueOf(this.field6_unknown);
    }
}
