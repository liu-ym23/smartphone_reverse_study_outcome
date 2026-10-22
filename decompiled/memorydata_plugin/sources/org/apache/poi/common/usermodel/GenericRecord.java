package org.apache.poi.common.usermodel;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface GenericRecord {
    default List<? extends GenericRecord> getGenericChildren() {
        return null;
    }

    Map<String, Supplier<?>> getGenericProperties();

    default Enum<?> getGenericRecordType() {
        return null;
    }
}
