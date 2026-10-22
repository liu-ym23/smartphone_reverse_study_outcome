package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.ss.SpreadsheetVersion;

/* JADX INFO: loaded from: classes7.dex */
public final class RowRecordsAggregate extends RecordAggregate {
    private int _firstrow;
    private int _lastrow;
    private RowRecord[] _rowRecordValues;
    private final Map<Integer, RowRecord> _rowRecords;
    private final SharedValueManager _sharedValueManager;
    private final List<Record> _unknownRecords;
    private final ValueRecordsAggregate _valuesAgg;

    public RowRecordsAggregate() {
        this(SharedValueManager.createEmpty());
    }

    public RowRecordsAggregate(RecordStream r5, SharedValueManager r6) {
        this(r6);
    L4:
        if (r5.hasNext() == false) goto L28;
        Record r0 = r5.getNext();
        short r1 = r0.getSid();
        if (r1 != 81) goto L8;
        addUnknownRecord(r0);
        goto L4
    L8:
        if (r1 == 215) goto L4;
        if (r1 == 440) goto L4;
        if (r1 != 520) goto L14;
        insertRow((RowRecord) ZeusTransformUtils.preCheckCast(r0, RowRecord.class, "com.obric.memorydata.plugin"));
        goto L4
    L14:
        if (ZeusTransformUtils.instanceOf(r0, UnknownRecord.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r0, MulBlankRecord.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r0, CellValueRecordInterface.class) == false) goto L25;
        this._valuesAgg.construct((CellValueRecordInterface) ZeusTransformUtils.preCheckCast(r0, CellValueRecordInterface.class, "com.obric.memorydata.plugin"), r5, r6);
        goto L4
    L25:
        throw new IllegalArgumentException("Unexpected record type (" + r0.getClass().getName() + ")");
    L20:
        this._valuesAgg.addMultipleBlanks((MulBlankRecord) ZeusTransformUtils.preCheckCast(r0, MulBlankRecord.class, "com.obric.memorydata.plugin"));
    L15:
        addUnknownRecord(r0);
        if (r5.peekNextSid() != 60) goto L4;
        r0 = r5.getNext();
        goto L15
    }

    private RowRecordsAggregate(SharedValueManager r2) {
        this._firstrow = -1;
        this._lastrow = -1;
        if (r2 == null) goto L7;
        this._rowRecords = new TreeMap();
        this._valuesAgg = new ValueRecordsAggregate();
        this._unknownRecords = new ArrayList();
        this._sharedValueManager = r2;
        return;
    L7:
        throw new IllegalArgumentException("SharedValueManager must be provided.");
    }

    private void addUnknownRecord(Record r1) {
        this._unknownRecords.add(r1);
    }

    private int getEndRowNumberForBlock(int r5) {
        int r0 = ((r5 + 1) * 32) - 1;
        if (r0 < this._rowRecords.size()) goto L6;
        r0 = this._rowRecords.size() - 1;
    L6:
        if (this._rowRecordValues != null) goto L12;
        this._rowRecordValues = (RowRecord[]) ZeusTransformUtils.preCheckCast(this._rowRecords.values().toArray(new RowRecord[0]), RowRecord[].class, "com.obric.memorydata.plugin");
    L12:
        return this._rowRecordValues[r0].getRowNumber();
    L11:
        throw new IllegalArgumentException("Did not find end row for block " + r5);
    }

    private int getStartRowNumberForBlock(int r5) {
        int r0 = r5 * 32;
        if (this._rowRecordValues != null) goto L9;
        this._rowRecordValues = (RowRecord[]) ZeusTransformUtils.preCheckCast(this._rowRecords.values().toArray(new RowRecord[0]), RowRecord[].class, "com.obric.memorydata.plugin");
    L9:
        return this._rowRecordValues[r0].getRowNumber();
    L8:
        throw new IllegalArgumentException("Did not find start row for block " + r5);
    }

