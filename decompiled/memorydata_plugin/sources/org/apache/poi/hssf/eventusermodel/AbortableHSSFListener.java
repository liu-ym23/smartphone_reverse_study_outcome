package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbortableHSSFListener implements HSSFListener {
    public AbortableHSSFListener() {
    }

    public abstract short abortableProcessRecord(Record r1);
}
