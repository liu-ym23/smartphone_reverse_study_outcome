package org.apache.poi.hemf.record.emf;

import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
interface HemfRecordWithoutProperties extends HemfRecord {
    @Override // org.apache.poi.common.usermodel.GenericRecord
    default Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }
}
