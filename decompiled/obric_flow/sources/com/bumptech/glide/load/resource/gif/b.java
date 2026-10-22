package com.bumptech.glide.load.resource.gif;

import ai.j0;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.d0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b implements z.g {
    public static final com.lynx.tasm.utils.c f = null;
    public static final a g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1653c;
    public final com.lynx.tasm.utils.c d;
    public final com.lynx.animax.player.b e;

    static {
        f = new com.lynx.tasm.utils.c(3);
        g = new a();
    }

    public b(Context r5, ArrayList r10, com.bumptech.glide.load.engine.bitmap_recycle.a r11, com.bumptech.glide.load.engine.bitmap_recycle.f r12) {
        com.lynx.tasm.utils.c r13 = f;
        this.f1651a = r5.getApplicationContext();
        this.f1652b = r10;
        this.d = r13;
        this.e = new com.lynx.animax.player.b(2, r11, r12);
        this.f1653c = g;
    }

    public static int d(x.c r5, int r10, int r11) {
        int r12 = Math.min(r5.g / r11, r5.f / r10);
        if (r12 != 0) goto L5;
        int r13 = 0;
    L6:
        int r14 = Math.max(1, r13);
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L10;
        if (r14 <= 1) goto L10;
        StringBuilder r15 = j0.v("Downsampling GIF, sampleSize: ", r14, r10, ", target dimens: [", "x");
        r15.append(r11);
        r15.append("], actual dimens: [");
        r15.append(r5.f);
        r15.append("x");
        r15.append(r5.g);
        r15.append("]");
        Log.v("BufferGifDecoder", r15.toString());
    L10:
        return r14;
    L5:
        r13 = Integer.highestOneBit(r12);
        goto L6
    }

    @Override // z.g
    public final boolean a(Object r5, z.f r10) {
        ByteBuffer r11 = (ByteBuffer) r5;
        if (((Boolean) r10.c(j.f1661b)).booleanValue() == true) goto L19;
        if (r11 != null) goto L6;
        ImageHeaderParser$ImageType r12 = ImageHeaderParser$ImageType.UNKNOWN;
    L14:
        if (r12 != ImageHeaderParser$ImageType.GIF) goto L20;
        return true;
    L20:
        return false;
    L6:
        ArrayList r13 = this.f1652b;
        int r14 = r13.size();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L12;
        ImageHeaderParser$ImageType r16 = ((z.b) r13.get(r15)).b(r11);
        if (r16 != ImageHeaderParser$ImageType.UNKNOWN) goto L10;
        r15 = r15 + 1;
        goto L7
    L10:
        r12 = r16;
        goto L14
    L12:
        r12 = ImageHeaderParser$ImageType.UNKNOWN;
        goto L14
    L19:
        return false;
    }

    @Override // z.g
    public final d0 b(Object r10, int r11, int r12, z.f r13) {
        ByteBuffer r5 = (ByteBuffer) r10;
        a r14 = this.f1653c;
        monitor-enter(r14);
        x.d r15 = (x.d) r14.f1650a.poll();     // Catch: Throwable -> L8
        if (r15 != null) goto L7;
        r15 = new x.d();     // Catch: Throwable -> L8
    L7:
        x.d r16 = r15;
        r16.f22926b = null;     // Catch: Throwable -> L8
        Arrays.fill(r16.f22925a, (byte) 0);     // Catch: Throwable -> L8
        r16.f22927c = new x.c();     // Catch: Throwable -> L8
        r16.d = 0;     // Catch: Throwable -> L8
        ByteBuffer r17 = r5.asReadOnlyBuffer();     // Catch: Throwable -> L8
        r16.f22926b = r17;     // Catch: Throwable -> L8
        r17.position(0);     // Catch: Throwable -> L8
        r16.f22926b.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L8
        monitor-exit(r14);
        c r18 = c(r5, r11, r12, r16, r13);     // Catch: Throwable -> L16
        this.f1653c.a(r16);
        return r18;
    L16:
        th = move-exception;
        this.f1653c.a(r16);
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    public final c c(ByteBuffer r17, int r18, int r19, x.d r20, z.f r21) {
        int r5 = q0.f.f21454b;
        long r10 = SystemClock.elapsedRealtimeNanos();
        x.c r11 = r20.b();     // Catch: Throwable -> L12
        if (r11.f22919c <= 0) goto L27;
        if (r11.f22918b != 0) goto L27;
        if (r21.c(j.f1660a) != DecodeFormat.PREFER_RGB_565) goto L14;
        Bitmap.Config r12 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L12
    L15:
        int r13 = d(r11, r18, r19);     // Catch: Throwable -> L12
        com.lynx.tasm.utils.c r14 = this.d;     // Catch: Throwable -> L12
        com.lynx.animax.player.b r15 = this.e;     // Catch: Throwable -> L12
        r14.getClass();     // Catch: Throwable -> L12
        x.e r16 = new x.e(r15, r11, r17, r13);     // Catch: Throwable -> L12
        r16.c(r12);     // Catch: Throwable -> L12
        r16.f22934k = (r16.f22934k + 1) % r16.f22935l.f22919c;     // Catch: Throwable -> L12
        Bitmap r110 = r16.b();     // Catch: Throwable -> L12
        if (r110 == null) goto L18;
        c r22 = new c(new GifDrawable(new GifDrawable.GifState(new GifFrameLoader(com.bumptech.glide.b.b(this.f1651a), r16, r18, r19, f0.a.f16872b, r110))));     // Catch: Throwable -> L12
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L25;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + q0.f.a(r10));
    L25:
        return r22;
    L18:
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L20;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + q0.f.a(r10));
    L20:
        return null;
    L14:
        r12 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L12
    L27:
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L29;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + q0.f.a(r10));
    L29:
        return null;
    L12:
        th = move-exception;
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L33;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + q0.f.a(r10));
    L33:
        throw th;
    }
}
