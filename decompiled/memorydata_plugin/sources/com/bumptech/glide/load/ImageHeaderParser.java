package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface ImageHeaderParser {

    /* JADX INFO: renamed from: com.bumptech.glide.load.ImageHeaderParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f567a = null;

        static {
            int[] r0 = new int[ImageType.values().length];
            f567a = r0;
            r0[ImageType.WEBP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f567a[ImageType.WEBP_A.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f567a[ImageType.ANIMATED_WEBP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType ANIMATED_AVIF = null;
        public static final ImageType ANIMATED_WEBP = null;
        public static final ImageType AVIF = null;
        public static final ImageType GIF = null;
        public static final ImageType JPEG = null;
        public static final ImageType PNG = null;
        public static final ImageType PNG_A = null;
        public static final ImageType RAW = null;
        public static final ImageType UNKNOWN = null;
        public static final ImageType WEBP = null;
        public static final ImageType WEBP_A = null;
        private final boolean hasAlpha;

        private static /* synthetic */ ImageType[] $values() {
            return new ImageType[]{GIF, JPEG, RAW, PNG_A, PNG, WEBP_A, WEBP, ANIMATED_WEBP, AVIF, ANIMATED_AVIF, UNKNOWN};
        }

        static {
            GIF = new ImageType("GIF", 0, true);
            JPEG = new ImageType("JPEG", 1, false);
            RAW = new ImageType("RAW", 2, false);
            PNG_A = new ImageType("PNG_A", 3, true);
            PNG = new ImageType("PNG", 4, false);
            WEBP_A = new ImageType("WEBP_A", 5, true);
            WEBP = new ImageType("WEBP", 6, false);
            ANIMATED_WEBP = new ImageType("ANIMATED_WEBP", 7, true);
            AVIF = new ImageType("AVIF", 8, true);
            ANIMATED_AVIF = new ImageType("ANIMATED_AVIF", 9, true);
            UNKNOWN = new ImageType("UNKNOWN", 10, false);
            $VALUES = $values();
        }

        private ImageType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.hasAlpha = r3;
        }

        public static ImageType valueOf(String r2) {
            return (ImageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageType.class, r2), ImageType.class, "com.obric.memorydata.plugin");
        }

        public static ImageType[] values() {
            return (ImageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageType[].class, "com.obric.memorydata.plugin");
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            int r2 = AnonymousClass1.f567a[ordinal()];
            if (r2 != 1) goto L5;
        L10:
            return true;
        L5:
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            return false;
        }
    }

    int a(InputStream r1, com.bumptech.glide.load.engine.bitmap_recycle.b r2);

    int a(ByteBuffer r1, com.bumptech.glide.load.engine.bitmap_recycle.b r2);

    ImageType getType(InputStream r1);

    ImageType getType(ByteBuffer r1);
}
