package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ExControlAtom extends RecordAtom {
    private byte[] _header;
    private int _id;

    public ExControlAtom(byte[] r1, int r2, int r3) {
        int r4 = r2 + 8;
        this._header = Arrays.copyOfRange(r1, r2, r4);
        this._id = LittleEndian.getInt(r1, r4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("slideId", new $$Lambda$LZWR841_sYTYQhL4z7KfnWyMlyE(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExControlAtom.typeID;
    }

    public int getSlideId() {
        return this._id;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        byte[] r0 = new byte[4];
        LittleEndian.putInt(r0, 0, this._id);
        r3.write(r0);
    }
}
