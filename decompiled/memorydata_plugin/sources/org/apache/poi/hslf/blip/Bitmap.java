package org.apache.poi.hslf.blip;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Bitmap extends HSLFPictureData {
    public Bitmap(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public byte[] getData() {
        byte[] r0 = getRawData();
        int r3 = (getUIDInstanceCount() * 16) + 1;
        return IOUtils.safelyClone(r0, r3, r0.length - r3, r0.length);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public Dimension getImageDimension() {
        UnsynchronizedByteArrayInputStream r0 = new UnsynchronizedByteArrayInputStream(getData());     // Catch: IOException -> L14
        BufferedImage r5 = ImageIO.read(r0);     // Catch: Throwable -> L6
        Dimension r1 = new Dimension((int) Units.pixelToPoints(r5.getWidth()), (int) Units.pixelToPoints(r5.getHeight()));     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L14
        return r1;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: IOException -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L14
    L15:
        return new Dimension(200, 200);
    }
}
