package org.apache.poi.hslf.blip;

import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.record.RecordAtom;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class DIB extends Bitmap {
    @Deprecated
    public DIB() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public DIB(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    public static byte[] addBMPHeader(byte[] r7) {
        byte[] r1 = new byte[14];
        LittleEndian.putInt(r1, 0, 19778);
        int r3 = LittleEndian.getInt(r7, 20);
        int r4 = r7.length + 14;
        LittleEndian.putInt(r1, 2, r4);
        LittleEndian.putInt(r1, 6, 0);
        LittleEndian.putInt(r1, 10, r4 - r3);
        byte[] r5 = IOUtils.safelyAllocate(((long) 14) + ((long) r7.length), RecordAtom.getMaxRecordLength());
        System.arraycopy(r1, 0, r5, 0, 14);
        System.arraycopy(r7, 0, r5, 14, r7.length);
        return r5;
    }

    @Override // org.apache.poi.hslf.blip.Bitmap, org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        return addBMPHeader(super.getData());
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        if (getUIDInstanceCount() != 1) goto L5;
        return 31360;
    L5:
        return 31376;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.DIB;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r2) {
        if (r2 != 31360) goto L5;
        int r3 = 1;
    L10:
        setUIDInstanceCount(r3);
        return;
    L5:
        if (r2 != 31376) goto L8;
        r3 = 2;
        goto L10
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid instance/signature value for DIB");
    }
}
