package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class InterfaceHdrRecord extends StandardRecord {
    private final int _codepage;

    public InterfaceHdrRecord(int r1) {
        this._codepage = r1;
    }

    public InterfaceHdrRecord(RecordInputStream r1) {
        this._codepage = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("codePage", new $$Lambda$InterfaceHdrRecord$_FvhXJk1lwaIXoFOs523w80IdRA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.INTERFACE_HDR;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 225;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$InterfaceHdrRecord() {
        return Integer.valueOf(this._codepage);
    }
}
