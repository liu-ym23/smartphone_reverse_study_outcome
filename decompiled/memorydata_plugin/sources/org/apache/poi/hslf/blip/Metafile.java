package org.apache.poi.hslf.blip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.Units;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Metafile extends HSLFPictureData {

    public static class Header {
        private final Rectangle bounds;
        private int compression;
        private int filter;
        private final Dimension size;
        private int wmfsize;
        private int zipsize;

        public Header() {
            this.bounds = new Rectangle();
            this.size = new Dimension();
            this.filter = 254;
        }

        static /* synthetic */ Dimension access$000(Header r0) {
            return r0.size;
        }

        public Rectangle getBounds() {
            return (Rectangle) ZeusTransformUtils.preCheckCast(this.bounds.clone(), Rectangle.class, "com.obric.memorydata.plugin");
        }

        public int getSize() {
            return 34;
        }

        public int getWmfSize() {
            return this.wmfsize;
        }

        public void read(byte[] r5, int r6) {
            LittleEndianInputStream r0 = new LittleEndianInputStream(new UnsynchronizedByteArrayInputStream(r5, r6, 34));     // Catch: IOException -> L14
            this.wmfsize = r0.readInt();     // Catch: Throwable -> L6
            int r7 = r0.readInt();     // Catch: Throwable -> L6
            int r8 = r0.readInt();     // Catch: Throwable -> L6
            int r1 = r0.readInt();     // Catch: Throwable -> L6
            int r2 = r0.readInt();     // Catch: Throwable -> L6
            this.bounds.setBounds(r7, r8, r1 - r7, r2 - r8);     // Catch: Throwable -> L6
            int r9 = r0.readInt();     // Catch: Throwable -> L6
            int r10 = r0.readInt();     // Catch: Throwable -> L6
            this.size.setSize(r9, r10);     // Catch: Throwable -> L6
            this.zipsize = r0.readInt();     // Catch: Throwable -> L6
            this.compression = r0.readUByte();     // Catch: Throwable -> L6
            this.filter = r0.readUByte();     // Catch: Throwable -> L6
            r0.close();     // Catch: IOException -> L14
            return;
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
        L14:
            e = move-exception;
            throw new IllegalStateException(e);
        }
    }

    public Metafile(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public Dimension getImageDimension() {
        int r0 = getUIDInstanceCount() * 16;
        Header r1 = new Header();
        r1.read(getRawData(), r0);
        return new Dimension((int) Math.round(Units.toPoints((long) Header.access$000(r1).getWidth())), (int) Math.round(Units.toPoints((long) Header.access$000(r1).getHeight())));
    }
}
