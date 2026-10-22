package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {
    public CloseableReference f;
    public volatile Bitmap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final QualityInfo f8171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Rect f8174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f8175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8176m;

    public CloseableStaticBitmap(Bitmap r5, SimpleBitmapReleaser r10, QualityInfo r11, int r12) {
        r5.getClass();
        this.g = r5;
        Bitmap r13 = this.g;
        r10.getClass();
        this.f = CloseableReference.a(r13, r10, CloseableReference.f);
        this.f8171h = r11;
        this.f8172i = r12;
        this.f8173j = 0;
        this.f8174k = null;
        this.f8175l = null;
        this.f8176m = -1;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final synchronized boolean a() {
        monitor-enter(this);
        CloseableReference r5 = this.f;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 != null) goto L8;
        return true;
    L8:
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final QualityInfo c() {
        return this.f8171h;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        monitor-enter(this);
        CloseableReference r5 = this.f;     // Catch: Throwable -> L8
        this.f = null;     // Catch: Throwable -> L8
        this.g = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r5 == null) goto L13;
        r5.close();
        return;
    L13:
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.CloseableImage
    public final int d() {
        return BitmapUtil.a(this.g);
    }

    public final synchronized CloseableReference e() {
        monitor-enter(this);
        CloseableReference r5 = this.f;     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        CloseableReference r10 = r5.b();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L10:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getHeight() {
        if ((this.f8172i % 180) != 0) goto L14;
        int r5 = this.f8173j;
        if (r5 == 5) goto L14;
        if (r5 == 7) goto L14;
        Bitmap r10 = this.g;
        if (r10 != null) goto L13;
        return 0;
    L13:
        return r10.getHeight();
    L14:
        Bitmap r11 = this.g;
        if (r11 != null) goto L18;
        return 0;
    L18:
        return r11.getWidth();
    }

    @Override // com.facebook.imagepipeline.image.ImageInfo
    public final int getWidth() {
        if ((this.f8172i % 180) != 0) goto L14;
        int r5 = this.f8173j;
        if (r5 == 5) goto L14;
        if (r5 == 7) goto L14;
        Bitmap r10 = this.g;
        if (r10 != null) goto L13;
        return 0;
    L13:
        return r10.getWidth();
    L14:
        Bitmap r11 = this.g;
        if (r11 != null) goto L18;
        return 0;
    L18:
        return r11.getHeight();
    }

    public CloseableStaticBitmap(CloseableReference r5, QualityInfo r10, int r11, int r12, Rect r13, Rect r14, int r15) {
        CloseableReference r16 = r5.b();
        r16.getClass();
        this.f = r16;
        monitor-enter(r16);
        Object r17 = r16.f7671b.d();     // Catch: Throwable -> L8
        monitor-exit(r16);     // Catch: Throwable -> L8
        this.g = (Bitmap) r17;
        this.f8171h = r10;
        this.f8172i = r11;
        this.f8173j = r12;
        this.f8174k = r13;
        this.f8175l = r14;
        this.f8176m = r15;
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public CloseableStaticBitmap(CloseableReference r5, QualityInfo r10, int r11, int r12, Rect r13, Rect r14, int r15, ImageFormat r16) {
        CloseableReference r17 = r5.b();
        r17.getClass();
        this.f = r17;
        monitor-enter(r17);
        Object r18 = r17.f7671b.d();     // Catch: Throwable -> L8
        monitor-exit(r17);     // Catch: Throwable -> L8
        this.g = (Bitmap) r18;
        this.f8171h = r10;
        this.f8172i = r11;
        this.f8173j = r12;
        this.f8174k = r13;
        this.f8175l = r14;
        this.f8176m = r15;
        this.f8168a = r16;
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
