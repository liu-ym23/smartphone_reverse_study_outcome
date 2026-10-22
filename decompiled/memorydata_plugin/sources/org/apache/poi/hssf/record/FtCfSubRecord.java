package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class FtCfSubRecord extends SubRecord {
    private short flags;

    FtCfSubRecord(LittleEndianInput r2, int r3, int r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r3 != 2) goto L7;
        this.flags = r5.readShort();
        return;
    L7:
        throw new RecordFormatException("Unexpected size (" + r3 + ")");
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return 2;
    }

    public short getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$ws8Yrojg9KTtb9meHWNcQQt1k4(this), new int[]{2, 9, -1}, new String[]{"METAFILE", "BITMAP", "UNSPECIFIED"}));
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.FT_CF;
    }
}
