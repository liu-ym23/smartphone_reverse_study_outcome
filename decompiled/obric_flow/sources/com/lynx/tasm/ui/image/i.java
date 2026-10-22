package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends an.c implements t0, Drawable.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f11047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f11048c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f11049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference f11050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f11051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11053l;

    public i(Context r5, String r10) {
        this.f11048c = null;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.f11049h = r5;
        this.f11051j = r10;
        PipelineDraweeControllerBuilder r11 = ((PipelineDraweeControllerBuilderSupplier) Fresco.f7726a.a()).a();
        if ((r5 instanceof LynxContext) == false) goto L5;
        ((LynxContext) r5).getClass();
    L5:
        v0 r12 = new v0(r5, r11, this, true);
        this.f11047b = r12;
        ImageResizeMethod r13 = ImageResizeMethod.f10988a;
        a0 r14 = r12.E;
        r14.f11014q = r13;
        r14.f11022z.c();
        r14.f11021y = new com.lynx.tasm.behavior.x0(this);
        r12.f11132r = new g(this, r5, r10);
    }

    @Override // an.c
    public final void a(int r10, int r11) {
        if (this.d == true) goto L5;
        v0 r5 = this.f11047b;
        r5.j();
        this.d = true;
        r5.f11121h = true;
    L5:
        this.f11052k = r10;
        this.f11053l = r11;
        this.f11047b.b(r10, r11, 0, 0, 0, 0);
    }

    @Override // an.c
    public final void b(Bitmap.Config r5) {
        a0 r10 = this.f11047b.E;
        r10.f11012o = r5;
        r10.f11022z.c();
    }

    @Override // an.c
    public final void c(LynxBaseUI r10) {
        this.f11050i = new WeakReference(r10);
        wn.c r5 = com.bytedance.apm.util.a.f(r10.getEnableLocalCache());
        boolean r11 = r10.getSkipRedirection();
        String r12 = this.f11051j;
        v0 r13 = this.f11047b;
        if (r11 == false) goto L5;
        a0 r14 = r13.E;
        r14.f11017u = r12;
        r14.r(r12);
    L6:
        boolean r15 = r5.f22882a;
        a0 r16 = r13.E;
        r16.s = r15;
        r16.f11016t = r5.f22883b;
        return;
    L5:
        r13.E.o(r12, null, true, false);
        r13.E.n(r12, null);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        if (this.f11048c == null) goto L14;
        v0 r10 = this.f11047b;
        if (r10.S == false) goto L12;
        Bitmap r11 = r10.f11113a0;
        if (r11 == null) goto L12;
        if (r11.isRecycled() == false) goto L12;
        LynxLog.b(4, "Lynx-Image", "bitmap has recycled and bitmap from cache is " + r10.f11115b0);
        return;
    L12:
        this.f11048c.draw(r5);
        return;
    }

    @Override // an.c
    public final int e() {
        return this.f;
    }

    @Override // an.c
    public final int f() {
        return this.e;
    }

    @Override // an.c
    public final boolean g() {
        if (this.f11048c == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // an.c
    public final void h() {
        if (this.d == true) goto L5;
        v0 r5 = this.f11047b;
        r5.j();
        this.d = true;
        r5.f11121h = true;
    L5:
        int r10 = this.f11052k;
        if (r10 <= 0) goto L11;
        int r11 = this.f11053l;
        if (r11 <= 0) goto L12;
        this.f11047b.b(r10, r11, 0, 0, 0, 0);
        return;
    L12:
        return;
    }

    @Override // an.c
    public final void i() {
        this.f11047b.k();
        this.d = false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        com.lynx.tasm.utils.j.f(new h(this, 0));
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        super.onBoundsChange(r5);
        Drawable r10 = this.f11048c;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    }

    @Override // com.lynx.tasm.ui.image.t0
    public final void onCloseableRefReady(CloseableReference r5) {
        if (r5 == null) goto L20;
        monitor-enter(r5);
        boolean r10 = r5.f7670a;     // Catch: Throwable -> L17
        monitor-exit(r5);
        if (r10 == true) goto L23;
        Object r11 = r5.c();
        if ((r11 instanceof CloseableBitmap) == false) goto L11;
        Bitmap r12 = ((CloseableStaticBitmap) ((CloseableBitmap) r11)).g;
    L14:
        if (r12 == null) goto L24;
        this.g = true;
        Bitmap r13 = r12.copy(r12.getConfig(), true);
        BitmapDrawable r14 = new BitmapDrawable(this.f11049h.getResources(), r13);
        this.f11048c = r14;
        r14.setBounds(getBounds());
        this.f11048c.setCallback(this);
        this.e = r12.getWidth();
        this.f = r12.getHeight();
        invalidateSelf();
        return;
    L24:
        return;
    L11:
        if ((r11 instanceof Bitmap) == false) goto L13;
        r12 = (Bitmap) r11;
        goto L14
    L13:
        r12 = null;
        goto L14
    L23:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.ui.image.t0
    public final void onDrawableReady(Drawable r5) {
        if (this.g == true) goto L18;
        this.f11048c = r5;
        r5.setBounds(getBounds());
        this.f11048c.setCallback(this);
        WeakReference r10 = this.f11050i;
        if (r10 == null) goto L16;
        LynxBaseUI r11 = (LynxBaseUI) r10.get();
        if (r11 == null) goto L16;
        int r12 = r11.getImageRendering();
        if (r12 != 2) goto L13;
        this.f11048c.setFilterBitmap(false);
        goto L16
    L13:
        if (r12 == 1) goto L15;
        if (r12 != 0) goto L16;
    L15:
        this.f11048c.setFilterBitmap(true);
    L16:
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r5, Runnable r10, long r11) {
        com.lynx.tasm.utils.j.a().postAtTime(r10, r5, r11);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r5, Runnable r10) {
        com.lynx.tasm.utils.j.a().removeCallbacks(r10, r5);
    }
}
