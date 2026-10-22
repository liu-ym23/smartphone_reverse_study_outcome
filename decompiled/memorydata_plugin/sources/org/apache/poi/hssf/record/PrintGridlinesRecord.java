package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PrintGridlinesRecord extends StandardRecord {
    private short field_1_print_gridlines;

    public PrintGridlinesRecord() {
    }

    public PrintGridlinesRecord(RecordInputStream r1) {
        this.field_1_print_gridlines = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("printGridlines", new $$Lambda$3Mq5PnpSxWgj_5q_dqAIDKRfF_g(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PRINT_GRIDLINES;
    }

    public boolean getPrintGridlines() {
        if (this.field_1_print_gridlines == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 43;
    }

    public void setPrintGridlines(boolean r1) {
        this.field_1_print_gridlines = r1 ? 1 : 0;
    }
}
