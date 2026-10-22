package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: classes7.dex */
public class ImageHeaderBitmap {
    private static final c LOG = null;
    private final Dimension size;

    static {
        LOG = b.a(ImageHeaderBitmap.class);
    }

    public ImageHeaderBitmap(byte[] r4, int r5) {
        BufferedImage r6 = ImageIO.read(new UnsynchronizedByteArrayInputStream(r4, r5, r4.length - r5));     // Catch: IOException -> L5
    L7:
        if (r6 != null) goto L9;
        Dimension r7 = new Dimension(200, 200);
    L10:
        this.size = r7;
        return;
    L9:
        r7 = new Dimension((int) Units.pixelToPoints(r6.getWidth()), (int) Units.pixelToPoints(r6.getHeight()));
    L5:
        e = move-exception;
        LOG.atWarn().a(e).a("Can't determine image dimensions");
        r6 = null;
        goto L7
    }

    public Dimension getSize() {
        return this.size;
    }
}
