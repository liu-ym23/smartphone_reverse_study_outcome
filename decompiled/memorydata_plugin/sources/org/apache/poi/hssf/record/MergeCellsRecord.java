package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class MergeCellsRecord extends StandardRecord {
    private final int _numberOfRegions;
    private final CellRangeAddress[] _regions;
    private final int _startIndex;

    public MergeCellsRecord(RecordInputStream r6) {
        int r0 = r6.readUShort();
        CellRangeAddress[] r1 = new CellRangeAddress[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = new CellRangeAddress(r6);
        r3 = r3 + 1;
        goto L3
    L5:
        this._numberOfRegions = r0;
        this._startIndex = 0;
        this._regions = r1;
    }

    public MergeCellsRecord(CellRangeAddress[] r1, int r2, int r3) {
        this._regions = r1;
        this._startIndex = r2;
        this._numberOfRegions = r3;
    }

    public CellRangeAddress getAreaAt(int r2) {
        return this._regions[this._startIndex + r2];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CellRangeAddressList.getEncodedSize(this._numberOfRegions);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("numRegions", new $$Lambda$ZkqW7RjWdygNq7YaQ5TfPjZV6Zg(this), "regions", new $$Lambda$MergeCellsRecord$MqxNTuJlO5iMusCPEZoR9WsP45o(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.MERGE_CELLS;
    }

    public short getNumAreas() {
        return (short) this._numberOfRegions;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 229;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$MergeCellsRecord() {
        CellRangeAddress[] r0 = this._regions;
        int r1 = this._startIndex;
        return (CellRangeAddress[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(r0, r1, this._numberOfRegions + r1), CellRangeAddress[].class, "com.obric.memorydata.plugin");
    }
}
