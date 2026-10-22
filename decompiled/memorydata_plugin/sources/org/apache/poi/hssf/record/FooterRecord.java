package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes7.dex */
public final class FooterRecord extends HeaderFooterBase {
    public FooterRecord(String r1) {
        super(r1);
    }

    public FooterRecord(RecordInputStream r1) {
        super(r1);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FOOTER;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 21;
    }
}
