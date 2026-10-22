package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CalcModeRecord extends StandardRecord {
    private short field_1_calcmode;

    public CalcModeRecord() {
    }

    public CalcModeRecord(RecordInputStream r1) {
        this.field_1_calcmode = r1.readShort();
    }

    public short getCalcMode() {
        return this.field_1_calcmode;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("calcMode", new $$Lambda$dAK_BFiFdzohCyEOyA3savexWos(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CALC_MODE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 13;
    }

    public void setCalcMode(short r1) {
        this.field_1_calcmode = r1;
    }
}
