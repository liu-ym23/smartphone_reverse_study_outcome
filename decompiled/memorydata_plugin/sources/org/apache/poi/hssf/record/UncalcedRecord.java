package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class UncalcedRecord extends StandardRecord {
    private short _reserved;

    public UncalcedRecord() {
        this._reserved = 0;
    }

    public UncalcedRecord(RecordInputStream r1) {
        this._reserved = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved", new $$Lambda$UncalcedRecord$mK2Hm2egvQXwW5EHgY7imkqWw5E(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.UNCALCED;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 94;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UncalcedRecord() {
        return Short.valueOf(this._reserved);
    }
}
