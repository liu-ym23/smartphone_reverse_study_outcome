package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FeatSmartTag implements SharedFeature {
    private byte[] data;

    public FeatSmartTag() {
        this.data = new byte[0];
    }

    public FeatSmartTag(RecordInputStream r1) {
        this.data = r1.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return this.data.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("data", new $$Lambda$FeatSmartTag$gY8n9bHpkLfpcLnOWTl9d0xlazY(this));
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FeatSmartTag() {
        return this.data;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
