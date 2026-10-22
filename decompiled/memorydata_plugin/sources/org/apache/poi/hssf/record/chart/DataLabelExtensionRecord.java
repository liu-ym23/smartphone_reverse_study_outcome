package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DataLabelExtensionRecord extends StandardRecord {
    private int grbitFrt;
    private int rt;
    private final byte[] unused;

    public DataLabelExtensionRecord(RecordInputStream r3) {
        byte[] r0 = new byte[8];
        this.unused = r0;
        this.rt = r3.readShort();
        this.grbitFrt = r3.readShort();
        r3.readFully(r0);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$DataLabelExtensionRecord$1OuVMFGIbjogo_pKs7gQEouWoro(this), "grbitFrt", new $$Lambda$DataLabelExtensionRecord$oOCFT5UWI2vx35iUtaV_kS3Zmfo(this), "unused", new $$Lambda$DataLabelExtensionRecord$QR_AtrDToVQ7FBTATJtr6_r0rI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DATA_LABEL_EXTENSION;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2154;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DataLabelExtensionRecord() {
        return Integer.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$DataLabelExtensionRecord() {
        return Integer.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$DataLabelExtensionRecord() {
        return this.unused;
    }
}
