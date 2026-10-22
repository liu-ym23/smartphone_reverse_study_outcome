package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StringRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class ValueRecordsAggregate implements Iterable<CellValueRecordInterface> {
    private int firstcell;
    private int lastcell;
    private CellValueRecordInterface[][] records;

    class ValueIterator implements Iterator<CellValueRecordInterface> {
        int curColIndex;
        int curRowIndex;
        int nextColIndex;
        int nextRowIndex;
        final /* synthetic */ ValueRecordsAggregate this$0;

        public ValueIterator(ValueRecordsAggregate r1) {
            this.this$0 = r1;
            this.curColIndex = -1;
            this.nextColIndex = -1;
            getNextPos();
        }

        void getNextPos() {
            if (this.nextRowIndex < ValueRecordsAggregate.access$000(this.this$0).length) goto L6;
            return;
        L6:
            if (this.nextRowIndex >= ValueRecordsAggregate.access$000(this.this$0).length) goto L16;
            this.nextColIndex++;
            if (ValueRecordsAggregate.access$000(this.this$0)[this.nextRowIndex] == null) goto L15;
            if (this.nextColIndex >= ValueRecordsAggregate.access$000(this.this$0)[this.nextRowIndex].length) goto L15;
            if (ValueRecordsAggregate.access$000(this.this$0)[this.nextRowIndex][this.nextColIndex] == null) goto L6;
            return;
        L15:
            this.nextRowIndex++;
            this.nextColIndex = -1;
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextRowIndex >= ValueRecordsAggregate.access$000(this.this$0).length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ CellValueRecordInterface next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public CellValueRecordInterface next2() {
            if (hasNext() == false) goto L7;
            this.curRowIndex = this.nextRowIndex;
            this.curColIndex = this.nextColIndex;
            CellValueRecordInterface r0 = ValueRecordsAggregate.access$000(this.this$0)[this.curRowIndex][this.curColIndex];
            getNextPos();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            ValueRecordsAggregate.access$000(this.this$0)[this.curRowIndex][this.curColIndex] = null;
        }
    }

    public ValueRecordsAggregate() {
        this(-1, -1, new CellValueRecordInterface[30][]);
    }

    private ValueRecordsAggregate(int r2, int r3, CellValueRecordInterface[][] r4) {
        this.firstcell = -1;
        this.lastcell = -1;
        this.firstcell = r2;
        this.lastcell = r3;
        this.records = r4;
    }

    static /* synthetic */ CellValueRecordInterface[][] access$000(ValueRecordsAggregate r0) {
        return r0.records;
    }

    private static int countBlanks(CellValueRecordInterface[] r3, int r4) {
        int r0 = r4;
    L4:
        if (r0 >= r3.length) goto L10;
        if (ZeusTransformUtils.instanceOf(r3[r0], BlankRecord.class) == false) goto L10;
        r0 = r0 + 1;
    L10:
        return r0 - r4;
    }

    private MulBlankRecord createMBR(CellValueRecordInterface[] r3, int r4, int r5) {
        short[] r2 = new short[r5];
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L6;
        r2[r0] = r3[r4 + r0].getXFIndex();
        r0 = r0 + 1;
        goto L3
    L6:
        return new MulBlankRecord(r3[r4].getRow(), r4, r2);
    }

    public void addMultipleBlanks(MulBlankRecord r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.getNumColumns()) goto L6;
        BlankRecord r1 = new BlankRecord();
        r1.setColumn((short) (r4.getFirstColumn() + r0));
        r1.setRow(r4.getRow());
        r1.setXFIndex(r4.getXFAt(r0));
        insertCell(r1);
        r0 = r0 + 1;
        goto L4
    }

    public void construct(CellValueRecordInterface r4, RecordStream r5, SharedValueManager r6) {
        CellValueRecordInterface r7 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r4, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, FormulaRecord.class) == false) goto L9;
        FormulaRecord r8 = (FormulaRecord) ZeusTransformUtils.preCheckCast(r7, FormulaRecord.class, "com.obric.memorydata.plugin");
        if (r5.peekNextClass() != StringRecord.class) goto L7;
        StringRecord r9 = (StringRecord) ZeusTransformUtils.preCheckCast(r5.getNext(), StringRecord.class, "com.obric.memorydata.plugin");
    L8:
        insertCell(new FormulaRecordAggregate(r8, r9, r6));
        return;
    L7:
        r9 = null;
        goto L8
    L9:
        insertCell(r7);
    }

    public int getFirstCellNum() {
        return this.firstcell;
    }

    public int getLastCellNum() {
        return this.lastcell;
    }

    public int getPhysicalNumberOfCells() {
        CellValueRecordInterface[][] r8 = this.records;
        int r0 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L13;
        CellValueRecordInterface[] r4 = r8[r2];
        if (r4 == null) goto L12;
        int r5 = r4.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L12;
        if (r4[r6] == null) goto L11;
        r3 = r3 + 1;
    L11:
        r6 = r6 + 1;
    L12:
        r2 = r2 + 1;
        goto L3
    L13:
        return r3;
    }

    public void insertCell(CellValueRecordInterface r7) {
        CellValueRecordInterface r8 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r7, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        short r0 = r8.getColumn();
        int r1 = r8.getRow();
        CellValueRecordInterface[][] r2 = this.records;
        if (r1 < r2.length) goto L8;
        int r3 = r2.length * 2;
        int r5 = r1 + 1;
        if (r3 >= r5) goto L7;
        r3 = r5;
    L7:
        CellValueRecordInterface[][] r4 = new CellValueRecordInterface[r3][];
        this.records = r4;
        System.arraycopy(r2, 0, r4, 0, r2.length);
    L8:
        CellValueRecordInterface[][] r6 = this.records;
        CellValueRecordInterface[] r9 = r6[r1];
        if (r9 != null) goto L15;
        int r10 = r0 + 1;
        if (r10 >= 10) goto L13;
        r10 = 10;
    L13:
        r9 = new CellValueRecordInterface[r10];
        r6[r1] = r9;
    L15:
        if (r0 < r9.length) goto L20;
        int r11 = r9.length * 2;
        int r12 = r0 + 1;
        if (r11 >= r12) goto L19;
        r11 = r12;
    L19:
        CellValueRecordInterface[] r13 = new CellValueRecordInterface[r11];
        System.arraycopy(r9, 0, r13, 0, r9.length);
        this.records[r1] = r13;
        r9 = r13;
    L20:
        r9[r0] = r8;
        int r14 = this.firstcell;
        if (r0 < r14) goto L23;
        if (r14 == (-1)) goto L23;
    L24:
        int r15 = this.lastcell;
        if (r0 > r15) goto L27;
        if (r15 == (-1)) goto L27;
        return;
    L27:
        this.lastcell = r0;
        return;
    L23:
        this.firstcell = r0;
        goto L24
    }

    @Override // java.lang.Iterable
    public Iterator<CellValueRecordInterface> iterator() {
        return new ValueIterator(this);
    }

    public void removeAllCellsValuesForRow(int r4) {
        if (r4 < 0) goto L11;
        if (r4 > 65535) goto L11;
        CellValueRecordInterface[][] r3 = this.records;
        if (r4 < r3.length) goto L8;
        return;
    L8:
        r3[r4] = null;
        return;
    L11:
        throw new IllegalArgumentException("Specified rowIndex " + r4 + " is outside the allowable range (0..65535)");
    }

    public void removeCell(CellValueRecordInterface r3) {
        CellValueRecordInterface r4 = (CellValueRecordInterface) ZeusTransformUtils.wrapperContextForParams(r3, CellValueRecordInterface.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        int r0 = r4.getRow();
        CellValueRecordInterface[][] r2 = this.records;
        if (r0 >= r2.length) goto L17;
        CellValueRecordInterface[] r5 = r2[r0];
        if (r5 == null) goto L15;
        short r6 = r4.getColumn();
        if (r6 >= r5.length) goto L13;
        r5[r6] = null;
        return;
    L13:
        throw new RuntimeException("cell column is out of range");
    L15:
        throw new RuntimeException("cell row is already empty");
    L17:
        throw new RuntimeException("cell row is out of range");
    L19:
        throw new IllegalArgumentException("cell must not be null");
    }

    public boolean rowHasCells(int r4) {
        CellValueRecordInterface[][] r3 = this.records;
        if (r4 < r3.length) goto L5;
        return false;
    L5:
        CellValueRecordInterface[] r5 = r3[r4];
        if (r5 != null) goto L8;
        return false;
    L8:
        int r6 = r5.length;
        int r0 = 0;
    L9:
        if (r0 >= r6) goto L15;
        if (r5[r0] != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    @Override // java.lang.Iterable
    public Spliterator<CellValueRecordInterface> spliterator() {
        return Spliterators.spliterator(iterator(), getPhysicalNumberOfCells(), 0);
    }

    public void visitCellsForRow(int r6, RecordAggregate.RecordVisitor r7) {
        RecordAggregate.RecordVisitor r8 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r7, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        CellValueRecordInterface[] r0 = this.records[r6];
        if (r0 == null) goto L20;
        int r9 = 0;
    L6:
        if (r9 >= r0.length) goto L18;
        RecordBase r2 = (RecordBase) ZeusTransformUtils.preCheckCast(r0[r9], RecordBase.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
        int r4 = countBlanks(r0, r9);
        if (r4 <= 1) goto L14;
        r8.visitRecord(createMBR(r0, r9, r4));
        r9 = r9 + (r4 - 1);
        goto L17
    L14:
        if (ZeusTransformUtils.instanceOf(r2, RecordAggregate.class) == false) goto L16;
        ((RecordAggregate) ZeusTransformUtils.preCheckCast(r2, RecordAggregate.class, "com.obric.memorydata.plugin")).visitContainedRecords(r8);
        goto L17
    L16:
        r8.visitRecord((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin"));
    L17:
        r9 = r9 + 1;
        goto L6
    L18:
        return;
    L20:
        throw new IllegalArgumentException("Row [" + r6 + "] is empty");
    }
}
