package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class CFHeaderRecord extends CFHeaderBase {
    public CFHeaderRecord() {
        createEmpty();
    }

    public CFHeaderRecord(RecordInputStream r1) {
        read(r1);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_HEADER;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 432;
    }
}
