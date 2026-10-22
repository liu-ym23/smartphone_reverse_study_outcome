package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final class WriteProtectRecord extends StandardRecord {
    public WriteProtectRecord() {
    }

    public WriteProtectRecord(RecordInputStream r2) {
        if (r2.remaining() != 2) goto L6;
        r2.readShort();
        return;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WRITE_PROTECT;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 134;
    }
}
