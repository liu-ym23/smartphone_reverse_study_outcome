package org.apache.poi.hssf.record.chart;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public final class ChartFRTInfoRecord extends StandardRecord {
    private final short grbitFrt;
    private CFRTID[] rgCFRTID;
    private final short rt;
    private final byte verOriginator;
    private final byte verWriter;

    private static final class CFRTID {
        private final int rtFirst;
        private final int rtLast;

        public CFRTID(LittleEndianInput r3) {
            LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
            this.rtFirst = r4.readShort();
            this.rtLast = r4.readShort();
        }
    }

    public ChartFRTInfoRecord(RecordInputStream r5) {
        this.rt = r5.readShort();
        this.grbitFrt = r5.readShort();
        this.verOriginator = r5.readByte();
        this.verWriter = r5.readByte();
        int r0 = r5.readShort();
        if (r0 < 0) goto L9;
        this.rgCFRTID = new CFRTID[r0];
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.rgCFRTID[r1] = new CFRTID(r5);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("Had negative CFRTID: " + r0);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this.rgCFRTID.length * 4) + 8;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("rt", new $$Lambda$ChartFRTInfoRecord$l4_8S2CPkuH7w4aVdSCuXif9ZO0(this), "grbitFrt", new $$Lambda$ChartFRTInfoRecord$SkwyW2l3zBr1wLpAPq6AJfCNit0(this), "verOriginator", new $$Lambda$ChartFRTInfoRecord$EtGfN80BfZxa5JOOQucjf6XAMg(this), "verWriter", new $$Lambda$ChartFRTInfoRecord$dbOr667chHEpsG8sHHOZNEKgGNg(this), "rgCFRTIDs", new $$Lambda$ChartFRTInfoRecord$xQNjj3sUnucif8euQ0wSLlsrfZA(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CHART_FRT_INFO;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 2128;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ChartFRTInfoRecord() {
        return Short.valueOf(this.rt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ChartFRTInfoRecord() {
        return Short.valueOf(this.grbitFrt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ChartFRTInfoRecord() {
        return Byte.valueOf(this.verOriginator);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ChartFRTInfoRecord() {
        return Byte.valueOf(this.verWriter);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$ChartFRTInfoRecord() {
        return this.rgCFRTID;
    }
}
