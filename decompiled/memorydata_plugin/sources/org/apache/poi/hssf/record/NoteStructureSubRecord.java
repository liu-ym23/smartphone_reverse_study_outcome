package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class NoteStructureSubRecord extends SubRecord {
    private final byte[] reserved;

    public NoteStructureSubRecord(LittleEndianInput r3, int r4, int r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if (r4 != 22) goto L7;
        byte[] r7 = IOUtils.safelyAllocate(r4, 22);
        r6.readFully(r7);
        this.reserved = r7;
        return;
    L7:
        throw new RecordFormatException("Unexpected size (" + r4 + ")");
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return this.reserved.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("reserved", new $$Lambda$NoteStructureSubRecord$NFsHCXEh1CN73Gr933j7iAPk8aM(this));
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.NOTE_STRUCTURE;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$NoteStructureSubRecord() {
        return this.reserved;
    }
}
