package org.apache.poi.common.usermodel;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import org.apache.poi.poifs.filesystem.FileMagic;

/* JADX INFO: loaded from: classes4.dex */
public final enum PictureType extends Enum<PictureType> {
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
    private static final HashMap<Integer, PictureType> PICTURE_TYPE_BY_OOXML_ID = null;
    public static final PictureType PNG = null;
    public static final PictureType SVG = null;
    public static final PictureType TIFF = null;
    public static final PictureType UNKNOWN = null;
    public static final PictureType WDP = null;
    public static final PictureType WMF = null;
    public static final PictureType WPG = null;
    public final String contentType;
    public final String extension;
    public final int ooxmlId;

    /* JADX INFO: renamed from: org.apache.poi.common.usermodel.PictureType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = null;

        static {
            int[] r0 = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = r0;
            r0[FileMagic.BMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.GIF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.JPEG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.PNG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.XML.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.WMF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.EMF.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.TIFF.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.UNKNOWN.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    static {
        PictureType r6 = new PictureType("EMF", 0, "image/x-emf", ".emf", 2);
        EMF = r6;
        PictureType r0 = new PictureType("WMF", 1, "image/x-wmf", ".wmf", 3);
        WMF = r0;
        PictureType r1 = new PictureType("PICT", 2, "image/x-pict", ".pict", 4);
        PICT = r1;
        PictureType r2 = new PictureType("JPEG", 3, "image/jpeg", ".jpg", 5);
        JPEG = r2;
        PictureType r3 = new PictureType("PNG", 4, "image/png", ".png", 6);
        PNG = r3;
        PictureType r4 = new PictureType("DIB", 5, "image/dib", ".dib", 7);
        DIB = r4;
        PictureType r5 = new PictureType("GIF", 6, "image/gif", ".gif", 8);
        GIF = r5;
        PictureType r13 = new PictureType("TIFF", 7, "image/tiff", ".tif", 9);
        TIFF = r13;
        PictureType r7 = new PictureType("EPS", 8, "image/x-eps", ".eps", 10);
        EPS = r7;
        PictureType r8 = new PictureType("BMP", 9, "image/x-ms-bmp", ".bmp", 11);
        BMP = r8;
        PictureType r9 = new PictureType("WPG", 10, "image/x-wpg", ".wpg", 12);
        WPG = r9;
        PictureType r10 = new PictureType("WDP", 11, "image/vnd.ms-photo", ".wdp", 13);
        WDP = r10;
        PictureType r11 = new PictureType("SVG", 12, "image/svg+xml", ".svg", -1);
        SVG = r11;
        PictureType r12 = new PictureType("UNKNOWN", 13, "", ".dat", -1);
        UNKNOWN = r12;
        PictureType r20 = new PictureType(CipherConst.LEVEL_ERROR, 14, "", ".dat", -1);
        ERROR = r20;
        PictureType r14 = new PictureType("CMYKJPEG", 15, "image/jpeg", ".jpg", -1);
        CMYKJPEG = r14;
        PictureType r15 = new PictureType("CLIENT", 16, "", ".dat", -1);
        CLIENT = r15;
        $VALUES = new PictureType[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15};
        PICTURE_TYPE_BY_OOXML_ID = new HashMap();
        PictureType[] r16 = values();
        int r17 = r16.length;
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L8;
        PictureType r19 = r16[r18];
        int r21 = r19.ooxmlId;
        if (r21 < (-1)) goto L7;
        PICTURE_TYPE_BY_OOXML_ID.put(Integer.valueOf(r21), r19);
    L7:
        r18 = r18 + 1;
        goto L3
    }

    private PictureType(String r1, int r2, String r3, String r4, int r5) {
        super(r1, r2);
        this.contentType = r3;
        this.extension = r4;
        this.ooxmlId = r5;
    }

    public static PictureType findByOoxmlId(int r2) {
        return (PictureType) ZeusTransformUtils.preCheckCast(PICTURE_TYPE_BY_OOXML_ID.get(Integer.valueOf(r2)), PictureType.class, "com.obric.memorydata.plugin");
    }

    public static PictureType valueOf(String r2) {
        return (PictureType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PictureType.class, r2), PictureType.class, "com.obric.memorydata.plugin");
    }

    public static PictureType valueOf(FileMagic r1) {
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[r1.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        return UNKNOWN;
    L7:
        return TIFF;
    L9:
        return EMF;
    L11:
        return WMF;
    L13:
        return SVG;
    L15:
        return PNG;
    L17:
        return JPEG;
    L19:
        return GIF;
    L21:
        return BMP;
    }

    public static PictureType[] values() {
        return (PictureType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PictureType[].class, "com.obric.memorydata.plugin");
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getExtension() {
        return this.extension;
    }

    public int getOoxmlId() {
        return this.ooxmlId;
    }
}
