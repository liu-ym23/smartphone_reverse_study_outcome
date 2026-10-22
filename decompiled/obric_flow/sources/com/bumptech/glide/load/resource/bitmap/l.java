package com.bumptech.glide.load.resource.bitmap;

import ai.j0;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.PreferredColorSpace;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final z.e f = null;
    public static final z.e g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final z.e f1615h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final z.e f1616i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f1617j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final wc.f f1618k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f1619l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ArrayDeque f1620m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f1621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f1622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1623c;
    public final ArrayList d;
    public final r e;

    static {
        f = z.e.a(DecodeFormat.DEFAULT, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");
        g = z.e.a(PreferredColorSpace.SRGB, "com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
        j r5 = j.f1611b;
        Boolean r10 = Boolean.FALSE;
        f1615h = z.e.a(r10, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        f1616i = z.e.a(r10, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        f1617j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"image/vnd.wap.wbmp", "image/x-ico"})));
        f1618k = new wc.f(2);
        f1619l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] r11 = q0.i.f21459a;
        f1620m = new ArrayDeque(0);
    }

    public l(ArrayList r5, DisplayMetrics r10, com.bumptech.glide.load.engine.bitmap_recycle.a r11, com.bumptech.glide.load.engine.bitmap_recycle.f r12) {
        this.e = r.a();
        this.d = r5;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.f1622b = r10;
        io.reactivex.internal.observers.h.h(r11, "Argument must not be null");
        this.f1621a = r11;
        io.reactivex.internal.observers.h.h(r12, "Argument must not be null");
        this.f1623c = r12;
    }

    public static Bitmap c(com.google.common.reflect.w r10, BitmapFactory.Options r11, k r12, com.bumptech.glide.load.engine.bitmap_recycle.a r13) {
        if (r11.inJustDecodeBounds == true) goto L15;
        r12.e();
        switch(r10.f9375a) {
            case 5: goto L7;
            default: goto L15;
        };
    L7:
        s r5 = (s) ((com.bumptech.glide.load.data.i) r10.f9377c).f1428b;
        monitor-enter(r5);
        r5.f1633c = r5.f1631a.length;     // Catch: Throwable -> L12
        monitor-exit(r5);
    L12:
        th = move-exception;
        throw th;
    L15:
        int r14 = r11.outWidth;
        int r15 = r11.outHeight;
        String r16 = r11.outMimeType;
        Lock r17 = u.f1635b;
        r17.lock();
        Bitmap r18 = r10.l(r11);     // Catch: Throwable -> L19 IllegalArgumentException -> L21
        r17.unlock();
        return r18;
    L19:
        th = move-exception;
        u.f1635b.unlock();
        throw th;
    L21:
        e = move-exception;
        StringBuilder r19 = j0.v("Exception decoding bitmap, outWidth: ", r14, r15, ", outHeight: ", ", outMimeType: ");     // Catch: Throwable -> L19
        r19.append(r16);     // Catch: Throwable -> L19
        r19.append(", inBitmap: ");     // Catch: Throwable -> L19
        r19.append(d(r11.inBitmap));     // Catch: Throwable -> L19
        IOException r20 = new IOException(r19.toString(), e);     // Catch: Throwable -> L19
        if (Log.isLoggable("Downsampler", 3) == false) goto L25;
        Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", r20);     // Catch: Throwable -> L19
    L25:
        Bitmap r21 = r11.inBitmap;     // Catch: Throwable -> L19
        if (r21 != null) goto L36;
        throw r20;     // Catch: Throwable -> L19
    L36:
        r13.b(r21);     // Catch: Throwable -> L19 IOException -> L30
        r11.inBitmap = null;     // Catch: Throwable -> L19 IOException -> L30
        Bitmap r22 = c(r10, r11, r12, r13);     // Catch: Throwable -> L19 IOException -> L30
        u.f1635b.unlock();
        return r22;
    L40:
        throw r20;     // Catch: Throwable -> L19
    L30:
        throw r20;     // Catch: Throwable -> L19
    }

    public static String d(Bitmap r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return "[" + r5.getWidth() + "x" + r5.getHeight() + "] " + r5.getConfig() + (" (" + r5.getAllocationByteCount() + ")");
    }

    public static void e(BitmapFactory.Options r5) {
        r5.inTempStorage = null;
        r5.inDither = false;
        r5.inScaled = false;
        r5.inSampleSize = 1;
        r5.inPreferredConfig = null;
        r5.inJustDecodeBounds = false;
        r5.inDensity = 0;
        r5.inTargetDensity = 0;
        r5.inPreferredColorSpace = null;
        r5.outColorSpace = null;
        r5.outConfig = null;
        r5.outWidth = 0;
        r5.outHeight = 0;
        r5.outMimeType = null;
        r5.inBitmap = null;
        r5.inMutable = true;
    }

    public final c a(com.google.common.reflect.w r17, int r18, int r19, z.f r20, k r21) {
        byte[] r13 = (byte[]) this.f1623c.c(65536, byte[].class);
        monitor-enter(l.class);
        ArrayDeque r14 = f1620m;     // Catch: Throwable -> L11
        monitor-enter(r14);     // Catch: Throwable -> L11
        BitmapFactory.Options r5 = (BitmapFactory.Options) r14.poll();     // Catch: Throwable -> L42
        monitor-exit(r14);     // Catch: Throwable -> L42
        if (r5 != null) goto L10;
        r5 = new BitmapFactory.Options();     // Catch: Throwable -> L11
        e(r5);     // Catch: Throwable -> L11
    L10:
        BitmapFactory.Options r15 = r5;
        monitor-exit(l.class);
        r15.inTempStorage = r13;
        DecodeFormat r10 = (DecodeFormat) r20.c(f);
        PreferredColorSpace r11 = (PreferredColorSpace) r20.c(g);
        j r12 = (j) r20.c(j.g);
        boolean r16 = ((Boolean) r20.c(f1615h)).booleanValue();
        z.e r22 = f1616i;
        if (r20.c(r22) != null) goto L17;
    L20:
        boolean r23 = false;
    L49:
        c r24 = c.b(b(r17, r15, r12, r10, r11, r23, r18, r19, r16, r21), this.f1621a);     // Catch: Throwable -> L32
        e(r15);
        monitor-enter(r14);
        r14.offer(r15);     // Catch: Throwable -> L29
        monitor-exit(r14);     // Catch: Throwable -> L29
        this.f1623c.h(r13);
        return r24;
    L29:
        th = move-exception;
        throw th;
    L32:
        th = move-exception;
        e(r15);
        ArrayDeque r25 = f1620m;
        monitor-enter(r25);
        r25.offer(r15);     // Catch: Throwable -> L39
        this.f1623c.h(r13);
        throw th;
    L39:
        th = move-exception;
        throw th;
    L17:
        if (((Boolean) r20.c(r22)).booleanValue() == false) goto L20;
        r23 = true;
        goto L49
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final Bitmap b(com.google.common.reflect.w r38, BitmapFactory.Options r39, j r40, DecodeFormat r41, PreferredColorSpace r42, boolean r43, int r44, int r45, boolean r46, k r47) {
        int r13 = q0.f.f21454b;
        long r14 = SystemClock.elapsedRealtimeNanos();
        r39.inJustDecodeBounds = true;
        com.bumptech.glide.load.engine.bitmap_recycle.a r15 = this.f1621a;
        c(r38, r39, r47, r15);
        r39.inJustDecodeBounds = false;
        int[] r10 = {r39.outWidth, r39.outHeight};
        int r11 = r10[0];
        int r12 = r10[1];
        String r16 = r39.outMimeType;
        if (r11 == (-1)) goto L7;
        if (r12 == (-1)) goto L7;
        boolean r17 = r43;
    L9:
        switch(r38.f9375a) {
            case 5: goto L29;
            default: goto L10;
        };
    L10:
        com.bumptech.glide.load.data.i r18 = (com.bumptech.glide.load.data.i) r38.d;
        com.bumptech.glide.load.engine.bitmap_recycle.f r19 = (com.bumptech.glide.load.engine.bitmap_recycle.f) r38.f9377c;
        long r110 = r14;
        ArrayList r111 = (ArrayList) r38.f9376b;
        int r112 = r111.size();
        String r20 = r16;
        int r113 = 0;
    L11:
        if (r113 >= r112) goto L28;
        ArrayList r48 = r111;
        z.b r114 = (z.b) r111.get(r113);
        int r21 = r112;
        s r115 = new s(new FileInputStream(r18.e().getFileDescriptor()), r19);     // Catch: Throwable -> L22
        int r5 = r114.a(r115, r19);     // Catch: Throwable -> L20
        r115.close();     // Catch: IOException -> L252
    L16:
        r18.e();
        if (r5 != (-1)) goto L18;
        r113 = r113 + 1;
        r111 = r48;
        r112 = r21;
        goto L11
    L18:
        int r116 = r5;
    L31:
        switch(r116) {
            case 3: goto L35;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L33;
            default: goto L32;
        };
    L32:
        int r117 = 0;
    L36:
        switch(r116) {
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L38;
            case 8: goto L38;
            default: goto L37;
        };
    L37:
        boolean r118 = false;
    L40:
        if (r44 != Integer.MIN_VALUE) goto L46;
        if (r117 == 90) goto L45;
        if (r117 == 270) goto L45;
        int r119 = r11;
    L47:
        if (r45 != Integer.MIN_VALUE) goto L53;
        if (r117 == 90) goto L52;
        if (r117 == 270) goto L52;
        int r120 = r12;
    L54:
        ImageHeaderParser$ImageType r22 = r38.p();
        String r23 = ", target density: ";
        int r24 = r116;
        String r121 = ", density: ";
        String r25 = "x";
        String r26 = "Downsampler";
        boolean r27 = r118;
        if (r11 <= 0) goto L127;
        if (r12 > 0) goto L59;
        int r28 = 3;
    L129:
        if (Log.isLoggable(r26, r28) == false) goto L131;
        Log.d(r26, "Unable to determine dimensions for: " + r22 + " with target [" + r119 + r25 + r120 + "]");
    L131:
        r r29 = this.e;
        if (r17 == true) goto L134;
        r29.getClass();
    L163:
        boolean r30 = false;
    L164:
        if (r30 == false) goto L166;
        r39.inPreferredConfig = Bitmap.Config.HARDWARE;
        boolean r31 = false;
        r39.inMutable = false;
    L167:
        if (r30 == false) goto L170;
    L168:
        boolean r32 = true;
    L185:
        if (r11 < 0) goto L189;
        if (r12 < 0) goto L189;
        if (r46 == false) goto L189;
    L203:
        if (r119 <= 0) goto L213;
        if (r120 <= 0) goto L213;
        Bitmap.Config r33 = r39.inPreferredConfig;
        if (r33 == Bitmap.Config.HARDWARE) goto L213;
        Bitmap.Config r122 = r39.outConfig;
        if (r122 != null) goto L211;
    L210:
        com.bumptech.glide.load.engine.bitmap_recycle.a r123 = r15;
        r39.inBitmap = r123.a(r119, r120, r33);
        com.bumptech.glide.load.engine.bitmap_recycle.a r124 = r123;
    L215:
        if (r42 != PreferredColorSpace.DISPLAY_P3) goto L221;
        ColorSpace r34 = r39.outColorSpace;
        if (r34 == null) goto L221;
        if (r34.isWideGamut() == false) goto L221;
        boolean r125 = r32;
    L222:
        if (r125 == false) goto L224;
        ColorSpace.Named r35 = ColorSpace.Named.DISPLAY_P3;
    L225:
        r39.inPreferredColorSpace = ColorSpace.get(r35);
        String r36 = r25;
        Bitmap r37 = c(r38, r39, r47, r124);
        r47.a(r37, r124);
        if (Log.isLoggable(r26, 2) == false) goto L228;
        StringBuilder r49 = new StringBuilder("Decoded ");
        r49.append(d(r37));
        r49.append(" from [");
        r49.append(r11);
        r49.append(r36);
        androidx.room.jarjarred.org.antlr.runtime.a.D(r49, r12, "] ", r20, " with inBitmap ");
        r49.append(d(r39.inBitmap));
        r49.append(" for [");
        r49.append(r44);
        r49.append(r36);
        r49.append(r45);
        r49.append("], sample size: ");
        r49.append(r39.inSampleSize);
        r49.append(r121);
        r49.append(r39.inDensity);
        r49.append(r23);
        r49.append(r39.inTargetDensity);
        r49.append(", thread: ");
        r49.append(Thread.currentThread().getName());
        r49.append(", duration: ");
        r49.append(q0.f.a(r110));
        Log.v(r26, r49.toString());
    L228:
        if (r37 == null) goto L250;
        r37.setDensity(this.f1622b.densityDpi);
        switch(r24) {
            case 2: goto L232;
            case 3: goto L232;
            case 4: goto L232;
            case 5: goto L232;
            case 6: goto L232;
            case 7: goto L232;
            case 8: goto L232;
            default: goto L231;
        };
    L231:
        Bitmap r50 = r37;
    L248:
        if (r37.equals(r50) == true) goto L268;
        r124.b(r37);
        return r50;
    L268:
        return r50;
    L232:
        Matrix r51 = new Matrix();
        switch(r24) {
            case 2: goto L241;
            case 3: goto L240;
            case 4: goto L239;
            case 5: goto L238;
            case 6: goto L237;
            case 7: goto L236;
            case 8: goto L235;
            default: goto L242;
        };
    L235:
        r51.setRotate(-90.0f);
        goto L242
    L236:
        r51.setRotate(-90.0f);
        r51.postScale(-1.0f, 1.0f);
        goto L242
    L237:
        r51.setRotate(90.0f);
        goto L242
    L238:
        r51.setRotate(90.0f);
        r51.postScale(-1.0f, 1.0f);
        goto L242
    L239:
        r51.setRotate(180.0f);
        r51.postScale(-1.0f, 1.0f);
        goto L242
    L240:
        r51.setRotate(180.0f);
        goto L242
    L241:
        r51.setScale(-1.0f, 1.0f);
    L242:
        RectF r52 = new RectF(0.0f, 0.0f, r37.getWidth(), r37.getHeight());
        r51.mapRect(r52);
        int r53 = Math.round(r52.width());
        int r54 = Math.round(r52.height());
        if (r37.getConfig() == null) goto L245;
        Bitmap.Config r55 = r37.getConfig();
    L246:
        Bitmap r56 = r124.g(r53, r54, r55);
        r51.postTranslate(-r52.left, -r52.top);
        r56.setHasAlpha(r37.hasAlpha());
        u.a(r37, r56, r51);
        r50 = r56;
        goto L248
    L245:
        r55 = Bitmap.Config.ARGB_8888;
        goto L246
    L250:
        return null;
    L224:
        r35 = ColorSpace.Named.SRGB;
    L221:
        r125 = r31;
        goto L222
    L211:
        r33 = r122;
    L213:
        r124 = r15;
    L189:
        int r57 = r39.inTargetDensity;
        if (r57 <= 0) goto L195;
        int r58 = r39.inDensity;
        if (r58 <= 0) goto L195;
        if (r57 == r58) goto L195;
        boolean r59 = r32;
    L196:
        if (r59 == false) goto L198;
        float r60 = r57 / r39.inDensity;
    L199:
        int r61 = r39.inSampleSize;
        float r126 = r61;
        int r62 = (int) Math.ceil(r11 / r126);
        int r127 = (int) Math.ceil(r12 / r126);
        int r63 = Math.round(r62 * r60);
        int r128 = Math.round(r127 * r60);
        if (Log.isLoggable(r26, 2) == false) goto L202;
        StringBuilder r129 = j0.v("Calculated target [", r63, r128, r25, "] for source [");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r129, r11, r25, r12, "], sampleSize: ");
        r129.append(r61);
        r129.append(", targetDensity: ");
        r129.append(r39.inTargetDensity);
        r129.append(r121);
        r129.append(r39.inDensity);
        r129.append(", density multiplier: ");
        r129.append(r60);
        Log.v(r26, r129.toString());
    L202:
        r119 = r63;
        r120 = r128;
        goto L203
    L198:
        r60 = 1.0f;
    L195:
        r59 = r31;
        goto L196
    L170:
        if (r41 != DecodeFormat.PREFER_ARGB_8888) goto L254;
        r32 = true;
        r39.inPreferredConfig = Bitmap.Config.ARGB_8888;
        goto L185
    L254:
        boolean r64 = r38.p().hasAlpha();     // Catch: IOException -> L173
    L178:
        if (r64 == false) goto L180;
        Bitmap.Config r65 = Bitmap.Config.ARGB_8888;
    L181:
        r39.inPreferredConfig = r65;
        if (r65 != Bitmap.Config.RGB_565) goto L168;
        r32 = true;
        r39.inDither = true;
        goto L185
    L180:
        r65 = Bitmap.Config.RGB_565;
    L173:
        e = move-exception;
        if (Log.isLoggable(r26, 3) == false) goto L177;
        Log.d(r26, "Cannot determine whether the image has alpha or not from header, format " + r41, e);
    L177:
        r64 = r31;
        goto L178
    L166:
        r31 = false;
        goto L167
    L134:
        if (r29.f1628a == false) goto L163;
        if (r27 == true) goto L163;
        if (r119 < 0) goto L160;
        if (r120 < 0) goto L160;
        monitor-enter(r29);
        int r66 = r29.f1630c + 1;     // Catch: Throwable -> L152
        r29.f1630c = r66;     // Catch: Throwable -> L152
        if (r66 < 50) goto L154;
        r29.f1630c = 0;     // Catch: Throwable -> L152
        int r67 = r.e.list().length;     // Catch: Throwable -> L152
        if (r67 >= r29.f1629b) goto L146;
        boolean r130 = true;
    L147:
        r29.d = r130;     // Catch: Throwable -> L152
        if (r130 == true) goto L154;
        if (Log.isLoggable("Downsampler", 5) == false) goto L154;
        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + r67 + ", limit " + r29.f1629b);     // Catch: Throwable -> L152
        goto L154
    L146:
        r130 = false;
    L154:
        boolean r68 = r29.d;     // Catch: Throwable -> L152
        monitor-exit(r29);
        if (r68 == false) goto L160;
        boolean r69 = true;
    L161:
        r30 = r69;
    L152:
        th = move-exception;
        throw th;
    L160:
        r69 = false;
        goto L161
    L59:
        if (r117 != 90) goto L61;
    L64:
        int r131 = r12;
        int r132 = r11;
    L65:
        float r70 = r40.b(r131, r132, r119, r120);
        if (r70 <= 0.0f) goto L125;
        int r210 = r117;
        DownsampleStrategy$SampleSizeRounding r133 = r40.a(r131, r132, r119, r120);
        if (r133 == null) goto L124;
        float r71 = r131;
        float r72 = r132;
        int r310 = r120;
        int r311 = r119;
        int r73 = r131 / ((int) (((double) (r70 * r71)) + 0.5d));
        int r74 = r132 / ((int) (((double) (r70 * r72)) + 0.5d));
        DownsampleStrategy$SampleSizeRounding r134 = DownsampleStrategy$SampleSizeRounding.MEMORY;
        if (r133 != r134) goto L72;
        int r75 = Math.max(r73, r74);
    L73:
        int r76 = Math.max(1, Integer.highestOneBit(r75));
        if (r133 == r134) goto L76;
    L78:
        r39.inSampleSize = r76;
        if (r22 != ImageHeaderParser$ImageType.JPEG) goto L85;
        float r77 = Math.min(r76, 8);
        int r78 = (int) Math.ceil(r71 / r77);
        int r79 = (int) Math.ceil(r72 / r77);
        int r80 = r76 / 8;
        if (r80 <= 0) goto L83;
        r78 = r78 / r80;
        r79 = r79 / r80;
    L83:
        r119 = r311;
        r120 = r310;
        double r135 = r40.b(r78, r79, r119, r120);
        if (r135 > 1.0d) goto L106;
        double r312 = r135;
    L107:
        int r136 = (int) Math.round(r312 * 2.147483647E9d);
        int r137 = (int) ((((double) r136) * r135) + 0.5d);
        r15 = r15;
        r39.inTargetDensity = (int) (((r135 / ((double) (r137 / r136))) * ((double) r137)) + 0.5d);
        if (r135 > 1.0d) goto L110;
        double r138 = r135;
    L111:
        int r81 = (int) Math.round(r138 * 2.147483647E9d);
        r39.inDensity = r81;
        int r139 = r39.inTargetDensity;
        if (r139 <= 0) goto L117;
        if (r81 <= 0) goto L117;
        if (r139 == r81) goto L117;
        r39.inScaled = true;
    L116:
        r26 = "Downsampler";
        if (Log.isLoggable(r26, 2) == false) goto L121;
        r25 = "x";
        r12 = r12;
        r11 = r11;
        StringBuilder r82 = j0.v("Calculate scaling, source: [", r11, r12, r25, "], degreesToRotate: ");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r82, r210, ", target: [", r119, r25);
        androidx.room.jarjarred.org.antlr.runtime.a.C(r82, r120, "], power of two scaled: [", r78, r25);
        r82.append(r79);
        r82.append("], exact scale factor: ");
        r82.append(r70);
        r82.append(", power of 2 sample size: ");
        r82.append(r76);
        r82.append(", adjusted scale factor: ");
        r82.append(r135);
        r23 = ", target density: ";
        r82.append(r23);
        r82.append(r39.inTargetDensity);
        r121 = ", density: ";
        r82.append(r121);
        r82.append(r39.inDensity);
        Log.v(r26, r82.toString());
        goto L131
    L121:
        r121 = r121;
        r23 = r23;
        r25 = "x";
        r12 = r12;
        r11 = r11;
    L117:
        r39.inTargetDensity = 0;
        r39.inDensity = 0;
        goto L116
    L110:
        r138 = 1.0d / r135;
        goto L111
    L106:
        r312 = 1.0d / r135;
        goto L107
    L85:
        if (r22 != ImageHeaderParser$ImageType.PNG) goto L87;
    L102:
        float r83 = r76;
        r78 = (int) Math.floor(r71 / r83);
        r79 = (int) Math.floor(r72 / r83);
        goto L83
    L87:
        if (r22 == ImageHeaderParser$ImageType.PNG_A) goto L102;
        if (r22 != ImageHeaderParser$ImageType.WEBP) goto L92;
    L101:
        float r84 = r76;
        r78 = Math.round(r71 / r84);
        r79 = Math.round(r72 / r84);
        goto L83
    L92:
        if (r22 == ImageHeaderParser$ImageType.WEBP_A) goto L101;
        if ((r131 % r76) != 0) goto L100;
        if ((r132 % r76) != 0) goto L100;
        r78 = r131 / r76;
        r79 = r132 / r76;
    L100:
        r39.inJustDecodeBounds = true;
        c(r38, r39, r47, r15);
        r39.inJustDecodeBounds = false;
        int[] r85 = {r39.outWidth, r39.outHeight};
        int r86 = r85[0];
        r79 = r85[1];
        r78 = r86;
        goto L83
    L76:
        if (r76 >= (1.0f / r70)) goto L78;
        r76 = r76 << 1;
        goto L78
    L72:
        r75 = Math.min(r73, r74);
        goto L73
    L124:
        throw new IllegalArgumentException("Cannot round with null rounding");
    L125:
        StringBuilder r87 = new StringBuilder("Cannot scale with factor: ");
        r87.append(r70);
        r87.append(" from: ");
        r87.append(r40);
        r87.append(", source: [");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r87, r11, "x", r12, "], target: [");
        r87.append(r119);
        r87.append("x");
        r87.append(r120);
        r87.append("]");
        throw new IllegalArgumentException(r87.toString());
    L61:
        if (r117 == 270) goto L64;
        r131 = r11;
        r132 = r12;
        goto L65
    L127:
        r28 = 3;
    L52:
        r120 = r11;
        goto L54
    L53:
        r120 = r45;
    L45:
        r119 = r12;
        goto L47
    L46:
        r119 = r44;
        goto L47
    L38:
        r118 = true;
        goto L40
    L33:
        r117 = 270;
        goto L36
    L34:
        r117 = 90;
        goto L36
    L35:
        r117 = 180;
    L20:
        th = th;
        s r88 = r115;
    L24:
        if (r88 != null) goto L258;
    L26:
        r18.e();
        throw th;
    L258:
        r88.close();     // Catch: IOException -> L253
    L22:
        th = th;
        r88 = null;
        goto L24
    L28:
        r116 = -1;
        goto L31
    L29:
        r20 = r16;
        r110 = r14;
        s r89 = (s) ((com.bumptech.glide.load.data.i) r38.f9377c).f1428b;
        r89.reset();
        r116 = f4.b.i((com.bumptech.glide.load.engine.bitmap_recycle.f) r38.f9376b, r89, (ArrayList) r38.d);
    L7:
        r17 = false;
        goto L9
    }
}
