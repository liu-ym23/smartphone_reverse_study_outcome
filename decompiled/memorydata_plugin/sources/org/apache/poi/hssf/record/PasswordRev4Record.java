package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PasswordRev4Record extends StandardRecord {
    private int field_1_password;

    public PasswordRev4Record(int r1) {
        this.field_1_password = r1;
    }

    public PasswordRev4Record(RecordInputStream r1) {
        this.field_1_password = r1.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("password", new $$Lambda$PasswordRev4Record$Uet2kfTtaOSXJLnY6gjJu5PaoGA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PASSWORD_REV_4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 444;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$PasswordRev4Record() {
        return Integer.valueOf(this.field_1_password);
    }
}
