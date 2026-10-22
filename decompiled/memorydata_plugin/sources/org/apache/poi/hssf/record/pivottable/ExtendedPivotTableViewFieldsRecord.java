package org.apache.poi.hssf.record.pivottable;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class ExtendedPivotTableViewFieldsRecord extends StandardRecord {
    private int _citmShow;
    private int _grbit1;
    private int _grbit2;
    private int _isxdiShow;
    private int _isxdiSort;
    private int _reserved1;
    private int _reserved2;
    private String _subtotalName;

    public ExtendedPivotTableViewFieldsRecord(RecordInputStream r3) {
        this._grbit1 = r3.readInt();
        this._grbit2 = r3.readUByte();
        this._citmShow = r3.readUByte();
        this._isxdiSort = r3.readUShort();
        this._isxdiShow = r3.readUShort();
        int r0 = r3.remaining();
        if (r0 != 0) goto L5;
        this._reserved1 = 0;
        this._reserved2 = 0;
        this._subtotalName = null;
        return;
    L5:
        if (r0 != 10) goto L11;
        int r1 = r3.readUShort();
        this._reserved1 = r3.readInt();
        this._reserved2 = r3.readInt();
        if (r1 == 65535) goto L14;
        this._subtotalName = r3.readUnicodeLEString(r1);
        return;
    L14:
        return;
    L11:
        throw new RecordFormatException("Unexpected remaining size (" + r3.remaining() + ")");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        String r0 = this._subtotalName;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return r1 + 20;
    L5:
        r1 = r0.length() * 2;
        goto L7
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("grbit1", new $$Lambda$ExtendedPivotTableViewFieldsRecord$qHLwViaBsMXThbi6cvIQudYjJ9A(this), "grbit2", new $$Lambda$ExtendedPivotTableViewFieldsRecord$1wvAbpQxGVxcu967Fs96qRTGpUM(this), "citmShow", new $$Lambda$ExtendedPivotTableViewFieldsRecord$M6hLgNtK3VbvnnUEbbyPaV8Hk(this), "isxdiSort", new $$Lambda$ExtendedPivotTableViewFieldsRecord$msRemSycoiNOkhdZ3dJHfHVIL4(this), "isxdiShow", new $$Lambda$ExtendedPivotTableViewFieldsRecord$4vVx8EDPRtOG352CMhIXClrWCLs(this), "subtotalName", new $$Lambda$ExtendedPivotTableViewFieldsRecord$ebplhO9TsbJm0lM3tRoEijcbeE(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTENDED_PIVOT_TABLE_VIEW_FIELDS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 256;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ExtendedPivotTableViewFieldsRecord() {
        return Integer.valueOf(this._grbit1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ExtendedPivotTableViewFieldsRecord() {
        return Integer.valueOf(this._grbit2);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ExtendedPivotTableViewFieldsRecord() {
        return Integer.valueOf(this._citmShow);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ExtendedPivotTableViewFieldsRecord() {
        return Integer.valueOf(this._isxdiSort);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ExtendedPivotTableViewFieldsRecord() {
        return Integer.valueOf(this._isxdiShow);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$ExtendedPivotTableViewFieldsRecord() {
        return this._subtotalName;
    }
}
