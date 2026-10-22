package org.apache.poi.sl.image;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.OutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ImageHeaderWMF {
    private static final c LOG = null;
    private final int bottom;
    private int checksum;
    private final int handle;
    private final int inch;
    private final int left;
    private final int reserved;
    private final int right;
    private final int top;

    static {
        LOG = b.a(ImageHeaderWMF.class);
    }

    public ImageHeaderWMF(Rectangle r4) {
        Rectangle r5 = (Rectangle) ZeusTransformUtils.wrapperContextForParams(r4, Rectangle.class, "com.obric.memorydata.plugin");
        this.handle = 0;
        this.left = r5.x;
        this.top = r5.y;
        this.right = r5.x + r5.width;
        this.bottom = r5.y + r5.height;
        this.inch = 72;
        this.reserved = 0;
    }

    public ImageHeaderWMF(byte[] r3, int r4) {
        int r0 = LittleEndian.getInt(r3, r4);
        int r5 = r4 + 4;
        if (r0 == (-1698247209)) goto L6;
        LOG.atWarn().a("WMF file doesn't contain a placeable header - ignore parsing");
        this.handle = 0;
        this.left = 0;
        this.top = 0;
        this.right = 200;
        this.bottom = 200;
        this.inch = 72;
        this.reserved = 0;
        return;
    L6:
        this.handle = LittleEndian.getUShort(r3, r5);
        int r6 = r5 + 2;
        this.left = LittleEndian.getShort(r3, r6);
        int r7 = r6 + 2;
        this.top = LittleEndian.getShort(r3, r7);
        int r8 = r7 + 2;
        this.right = LittleEndian.getShort(r3, r8);
        int r9 = r8 + 2;
        this.bottom = LittleEndian.getShort(r3, r9);
        int r10 = r9 + 2;
        this.inch = LittleEndian.getUShort(r3, r10);
        int r11 = r10 + 2;
        this.reserved = LittleEndian.getInt(r3, r11);
        short r12 = LittleEndian.getShort(r3, r11 + 4);
        this.checksum = r12;
        if (r12 == getChecksum()) goto L10;
        LOG.atWarn().a("WMF checksum does not match the header data");
        return;
    }

    public int getChecksum() {
        int r0 = (((this.left ^ (-43247)) ^ this.top) ^ this.right) ^ this.bottom;
        return this.inch ^ r0;
    }

    public Dimension getSize() {
        double r2 = 72.0d / ((double) this.inch);
        return new Dimension((int) Math.round(((double) (this.right - this.left)) * r2), (int) Math.round(((double) (this.bottom - this.top)) * r2));
    }

    public void write(OutputStream r5) {
        byte[] r0 = new byte[22];
        LittleEndian.putInt(r0, 0, -1698247209);
        LittleEndian.putUShort(r0, 4, 0);
        LittleEndian.putUShort(r0, 6, this.left);
        LittleEndian.putUShort(r0, 8, this.top);
        LittleEndian.putUShort(r0, 10, this.right);
        LittleEndian.putUShort(r0, 12, this.bottom);
        LittleEndian.putUShort(r0, 14, this.inch);
        LittleEndian.putInt(r0, 16, 0);
        int r1 = getChecksum();
        this.checksum = r1;
        LittleEndian.putUShort(r0, 20, r1);
        r5.write(r0);
    }
}
