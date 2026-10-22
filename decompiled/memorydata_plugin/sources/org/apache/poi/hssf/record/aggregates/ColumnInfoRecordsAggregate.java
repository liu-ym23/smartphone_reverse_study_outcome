package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ColumnInfoRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class ColumnInfoRecordsAggregate extends RecordAggregate {
    private final List<ColumnInfoRecord> records;

    public ColumnInfoRecordsAggregate() {
        this.records = new ArrayList();
    }

    public ColumnInfoRecordsAggregate(RecordStream r7) {
        this();
        ColumnInfoRecord r1 = null;
        boolean r2 = true;
    L4:
        if (r7.peekNextClass() != ColumnInfoRecord.class) goto L12;
        ColumnInfoRecord r3 = (ColumnInfoRecord) ZeusTransformUtils.preCheckCast(r7.getNext(), ColumnInfoRecord.class, "com.obric.memorydata.plugin");
        this.records.add(r3);
        if (r1 == null) goto L10;
        if (compareColInfos(r1, r3) <= 0) goto L10;
        r2 = false;
    L10:
        r1 = r3;
        goto L4
    L12:
        if (this.records.size() < 1) goto L17;
        if (r2 == true) goto L22;
        this.records.sort($$Lambda$ColumnInfoRecordsAggregate$Z7AxgHlaGYKDWdBaaI3TMLnq9M.INSTANCE);
        return;
    L22:
        return;
    L17:
        throw new RuntimeException("No column info records found");
    }

    private static int compareColInfos(ColumnInfoRecord r0, ColumnInfoRecord r1) {
        return r0.getFirstColumn() - r1.getFirstColumn();
    }

    private ColumnInfoRecord getColInfo(int r2) {
        return (ColumnInfoRecord) ZeusTransformUtils.preCheckCast(this.records.get(r2), ColumnInfoRecord.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$Z7AxgHlaGYKDWdBaaI3TM-Lnq9M, reason: not valid java name */
    public static /* synthetic */ int m3161lambda$Z7AxgHlaGYKDWdBaaI3TMLnq9M(ColumnInfoRecord r0, ColumnInfoRecord r1) {
        return compareColInfos(r0, r1);
    }

    public ColumnInfoRecord findColumnInfo(int r5) {
        int r0 = this.records.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ColumnInfoRecord r2 = getColInfo(r1);
        if (r2.containsColumn(r5) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r5) {
        RecordAggregate.RecordVisitor r6 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r5, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (this.records.size() >= 1) goto L5;
        return;
    L5:
        ColumnInfoRecord r0 = null;
        Iterator<ColumnInfoRecord> r4 = this.records.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        ColumnInfoRecord r2 = (ColumnInfoRecord) ZeusTransformUtils.preCheckCast(r4.next(), ColumnInfoRecord.class, "com.obric.memorydata.plugin");
        r6.visitRecord(r2);
        if (r0 == null) goto L15;
        if (compareColInfos(r0, r2) <= 0) goto L15;
        throw new RuntimeException("Column info records are out of order");
    L15:
        r0 = r2;
        goto L7
    }
}
