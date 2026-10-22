package com.lynx.tasm.ui.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.DefaultDrawableFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.service.ILynxImageService;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final Handler f11111j0 = null;
    public boolean A;
    public final boolean B;
    public RoundingParams C;
    public GenericDraweeHierarchy D;
    public final a0 E;
    public FlattenUIImage F;
    public long G;
    public boolean H;
    public PorterDuffColorFilter I;
    public boolean J;
    public q0 K;
    public q0 L;
    public final LinkedHashMap M;
    public CloseableReference N;
    public o0 O;
    public DefaultDrawableFactory P;
    public BitmapMemoryCacheKey Q;
    public InstrumentedMemoryCache R;
    public boolean S;
    public int T;
    public boolean U;
    public boolean V;
    public Animatable W;
    public CloseableReference X;
    public CloseableReference Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f11112a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Bitmap f11113a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f11114b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f11115b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PipelineDraweeControllerBuilder f11116c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f11117c0;
    public BaseControllerListener d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f11118d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f11119e0;
    public int f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public u0 f11120f0;
    public ScalingUtils.AbstractScaleType g;
    public int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11121h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public View f11122h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.utils.d f11123i;
    public WeakReference i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DraweeHolder f11125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DraweeHolder f11126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f11127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b1 f11128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b1 f11129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final t0 f11130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public no.d f11131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b0 f11132r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f11133t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11134u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11135v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f11136w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CloseableReference f11137x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f11138y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f11139z;

    static {
        f11111j0 = new Handler(Looper.getMainLooper());
    }

    public v0(Context r5, PipelineDraweeControllerBuilder r10, t0 r11, boolean r12) {
        boolean r13 = false;
        this.e = 0;
        this.f = 0;
        this.f11123i = null;
        this.f11124j = false;
        this.f11127m = new LinkedHashMap();
        this.f11136w = false;
        this.f11137x = null;
        this.f11138y = false;
        this.f11139z = false;
        this.A = false;
        this.F = null;
        this.H = true;
        this.I = null;
        this.M = new LinkedHashMap();
        this.S = false;
        this.T = 0;
        this.g0 = -1;
        this.f11114b = r5;
        this.g = (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7893a;
        this.f11116c = r10;
        this.f11130p = r11;
        LynxContext r14 = kk.a.i(r5);
        this.f11112a = r14;
        if (r14 == null) goto L17;
        com.lynx.tasm.u0 r15 = r14.K;
        if (r15 == null) goto L7;
        boolean r16 = r15.f;
    L8:
        this.f11139z = r16;
        if (r15 == null) goto L11;
        boolean r17 = r15.f10970h;
    L12:
        if (r17 == false) goto L14;
    L15:
        r13 = true;
    L16:
        this.S = r13;
        goto L17
    L14:
        if (LynxEnv.inst().enableImageAsyncRequest() == false) goto L16;
    L11:
        r17 = false;
        goto L12
    L7:
        r16 = true;
    L17:
        this.A = !LynxEnv.inst().disableImagePostProcessor();
        this.B = LynxEnv.inst().enableFlattenImageFlickerFix();
        this.f11117c0 = LynxEnv.inst().enableImageRequestOptimize();
        a0 r18 = new a0(r5, new jg.k(this, 6));
        this.E = r18;
        boolean r19 = this.S;
        r18.F = r19;
        if (r19 == false) goto L20;
        f();
    L20:
        this.f11136w = r12;
        r18.C = r12;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void e(v0 r17, Throwable r18) {
        a0 r5 = r17.E;
        String r10 = r5.f11017u;
        if (r10 != null) goto L5;
    L12:
        StringBuilder r11 = new StringBuilder("onFailed src:");
        a0 r12 = r17.E;
        r11.append(r12.f11017u);
        r11.append("with reason");
        r11.append(r18.getMessage());
        LynxLog.b(4, "FrescoImageView", r11.toString());
        int r13 = mh.e.b(r18);
        int r14 = mh.e.a(r13);
        r17.g0 = -1;
        if (r17.f11132r == null) goto L25;
        String r15 = r18.getMessage();
        int r16 = 0;
        if (TextUtils.isEmpty(r15) == false) goto L21;
        r15 = Log.getStackTraceString(r18);
        if (r15 == null) goto L21;
        if (r15.length() <= 200) goto L21;
        r15 = r15.substring(0, 200);
    L21:
        LynxError r19 = new LynxError(r14, "Android LynxImageManager loading image failed", "", "error");
        r19.g = null;
        r19.f10000o = r15;
        FlattenUIImage r20 = r17.F;
        if (r20 == null) goto L24;
        r16 = r20.getNodeIndex();
    L24:
        r19.b("node_index", Integer.toString(r16));
        r17.f11132r.b(r19, r14, r13);
    L25:
        long r110 = System.currentTimeMillis();
        r12.p(r12.f11017u, false, r17.G, r110, 0, null);
        String r111 = r12.f11017u;
        long r21 = r17.G;
        LynxContext r112 = kk.a.i(r12.A);
        if (r12.G == false) goto L28;
        td.c.b(0, r13, r21, r110, r112, r111, false, false);
    L28:
        r12.m(r12.f11017u, r13, false, r17.g0, r17.G, r110, true, 0, 0);
        return;
    L5:
        if (r10.equals(r10) == false) goto L12;
        if (r10.startsWith("http") == false) goto L12;
        int r22 = r5.f11018v;
        r5.f11018v = r22 - 1;
        if (r22 <= 0) goto L12;
        r5.r(r10);
        y r23 = r5.f11022z;
        r23.c();
        r23.e();
    }

    public final void a() {
        DraweeHolder r5 = this.f11125k;
        if (r5 == null) goto L5;
        r5.g();
    L5:
        b1 r10 = this.f11128n;
        if (r10 == null) goto L9;
        r10.g();
        return;
    }

    public final void b(int r5, int r10, int r11, int r12, int r13, int r14) {
        if (this.e == r5) goto L5;
    L6:
        this.e = r5;
        this.f = r10;
        this.f11121h = true;
    L7:
        this.s = r11;
        this.f11133t = r13;
        this.f11134u = r12;
        this.f11135v = r14;
        if (this.f11121h == false) goto L67;
        if (r5 <= 0) goto L13;
        if (r10 <= 0) goto L13;
    L15:
        a0 r15 = this.E;
        if (r15.f11019w != null) goto L21;
        if (r15.f11020x != null) goto L21;
        return;
    L21:
        if (this.f11117c0 == true) goto L23;
    L32:
        TraceEvent.c("LynxImageManager.maybeUpdateView");
        a0 r16 = this.E;
        if (r16.s == true) goto L35;
    L41:
        this.g0 = -1;
        if (this.E.s == false) goto L60;
        CloseableReference r17 = this.f11137x;
        if (r17 == null) goto L56;
        monitor-enter(r17);
        boolean r18 = r17.f7670a;     // Catch: Throwable -> L52
        monitor-exit(r17);
        if (r18 == true) goto L56;
        if (this.f11137x.c() == null) goto L56;
    L57:
        TraceEvent.a(0, "LynxImageManager.maybeUpdateView");
        return;
    L52:
        th = move-exception;
        throw th;
    L56:
        if (this.E.f11016t == true) goto L57;
    L60:
        if (this.S == false) goto L62;
        h(r5, r10, r11, r12, r13, r14);
    L63:
        TraceEvent.a(0, "LynxImageManager.maybeUpdateView");
        return;
    L62:
        g(r5, r10, r11, r12, r13, r14);
        goto L63
    L35:
        if (r16.I == true) goto L37;
        r16.f(r5, r10);
        goto L41
    L37:
        if (r16.s(r5, r10) == false) goto L41;
        TraceEvent.a(0, "LynxImageManager.maybeUpdateView");
        return;
    L23:
        if (Math.abs(r5 - this.f11118d0) > 1) goto L32;
        if (Math.abs(r10 - this.f11119e0) > 1) goto L32;
        StringBuilder r19 = new StringBuilder("maybeUpdateView with 1px change source:current:prev size is ");
        oo.k r20 = this.E.f11019w;
        if (r20 == null) goto L29;
        String r21 = r20.a().toString();
    L30:
        r19.append(r21);
        r19.append(":");
        r19.append(r5);
        r19.append(":");
        r19.append(r10);
        r19.append(":");
        r19.append(this.f11118d0);
        r19.append(":");
        r19.append(this.f11119e0);
        Log.i("LynxImageManager", r19.toString());
        return;
    L29:
        r21 = null;
    L13:
        if (this.E.f11009l == true) goto L15;
        return;
    L67:
        return;
    L5:
        if (this.f == r10) goto L7;
        goto L6
    }

    public final void c(int r5, int r10, int r11, int r12, float[] r13, ScalingUtils.AbstractScaleType r14) {
        a0 r15 = this.E;
        if (r15.f == false) goto L7;
        this.A = false;
        return;
    L7:
        if (this.Z == false) goto L11;
        this.A = false;
        return;
    L11:
        if (r15.U == false) goto L15;
        this.A = false;
        return;
    L15:
        if (this.A == false) goto L18;
        return;
    L18:
        if (r5 != 0) goto L40;
        if (r10 != 0) goto L40;
        if (r11 != 0) goto L40;
        if (r12 != 0) goto L40;
        if (r15.g == null) goto L28;
        this.A = true;
        return;
    L28:
        if (r15.f11015r == null) goto L31;
        this.A = true;
        return;
    L31:
        if (r13 != null) goto L33;
        return;
    L33:
        if (r14 != ScalingUtils.ScaleType.g) goto L35;
        return;
    L35:
        if (r14 != ScalingUtils.ScaleType.f7896h) goto L37;
        return;
    L37:
        if (r14 == ScalingUtils.ScaleType.f7893a) goto L45;
        this.A = true;
        return;
    L45:
        return;
    L40:
        this.A = true;
    }

    public final void d(Callback r5) {
        if (i() == true) goto L5;
        return;
    L5:
        if (this.S == false) goto L7;
        Animatable r10 = this.W;
    L9:
        if ((r10 instanceof AnimatedDrawable2) == true) goto L11;
        return;
    L11:
        if (oo.g.d((AnimatedDrawable2) r10) == false) goto L14;
        r5.invoke(new Object[]{0, "Animation paused."});
        return;
    L14:
        r5.invoke(new Object[]{4, "Not support pause yet"});
        return;
    L7:
        r10 = ((AbstractDraweeController) this.f11125k.e).a();
        goto L9
    }

    public final void f() {
        this.R = Fresco.a().e().e;
        Context r5 = this.f11114b;
        Resources r10 = r5.getResources();
        Fresco.a().a();
        this.P = new DefaultDrawableFactory(r10);
        this.O = new o0(this.P);
        GenericDraweeHierarchyBuilder r11 = new GenericDraweeHierarchyBuilder(r5.getResources());
        r11.f7922l = e0.b(this.g);
        GenericDraweeHierarchyBuilder.s = 0;
        GenericDraweeHierarchy r12 = r11.a();
        this.D = r12;
        this.K = new q0(r12);
        LynxContext r13 = this.f11112a;
        if (r13 == null) goto L5;
        LynxFeatureCounter.a(75, r13.A);
    L5:
        this.d = new r0(this, 0);
        this.f11120f0 = new u0(this);
        a0 r14 = this.E;
        r14.f11000e0 = this.D;
    }

    public final void g(int r23, int r24, int r25, int r26, int r27, int r28) {
        TraceEvent.c("LynxImageManager.tryFetchImageFromFresco");
        ScalingUtils.AbstractScaleType r13 = this.g;
        com.lynx.tasm.behavior.ui.utils.d r5 = this.f11123i;
        if (r5 == null) goto L5;
        r5.a(r23, r24);
        float[] r15 = this.f11123i.c();
    L6:
        c(r25, r26, r27, r28, r15, r13);
        if (this.D != null) goto L9;
    L12:
        GenericDraweeHierarchyBuilder r10 = new GenericDraweeHierarchyBuilder(this.f11114b.getResources());
        r10.f7926p = null;
        this.D = r10.a();
    L13:
        a0 r11 = this.E;
        r11.f11000e0 = this.D;
        no.d r12 = r11.b(r11.f11019w, r23, r24, r25, r26, r27, r28, r15, r13);
        if (this.E.U == false) goto L20;
        ILynxImageService r14 = (ILynxImageService) ko.r.g().e(ILynxImageService.class);
        if (r14 == null) goto L20;
        View r16 = this.f11122h0;
        if (r16 == null) goto L20;
        r14.setImageSRSize(r12, r16);
    L20:
        this.f11131q = r12;
        this.G = System.currentTimeMillis();
        if (this.A == false) goto L69;
        ColorDrawable r17 = b1.f11027k;
        if (r12 == null) goto L37;
        CloseableReference r18 = Fresco.a().e().e.a(Fresco.a().e().f.b(r12, null));
        if (r18 == null) goto L37;
        monitor-enter(r18);
        Object r19 = r18.f7671b.d();     // Catch: Throwable -> L34
        monitor-exit(r18);     // Catch: Throwable -> L34
        if (r19 == null) goto L37;
        if ((r18.c() instanceof CloseableStaticBitmap) == false) goto L37;
    L38:
        if (r18 != null) goto L40;
    L68:
        this.C = null;
    L73:
        a0 r20 = this.E;
        s0 r21 = new s0(this, r20.b(r20.f11020x, r23, r24, r25, r26, r27, r28, r15, r13), r12);
        if (this.f11139z == true) goto L76;
    L78:
        d0 r22 = d0.a();
        r22.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L88;
        Handler r29 = r22.f11038c;
        if (r29 == null) goto L84;
        r29.post(r21);
        goto L88
    L84:
        if (r22.f11036a != null) goto L86;
        r22.f11036a = new LinkedList();
    L86:
        r22.f11036a.add(r21);
    L88:
        this.f11121h = false;
        a0 r30 = this.E;
        r30.f10995b = r23;
        r30.f10997c = r24;
        this.f11118d0 = r23;
        this.f11119e0 = r24;
        TraceEvent.a(0, "LynxImageManager.tryFetchImageFromFresco");
        return;
    L76:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L78;
        r21.run();
        goto L88
    L40:
        if (r18.c() == null) goto L68;
        a();
        b1 r31 = new b1(r18);
        this.f11128n = r31;
        PorterDuffColorFilter r32 = this.I;
        if (r32 == null) goto L47;
        BitmapDrawable r33 = r31.f11028h;
        if (r33 == null) goto L47;
        r33.setColorFilter(r32);
    L47:
        if (this.f11132r == null) goto L58;
        oo.k r34 = this.E.f11019w;
        if (r34 == null) goto L53;
        ConcurrentHashMap r35 = a0.f10992m0;
        if (r35.containsKey(r34.a().toString()) == false) goto L53;
        m r36 = (m) r35.get(this.E.f11019w.a().toString());
        int r37 = r36.f11081a;
        int r38 = r36.f11082b;
    L55:
        if (this.J == false) goto L57;
        this.E.g(this.e, this.f, r37, r38, this.G, System.currentTimeMillis(), true);
    L59:
        a0 r39 = this.E;
        if (r39.f11009l == true) goto L62;
    L66:
        this.f11130p.onDrawableReady(this.f11128n.f11030j);
        a0 r110 = this.E;
        r110.m(r110.f11017u, 0, true, 5, this.G, System.currentTimeMillis(), true, r37, r38);
        this.f11121h = false;
        TraceEvent.a(0, "LynxImageManager.tryFetchImageFromFresco");
        return;
    L62:
        if (r39.d != 0) goto L66;
        if (r39.e != 0) goto L66;
        r39.e = r38;
        r39.d = r37;
        r39.d();
        goto L66
    L57:
        this.f11132r.d(r37, r38);
    L53:
        CloseableImage r40 = (CloseableImage) r18.c();
        r37 = r40.getWidth();
        r38 = r40.getHeight();
        goto L55
    L58:
        r38 = 0;
        r37 = 0;
    L34:
        th = move-exception;
        throw th;
    L37:
        r18 = null;
        goto L38
    L69:
        if (r15 == null) goto L73;
        if (r15.length != 8) goto L73;
        this.C = RoundingParams.a(r15);
        goto L73
    L9:
        if (this.f11138y == true) goto L12;
        this.D.b();
        goto L13
    L5:
        r15 = null;
        goto L6
    }

    public final void h(int r30, int r31, int r32, int r33, int r34, int r35) {
        TraceEvent.c("LynxImageManager.tryFetchImageFromFrescoAsync");
        ScalingUtils.AbstractScaleType r13 = this.g;
        com.lynx.tasm.behavior.ui.utils.d r5 = this.f11123i;
        RootDrawable r15 = null;
        if (r5 != null) goto L5;
        float[] r16 = null;
    L9:
        this.A = false;
        c(r32, r33, r34, r35, r16, r13);
        a0 r10 = this.E;
        no.d r11 = r10.b(r10.f11019w, r30, r31, r32, r33, r34, r35, r16, r13);
        this.f11131q = r11;
        DefaultCacheKeyFactory r12 = Fresco.a().e().f;
        if (r12 == null) goto L16;
        if (r11 == null) goto L16;
        if (r11.f8422m == null) goto L15;
        BitmapMemoryCacheKey r14 = r12.b(r11, null);
    L17:
        this.Q = r14;
        this.G = System.currentTimeMillis();
        BitmapMemoryCacheKey r17 = this.Q;
        if (r17 == null) goto L82;
        InstrumentedMemoryCache r18 = this.R;
        if (r18 == null) goto L82;
        CloseableReference r19 = r18.a(r17);
        if (r19 == null) goto L82;
        monitor-enter(r19);
        Object r20 = r19.f7671b.d();     // Catch: Throwable -> L79
        monitor-exit(r19);     // Catch: Throwable -> L79
        if (r20 == null) goto L82;
        if (((ImmutableQualityInfo) ((CloseableImage) r19.c()).c()).f8193c == true) goto L31;
        r19.close();
        goto L82
    L31:
        CloseableImage r21 = (CloseableImage) r19.c();
        if ((r21 instanceof CloseableBitmap) == false) goto L113;
        this.f11113a0 = ((CloseableStaticBitmap) ((CloseableBitmap) r21)).g;
    L113:
        Drawable r22 = this.P.a(r21);     // Catch: Exception -> L38
        if (this.A == true) goto L40;
        this.D.a(r22, 1.0f, true);     // Catch: Exception -> L38
    L40:
        if (this.f11132r == null) goto L52;
        oo.k r23 = this.E.f11019w;
        if (r23 == null) goto L47;
        ConcurrentHashMap r24 = a0.f10992m0;
        if (r24.containsKey(r23.a().toString()) == false) goto L47;
        m r25 = (m) r24.get(this.E.f11019w.a().toString());
        int r26 = r25.f11081a;
        int r27 = r25.f11082b;
    L46:
        int r110 = r26;
        if (this.J == false) goto L51;
        this.E.g(this.e, this.f, r110, r27, this.G, System.currentTimeMillis(), true);
    L53:
        a0 r28 = this.E;
        if (r28.f11009l == true) goto L56;
    L60:
        l();
        PorterDuffColorFilter r29 = this.I;
        if (r29 != null) goto L63;
    L66:
        t0 r36 = this.f11130p;
        if (this.A == true) goto L73;
        DraweeHierarchy r37 = this.K.f11098c;
        if (r37 != null) goto L72;
        r22 = null;
        goto L73
    L72:
        r22 = ((GenericDraweeHierarchy) r37).e;
    L73:
        r36.onDrawableReady(r22);
        CloseableReference r38 = this.N;
        if (r38 == null) goto L76;
        r38.close();
        this.N = null;
    L76:
        this.N = r19;
        this.f11121h = false;
        this.f11115b0 = true;
        a0 r39 = this.E;
        r39.m(r39.f11017u, 0, true, 5, this.G, System.currentTimeMillis(), true, r110, r27);
        TraceEvent.a(0, "LynxImageManager.tryFetchImageFromFrescoAsync");
        return;
    L63:
        if (this.A == false) goto L66;
        if (r22 == null) goto L66;
        r22.setColorFilter(r29);
        goto L66
    L56:
        if (r28.d != 0) goto L60;
        if (r28.e != 0) goto L60;
        r28.e = r27;
        r28.d = r110;
        r28.d();
        goto L60
    L51:
        this.f11132r.d(r110, r27);
    L47:
        r26 = r21.getWidth();
        r27 = r21.getHeight();
        goto L46
    L52:
        r27 = 0;
        r110 = 0;
    L78:
        r19.close();
    L79:
        th = move-exception;
        throw th;
    L82:
        a0 r40 = this.E;
        no.d r41 = r40.b(r40.f11020x, r30, r31, r32, r33, r34, r35, r16, r13);
        TraceEvent.c("LynxImageManager.doAsyncFrescoImageRequest");
        if (this.f11138y == false) goto L85;
        GenericDraweeHierarchyBuilder r42 = new GenericDraweeHierarchyBuilder(null);
        r42.f7926p = this.C;
        GenericDraweeHierarchyBuilder.s = this.T;
        this.D = r42.a();
    L87:
        if (this.f11138y == false) goto L98;
        q0 r43 = this.K;
        if (r43 != null) goto L91;
    L96:
        this.K = new q0(this.D);
        goto L98
    L91:
        if (this.B == false) goto L95;
        n0 r44 = r43.d;
        if (r44 == null) goto L96;
        this.M.put(r44.f11064o, r43);
        goto L96
    L95:
        this.L = r43;
    L98:
        if (this.f11124j == false) goto L101;
        q0 r45 = this.K;
        r45.f11097b = true;
        r45.f11096a = true;
    L101:
        if (this.f11138y == true) goto L109;
        t0 r46 = this.f11130p;
        if (r46 == null) goto L109;
        DraweeHierarchy r47 = this.K.f11098c;
        if (r47 == null) goto L108;
        r15 = ((GenericDraweeHierarchy) r47).e;
    L108:
        r46.onDrawableReady(r15);
    L109:
        mn.h.j().execute(new com.bytedance.apm.e(this, r41, r11, this.E.f11017u, 9));
        TraceEvent.a(0, "LynxImageManager.doAsyncFrescoImageRequest");
        this.f11121h = false;
        a0 r48 = this.E;
        r48.f10995b = r30;
        r48.f10997c = r31;
        this.f11118d0 = r30;
        this.f11119e0 = r31;
        TraceEvent.a(0, "LynxImageManager.tryFetchImageFromFrescoAsync");
        return;
    L85:
        this.D.b();
        goto L87
    L15:
        r14 = r12.a(r11, null);
    L16:
        r14 = null;
        goto L17
    L5:
        if (r5.a((r30 + r32) + r34, (r31 + r33) + r35) == false) goto L7;
        this.U = true;
    L7:
        r16 = this.f11123i.c();
        goto L9
    }

    public final boolean i() {
        if (this.S == true) goto L5;
        DraweeHolder r5 = this.f11125k;
        if (r5 == null) goto L15;
        DraweeController r10 = r5.e;
        if (r10 == null) goto L15;
        if (((AbstractDraweeController) r10).a() == null) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (this.W == null) goto L7;
        return true;
    L7:
        return false;
    }

    public final void j() {
        this.f11124j = true;
        if (this.S == false) goto L7;
        this.G = System.currentTimeMillis();
        q0 r5 = this.K;
        r5.f11097b = true;
        r5.f11096a = true;
        return;
    L7:
        if (this.f11125k == null) goto L10;
        this.G = System.currentTimeMillis();
        this.f11125k.f();
        return;
    }

    public final void k() {
        this.f11124j = false;
        if (this.S == false) goto L16;
        CloseableReference r5 = this.N;
        if (r5 == null) goto L7;
        r5.close();
        this.N = null;
    L7:
        q0 r10 = this.K;
        if (r10 == null) goto L10;
        r10.f11097b = false;
        r10.a();
    L10:
        this.f11113a0 = null;
        CloseableReference r11 = this.X;
        if (r11 == null) goto L13;
        r11.close();
        this.X = null;
    L13:
        GenericDraweeHierarchy r12 = this.D;
        if (r12 == null) goto L17;
        r12.b();
    L17:
        a0 r13 = this.E;
        r13.d = 0;
        r13.e = 0;
        CloseableReference r14 = this.f11137x;
        if (r14 == null) goto L21;
        r14.close();
        this.f11137x = null;
        return;
    L21:
        return;
    L16:
        a();
        goto L17
    }

    public final void l() {
        if (this.A == false) goto L7;
        this.V = false;
        this.U = false;
        return;
    L7:
        if (this.V == false) goto L14;
        GenericDraweeHierarchy r5 = this.D;
        ScalingUtils.ScaleType r10 = e0.b(this.g);
        r5.getClass();
        r10.getClass();
        ScaleTypeDrawable r11 = r5.b(2);
        if (Objects.a(r11.d, r10) == true) goto L12;
        r11.d = r10;
        r11.e();
        r11.invalidateSelf();
    L12:
        this.V = false;
    L14:
        if (this.U == false) goto L23;
        com.lynx.tasm.behavior.ui.utils.d r12 = this.f11123i;
        if (r12 != null) goto L18;
        return;
    L18:
        if (r12.c() == null) goto L20;
        this.C = RoundingParams.a(this.f11123i.c());
    L21:
        this.D.a(this.C);
        this.U = false;
        return;
    L20:
        this.C = null;
        goto L21
    }
}
