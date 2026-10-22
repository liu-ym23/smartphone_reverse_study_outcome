package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PrintHeadersRecord extends StandardRecord {
    private short field_1_print_headers;

    public PrintHeadersRecord() {
    }

    public PrintHeadersRecord(RecordInputStream r1) {
        this.field_1_print_headers = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("printHeaders", new $$Lambda$dIBoytaFxo0gAWaGncD0rpYCw(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PRINT_HEADERS;
    }

    public boolean getPrintHeaders() {
        if (this.field_1_print_headers == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 42;
    }

    public void setPrintHeaders(boolean r1) {
        if (r1 == false) goto L4;
        short r2 = 1;
    L5:
        this.field_1_print_headers = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }
}
