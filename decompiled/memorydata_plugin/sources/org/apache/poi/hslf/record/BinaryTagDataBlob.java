package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class BinaryTagDataBlob extends PositionDependentRecordContainer {
    private byte[] _header;
    private long _type;

    public BinaryTagDataBlob(byte[] r4, int r5, int r6) {
        int r0 = r5 + 8;
        byte[] r7 = Arrays.copyOfRange(r4, r5, r0);
        this._header = r7;
        this._type = LittleEndian.getUShort(r7, 2);
        this._children = Record.findChildRecords(r4, r0, r6 - 8);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this._type;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], this._type, this._children, r10);
    }
}
