package org.apache.poi.hssf.record.chart;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SeriesTextRecord extends StandardRecord {
    private int field_1_id;
    private String field_4_text;
    private boolean is16bit;

    public SeriesTextRecord() {
        this.field_4_text = "";
        this.is16bit = false;
    }

    public SeriesTextRecord(RecordInputStream r4) {
        this.field_1_id = r4.readUShort();
        int r0 = r4.readUByte();
        boolean r2 = true;
        if ((r4.readUByte() & 1) != 0) goto L6;
        r2 = false;
    L6:
        this.is16bit = r2;
        if (r2 == false) goto L9;
        String r5 = r4.readUnicodeLEString(r0);
    L10:
        this.field_4_text = r5;
        return;
    L9:
        r5 = r4.readCompressedUnicode(r0);
        goto L10
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r0 = this.field_4_text.length();
        if (this.is16bit == false) goto L5;
        int r1 = 2;
    L7:
        return (r0 * r1) + 4;
    L5:
        r1 = 1;
        goto L7
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(OaidModel.KEY_ID, new $$Lambda$yabGSnl_RhCZIgyDPzTmomdXYow(this), "bit16", new $$Lambda$SeriesTextRecord$iLZmQbm_PbuMqwZ7Yrss7v_eNXE(this), IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, new $$Lambda$nGwuIst7kiPR033yaW6Fu1wYTU0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SERIES_TEXT;
    }

    public int getId() {
        return this.field_1_id;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 4109;
    }

    public String getText() {
        return this.field_4_text;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$SeriesTextRecord() {
        return Boolean.valueOf(this.is16bit);
    }
}