    private static short[] shortListToArray(List<Short> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        short[] r0 = new short[r6.size()];
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r2] = ((Short) ZeusTransformUtils.preCheckCast(r7.next(), Short.class, "com.obric.memorydata.plugin")).shortValue();
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    private int visitRowRecordsForBlock(int r6, RecordAggregate.RecordVisitor r7) {
        RecordAggregate.RecordVisitor r8 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r7, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        int r9 = r6 * 32;
        int r0 = r9 + 32;
        Iterator<RowRecord> r5 = this._rowRecords.values().iterator();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r9) goto L6;
        r5.next();
        r3 = r3 + 1;
    L6:
        if (r5.hasNext() == false) goto L10;
        int r10 = r3 + 1;
        if (r3 >= r0) goto L10;
        Record r4 = (Record) ZeusTransformUtils.preCheckCast(r5.next(), Record.class, "com.obric.memorydata.plugin");
        r2 = r2 + r4.getRecordSize();
        r8.visitRecord(r4);
        r3 = r10;
    L10:
        return r2;
    }

    public DimensionsRecord createDimensions() {
        DimensionsRecord r0 = new DimensionsRecord();
        r0.setFirstRow(this._firstrow);
        r0.setLastRow(this._lastrow);
        r0.setFirstCol((short) this._valuesAgg.getFirstCellNum());
        r0.setLastCol((short) this._valuesAgg.getLastCellNum());
        return r0;
    }

    public FormulaRecordAggregate createFormula(int r2, int r3) {
        FormulaRecord r0 = new FormulaRecord();
        r0.setRow(r2);
        r0.setColumn((short) r3);
        return new FormulaRecordAggregate(r0, null, this._sharedValueManager);
    }

    public Iterator<CellValueRecordInterface> getCellValueIterator() {
        return this._valuesAgg.iterator();
    }

    public Iterator<RowRecord> getIterator() {
        return this._rowRecords.values().iterator();
    }

    public RowRecord getRow(int r4) {
        int r0 = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (r4 < 0) goto L8;
        if (r4 > r0) goto L8;
        return (RowRecord) ZeusTransformUtils.preCheckCast(this._rowRecords.get(Integer.valueOf(r4)), RowRecord.class, "com.obric.memorydata.plugin");
    L8:
        throw new IllegalArgumentException("The row number must be between 0 and " + r0 + ", but had: " + r4);
    }

    public int getRowBlockCount() {
        int r0 = this._rowRecords.size() / 32;
        if ((this._rowRecords.size() % 32) != 0) goto L5;
        return r0;
    L5:
        return r0 + 1;
    }

    public void insertCell(CellValueRecordInterface r3) {
        CellValueRecordInterface r4 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r3, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        this._valuesAgg.insertCell(r4);
    }

    public void insertRow(RowRecord r4) {
        this._rowRecords.put(Integer.valueOf(r4.getRowNumber()), r4);
        this._rowRecordValues = null;
        int r0 = r4.getRowNumber();
        int r1 = this._firstrow;
        if (r0 < r1) goto L5;
        if (r1 == (-1)) goto L5;
    L6:
        int r2 = r4.getRowNumber();
        int r3 = this._lastrow;
        if (r2 > r3) goto L9;
        if (r3 == (-1)) goto L9;
        return;
    L9:
        this._lastrow = r4.getRowNumber();
        return;
    L5:
        this._firstrow = r4.getRowNumber();
        goto L6
    }

    public void removeCell(CellValueRecordInterface r3) {
        CellValueRecordInterface r4 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r3, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, FormulaRecordAggregate.class) == false) goto L5;
        ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(r4, FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).notifyFormulaChanging();
    L5:
        this._valuesAgg.removeCell(r4);
    }

    public void removeRow(RowRecord r5) {
        int r0 = r5.getRowNumber();
        this._valuesAgg.removeAllCellsValuesForRow(r0);
        RowRecord r1 = (RowRecord) ZeusTransformUtils.preCheckCast(this._rowRecords.remove(Integer.valueOf(r0)), RowRecord.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L10;
        if (r5 != r1) goto L7;
        this._rowRecordValues = null;
        return;
    L7:
        this._rowRecords.put(Integer.valueOf(r0), r1);
        throw new IllegalArgumentException("Attempt to remove row that does not belong to this sheet");
    L10:
        throw new IllegalArgumentException("Invalid row index (" + r0 + ")");
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r11) {
        final RecordAggregate.RecordVisitor r12 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r11, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        RecordAggregate.PositionTrackingVisitor r0 = new RecordAggregate.PositionTrackingVisitor(r12, 0);
        int r2 = getRowBlockCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        int r4 = visitRowRecordsForBlock(r3, r12);
        int r5 = r4 + 0;
        int r6 = getStartRowNumberForBlock(r3);
        int r7 = getEndRowNumberForBlock(r3);
        ArrayList r8 = new ArrayList();
        int r9 = r4 - 20;
    L5:
        if (r6 > r7) goto L10;
        if (this._valuesAgg.rowHasCells(r6) == false) goto L9;
        r0.setPosition(0);
        this._valuesAgg.visitCellsForRow(r6, r0);
        int r10 = r0.getPosition();
        r5 = r5 + r10;
        r8.add(Short.valueOf((short) r9));
        r9 = r10;
    L9:
        r6 = r6 + 1;
        goto L5
    L10:
        r12.visitRecord(new DBCellRecord(r5, shortListToArray(r8)));
        r3 = r3 + 1;
        goto L3
    L11:
        List<Record> r13 = this._unknownRecords;
        r12.getClass();
        r13.forEach(new $$Lambda$EVfSC4EtUPM6m_b8Sm1opKiHFAU(r12));
    }
}
