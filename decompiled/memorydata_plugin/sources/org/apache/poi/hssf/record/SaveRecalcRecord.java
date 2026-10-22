package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SaveRecalcRecord extends StandardRecord {
    private short field_1_recalc;

    public SaveRecalcRecord() {
    }

    public SaveRecalcRecord(RecordInputStream r1) {
        this.field_1_recalc = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("recalc", new $$Lambda$z9BYw3SiytMnZuvXgdCW6eSrIi0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SAVE_RECALC;
    }

    public boolean getRecalc() {
        if (this.field_1_recalc == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 95;
    }

    public void setRecalc(boolean r1) {
        this.field_1_recalc = r1 ? 1 : 0;
    }
}
