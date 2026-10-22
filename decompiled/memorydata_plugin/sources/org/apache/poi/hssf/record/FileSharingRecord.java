package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FileSharingRecord extends StandardRecord {
    private short field_1_readonly;
    private short field_2_password;
    private byte field_3_username_unicode_options;
    private String field_3_username_value;

    public FileSharingRecord() {
    }

    public FileSharingRecord(RecordInputStream r3) {
        this.field_1_readonly = r3.readShort();
        this.field_2_password = r3.readShort();
        short r0 = r3.readShort();
        if (r0 <= 0) goto L5;
        this.field_3_username_unicode_options = r3.readByte();
        String r4 = r3.readCompressedUnicode(r0);
    L6:
        this.field_3_username_value = r4;
        return;
    L5:
        r4 = "";
        goto L6
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int r1 = this.field_3_username_value.length();
        if (r1 >= 1) goto L7;
        return 6;
    L7:
        return r1 + 7;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("readOnly", new $$Lambda$kvYaoVnHIwwtHuANahUAs1sneA(this), "password", new $$Lambda$4Y2bznfNrk7_c2WgkQn8i5UwWM(this), "username", new $$Lambda$U8DG6zKzRfPqosVzrXvPYqVo8Oc(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FILE_SHARING;
    }

    public short getPassword() {
        return this.field_2_password;
    }

    public short getReadOnly() {
        return this.field_1_readonly;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 91;
    }

    public String getUsername() {
        return this.field_3_username_value;
    }
}
