package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PaneRecord extends StandardRecord {
    private short field_1_x;
    private short field_2_y;
    private short field_3_topRow;
    private short field_4_leftColumn;
    private short field_5_activePane;

    public PaneRecord() {
    }

    public PaneRecord(RecordInputStream r2) {
        this.field_1_x = r2.readShort();
        this.field_2_y = r2.readShort();
        this.field_3_topRow = r2.readShort();
        this.field_4_leftColumn = r2.readShort();
        this.field_5_activePane = r2.readShort();
    }

    public short getActivePane() {
        return this.field_5_activePane;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 10;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("x", new $$Lambda$u2bxEk7z6CxgeWwj2kAHjUowT7A(this), "y", new $$Lambda$JSEZFcbcgA4eEGqHbzOWHqO05Zw(this), "topRow", new $$Lambda$hkI8JZGTNmWPnm6gUWxOa1Fiw(this), "leftColumn", new $$Lambda$CBuvWNsECFGbbY88gTU_OtCtxes(this), "activePane", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$VQ8jg7MhPsNMeBQOLIFpY7Q1_o(this), new int[]{0, 1, 2, 3}, new String[]{"LOWER_RIGHT", "UPPER_RIGHT", "LOWER_LEFT", "UPPER_LEFT"}));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PANE;
    }

    public short getLeftColumn() {
        return this.field_4_leftColumn;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 65;
    }

    public short getTopRow() {
        return this.field_3_topRow;
    }

    public short getX() {
        return this.field_1_x;
    }

    public short getY() {
        return this.field_2_y;
    }
}
