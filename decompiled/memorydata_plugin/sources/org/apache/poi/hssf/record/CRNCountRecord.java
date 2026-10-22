package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class CRNCountRecord extends StandardRecord {
    private int field_1_number_crn_records;
    private int field_2_sheet_table_index;

    public CRNCountRecord(RecordInputStream r2) {
        short r0 = r2.readShort();
        this.field_1_number_crn_records = r0;
        if (r0 >= 0) goto L5;
        this.field_1_number_crn_records = (short) (-r0);
    L5:
        this.field_2_sheet_table_index = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("numberOfCRNs", new $$Lambda$nhAa8haKkpvltz63ULW6_xkdwHQ(this), "sheetTableIndex", new $$Lambda$CRNCountRecord$Lw_mSXIodBNYcbgpSoqI_wleL5g(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CRN_COUNT;
    }

    public int getNumberOfCRNs() {
        return this.field_1_number_crn_records;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 89;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CRNCountRecord() {
        return Integer.valueOf(this.field_2_sheet_table_index);
    }
}
