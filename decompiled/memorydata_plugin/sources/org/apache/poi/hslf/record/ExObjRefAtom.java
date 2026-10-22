package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class ExObjRefAtom extends RecordAtom {
    private byte[] _header;
    private int exObjIdRef;

    public ExObjRefAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 0);
        LittleEndian.putUShort(this._header, 2, (int) getRecordType());
        LittleEndian.putInt(this._header, 4, 4);
        this.exObjIdRef = 0;
    }

    public ExObjRefAtom(byte[] r1, int r2, int r3) {
        int r4 = r2 + 8;
        this._header = Arrays.copyOfRange(r1, r2, r4);
        this.exObjIdRef = (int) LittleEndian.getUInt(r1, r4);
    }

    public int getExObjIdRef() {
        return this.exObjIdRef;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("exObjIdRef", new $$Lambda$QPbRSxyKTBUdfSm4k32k01AOGME(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExObjRefAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r4) {
        r4.write(this._header);
        byte[] r0 = new byte[4];
        LittleEndian.putUInt(r0, 0, this.exObjIdRef);
        r4.write(r0);
    }
}
