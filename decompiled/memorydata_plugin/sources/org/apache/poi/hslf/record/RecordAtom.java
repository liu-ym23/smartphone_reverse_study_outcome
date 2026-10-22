package org.apache.poi.hslf.record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class RecordAtom extends Record {
    private static int MAX_RECORD_LENGTH = 1000000;

    static {
    }

    public RecordAtom() {
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    @Override // org.apache.poi.hslf.record.Record
    public Record[] getChildRecords() {
        return null;
    }
}
