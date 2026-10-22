package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: classes7.dex */
public final class CustomViewSettingsRecordAggregate extends RecordAggregate {
    private final Record _begin;
    private final Record _end;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _recs;

    public CustomViewSettingsRecordAggregate(RecordStream r6) {
        Record r0 = r6.getNext();
        this._begin = r0;
        if (r0.getSid() != 426) goto L25;
        ArrayList r1 = new ArrayList();
    L6:
        if (r6.peekNextSid() == 427) goto L19;
        if (PageSettingsBlock.isComponentRecord(r6.peekNextSid()) == false) goto L17;
        if (this._psBlock != null) goto L12;
        PageSettingsBlock r2 = new PageSettingsBlock(r6);
        this._psBlock = r2;
        Object r3 = r2;
    L18:
        r1.add(r3);
        goto L6
    L12:
        if (r6.peekNextSid() != 2204) goto L15;
        this._psBlock.addLateHeaderFooter((HeaderFooterRecord) ZeusTransformUtils.preCheckCast(r6.getNext(), HeaderFooterRecord.class, "com.obric.memorydata.plugin"));
        goto L6
    L15:
        throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + r6.peekNextSid());
    L17:
        r3 = r6.getNext();
        goto L18
    L19:
        this._recs = r1;
        Record r7 = r6.getNext();
        this._end = r7;
        if (r7.getSid() != 427) goto L23;
        return;
    L23:
        throw new IllegalStateException("Bad custom view settings end record");
    L25:
        throw new IllegalStateException("Bad begin record");
    }

    public static boolean isBeginRecord(int r1) {
        if (r1 != 426) goto L5;
        return true;
    L5:
        return false;
    }

    public void append(RecordBase r1) {
        this._recs.add(r1);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r5) {
        RecordAggregate.RecordVisitor r6 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r5, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (this._recs.isEmpty() == false) goto L5;
        return;
    L5:
        r6.visitRecord(this._begin);
        Iterator<RecordBase> r0 = this._recs.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        RecordBase r2 = (RecordBase) ZeusTransformUtils.preCheckCast(r0.next(), RecordBase.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, RecordAggregate.class) == true) goto L10;
        r6.visitRecord((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin"));
        goto L7
    L10:
        ((RecordAggregate) ZeusTransformUtils.preCheckCast(r2, RecordAggregate.class, "com.obric.memorydata.plugin")).visitContainedRecords(r6);
        goto L7
    L12:
        r6.visitRecord(this._end);
    }
}
