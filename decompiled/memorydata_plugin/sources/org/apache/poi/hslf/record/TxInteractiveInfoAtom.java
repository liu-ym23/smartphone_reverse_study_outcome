package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class TxInteractiveInfoAtom extends RecordAtom {
    private byte[] _data;
    private byte[] _header;

    public TxInteractiveInfoAtom() {
        byte[] r1 = new byte[8];
        this._header = r1;
        this._data = new byte[8];
        LittleEndian.putShort(r1, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public TxInteractiveInfoAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public int getEndIndex() {
        return LittleEndian.getInt(this._data, 4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("startIndex", new $$Lambda$lZSxgYAMqEnP9pj1qhhvQPLVoi8(this), "endIndex", new $$Lambda$AX2zmQoSt8Bnr_eXPWA8CoslZsM(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.TxInteractiveInfoAtom.typeID;
    }

    public int getStartIndex() {
        return LittleEndian.getInt(this._data, 0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
