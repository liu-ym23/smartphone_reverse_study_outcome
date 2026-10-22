package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ObjectLinkRecord extends StandardRecord {
    private short field_1_anchorId;
    private short field_2_link1;
    private short field_3_link2;

    public ObjectLinkRecord() {
    }

    public ObjectLinkRecord(RecordInputStream r2) {
        this.field_1_anchorId = r2.readShort();
        this.field_2_link1 = r2.readShort();
        this.field_3_link2 = r2.readShort();
    }

    public short getAnchorId() {
        return this.field_1_anchorId;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("anchorId", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$jKOg8W2ffZfQStIPH_LPkAY10eY(this), new int[]{1, 2, 3, 4, 7}, new String[]{"CHART_TITLE", "Y_AXIS", "X_AXIS", "SERIES_OR_POINT", "Z_AXIS"}), "link1", new $$Lambda$_VUEuMDwCkQpZCL27Er5fzhoWU8(this), "link2", new $$Lambda$c8HGHdtmSg1wihjF5dODlZYvrbU(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.OBJECT_LINK;
    }

    public short getLink1() {
        return this.field_2_link1;
    }

    public short getLink2() {
        return this.field_3_link2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4135;
    }
}
