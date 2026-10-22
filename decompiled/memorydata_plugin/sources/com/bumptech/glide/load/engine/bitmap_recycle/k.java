package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config f765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f766b;
    private final Set<Bitmap.Config> c;
    private final long d;
    private final a e;
    private long f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;

    private interface a {
        void a(Bitmap r1);

        void b(Bitmap r1);
    }

    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void a(Bitmap r1) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.k.a
        public void b(Bitmap r1) {
        }
    }

    static {
        f765a = Bitmap.Config.ARGB_8888;
    }

    public k(long r3) {
        this(r3, f(), g());
    }

    k(long r3, l r5, Set<Bitmap.Config> r6) {
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        Set<Bitmap.Config> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        this.d = r3;
        this.f = r3;
        this.f766b = r7;
        this.c = r8;
        this.e = new b();
    }

    private synchronized void a(long r6) {
        monitor-enter(this);
    L23:
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.g <= r6) goto L18;
        Bitmap r0 = this.f766b.a();     // Catch: Throwable -> L20
        if (r0 == null) goto L8;
        this.e.b(r0);     // Catch: Throwable -> L20
        this.g -= (long) this.f766b.c(r0);     // Catch: Throwable -> L20
        this.k++;     // Catch: Throwable -> L20
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L16;
        Log.d("LruBitmapPool", "Evicting bitmap=" + this.f766b.b(r0));     // Catch: Throwable -> L20
    L16:
        d();     // Catch: Throwable -> L20
        r0.recycle();     // Catch: Throwable -> L20
        goto L23
    L8:
        if (Log.isLoggable("LruBitmapPool", 5) == false) goto L10;
        Log.w("LruBitmapPool", "Size mismatch, resetting");     // Catch: Throwable -> L20
        e();     // Catch: Throwable -> L20
    L10:
        this.g = 0;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L18:
        monitor-exit(this);
    }

    private static void a(Bitmap.Config r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        return;
    L6:
        if (r3 == Bitmap.Config.HARDWARE) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + r3 + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private static void b(Bitmap r1) {
        r1.setHasAlpha(true);
        c(r1);
    }

    private static Bitmap c(int r0, int r1, Bitmap.Config r2) {
        if (r2 != null) goto L6;
        r2 = f765a;
    L6:
        return Bitmap.createBitmap(r0, r1, r2);
    }

    private void c() {
        a(this.f);
    }

    private static void c(Bitmap r2) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r2.setPremultiplied(true);
        return;
    }

    private synchronized Bitmap d(int r6, int r7, Bitmap.Config r8) {
        monitor-enter(this);
        a(r8);     // Catch: Throwable -> L20
        l r0 = this.f766b;     // Catch: Throwable -> L20
        if (r8 == null) goto L6;
        Bitmap.Config r1 = r8;
    L7:
        Bitmap r2 = r0.a(r6, r7, r1);     // Catch: Throwable -> L20
        if (r2 == null) goto L10;
        this.h++;     // Catch: Throwable -> L20
        this.g -= (long) this.f766b.c(r2);     // Catch: Throwable -> L20
        this.e.b(r2);     // Catch: Throwable -> L20
        b(r2);     // Catch: Throwable -> L20
    L15:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L17;
        Log.v("LruBitmapPool", "Get bitmap=" + this.f766b.b(r6, r7, r8));     // Catch: Throwable -> L20
    L17:
        d();     // Catch: Throwable -> L20
        monitor-exit(this);
        return r2;
    L10:
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L12;
        Log.d("LruBitmapPool", "Missing bitmap=" + this.f766b.b(r6, r7, r8));     // Catch: Throwable -> L20
    L12:
        this.i++;     // Catch: Throwable -> L20
        goto L15
    L6:
        r1 = f765a;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private void d() {
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L6;
        e();
        return;
    }

    private void e() {
        Log.v("LruBitmapPool", "Hits=" + this.h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.g + ", maxSize=" + this.f + "\nStrategy=" + this.f766b);
    }

    private static l f() {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        return new n();
    L6:
        return new c();
    }

    private static Set<Bitmap.Config> g() {
        HashSet r0 = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r0.add(null);
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        r0.remove(Bitmap.Config.HARDWARE);
    L9:
        return Collections.unmodifiableSet(r0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public Bitmap a(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = d(r1, r2, r3);
        if (r0 == null) goto L6;
        r0.eraseColor(0);
        return r0;
    L6:
        return c(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L5;
        Log.d("LruBitmapPool", "clearMemory");
    L5:
        a(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a(int r5) {
        if (Log.isLoggable("LruBitmapPool", 3) == false) goto L6;
        Log.d("LruBitmapPool", "trimMemory, level=" + r5);
    L6:
        if (r5 < 40) goto L8;
    L15:
        a();
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        if (r5 >= 20) goto L15;
    L11:
        if (r5 < 20) goto L13;
    L14:
        a(b() / 2);
        return;
    L13:
        if (r5 == 15) goto L14;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public synchronized void a(Bitmap r7) {
        monitor-enter(this);
        if (r7 == null) goto L30;
        if (r7.isRecycled() == true) goto L26;
        if (r7.isMutable() == false) goto L20;
        if (this.f766b.c(r7) > this.f) goto L20;
        if (this.c.contains(r7.getConfig()) == false) goto L20;
        int r0 = this.f766b.c(r7);     // Catch: Throwable -> L27
        this.f766b.a(r7);     // Catch: Throwable -> L27
        this.e.a(r7);     // Catch: Throwable -> L27
        this.j++;     // Catch: Throwable -> L27
        this.g += (long) r0;     // Catch: Throwable -> L27
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L16;
        Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f766b.b(r7));     // Catch: Throwable -> L27
    L16:
        d();     // Catch: Throwable -> L27
        c();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L20:
        if (Log.isLoggable("LruBitmapPool", 2) == false) goto L22;
        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f766b.b(r7) + ", is mutable: " + r7.isMutable() + ", is allowed config: " + this.c.contains(r7.getConfig()));     // Catch: Throwable -> L27
    L22:
        r7.recycle();     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L26:
        throw new IllegalStateException("Cannot pool recycled bitmap");     // Catch: Throwable -> L27
    L30:
        throw new NullPointerException("Bitmap must not be null");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public long b() {
        return this.f;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public Bitmap b(int r1, int r2, Bitmap.Config r3) {
        Bitmap r0 = d(r1, r2, r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return c(r1, r2, r3);
    }
}
