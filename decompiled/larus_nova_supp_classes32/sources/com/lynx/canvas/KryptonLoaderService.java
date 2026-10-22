package com.lynx.canvas;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class KryptonLoaderService extends KryptonService {

    public interface DataResolver {
        void reject(String r1);

        void resolve(byte[] r1, int r2, int r3);
    }

    public static final class ImageLoadOptions {
        public final boolean decodeImageInJs;
        public final boolean usingBuiltinImageDecoder;

        public static ImageLoadOptions defaults() {
            return new ImageLoadOptions(false, false);
        }

        public ImageLoadOptions(boolean r1, boolean r2) {
            this.decodeImageInJs = r1;
            this.usingBuiltinImageDecoder = r2;
        }
    }

    public interface ImageResolver {
        void reject(String r1);

        void resolve(Bitmap r1);
    }

    public static final enum LoadPolicy extends Enum<LoadPolicy> {
        private static final /* synthetic */ LoadPolicy[] $VALUES = null;
        public static final LoadPolicy DEFAULT_ASYNC = null;
        public static final LoadPolicy PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI = null;

        static {
            LoadPolicy r0 = new LoadPolicy("DEFAULT_ASYNC", 0);
            DEFAULT_ASYNC = r0;
            LoadPolicy r1 = new LoadPolicy("PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI", 1);
            PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI = r1;
            $VALUES = new LoadPolicy[]{r0, r1};
        }

        public static LoadPolicy[] values() {
            return (LoadPolicy[]) $VALUES.clone();
        }

        public static LoadPolicy valueOf(String r1) {
            return (LoadPolicy) a.a(LoadPolicy.class, r1);
        }

        private LoadPolicy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface StreamDelegate {
        void onData(byte[] r1, int r2, int r3);

        void onEnd();

        void onError(String r1);

        void onStart(int r1);
    }

    public static final enum TextureUploadFunctionType extends Enum<TextureUploadFunctionType> {
        private static final /* synthetic */ TextureUploadFunctionType[] $VALUES = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_IMAGE_2D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_IMAGE_3D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_SUB_IMAGE_2D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_SUB_IMAGE_3D = null;
        public static final TextureUploadFunctionType TEX_IMAGE_2D = null;
        public static final TextureUploadFunctionType TEX_IMAGE_3D = null;
        public static final TextureUploadFunctionType TEX_SUB_IMAGE_2D = null;
        public static final TextureUploadFunctionType TEX_SUB_IMAGE_3D = null;

        static {
            TextureUploadFunctionType r0 = new TextureUploadFunctionType("TEX_IMAGE_2D", 0);
            TEX_IMAGE_2D = r0;
            TextureUploadFunctionType r1 = new TextureUploadFunctionType("TEX_SUB_IMAGE_2D", 1);
            TEX_SUB_IMAGE_2D = r1;
            TextureUploadFunctionType r3 = new TextureUploadFunctionType("TEX_IMAGE_3D", 2);
            TEX_IMAGE_3D = r3;
            TextureUploadFunctionType r5 = new TextureUploadFunctionType("TEX_SUB_IMAGE_3D", 3);
            TEX_SUB_IMAGE_3D = r5;
            TextureUploadFunctionType r7 = new TextureUploadFunctionType("COMPRESSED_TEX_IMAGE_2D", 4);
            COMPRESSED_TEX_IMAGE_2D = r7;
            TextureUploadFunctionType r9 = new TextureUploadFunctionType("COMPRESSED_TEX_SUB_IMAGE_2D", 5);
            COMPRESSED_TEX_SUB_IMAGE_2D = r9;
            TextureUploadFunctionType r11 = new TextureUploadFunctionType("COMPRESSED_TEX_IMAGE_3D", 6);
            COMPRESSED_TEX_IMAGE_3D = r11;
            TextureUploadFunctionType r13 = new TextureUploadFunctionType("COMPRESSED_TEX_SUB_IMAGE_3D", 7);
            COMPRESSED_TEX_SUB_IMAGE_3D = r13;
            $VALUES = new TextureUploadFunctionType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static TextureUploadFunctionType[] values() {
            return (TextureUploadFunctionType[]) $VALUES.clone();
        }

        public static TextureUploadFunctionType valueOf(String r1) {
            return (TextureUploadFunctionType) a.a(TextureUploadFunctionType.class, r1);
        }

        private TextureUploadFunctionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class TextureUploadRequest {
        public final int border;
        public final int depth;
        public final int format;
        public final TextureUploadFunctionType functionType;
        public final int height;
        public final int internalformat;
        public final int level;
        public final long sourceByteLength;
        public final ByteBuffer sourceData;
        public final TextureUploadSourceViewType sourceViewType;
        public final long srcLengthOverride;
        public final long srcOffset;
        public final int target;
        public final int type;
        public final int width;
        public final int xoffset;
        public final int yoffset;
        public final int zoffset;

        public TextureUploadRequest(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, long r17, long r19, int r21, long r22, ByteBuffer r24) {
            this.functionType = TextureUploadFunctionType.values()[r4];
            this.target = r5;
            this.level = r6;
            this.internalformat = r7;
            this.width = r8;
            this.height = r9;
            this.depth = r10;
            this.border = r11;
            this.format = r12;
            this.type = r13;
            this.xoffset = r14;
            this.yoffset = r15;
            this.zoffset = r16;
            this.srcOffset = r17;
            this.srcLengthOverride = r19;
            this.sourceViewType = TextureUploadSourceViewType.values()[r21];
            this.sourceByteLength = r22;
            if (r24 != null) goto L5;
            ByteBuffer r1 = null;
        L6:
            this.sourceData = r1;
            return;
        L5:
            r1 = r24.asReadOnlyBuffer();
            goto L6
        }
    }

    public static final enum TextureUploadSourceViewType extends Enum<TextureUploadSourceViewType> {
        private static final /* synthetic */ TextureUploadSourceViewType[] $VALUES = null;
        public static final TextureUploadSourceViewType BIG_INT64 = null;
        public static final TextureUploadSourceViewType BIG_UINT64 = null;
        public static final TextureUploadSourceViewType DATA_VIEW = null;
        public static final TextureUploadSourceViewType EMPTY = null;
        public static final TextureUploadSourceViewType FLOAT32 = null;
        public static final TextureUploadSourceViewType FLOAT64 = null;
        public static final TextureUploadSourceViewType INT16 = null;
        public static final TextureUploadSourceViewType INT32 = null;
        public static final TextureUploadSourceViewType INT8 = null;
        public static final TextureUploadSourceViewType UINT16 = null;
        public static final TextureUploadSourceViewType UINT32 = null;
        public static final TextureUploadSourceViewType UINT8 = null;
        public static final TextureUploadSourceViewType UINT8_CLAMPED = null;

        static {
            TextureUploadSourceViewType r0 = new TextureUploadSourceViewType("EMPTY", 0);
            EMPTY = r0;
            TextureUploadSourceViewType r1 = new TextureUploadSourceViewType("INT8", 1);
            INT8 = r1;
            TextureUploadSourceViewType r3 = new TextureUploadSourceViewType("UINT8", 2);
            UINT8 = r3;
            TextureUploadSourceViewType r5 = new TextureUploadSourceViewType("UINT8_CLAMPED", 3);
            UINT8_CLAMPED = r5;
            TextureUploadSourceViewType r7 = new TextureUploadSourceViewType("INT16", 4);
            INT16 = r7;
            TextureUploadSourceViewType r9 = new TextureUploadSourceViewType("UINT16", 5);
            UINT16 = r9;
            TextureUploadSourceViewType r11 = new TextureUploadSourceViewType("INT32", 6);
            INT32 = r11;
            TextureUploadSourceViewType r13 = new TextureUploadSourceViewType("UINT32", 7);
            UINT32 = r13;
            TextureUploadSourceViewType r15 = new TextureUploadSourceViewType("FLOAT32", 8);
            FLOAT32 = r15;
            TextureUploadSourceViewType r14 = new TextureUploadSourceViewType("FLOAT64", 9);
            FLOAT64 = r14;
            TextureUploadSourceViewType r12 = new TextureUploadSourceViewType("BIG_INT64", 10);
            BIG_INT64 = r12;
            TextureUploadSourceViewType r10 = new TextureUploadSourceViewType("BIG_UINT64", 11);
            BIG_UINT64 = r10;
            TextureUploadSourceViewType r8 = new TextureUploadSourceViewType("DATA_VIEW", 12);
            DATA_VIEW = r8;
            $VALUES = new TextureUploadSourceViewType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        public static TextureUploadSourceViewType[] values() {
            return (TextureUploadSourceViewType[]) $VALUES.clone();
        }

        public static TextureUploadSourceViewType valueOf(String r1) {
            return (TextureUploadSourceViewType) a.a(TextureUploadSourceViewType.class, r1);
        }

        private TextureUploadSourceViewType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public byte[] loadUrlSync(String r1) {
        return null;
    }

    public abstract void loadUrlWithDataResolver(String r1, DataResolver r2);

    public abstract void loadUrlWithImageResolver(String r1, ImageResolver r2);

    public void onGetSupportedExtensions(String[] r1) {
    }

    public byte[] overrideTextureUpload(TextureUploadRequest r1) {
        return null;
    }

    public abstract String redirectUrl(String r1);

    public KryptonLoaderService() {
    }

    public void loadUrlWithStreamDelegate(String r1, StreamDelegate r2) {
        throw new UnsupportedOperationException();
    }

    public void loadImageWithOptions(String r1, ImageLoadOptions r2, ImageResolver r3) {
        throw new UnsupportedOperationException();
    }

    public void loadUrlWithDataResolverWithPolicy(String r1, DataResolver r2, LoadPolicy r3) {
        loadUrlWithDataResolver(r1, r2);
    }
}
