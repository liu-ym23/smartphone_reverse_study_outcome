package org.apache.poi.hssf.eventusermodel.dummyrecord;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
abstract class DummyRecordBase extends Record {
    public DummyRecordBase() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        throw new RecordFormatException("Cannot serialize a dummy record");
    }

    @Override // org.apache.poi.hssf.record.Record
    public final short getSid() {
        return -1;
    }
}
