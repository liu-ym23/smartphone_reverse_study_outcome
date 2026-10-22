package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.DVALRecord;
import org.apache.poi.hssf.record.DVRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class DataValidityTable extends RecordAggregate {
    private final DVALRecord _headerRec;
    private final List<DVRecord> _validationList;

    public DataValidityTable() {
        this._headerRec = new DVALRecord();
        this._validationList = new ArrayList();
    }

    public DataValidityTable(RecordStream r5) {
        this._headerRec = (DVALRecord) ZeusTransformUtils.preCheckCast(r5.getNext(), DVALRecord.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
    L4:
        if (r5.peekNextClass() != DVRecord.class) goto L6;
        r0.add((DVRecord) ZeusTransformUtils.preCheckCast(r5.getNext(), DVRecord.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        this._validationList = r0;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r3) {
        final RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (this._validationList.isEmpty() == false) goto L5;
        return;
    L5:
        r4.visitRecord(this._headerRec);
        List<DVRecord> r2 = this._validationList;
        r4.getClass();
        r2.forEach(new $$Lambda$AvgxyyxiNrLRSyOOKtyADbiJag(r4));
    }
}
