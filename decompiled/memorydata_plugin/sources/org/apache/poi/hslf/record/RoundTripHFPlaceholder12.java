package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class RoundTripHFPlaceholder12 extends RecordAtom {
    private byte[] _header;
    private byte _placeholderId;

    public RoundTripHFPlaceholder12(byte[] r1, int r2, int r3) {
        int r4 = r2 + 8;
        this._header = Arrays.copyOfRange(r1, r2, r4);
        this._placeholderId = r1[r4];
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("placeholderId", new $$Lambda$OP_4wOKKWKG2IOOcb6nTZRqQo(this));
    }

    public int getPlaceholderId() {
        return this._placeholderId;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.RoundTripHFPlaceholder12.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._placeholderId);
    }
}
