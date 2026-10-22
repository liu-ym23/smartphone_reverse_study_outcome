package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g implements a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Bitmap.Config f1457j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f1459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uj.a f1460c;
    public final long d;
    public long e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1462i;

    static {
        f1457j = Bitmap.Config.ARGB_8888;
    }

    public g(long r5) {
        k r10 = new k();
        HashSet r11 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        r11.add(null);
        r11.remove(Bitmap.Config.HARDWARE);
        Set r12 = Collections.unmodifiableSet(r11);
        this.d = r5;
        this.f1458a = r10;
        this.f1459b = r12;
        this.f1460c = new uj.a();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public final Bitmap a(int r5, int r10, Bitmap.Config r11) {
        Bitmap r12 = d(r5, r10, r11);
        if (r12 != null) goto L9;
        if (r11 != null) goto L8;
        r11 = f1457j;
    L8:
        return Bitmap.createBitmap(r5, r10, r11);
    L9:
        return r12;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public final synchronized void b(Bitmap r10) {
        monitor-enter(this);
        if (r10 == null) goto L34;
        if (r10.isRecycled() == true) goto L32;
        if (r10.isMutable() == false) goto L26;
        this.f1458a.getClass();     // Catch: Throwable -> L17
        if (q0.i.c(r10) > this.d) goto L26;
        if (this.f1459b.contains(r10.getConfig()) == false) goto L26;
        this.f1458a.getClass();     // Catch: Throwable -> L17
        int r5 = q0.i.c(r10);     // Catch: Throwable -> L17
        this.f1458a.e(r10);     // Catch: Throwable -> L17
        this.f1460c.getClass();     // Catch: Throwable -> L17
        this.f1461h++;     // Catch: Throwable -> L17
        this.e += (long) r5;     // Catch: Throwable -> L17
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L20;
        StringBuilder r11 = new StringBuilder("Put bitmap in pool=");     // Catch: Throwable -> L17
        this.f1458a.getClass();     // Catch: Throwable -> L17
        r11.append(k.c(q0.i.c(r10), r10.getConfig()));     // Catch: Throwable -> L17
        Log.v("LruBitmapPool", r11.toString());     // Catch: Throwable -> L17
    L20:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L22;
        c();     // Catch: Throwable -> L17
    L22:
        h(this.d);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L26:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L28;
        StringBuilder r12 = new StringBuilder("Reject bitmap from pool, bitmap: ");     // Catch: Throwable -> L17
        this.f1458a.getClass();     // Catch: Throwable -> L17
        r12.append(k.c(q0.i.c(r10), r10.getConfig()));     // Catch: Throwable -> L17
        r12.append(", is mutable: ");     // Catch: Throwable -> L17
        r12.append(r10.isMutable());     // Catch: Throwable -> L17
        r12.append(", is allowed config: ");     // Catch: Throwable -> L17
        r12.append(this.f1459b.contains(r10.getConfig()));     // Catch: Throwable -> L17
        Log.v("LruBitmapPool", r12.toString());     // Catch: Throwable -> L17
    L28:
        r10.recycle();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L32:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L17
    L34:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Log.v("LruBitmapPool", "Hits=" + this.f + ", misses=" + this.g + ", puts=" + this.f1461h + ", evictions=" + this.f1462i + ", currentSize=" + this.e + ", maxSize=" + this.d + "\nStrategy=" + this.f1458a);
    }

    public final synchronized Bitmap d(int r10, int r11, Bitmap.Config r12) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r12 == Bitmap.Config.HARDWARE) goto L28;
        k r5 = this.f1458a;     // Catch: Throwable -> L15
        if (r12 == null) goto L9;
        Bitmap.Config r13 = r12;
    L10:
        Bitmap r14 = r5.b(r10, r11, r13);     // Catch: Throwable -> L15
        if (r14 == null) goto L13;
        this.f++;     // Catch: Throwable -> L15
        long r15 = this.e;     // Catch: Throwable -> L15
        this.f1458a.getClass();     // Catch: Throwable -> L15
        this.e = r15 - ((long) q0.i.c(r14));     // Catch: Throwable -> L15
        this.f1460c.getClass();     // Catch: Throwable -> L15
        r14.setHasAlpha(true);     // Catch: Throwable -> L15
        r14.setPremultiplied(true);     // Catch: Throwable -> L15
    L20:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L23;
        StringBuilder r16 = new StringBuilder("Get bitmap=");     // Catch: Throwable -> L15
        this.f1458a.getClass();     // Catch: Throwable -> L15
        r16.append(k.c(q0.i.b(r10, r11, r12), r12));     // Catch: Throwable -> L15
        Log.v("LruBitmapPool", r16.toString());     // Catch: Throwable -> L15
    L23:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L25;
        c();     // Catch: Throwable -> L15
    L25:
        monitor-exit(this);
        return r14;
    L13:
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L17;
        StringBuilder r17 = new StringBuilder("Missing bitmap=");     // Catch: Throwable -> L15
        this.f1458a.getClass();     // Catch: Throwable -> L15
        r17.append(k.c(q0.i.b(r10, r11, r12), r12));     // Catch: Throwable -> L15
        Log.d("LruBitmapPool", r17.toString());     // Catch: Throwable -> L15
    L17:
        this.g++;     // Catch: Throwable -> L15
        goto L20
    L9:
        r13 = f1457j;     // Catch: Throwable -> L15
        goto L10
    L28:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r12 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");     // Catch: Throwable -> L15
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public final void e(int r5) {
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L6;
        Log.d("LruBitmapPool", "trimMemory, level=" + r5);
    L6:
        if (r5 < 40) goto L8;
    L14:
        f();
        return;
    L8:
        if (r5 >= 20) goto L14;
        if (r5 < 20) goto L12;
    L13:
        h(this.d / 2);
        return;
    L12:
        if (r5 == 15) goto L13;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public final void f() {
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L5;
        Log.d("LruBitmapPool", "clearMemory");
    L5:
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public final Bitmap g(int r5, int r10, Bitmap.Config r11) {
        Bitmap r12 = d(r5, r10, r11);
        if (r12 == null) goto L5;
        r12.eraseColor(0);
        return r12;
    L5:
        if (r11 != null) goto L9;
        r11 = f1457j;
    L9:
        return Bitmap.createBitmap(r5, r10, r11);
    }

    public final synchronized void h(long r10) {
        monitor-enter(this);
    L29:
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.e <= r10) goto L25;
        k r5 = this.f1458a;     // Catch: Throwable -> L12
        Bitmap r11 = (Bitmap) r5.f1469b.B();     // Catch: Throwable -> L12
        if (r11 == null) goto L8;
        r5.a(Integer.valueOf(q0.i.c(r11)), r11);     // Catch: Throwable -> L12
    L8:
        if (r11 == null) goto L10;
        this.f1460c.getClass();     // Catch: Throwable -> L12
        long r12 = this.e;     // Catch: Throwable -> L12
        this.f1458a.getClass();     // Catch: Throwable -> L12
        this.e = r12 - ((long) q0.i.c(r11));     // Catch: Throwable -> L12
        this.f1462i++;     // Catch: Throwable -> L12
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L21;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L12
        r13.append("Evicting bitmap=");     // Catch: Throwable -> L12
        this.f1458a.getClass();     // Catch: Throwable -> L12
        r13.append(k.c(q0.i.c(r11), r11.getConfig()));     // Catch: Throwable -> L12
        Log.d("LruBitmapPool", r13.toString());     // Catch: Throwable -> L12
    L21:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L23;
        c();     // Catch: Throwable -> L12
    L23:
        r11.recycle();     // Catch: Throwable -> L12
        goto L29
    L10:
        if (Log.isLoggable("LruBitmapPool", 5) == false) goto L14;
        Log.w("LruBitmapPool", "Size mismatch, resetting");     // Catch: Throwable -> L12
        c();     // Catch: Throwable -> L12
    L14:
        this.e = 0;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L25:
        monitor-exit(this);
    }
}
