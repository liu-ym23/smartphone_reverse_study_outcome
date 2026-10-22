package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DVALRecord extends StandardRecord {
    private short field_1_options;
    private int field_2_horiz_pos;
    private int field_3_vert_pos;
    private int field_5_dv_no;
    private int field_cbo_id;

    public DVALRecord() {
        this.field_cbo_id = -1;
        this.field_5_dv_no = 0;
    }

    public DVALRecord(RecordInputStream r2) {
        this.field_1_options = r2.readShort();
        this.field_2_horiz_pos = r2.readInt();
        this.field_3_vert_pos = r2.readInt();
        this.field_cbo_id = r2.readInt();
        this.field_5_dv_no = r2.readInt();
    }

    public int getDVRecNo() {
        return this.field_5_dv_no;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 18;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("options", new $$Lambda$FhwfyYSeAFbC5EapaytPlC8cvFM(this), "horizPos", new $$Lambda$cvvd4uSfHpHHwdb7bgxDlPVMLU(this), "vertPos", new $$Lambda$iRmZ1gkD6lV1Rb3NcuR_eMUydU(this), "comboObjectID", new $$Lambda$Az1v4xly8Di5_IS9i_I8ic07gDU(this), "dvRecordsNumber", new $$Lambda$8fAnXkQP3isGhGj41Q6RrRKNg8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DVAL;
    }

    public int getHorizontalPos() {
        return this.field_2_horiz_pos;
    }

    public int getObjectID() {
        return this.field_cbo_id;
    }

    public short getOptions() {
        return this.field_1_options;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 434;
    }

    public int getVerticalPos() {
        return this.field_3_vert_pos;
    }
}
