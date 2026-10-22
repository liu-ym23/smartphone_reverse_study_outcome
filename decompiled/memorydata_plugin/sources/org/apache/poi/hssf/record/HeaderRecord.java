package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class HeaderRecord extends HeaderFooterBase {
    public HeaderRecord(String r1) {
        super(r1);
    }

    public HeaderRecord(RecordInputStream r1) {
        super(r1);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HEADER;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 20;
    }
}
