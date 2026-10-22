package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartStartBlockRecord extends StandardRecord {
    private short grbitFrt;
    private short iObjectContext;
    private short iObjectInstance1;
    private short iObjectInstance2;
    private short iObjectKind;
    private short rt;

    public ChartStartBlockRecord() {
    }

    public ChartStartBlockRecord(RecordInputStream r2) {
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
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$ChartStartBlockRecord$5vN_tQKpwmKQoxxYnvDw_KxDU(this), "grbitFrt", new $$Lambda$ChartStartBlockRecord$T695N84Z9VSxTWw1xFGzxJKj1ek(this), "iObjectKind", new $$Lambda$ChartStartBlockRecord$PwDVXLx2WcyziFILkPMsdWw3rE(this), "iObjectContext", new $$Lambda$ChartStartBlockRecord$R_xbdZvAe5wVTvtnOHHTPYX3xFk(this), "iObjectInstance1", new $$Lambda$ChartStartBlockRecord$sFhJKAW31mgYoUlOVItEOmokvw(this), "iObjectInstance2", new $$Lambda$ChartStartBlockRecord$M7T0b5sboNmB5VNlI41QqYHi4Y(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_START_BLOCK;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2130;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ChartStartBlockRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartStartBlockRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ChartStartBlockRecord() {
        return Short.valueOf(this.iObjectKind);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ChartStartBlockRecord() {
        return Short.valueOf(this.iObjectContext);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ChartStartBlockRecord() {
        return Short.valueOf(this.iObjectInstance1);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$ChartStartBlockRecord() {
        return Short.valueOf(this.iObjectInstance2);
    }
}
