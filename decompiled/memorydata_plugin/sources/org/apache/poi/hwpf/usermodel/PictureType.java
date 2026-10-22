package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes7.dex */
public final enum PictureType extends Enum<PictureType> {
    private static final /* synthetic */ PictureType[] $VALUES = null;
    public static final PictureType BMP = null;
    public static final PictureType EMF = null;
    public static final PictureType GIF = null;
    public static final PictureType JPEG = null;
    public static final PictureType PICT = null;
    public static final PictureType PNG = null;
    public static final PictureType TIFF = null;
    public static final PictureType UNKNOWN = null;
    public static final PictureType WMF = null;
    private String _extension;
    private String _mime;
    private byte[][] _signatures;

    static {
        PictureType r6 = new PictureType("BMP", 0, "image/bmp", "bmp", new byte[][]{new byte[]{66, 77}});
        BMP = r6;
        PictureType r0 = new PictureType("EMF", 1, "image/x-emf", "emf", new byte[][]{new byte[]{1, 0, 0, 0}});
        EMF = r0;
        PictureType r2 = new PictureType("GIF", 2, "image/gif", "gif", new byte[][]{new byte[]{71, 73, 70}});
        GIF = r2;
        PictureType r3 = new PictureType("JPEG", 3, "image/jpeg", "jpg", new byte[][]{new byte[]{-1, MessagePack.Code.FIXEXT16}});
        JPEG = r3;
        PictureType r5 = new PictureType("PICT", 4, "image/x-pict", ".pict", new byte[0][]);
        PICT = r5;
        PictureType r10 = new PictureType("PNG", 5, "image/png", "png", new byte[][]{new byte[]{-119, 80, 78, 71, 13, 10, 26, 10}});
        PNG = r10;
        PictureType r11 = new PictureType("TIFF", 6, "image/tiff", "tiff", new byte[][]{new byte[]{73, 73, 42, 0}, new byte[]{77, 77, 0, 42}});
        TIFF = r11;
        PictureType r12 = new PictureType("UNKNOWN", 7, "image/unknown", "", new byte[0][]);
        UNKNOWN = r12;
        PictureType r13 = new PictureType("WMF", 8, "image/x-wmf", "wmf", new byte[][]{new byte[]{MessagePack.Code.FIXEXT8, MessagePack.Code.UINT16, MessagePack.Code.BIN32, -102, 0, 0}, new byte[]{1, 0, 9, 0, 0, 3}});
        WMF = r13;
        $VALUES = new PictureType[]{r6, r0, r2, r3, r5, r10, r11, r12, r13};
    }

    private PictureType(String r1, int r2, String r3, String r4, byte[][] r5) {
        super(r1, r2);
        this._mime = r3;
        this._extension = r4;
        this._signatures = (byte[][]) ZeusTransformUtils.preCheckCast(r5.clone(), byte[][].class, "com.obric.memorydata.plugin");
    }

    public static PictureType findMatchingType(byte[] r9) {
        PictureType[] r0 = values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        PictureType r4 = r0[r3];
        byte[][] r5 = r4.getSignatures();
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        if (matchSignature(r9, r5[r7]) == true) goto L8;
        r7 = r7 + 1;
        goto L5
    L8:
        return r4;
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        return UNKNOWN;
    }

    private static boolean matchSignature(byte[] r4, byte[] r5) {
        if (r4.length >= r5.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L12;
        if (r4[r0] != r5[r0]) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static PictureType valueOf(String r2) {
        return (PictureType) ZeusTransformUtils.preCheckCast(Enum.valueOf(PictureType.class, r2), PictureType.class, "com.obric.memorydata.plugin");
    }

    public static PictureType[] values() {
        return (PictureType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PictureType[].class, "com.obric.memorydata.plugin");
    }

    public String getExtension() {
        return this._extension;
    }

    public String getMime() {
        return this._mime;
    }

    public byte[][] getSignatures() {
        return this._signatures;
    }

    public boolean matchSignature(byte[] r5) {
        byte[][] r4 = getSignatures();
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (matchSignature(r4[r2], r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
