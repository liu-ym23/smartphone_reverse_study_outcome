package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ImageCropType extends Enum<ImageCropType> implements WireEnum {
    private static final /* synthetic */ ImageCropType[] $VALUES = null;
    public static final ProtoAdapter<ImageCropType> ADAPTER = null;
    public static final ImageCropType COVER = null;
    public static final ImageCropType INTACT = null;
    public static final ImageCropType MIDDLE = null;
    public static final ImageCropType MIDDLE_MP4 = null;
    public static final ImageCropType MIDDLE_WEBP = null;
    public static final ImageCropType ORIGIN = null;
    public static final ImageCropType THUMB = null;
    public static final ImageCropType THUMB_WEBP = null;
    private final int value;

    static {
        ImageCropType r0 = new ImageCropType("ORIGIN", 0, 1);
        ORIGIN = r0;
        ImageCropType r1 = new ImageCropType("MIDDLE", 1, 2);
        MIDDLE = r1;
        ImageCropType r4 = new ImageCropType("THUMB", 2, 3);
        THUMB = r4;
        ImageCropType r6 = new ImageCropType("MIDDLE_WEBP", 3, 4);
        MIDDLE_WEBP = r6;
        ImageCropType r8 = new ImageCropType("THUMB_WEBP", 4, 5);
        THUMB_WEBP = r8;
        ImageCropType r10 = new ImageCropType("MIDDLE_MP4", 5, 6);
        MIDDLE_MP4 = r10;
        ImageCropType r12 = new ImageCropType("COVER", 6, 7);
        COVER = r12;
        ImageCropType r14 = new ImageCropType("INTACT", 7, 8);
        INTACT = r14;
        $VALUES = new ImageCropType[]{r0, r1, r4, r6, r8, r10, r12, r14};
        ADAPTER = ProtoAdapter.newEnumAdapter(ImageCropType.class);
    }

    public static ImageCropType[] values() {
        return (ImageCropType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ImageCropType fromValue(int r0) {
        switch(r0) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return INTACT;
    L8:
        return COVER;
    L10:
        return MIDDLE_MP4;
    L12:
        return THUMB_WEBP;
    L14:
        return MIDDLE_WEBP;
    L16:
        return THUMB;
    L18:
        return MIDDLE;
    L20:
        return ORIGIN;
    }

    public static ImageCropType valueOf(String r1) {
        return (ImageCropType) a.a(ImageCropType.class, r1);
    }

    private ImageCropType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
