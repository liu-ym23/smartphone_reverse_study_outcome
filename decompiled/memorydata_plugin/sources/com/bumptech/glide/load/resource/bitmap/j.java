package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<DecodeFormat> f862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<PreferredColorSpace> f863b = null;

    @Deprecated
    public static final com.bumptech.glide.load.d<DownsampleStrategy> c = null;
    public static final com.bumptech.glide.load.d<Boolean> d = null;
    public static final com.bumptech.glide.load.d<Boolean> e = null;
    private static final Set<String> f = null;
    private static final a g = null;
    private static final Set<ImageHeaderParser.ImageType> h = null;
    private static final Queue<BitmapFactory.Options> i = null;
    private final com.bumptech.glide.load.engine.bitmap_recycle.e j;
    private final DisplayMetrics k;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b l;
    private final List<ImageHeaderParser> m;
    private final n n;

    public interface a {
        void a();

        void a(com.bumptech.glide.load.engine.bitmap_recycle.e r1, Bitmap r2);
    }

    static {
        f862a = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        f863b = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        c = DownsampleStrategy.h;
        d = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
        e = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
        f = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
        g = new AnonymousClass1();
        h = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        i = com.bumptech.glide.util.k.b(0);
    }

    public j(List<ImageHeaderParser> r3, DisplayMetrics r4, com.bumptech.glide.load.engine.bitmap_recycle.e r5, com.bumptech.glide.load.engine.bitmap_recycle.b r6) {
        List<ImageHeaderParser> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r8 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r9 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.n = n.a();
        this.m = r7;
        this.k = (DisplayMetrics) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r4), DisplayMetrics.class, "com.obric.memorydata.plugin");
        this.j = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8), com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        this.l = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r9), com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
    }

    private static int a(double r4) {
        int r0 = b(r4);
        int r1 = c(((double) r0) * r4);
        return c((r4 / ((double) (r1 / r0))) * ((double) r1));
    }

    private Bitmap a(o r28, BitmapFactory.Options r29, DownsampleStrategy r30, DecodeFormat r31, PreferredColorSpace r32, boolean r33, int r34, int r35, boolean r36, a r37) {
        o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r28, o.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r37, a.class, "com.obric.memorydata.plugin");
        long r20 = com.bumptech.glide.util.f.a();
        int[] r0 = a(r5, r29, r4, this.j);
        boolean r22 = false;
        int r3 = r0[0];
        int r1 = r0[1];
        String r2 = r29.outMimeType;
        if (r3 == (-1)) goto L7;
        if (r1 == (-1)) goto L7;
        boolean r23 = r33;
    L8:
        int r15 = r5.b();
        int r14 = u.a(r15);
        boolean r24 = u.b(r15);
        if (r34 != Integer.MIN_VALUE) goto L14;
        int r12 = r35;
        if (a(r14) == false) goto L13;
        int r25 = r1;
    L15:
        if (r12 == Integer.MIN_VALUE) goto L17;
        int r26 = r12;
    L21:
        ImageHeaderParser.ImageType r11 = r5.a();
        a(r11, r5, r4, this.j, r30, r14, r3, r1, r25, r26, r29);
        a(r5, r31, r23, r24, r29, r25, r26);
        if (Build.VERSION.SDK_INT < 19) goto L24;
        boolean r6 = true;
    L26:
        if (r29.inSampleSize == 1) goto L30;
        if (r6 == true) goto L30;
        j r7 = this;
    L47:
        if (r32 != null) goto L49;
    L63:
        Bitmap r8 = b(r5, r29, r4, r7.j);
        r4.a(r7.j, r8);
        if (Log.isLoggable("Downsampler", 2) == false) goto L66;
        a(r3, r1, r2, r29, r8, r34, r35, r20);
    L66:
        Bitmap r9 = null;
        if (r8 == null) goto L71;
        r8.setDensity(r7.k.densityDpi);
        r9 = u.a(r7.j, r8, r15);
        if (r8.equals(r9) == true) goto L71;
        r7.j.a(r8);
    L71:
        return r9;
    L49:
        if (Build.VERSION.SDK_INT < 28) goto L60;
        if (r32 == PreferredColorSpace.DISPLAY_P3) goto L53;
    L57:
        if (r22 == false) goto L61;
        ColorSpace.Named r10 = ColorSpace.Named.DISPLAY_P3;
    L62:
        r29.inPreferredColorSpace = ColorSpace.get(r10);
    L61:
        r10 = ColorSpace.Named.SRGB;
        goto L62
    L53:
        if (r29.outColorSpace == null) goto L57;
        if (r29.outColorSpace.isWideGamut() == false) goto L57;
        r22 = true;
        goto L57
    L60:
        if (Build.VERSION.SDK_INT < 26) goto L63;
    L30:
        r7 = this;
        if (r7.a(r11) == false) goto L47;
        if (r3 < 0) goto L38;
        if (r1 < 0) goto L38;
        if (r36 == false) goto L38;
        if (r6 == false) goto L38;
        int r13 = r25;
        int r16 = r26;
    L44:
        if (r13 <= 0) goto L47;
        if (r16 <= 0) goto L47;
        a(r29, r7.j, r13, r16);
    L38:
        if (a(r29) == false) goto L40;
        float r17 = r29.inTargetDensity / r29.inDensity;
    L41:
        int r18 = r29.inSampleSize;
        float r19 = r18;
        int r21 = (int) Math.ceil(r3 / r19);
        int r27 = (int) Math.ceil(r1 / r19);
        r13 = Math.round(r21 * r17);
        r16 = Math.round(r27 * r17);
        if (Log.isLoggable("Downsampler", 2) == false) goto L44;
        Log.v("Downsampler", "Calculated target [" + r13 + "x" + r16 + "] for source [" + r3 + "x" + r1 + "], sampleSize: " + r18 + ", targetDensity: " + r29.inTargetDensity + ", density: " + r29.inDensity + ", density multiplier: " + r17);
        goto L44
    L40:
        r17 = 1.0f;
        goto L41
    L24:
        r6 = false;
        goto L26
    L17:
        if (a(r14) == false) goto L19;
        r26 = r3;
        goto L21
    L19:
        r26 = r1;
        goto L21
    L13:
        r25 = r3;
        goto L15
    L14:
        r12 = r35;
        r25 = r34;
    L7:
        r23 = false;
        goto L8
    }

    private static synchronized BitmapFactory.Options a() {
        monitor-enter(j.class);
        Queue<BitmapFactory.Options> r1 = i;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        BitmapFactory.Options r2 = (BitmapFactory.Options) ZeusTransformUtils.preCheckCast(r1.poll(), BitmapFactory.Options.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        d(r2);     // Catch: Throwable -> L15
    L10:
        monitor-exit(j.class);
        return r2;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private com.bumptech.glide.load.engine.s<Bitmap> a(o r16, int r17, int r18, com.bumptech.glide.load.e r19, a r20) {
        o r2 = (o) ZeusTransformUtils.wrapperContextForParams(r16, o.class, "com.obric.memorydata.plugin");
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r20, a.class, "com.obric.memorydata.plugin");
        byte[] r13 = (byte[]) ZeusTransformUtils.preCheckCast(this.l.a(65536, byte[].class), byte[].class, "com.obric.memorydata.plugin");
        BitmapFactory.Options r14 = a();
        r14.inTempStorage = r13;
        DecodeFormat r5 = (DecodeFormat) ZeusTransformUtils.preCheckCast(r19.b(f862a), DecodeFormat.class, "com.obric.memorydata.plugin");
        PreferredColorSpace r6 = (PreferredColorSpace) ZeusTransformUtils.preCheckCast(r19.b(f863b), PreferredColorSpace.class, "com.obric.memorydata.plugin");
        DownsampleStrategy r4 = (DownsampleStrategy) ZeusTransformUtils.preCheckCast(r19.b(DownsampleStrategy.h), DownsampleStrategy.class, "com.obric.memorydata.plugin");
        boolean r10 = ((Boolean) ZeusTransformUtils.preCheckCast(r19.b(d), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        com.bumptech.glide.load.d<Boolean> r1 = e;
        if (r19.b(r1) != null) goto L5;
    L7:
        boolean r0 = false;
    L15:
        e r3 = e.a(a(r2, r14, r4, r5, r6, r0, r17, r18, r10, r11), this.j);     // Catch: Throwable -> L12
        c(r14);
        this.l.a(r13);
        return r3;
    L12:
        th = move-exception;
        c(r14);
        this.l.a(r13);
        throw th;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r19.b(r1), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r0 = true;
        goto L15
    }

    private static IOException a(IllegalArgumentException r3, int r4, int r5, String r6, BitmapFactory.Options r7) {
        return new IOException("Exception decoding bitmap, outWidth: " + r4 + ", outHeight: " + r5 + ", outMimeType: " + r6 + ", inBitmap: " + b(r7), r3);
    }

    private static String a(Bitmap r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT < 19) goto L8;
        String r0 = " (" + r3.getAllocationByteCount() + ")";
    L10:
        return "[" + r3.getWidth() + "x" + r3.getHeight() + "] " + r3.getConfig() + r0;
    L8:
        r0 = "";
        goto L10
    }

    private static void a(int r2, int r3, String r4, BitmapFactory.Options r5, Bitmap r6, int r7, int r8, long r9) {
        Log.v("Downsampler", "Decoded " + a(r6) + " from [" + r2 + "x" + r3 + "] " + r4 + " with inBitmap " + b(r5) + " for [" + r7 + "x" + r8 + "], sample size: " + r5.inSampleSize + ", density: " + r5.inDensity + ", target density: " + r5.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.f.a(r9));
    }

    private static void a(BitmapFactory.Options r2, com.bumptech.glide.load.engine.bitmap_recycle.e r3, int r4, int r5) {
        com.bumptech.glide.load.engine.bitmap_recycle.e r6 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        Bitmap.Config r0 = null;
    L9:
        if (r0 != null) goto L11;
        r0 = r2.inPreferredConfig;
    L11:
        r2.inBitmap = r6.b(r4, r5, r0);
        return;
    L5:
        if (r2.inPreferredConfig != Bitmap.Config.HARDWARE) goto L7;
        return;
    L7:
        r0 = r2.outConfig;
        goto L9
    }

    private static void a(ImageHeaderParser.ImageType r17, o r18, a r19, com.bumptech.glide.load.engine.bitmap_recycle.e r20, DownsampleStrategy r21, int r22, int r23, int r24, int r25, int r26, BitmapFactory.Options r27) {
        o r7 = (o) ZeusTransformUtils.wrapperContextForParams(r18, o.class, "com.obric.memorydata.plugin");
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r19, a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r8 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r20, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (r23 <= 0) goto L67;
        if (r24 <= 0) goto L67;
        if (a(r22) == false) goto L9;
        int r14 = r23;
        int r13 = r24;
    L10:
        float r15 = r21.a(r13, r14, r25, r26);
        if (r15 <= 0.0f) goto L65;
        DownsampleStrategy.SampleSizeRounding r10 = r21.b(r13, r14, r25, r26);
        if (r10 == null) goto L63;
        float r3 = r13;
        int r11 = c(r15 * r3);
        float r12 = r14;
        int r2 = r13 / r11;
        int r1 = r14 / c(r15 * r12);
        if (r10 != DownsampleStrategy.SampleSizeRounding.MEMORY) goto L17;
        int r4 = Math.max(r2, r1);
    L19:
        if (Build.VERSION.SDK_INT <= 23) goto L21;
    L23:
        int r5 = Math.max(1, Integer.highestOneBit(r4));
        if (r10 == DownsampleStrategy.SampleSizeRounding.MEMORY) goto L26;
    L28:
        r27.inSampleSize = r5;
        if (r17 != ImageHeaderParser.ImageType.JPEG) goto L34;
        float r0 = Math.min(r5, 8);
        int r6 = (int) Math.ceil(r3 / r0);
        int r16 = (int) Math.ceil(r12 / r0);
        int r28 = r5 / 8;
        if (r28 <= 0) goto L51;
        r6 = r6 / r28;
        r16 = r16 / r28;
    L51:
        double r29 = r21.a(r6, r16, r25, r26);
        if (Build.VERSION.SDK_INT < 19) goto L55;
        r27.inTargetDensity = a(r29);
        r27.inDensity = b(r29);
    L55:
        if (a(r27) == false) goto L57;
        r27.inScaled = true;
    L59:
        if (Log.isLoggable("Downsampler", 2) == false) goto L70;
        Log.v("Downsampler", "Calculate scaling, source: [" + r23 + "x" + r24 + "], degreesToRotate: " + r22 + ", target: [" + r25 + "x" + r26 + "], power of two scaled: [" + r6 + "x" + r16 + "], exact scale factor: " + r15 + ", power of 2 sample size: " + r5 + ", adjusted scale factor: " + r29 + ", target density: " + r27.inTargetDensity + ", density: " + r27.inDensity);
        return;
    L70:
        return;
    L57:
        r27.inTargetDensity = 0;
        r27.inDensity = 0;
        goto L59
    L34:
        if (r17 != ImageHeaderParser.ImageType.PNG) goto L36;
    L50:
        float r30 = r5;
        r6 = (int) Math.floor(r3 / r30);
        r16 = (int) Math.floor(r12 / r30);
        goto L51
    L36:
        if (r17 == ImageHeaderParser.ImageType.PNG_A) goto L50;
        if (r17.isWebp() == false) goto L44;
        if (Build.VERSION.SDK_INT < 24) goto L50;
        float r31 = r5;
        r6 = Math.round(r3 / r31);
        r16 = Math.round(r12 / r31);
        goto L51
    L44:
        if ((r13 % r5) == 0) goto L46;
    L49:
        int[] r32 = a(r7, r27, r9, r8);
        r6 = r32[0];
        r16 = r32[1];
        goto L51
    L46:
        if ((r14 % r5) != 0) goto L49;
        r6 = r13 / r5;
        r16 = r14 / r5;
        goto L51
    L26:
        if (r5 >= (1.0f / r15)) goto L28;
        r5 = r5 << 1;
        goto L28
    L21:
        if (f.contains(r27.outMimeType) == false) goto L23;
        r5 = 1;
        goto L28
    L17:
        r4 = Math.min(r2, r1);
        goto L19
    L63:
        throw new IllegalArgumentException("Cannot round with null rounding");
    L65:
        throw new IllegalArgumentException("Cannot scale with factor: " + r15 + " from: " + r21 + ", source: [" + r23 + "x" + r24 + "], target: [" + r25 + "x" + r26 + "]");
    L9:
        r13 = r23;
        r14 = r24;
    L67:
        if (Log.isLoggable("Downsampler", 3) == false) goto L71;
        Log.d("Downsampler", "Unable to determine dimensions for: " + r17 + " with target [" + r25 + "x" + r26 + "]");
        return;
    }

    private void a(o r7, DecodeFormat r8, boolean r9, boolean r10, BitmapFactory.Options r11, int r12, int r13) {
        o r14 = (o) ZeusTransformUtils.wrapperContextForParams(r7, o.class, "com.obric.memorydata.plugin");
        if (this.n.a(r12, r13, r11, r9, r10) == false) goto L6;
        return;
    L6:
        if (r8 != DecodeFormat.PREFER_ARGB_8888) goto L8;
    L24:
        r11.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return;
    L8:
        if (Build.VERSION.SDK_INT == 16) goto L24;
        boolean r6 = false;
        r6 = r14.a().hasAlpha();     // Catch: IOException -> L13
    L17:
        if (r6 == false) goto L19;
        Bitmap.Config r15 = Bitmap.Config.ARGB_8888;
    L20:
        r11.inPreferredConfig = r15;
        if (r11.inPreferredConfig != Bitmap.Config.RGB_565) goto L28;
        r11.inDither = true;
        return;
    L28:
        return;
    L19:
        r15 = Bitmap.Config.RGB_565;
    L13:
        e = move-exception;
        if (Log.isLoggable("Downsampler", 3) == false) goto L17;
        Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + r8, e);
        goto L17
    }

    private static boolean a(int r1) {
        if (r1 != 90) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 270) goto L8;
        return false;
    }

    private static boolean a(BitmapFactory.Options r1) {
        if (r1.inTargetDensity > 0) goto L5;
    L9:
        return false;
    L5:
        if (r1.inDensity <= 0) goto L9;
        if (r1.inTargetDensity == r1.inDensity) goto L9;
        return true;
    }

    private boolean a(ImageHeaderParser.ImageType r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return true;
    L7:
        return h.contains(r2);
    }

    private static int[] a(o r2, BitmapFactory.Options r3, a r4, com.bumptech.glide.load.engine.bitmap_recycle.e r5) {
        o r6 = (o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin");
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r8 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        r3.inJustDecodeBounds = true;
        b(r6, r3, r7, r8);
        r3.inJustDecodeBounds = false;
        return new int[]{r3.outWidth, r3.outHeight};
    }

    private static int b(double r3) {
        if (r3 <= 1.0d) goto L7;
        r3 = 1.0d / r3;
    L7:
        return (int) Math.round(r3 * 2.147483647E9d);
    }

    private static Bitmap b(o r5, BitmapFactory.Options r6, a r7, com.bumptech.glide.load.engine.bitmap_recycle.e r8) {
        o r9 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r11 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        if (r6.inJustDecodeBounds == true) goto L5;
        r10.a();
        r9.c();
    L5:
        int r1 = r6.outWidth;
        int r2 = r6.outHeight;
        String r3 = r6.outMimeType;
        u.a().lock();
        Bitmap r12 = r9.a(r6);     // Catch: Throwable -> L9 IllegalArgumentException -> L11
        u.a().unlock();
        return r12;
    L11:
        e = move-exception;
        IOException r4 = a(e, r1, r2, r3, r6);     // Catch: Throwable -> L9
        if (Log.isLoggable("Downsampler", 3) == false) goto L16;
        Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", r4);     // Catch: Throwable -> L9
    L16:
        if (r6.inBitmap != null) goto L24;
        throw r4;     // Catch: Throwable -> L9
    L24:
        r11.a(r6.inBitmap);     // Catch: Throwable -> L9 IOException -> L20
        r6.inBitmap = null;     // Catch: Throwable -> L9 IOException -> L20
        Bitmap r13 = b(r9, r6, r10, r11);     // Catch: Throwable -> L9 IOException -> L20
        u.a().unlock();
        return r13;
    L28:
        throw r4;     // Catch: Throwable -> L9
    L20:
        throw r4;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        u.a().unlock();
        throw th;
    }

    private static String b(BitmapFactory.Options r0) {
        return a(r0.inBitmap);
    }

    private static int c(double r2) {
        return (int) (r2 + 0.5d);
    }

    private static void c(BitmapFactory.Options r1) {
        d(r1);
        Queue<BitmapFactory.Options> r0 = i;
        monitor-enter(r0);
        r0.offer(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void d(BitmapFactory.Options r5) {
        r5.inTempStorage = null;
        r5.inDither = false;
        r5.inScaled = false;
        r5.inSampleSize = 1;
        r5.inPreferredConfig = null;
        r5.inJustDecodeBounds = false;
        r5.inDensity = 0;
        r5.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r5.inPreferredColorSpace = null;
        r5.outColorSpace = null;
        r5.outConfig = null;
    L5:
        r5.outWidth = 0;
        r5.outHeight = 0;
        r5.outMimeType = null;
        r5.inBitmap = null;
        r5.inMutable = true;
    }

    public com.bumptech.glide.load.engine.s<Bitmap> a(ParcelFileDescriptor r7, int r8, int r9, com.bumptech.glide.load.e r10) {
        return a(new o.c(r7, this.m, this.l), r8, r9, r10, g);
    }

    public com.bumptech.glide.load.engine.s<Bitmap> a(InputStream r7, int r8, int r9, com.bumptech.glide.load.e r10, a r11) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r11, a.class, "com.obric.memorydata.plugin");
        return a(new o.b(r7, this.m, this.l), r8, r9, r10, r5);
    }

    public com.bumptech.glide.load.engine.s<Bitmap> a(ByteBuffer r7, int r8, int r9, com.bumptech.glide.load.e r10) {
        return a(new o.a(r7, this.m, this.l), r8, r9, r10, g);
    }

    public boolean a(ParcelFileDescriptor r1) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean a(InputStream r1) {
        return true;
    }

    public boolean a(ByteBuffer r1) {
        return true;
    }
}
