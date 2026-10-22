package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VideoDecoder<T> implements com.bumptech.glide.load.f<T, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Long> f844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f845b = null;
    private static final d c = null;
    private static final List<String> d = null;
    private final c<T> e;
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f;
    private final d g;

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    private static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaExtractor r7, AssetFileDescriptor r8) {
            r7.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaExtractor r3, AssetFileDescriptor r4) {
            a2(r3, (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r4, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r7, AssetFileDescriptor r8) {
            r7.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaMetadataRetriever r3, AssetFileDescriptor r4) {
            a2(r3, (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r4, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class b implements c<ByteBuffer> {
        b() {
        }

        private MediaDataSource a(final ByteBuffer r2) {
            return new AnonymousClass1(this, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaExtractor r3, ByteBuffer r4) {
            a2(r3, (ByteBuffer) ZeusTransformUtils.preCheckCast(r4, ByteBuffer.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaExtractor r1, ByteBuffer r2) {
            r1.setDataSource(a(r2));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaMetadataRetriever r3, ByteBuffer r4) {
            a2(r3, (ByteBuffer) ZeusTransformUtils.preCheckCast(r4, ByteBuffer.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r1, ByteBuffer r2) {
            r1.setDataSource(a(r2));
        }
    }

    interface c<T> {
        void a(MediaExtractor r1, T r2);

        void a(MediaMetadataRetriever r1, T r2);
    }

    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    static final class e implements c<ParcelFileDescriptor> {
        e() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaExtractor r1, ParcelFileDescriptor r2) {
            r1.setDataSource(r2.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaExtractor r3, ParcelFileDescriptor r4) {
            a2(r3, (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r4, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r1, ParcelFileDescriptor r2) {
            r1.setDataSource(r2.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.c
        public /* synthetic */ void a(MediaMetadataRetriever r3, ParcelFileDescriptor r4) {
            a2(r3, (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r4, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f844a = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new AnonymousClass1());
        f845b = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new AnonymousClass2());
        c = new d();
        d = Collections.unmodifiableList(Arrays.asList(new String[]{"TP1A", "TD1A.220804.031"}));
    }

    VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.e r3, c<T> r4) {
        this((com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"), c);
    }

    VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.e r3, c<T> r4, d r5) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r6 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        c<T> r7 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        this.f = r6;
        this.e = r7;
        this.g = r5;
    }

    private static Bitmap a(MediaMetadataRetriever r0, long r1, int r3) {
        return r0.getFrameAtTime(r1, r3);
    }

    private static Bitmap a(MediaMetadataRetriever r9, long r10, int r12, int r13, int r14, DownsampleStrategy r15) {
        int r0 = Integer.parseInt(r9.extractMetadata(18));     // Catch: Throwable -> L10
        int r1 = Integer.parseInt(r9.extractMetadata(19));     // Catch: Throwable -> L10
        int r2 = Integer.parseInt(r9.extractMetadata(24));     // Catch: Throwable -> L10
        if (r2 != 90) goto L6;
    L7:
        r1 = r0;
        r0 = r1;
    L8:
        float r16 = r15.a(r0, r1, r13, r14);     // Catch: Throwable -> L10
        return r9.getScaledFrameAtTime(r10, r12, Math.round(r0 * r16), Math.round(r16 * r1));
    L6:
        if (r2 != 270) goto L8;
    L10:
        th = move-exception;
        if (Log.isLoggable("VideoDecoder", 3) == false) goto L18;
        Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
        return null;
    L18:
        return null;
    }

    private static Bitmap a(MediaMetadataRetriever r8, Bitmap r9) {
        if (a() == true) goto L5;
        return r9;
    L5:
        boolean r2 = false;
        if (a(r8) == false) goto L15;
        if (Math.abs(Integer.parseInt(r8.extractMetadata(24))) != 180) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L18;
        return r9;
    L18:
        if (Log.isLoggable("VideoDecoder", 3) == false) goto L20;
        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
    L20:
        Matrix r6 = new Matrix();
        r6.postRotate(180.0f, r9.getWidth() / 2.0f, r9.getHeight() / 2.0f);
        return Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r6, true);
    L13:
        if (Log.isLoggable("VideoDecoder", 3) == false) goto L15;
        Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
        goto L15
    }

    private Bitmap a(T r2, MediaMetadataRetriever r3, long r4, int r6, int r7, int r8, DownsampleStrategy r9) {
        if (a(r2, r3) == true) goto L20;
        Bitmap r1 = null;
        if (Build.VERSION.SDK_INT >= 27) goto L7;
    L12:
        if (r1 != null) goto L14;
        r1 = a(r3, r4, r6);
    L14:
        Bitmap r5 = a(r3, r1);
        if (r5 == null) goto L18;
        return r5;
    L18:
        throw new VideoDecoderException();
    L7:
        if (r7 == Integer.MIN_VALUE) goto L12;
        if (r8 == Integer.MIN_VALUE) goto L12;
        if (r9 == DownsampleStrategy.f) goto L12;
        r1 = a(r3, r4, r6, r7, r8, r9);
        goto L12
    L20:
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    public static com.bumptech.glide.load.f<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.engine.bitmap_recycle.e r3) {
        return new VideoDecoder((com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), new a(null));
    }

    static boolean a() {
        if (Build.MODEL.startsWith("Pixel") == false) goto L9;
        if (Build.VERSION.SDK_INT != 33) goto L9;
        return b();
    L9:
        if (Build.VERSION.SDK_INT >= 30) goto L11;
    L13:
        return false;
    L11:
        if (Build.VERSION.SDK_INT >= 33) goto L13;
        return true;
    }

    private static boolean a(MediaMetadataRetriever r3) {
        String r0 = r3.extractMetadata(36);
        String r4 = r3.extractMetadata(35);
        int r1 = Integer.parseInt(r0);
        int r5 = Integer.parseInt(r4);
        if (r1 == 7) goto L5;
        if (r1 == 6) goto L5;
    L7:
        return false;
    L5:
        if (r5 != 6) goto L7;
        return true;
    }

    private boolean a(T r6, MediaMetadataRetriever r7) {
        if (Build.VERSION.SDK_INT >= 16) goto L6;
        return false;
    L6:
        if (Build.DEVICE != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return false;
    L13:
        MediaExtractor r2 = null;
    L28:
        th = th;
    L42:
    L36:
        th = move-exception;
        if (r2 == null) goto L39;
        r2.release();
    L39:
        throw th;
    L31:
        if (Log.isLoggable("VideoDecoder", 3) == false) goto L33;
        Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);     // Catch: Throwable -> L36
    L33:
        if (r2 == null) goto L35;
        r2.release();
    L35:
        return false;
    L15:
        if ("video/webm".equals(r7.extractMetadata(12)) == true) goto L17;
        return false;
    L17:
        MediaExtractor r8 = new MediaExtractor();     // Catch: Throwable -> L28
        this.e.a(r8, r6);     // Catch: Throwable -> L26
        int r5 = r8.getTrackCount();     // Catch: Throwable -> L26
        int r9 = 0;
    L19:
        if (r9 >= r5) goto L25;
        if ("video/x-vnd.on2.vp8".equals(r8.getTrackFormat(r9).getString("mime")) == true) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        r8.release();
        return true;
    L25:
        r8.release();
    L26:
        th = th;
        r2 = r8;
        goto L42
    L8:
        if (Build.DEVICE.matches(".+_cheets|cheets_.+") == false) goto L10;
        r1 = true;
        goto L11
    }

    public static com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> b(com.bumptech.glide.load.engine.bitmap_recycle.e r2) {
        return new VideoDecoder((com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), new e());
    }

    private static boolean b() {
        Iterator<String> r0 = d.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (Build.ID.startsWith(r1) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static com.bumptech.glide.load.f<ByteBuffer, Bitmap> c(com.bumptech.glide.load.engine.bitmap_recycle.e r2) {
        return new VideoDecoder((com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), new b());
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.s<Bitmap> a(T r13, int r14, int r15, com.bumptech.glide.load.e r16) {
        long r5 = ((Long) ZeusTransformUtils.preCheckCast(r16.b(f844a), Long.class, "com.obric.memorydata.plugin")).longValue();
        if (r5 < 0) goto L5;
    L9:
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r16.b(f845b), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        r2 = 2;
    L12:
        DownsampleStrategy r1 = (DownsampleStrategy) ZeusTransformUtils.preCheckCast(r16.b(DownsampleStrategy.h), DownsampleStrategy.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L15;
        r1 = DownsampleStrategy.g;
    L15:
        DownsampleStrategy r9 = r1;
        MediaMetadataRetriever r10 = this.g.a();
        this.e.a(r10, r13);     // Catch: Throwable -> L23
        Bitmap r3 = a(r13, r10, r5, r2.intValue(), r14, r15, r9);     // Catch: Throwable -> L23
        if (Build.VERSION.SDK_INT < 29) goto L20;
        r10.close();
    L22:
        return com.bumptech.glide.load.resource.bitmap.e.a(r3, this.f);
    L20:
        r10.release();
    L23:
        th = move-exception;
        if (Build.VERSION.SDK_INT < 29) goto L27;
        r10.close();
    L28:
        throw th;
    L27:
        r10.release();
        goto L28
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + r5);
    }

    @Override // com.bumptech.glide.load.f
    public boolean a(T r1, com.bumptech.glide.load.e r2) {
        return true;
    }
}
