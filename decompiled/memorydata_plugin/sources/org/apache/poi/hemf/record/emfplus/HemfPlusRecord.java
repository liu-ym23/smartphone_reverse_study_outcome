package org.apache.poi.hemf.record.emfplus;

import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public interface HemfPlusRecord extends GenericRecord {
    HemfPlusRecordType getEmfPlusRecordType();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    /* bridge */ /* synthetic */ default Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    default HemfPlusRecordType getGenericRecordType() {
        return getEmfPlusRecordType();
    }
}
