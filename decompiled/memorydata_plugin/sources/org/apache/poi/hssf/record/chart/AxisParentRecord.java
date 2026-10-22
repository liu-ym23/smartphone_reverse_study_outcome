package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class AxisParentRecord extends StandardRecord {
    private short field_1_axisType;
    private int field_2_x;
    private int field_3_y;
    private int field_4_width;
    private int field_5_height;

    public AxisParentRecord() {
    }

    public AxisParentRecord(RecordInputStream r2) {
        this.field_1_axisType = r2.readShort();
        this.field_2_x = r2.readInt();
        this.field_3_y = r2.readInt();
        this.field_4_width = r2.readInt();
        this.field_5_height = r2.readInt();
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("axisType", new $$Lambda$dn3mFKgIw2ZBpD4DYs5IFOuXk(this), "x", new $$Lambda$SA2MJbx5SfbgjOWvtCAZNtwTw(this), "y", new $$Lambda$8mAa5p5l9n7_wuX0x9YF5xAFo9U(this), "width", new $$Lambda$OFlqMw8DbSZLJSgMFDyKP69WrW0(this), "height", new $$Lambda$b43y6j_KnjkKNlWO5g7kXtG6e8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.AXIS_PARENT;
    }

    public int getHeight() {
        return this.field_5_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4161;
    }

    public int getWidth() {
        return this.field_4_width;
    }

    public int getX() {
        return this.field_2_x;
    }

    public int getY() {
        return this.field_3_y;
    }
}
