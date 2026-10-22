package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CellRangeAddressBase implements Iterable<CellAddress>, GenericRecord {
    private int _firstCol;
    private int _firstRow;
    private int _lastCol;
    private int _lastRow;

    public static final enum CellPosition extends Enum<CellPosition> {
        private static final /* synthetic */ CellPosition[] $VALUES = null;
        public static final CellPosition BOTTOM = null;
        public static final CellPosition INSIDE = null;
        public static final CellPosition LEFT = null;
        public static final CellPosition RIGHT = null;
        public static final CellPosition TOP = null;

        static {
            CellPosition r0 = new CellPosition("TOP", 0);
            TOP = r0;
            CellPosition r1 = new CellPosition("BOTTOM", 1);
            BOTTOM = r1;
            CellPosition r3 = new CellPosition("LEFT", 2);
            LEFT = r3;
            CellPosition r5 = new CellPosition("RIGHT", 3);
            RIGHT = r5;
            CellPosition r7 = new CellPosition("INSIDE", 4);
            INSIDE = r7;
            $VALUES = new CellPosition[]{r0, r1, r3, r5, r7};
        }

        private CellPosition(String r1, int r2) {
            super(r1, r2);
        }

        public static CellPosition valueOf(String r2) {
            return (CellPosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellPosition.class, r2), CellPosition.class, "com.obric.memorydata.plugin");
        }

        public static CellPosition[] values() {
            return (CellPosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellPosition[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class RowMajorCellAddressIterator implements Iterator<CellAddress> {
        private int c;
        private final int firstCol;
        private final int firstRow;
        private final int lastCol;
        private final int lastRow;
        private int r;

        public RowMajorCellAddressIterator(CellRangeAddressBase r4) {
            int r0 = r4.getFirstRow();
            this.firstRow = r0;
            this.r = r0;
            int r1 = r4.getFirstColumn();
            this.firstCol = r1;
            this.c = r1;
            int r2 = r4.getLastRow();
            this.lastRow = r2;
            int r5 = r4.getLastColumn();
            this.lastCol = r5;
            if (r0 < 0) goto L15;
            if (r1 < 0) goto L13;
            if (r0 > r2) goto L11;
            if (r1 > r5) goto L9;
            return;
        L9:
            throw new IllegalStateException("First column cannot be greater than last column.");
        L11:
            throw new IllegalStateException("First row cannot be greater than last row.");
        L13:
            throw new IllegalStateException("First column cannot be negative.");
        L15:
            throw new IllegalStateException("First row cannot be negative.");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.r <= this.lastRow) goto L5;
        L7:
            return false;
        L5:
            if (this.c > this.lastCol) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ CellAddress next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public CellAddress next2() {
            if (hasNext() == false) goto L10;
            CellAddress r0 = new CellAddress(this.r, this.c);
            int r1 = this.c;
            if (r1 >= this.lastCol) goto L7;
            this.c = r1 + 1;
        L8:
            return r0;
        L7:
            this.c = this.firstCol;
            this.r++;
            goto L8
        L10:
            throw new NoSuchElementException();
        }
    }

    public CellRangeAddressBase(int r1, int r2, int r3, int r4) {
        this._firstRow = r1;
        this._lastRow = r2;
        this._firstCol = r3;
        this._lastCol = r4;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, CellRangeAddressBase.class) == false) goto L14;
        CellRangeAddressBase r5 = (CellRangeAddressBase) ZeusTransformUtils.preCheckCast(r4, CellRangeAddressBase.class, "com.obric.memorydata.plugin");
        if (getMinRow() == r5.getMinRow()) goto L7;
        return false;
    L7:
        if (getMaxRow() == r5.getMaxRow()) goto L9;
        return false;
    L9:
        if (getMinColumn() == r5.getMinColumn()) goto L11;
        return false;
    L11:
        if (getMaxColumn() != r5.getMaxColumn()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public final int getFirstColumn() {
        return this._firstCol;
    }

    public final int getFirstRow() {
        return this._firstRow;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("firstRow", new $$Lambda$GygF3KNseMkXZIGhVT1j1yMGJg(this), "firstCol", new $$Lambda$a6fCDKpUlwGh4wylIdYMudv87j4(this), "lastRow", new $$Lambda$unzdTttqaGhhc1g1kVIIkWbWEc(this), "lastCol", new $$Lambda$06AR332NSR4FyKTLA9tkq770cKQ(this));
    }

    public final int getLastColumn() {
        return this._lastCol;
    }

    public final int getLastRow() {
        return this._lastRow;
    }

    public int getMaxColumn() {
        return Math.max(this._firstCol, this._lastCol);
    }

    public int getMaxRow() {
        return Math.max(this._firstRow, this._lastRow);
    }

    public int getMinColumn() {
        return Math.min(this._firstCol, this._lastCol);
    }

    public int getMinRow() {
        return Math.min(this._firstRow, this._lastRow);
    }

    public int getNumberOfCells() {
        return ((this._lastRow - this._firstRow) + 1) * ((this._lastCol - this._firstCol) + 1);
    }

    public int hashCode() {
        return ((getMinColumn() + (getMaxColumn() << 8)) + (getMinRow() << 16)) + (getMaxRow() << 24);
    }

    public final boolean isFullColumnRange() {
        if (this._firstRow != 0) goto L7;
        if (this._lastRow != SpreadsheetVersion.EXCEL97.getLastRowIndex()) goto L7;
    L10:
        return true;
    L7:
        if (this._firstRow == (-1)) goto L9;
    L11:
        return false;
    L9:
        if (this._lastRow != (-1)) goto L11;
        goto L10
    }

    public final boolean isFullRowRange() {
        if (this._firstCol != 0) goto L7;
        if (this._lastCol != SpreadsheetVersion.EXCEL97.getLastColumnIndex()) goto L7;
    L10:
        return true;
    L7:
        if (this._firstCol == (-1)) goto L9;
    L11:
        return false;
    L9:
        if (this._lastCol != (-1)) goto L11;
        goto L10
    }

    public boolean isInRange(int r2, int r3) {
        if (this._firstRow <= r2) goto L5;
    L11:
        return false;
    L5:
        if (r2 > this._lastRow) goto L11;
        if (this._firstCol > r3) goto L11;
        if (r3 > this._lastCol) goto L11;
        return true;
    }

    public boolean isInRange(Cell r3) {
        Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        return isInRange(r4.getRowIndex(), r4.getColumnIndex());
    }

    public boolean isInRange(CellReference r2) {
        return isInRange(r2.getRow(), r2.getCol());
    }

    @Override // java.lang.Iterable
    public Iterator<CellAddress> iterator() {
        return new RowMajorCellAddressIterator(this);
    }

    @Override // java.lang.Iterable
    public Spliterator<CellAddress> spliterator() {
        return Spliterators.spliterator(iterator(), getNumberOfCells(), 0);
    }

    public final String toString() {
        return getClass().getName() + " [" + new CellAddress(this._firstRow, this._firstCol).formatAsString() + ParameterizedMessage.ERROR_MSG_SEPARATOR + new CellAddress(this._lastRow, this._lastCol).formatAsString() + "]";
    }
}
