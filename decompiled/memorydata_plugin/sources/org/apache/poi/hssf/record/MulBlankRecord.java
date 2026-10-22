package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class MulBlankRecord extends StandardRecord {
    private final int _firstCol;
    private final int _lastCol;
    private final int _row;
    private final short[] _xfs;

    public MulBlankRecord(int r1, int r2, short[] r3) {
        this._row = r1;
        this._firstCol = r2;
        this._xfs = r3;
        this._lastCol = (r2 + r3.length) - 1;
    }

    public MulBlankRecord(RecordInputStream r2) {
        this._row = r2.readUShort();
        this._firstCol = r2.readShort();
        this._xfs = parseXFs(r2);
        this._lastCol = r2.readShort();
    }

    private static short[] parseXFs(RecordInputStream r4) {
        int r0 = (r4.remaining() - 2) / 2;
        short[] r1 = new short[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = r4.readShort();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._xfs.length * 2) + 6;
    }

    public int getFirstColumn() {
        return this._firstCol;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$JIkBtuMXrNS_R3eDidRMapC0Ahw(this), "firstColumn", new $$Lambda$2LQkk48ZtLrHa2m2cYcFsPeue98(this), "lastColumn", new $$Lambda$Jolzm4UeEG1ZLRXktpDNdNo6ako(this), "xf", new $$Lambda$MulBlankRecord$CWEyixSnWkLxYQRyLhiVSOKCadg(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MUL_BLANK;
    }

    public int getLastColumn() {
        return this._lastCol;
    }

    public int getNumColumns() {
        return (this._lastCol - this._firstCol) + 1;
    }

    public int getRow() {
        return this._row;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 190;
    }

    public short getXFAt(int r1) {
        return this._xfs[r1];
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$MulBlankRecord() {
        return this._xfs;
    }
}
