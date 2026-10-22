package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SlideAtom extends RecordAtom {
    private static long _type = 1007;
    private byte[] _header;
    private boolean followMasterBackground;
    private boolean followMasterObjects;
    private boolean followMasterScheme;
    private SlideAtomLayout layoutAtom;
    private int masterID;
    private int notesID;
    private byte[] reserved;

    static {
    }

    public SlideAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 2);
        LittleEndian.putUShort(this._header, 2, (int) _type);
        LittleEndian.putInt(this._header, 4, 24);
        SlideAtomLayout r3 = new SlideAtomLayout(new byte[12]);
        this.layoutAtom = r3;
        r3.setGeometryType(SlideAtomLayout.SlideLayoutType.BLANK_SLIDE);
        this.followMasterObjects = true;
        this.followMasterScheme = true;
        this.followMasterBackground = true;
        this.masterID = Integer.MIN_VALUE;
        this.notesID = 0;
        this.reserved = new byte[2];
    }

    public SlideAtom(byte[] r7, int r8, int r9) {
        if (r9 >= 30) goto L5;
        r9 = 30;
    L5:
        int r1 = r8 + 8;
        this._header = Arrays.copyOfRange(r7, r8, r1);
        int r2 = (r8 + 12) + 8;
        this.layoutAtom = new SlideAtomLayout(Arrays.copyOfRange(r7, r1, r2));
        this.masterID = LittleEndian.getInt(r7, r2);
        this.notesID = LittleEndian.getInt(r7, (r8 + 16) + 8);
        int r3 = LittleEndian.getUShort(r7, (r8 + 20) + 8);
        boolean r4 = false;
        if ((r3 & 4) != 4) goto L8;
        boolean r5 = true;
    L9:
        this.followMasterBackground = r5;
        if ((r3 & 2) != 2) goto L12;
        boolean r6 = true;
    L13:
        this.followMasterScheme = r6;
        if ((r3 & 1) != 1) goto L16;
        r4 = true;
    L16:
        this.followMasterObjects = r4;
        this.reserved = IOUtils.safelyClone(r7, r8 + 30, r9 - 30, getMaxRecordLength());
        return;
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = false;
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
        return GenericRecordUtil.getGenericProperties("masterID", new $$Lambda$SjZ9RbemSZsCk5wZEr5KKDwd2uk(this), "notesID", new $$Lambda$IVeBy9zfk4KH1hVYrxlAiYVs2Qo(this), "followMasterObjects", new $$Lambda$kB0buwO1t1gNI0sJoN_1EBC5RKw(this), "followMasterScheme", new $$Lambda$ndhDnWrakMJqM0hAGf343lhbc50(this), "followMasterBackground", new $$Lambda$ZgckKdCYo76TRAkN06_N08U8aCI(this), "layoutAtom", new $$Lambda$5D8kArbBDw01eagzrLkICPyroPI(this));
    }

    public int getMasterID() {
        return this.masterID;
    }

    public int getNotesID() {
        return this.notesID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public SlideAtomLayout getSSlideLayoutAtom() {
        return this.layoutAtom;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r3) {
        r3.write(this._header);
        this.layoutAtom.writeOut(r3);
        writeLittleEndian(this.masterID, r3);
        writeLittleEndian(this.notesID, r3);
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
