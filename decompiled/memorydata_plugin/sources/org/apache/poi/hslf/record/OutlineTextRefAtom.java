package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class OutlineTextRefAtom extends RecordAtom {
    private byte[] _header;
    private int _index;

    public OutlineTextRefAtom() {
        this._index = 0;
        byte[] r1 = new byte[8];
        this._header = r1;
        LittleEndian.putUShort(r1, 0, 0);
        LittleEndian.putUShort(this._header, 2, (int) getRecordType());
        LittleEndian.putInt(this._header, 4, 4);
    }

    public OutlineTextRefAtom(byte[] r1, int r2, int r3) {
        int r4 = r2 + 8;
        this._header = Arrays.copyOfRange(r1, r2, r4);
        this._index = LittleEndian.getInt(r1, r4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("textIndex", new $$Lambda$9Og4CojZ_QeK0E2L1W9L1LTU3lw(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.OutlineTextRefAtom.typeID;
    }

    public int getTextIndex() {
        return this._index;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        byte[] r0 = new byte[4];
        LittleEndian.putInt(r0, 0, this._index);
        r3.write(r0);
    }
}
