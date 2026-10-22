package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DrawingRecord extends StandardRecord {
    private static final byte[] EMPTY_BYTE_ARRAY = null;
    private byte[] contd;
    private byte[] recordData;

    static {
        EMPTY_BYTE_ARRAY = new byte[0];
    }

    public DrawingRecord() {
        this.recordData = EMPTY_BYTE_ARRAY;
    }

    public DrawingRecord(RecordInputStream r1) {
        this.recordData = r1.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.recordData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("recordData", new $$Lambda$2dNu84Wd9BTb3Cwn2EUm8SiKdw(this), "contd", new $$Lambda$DrawingRecord$8exBRQxJ3Q_cMB0L5j_8Knes1p4(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DRAWING;
    }

    public byte[] getRecordData() {
        return this.recordData;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 236;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$DrawingRecord() {
        return this.contd;
    }

    @Deprecated
    void processContinueRecord(byte[] r1) {
        this.contd = r1;
    }
}
