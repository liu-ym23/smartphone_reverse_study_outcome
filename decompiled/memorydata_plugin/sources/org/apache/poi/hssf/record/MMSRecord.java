package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class MMSRecord extends StandardRecord {
    private byte field_1_addMenuCount;
    private byte field_2_delMenuCount;

    public MMSRecord() {
    }

    public MMSRecord(RecordInputStream r2) {
        if (r2.remaining() != 0) goto L5;
        return;
    L5:
        this.field_1_addMenuCount = r2.readByte();
        this.field_2_delMenuCount = r2.readByte();
    }

    public byte getAddMenuCount() {
        return this.field_1_addMenuCount;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public byte getDelMenuCount() {
        return this.field_2_delMenuCount;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("addMenuCount", new $$Lambda$AjjWE4l8BxL7aqJARGsRqKB8pY0(this), "delMenuCount", new $$Lambda$qa2nfs0O5i3t0jJKC8tRdlZ81Xc(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MMS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 193;
    }

    public void setAddMenuCount(byte r1) {
        this.field_1_addMenuCount = r1;
    }

    public void setDelMenuCount(byte r1) {
        this.field_2_delMenuCount = r1;
    }
}
