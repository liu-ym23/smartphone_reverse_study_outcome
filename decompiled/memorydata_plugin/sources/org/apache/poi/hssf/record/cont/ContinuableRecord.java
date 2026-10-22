package org.apache.poi.hssf.record.cont;

import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ContinuableRecord extends Record {
    public ContinuableRecord() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        ContinuableRecordOutput r0 = ContinuableRecordOutput.createForCountingOnly();
        serialize(r0);
        r0.terminate();
        return r0.getTotalSize();
    }

    public abstract void serialize(ContinuableRecordOutput r1);
}
