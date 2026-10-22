package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class RecalcIdRecord extends StandardRecord {
    private int _engineId;
    private final int _reserved0;

    public RecalcIdRecord() {
        this._reserved0 = 0;
        this._engineId = 0;
    }

    public RecalcIdRecord(RecordInputStream r2) {
        r2.readUShort();
        this._reserved0 = r2.readUShort();
        this._engineId = r2.readInt();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 8;
    }

    public int getEngineId() {
        return this._engineId;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved0", new $$Lambda$RecalcIdRecord$SCucpQasHk3HMSEBIawdYOei7zw(this), "engineId", new $$Lambda$zJ6lB71Fjl3OtG8GhEtBZhO6g(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.RECALC_ID;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 449;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$RecalcIdRecord() {
        return Integer.valueOf(this._reserved0);
    }
}
