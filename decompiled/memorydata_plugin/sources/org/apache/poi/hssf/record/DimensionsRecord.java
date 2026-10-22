package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DimensionsRecord extends StandardRecord {
    private static final c LOG = null;
    private int field_1_first_row;
    private int field_2_last_row;
    private short field_3_first_col;
    private short field_4_last_col;
    private short field_5_zero;

    static {
        LOG = b.a(DimensionsRecord.class);
    }

    public DimensionsRecord() {
    }

    public DimensionsRecord(RecordInputStream r2) {
        this.field_1_first_row = r2.readInt();
        this.field_2_last_row = r2.readInt();
        this.field_3_first_col = r2.readShort();
        this.field_4_last_col = r2.readShort();
        this.field_5_zero = r2.readShort();
        if (r2.available() != 2) goto L6;
        LOG.atInfo().a("DimensionsRecord has extra 2 bytes.");
        r2.readShort();
        return;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 14;
    }

    public short getFirstCol() {
        return this.field_3_first_col;
    }

    public int getFirstRow() {
        return this.field_1_first_row;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("firstRow", new $$Lambda$DsRYjO3dic8P5M01gavoQoxFxw(this), "lastRow", new $$Lambda$sQ6BL1giEfFdBMsDbOZNE2HuuI(this), "firstColumn", new $$Lambda$D0DGApPSP1V9kwGOrQZvvtkUag(this), "lastColumn", new $$Lambda$GRP8SqX_3ZKaI35YwVjlgg4g38(this), "zero", new $$Lambda$DimensionsRecord$ZQ6G9MrkplyYyeDvCchkAhKDu7E(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DIMENSIONS;
    }

    public short getLastCol() {
        return this.field_4_last_col;
    }

    public int getLastRow() {
        return this.field_2_last_row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 512;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DimensionsRecord() {
        return Short.valueOf(this.field_5_zero);
    }

    public void setFirstCol(short r1) {
        this.field_3_first_col = r1;
    }

    public void setFirstRow(int r1) {
        this.field_1_first_row = r1;
    }

    public void setLastCol(short r1) {
        this.field_4_last_col = r1;
    }

    public void setLastRow(int r1) {
        this.field_2_last_row = r1;
    }
}
