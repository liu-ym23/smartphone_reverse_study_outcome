package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class OEPlaceholderAtom extends RecordAtom {
    private final byte[] _header;
    private int placeholderId;
    private int placeholderSize;
    private int placementId;
    private short unusedShort;

    OEPlaceholderAtom(byte[] r1, int r2, int r3) {
        int r4 = r2 + 8;
        this._header = Arrays.copyOfRange(r1, r2, r4);
        this.placementId = LittleEndian.getInt(r1, r4);
        int r5 = r4 + 4;
        this.placeholderId = LittleEndian.getUByte(r1, r5);
        int r6 = r5 + 1;
        this.placeholderSize = LittleEndian.getUByte(r1, r6);
        this.unusedShort = LittleEndian.getShort(r1, r6 + 1);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("placementId", new $$Lambda$bZsepPanM5Et51iuniZMkU3j0eg(this), "placeholderId", new $$Lambda$KpHnPREfQgHW_htgiafyJ3Q6j4Y(this), "placeholderSize", new $$Lambda$PNjpPnRBxqctiDXyHyVcUDC3z5U(this));
    }

    public int getPlaceholderId() {
        return this.placeholderId;
    }

    public int getPlaceholderSize() {
        return this.placeholderSize;
    }

    public int getPlacementId() {
        return this.placementId;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.OEPlaceholderAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r4) {
        r4.write(this._header);
        byte[] r0 = new byte[8];
        LittleEndian.putInt(r0, 0, this.placementId);
        r0[4] = (byte) this.placeholderId;
        r0[5] = (byte) this.placeholderSize;
        LittleEndian.putShort(r0, 6, this.unusedShort);
        r4.write(r0);
    }
}
