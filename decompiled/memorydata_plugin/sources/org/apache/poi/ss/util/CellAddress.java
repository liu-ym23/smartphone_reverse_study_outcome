package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: classes7.dex */
public class CellAddress implements Comparable<CellAddress> {
    public static final CellAddress A1 = null;
    private final int _col;
    private final int _row;

    static {
        A1 = new CellAddress(0, 0);
    }

    public CellAddress(int r1, int r2) {
        this._row = r1;
        this._col = r2;
    }

    public CellAddress(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (Character.isDigit(r5.charAt(r2)) == true) goto L8;
        r2 = r2 + 1;
    L8:
        String r1 = r5.substring(0, r2).toUpperCase(Locale.ROOT);
        this._row = Integer.parseInt(r5.substring(r2)) - 1;
        this._col = CellReference.convertColStringToIndex(r1);
    }

    public CellAddress(Cell r3) {
        Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        this(r4.getRowIndex(), r4.getColumnIndex());
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(CellAddress r3) {
        return compareTo2((CellAddress) ZeusTransformUtils.preCheckCast(r3, CellAddress.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CellAddress r3) {
        int r0 = this._row - r3._row;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return this._col - r3._col;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CellAddress.class) == true) goto L8;
        return false;
    L8:
        CellAddress r6 = (CellAddress) ZeusTransformUtils.preCheckCast(r5, CellAddress.class, "com.obric.memorydata.plugin");
        if (this._row != r6._row) goto L14;
        if (this._col != r6._col) goto L14;
        return true;
    L14:
        return false;
    }

    public String formatAsString() {
        return CellReference.convertNumToColString(this._col) + (this._row + 1);
    }

    public int getColumn() {
        return this._col;
    }

    public int getRow() {
        return this._row;
    }

    public int hashCode() {
        return (this._row + this._col) << 16;
    }

    public String toString() {
        return formatAsString();
    }
}
