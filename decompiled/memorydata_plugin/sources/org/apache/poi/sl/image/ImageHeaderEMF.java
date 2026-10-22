package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class ImageHeaderEMF {
    private static final c LOG = null;
    private final Rectangle deviceBounds;

    static {
        LOG = b.a(ImageHeaderEMF.class);
    }

    public ImageHeaderEMF(byte[] r9, int r10) {
        int r0 = (int) LittleEndian.getUInt(r9, r10);
        int r11 = r10 + 4;
        int r2 = 0;
        if (r0 == 1) goto L6;
        LOG.atWarn().a("Invalid EMF picture - invalid type");
        this.deviceBounds = new Rectangle(0, 0, 200, 200);
        return;
    L6:
        int r12 = r11 + 4;
        int r1 = LittleEndian.getInt(r9, r12);
        int r13 = r12 + 4;
        int r3 = LittleEndian.getInt(r9, r13);
        int r14 = r13 + 4;
        int r4 = LittleEndian.getInt(r9, r14);
        int r15 = r14 + 4;
        int r5 = LittleEndian.getInt(r9, r15);
        int r16 = r15 + 4;
        int r6 = r4 - r1;
        if (r6 != (-1)) goto L9;
        r6 = 0;
    L9:
        int r7 = r5 - r3;
        if (r7 == (-1)) goto L13;
        r2 = r7;
    L13:
        this.deviceBounds = new Rectangle(r1, r3, r6, r2);
        if (" EMF".equals(new String(r9, r16 + 16, 4, LocaleUtil.CHARSET_1252)) == true) goto L17;
        LOG.atWarn().a("Invalid EMF picture - invalid signature");
        return;
    }

    public Dimension getSize() {
        return this.deviceBounds.getSize();
    }
}
