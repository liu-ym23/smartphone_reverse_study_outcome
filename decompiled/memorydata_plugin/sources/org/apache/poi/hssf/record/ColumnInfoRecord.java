package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ColumnInfoRecord extends StandardRecord {
    private static final BitField collapsed = null;
    private static final BitField hidden = null;
    private static final BitField outlevel = null;
    private int _colWidth;
    private int _firstCol;
    private int _lastCol;
    private int _options;
    private int _xfIndex;
    private int field_6_reserved;

    static {
        hidden = BitFieldFactory.getInstance(1);
        outlevel = BitFieldFactory.getInstance(1792);
        collapsed = BitFieldFactory.getInstance(4096);
    }

    public ColumnInfoRecord() {
        setColumnWidth(2275);
        this._options = 2;
        this._xfIndex = 15;
        this.field_6_reserved = 2;
    }

    public ColumnInfoRecord(RecordInputStream r3) {
        this._firstCol = r3.readUShort();
        this._lastCol = r3.readUShort();
        this._colWidth = r3.readUShort();
        this._xfIndex = r3.readUShort();
        this._options = r3.readUShort();
        int r0 = r3.remaining();
        if (r0 != 0) goto L5;
        int r4 = 0;
    L13:
        this.field_6_reserved = r4;
        return;
    L5:
        if (r0 != 1) goto L7;
        r4 = r3.readByte();
        goto L13
    L7:
        if (r0 != 2) goto L10;
        r4 = r3.readUShort();
        goto L13
    L10:
        throw new IllegalArgumentException("Unusual record size remaining=(" + r3.remaining() + ")");
    }

    public boolean containsColumn(int r2) {
        if (this._firstCol <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 > this._lastCol) goto L7;
        return true;
    }

    public boolean getCollapsed() {
        return collapsed.isSet(this._options);
    }

    public int getColumnWidth() {
        return this._colWidth;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    public int getFirstColumn() {
        return this._firstCol;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("firstColumn", new $$Lambda$bYwaP_bTaY5liBUde82Bbz_Od4(this), "lastColumn", new $$Lambda$7PHy9gozBQ3wL3tVKVQWYlsZ3cw(this), "columnWidth", new $$Lambda$nhmEBnH0M5voQEMdIEF4gH_cMrw(this), "xfIndex", new $$Lambda$ky1IBMkTDQsVqFOMbYsu1py5URM(this), "options", new $$Lambda$ColumnInfoRecord$1l4LfvwqyLouA3kzxZi4g7tuof0(this), "hidden", new $$Lambda$cOtl97fSh9RUxDLa8RtfUkLYGOc(this), "outlineLevel", new $$Lambda$7RsADt_qrbUtnWks15Jy8yzNqk(this), "collapsed", new $$Lambda$txrc8eBJ4HFa7BqVJL40oGEm_EA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.COLUMN_INFO;
    }

    public boolean getHidden() {
        return hidden.isSet(this._options);
    }

    public int getLastColumn() {
        return this._lastCol;
    }

    public int getOutlineLevel() {
        return outlevel.getValue(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 125;
    }

    public int getXFIndex() {
        return this._xfIndex;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ColumnInfoRecord() {
        return Integer.valueOf(this._options);
    }

    public void setColumnWidth(int r1) {
        this._colWidth = r1;
    }
}
