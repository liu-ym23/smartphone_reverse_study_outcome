package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class BlankRecord extends StandardRecord implements CellValueRecordInterface {
    private int field_1_row;
    private short field_2_col;
    private short field_3_xf;

    public BlankRecord() {
    }

    public BlankRecord(RecordInputStream r2) {
        this.field_1_row = r2.readUShort();
        this.field_2_col = r2.readShort();
        this.field_3_xf = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_col;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$nGEjlgfS3VBbX2JprYKfEG6dFWQ(this), "col", new $$Lambda$b5A4B9OcE_izr1qjAAH7huTmgYI(this), "xfIndex", new $$Lambda$JWV4qAIyMKY0ydyt8FeKsFl4Gk(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BLANK;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 513;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf;
    }

    public void setColumn(short r1) {
        this.field_2_col = r1;
    }

    public void setRow(int r1) {
        this.field_1_row = r1;
    }

    public void setXFIndex(short r1) {
        this.field_3_xf = r1;
    }
}
