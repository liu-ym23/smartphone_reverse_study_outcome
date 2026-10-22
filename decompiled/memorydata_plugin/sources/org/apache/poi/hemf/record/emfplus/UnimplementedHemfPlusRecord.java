package org.apache.poi.hemf.record.emfplus;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class UnimplementedHemfPlusRecord implements HemfPlusRecord {
    private int flags;
    private HemfPlusRecordType recordType;

    public UnimplementedHemfPlusRecord() {
    }

    @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
    public HemfPlusRecordType getEmfPlusRecordType() {
        return this.recordType;
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$BEfIBEkuGib54tAMMu4Kr5VGM(this));
    }
}
