package org.apache.poi.hslf.blip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.sl.usermodel.PictureData;

/* JADX INFO: loaded from: classes7.dex */
public final class JPEG extends Bitmap {
    private ColorSpace colorSpace;

    public static final enum ColorSpace extends Enum<ColorSpace> {
        private static final /* synthetic */ ColorSpace[] $VALUES = null;
        public static final ColorSpace cymk = null;
        public static final ColorSpace rgb = null;

        static {
            ColorSpace r0 = new ColorSpace("rgb", 0);
            rgb = r0;
            ColorSpace r1 = new ColorSpace("cymk", 1);
            cymk = r1;
            $VALUES = new ColorSpace[]{r0, r1};
        }

        private ColorSpace(String r1, int r2) {
            super(r1, r2);
        }

        public static ColorSpace valueOf(String r2) {
            return (ColorSpace) ZeusTransformUtils.preCheckCast(Enum.valueOf(ColorSpace.class, r2), ColorSpace.class, "com.obric.memorydata.plugin");
        }

        public static ColorSpace[] values() {
            return (ColorSpace[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ColorSpace[].class, "com.obric.memorydata.plugin");
        }
    }

    @Deprecated
    public JPEG() {
        this(new EscherContainerRecord(), new EscherBSERecord());
    }

    public JPEG(EscherContainerRecord r1, EscherBSERecord r2) {
        super(r1, r2);
        this.colorSpace = ColorSpace.rgb;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public int getSignature() {
        ColorSpace r0 = this.colorSpace;
        ColorSpace r1 = ColorSpace.rgb;
        int r3 = getUIDInstanceCount();
        if (r0 != r1) goto L7;
        if (r3 != 1) goto L6;
        return 18080;
    L6:
        return 18096;
    L7:
        if (r3 != 1) goto L9;
        return 28192;
    L9:
        return 28208;
    }

    @Override // org.apache.poi.sl.usermodel.PictureData
    public PictureData.PictureType getType() {
        return PictureData.PictureType.JPEG;
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFPictureData
    public void setSignature(int r4) {
        if (r4 != 18080) goto L5;
        setUIDInstanceCount(1);
    L17:
        ColorSpace r5 = ColorSpace.rgb;
    L18:
        this.colorSpace = r5;
        return;
    L5:
        if (r4 != 18096) goto L7;
        setUIDInstanceCount(2);
        goto L17
    L7:
        if (r4 != 28192) goto L9;
        setUIDInstanceCount(1);
    L14:
        r5 = ColorSpace.cymk;
        goto L18
    L9:
        if (r4 != 28208) goto L12;
        setUIDInstanceCount(2);
        goto L14
    L12:
        throw new IllegalArgumentException(r4 + " is not a valid instance/signature value for JPEG");
    }
}
