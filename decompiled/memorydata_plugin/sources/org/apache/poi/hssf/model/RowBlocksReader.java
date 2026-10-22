package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.MergeCellsRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.TableRecord;
import org.apache.poi.hssf.record.aggregates.SharedValueManager;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class RowBlocksReader {
    private final MergeCellsRecord[] _mergedCellsRecords;
    private final List<Record> _plainRecords;
    private final SharedValueManager _sfm;

    public RowBlocksReader(RecordStream r11) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Record r6 = null;
    L4:
        if (RecordOrderer.isEndOfRowBlock(r11.peekNextSid()) == true) goto L27;
        if (r11.hasNext() == false) goto L26;
        Record r7 = r11.getNext();
        short r8 = r7.getSid();
        if (r8 != 229) goto L10;
        ArrayList r9 = r5;
    L24:
        r9.add(r7);
        r6 = r7;
        goto L4
    L10:
        if (r8 != 545) goto L12;
        r9 = r3;
        goto L24
    L12:
        if (r8 != 566) goto L14;
        r9 = r4;
        goto L24
    L14:
        if (r8 == 1212) goto L17;
        r9 = r0;
        goto L24
    L17:
        if (ZeusTransformUtils.instanceOf(r6, FormulaRecord.class) == false) goto L20;
        FormulaRecord r10 = (FormulaRecord) ZeusTransformUtils.preCheckCast(r6, FormulaRecord.class, "com.obric.memorydata.plugin");
        r2.add(new CellReference(r10.getRow(), r10.getColumn()));
        r9 = r1;
        goto L24
    L20:
        throw new IllegalStateException("Shared formula record should follow a FormulaRecord, but had " + r6);
    L26:
        throw new IllegalStateException("Failed to find end of row/cell records");
    L27:
        SharedFormulaRecord[] r12 = new SharedFormulaRecord[r1.size()];
        CellReference[] r13 = new CellReference[r2.size()];
        ArrayRecord[] r14 = new ArrayRecord[r3.size()];
        TableRecord[] r15 = new TableRecord[r4.size()];
        r1.toArray(r12);
        r2.toArray(r13);
        r3.toArray(r14);
        r4.toArray(r15);
        this._plainRecords = r0;
        this._sfm = SharedValueManager.create(r12, r13, r14, r15);
        MergeCellsRecord[] r16 = new MergeCellsRecord[r5.size()];
        this._mergedCellsRecords = r16;
        r5.toArray(r16);
    }

    public MergeCellsRecord[] getLooseMergedCells() {
        return this._mergedCellsRecords;
    }

    public RecordStream getPlainRecordStream() {
        return new RecordStream(this._plainRecords, 0);
    }

    public SharedValueManager getSharedFormulaManager() {
        return this._sfm;
    }
}
