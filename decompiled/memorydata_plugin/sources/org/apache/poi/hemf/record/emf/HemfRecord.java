package org.apache.poi.hemf.record.emf;

import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public interface HemfRecord extends GenericRecord {
    HemfRecordType getEmfRecordType();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    /* bridge */ /* synthetic */ default Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    default HemfRecordType getGenericRecordType() {
        return getEmfRecordType();
    }
}
