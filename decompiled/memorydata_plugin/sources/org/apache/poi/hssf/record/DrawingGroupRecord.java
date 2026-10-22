package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ddf.EscherRecord;

/* JADX INFO: loaded from: classes7.dex */
public final class DrawingGroupRecord extends AbstractEscherHolderRecord {
    private static int MAX_RECORD_SIZE = 8228;

    static {
    }

    public DrawingGroupRecord() {
    }

    public DrawingGroupRecord(RecordInputStream r1) {
        super(r1);
    }

    private static int getMaxDataSize() {
        return MAX_RECORD_SIZE - 4;
    }

    private int getRawDataSize() {
        List<EscherRecord> r0 = getEscherRecords();
        byte[] r4 = getRawData();
        if (r0.isEmpty() == false) goto L7;
        if (r4 == null) goto L7;
        return r4.length;
    L7:
        int r5 = 0;
        Iterator<EscherRecord> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        r5 = r5 + ((EscherRecord) ZeusTransformUtils.preCheckCast(r1.next(), EscherRecord.class, "com.obric.memorydata.plugin")).getRecordSize();
        goto L9
    L11:
        return r5;
    }

    static int grossSizeFromDataSize(int r2) {
        return r2 + ((((r2 - 1) / getMaxDataSize()) + 1) * 4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.DRAWING_GROUP;
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        return grossSizeFromDataSize(getRawDataSize());
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 235;
    }
}
