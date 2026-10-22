package org.apache.poi.hslf.blip;

import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.sl.image.ImageHeaderPNG;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: loaded from: classes7.dex */
public final class PNG extends Bitmap {
    @Deprecated
    public PNG() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public PNG(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.hslf.blip.Bitmap, org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        return new ImageHeaderPNG(super.getData()).extractPNG();
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        if (getUIDInstanceCount() != 1) goto L5;
        return 28160;
    L5:
        return 28176;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.PNG;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r2) {
        if (r2 != 28160) goto L5;
        int r3 = 1;
    L10:
        setUIDInstanceCount(r3);
        return;
    L5:
        if (r2 != 28176) goto L8;
        r3 = 2;
        goto L10
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid instance/signature value for PNG");
    }
}
