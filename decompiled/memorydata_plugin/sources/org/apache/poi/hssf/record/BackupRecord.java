package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class BackupRecord extends StandardRecord {
    private short field_1_backup;

    public BackupRecord() {
    }

    public BackupRecord(RecordInputStream r1) {
        this.field_1_backup = r1.readShort();
    }

    public short getBackup() {
        return this.field_1_backup;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("backup", new $$Lambda$5MHdFyRvuVGrfeFO5jAee1QQW4(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BACKUP;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 64;
    }

    public void setBackup(short r1) {
        this.field_1_backup = r1;
    }
}
