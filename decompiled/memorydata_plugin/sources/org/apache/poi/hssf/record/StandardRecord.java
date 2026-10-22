package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StandardRecord extends Record {
    public StandardRecord() {
    }

    public abstract int getDataSize();

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        return getDataSize() + 4;
    }
}
