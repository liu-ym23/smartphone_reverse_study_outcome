package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class UserSViewEnd extends StandardRecord {
    private byte[] _rawData;

    public UserSViewEnd(RecordInputStream r1) {
        this._rawData = r1.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rawData", new $$Lambda$UserSViewEnd$IjY8mREvM4Vrg5l0rThADHcKCUs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.USER_SVIEW_END;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 427;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UserSViewEnd() {
        return this._rawData;
    }
}
