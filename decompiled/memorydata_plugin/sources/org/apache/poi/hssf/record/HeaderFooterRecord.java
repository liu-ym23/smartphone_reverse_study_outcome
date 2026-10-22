package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HeaderFooterRecord extends StandardRecord {
    private static final byte[] BLANK_GUID = null;
    private byte[] _rawData;

    static {
        BLANK_GUID = new byte[16];
    }

    public HeaderFooterRecord(RecordInputStream r1) {
        this._rawData = r1.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rawData", new $$Lambda$HeaderFooterRecord$BTA1czQjLfMOS3kvXaDxTO7Nq2I(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.HEADER_FOOTER;
    }

    public byte[] getGuid() {
        return Arrays.copyOfRange(this._rawData, 12, 28);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2204;
    }

    public boolean isCurrentSheet() {
        return Arrays.equals(getGuid(), BLANK_GUID);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HeaderFooterRecord() {
        return this._rawData;
    }
}
