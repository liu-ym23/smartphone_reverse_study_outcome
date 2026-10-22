package org.apache.poi.hssf.record;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class NameCommentRecord extends StandardRecord {
    private final short field_1_record_type;
    private final short field_2_frt_cell_ref_flag;
    private final long field_3_reserved;
    private String field_6_name_text;
    private String field_7_comment_text;

    public NameCommentRecord(RecordInputStream r4) {
        this.field_1_record_type = r4.readShort();
        this.field_2_frt_cell_ref_flag = r4.readShort();
        this.field_3_reserved = r4.readLong();
        short r0 = r4.readShort();
        short r1 = r4.readShort();
        if (r4.readByte() != 0) goto L5;
        String r2 = StringUtil.readCompressedUnicode(r4, r0);
    L6:
        this.field_6_name_text = r2;
        if (r4.readByte() != 0) goto L9;
        String r5 = StringUtil.readCompressedUnicode(r4, r1);
    L10:
        this.field_7_comment_text = r5;
        return;
    L9:
        r5 = StringUtil.readUnicodeLE(r4, r1);
        goto L10
    L5:
        r2 = StringUtil.readUnicodeLE(r4, r0);
        goto L6
    }

    public String getCommentText() {
        return this.field_7_comment_text;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        if (StringUtil.hasMultibyte(this.field_6_name_text) == false) goto L5;
        int r0 = this.field_6_name_text.length() * 2;
    L6:
        int r1 = r0 + 18;
        boolean r2 = StringUtil.hasMultibyte(this.field_7_comment_text);
        int r3 = this.field_7_comment_text.length();
        if (r2 == false) goto L10;
        r3 = r3 * 2;
    L10:
        return r1 + r3;
    L5:
        r0 = this.field_6_name_text.length();
        goto L6
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("recordType", new $$Lambda$9nk3idXBz7C7yRUB1ybeN85Xkxs(this), "frtCellRefFlag", new $$Lambda$NameCommentRecord$IjYjwHjezuPljp3qi7mKxNdCKbY(this), "reserved", new $$Lambda$NameCommentRecord$F_cTrWjISrfUWIoRnlcqbvbBqM(this), ActivityLifecycle.NAME, new $$Lambda$Yj_VtthGSlJfJHHRjMF_L5fWWk(this), "comment", new $$Lambda$Kh5bqZqsCm7Q9A0YIJZ_GyA0Ec(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.NAME_COMMENT;
    }

    public String getNameText() {
        return this.field_6_name_text;
    }

    public short getRecordType() {
        return this.field_1_record_type;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2196;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$NameCommentRecord() {
        return Short.valueOf(this.field_2_frt_cell_ref_flag);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$NameCommentRecord() {
        return Long.valueOf(this.field_3_reserved);
    }

    public void setNameText(String r1) {
        this.field_6_name_text = r1;
    }
}
