package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: loaded from: classes7.dex */
public final class MergedCellsTable extends RecordAggregate {
    private final List<CellRangeAddress> _mergedRegions;

    public MergedCellsTable() {
        this._mergedRegions = new ArrayList();
    }

    private void addMergeCellsRecord(MergeCellsRecord r5) {
        short r0 = r5.getNumAreas();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        CellRangeAddress r2 = r5.getAreaAt(r1);
        this._mergedRegions.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    private void checkIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= this._mergedRegions.size()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Specified CF index " + r4 + " is outside the allowable range (0.." + (this._mergedRegions.size() - 1) + ")");
    }

    public void addRecords(MergeCellsRecord[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addMergeCellsRecord(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    public CellRangeAddress get(int r2) {
        checkIndex(r2);
        return (CellRangeAddress) ZeusTransformUtils.preCheckCast(this._mergedRegions.get(r2), CellRangeAddress.class, "com.obric.memorydata.plugin");
    }

    public int getNumberOfMergedRegions() {
        return this._mergedRegions.size();
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        int r2 = this._mergedRegions.size();
        if (r2 >= 1) goto L6;
        return 0;
    L6:
        int r0 = r2 / 1027;
        return ((r0 * (CellRangeAddressList.getEncodedSize(1027) + 4)) + 4) + CellRangeAddressList.getEncodedSize(r2 % 1027);
    }

    public void read(RecordStream r6) {
    L3:
        if (r6.peekNextClass() != MergeCellsRecord.class) goto L7;
        MergeCellsRecord r0 = (MergeCellsRecord) ZeusTransformUtils.preCheckCast(r6.getNext(), MergeCellsRecord.class, "com.obric.memorydata.plugin");
        short r1 = r0.getNumAreas();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L3;
        CellRangeAddress r3 = r0.getAreaAt(r2);
        this._mergedRegions.add(r3);
        r2 = r2 + 1;
        goto L5
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r7) {
        RecordAggregate.RecordVisitor r8 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r7, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        int r0 = this._mergedRegions.size();
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r1 = r0 / 1027;
        int r2 = r0 % 1027;
        CellRangeAddress[] r3 = new CellRangeAddress[r0];
        this._mergedRegions.toArray(r3);
        int r6 = 0;
    L7:
        if (r6 >= r1) goto L9;
        r8.visitRecord(new MergeCellsRecord(r3, r6 * 1027, 1027));
        r6 = r6 + 1;
        goto L7
    L9:
        if (r2 <= 0) goto L13;
        r8.visitRecord(new MergeCellsRecord(r3, r1 * 1027, r2));
        return;
    }
}
