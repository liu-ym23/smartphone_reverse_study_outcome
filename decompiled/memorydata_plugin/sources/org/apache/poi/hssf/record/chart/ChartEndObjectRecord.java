package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartEndObjectRecord extends StandardRecord {
    private short grbitFrt;
    private short iObjectKind;
    private byte[] reserved;
    private short rt;

    public ChartEndObjectRecord(RecordInputStream r2) {
        this.rt = r2.readShort();
        this.grbitFrt = r2.readShort();
        this.iObjectKind = r2.readShort();
        this.reserved = new byte[6];
        if (r2.available() == 0) goto L7;
        r2.readFully(this.reserved);
        return;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$ChartEndObjectRecord$VgbKTN3mMb1R01DGyV4bUpavY(this), "grbitFrt", new $$Lambda$ChartEndObjectRecord$ffLtOd8yG_MddKFENkztW3Scpk(this), "iObjectKind", new $$Lambda$ChartEndObjectRecord$vESIV2mXGrtOWYhVFoGY9K3yGRg(this), "reserved", new $$Lambda$ChartEndObjectRecord$42VMIzfOAOGPhQeZrqlbRsRfWmA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_END_OBJECT;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2133;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ChartEndObjectRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartEndObjectRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ChartEndObjectRecord() {
        return Short.valueOf(this.iObjectKind);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ChartEndObjectRecord() {
        return this.reserved;
    }
}
