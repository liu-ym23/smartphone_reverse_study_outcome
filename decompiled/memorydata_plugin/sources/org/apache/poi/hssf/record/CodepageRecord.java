package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CodepageRecord extends StandardRecord {
    private short field_1_codepage;

    public CodepageRecord() {
    }

    public CodepageRecord(RecordInputStream r1) {
        this.field_1_codepage = r1.readShort();
    }

    public short getCodepage() {
        return this.field_1_codepage;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("codepage", new $$Lambda$Zmh7RbGFiHmXmArow25k5T9zzh8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CODEPAGE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 66;
    }

    public void setCodepage(short r1) {
        this.field_1_codepage = r1;
    }
}
