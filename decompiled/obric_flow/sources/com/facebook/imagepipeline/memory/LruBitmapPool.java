package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
public class LruBitmapPool implements BitmapPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapPoolBackend f8222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NoOpPoolStatsTracker f8224c;
    public int d;

    public LruBitmapPool(int r5, NoOpPoolStatsTracker r10) {
        this.f8222a = new BitmapPoolBackend();
        this.f8223b = r5;
        this.f8224c = r10;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L16:
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.d <= 0) goto L12;
        BitmapPoolBackend r5 = this.f8222a;     // Catch: Throwable -> L10
        Bitmap r10 = (Bitmap) r5.a(r5.f8226b.a());     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        this.f8222a.getClass();     // Catch: Throwable -> L10
        this.d -= BitmapUtil.a(r10);     // Catch: Throwable -> L10
        this.f8224c.getClass();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
    }

    @Override // com.facebook.common.memory.Pool
    public final Object get(int r5) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.d <= 0) goto L8;
        a();     // Catch: Throwable -> L6
    L8:
        BitmapPoolBackend r10 = this.f8222a;     // Catch: Throwable -> L6
        Bitmap r11 = (Bitmap) r10.a(r10.f8226b.a(r5));     // Catch: Throwable -> L6
        if (r11 != null) goto L11;
    L17:
        r11 = null;
    L18:
        if (r11 == null) goto L22;
        this.f8222a.getClass();     // Catch: Throwable -> L6
        this.d -= BitmapUtil.a(r11);     // Catch: Throwable -> L6
        this.f8224c.getClass();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r11;
    L22:
        this.f8224c.getClass();     // Catch: Throwable -> L6
        Bitmap r12 = Bitmap.createBitmap(1, r5, Bitmap.Config.ALPHA_8);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r12;
    L11:
        if (r11.isRecycled() == false) goto L14;
        FLog.a("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", new Object[]{r11});     // Catch: Throwable -> L6
        goto L17
    L14:
        if (r11.isMutable() == true) goto L16;
        FLog.a("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", new Object[]{r11});     // Catch: Throwable -> L6
        goto L17
    L16:
        r11.eraseColor(0);     // Catch: Throwable -> L6
        goto L18
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public final void release(Object r5) {
        Bitmap r10 = (Bitmap) r5;
        this.f8222a.getClass();
        int r11 = BitmapUtil.a(r10);
        if (r11 > this.f8223b) goto L12;
        this.f8224c.getClass();
        this.f8222a.b(r10);
        monitor-enter(this);
        this.d += r11;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
