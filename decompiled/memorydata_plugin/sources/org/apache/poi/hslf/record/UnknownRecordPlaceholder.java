package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class UnknownRecordPlaceholder extends RecordAtom {
    private byte[] _contents;
    private long _type;

    public UnknownRecordPlaceholder(byte[] r2, int r3, int r4) {
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        byte[] r5 = IOUtils.safelyClone(r2, r3, r4, 20000000);
        this._contents = r5;
        this._type = LittleEndian.getUShort(r5, 2);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("contents", new $$Lambda$UnknownRecordPlaceholder$kxeX8cbb0EBikfXF4KHj6fhzUk(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this._type;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UnknownRecordPlaceholder() {
        return this._contents;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r1) {
        r1.write(this._contents);
    }
}
