package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.SharedValueRecordBase;
import org.apache.poi.hssf.record.TableRecord;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class SharedValueManager {
    private final List<ArrayRecord> _arrayRecords;
    private final Map<SharedFormulaRecord, SharedFormulaGroup> _groupsBySharedFormulaRecord;
    private Map<Integer, SharedFormulaGroup> _groupsCache;
    private final TableRecord[] _tableRecords;

    private static final class SharedFormulaGroup {
        private final CellReference _firstCell;
        private final FormulaRecordAggregate[] _frAggs;
        private int _numberOfFormulas;
        private final SharedFormulaRecord _sfr;

        public SharedFormulaGroup(SharedFormulaRecord r3, CellReference r4) {
            if (r3.isInRange(r4.getRow(), r4.getCol()) == false) goto L7;
            this._sfr = r3;
            this._firstCell = r4;
            this._frAggs = new FormulaRecordAggregate[((r3.getLastColumn() - r3.getFirstColumn()) + 1) * ((r3.getLastRow() - r3.getFirstRow()) + 1)];
            this._numberOfFormulas = 0;
            return;
        L7:
            throw new IllegalArgumentException("First formula cell " + r4.formatAsString() + " is not shared formula range " + r3.getRange() + ".");
        }

        static /* synthetic */ CellReference access$000(SharedFormulaGroup r0) {
            return r0._firstCell;
        }

        public void add(FormulaRecordAggregate r4) {
            if (this._numberOfFormulas == 0) goto L5;
        L11:
            int r0 = this._numberOfFormulas;
            FormulaRecordAggregate[] r1 = this._frAggs;
            if (r0 >= r1.length) goto L16;
            this._numberOfFormulas = r0 + 1;
            r1[r0] = r4;
            return;
        L16:
            throw new IllegalStateException("Too many formula records for shared formula group: " + this._numberOfFormulas + ", expecting less than " + this._frAggs.length);
        L5:
            if (this._firstCell.getRow() != r4.getRow()) goto L10;
            if (this._firstCell.getCol() == r4.getColumn()) goto L11;
        L10:
            throw new IllegalStateException("shared formula coding error: " + this._firstCell.getCol() + '/' + this._firstCell.getRow() + " != " + r4.getColumn() + '/' + r4.getRow());
        }

        public SharedFormulaRecord getSFR() {
            return this._sfr;
        }

        public final String toString() {
            return getClass().getName() + " [" + this._sfr.getRange() + "]";
        }

        public void unlinkSharedFormulas() {
            int r0 = 0;
        L4:
            if (r0 >= this._numberOfFormulas) goto L6;
            this._frAggs[r0].unlinkSharedFormula();
            r0 = r0 + 1;
            goto L4
        }
    }

    private SharedValueManager(SharedFormulaRecord[] r5, CellReference[] r6, ArrayRecord[] r7, TableRecord[] r8) {
        int r0 = r5.length;
        if (r0 != r6.length) goto L10;
        this._arrayRecords = toList(r7);
        this._tableRecords = r8;
        HashMap r9 = new HashMap((r0 * 3) / 2);
        int r10 = 0;
    L5:
        if (r10 >= r0) goto L7;
        SharedFormulaRecord r1 = r5[r10];
        r9.put(r1, new SharedFormulaGroup(r1, r6[r10]));
        r10 = r10 + 1;
        goto L5
    L7:
        this._groupsBySharedFormulaRecord = r9;
        return;
    L10:
        throw new IllegalArgumentException("array sizes don't match: " + r0 + "!=" + r6.length + ".");
    }

    public static SharedValueManager create(SharedFormulaRecord[] r2, CellReference[] r3, ArrayRecord[] r4, TableRecord[] r5) {
        if ((((r2.length + r3.length) + r4.length) + r5.length) >= 1) goto L7;
        return createEmpty();
    L7:
        return new SharedValueManager(r2, r3, r4, r5);
    }

    public static SharedValueManager createEmpty() {
        return new SharedValueManager(new SharedFormulaRecord[0], new CellReference[0], new ArrayRecord[0], new TableRecord[0]);
    }

    private SharedFormulaGroup findFormulaGroupForCell(CellReference r6) {
        if (this._groupsCache != null) goto L9;
        this._groupsCache = new HashMap(this._groupsBySharedFormulaRecord.size());
        Iterator<SharedFormulaGroup> r0 = this._groupsBySharedFormulaRecord.values().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        SharedFormulaGroup r2 = (SharedFormulaGroup) ZeusTransformUtils.preCheckCast(r0.next(), SharedFormulaGroup.class, "com.obric.memorydata.plugin");
        this._groupsCache.put(getKeyForCache(SharedFormulaGroup.access$000(r2)), r2);
    L9:
        return (SharedFormulaGroup) ZeusTransformUtils.preCheckCast(this._groupsCache.get(getKeyForCache(r6)), SharedFormulaGroup.class, "com.obric.memorydata.plugin");
    }

    private Integer getKeyForCache(CellReference r1) {
        return Integer.valueOf(((r1.getCol() + 1) << 16) | r1.getRow());
    }

    private static <Z> List<Z> toList(Z[] r2) {
        ArrayList r0 = new ArrayList(r2.length);
        Collections.addAll(r0, r2);
        return r0;
    }

    public ArrayRecord getArrayRecord(int r4, int r5) {
        Iterator<ArrayRecord> r3 = this._arrayRecords.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        ArrayRecord r0 = (ArrayRecord) ZeusTransformUtils.preCheckCast(r3.next(), ArrayRecord.class, "com.obric.memorydata.plugin");
        if (r0.isFirstCell(r4, r5) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    public SharedValueRecordBase getRecordForFirstCell(FormulaRecordAggregate r8) {
        CellReference r0 = r8.getFormulaRecord().getFormula().getExpReference();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = r0.getRow();
        short r3 = r0.getCol();
        if (r8.getRow() == r2) goto L8;
    L28:
        return null;
    L8:
        if (r8.getColumn() != r3) goto L28;
        if (this._groupsBySharedFormulaRecord.isEmpty() == true) goto L16;
        SharedFormulaGroup r9 = findFormulaGroupForCell(r0);
        if (r9 == null) goto L16;
        return r9.getSFR();
    L16:
        TableRecord[] r10 = this._tableRecords;
        int r1 = r10.length;
        int r4 = 0;
    L17:
        if (r4 >= r1) goto L22;
        TableRecord r5 = r10[r4];
        if (r5.isFirstCell(r2, r3) == true) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return r5;
    L22:
        Iterator<ArrayRecord> r7 = this._arrayRecords.iterator();
    L24:
        if (r7.hasNext() == false) goto L28;
        ArrayRecord r11 = (ArrayRecord) ZeusTransformUtils.preCheckCast(r7.next(), ArrayRecord.class, "com.obric.memorydata.plugin");
        if (r11.isFirstCell(r2, r3) == false) goto L24;
        return r11;
    }

    public SharedFormulaRecord linkSharedFormulaRecord(CellReference r2, FormulaRecordAggregate r3) {
        SharedFormulaGroup r1 = findFormulaGroupForCell(r2);
        if (r1 == null) goto L7;
        r1.add(r3);
        return r1.getSFR();
    L7:
        throw new IllegalArgumentException("Failed to find a matching shared formula record for cell: " + r2);
    }

    public CellRangeAddress8Bit removeArrayFormula(int r5, int r6) {
        Iterator<ArrayRecord> r0 = this._arrayRecords.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ArrayRecord r1 = (ArrayRecord) ZeusTransformUtils.preCheckCast(r0.next(), ArrayRecord.class, "com.obric.memorydata.plugin");
        if (r1.isInRange(r5, r6) == false) goto L4;
        this._arrayRecords.remove(r1);
        return r1.getRange();
    L10:
        throw new IllegalArgumentException("Specified cell " + new CellReference(r5, r6, false, false).formatAsString() + " is not part of an array formula.");
    }

    public void unlink(SharedFormulaRecord r3) {
        SharedFormulaGroup r4 = (SharedFormulaGroup) ZeusTransformUtils.preCheckCast(this._groupsBySharedFormulaRecord.remove(r3), SharedFormulaGroup.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this._groupsCache = null;
        r4.unlinkSharedFormulas();
        return;
    L7:
        throw new IllegalStateException("Failed to find formulas for shared formula");
    }
}
