package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartEndBlockRecord extends StandardRecord {
    private short grbitFrt;
    private short iObjectKind;
    private short rt;
    private byte[] unused;

    public ChartEndBlockRecord() {
    }

    public ChartEndBlockRecord(RecordInputStream r2) {
        this.rt = r2.readShort();
        this.grbitFrt = r2.readShort();
        this.iObjectKind = r2.readShort();
        if (r2.available() != 0) goto L5;
        this.unused = new byte[0];
        return;
    L5:
        byte[] r0 = new byte[6];
        this.unused = r0;
        r2.readFully(r0);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.unused.length + 6;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$ChartEndBlockRecord$HUMxPQ51gph4MhAryKbMxHtNY(this), "grbitFrt", new $$Lambda$ChartEndBlockRecord$d5AHJKKjhMd8Iic9vN5MAwHfbY(this), "iObjectKind", new $$Lambda$ChartEndBlockRecord$NdbWATs7eJK1G4QeioHCP_LSFhc(this), "unused", new $$Lambda$ChartEndBlockRecord$PUKJ_SfXByHMXSfnbv7IPOJNJEo(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_END_BLOCK;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2131;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ChartEndBlockRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartEndBlockRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ChartEndBlockRecord() {
        return Short.valueOf(this.iObjectKind);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ChartEndBlockRecord() {
        return this.unused;
    }
}
