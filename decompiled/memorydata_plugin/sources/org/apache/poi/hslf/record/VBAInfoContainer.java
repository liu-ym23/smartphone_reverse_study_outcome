package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class VBAInfoContainer extends RecordContainer {
    private static final long _type = 0;
    private byte[] _header;

    static {
        _type = RecordTypes.VBAInfo.typeID;
    }

    public VBAInfoContainer(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._children = Record.findChildRecords(r2, r0, r4 - 8);
        findInterestingChildren();
    }

    private void findInterestingChildren() {
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
