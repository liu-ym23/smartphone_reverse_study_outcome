package org.apache.poi.hslf.usermodel;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hslf.record.ExOleObjStg;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFObjectData implements GenericRecord {
    private final ExOleObjStg storage;

    public HSLFObjectData(ExOleObjStg r1) {
        this.storage = r1;
    }

    public ExOleObjStg getExOleObjStg() {
        return this.storage;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return Collections.singletonList(getExOleObjStg());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }
}
