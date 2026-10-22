package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SoundData extends RecordAtom {
    private static int MAX_RECORD_LENGTH = 100000000;
    private byte[] _data;
    private byte[] _header;

    static {
    }

    public SoundData() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[0];
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public SoundData(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, MAX_RECORD_LENGTH);
    }

    public byte[] getData() {
        return this._data;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("data", new $$Lambda$GL3LNAGz6ot4lYw3CBZ6aYFWnNU(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.SoundData.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
