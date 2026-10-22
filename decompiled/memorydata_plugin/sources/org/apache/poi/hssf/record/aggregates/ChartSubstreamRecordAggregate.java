package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartSubstreamRecordAggregate extends RecordAggregate {
    private final BOFRecord _bofRec;
    private PageSettingsBlock _psBlock;
    private final List<RecordBase> _recs;

    public ChartSubstreamRecordAggregate(RecordStream r6) {
        this._bofRec = (BOFRecord) ZeusTransformUtils.preCheckCast(r6.getNext(), BOFRecord.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
    L4:
        if (r6.peekNextClass() == EOFRecord.class) goto L17;
        if (PageSettingsBlock.isComponentRecord(r6.peekNextSid()) == false) goto L15;
        if (this._psBlock != null) goto L10;
        PageSettingsBlock r1 = new PageSettingsBlock(r6);
        this._psBlock = r1;
        Object r2 = r1;
    L16:
        r0.add(r2);
        goto L4
    L10:
        if (r6.peekNextSid() != 2204) goto L13;
        this._psBlock.addLateHeaderFooter((HeaderFooterRecord) ZeusTransformUtils.preCheckCast(r6.getNext(), HeaderFooterRecord.class, "com.obric.memorydata.plugin"));
        goto L4
    L13:
        throw new IllegalStateException("Found more than one PageSettingsBlock in chart sub-stream, had sid: " + r6.peekNextSid());
    L15:
        r2 = r6.getNext();
        goto L16
    L17:
        this._recs = r0;
        if (ZeusTransformUtils.instanceOf(r6.getNext(), EOFRecord.class) == false) goto L21;
        return;
    L21:
        throw new IllegalStateException("Bad chart EOF");
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r4) {
        RecordAggregate.RecordVisitor r5 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (this._recs.isEmpty() == false) goto L5;
        return;
    L5:
        r5.visitRecord(this._bofRec);
        Iterator<RecordBase> r3 = this._recs.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        RecordBase r0 = (RecordBase) ZeusTransformUtils.preCheckCast(r3.next(), RecordBase.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, RecordAggregate.class) == true) goto L10;
        r5.visitRecord((Record) ZeusTransformUtils.preCheckCast(r0, Record.class, "com.obric.memorydata.plugin"));
        goto L7
    L10:
        ((RecordAggregate) ZeusTransformUtils.preCheckCast(r0, RecordAggregate.class, "com.obric.memorydata.plugin")).visitContainedRecords(r5);
        goto L7
    L12:
        r5.visitRecord(EOFRecord.instance);
    }
}
