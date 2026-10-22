package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class HorizontalPageBreakRecord extends PageBreakRecord {
    public HorizontalPageBreakRecord() {
    }

    public HorizontalPageBreakRecord(RecordInputStream r1) {
        super(r1);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HORIZONTAL_PAGE_BREAK;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 27;
    }
}
