package org.apache.poi.hssf.record;

import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberRecord extends CellRecord {
    private double field_4_value;

    public NumberRecord() {
    }

    public NumberRecord(RecordInputStream r3) {
        super(r3);
        this.field_4_value = r3.readDouble();
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$NumberRecord$EzLNn2aq8TYga5MWFT2UDLDZRU(this), EventBody.KEY_VALUE, new $$Lambda$yxYRIUXwIAwtuW_Dio4qGNor7jc(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NUMBER;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 515;
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 8;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$NumberRecord() {
        return super.getGenericProperties();
    }

    public void setValue(double r1) {
        this.field_4_value = r1;
    }
}
