package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.util.RKUtil;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class RKRecord extends CellRecord {
    private final int field_4_rk_number;

    public RKRecord(RecordInputStream r1) {
        super(r1);
        this.field_4_rk_number = r1.readInt();
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$RKRecord$Wr2gdjuy8A0kRq6Kr0iSep_tz6M(this), "rkNumber", new $$Lambda$GD2MUULLXaz8GuCaPHIDib5qeY(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.RK;
    }

    public double getRKNumber() {
        return RKUtil.decodeNumber(this.field_4_rk_number);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 638;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 4;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$RKRecord() {
        return super.getGenericProperties();
    }
}
