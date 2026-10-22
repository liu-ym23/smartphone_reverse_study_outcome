package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.d0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b implements z.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z.e f1599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z.e f1600c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f1601a;

    static {
        f1599b = z.e.a(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");
        f1600c = new z.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, z.e.e);
    }

    public b(com.bumptech.glide.load.engine.bitmap_recycle.f r5) {
        this.f1601a = r5;
    }

    @Override // z.h
    public final EncodeStrategy f(z.f r5) {
        return EncodeStrategy.TRANSFORMED;
    }

    @Override // z.a
    public final boolean g(Object r10, File r11, z.f r12) {
        Bitmap r13 = (Bitmap) ((d0) r10).get();
        z.e r5 = f1600c;
        Bitmap.CompressFormat r14 = (Bitmap.CompressFormat) r12.c(r5);
        if (r14 == null) goto L6;
    L9:
        r13.getWidth();
        r13.getHeight();
        int r15 = q0.f.f21454b;
        long r16 = SystemClock.elapsedRealtimeNanos();
        int r17 = ((Integer) r12.c(f1599b)).intValue();
        OutputStream r18 = null;
        FileOutputStream r19 = new FileOutputStream(r11);     // Catch: Throwable -> L28 IOException -> L30
        com.bumptech.glide.load.engine.bitmap_recycle.f r20 = this.f1601a;
        if (r20 != null) goto L59;
        r18 = r19;
    L22:
        r13.compress(r14, r17, r18);     // Catch: Throwable -> L28 IOException -> L30
        r18.close();     // Catch: Throwable -> L28 IOException -> L30
        r18.close();     // Catch: Throwable -> L25 IOException -> L47
    L27:
        boolean r21 = true;
    L39:
        if (Log.isLoggable("BitmapEncoder", 2) == false) goto L41;
        Log.v("BitmapEncoder", "Compressed with type: " + r14 + " of size " + q0.i.c(r13) + " in " + q0.f.a(r16) + ", options format: " + r12.c(r5) + ", hasAlpha: " + r13.hasAlpha());
    L41:
        return r21;
    L59:
        r18 = new com.bumptech.glide.load.data.c(r19, r20);     // Catch: Throwable -> L17 IOException -> L19
        goto L22
    L19:
        e = e;
        r18 = r19;
    L33:
        if (Log.isLoggable("BitmapEncoder", 3) == false) goto L35;
        Log.d("BitmapEncoder", "Failed to encode Bitmap", e);     // Catch: Throwable -> L28
    L35:
        if (r18 != null) goto L51;
    L37:
        r21 = false;
        goto L39
    L51:
        r18.close();     // Catch: Throwable -> L25 IOException -> L49
    L17:
        th = th;
        r18 = r19;
    L42:
        if (r18 != null) goto L53;
    L46:
        throw th;
    L53:
        r18.close();     // Catch: Throwable -> L25 IOException -> L48
    L28:
        th = th;
    L30:
        e = e;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r13.hasAlpha() == false) goto L8;
        r14 = Bitmap.CompressFormat.PNG;
        goto L9
    L8:
        r14 = Bitmap.CompressFormat.JPEG;
        goto L9
    }
}
