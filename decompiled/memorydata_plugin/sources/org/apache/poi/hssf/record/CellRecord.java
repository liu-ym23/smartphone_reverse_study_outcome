package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CellRecord extends StandardRecord implements CellValueRecordInterface {
    private int _columnIndex;
    private int _formatIndex;
    private int _rowIndex;

    public CellRecord() {
    }

    public CellRecord(RecordInputStream r2) {
        this._rowIndex = r2.readUShort();
        this._columnIndex = r2.readUShort();
        this._formatIndex = r2.readUShort();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getColumn() {
        return (short) this._columnIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final int getDataSize() {
        return getValueDataSize() + 6;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$b38rAFpuL1vMmhE0XsEl23LzPx4(this), "col", new $$Lambda$2gt2tBQn8o0cBxNI_d3xONDSwqY(this), "xfIndex", new $$Lambda$_049Sl3ZXCYElnrnIq7YTtoNJdE(this));
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final int getRow() {
        return this._rowIndex;
    }

    public abstract int getValueDataSize();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getXFIndex() {
        return (short) this._formatIndex;
    }

    public final void setColumn(short r1) {
        this._columnIndex = r1;
    }

    public final void setRow(int r1) {
        this._rowIndex = r1;
    }

    public final void setXFIndex(short r1) {
        this._formatIndex = r1;
    }
}
