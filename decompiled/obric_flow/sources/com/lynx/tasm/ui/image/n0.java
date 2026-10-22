package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends i0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DrawableFactory f11083p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Supplier f11084q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public u0 f11085r;

    public n0(b r5, DrawableFactory r10, UiThreadImmediateExecutorService r11) {
        super(r5, r11);
        this.f11083p = r10;
    }

    @Override // com.lynx.tasm.ui.image.i0
    public final void f(Object r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (r10 == null) goto L6;
        r10.close();
        return;
    }

    public final Drawable g(Object r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (CloseableReference.b(r10) == false) goto L16;
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        CloseableImage r12 = (CloseableImage) r11;
        Drawable r13 = ((DefaultDrawableFactory) this.f11083p).a(r12);
        if (r13 == null) goto L11;
        return r13;
    L11:
        throw new UnsupportedOperationException("Unrecognized image class: " + r12);
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException();
    }

    public final ImageInfo h(Object r5) {
        CloseableReference r10 = (CloseableReference) r5;
        if (CloseableReference.b(r10) == false) goto L13;
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return (ImageInfo) r11;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException();
    }

    @Override // com.lynx.tasm.ui.image.i0
    public final String toString() {
        return new Objects.ToStringHelper(n0.class.getSimpleName()).a("super", super.toString()).a("dataSourceSupplier", this.f11084q).toString();
    }
}
