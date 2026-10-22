package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public final class EOFRecord extends StandardRecord {
    public static final EOFRecord instance = null;

    static {
        instance = new EOFRecord();
    }

    private EOFRecord() {
    }

    public EOFRecord(RecordInputStream r1) {
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
        return HSSFRecordTypes.EOF;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 10;
    }
}
