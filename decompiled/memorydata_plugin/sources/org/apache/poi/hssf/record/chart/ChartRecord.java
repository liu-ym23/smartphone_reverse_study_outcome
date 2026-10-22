package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartRecord extends StandardRecord {
    private int field_1_x;
    private int field_2_y;
    private int field_3_width;
    private int field_4_height;

    public ChartRecord() {
    }

    public ChartRecord(RecordInputStream r2) {
        this.field_1_x = r2.readInt();
        this.field_2_y = r2.readInt();
        this.field_3_width = r2.readInt();
        this.field_4_height = r2.readInt();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 16;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("x", new $$Lambda$gMCBNepa1stPvZYRGdzmjgj7Mbg(this), "y", new $$Lambda$REVmlLxEh6OptZgpZccQfW7iB8(this), "width", new $$Lambda$IogplGh1Baq79S_8R_uwGbZjc4(this), "height", new $$Lambda$ziwvOwTLQAwT4QME3AEQkD7qsSQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART;
    }

    public int getHeight() {
        return this.field_4_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4098;
    }

    public int getWidth() {
        return this.field_3_width;
    }

    public int getX() {
        return this.field_1_x;
    }

    public int getY() {
        return this.field_2_y;
    }
}
