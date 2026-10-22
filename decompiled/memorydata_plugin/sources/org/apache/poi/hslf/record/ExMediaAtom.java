package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ExMediaAtom extends RecordAtom {
    private static final int[] FLAG_MASKS = null;
    private static final String[] FLAG_NAMES = null;
    private byte[] _header;
    private byte[] _recdata;

    static {
        FLAG_MASKS = new int[]{1, 2, 4};
        FLAG_NAMES = new String[]{"LOOP", "REWIND", "NARRATION"};
    }

    public ExMediaAtom() {
        this._recdata = new byte[8];
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._recdata.length);
    }

    public ExMediaAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._recdata = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("objectId", new $$Lambda$yYU89Bn3DCgQgqsgXSifO9yG3no(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$f28pW6byQHgoUyQtU9VeAPpjqJw(this), FLAG_MASKS, FLAG_NAMES));
    }

    public int getMask() {
        return LittleEndian.getInt(this._recdata, 4);
    }

    public int getObjectId() {
        return LittleEndian.getInt(this._recdata, 0);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExMediaAtom.typeID;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._recdata);
    }
}
