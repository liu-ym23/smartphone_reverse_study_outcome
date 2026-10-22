package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class UserSViewBegin extends StandardRecord {
    private byte[] _rawData;

    public UserSViewBegin(RecordInputStream r1) {
        this._rawData = r1.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("guid", new $$Lambda$wpIm5nRgCMuP5zVtV0UGNY3wS38(this), "rawData", new $$Lambda$UserSViewBegin$ixcBQlkwHvVhBdb90Moz2QaxpP8(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.USER_SVIEW_BEGIN;
    }

    public byte[] getGuid() {
        return Arrays.copyOf(this._rawData, 16);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 426;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UserSViewBegin() {
        return this._rawData;
    }
}
