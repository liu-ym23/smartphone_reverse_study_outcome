package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class TabIdRecord extends StandardRecord {
    private static final short[] EMPTY_SHORT_ARRAY = null;
    private short[] _tabids;

    static {
        EMPTY_SHORT_ARRAY = new short[0];
    }

    public TabIdRecord() {
        this._tabids = EMPTY_SHORT_ARRAY;
    }

    public TabIdRecord(RecordInputStream r4) {
        this._tabids = new short[r4.remaining() / 2];
        int r0 = 0;
    L3:
        short[] r1 = this._tabids;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r4.readShort();
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._tabids.length * 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("elements", new $$Lambda$TabIdRecord$o8LYSyncb98umNq_PjhM0tlSTBs(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.TAB_ID;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 317;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$TabIdRecord() {
        return this._tabids;
    }

    public void setTabIdArray(short[] r3) {
        this._tabids = (short[]) ZeusTransformUtils.preCheckCast(r3.clone(), short[].class, "com.obric.memorydata.plugin");
    }
}
