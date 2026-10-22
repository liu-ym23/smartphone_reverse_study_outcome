package org.apache.poi.hwmf.record;

import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public interface HwmfRecord extends GenericRecord {
    @Override // org.apache.poi.common.usermodel.GenericRecord
    default Enum<?> getGenericRecordType() {
        return getWmfRecordType();
    }

    HwmfRecordType getWmfRecordType();
}
