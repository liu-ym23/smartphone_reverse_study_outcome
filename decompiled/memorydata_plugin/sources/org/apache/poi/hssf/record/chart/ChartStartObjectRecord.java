package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartStartObjectRecord extends StandardRecord {
    private short grbitFrt;
    private short iObjectContext;
    private short iObjectInstance1;
    private short iObjectInstance2;
    private short iObjectKind;
    private short rt;

    public ChartStartObjectRecord(RecordInputStream r2) {
        this.rt = r2.readShort();
        this.grbitFrt = r2.readShort();
        this.iObjectKind = r2.readShort();
        this.iObjectContext = r2.readShort();
        this.iObjectInstance1 = r2.readShort();
        this.iObjectInstance2 = r2.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$ChartStartObjectRecord$9OUxmDtW4daa2S96yVNTWWzuy0(this), "grbitFrt", new $$Lambda$ChartStartObjectRecord$OdU9Vfhxj_oZJ4opyWy1k28wgkI(this), "iObjectKind", new $$Lambda$ChartStartObjectRecord$5oepWwWEjJV0PM03X3xGA7RXz1Q(this), "iObjectContext", new $$Lambda$ChartStartObjectRecord$JjhEibFOmpwNyUjbRUrpTNhXP8(this), "iObjectInstance1", new $$Lambda$ChartStartObjectRecord$QQeP1mBW_aCU4R90OClVUpqccrY(this), "iObjectInstance2", new $$Lambda$ChartStartObjectRecord$AcxlFZ8AMFo7AnADTl7GX9xBYUs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_START_OBJECT;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2132;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ChartStartObjectRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartStartObjectRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ChartStartObjectRecord() {
        return Short.valueOf(this.iObjectKind);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ChartStartObjectRecord() {
        return Short.valueOf(this.iObjectContext);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ChartStartObjectRecord() {
        return Short.valueOf(this.iObjectInstance1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$ChartStartObjectRecord() {
        return Short.valueOf(this.iObjectInstance2);
    }
}
