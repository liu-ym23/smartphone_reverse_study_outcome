package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class NotesAtom extends RecordAtom {
    private static long _type = 1009;
    private byte[] _header;
    private boolean followMasterBackground;
    private boolean followMasterObjects;
    private boolean followMasterScheme;
    private byte[] reserved;
    private int slideID;

    static {
    }

    public NotesAtom(byte[] r6, int r7, int r8) {
        if (r8 >= 8) goto L5;
        r8 = 8;
    L5:
        int r0 = r7 + 8;
        this._header = Arrays.copyOfRange(r6, r7, r0);
        this.slideID = LittleEndian.getInt(r6, r0);
        int r1 = LittleEndian.getUShort(r6, r7 + 12);
        boolean r3 = false;
        if ((r1 & 4) != 4) goto L8;
        boolean r2 = true;
    L9:
        this.followMasterBackground = r2;
        if ((r1 & 2) != 2) goto L12;
        boolean r4 = true;
    L13:
        this.followMasterScheme = r4;
        if ((r1 & 1) != 1) goto L16;
        r3 = true;
    L16:
        this.followMasterObjects = r3;
        this.reserved = IOUtils.safelyClone(r6, r7 + 14, r8 - 14, getMaxRecordLength());
        return;
    L12:
        r4 = false;
        goto L13
    L8:
        r2 = false;
        goto L9
    }

    public boolean getFollowMasterBackground() {
        return this.followMasterBackground;
    }

    public boolean getFollowMasterObjects() {
        return this.followMasterObjects;
    }

    public boolean getFollowMasterScheme() {
        return this.followMasterScheme;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("slideId", new $$Lambda$kzhcIFlWDtOZN8z64qQ6uoZs1_0(this), "followMasterObjects", new $$Lambda$RMwzMT1Ffnvtz76w91VQnTfTK_I(this), "followMasterScheme", new $$Lambda$aSDuB9VvItOH2qLFdOCeohdrATs(this), "followMasterBackground", new $$Lambda$gilDoMM1ApTD5fhrU21H7_H8gqU(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public int getSlideID() {
        return this.slideID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        writeLittleEndian(this.slideID, r3);
        if (this.followMasterObjects == false) goto L5;
        short r0 = (short) 1;
    L7:
        if (this.followMasterScheme == false) goto L10;
        r0 = (short) (r0 + 2);
    L10:
        if (this.followMasterBackground == false) goto L12;
        r0 = (short) (r0 + 4);
    L12:
        writeLittleEndian(r0, r3);
        r3.write(this.reserved);
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
