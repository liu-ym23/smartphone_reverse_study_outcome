package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class IterationRecord extends StandardRecord {
    private static final BitField iterationOn = null;
    private int _flags;

    static {
        iterationOn = BitFieldFactory.getInstance(1);
    }

    public IterationRecord(RecordInputStream r1) {
        this._flags = r1.readShort();
    }

    public IterationRecord(boolean r3) {
        this._flags = iterationOn.setBoolean(0, r3);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", new $$Lambda$IterationRecord$HJ7YigqBBlPqXFoOQxXBfA4mHfc(this), "iteration", new $$Lambda$rwMfvFi52nTDkpbAf7wU99VpnjY(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ITERATION;
    }

    public boolean getIteration() {
        return iterationOn.isSet(this._flags);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 17;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$IterationRecord() {
        return Integer.valueOf(this._flags);
    }
}
