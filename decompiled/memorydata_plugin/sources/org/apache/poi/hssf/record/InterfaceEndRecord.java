package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class InterfaceEndRecord extends StandardRecord {
    public static final InterfaceEndRecord instance = null;

    static {
        instance = new InterfaceEndRecord();
    }

    private InterfaceEndRecord() {
    }

    public static Record create(RecordInputStream r3) {
        int r0 = r3.remaining();
        if (r0 == 0) goto L11;
        if (r0 != 2) goto L9;
        return new InterfaceHdrRecord(r3);
    L9:
        throw new RecordFormatException("Invalid record data size: " + r3.remaining());
    L11:
        return instance;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.INTERFACE_END;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 226;
    }
}
