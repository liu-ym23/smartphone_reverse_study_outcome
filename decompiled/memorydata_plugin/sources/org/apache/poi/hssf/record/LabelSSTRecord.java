package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class LabelSSTRecord extends CellRecord {
    private int field_4_sst_index;

    public LabelSSTRecord() {
    }

    public LabelSSTRecord(RecordInputStream r1) {
        super(r1);
        this.field_4_sst_index = r1.readInt();
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$LabelSSTRecord$aILlk_r8oQhNaJZKGF_u081Osw(this), "sstIndex", new $$Lambda$HAlhag0j_yCir4PvQQWL81uKh4(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LABEL_SST;
    }

    public int getSSTIndex() {
        return this.field_4_sst_index;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 253;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 4;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$LabelSSTRecord() {
        return super.getGenericProperties();
    }

    public void setSSTIndex(int r1) {
        this.field_4_sst_index = r1;
    }
}
