package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CRNRecord extends StandardRecord {
    private int field_1_last_column_index;
    private int field_2_first_column_index;
    private int field_3_row_index;
    private Object[] field_4_constant_values;

    public CRNRecord(RecordInputStream r3) {
        this.field_1_last_column_index = r3.readUByte();
        this.field_2_first_column_index = r3.readUByte();
        this.field_3_row_index = r3.readShort();
        this.field_4_constant_values = ConstantValueParser.parse(r3, (this.field_1_last_column_index - this.field_2_first_column_index) + 1);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return ConstantValueParser.getEncodedSize(this.field_4_constant_values) + 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("row", new $$Lambda$CRNRecord$BHz5LkEOzUlgWC_fpQ7AIXes2g(this), "firstColumn", new $$Lambda$CRNRecord$6iioziSJMfWXWql5ctfnRgfCOK8(this), "lastColumn", new $$Lambda$CRNRecord$8FgQUxyELNReAkr66CO_Mj9M51Y(this), "constantValues", new $$Lambda$CRNRecord$pEMIJreyGURuhP2avxCGG7hTjQ(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CRN;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 90;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CRNRecord() {
        return Integer.valueOf(this.field_3_row_index);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$CRNRecord() {
        return Integer.valueOf(this.field_2_first_column_index);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$CRNRecord() {
        return Integer.valueOf(this.field_1_last_column_index);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$CRNRecord() {
        return this.field_4_constant_values;
    }
}
