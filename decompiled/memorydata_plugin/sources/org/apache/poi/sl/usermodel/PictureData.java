package org.apache.poi.sl.usermodel;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Dimension;

/* JADX INFO: loaded from: classes7.dex */
public interface PictureData {

    public static final enum PictureType extends Enum<PictureType> {
        private static final /* synthetic */ PictureType[] $VALUES = null;
        public static final PictureType BMP = null;
        public static final PictureType CLIENT = null;
        public static final PictureType CMYKJPEG = null;
        public static final PictureType DIB = null;
        public static final PictureType EMF = null;
        public static final PictureType EPS = null;
        public static final PictureType ERROR = null;
        public static final PictureType GIF = null;
        public static final PictureType JPEG = null;
        public static final PictureType PICT = null;
        public static final PictureType PNG = null;
        public static final PictureType SVG = null;
        public static final PictureType TIFF = null;
        public static final PictureType UNKNOWN = null;
        public static final PictureType WDP = null;
        public static final PictureType WMF = null;
        public static final PictureType WPG = null;
        public final String contentType;
        public final String extension;
        public final int nativeId;
        public final int ooxmlId;

        static {
            PictureType r7 = new PictureType("EMF", 0, 2, 2, "image/x-emf", ".emf");
            EMF = r7;
            PictureType r0 = new PictureType("WMF", 1, 3, 3, "image/x-wmf", ".wmf");
            WMF = r0;
            PictureType r1 = new PictureType("PICT", 2, 4, 4, "image/x-pict", ".pict");
            PICT = r1;
            PictureType r2 = new PictureType("JPEG", 3, 5, 5, "image/jpeg", ".jpg");
            JPEG = r2;
            PictureType r3 = new PictureType("PNG", 4, 6, 6, "image/png", ".png");
            PNG = r3;
            PictureType r4 = new PictureType("DIB", 5, 7, 7, "image/dib", ".dib");
            DIB = r4;
            PictureType r5 = new PictureType("GIF", 6, -1, 8, "image/gif", ".gif");
            GIF = r5;
            PictureType r6 = new PictureType("TIFF", 7, 17, 9, "image/tiff", ".tif");
            TIFF = r6;
            PictureType r8 = new PictureType("EPS", 8, -1, 10, "image/x-eps", ".eps");
            EPS = r8;
            PictureType r16 = new PictureType("BMP", 9, -1, 11, "image/x-ms-bmp", ".bmp");
            BMP = r16;
            PictureType r9 = new PictureType("WPG", 10, -1, 12, "image/x-wpg", ".wpg");
            WPG = r9;
            PictureType r10 = new PictureType("WDP", 11, -1, 13, "image/vnd.ms-photo", ".wdp");
            WDP = r10;
            PictureType r11 = new PictureType("SVG", 12, -1, -1, "image/svg+xml", ".svg");
            SVG = r11;
            PictureType r12 = new PictureType("UNKNOWN", 13, 1, -1, "", ".dat");
            UNKNOWN = r12;
            PictureType r13 = new PictureType(CipherConst.LEVEL_ERROR, 14, 0, -1, "", ".dat");
            ERROR = r13;
            PictureType r14 = new PictureType("CMYKJPEG", 15, 18, -1, "image/jpeg", ".jpg");
            CMYKJPEG = r14;
            PictureType r15 = new PictureType("CLIENT", 16, 32, -1, "", ".dat");
            CLIENT = r15;
            $VALUES = new PictureType[]{r7, r0, r1, r2, r3, r4, r5, r6, r8, r16, r9, r10, r11, r12, r13, r14, r15};
        }

        private PictureType(String r1, int r2, int r3, int r4, String r5, String r6) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
            this.contentType = r5;
            this.extension = r6;
        }

        public static PictureType forNativeID(int r5) {
            PictureType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            PictureType r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            PictureType r4 = CLIENT;
            if (r5 < r4.nativeId) goto L12;
            return r4;
        L12:
            return UNKNOWN;
        }

        public static PictureType forOoxmlID(int r5) {
            PictureType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            PictureType r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static PictureType valueOf(String r2) {
            return (PictureType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PictureType.class, r2), PictureType.class, "com.obric.memorydata.plugin");
        }

        public static PictureType[] values() {
            return (PictureType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PictureType[].class, "com.obric.memorydata.plugin");
        }
    }

    byte[] getData();

    Dimension getImageDimension();

    PictureType getType();
}
