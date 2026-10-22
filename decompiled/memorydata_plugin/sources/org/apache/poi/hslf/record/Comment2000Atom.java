package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.util.SystemTimeUtils;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class Comment2000Atom extends RecordAtom {
    private byte[] _data;
    private byte[] _header;

    public Comment2000Atom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[28];
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public Comment2000Atom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public Date getDate() {
        return SystemTimeUtils.getDate(this._data, 4);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("number", new $$Lambda$phB2pHKPZUBczRgXNKYUbyB8aO8(this), "date", new $$Lambda$cTzDoDi8ITJY2oDoul2o4an_eoM(this), "xOffset", new $$Lambda$122iYGMClLazMIfx1SKlWGTPRVg(this), "yOffset", new $$Lambda$3AZqsImOEboTYHGaIupjPuhrZgc(this));
    }

    public int getNumber() {
        return LittleEndian.getInt(this._data, 0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.Comment2000Atom.typeID;
    }

    public int getXOffset() {
        return LittleEndian.getInt(this._data, 20);
    }

    public int getYOffset() {
        return LittleEndian.getInt(this._data, 24);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
