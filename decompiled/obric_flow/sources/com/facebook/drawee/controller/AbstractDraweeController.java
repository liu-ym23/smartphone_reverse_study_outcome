package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier$FirstAvailableDataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.imagepipeline.blurhash.BlurHashMapUtils;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map f7772t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Map f7773u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Class f7774v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DraweeEventTracker f7775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeferredReleaserConcurrentImpl f7776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UiThreadImmediateExecutorService f7777c;
    public ControllerListener d;
    public final ForwardingControllerListener2 e;
    public SettableDraweeHierarchy f;
    public DebugControllerOverlayDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f7779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DataSource f7784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f7785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f7787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Object f7788r;
    public ImageRequest s;

    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        public InternalForwardingListener() {
        }

        public static InternalForwardingListener a(ControllerListener r5, ControllerListener r10) {
            FrescoSystrace.a().getClass();
            InternalForwardingListener r11 = new InternalForwardingListener();
            monitor-enter(r11);
            r11.f7805b.add(r5);     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            r11.a(r10);
            FrescoSystrace.a().getClass();
            return r11;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f7772t = ImmutableMap.a("component_tag", "drawee");
        f7773u = ImmutableMap.a("origin", "memory_bitmap", "origin_sub", "shortcut");
        f7774v = AbstractDraweeController.class;
    }

    public AbstractDraweeController(DeferredReleaserConcurrentImpl r5, UiThreadImmediateExecutorService r10) {
        if (DraweeEventTracker.f7755c == false) goto L5;
        DraweeEventTracker r11 = new DraweeEventTracker();
    L6:
        this.f7775a = r11;
        this.e = new ForwardingControllerListener2();
        this.f7786p = true;
        this.f7776b = r5;
        this.f7777c = r10;
        a(null, null);
        return;
    L5:
        r11 = DraweeEventTracker.f7754b;
        goto L6
    }

    public abstract Drawable a(Object r5);

    public abstract void a(String r5, CloseableReference r10);

    public final void a(String r5, Throwable r10) {
        FLogDefaultLoggingDelegate r11 = FLogDefaultLoggingDelegate.f7658a;
        if (r11.a(2) == false) goto L8;
        Class r12 = f7774v;
        Integer r13 = Integer.valueOf(System.identityHashCode(this));
        String r14 = this.f7778h;
        if (r11.a(2) == false) goto L9;
        String r15 = r12.getSimpleName();
        String r16 = String.format(null, "controller %x %s: %s: failure: %s", new Object[]{r13, r14, r5, r10});
        Log.println(2, FLogDefaultLoggingDelegate.a(r15), r16);
        return;
    L9:
        return;
    }

    public abstract ImageInfo b(Object r5);

    public final void b(String r10, Object r11) {
        FLogDefaultLoggingDelegate r5 = FLogDefaultLoggingDelegate.f7658a;
        if (r5.a(2) == false) goto L25;
        Class r12 = f7774v;
        Integer r13 = Integer.valueOf(System.identityHashCode(this));
        String r14 = this.f7778h;
        if (r11 == null) goto L7;
        String r15 = r11.getClass().getSimpleName();
    L8:
        CloseableReference r16 = (CloseableReference) r11;
        if (r16 == null) goto L18;
        monitor-enter(r16);
        boolean r17 = r16.f7670a;     // Catch: Throwable -> L15
        monitor-exit(r16);
        if (r17 == true) goto L18;
        int r18 = System.identityHashCode(r16.f7671b.d());
    L19:
        Object[] r19 = {r13, r14, r10, r15, Integer.valueOf(r18)};
        if (r5.a(2) == false) goto L26;
        String r20 = r12.getSimpleName();
        String r21 = String.format(null, "controller %x %s: %s: image: %s %x", r19);
        Log.println(2, FLogDefaultLoggingDelegate.a(r20), r21);
        return;
    L26:
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        r18 = 0;
        goto L19
    L7:
        r15 = "<null>";
        goto L8
    }

    public abstract Uri c();

    public final void c(String r5, Object r10) {
        ImageInfo r11 = b(r10);
        ControllerListener r12 = this.d;
        if (r12 != null) goto L5;
        r12 = BaseControllerListener.f7804a;
    L5:
        r12.a(r5, r11);
        b().onIntermediateImageSet(r5, r11);
    }

    public final void d() {
        boolean r5 = this.f7781k;
        this.f7781k = false;
        this.f7782l = false;
        DataSource r10 = this.f7784n;
        HashMap r11 = null;
        if (r10 == null) goto L5;
        HashMap r12 = ((AbstractDataSource) r10).f7703a;
        r10.close();
        this.f7784n = null;
    L6:
        this.f7787q = null;
        Object r13 = this.f7785o;
        if (r13 == null) goto L16;
        ImageInfo r14 = b(r13);
        if (r14 != null) goto L11;
        HashMap r15 = null;
    L12:
        b("release", this.f7785o);
        CloseableReference r16 = (CloseableReference) this.f7785o;
        if (r16 == null) goto L15;
        r16.close();
    L15:
        this.f7785o = null;
        r11 = r15;
        goto L16
    L11:
        r15 = ((CloseableImage) r14).f8169b;
    L16:
        if (r5 == false) goto L19;
        a(r12, r11);
        return;
    L19:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void e() {
        FrescoSystrace.a().getClass();
        PipelineDraweeController r5 = (PipelineDraweeController) this;
        FrescoSystrace.a().getClass();
        InstrumentedMemoryCache r10 = r5.f7732x;     // Catch: Throwable -> L16
        if (r10 == null) goto L22;
        BitmapMemoryCacheKey r11 = r5.f7733y;     // Catch: Throwable -> L16
        if (r11 == null) goto L22;
        CloseableReference r12 = r10.a(r11);     // Catch: Throwable -> L16
        if (r12 == null) goto L21;
        monitor-enter(r12);     // Catch: Throwable -> L16
        Object r13 = r12.f7671b.d();     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
    L14:
        if (((ImmutableQualityInfo) ((CloseableImage) r13).c()).f8193c == true) goto L21;
        r12.close();     // Catch: Throwable -> L16
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L21:
        CloseableReference r14 = r12;
    L23:
        FrescoSystrace.a().getClass();
        a(r14);
        final boolean r15 = false;
        if (r14 == null) goto L27;
        FrescoSystrace.a().getClass();
        this.f7784n = null;
        this.f7781k = true;
        this.f7782l = false;
        this.f7775a.a(DraweeEventTracker.Event.s);
        a(this.f7784n, b(r14));
        a(this.f7778h, r14);
        a(this.f7778h, this.f7784n, r14, 1.0f, true, true, true);
        FrescoSystrace.a().getClass();
        FrescoSystrace.a().getClass();
        return;
    L27:
        this.f7775a.a(DraweeEventTracker.Event.f7762j);
        SettableDraweeHierarchy r16 = this.f;
        if (r16 == null) goto L30;
        ((GenericDraweeHierarchy) r16).a(0.0f, true);
    L30:
        this.f7781k = true;
        this.f7782l = false;
        FrescoSystrace.a().getClass();
        FLogDefaultLoggingDelegate r17 = FLogDefaultLoggingDelegate.f7658a;
        if (r17.a(2) == false) goto L33;
        FLog.a(PipelineDraweeController.class, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(r5)));
    L33:
        DataSource r18 = (DataSource) r5.f7734z.get();
        FrescoSystrace.a().getClass();
        this.f7784n = r18;
        a(r18, null);
        if (r17.a(2) == false) goto L36;
        FLog.a(f7774v, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f7778h, Integer.valueOf(System.identityHashCode(this.f7784n)));
    L36:
        final String r19 = this.f7778h;
        DataSource r20 = this.f7784n;
        if (r20 != null) goto L39;
    L41:
        BaseDataSubscriber<Object> r21 = new AnonymousClass2(this, r19, r15);
        ((AbstractDataSource) this.f7784n).a(r21, this.f7777c);
        if (c() == null) goto L44;
        BlurHashMapUtils.f8000a.put(c().toString(), this);
    L44:
        FrescoSystrace.a().getClass();
        return;
    L39:
        if (r20.a() == false) goto L41;
        r15 = true;
    L22:
        r14 = null;
    L16:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public final void release() {
        this.f7775a.a(DraweeEventTracker.Event.f7761i);
        SettableDraweeHierarchy r5 = this.f;
        if (r5 == null) goto L5;
        ((GenericDraweeHierarchy) r5).b();
    L5:
        d();
    }

    public String toString() {
        Objects.ToStringHelper r5 = new Objects.ToStringHelper(getClass().getSimpleName()).a("isAttached", String.valueOf(this.f7780j)).a("isRequestSubmitted", String.valueOf(this.f7781k)).a("hasFetchFailed", String.valueOf(this.f7782l));
        CloseableReference r10 = (CloseableReference) this.f7785o;
        if (r10 == null) goto L12;
        monitor-enter(r10);
        boolean r11 = r10.f7670a;     // Catch: Throwable -> L9
        monitor-exit(r10);
        if (r11 == true) goto L12;
        int r12 = System.identityHashCode(r10.f7671b.d());
    L14:
        return r5.a("fetchedImage", String.valueOf(r12)).a("events", this.f7775a.f7756a.toString()).toString();
    L9:
        th = move-exception;
        throw th;
    L12:
        r12 = 0;
        goto L14
    }

    public final synchronized void a(String r5, Object r10) {
        monitor-enter(this);
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L8
        this.f7775a.a(DraweeEventTracker.Event.f);     // Catch: Throwable -> L8
        if (this.f7786p == true) goto L10;
        DeferredReleaserConcurrentImpl r11 = this.f7776b;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r11.a(this);     // Catch: Throwable -> L8
    L10:
        this.f7780j = false;     // Catch: Throwable -> L8
        d();     // Catch: Throwable -> L8
        this.f7783m = false;     // Catch: Throwable -> L8
        ControllerListener r12 = this.d;     // Catch: Throwable -> L8
        if ((r12 instanceof InternalForwardingListener) == false) goto L13;
        ((InternalForwardingListener) r12).d();     // Catch: Throwable -> L8
    L14:
        SettableDraweeHierarchy r13 = this.f;     // Catch: Throwable -> L8
        if (r13 == null) goto L17;
        ((GenericDraweeHierarchy) r13).b();     // Catch: Throwable -> L8
        RootDrawable r14 = ((GenericDraweeHierarchy) this.f).e;     // Catch: Throwable -> L8
        r14.d = null;     // Catch: Throwable -> L8
        r14.invalidateSelf();     // Catch: Throwable -> L8
        this.f = null;     // Catch: Throwable -> L8
    L17:
        this.g = null;     // Catch: Throwable -> L8
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L20;
        FLog.a(f7774v, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f7778h, r5);     // Catch: Throwable -> L8
    L20:
        this.f7778h = r5;     // Catch: Throwable -> L8
        this.f7779i = r10;     // Catch: Throwable -> L8
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L13:
        this.d = null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final ControllerListener2 b() {
        return this.e;
    }

    public final void a(String r5, DataSource r10, Throwable r11, boolean r12) {
        FrescoSystrace.a().getClass();
        if (a(r5, r10) == true) goto L6;
        a("ignore_old_datasource @ onFailure", r11);
        r10.close();
        FrescoSystrace.a().getClass();
        return;
    L6:
        DraweeEventTracker r13 = this.f7775a;
        if (r12 == false) goto L9;
        DraweeEventTracker.Event r14 = DraweeEventTracker.Event.f7765m;
    L10:
        r13.a(r14);
        if (r12 == false) goto L27;
        a("final_failed @ onFailure", r11);
        this.f7784n = null;
        this.f7782l = true;
        if (this.f7783m == false) goto L19;
        Drawable r15 = this.f7787q;
        if (r15 == null) goto L19;
        SettableDraweeHierarchy r16 = this.f;
        if (r16 == null) goto L26;
        ((GenericDraweeHierarchy) r16).a(r15, 1.0f, true);
    L26:
        a(r11, r10);
    L28:
        FrescoSystrace.a().getClass();
        return;
    L19:
        SettableDraweeHierarchy r17 = this.f;
        if (r17 == null) goto L26;
        GenericDraweeHierarchy r18 = (GenericDraweeHierarchy) r17;
        r18.f.f7846q++;
        r18.a();
        if (r18.f.a(5) == null) goto L24;
        r18.f.c(5);
    L25:
        r18.f.a();
        goto L26
    L24:
        r18.f.c(1);
        goto L25
    L27:
        a("intermediate_failed @ onFailure", r11);
        a(r11);
        goto L28
    L9:
        r14 = DraweeEventTracker.Event.f7766n;
        goto L10
    }

    public final void a(String r10, DataSource r11, Object r12, float r13, boolean r14, boolean r15, boolean r16) {
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L7
        if (a(r10, r11) == true) goto L9;
        b("ignore_old_datasource @ onNewResult", r12);     // Catch: Throwable -> L7
        ((CloseableReference) r12).close();     // Catch: Throwable -> L7
        r11.close();     // Catch: Throwable -> L7
        FrescoSystrace.a().getClass();
        return;
    L9:
        DraweeEventTracker r5 = this.f7775a;     // Catch: Throwable -> L7
        if (r14 == false) goto L12;
        DraweeEventTracker.Event r17 = DraweeEventTracker.Event.f7763k;     // Catch: Throwable -> L7
    L13:
        r5.a(r17);     // Catch: Throwable -> L7
        Drawable r18 = a(r12);     // Catch: Throwable -> L7 Exception -> L62
        Object r19 = this.f7785o;     // Catch: Throwable -> L7
        this.f7785o = r12;     // Catch: Throwable -> L7
        this.f7787q = r18;     // Catch: Throwable -> L7
        if ((r11 instanceof FirstAvailableDataSourceSupplier$FirstAvailableDataSource) == false) goto L27;
        FirstAvailableDataSourceSupplier$FirstAvailableDataSource r20 = (FirstAvailableDataSourceSupplier$FirstAvailableDataSource) r11;     // Catch: Throwable -> L7
        monitor-enter(r20);     // Catch: Throwable -> L7
        boolean r21 = r20.f7705c;     // Catch: Throwable -> L24
        monitor-exit(r20);     // Catch: Throwable -> L24
        if (r21 == true) goto L27;
        throw null;     // Catch: Throwable -> L7
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L27:
        HashMap r22 = new HashMap();     // Catch: Throwable -> L7
        r22.put("drawableWidth", Integer.valueOf(r18.getIntrinsicWidth()));     // Catch: Throwable -> L7
        r22.put("drawableHeight", Integer.valueOf(r18.getIntrinsicHeight()));     // Catch: Throwable -> L7
        r22.put("scene_tag", this.f7779i);     // Catch: Throwable -> L7
        if (r14 == false) goto L36;
        b("set_final_result @ onNewResult", r12);     // Catch: Throwable -> L33
        this.f7784n = null;     // Catch: Throwable -> L33
        SettableDraweeHierarchy r110 = this.f;     // Catch: Throwable -> L33
        if (r110 == null) goto L35;
        ((GenericDraweeHierarchy) r110).a(r18, 1.0f, r15);     // Catch: Throwable -> L33
    L35:
        a(r10, r12, r11);     // Catch: Throwable -> L33
    L53:
        if (r19 == null) goto L56;
        if (r19 == r12) goto L56;
        b("release_previous_result @ onNewResult", r19);     // Catch: Throwable -> L7
        ((CloseableReference) r19).close();     // Catch: Throwable -> L7
    L56:
        FrescoSystrace.a().getClass();
        return;
    L36:
        if (r16 == false) goto L41;
        b("set_temporary_result @ onNewResult", r12);     // Catch: Throwable -> L33
        SettableDraweeHierarchy r111 = this.f;     // Catch: Throwable -> L33
        if (r111 == null) goto L40;
        ((GenericDraweeHierarchy) r111).a(r18, 1.0f, r15);     // Catch: Throwable -> L33
    L40:
        a(r10, r12, r11);     // Catch: Throwable -> L33
        goto L53
    L41:
        b("set_intermediate_result @ onNewResult", r12);     // Catch: Throwable -> L33
        SettableDraweeHierarchy r23 = this.f;     // Catch: Throwable -> L33
        if (r23 == null) goto L44;
        ((GenericDraweeHierarchy) r23).a(r18, r13, r15);     // Catch: Throwable -> L33
    L44:
        c(r10, r12);     // Catch: Throwable -> L33
        Object r24 = this.d;     // Catch: Throwable -> L33
        if (r24 != null) goto L47;
        Object r112 = BaseControllerListener.f7804a;     // Catch: Throwable -> L33
    L49:
        if ((r112 instanceof BaseControllerListener) == false) goto L53;
        if (r24 != null) goto L52;
        r24 = BaseControllerListener.f7804a;     // Catch: Throwable -> L33
    L52:
        ((BaseControllerListener) r24).c(r10, b(r12), a());     // Catch: Throwable -> L33
        goto L53
    L47:
        r112 = r24;
    L33:
        th = move-exception;
        if (r19 == null) goto L61;
        if (r19 == r12) goto L61;
        b("release_previous_result @ onNewResult", r19);     // Catch: Throwable -> L7
        ((CloseableReference) r19).close();     // Catch: Throwable -> L7
    L61:
        throw th;     // Catch: Throwable -> L7
    L62:
        e = move-exception;
        b("drawable_failed @ onNewResult", r12);     // Catch: Throwable -> L7
        ((CloseableReference) r12).close();     // Catch: Throwable -> L7
        a(r10, r11, e, r14);     // Catch: Throwable -> L7
        FrescoSystrace.a().getClass();
        return;
    L12:
        r17 = DraweeEventTracker.Event.f7764l;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        FrescoSystrace.a().getClass();
        throw th;
    }

    public final void a(ControllerListener r5) {
        r5.getClass();
        ControllerListener r10 = this.d;
        if ((r10 instanceof InternalForwardingListener) == false) goto L12;
        InternalForwardingListener r11 = (InternalForwardingListener) r10;
        monitor-enter(r11);
        r11.f7805b.add(r5);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        if (r10 == null) goto L15;
        this.d = InternalForwardingListener.a(r10, r5);
        return;
    L15:
        this.d = r5;
    }

    public final void a(Throwable r5) {
        ControllerListener r10 = this.d;
        if (r10 != null) goto L5;
        r10 = BaseControllerListener.f7804a;
    L5:
        r10.a(this.f7778h, r5);
        b().onIntermediateImageFailed(this.f7778h);
    }

    public final void a(Map r5, HashMap r10) {
        ControllerListener r11 = this.d;
        if (r11 != null) goto L5;
        r11 = BaseControllerListener.f7804a;
    L5:
        r11.a(this.f7778h);
        b().onRelease(this.f7778h, a(r5, r10, null));
        ControllerListener r12 = this.d;
        if (r12 != null) goto L9;
        r12 = BaseControllerListener.f7804a;
    L9:
        if ((r12 instanceof BaseControllerListener) == false) goto L11;
        ImageRequest r13 = (ImageRequest) this.f7788r;
        ((BaseControllerListener) r12).c();
    L11:
        r12.a(this.f7778h);
    }

    public final void a(DataSource r10, ImageInfo r11) {
        ControllerListener r5 = this.d;
        if (r5 != null) goto L5;
        r5 = BaseControllerListener.f7804a;
    L5:
        r5.a(this.f7778h, this.f7779i);
        ControllerListener2 r12 = b();
        String r13 = this.f7778h;
        Object r14 = this.f7779i;
        Uri r15 = c();
        HashMap r16 = null;
        if (r10 != null) goto L8;
        HashMap r17 = null;
    L9:
        if (r11 == null) goto L12;
        r16 = ((CloseableImage) r11).f8169b;
    L12:
        r12.onSubmit(r13, r14, a(r17, r16, r15));
        return;
    L8:
        r17 = ((AbstractDataSource) r10).f7703a;
        goto L9
    }

    public final boolean a(String r5, DataSource r10) {
        if (r10 != null) goto L8;
        if (this.f7784n != null) goto L8;
        return true;
    L8:
        if (r5.equals(this.f7778h) == true) goto L10;
        return false;
    L10:
        if (r10 == this.f7784n) goto L12;
        return false;
    L12:
        if (this.f7781k == false) goto L17;
        return true;
    L17:
        return false;
    }

    public final Animatable a() {
        Object r5 = this.f7787q;
        if ((r5 instanceof Animatable) == true) goto L5;
        return null;
    L5:
        return (Animatable) r5;
    }

    public final void a(String r10, Object r11, DataSource r12) {
        ImageInfo r5 = b(r11);
        HashMap r13 = new HashMap();
        r13.put("drawableWidth", Integer.valueOf(this.f7787q.getIntrinsicWidth()));
        r13.put("drawableHeight", Integer.valueOf(this.f7787q.getIntrinsicHeight()));
        ControllerListener r14 = this.d;
        if (r14 != null) goto L6;
        r14 = BaseControllerListener.f7804a;
    L6:
        if ((r14 instanceof BaseControllerListener) == false) goto L8;
        ImageInfo r15 = b(r11);
        Animatable r16 = a();
        ImageRequest r17 = (ImageRequest) this.f7788r;
        ((BaseControllerListener) r14).b(r10, r15, r16);
    L8:
        r14.a(r10, r5, a());
        ControllerListener2 r18 = b();
        if (r12 != null) goto L11;
        HashMap r19 = null;
    L12:
        if (r5 != null) goto L14;
        HashMap r20 = null;
    L15:
        r18.onFinalImageSet(r10, r5, a(r19, r20, null));
        return;
    L14:
        r20 = ((CloseableImage) r5).f8169b;
        goto L15
    L11:
        r19 = ((AbstractDataSource) r12).f7703a;
        goto L12
    }

    public final ControllerListener2.Extras a(Map r15, HashMap r16, Uri r17) {
        SettableDraweeHierarchy r5 = this.f;
        Rect r10 = null;
        if ((r5 instanceof GenericDraweeHierarchy) == false) goto L19;
        GenericDraweeHierarchy r11 = (GenericDraweeHierarchy) r5;
        if (r11 != null) goto L8;
        String r12 = null;
    L12:
        if (r11 != null) goto L15;
    L16:
        PointF r13 = null;
    L18:
        PointF r14 = r13;
        String r18 = r12;
    L20:
        Map r19 = f7772t;
        Map r20 = f7773u;
        SettableDraweeHierarchy r21 = this.f;
        if (r21 == null) goto L25;
        r10 = ((GenericDraweeHierarchy) r21).e.getBounds();
    L25:
        return MiddlewareUtils.a(r19, r20, r15, r10, r18, r14, r16, this.f7779i, r17);
    L15:
        if ((r11.a(2) instanceof ScaleTypeDrawable) == false) goto L16;
        r13 = r11.b(2).e;
        goto L18
    L8:
        if ((r11.a(2) instanceof ScaleTypeDrawable) == true) goto L10;
        ScalingUtils.ScaleType r22 = null;
    L11:
        r12 = String.valueOf(r22);
        goto L12
    L10:
        r22 = r11.b(2).d;
        goto L11
    L19:
        r18 = null;
        r14 = null;
        goto L20
    }

    public final void a(Throwable r5, DataSource r10) {
        if (r10 != null) goto L5;
        HashMap r11 = null;
    L6:
        ControllerListener2.Extras r12 = a(r11, null, null);
        ControllerListener r13 = this.d;
        if (r13 != null) goto L9;
        r13 = BaseControllerListener.f7804a;
    L9:
        r13.b(this.f7778h, r5);
        b().onFailure(this.f7778h, r5, r12);
        ControllerListener r14 = this.d;
        if (r14 != null) goto L13;
        r14 = BaseControllerListener.f7804a;
    L13:
        if ((r14 instanceof BaseControllerListener) == false) goto L15;
        ImageRequest r15 = (ImageRequest) this.f7788r;
        ((BaseControllerListener) r14).b();
    L15:
        r14.b(this.f7778h, r5);
        return;
    L5:
        r11 = ((AbstractDataSource) r10).f7703a;
        goto L6
    }

    public static void a(CloseableReference r5) {
        if (r5 != null) goto L5;
        r5 = null;
    L5:
        if (r5 == null) goto L15;
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        if ((r10 instanceof CloseableImage) == false) goto L18;
        CloseableImage r11 = (CloseableImage) r5.c();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
