package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BorderRadius;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.service.ILynxImageService;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e0 {
    public static final Handler j0 = null;
    public final boolean A;
    public boolean B;
    public final boolean C;
    public RoundingParams D;
    public GenericDraweeHierarchy E;
    public final h F;
    public LynxBaseUI G;
    public long H;
    public boolean I;
    public ColorFilter J;
    public boolean K;
    public boolean L;
    public y<GenericDraweeHierarchy> M;
    public y<GenericDraweeHierarchy> N;
    public final Map<String, y<GenericDraweeHierarchy>> O;
    public CloseableReference<CloseableImage> P;
    public v Q;
    public DefaultDrawableFactory R;
    public CacheKey S;
    public MemoryCache<CacheKey, CloseableImage> T;
    public boolean U;
    public int V;
    public boolean W;
    public boolean X;
    public Animatable Y;
    public CloseableReference<?> Z;
    public final LynxContext a;
    public CloseableReference<?> a0;
    public final Context b;
    public boolean b0;
    public final AbstractDraweeControllerBuilder c;
    public final boolean c0;
    public ControllerListener d;
    public Bitmap d0;
    public final Object e;
    public boolean e0;
    public int f;
    public final boolean f0;
    public int g;
    public int g0;
    public ScalingUtils.ScaleType h;
    public View h0;
    public boolean i;
    public WeakReference<FlattenUIImage> i0;
    public BorderRadius j;
    public boolean k;
    public DraweeHolder<GenericDraweeHierarchy> l;
    public DraweeHolder<GenericDraweeHierarchy> m;
    public final Map<String, DraweeHolder<GenericDraweeHierarchy>> n;
    public n0 o;
    public n0 p;
    public final c q;
    public l8a.d r;
    public l s;
    public int t;
    public int u;
    public int v;
    public int w;
    public final boolean x;
    public CloseableReference<?> y;
    public volatile boolean z;

    public class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ e0 a;

        public a(e0 r1) {
            this.a = r1;
        }

        public final void onFailure(String r2, Throwable r3) {
            e0 r4 = this.a;
            r4.e0 = false;
            r4.l();
            e0.a(this.a, r3);
        }

        public final void onFinalImageSet(String r11, Object r12, Animatable r13) {
            CloseableStaticBitmap r3 = (ImageInfo) r12;
            this.a.l();
            if (this.a.z == false) goto L5;
            e0.j0.post(new d0(this, r11));
        L5:
            e0 r14 = this.a;
            r14.Y = r13;
            r14.e0 = false;
            if ((r3 instanceof CloseableStaticBitmap) == false) goto L14;
            CloseableStaticBitmap r15 = r3;
            r14.d0 = r15.getUnderlyingBitmap();
            if (this.a.z == true) goto L12;
            e0 r16 = this.a;
            CloseableReference<?> r1 = r16.Z;
            if (r1 == null) goto L13;
            CloseableReference.closeSafely(r1);
            r16.Z = null;
        L13:
            e0 r17 = this.a;
            r17.Z = r15.cloneUnderlyingBitmapReference();
            goto L14
        L12:
            e0 r18 = this.a;
            r18.a0 = r18.Z;
        L14:
            e0 r19 = this.a;
            CloseableReference<CloseableImage> r110 = r19.P;
            if (r110 == null) goto L17;
            CloseableReference.closeSafely(r110);
            r19.P = null;
        L17:
            e0 r111 = this.a;
            ILynxImageService r112 = r111.F.r0;
            if (r112 == null) goto L21;
            if (r3 == null) goto L21;
            r111.g0 = r112.getImageOrigin(r3);
        L21:
            e0 r113 = this.a;
            r113.F.h(r113.f, r113.g, r3, r13, r113.H, true, r113.g0, r113.s);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ImageRequest a;
        public final /* synthetic */ ImageRequest b;
        public final /* synthetic */ e0 c;

        public class a extends BaseControllerListener<ImageInfo> {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void onFailure(String r1, Throwable r2) {
                e0.a(this.a.c, r2);
            }

            public final void onFinalImageSet(String r11, Object r12, Animatable r13) {
                ImageInfo r3 = (ImageInfo) r12;
                if ((r3 instanceof CloseableStaticBitmap) == false) goto L10;
                if (this.a.c.l.hasHierarchy() == false) goto L10;
                GenericDraweeHierarchy r14 = this.a.c.l.getHierarchy();
                if (r14 == null) goto L10;
                r14.setFadeDuration(this.a.c.V);
            L10:
                if (this.a.c.z == false) goto L12;
                e0.j0.post(new f0(this, r11));
            L12:
                e0 r15 = this.a.c;
                ILynxImageService r16 = r15.F.r0;
                if (r16 == null) goto L16;
                if (r3 == null) goto L16;
                r15.g0 = r16.getImageOrigin(r3);
            L16:
                e0 r17 = this.a.c;
                r17.F.h(r17.f, r17.g, r3, r13, r17.H, true, r17.g0, r17.s);
            }
        }

        /* JADX INFO: renamed from: com.lynx.tasm.ui.image.e0$b$b, reason: collision with other inner class name */
        public class RunnableC0068b implements Runnable {
            public final /* synthetic */ b a;

            public final void a() {
                b r0 = this.a;
                ImageRequest r1 = r0.b;
                e0 r2 = r0.c;
                if (r1 == r2.r) goto L6;
                return;
            L6:
                if (r2.z == true) goto L10;
                e0 r3 = this.a.c;
                c r4 = r3.q;
                if (r4 == null) goto L10;
                r4.onDrawableReady(r3.l.getTopLevelDrawable());
            L10:
                TraceEvent.beginSection("LynxImageManager.onAttach");
                this.a.c.c();
                e0 r5 = this.a.c;
                if (r5.k == false) goto L13;
                r5.l.onAttach();
            L13:
                TraceEvent.endSection("LynxImageManager.onAttach");
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0068b(b r1) {
                this.a = r1;
            }
        }

        public final void a() {
            TraceEvent.beginSection("LynxImageManager.ImageRequestJobScheduler");
            e0 r1 = this.c;
            ColorFilter r2 = r1.J;
            if (r2 == null) goto L5;
            r1.E.setActualImageColorFilter(r2);
        L5:
            e0 r3 = this.c;
            if (r3.l != null) goto L8;
        L9:
            e0 r4 = this.c;
            DraweeHolder<GenericDraweeHierarchy> r5 = r4.l;
            if (r5 == null) goto L18;
            if (r4.C == true) goto L14;
            r4.m = r5;
            goto L18
        L14:
            if ((r5.getController() instanceof AbstractDraweeController) == false) goto L18;
            e0 r6 = this.c;
            r6.n.put(r6.l.getController().getId(), this.c.l);
        L18:
            if (this.c.z == false) goto L22;
            e0 r7 = this.c;
            n0 r8 = r7.o;
            if (r8 == null) goto L22;
            r7.p = r8;
            r7.o = null;
        L22:
            e0 r9 = this.c;
            r9.l = DraweeHolder.create(r9.E, r9.b);
        L23:
            this.c.c.reset();
            ImageRequest r10 = this.a;
            e0 r11 = this.c;
            r11.d = new a(this);
            e0 r12 = this.c;
            AbstractDraweeControllerBuilder r13 = r12.c.setAutoPlayAnimations(r12.I).setCallerContext(this.c.e).setControllerListener(this.c.d);
            if (r10 == null) goto L26;
            boolean r14 = true;
        L27:
            r13.setRetainImageOnFailure(r14).setImageRequest(this.b).setOldController(this.c.l.getController()).setLowResImageRequest(r10);
            e0 r15 = this.c;
            Context r16 = r15.b;
            AbstractDraweeControllerBuilder r17 = r15.c;
            r15.l.setController(r17.build());
            this.c.c.reset();
            e0 r18 = this.c;
            if (r18.B == false) goto L30;
        L32:
            e0 r19 = this.c;
            if (r19.x == true) goto L35;
        L37:
            RunnableC0068b r20 = new RunnableC0068b(this);
            if (this.c.A == true) goto L40;
        L42:
            e0.j0.post(r20);
        L43:
            TraceEvent.endSection("LynxImageManager.ImageRequestJobScheduler");
            return;
        L40:
            if (Looper.myLooper() != Looper.getMainLooper()) goto L42;
            r20.run();
            goto L43
        L35:
            if (r19.l.hasHierarchy() == false) goto L37;
            this.c.l.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
            goto L37
        L30:
            if (r18.l.hasHierarchy() == false) goto L32;
            e0 r21 = this.c;
            r21.E.setRoundingParams(r21.D);
            this.c.l.getHierarchy().setActualImageScaleType(o.a(this.c.h));
            goto L32
        L26:
            r14 = false;
            goto L27
        L8:
            if (r3.z == false) goto L23;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(e0 r1, l8a.d r2, l8a.d r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public interface c {
        void onCloseableRefReady(CloseableReference<?> r1);

        void onDrawableReady(Drawable r1);
    }

    public final void h() {
        this.k = true;
        if (this.U == false) goto L6;
        this.H = System.currentTimeMillis();
        y<GenericDraweeHierarchy> r1 = this.M;
        r1.b = true;
        r1.a = true;
        return;
    L6:
        if (this.l == null) goto L10;
        this.H = System.currentTimeMillis();
        this.l.onAttach();
        return;
    }

    public final void i() {
        this.k = false;
        if (this.U == false) goto L22;
        CloseableReference<CloseableImage> r1 = this.P;
        if (r1 == null) goto L7;
        CloseableReference.closeSafely(r1);
        this.P = null;
    L7:
        y<GenericDraweeHierarchy> r2 = this.M;
        if (r2 == null) goto L16;
        r2.b = false;
        if (r2.a == false) goto L16;
        r2.a = false;
        x r3 = new x(r2);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L15;
        r3.run();
        goto L16
    L15:
        LynxThreadPool.d().execute(r3);
    L16:
        this.d0 = null;
        CloseableReference<?> r4 = this.Z;
        if (r4 == null) goto L19;
        CloseableReference.closeSafely(r4);
        this.Z = null;
    L19:
        GenericDraweeHierarchy r5 = this.E;
        if (r5 == null) goto L23;
        r5.reset();
    L23:
        h r6 = this.F;
        r6.d = 0;
        r6.e = 0;
        CloseableReference<?> r0 = this.y;
        if (r0 == null) goto L27;
        r0.close();
        this.y = null;
        return;
    L27:
        return;
    L22:
        c();
        goto L23
    }

    static {
        j0 = new Handler(Looper.getMainLooper());
    }

    public final void c() {
        DraweeHolder<GenericDraweeHierarchy> r0 = this.l;
        if (r0 == null) goto L5;
        r0.onDetach();
    L5:
        n0 r1 = this.o;
        if (r1 == null) goto L9;
        r1.onDetach();
        return;
    }

    public final boolean e() {
        if (this.U == true) goto L5;
        DraweeHolder<GenericDraweeHierarchy> r0 = this.l;
        if (r0 != null) goto L12;
    L16:
        return false;
    L12:
        if (r0.getController() == null) goto L16;
        if (this.l.getController().getAnimatable() == null) goto L16;
        return true;
    L5:
        if (this.Y != null) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean f() {
        Bitmap r0 = this.d0;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isRecycled() == false) goto L10;
        LLog.e("Lynx-Image", "bitmap has recycled and bitmap from cache is " + this.e0);
        return true;
    L10:
        return false;
    }

    public final void l() {
        if (this.B == false) goto L7;
        this.X = false;
        this.W = false;
        return;
    L7:
        if (this.X == false) goto L10;
        this.E.setActualImageScaleType(o.a(this.h));
        this.X = false;
    L10:
        if (this.W == false) goto L19;
        BorderRadius r0 = this.j;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r0.a() == null) goto L16;
        this.D = RoundingParams.fromCornersRadii(this.j.a());
    L17:
        this.E.setRoundingParams(this.D);
        this.W = false;
        return;
    L16:
        this.D = null;
        goto L17
    }

    public final void d() {
        this.T = Fresco.getImagePipeline().getBitmapMemoryCache();
        this.R = new DefaultDrawableFactory(this.b.getResources(), Fresco.getImagePipelineFactory().getAnimatedDrawableFactory(this.b));
        this.Q = new v(this.b, this.R);
        GenericDraweeHierarchy r0 = new GenericDraweeHierarchyBuilder(this.b.getResources()).setActualImageScaleType(o.a(this.h)).setFadeDuration(0).build();
        this.E = r0;
        this.M = new y(r0);
        LynxContext r1 = this.a;
        if (r1 == null) goto L5;
        LynxFeatureCounter.a(85, r1.getInstanceId());
    L5:
        this.d = new a(this);
        h r2 = this.F;
        r2.i0 = this.E;
    }

    public static void a(e0 r17, Throwable r18) {
        h r1 = r17.F;
        if (r1.m(r1.v) == true) goto L20;
        LLog.e("FrescoImageView", "onFailed src:" + r17.F.v + "with reason" + r18.getMessage());
        int r2 = u7a.b.a(r18);
        int r3 = u7a.b.b(r2);
        r17.g0 = -1;
        String r4 = r18.getMessage();
        if (r17.s == null) goto L18;
        int r5 = 0;
        if (TextUtils.isEmpty(r4) == false) goto L14;
        r4 = Log.getStackTraceString(r18);
        if (r4 == null) goto L14;
        if (r4.length() <= 200) goto L14;
        r4 = r4.substring(0, 200);
    L14:
        LynxError r6 = new LynxError(r3, "Android LynxImageManager loading image failed", NameKeys.UnloadStrategy_No_Strategy, "error");
        r6.setRootCause(r4);
        LynxBaseUI r7 = r17.G;
        if (r7 == null) goto L17;
        r5 = r7.getNodeIndex();
    L17:
        r6.addCustomInfo("node_index", Integer.toString(r5));
        r17.s.onImageLoadFailed(r6, r3, r2);
    L18:
        long r14 = System.currentTimeMillis();
        h r8 = r17.F;
        r8.j(r8.v, false, r17.H, r14, 0, null);
        h r9 = r17.F;
        r9.l(r9.v, false, false, r17.H, r14, r2, 0);
        h r10 = r17.F;
        r10.k(r10.v, r2, false, r17.g0, r17.H, r14, true, 0, 0);
        r17.F.getClass();
        return;
    }

    public e0(Context r4, PipelineDraweeControllerBuilder r5, Object r6, c r7, boolean r8) {
        boolean r0 = false;
        this.f = 0;
        this.g = 0;
        this.j = null;
        this.k = false;
        this.n = new LinkedHashMap();
        this.x = false;
        this.y = null;
        this.z = false;
        this.A = false;
        this.B = false;
        this.G = null;
        this.I = true;
        this.J = null;
        this.L = false;
        this.O = new LinkedHashMap();
        this.U = false;
        this.V = 0;
        this.g0 = -1;
        this.b = r4;
        this.h = ScalingUtils.ScaleType.FIT_XY;
        this.c = r5;
        this.e = r6;
        this.q = r7;
        LynxContext r9 = com.lynx.tasm.utils.a.a(r4);
        this.a = r9;
        if (r9 == null) goto L13;
        this.A = r9.isSyncImageAttach();
        boolean r10 = r9.isEnableAsyncImageCallback();
        this.c0 = r10;
        if (r9.isEnableAsyncRequestImage() == true) goto L11;
        if (r10 == true) goto L11;
        if (r9.isForceImageAsyncRequest() == true) goto L11;
        if (LynxEnv.inst().enableImageAsyncRequest() == true) goto L11;
    L12:
        this.U = r0;
    L11:
        r0 = true;
    L13:
        this.B = !LynxEnv.inst().disableImagePostProcessor();
        this.C = LynxEnv.inst().enableFlattenImageFlickerFix();
        this.f0 = LynxEnv.inst().enableImageRequestOptimize();
        h r11 = new h(r4, new c0(this));
        this.F = r11;
        boolean r12 = this.U;
        r11.H = r12;
        if (r12 == false) goto L16;
        d();
    L16:
        this.x = r8;
        r11.D = r8;
    }

    public final void g(int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.f0 == false) goto L12;
        if (Math.abs(this.f - r4) <= 1) goto L7;
    L10:
        this.f = r4;
        this.g = r5;
        this.i = true;
    L16:
        this.t = r6;
        this.u = r8;
        this.v = r7;
        this.w = r9;
        if (this.i == true) goto L19;
        return;
    L19:
        if (r4 <= 0) goto L22;
        if (r5 <= 0) goto L22;
    L24:
        h r0 = this.F;
        if (r0.x == null) goto L27;
    L29:
        l r1 = this.s;
        if (r1 == null) goto L32;
        r1.onImageStartLoad();
    L32:
        TraceEvent.beginSection("LynxImageManager.maybeUpdateView");
        h r2 = this.F;
        if (r2.t == true) goto L35;
    L41:
        this.g0 = -1;
        if (this.F.t == false) goto L54;
        CloseableReference<?> r3 = this.y;
        if (r3 == null) goto L50;
        if (r3.isValid() == false) goto L50;
        if (this.y.get() == null) goto L50;
    L51:
        TraceEvent.endSection("LynxImageManager.maybeUpdateView");
        return;
    L50:
        if (this.F.u == true) goto L51;
    L54:
        if (this.U == false) goto L56;
        k(r4, r5, r6, r7, r8, r9);
    L57:
        TraceEvent.endSection("LynxImageManager.maybeUpdateView");
        return;
    L56:
        j(r4, r5, r6, r7, r8, r9);
        goto L57
    L35:
        if (r2.K == true) goto L37;
        r2.x(r4, r5);
        goto L41
    L37:
        if (r2.y(r4, r5) == false) goto L41;
        TraceEvent.endSection("LynxImageManager.maybeUpdateView");
        return;
    L27:
        if (r0.y != null) goto L29;
        return;
    L22:
        if (this.F.m == true) goto L24;
        return;
    L7:
        if (Math.abs(this.g - r5) > 1) goto L10;
        LLog.d("LynxImageManager", "setBounds with src:" + this.F.v + " :pre-size: " + this.f + ":" + this.g + " :cur-size: " + r4 + ":" + r5);
        goto L16
    L12:
        if (this.f == r4) goto L14;
    L15:
        this.f = r4;
        this.g = r5;
        this.i = true;
        goto L16
    L14:
        if (this.g == r5) goto L16;
        goto L15
    }

    public final void j(int r32, int r33, int r34, int r35, int r36, int r37) {
        if (TraceEvent.isTracingStarted() == false) goto L13;
        HashMap r1 = new HashMap();
        String r2 = this.F.v;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        r1.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.F.v);
    L12:
        TraceEvent.beginSection("LynxImageManager.tryFetchImageFromFresco", r1);
        goto L13
    L7:
        if (r2.startsWith("http") == false) goto L9;
        r3 = true;
    L13:
        ScalingUtils.ScaleType r10 = this.h;
        BorderRadius r4 = this.j;
        if (r4 == null) goto L16;
        r4.d(r32, r33);
        float[] r8 = this.j.a();
    L17:
        m(r34, r35, r36, r37, r8, r10);
        if (this.E != null) goto L20;
    L23:
        this.E = new GenericDraweeHierarchyBuilder(this.b.getResources()).setRoundingParams(null).build();
    L24:
        h r5 = this.F;
        r5.i0 = this.E;
        float[] r16 = r8;
        l8a.d r11 = b(r5.x, r32, r33, r34, r35, r36, r37, r16, r10);
        if (this.F.Y == false) goto L31;
        ILynxImageService r6 = (ILynxImageService) i8a.n.c().a(ILynxImageService.class);
        if (r6 == null) goto L31;
        View r7 = this.h0;
        if (r7 == null) goto L31;
        r6.setImageSRSize(r11, r7);
    L31:
        this.r = r11;
        this.H = System.currentTimeMillis();
        if (this.B == false) goto L86;
        Drawable r9 = n0.e;
        if (r11 == null) goto L43;
        CloseableReference r12 = Fresco.getImagePipeline().getBitmapMemoryCache().get(Fresco.getImagePipeline().getCacheKeyFactory().getPostprocessedBitmapCacheKey(r11, null));
        if (r12 == null) goto L43;
        if (r12.get() == null) goto L43;
        if ((r12.get() instanceof CloseableStaticBitmap) == false) goto L43;
    L44:
        if (r12 != null) goto L46;
    L79:
        boolean r17 = false;
    L80:
        if (r17 == true) goto L82;
        this.D = null;
        float[] r13 = r16;
    L91:
        b r14 = new b(this, b(this.F.y, r32, r33, r34, r35, r36, r37, r13, r10), r11);
        if (this.A == false) goto L97;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L97;
        r14.run();
    L118:
        this.i = false;
        h r15 = this.F;
        r15.b = r32;
        r15.c = r33;
        if (TraceEvent.isTracingStarted() == false) goto L125;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFresco");
        return;
    L125:
        return;
    L97:
        if (n.g == null) goto L99;
    L108:
        n r18 = n.g;
        r18.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L118;
        Handler r19 = r18.e;
        if (r19 == null) goto L114;
        r19.post(r14);
        goto L118
    L114:
        if (r18.c != null) goto L116;
        r18.c = new LinkedList();
    L116:
        ((LinkedList) r18.c).add(r14);
        goto L118
    L99:
        monitor-enter(n.class);
    L105:
        th = move-exception;
        throw th;
    L101:
        if (n.g != null) goto L103;
        n.g = new n();     // Catch: Throwable -> L105
    L103:
        monitor-exit(n.class);     // Catch: Throwable -> L105
        goto L108
    L82:
        if (TraceEvent.isTracingStarted() == false) goto L124;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFresco");
        return;
    L124:
        return;
    L46:
        if (r12.get() == null) goto L79;
        c();
        n0 r20 = new n0(r12);
        this.o = r20;
        ColorFilter r21 = this.J;
        if (r21 == null) goto L53;
        Drawable r22 = r20.b;
        if (r22 == null) goto L53;
        r22.setColorFilter(r21);
    L53:
        if (this.s == null) goto L67;
        m8a.g r23 = this.F.x;
        if (r23 == null) goto L59;
        ConcurrentHashMap<String, FrescoImageView.d> r24 = h.t0;
        if (r24.containsKey(r23.b().toString()) == false) goto L59;
        FrescoImageView.d r25 = r24.get(this.F.x.b().toString());
        int r26 = r25.a;
        int r27 = r25.b;
    L61:
        if (this.L == false) goto L64;
        this.F.o(this.f, this.g, r26, r27, this.H, System.currentTimeMillis(), 5);
    L68:
        h r28 = this.F;
        if (r28.m == true) goto L71;
    L75:
        boolean r29 = false;
    L76:
        if (r29 == false) goto L78;
        r28.e = r27;
        r28.d = r26;
        r28.i();
    L78:
        this.q.onDrawableReady(this.o.d);
        h r30 = this.F;
        r30.k(r30.v, 0, true, 5, this.H, System.currentTimeMillis(), true, r26, r27);
        h r31 = this.F;
        System.currentTimeMillis();
        r31.getClass();
        this.i = false;
        r17 = true;
        goto L80
    L71:
        if (r28.d != 0) goto L75;
        if (r28.e != 0) goto L75;
        r29 = true;
        goto L76
    L64:
        if (this.K == false) goto L66;
        this.F.n(this.f, this.g, r26, r27, this.H, System.currentTimeMillis(), true, 5);
        goto L68
    L66:
        this.s.onImageLoadSuccess(r26, r27);
    L59:
        CloseableImage r38 = (CloseableImage) r12.get();
        r26 = r38.getWidth();
        r27 = r38.getHeight();
        goto L61
    L67:
        r27 = 0;
        r26 = 0;
    L43:
        r12 = null;
        goto L44
    L86:
        r13 = r16;
        if (r13 == null) goto L91;
        if (r13.length != 8) goto L91;
        this.D = RoundingParams.fromCornersRadii(r13);
        goto L91
    L20:
        if (this.z == true) goto L23;
        this.E.reset();
        goto L24
    L16:
        r8 = null;
        goto L17
    }

    public final void k(int r31, int r32, int r33, int r34, int r35, int r36) {
        if (TraceEvent.isTracingStarted() == false) goto L13;
        HashMap r0 = new HashMap();
        String r1 = this.F.v;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        r0.put(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.F.v);
    L12:
        TraceEvent.beginSection("LynxImageManager.tryFetchImageFromFrescoAsync", r0);
        goto L13
    L7:
        if (r1.startsWith("http") == false) goto L9;
        r2 = true;
    L13:
        ScalingUtils.ScaleType r9 = this.h;
        BorderRadius r3 = this.j;
        if (r3 != null) goto L16;
        float[] r16 = null;
    L20:
        this.B = false;
        m(r33, r34, r35, r36, r16, r9);
        l8a.d r10 = b(this.F.x, r31, r32, r33, r34, r35, r36, r16, r9);
        this.r = r10;
        Object r4 = this.e;
        CacheKeyFactory r5 = Fresco.getImagePipeline().getCacheKeyFactory();
        if (r5 == null) goto L27;
        if (r10 == null) goto L27;
        if (r10.getPostprocessor() == null) goto L26;
        CacheKey r8 = r5.getPostprocessedBitmapCacheKey(r10, r4);
    L28:
        this.S = r8;
        this.H = System.currentTimeMillis();
        CacheKey r6 = this.S;
        if (r6 == null) goto L91;
        MemoryCache<CacheKey, CloseableImage> r7 = this.T;
        if (r7 == null) goto L91;
        CloseableReference<CloseableImage> r11 = r7.get(r6);
        if (r11 == null) goto L91;
        if (r11.get() == null) goto L91;
        if (((CloseableImage) r11.get()).getQualityInfo().isOfFullQuality() == true) goto L40;
        CloseableReference.closeSafely(r11);
        goto L91
    L40:
        CloseableBitmap r12 = (CloseableImage) r11.get();
        if ((r12 instanceof CloseableBitmap) == false) goto L128;
        this.d0 = r12.getUnderlyingBitmap();
    L128:
        Drawable r13 = this.R.createDrawable(r12);     // Catch: Exception -> L90
        if (this.B == true) goto L47;
        this.E.setImage(r13, 1.0f, true);     // Catch: Exception -> L90
    L47:
        if (this.s == null) goto L61;
        m8a.g r14 = this.F.x;
        if (r14 == null) goto L53;
        ConcurrentHashMap<String, FrescoImageView.d> r15 = h.t0;
        if (r15.containsKey(r14.b().toString()) == false) goto L53;
        FrescoImageView.d r17 = r15.get(this.F.x.b().toString());
        int r18 = r17.a;
        int r19 = r17.b;
    L55:
        if (this.L == false) goto L58;
        this.F.o(this.f, this.g, r18, r19, this.H, System.currentTimeMillis(), 5);
    L62:
        h r20 = this.F;
        if (r20.m == true) goto L65;
    L69:
        boolean r21 = false;
    L70:
        if (r21 == false) goto L72;
        r20.e = r19;
        r20.d = r18;
        r20.i();
    L72:
        l();
        ColorFilter r22 = this.J;
        if (r22 != null) goto L75;
    L78:
        c r23 = this.q;
        if (this.B == true) goto L86;
        DH r24 = this.M.c;
        if (r24 != 0) goto L84;
        Drawable r25 = null;
    L85:
        r13 = r25;
        goto L86
    L84:
        r25 = r24.getTopLevelDrawable();
    L86:
        r23.onDrawableReady(r13);
        CloseableReference<CloseableImage> r26 = this.P;
        if (r26 == null) goto L89;
        CloseableReference.closeSafely(r26);
        this.P = null;
    L89:
        this.P = r11;
        this.i = false;
        this.e0 = true;
        h r27 = this.F;
        r27.k(r27.v, 0, true, 5, this.H, System.currentTimeMillis(), true, r18, r19);
        h r28 = this.F;
        System.currentTimeMillis();
        r28.getClass();
        boolean r29 = true;
    L92:
        if (r29 == true) goto L94;
        l8a.d r30 = b(this.F.y, r31, r32, r33, r34, r35, r36, r16, r9);
        TraceEvent.beginSection("LynxImageManager.doAsyncFrescoImageRequest");
        if (this.z == false) goto L100;
        this.E = new GenericDraweeHierarchyBuilder(this.b.getResources()).setRoundingParams(this.D).setFadeDuration(this.V).build();
    L102:
        if (this.z == false) goto L113;
        y<GenericDraweeHierarchy> r37 = this.M;
        if (r37 != null) goto L106;
    L111:
        this.M = new y(this.E);
        goto L113
    L106:
        if (this.C == false) goto L110;
        q r38 = r37.d;
        if ((r38 instanceof q) == false) goto L111;
        this.O.put(r38.o, r37);
        goto L111
    L110:
        this.N = r37;
    L113:
        if (this.k == false) goto L116;
        y<GenericDraweeHierarchy> r39 = this.M;
        r39.b = true;
        r39.a = true;
    L116:
        if (this.z == true) goto L124;
        c r40 = this.q;
        if (r40 == null) goto L124;
        DH r41 = this.M.c;
        if (r41 != 0) goto L122;
        Drawable r42 = null;
    L123:
        r40.onDrawableReady(r42);
        goto L124
    L122:
        r42 = r41.getTopLevelDrawable();
    L124:
        LynxThreadPool.d().execute(new g0(this, r30, r10, this.F.v));
        TraceEvent.endSection("LynxImageManager.doAsyncFrescoImageRequest");
        this.i = false;
        h r43 = this.F;
        r43.b = r31;
        r43.c = r32;
        if (TraceEvent.isTracingStarted() == false) goto L131;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFrescoAsync");
        return;
    L131:
        return;
    L100:
        this.E.reset();
        goto L102
    L94:
        if (TraceEvent.isTracingStarted() == false) goto L130;
        TraceEvent.endSection("LynxImageManager.tryFetchImageFromFrescoAsync");
        return;
    L130:
        return;
    L75:
        if (this.B == false) goto L78;
        if (r13 == null) goto L78;
        r13.setColorFilter(r22);
        goto L78
    L65:
        if (r20.d != 0) goto L69;
        if (r20.e != 0) goto L69;
        r21 = true;
        goto L70
    L58:
        if (this.K == false) goto L60;
        this.F.n(this.f, this.g, r18, r19, this.H, System.currentTimeMillis(), true, 5);
        goto L62
    L60:
        this.s.onImageLoadSuccess(r18, r19);
    L53:
        r18 = r12.getWidth();
        r19 = r12.getHeight();
        goto L55
    L61:
        r19 = 0;
        r18 = 0;
    L90:
        CloseableReference.closeSafely(r11);
    L91:
        r29 = false;
        goto L92
    L26:
        r8 = r5.getBitmapCacheKey(r10, r4);
    L27:
        r8 = null;
        goto L28
    L16:
        if (r3.d((r31 + r33) + r35, (r32 + r34) + r36) == false) goto L18;
        this.W = true;
    L18:
        r16 = this.j.a();
        goto L20
    }

    public final void m(int r4, int r5, int r6, int r7, float[] r8, ScalingUtils.ScaleType r9) {
        h r0 = this.F;
        if (r0.f == false) goto L7;
        this.B = false;
        return;
    L7:
        if (this.b0 == false) goto L11;
        this.B = false;
        return;
    L11:
        if (r0.Y == false) goto L15;
        this.B = false;
        return;
    L15:
        if (this.B == false) goto L18;
        return;
    L18:
        if (r4 != 0) goto L40;
        if (r5 != 0) goto L40;
        if (r6 != 0) goto L40;
        if (r7 != 0) goto L40;
        if (r0.g == null) goto L28;
        this.B = true;
        return;
    L28:
        if (r0.s == null) goto L31;
        this.B = true;
        return;
    L31:
        if (r8 != null) goto L33;
        return;
    L33:
        if (r9 != ScalingUtils.ScaleType.CENTER_CROP) goto L35;
        return;
    L35:
        if (r9 != ScalingUtils.ScaleType.FOCUS_CROP) goto L37;
        return;
    L37:
        if (r9 == ScalingUtils.ScaleType.FIT_XY) goto L45;
        this.B = true;
        return;
    L45:
        return;
    L40:
        this.B = true;
    }

    public final l8a.d b(m8a.g r12, int r13, int r14, int r15, int r16, int r17, int r18, float[] r19, ScalingUtils.ScaleType r20) {
        return this.F.d(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }
}
