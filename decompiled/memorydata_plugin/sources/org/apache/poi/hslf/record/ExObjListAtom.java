package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExObjListAtom extends RecordAtom {
    private byte[] _data;
    private byte[] _header;

    public ExObjListAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[4];
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public ExObjListAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        byte[] r5 = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
        this._data = r5;
        if (r5.length < 4) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The length of the data for a ExObjListAtom must be at least 4 bytes, but was only " + this._data.length);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("objectIDSeed", new $$Lambda$ZKnG5HpYQLVxObJxGV0bPAyB8Kk(this));
    }

    public long getObjectIDSeed() {
        return LittleEndian.getUInt(this._data, 0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExObjListAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
