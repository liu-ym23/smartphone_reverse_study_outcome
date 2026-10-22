package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SharedValueRecordBase extends StandardRecord {
    private CellRangeAddress8Bit _range;

    public SharedValueRecordBase(CellRangeAddress8Bit r1) {
        if (r1 == null) goto L7;
        this._range = r1;
        return;
    L7:
        throw new IllegalArgumentException("range must be supplied.");
    }

    public SharedValueRecordBase(LittleEndianInput r3) {
        this._range = new CellRangeAddress8Bit((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return getExtraDataSize() + 6;
    }

    public abstract int getExtraDataSize();

    public final int getFirstColumn() {
        return (short) this._range.getFirstColumn();
    }

    public final int getFirstRow() {
        return this._range.getFirstRow();
    }

    public final int getLastColumn() {
        return (short) this._range.getLastColumn();
    }

    public final int getLastRow() {
        return this._range.getLastRow();
    }

    public final CellRangeAddress8Bit getRange() {
        return this._range;
    }

    public final boolean isFirstCell(int r2, int r3) {
        CellRangeAddress8Bit r1 = getRange();
        if (r1.getFirstRow() == r2) goto L5;
    L7:
        return false;
    L5:
        if (r1.getFirstColumn() != r3) goto L7;
        return true;
    }

    public final boolean isInRange(int r2, int r3) {
        CellRangeAddress8Bit r1 = this._range;
        if (r1.getFirstRow() <= r2) goto L5;
    L11:
        return false;
    L5:
        if (r1.getLastRow() < r2) goto L11;
        if (r1.getFirstColumn() > r3) goto L11;
        if (r1.getLastColumn() < r3) goto L11;
        return true;
    }
}
