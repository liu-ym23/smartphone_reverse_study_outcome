package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class GutsRecord extends StandardRecord {
    private short field_1_left_row_gutter;
    private short field_2_top_col_gutter;
    private short field_3_row_level_max;
    private short field_4_col_level_max;

    public GutsRecord() {
    }

    public GutsRecord(RecordInputStream r2) {
        this.field_1_left_row_gutter = r2.readShort();
        this.field_2_top_col_gutter = r2.readShort();
        this.field_3_row_level_max = r2.readShort();
        this.field_4_col_level_max = r2.readShort();
    }

    public short getColLevelMax() {
        return this.field_4_col_level_max;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("leftGutter", new $$Lambda$u1yiKwRkhn3rNbAWyaDV9inINvw(this), "topGutter", new $$Lambda$6o5c0k4u_CkBnISO7yC5wHkJdpw(this), "rowLevelMax", new $$Lambda$IuLibvTOSK3pSaYP5l6I3Pk3EU0(this), "colLevelMax", new $$Lambda$QfpOZAGGxIH6oydcydwrjXnbBd0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.GUTS;
    }

    public short getLeftRowGutter() {
        return this.field_1_left_row_gutter;
    }

    public short getRowLevelMax() {
        return this.field_3_row_level_max;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 128;
    }

    public short getTopColGutter() {
        return this.field_2_top_col_gutter;
    }

    public void setColLevelMax(short r1) {
        this.field_4_col_level_max = r1;
    }

    public void setLeftRowGutter(short r1) {
        this.field_1_left_row_gutter = r1;
    }

    public void setRowLevelMax(short r1) {
        this.field_3_row_level_max = r1;
    }

    public void setTopColGutter(short r1) {
        this.field_2_top_col_gutter = r1;
    }
}
