package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class DateTimeMCAtom extends RecordAtom {
    private final byte[] _header;
    private int index;
    private int position;
    private final byte[] unused;

    public DateTimeMCAtom(byte[] r4, int r5, int r6) {
        byte[] r0 = new byte[3];
        this.unused = r0;
        int r1 = r5 + 8;
        this._header = Arrays.copyOfRange(r4, r5, r1);
        this.position = LittleEndian.getInt(r4, r1);
        this.index = LittleEndian.getUByte(r4, r5 + 12);
        System.arraycopy(r4, r5 + 13, r0, 0, 3);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("position", new $$Lambda$JQe1fN8aS8px4Em_NE127HqDLXs(this), "index", new $$Lambda$pv2VytTpMjuLL2ui1VOXdpwxyag(this));
    }

    public int getIndex() {
        return this.index;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.DateTimeMCAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        LittleEndian.putInt(this.position, r2);
        r2.write(this.index);
        r2.write(this.unused);
    }
}
