package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.ui.common.MultiUriHelper;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableDrawable;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    public ImageOriginListener A;
    public DebugOverlayImageOriginListener B;
    public ImageRequest C;
    public ImageRequest D;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DefaultDrawableFactory f7731w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final InstrumentedMemoryCache f7732x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BitmapMemoryCacheKey f7733y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Supplier f7734z;

    public PipelineDraweeController(Resources r5, DeferredReleaserConcurrentImpl r10, UiThreadImmediateExecutorService r11, InstrumentedMemoryCache r12) {
        super(r10, r11);
        this.f7731w = new DefaultDrawableFactory(r5);
        this.f7732x = r12;
    }

    public final void a(CloseableImage r5) {
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final ImageInfo b(Object r5) {
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

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Uri c() {
        return MultiUriHelper.getMainUri(this.C, this.D, null, ImageRequest.s);
    }

    public final synchronized RequestListener f() {
        monitor-enter(this);
        ImageOriginListener r5 = this.A;     // Catch: Throwable -> L7
        if (r5 == null) goto L9;
        ImageOriginRequestListener r10 = new ImageOriginRequestListener(this.f7778h, r5);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r10;
    L9:
        r10 = null;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final String toString() {
        return new Objects.ToStringHelper(getClass().getSimpleName()).a("super", super.toString()).a("dataSourceSupplier", this.f7734z).toString();
    }

    public final void a(DraweeHierarchy r5) {
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L5;
        FLog.a(AbstractDraweeController.f7774v, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f7778h, r5);
    L5:
        DraweeEventTracker r10 = this.f7775a;
        if (r5 == null) goto L8;
        DraweeEventTracker.Event r11 = DraweeEventTracker.Event.f7757a;
    L9:
        r10.a(r11);
        if (this.f7781k == false) goto L12;
        this.f7776b.a(this);
        release();
    L12:
        SettableDraweeHierarchy r12 = this.f;
        if (r12 == null) goto L15;
        RootDrawable r13 = ((GenericDraweeHierarchy) r12).e;
        r13.d = null;
        r13.invalidateSelf();
        this.f = null;
    L15:
        if (r5 != null) goto L17;
    L21:
        a(null);
        return;
    L17:
        if ((r5 instanceof SettableDraweeHierarchy) == false) goto L20;
        SettableDraweeHierarchy r14 = (SettableDraweeHierarchy) r5;
        this.f = r14;
        DebugControllerOverlayDrawable r15 = this.g;
        RootDrawable r16 = ((GenericDraweeHierarchy) r14).e;
        r16.d = r15;
        r16.invalidateSelf();
        goto L21
    L20:
        throw new IllegalArgumentException();
    L8:
        r11 = DraweeEventTracker.Event.f7758b;
        goto L9
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final Drawable a(Object r5) {
        CloseableReference r10 = (CloseableReference) r5;
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L13
        if (CloseableReference.b(r10) == false) goto L25;
        monitor-enter(r10);     // Catch: Throwable -> L13
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        CloseableImage r12 = (CloseableImage) r11;     // Catch: Throwable -> L13
        a(r12);     // Catch: Throwable -> L13
        if ((r12 instanceof CloseableDrawable) == false) goto L15;
        Drawable r13 = ((CloseableDrawable) r12).f;     // Catch: Throwable -> L13
        FrescoSystrace.a().getClass();
        return r13;
    L15:
        Fresco.a().e().f8068j.getClass();     // Catch: Throwable -> L13
        r12.getClass();     // Catch: Throwable -> L13
        Drawable r14 = this.f7731w.a(r12, this.f7787q);     // Catch: Throwable -> L13
        if (r14 == null) goto L20;
        FrescoSystrace.a().getClass();
        return r14;
    L20:
        throw new UnsupportedOperationException("Unrecognized image class: " + r12);     // Catch: Throwable -> L13
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L25:
        throw new IllegalStateException();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final void a(Supplier r5, String r10, BitmapMemoryCacheKey r11, Object r12, ImageOriginListener r13, ImageRequest r14) {
        FrescoSystrace.a().getClass();
        this.f7788r = r14;
        a(r10, r12);
        this.f7786p = false;
        this.f7734z = r5;
        a(null);
        this.f7733y = r11;
        monitor-enter(this);
        this.A = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        a(null);
        a(r13);
        FrescoSystrace.a().getClass();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(ImageOriginListener r5) {
        monitor-enter(this);
        ImageOriginListener r10 = this.A;     // Catch: Throwable -> L8
        if ((r10 instanceof ForwardingImageOriginListener) == false) goto L10;
        ((ForwardingImageOriginListener) r10).a(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        if (r10 == null) goto L14;
        this.A = new ForwardingImageOriginListener(new ImageOriginListener[]{r10, r5});     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        this.A = r5;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public final void a(String r5, CloseableReference r10) {
        monitor-enter(this);
        ImageOriginListener r11 = this.A;     // Catch: Throwable -> L6
        if (r11 == null) goto L8;
        r11.a(r5, 6, true, "PipelineDraweeController");     // Catch: Throwable -> L6
    L8:
        ForwardingRequestListener r12 = ((ImagePipelineFactory) Preconditions.a(ImagePipelineFactory.f8097u, "ImagePipelineFactory was not initialized!")).e().a((ImageRequest) this.f7788r, (BaseRequestListener) f());     // Catch: Throwable -> L6
        r12.a((ImageRequest) this.f7788r, null, "-1", false);     // Catch: Throwable -> L6
        r12.a((ImageRequest) this.f7788r, "-1", false);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
