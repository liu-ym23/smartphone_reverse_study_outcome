package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeaderBase;

/* JADX INFO: loaded from: classes7.dex */
public final class ConditionalFormattingTable extends RecordAggregate {
    private final List<CFRecordsAggregate> _cfHeaders;

    public ConditionalFormattingTable() {
        this._cfHeaders = new ArrayList();
    }

    public ConditionalFormattingTable(RecordStream r3) {
        this._cfHeaders = new ArrayList();
    L4:
        if (ZeusTransformUtils.instanceOf(r3.peekNextRecord(), CFHeaderBase.class) == false) goto L6;
        this._cfHeaders.add(CFRecordsAggregate.createCFAggregate(r3));
        goto L4
    }

    private void checkIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= this._cfHeaders.size()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Specified CF index " + r4 + " is outside the allowable range (0.." + (this._cfHeaders.size() - 1) + ")");
    }

    public CFRecordsAggregate get(int r2) {
        checkIndex(r2);
        return (CFRecordsAggregate) ZeusTransformUtils.preCheckCast(this._cfHeaders.get(r2), CFRecordsAggregate.class, "com.obric.memorydata.plugin");
    }

    public int size() {
        return this._cfHeaders.size();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r4) {
        RecordAggregate.RecordVisitor r5 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        Iterator<CFRecordsAggregate> r3 = this._cfHeaders.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((CFRecordsAggregate) ZeusTransformUtils.preCheckCast(r3.next(), CFRecordsAggregate.class, "com.obric.memorydata.plugin")).visitContainedRecords(r5);
        goto L4
    }
}
