package org.apache.poi.hssf.eventusermodel.dummyrecord;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class MissingCellDummyRecord extends DummyRecordBase {
    private final int column;
    private final int row;

    public MissingCellDummyRecord(int r1, int r2) {
        this.row = r1;
        this.column = r2;
    }

    public int getColumn() {
        return this.column;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$MnxBDvW2yBeuS8HhosFvOPcKbc(this), "column", new $$Lambda$OYZ0Tc9KwT4dQIl6RowOdo1XcA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return null;
    }

    public int getRow() {
        return this.row;
    }
}
