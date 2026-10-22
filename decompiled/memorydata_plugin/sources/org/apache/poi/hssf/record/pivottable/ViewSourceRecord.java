package org.apache.poi.hssf.record.pivottable;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ViewSourceRecord extends StandardRecord {
    private int vs;

    public ViewSourceRecord(RecordInputStream r1) {
        this.vs = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("vs", new $$Lambda$ViewSourceRecord$gobecTuApfLiqHS3csCrhiFT4D8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VIEW_SOURCE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 227;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ViewSourceRecord() {
        return Integer.valueOf(this.vs);
    }
}
