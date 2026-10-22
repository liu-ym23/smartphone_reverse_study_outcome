package org.apache.poi.sl.image;

import java.awt.Dimension;
import java.awt.Rectangle;

/* JADX INFO: loaded from: classes7.dex */
public class ImageHeaderPICT {
    private static final byte[] V2_HEADER = null;
    private final Rectangle bounds;
    private final double hRes;
    private final double vRes;

    static {
        V2_HEADER = new byte[]{0, 17, 2, -1, 12, 0, -1, -2, 0, 0};
    }

    public ImageHeaderPICT(byte[] r11, int r12) {
        int r13 = r12 + 2;
        int r0 = readUnsignedShort(r11, r13);
        int r14 = r13 + 2;
        int r1 = readUnsignedShort(r11, r14);
        int r15 = r14 + 2;
        int r2 = readUnsignedShort(r11, r15);
        int r16 = r15 + 2;
        int r3 = readUnsignedShort(r11, r16);
        int r17 = r16 + 2;
        byte[] r4 = V2_HEADER;
        int r5 = r4.length;
        boolean r6 = false;
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L8;
        int r9 = r17 + 1;
        if (r4[r7] != r11[r17]) goto L6;
        r7 = r7 + 1;
        r17 = r9;
        goto L3
    L6:
        r17 = r9;
    L9:
        if (r6 == false) goto L11;
        this.hRes = readFixedPoint(r11, r17);
        double r18 = readFixedPoint(r11, r17 + 4);
    L12:
        this.vRes = r18;
        this.bounds = new Rectangle(r1, r0, r3 - r1, r2 - r0);
        return;
    L11:
        r18 = 72.0d;
        this.hRes = 72.0d;
        goto L12
    L8:
        r6 = true;
        goto L9
    }

    private static double readFixedPoint(byte[] r3, int r4) {
        int r0 = r3[r4] & 255;
        int r1 = r3[r4 + 1] & 255;
        int r2 = r3[r4 + 2] & 255;
        return ((double) ((r3[r4 + 3] & 255) | (((r0 << 24) | (r1 << 16)) | (r2 << 8)))) / 65536.0d;
    }

    private static int readUnsignedShort(byte[] r1, int r2) {
        int r0 = r1[r2] & 255;
        return (r1[r2 + 1] & 255) | (r0 << 8);
    }

    public Dimension getSize() {
        int r0 = (int) Math.round((((double) this.bounds.height) * 72.0d) / this.vRes);
        return new Dimension((int) Math.round((((double) this.bounds.width) * 72.0d) / this.hRes), r0);
    }
}
