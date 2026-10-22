package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.lynx.base.log.LynxLog;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.core.LynxLayoutProxy;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxImageService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    public static final Bitmap.Config l0 = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final ConcurrentHashMap f10992m0 = null;
    public final Context A;
    public ReadableMap B;
    public boolean C;
    public LynxBaseUI D;
    public final HashMap E;
    public boolean F;
    public final boolean G;
    public final boolean H;
    public final boolean I;
    public final boolean J;
    public final com.bytedance.ies.bullet.base.utils.b K;
    public int L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public float V;
    public boolean W;
    public boolean X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f10993a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f10994a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10995b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f10996b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10997c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f10998c0;
    public int d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f10999d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public GenericDraweeHierarchy f11000e0;
    public boolean f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f11001f0;
    public String g;
    public final boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11002h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final AnimationListener f11003h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11004i;
    public OptionalBool i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11005j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public OptionalBool f11006j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11007k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final ILynxImageService f11008k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ShadowNode f11010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Bitmap.Config f11012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f11013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageResizeMethod f11014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public no.c f11015r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11016t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f11017u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public oo.k f11019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public oo.k f11020x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public r f11021y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final y f11022z;

    static {
        l0 = Bitmap.Config.ARGB_8888;
        f10992m0 = new ConcurrentHashMap();
    }

    public a0(Context r5, y r10) {
        boolean r11 = false;
        this.f10995b = 0;
        this.f10997c = 0;
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = null;
        this.f11002h = null;
        this.f11004i = null;
        this.f11005j = null;
        this.f11007k = false;
        this.f11009l = false;
        this.f11010m = null;
        this.f11012o = l0;
        this.f11013p = 0;
        this.f11014q = ImageResizeMethod.f10989b;
        this.s = false;
        this.f11016t = false;
        this.f11021y = null;
        this.C = false;
        this.D = null;
        this.E = new HashMap();
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = null;
        this.L = 0;
        this.T = false;
        this.U = false;
        this.V = 0.0f;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = 0;
        this.f10994a0 = 0;
        this.f10996b0 = null;
        this.f10998c0 = null;
        this.f10999d0 = 1;
        this.f11001f0 = false;
        this.g0 = false;
        this.f11003h0 = new t();
        OptionalBool r12 = OptionalBool.f10952c;
        this.i0 = r12;
        this.f11006j0 = r12;
        this.A = r5;
        this.f11022z = r10;
        LynxContext r13 = kk.a.i(r5);
        this.f10993a = r13;
        this.f11001f0 = true;
        this.f11008k0 = (ILynxImageService) ko.r.g().e(ILynxImageService.class);
        if (r13 == null) goto L24;
        this.f = false;
        this.s = false;
        com.lynx.tasm.u0 r14 = r13.K;
        if (r14 == null) goto L7;
        boolean r15 = r14.g;
    L8:
        this.H = r15;
        this.G = LynxEnv.inst().enableImageEventReport();
        com.bytedance.ies.bullet.base.utils.b r16 = r13.E;
        this.K = r16;
        if (r16 == null) goto L11;
        boolean r17 = true;
    L12:
        this.I = r17;
        if (LynxEnv.inst().enableImageAsyncRedirect() == false) goto L17;
        if (r17 == false) goto L16;
    L22:
        r11 = true;
    L23:
        this.T = r11;
        goto L24
    L16:
        if (r13.d != null) goto L22;
    L17:
        com.lynx.tasm.u0 r18 = r13.K;
        if (r18 == null) goto L20;
        boolean r19 = r18.e;
    L21:
        if (r19 == false) goto L23;
    L20:
        r19 = false;
        goto L21
    L11:
        r17 = false;
        goto L12
    L7:
        r15 = true;
    L24:
        this.g0 = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        this.J = LynxEnv.inst().enableImageAsyncLayout();
    }

    public static void k(a0 r5) {
        r5.getClass();
        h r10 = new h(r5, 3);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        r10.run();
        return;
    L6:
        new Handler(Looper.getMainLooper()).post(r10);
    }

    public final String a(LynxContext r10, String r11) {
        if (this.I == true) goto L11;
        if (this.T == false) goto L9;
        return dn.a.J(r10, true, r11);
    L9:
        return dn.a.J(r10, false, r11);
    L11:
        if (TraceController.g == false) goto L13;
        HashMap r12 = new HashMap();
        r12.put("url", r11);
        TraceEvent.b(0, "MediaFetcher.shouldRedirectImageUrl", r12);
    L13:
        int r5 = 8;
        ko.r r13 = new ko.r(r5, r11, LynxResourceRequest$LynxResourceType.f10942a);
        String r14 = this.K.d(r13);
        if (TraceController.g == false) goto L16;
        TraceEvent.a(0, "MediaFetcher.shouldRedirectImageUrl");
    L16:
        return r14;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final no.d b(oo.k r33, int r34, int r35, int r36, int r37, int r38, int r39, float[] r40, ScalingUtils.ScaleType r41) {
        Postprocessor r16 = null;
        if (r33 != null) goto L5;
        return null;
    L5:
        TraceEvent.c("ImageDelegate.createImageRequest");
        Uri r10 = r33.a();
        y r14 = this.f11022z;
        ImageRequestBuilder r13 = r14.j(r10);
        r13.d = RotationOptions.f8054c;
        r13.g = this.f11011n;
        if (this.f == true) goto L33;
        if (this.U == true) goto L33;
        ImageResizeMethod r11 = this.f11014q;
        if (r11 != ImageResizeMethod.f10988a) goto L17;
        if (UriUtil.a(r33.a()) == true) goto L19;
        if ("file".equals(r33.a().getScheme()) == true) goto L19;
    L30:
        ResizeOptions r12 = null;
    L31:
        r13.f8436c = r12;
    L19:
        if (this.f11009l == true) goto L30;
        int r15 = this.f10995b;
        int r17 = this.f10997c;
        if (r15 <= 0) goto L29;
        if (r17 <= 0) goto L29;
        if (Math.abs(r34 - r15) > 1) goto L29;
        if (Math.abs(r35 - r17) > 1) goto L29;
        r12 = new ResizeOptions(r15, r17, 2048.0f);
    L29:
        r12 = new ResizeOptions(r34, r35, 2048.0f);
        goto L31
    L17:
        if (r11 != ImageResizeMethod.f10989b) goto L30;
    L33:
        if (this.F == false) goto L35;
        r13.f8437h = Priority.f8050c;
    L35:
        boolean r18 = r14.d();
        LinkedList r19 = new LinkedList();
        boolean r20 = this.U;
        ILynxImageService r110 = this.f11008k0;
        if (r20 == false) goto L61;
        if (r110 == null) goto L40;
        r19.add((Postprocessor) r110.getImageSRPostProcessor());
    L40:
        if (this.V <= 0.0f) goto L61;
        Class r111 = Integer.TYPE;     // Catch: InvocationTargetException -> L46 IllegalAccessException -> L48 NoSuchMethodException -> L50
        Method r21 = ImageRequestBuilder.class.getMethod("setTargetWidth", new Class[]{r111});     // Catch: InvocationTargetException -> L46 IllegalAccessException -> L48 NoSuchMethodException -> L50
        Method r5 = ImageRequestBuilder.class.getMethod("setTargetHeight", new Class[]{r111});     // Catch: InvocationTargetException -> L52 IllegalAccessException -> L54 NoSuchMethodException -> L56
        float r22 = r34;
        r21.invoke(r13, new Object[]{Integer.valueOf((int) (this.V * r22))});     // Catch: InvocationTargetException -> L52 IllegalAccessException -> L54 NoSuchMethodException -> L56
        float r23 = r35;
        r5.invoke(r13, new Object[]{Integer.valueOf((int) (this.V * r23))});     // Catch: InvocationTargetException -> L52 IllegalAccessException -> L54 NoSuchMethodException -> L56
    L44:
        LynxLog.b(1, "ImageDelegate", "SR setTargetWidth:setTargetHeight" + ((int) (r22 * this.V)) + "::" + ((int) (r23 * this.V)));     // Catch: InvocationTargetException -> L46 IllegalAccessException -> L48 NoSuchMethodException -> L50
    L54:
        e = e;
    L59:
        LynxLog.b(4, "ImageDelegate", "SR invoke setTargetWidth & setTargetHeight failed:" + e);
    L56:
        e = e;
    L60:
        LynxLog.b(4, "ImageDelegate", "SR no such method setTargetWidth & setTargetHeight:" + e);
    L52:
        e = e;
    L58:
        LynxLog.b(4, "ImageDelegate", "SR invoke setTargetWidth & setTargetHeight failed:" + e);
    L48:
        e = e;
    L50:
        e = e;
    L46:
        e = e;
    L61:
        if (r18 == false) goto L67;
        if (r34 <= 0) goto L67;
        if (r35 <= 0) goto L67;
        if (this.C == true) goto L67;
        r19.add(new z(r33.a().toString(), r34, r35, r36, r37, r38, r39, r40, r41, this.g, this.f11002h, this.f11012o, this.f11007k));
        LinkedList r24 = r19;
    L68:
        no.c r25 = this.f11015r;
        if (r25 == null) goto L71;
        r24.add(r25);
    L71:
        r14.d(r24);
        int r26 = r24.size();
        if (r26 != 0) goto L74;
    L77:
        Postprocessor r27 = r16;
    L78:
        if (r27 == null) goto L81;
        oo.k r28 = this.f11019w;
        if (r28 == null) goto L81;
        String r29 = r28.a().toString().toLowerCase();
        if (r29.endsWith(".gif") == true) goto L81;
        if (r29.endsWith(".apng") == true) goto L81;
        ImageRequestBuilder r30 = r13;
        r30.f8438i = r27;
    L88:
        if (TextUtils.isEmpty(this.f11004i) == true) goto L97;
        if (FrescoImagePrefetchHelper.PRIORITY_HIGH.equalsIgnoreCase(this.f11004i) == false) goto L93;
        r30.f8437h = Priority.f8050c;
        goto L97
    L93:
        if (FrescoImagePrefetchHelper.PRIORITY_LOW.equalsIgnoreCase(this.f11004i) == false) goto L95;
        r30.f8437h = Priority.f8048a;
        goto L97
    L95:
        r30.f8437h = Priority.f8049b;
    L97:
        if (TextUtils.isEmpty(this.f11005j) == true) goto L100;
        if (r110 == null) goto L100;
        r110.setImageCacheChoice(this.f11005j, r30);
    L100:
        no.d r31 = new no.d(r30, this.B);
        if (TextUtils.isEmpty(this.f10996b0) == true) goto L108;
        boolean r32 = this.W;
        if (r32 == false) goto L105;
    L106:
        if (r110 == null) goto L108;
        r110.setImagePlaceHolderHash(this.f11000e0, r31, r41, this.f10996b0, this.f10998c0, this.Y, this.Z, this.f10994a0, this.f10999d0, r32);
        goto L108
    L105:
        if (this.X == true) goto L106;
    L108:
        TraceEvent.a(0, "ImageDelegate.createImageRequest");
        return r31;
    L81:
        r30 = r13;
        goto L88
    L74:
        if (r26 == 1) goto L76;
        r27 = new a1(r24);
        goto L78
    L76:
        r16 = (Postprocessor) r24.get(0);
    L67:
        r24 = r19;
        goto L68
    }

    public final JSONObject c(int r5, int r10, int r11, int r12) {
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L5
        r13.put("viewWidth", r5);     // Catch: JSONException -> L5
        r13.put("viewHeight", r10);     // Catch: JSONException -> L5
        r13.put("width", r11);     // Catch: JSONException -> L5
        r13.put("height", r12);     // Catch: JSONException -> L5
        Bitmap.Config r14 = this.f11012o;     // Catch: JSONException -> L5
        if (r14 != null) goto L7;
        r14 = l0;     // Catch: JSONException -> L5
    L7:
        r13.put("config", r14);     // Catch: JSONException -> L5
        return r13;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final void d() {
        LynxBaseUI r5 = this.D;
        if (r5 == null) goto L30;
        int r10 = this.d;
        if (r10 == 0) goto L31;
        int r11 = this.e;
        if (r11 == 0) goto L32;
        boolean r12 = this.f11009l;
        int r13 = r5.getWidth();
        int r14 = this.D.getHeight();
        if (this.J == false) goto L17;
        LynxContext r15 = this.D.getLynxContext();
        int r16 = this.D.getSign();
        s r17 = new s(r10, r11, r13, r14, r12);
        r15.getClass();
        androidx.profileinstaller.a r18 = new androidx.profileinstaller.a(r15, r16, r17, 1);
        LynxLayoutProxy r19 = (LynxLayoutProxy) r15.f10144l.get();
        if (r19 == null) goto L29;
        r19.b(r18);
        return;
    L29:
        return;
    L17:
        if (this.f11010m != null) goto L23;
        LynxContext r20 = this.D.getLynxContext();
        int r21 = this.D.getSign();
        com.lynx.tasm.behavior.w0 r22 = (com.lynx.tasm.behavior.w0) r20.f10151t.get();
        if (r22 == null) goto L21;
        ShadowNode r23 = (ShadowNode) ((SparseArray) r22.g.f10812a).get(r21);
    L22:
        this.f11010m = r23;
        goto L23
    L21:
        r23 = null;
    L23:
        ShadowNode r24 = this.f11010m;
        if ((r24 instanceof AutoSizeImage) == true) goto L27;
        this.S = true;
        return;
    L27:
        ((AutoSizeImage) r24).s(r10, r11, r13, r14, r12);
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void e(int r5) {
        if (r5 != 0) goto L10;
        this.f11015r = null;
    L8:
        this.f11022z.c();
        return;
    L10:
        this.f11015r = new no.c(r5, this.f10993a);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        LynxLog.b(4, "ImageDelegate", "setBlurRadius failed: " + th.getMessage());
        goto L8
    }

    public final void f(int r18, int r19) {
        oo.k r5 = this.f11019w;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f20818b != null) goto L7;
        return;
    L7:
        if (this.s == false) goto L22;
        Context r10 = this.A;
        if (r10 == null) goto L23;
        TraceEvent.c("ImageDelegate.tryFetchImageFromLocalCache");
        long r11 = System.currentTimeMillis();
        String r12 = this.f11019w.f20818b;
        float r13 = r18;
        float r14 = r19;
        w r15 = new w(this, r12, r18, r19, r11);
        LynxContext r16 = kk.a.i(r10);
        if (r16 != null) goto L14;
        LynxLog.b(4, "ImageUrlRedirectUtils", "load image failed due to no context available");
    L18:
        TraceEvent.a(0, "ImageDelegate.tryFetchImageFromLocalCache");
        return;
    L14:
        com.lynx.tasm.behavior.k r17 = r16.f10139c;
        if (r17 == null) goto L17;
        r17.loadImage(r16, null, r12, r13, r14, null, r15);
        goto L18
    L17:
        r15.a(null);
        goto L18
    L23:
        return;
    }

    public final void g(int r20, int r21, int r22, int r23, long r24, long r26, boolean r28) {
        if (this.Q == false) goto L43;
        LynxContext r5 = this.f10993a;
        if (r5 != null) goto L7;
        return;
    L7:
        if (this.D == null) goto L45;
        Bitmap.Config r10 = this.f11012o;
        if (r10 != null) goto L11;
        r10 = Bitmap.Config.ARGB_8888;
    L11:
        int r17 = td.b.a(r22, r23, r10);
        long r13 = r26 - r24;
        if (this.f11019w == null) goto L24;
        String r11 = this.f11017u;
        if (r11 == null) goto L24;
        if (r11.startsWith("data") == false) goto L19;
        String r12 = "base64";
    L25:
        JSONObject r18 = c(r20, r21, r22, r23);
        String r14 = this.f11017u;
        JSONObject r15 = td.c.a(this.f10993a, r14, true, r28, r24, r13, r13, r26, r17, r18);
        if (r15 == null) goto L46;
        com.lynx.animax.i r16 = new com.lynx.animax.i(this.D.getSign(), "load");
        Iterator<String> r19 = r15.keys();
    L29:
        if (r19.hasNext() == false) goto L36;
        String r25 = r19.next();
        Object r27 = r15.get(r25);     // Catch: JSONException -> L33
    L35:
        r16.a(r25, r27);
    L33:
        e = move-exception;
        e.printStackTrace();
        r27 = null;
        goto L35
    L36:
        r16.a("resourceFrom", r12);
        r16.a("width", Integer.valueOf(r22));
        r16.a("height", Integer.valueOf(r23));
        r5.g.b(r16);
        return;
    L46:
        return;
    L19:
        if (this.f11017u.startsWith("http") == true) goto L21;
    L23:
        r12 = "local resource";
        goto L25
    L21:
        if (this.f11019w.f20818b.equals(this.f11017u) == false) goto L23;
        r12 = "cdn";
    L24:
        r12 = "";
        goto L25
    L45:
        return;
    }

    public final void h(int r20, int r21, ImageInfo r22, Animatable r23, long r24, boolean r26, int r27, b0 r28) {
        long r13 = System.currentTimeMillis();
        oo.k r5 = this.f11019w;
        int r10 = 0;
        if (r5 == null) goto L8;
        ConcurrentHashMap r11 = f10992m0;
        if (r11.containsKey(r5.a().toString()) == false) goto L8;
        m r12 = (m) r11.get(this.f11019w.a().toString());
        int r14 = r12.f11081a;
        int r15 = r12.f11082b;
        int r16 = r14;
    L11:
        JSONObject r17 = c(r20, r21, r16, r15);
        if (r17 != null) goto L14;
    L21:
        if (r28 != null) goto L23;
        int r18 = r15;
    L34:
        i(r23);
        Bitmap.Config r19 = this.f11012o;
        if (r19 != null) goto L37;
        r19 = Bitmap.Config.ARGB_8888;
    L37:
        int r25 = td.b.a(r16, r18, r19);
        this.f11013p = r25;
        p(this.f11017u, true, r24, r13, r25, r17);
        String r29 = this.f11017u;
        LynxContext r30 = kk.a.i(this.A);
        if (this.G == false) goto L40;
        td.c.b(r25, 0, r24, r13, r30, r29, true, false);
    L40:
        m(this.f11017u, 0, false, r27, r24, r13, r26, r16, r18);
        return;
    L23:
        if (this.f11009l == false) goto L30;
        if (this.d != 0) goto L30;
        if (this.e != 0) goto L30;
        this.d = r16;
        this.e = r15;
        d();
    L30:
        if (this.M == false) goto L32;
        r18 = r15;
        g(r20, r21, r16, r15, r24, r13, false);
        goto L34
    L32:
        r18 = r15;
        r28.d(r16, r18);
        goto L34
    L14:
        if (r23 == null) goto L42;
        if (r26 == false) goto L42;
        r10 = 1;
    L42:
        r17.put("isFlattenAnim", r10);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L8:
        if (r22 == null) goto L10;
        r16 = r22.getWidth();
        r15 = r22.getHeight();
        goto L11
    L10:
        r21 = r21;
        r15 = 0;
        r16 = 0;
        goto L11
    }

    public final void i(Animatable r5) {
        if ((r5 instanceof AnimatedDrawable2) == false) goto L15;
        AnimatedDrawable2 r10 = (AnimatedDrawable2) r5;
        if (this.P == false) goto L7;
    L12:
        r10.setAnimationListener(this.f11003h0);
    L13:
        r10.setAnimationBackend(new no.b(r10.getAnimationBackend()));
        oo.g.a(r10);
        return;
    L7:
        if (this.N == true) goto L12;
        if (this.O == true) goto L12;
        r10.setAnimationListener(null);
        goto L13
    }

    public final void j(ReadableMap r18) {
        if (r18 == null) goto L17;
        String r5 = r18.getString("type");
        if ("preview".equalsIgnoreCase(r5) == false) goto L8;
        this.W = true;
    L12:
        if (this.W == false) goto L14;
    L15:
        String r10 = r18.getString("width");
        LynxContext r11 = this.f10993a;
        float r12 = r11.f10145m.getFontSize();
        float r13 = this.D.getFontSize();
        float r14 = r11.f10145m.getWidth();
        float r15 = r11.f10145m.getHeight();
        DisplayMetrics r16 = r11.f10152u;
        this.Y = Math.round(com.lynx.tasm.utils.k.c(r10, r12, r13, r14, r15, 0.0f, r16));
        this.Z = Math.round(com.lynx.tasm.utils.k.c(r18.getString("height"), r11.f10145m.getFontSize(), this.D.getFontSize(), r11.f10145m.getWidth(), r11.f10145m.getHeight(), 0.0f, r16));
        this.f10994a0 = Math.round(com.lynx.tasm.utils.k.c(r18.getString("radius"), r11.f10145m.getFontSize(), this.D.getFontSize(), r11.f10145m.getWidth(), r11.f10145m.getHeight(), 0.0f, r16));
        this.f10996b0 = r18.getString("hash");
        this.f10998c0 = r18.getString("metaData");
        this.f10999d0 = r18.getInt("iterations", 1);
        return;
    L14:
        if (this.X == true) goto L15;
        return;
    L8:
        if ("blur".equalsIgnoreCase(r5) == false) goto L10;
        this.X = true;
        goto L12
    L10:
        this.W = false;
        this.X = false;
        goto L12
    }

    public final void l(String r5) {
        oo.k r10 = this.f11020x;
        if (r10 != null) goto L5;
    L7:
        this.f11020x = null;
        if (r5 != null) goto L10;
    L14:
        this.f11022z.c();
        return;
    L10:
        if (r5.isEmpty() == true) goto L14;
        oo.k r11 = new oo.k(this.A, r5);
        this.f11020x = r11;
        if (Uri.EMPTY.equals(r11.a()) == false) goto L14;
        LynxLog.b(3, LynxMonitorService.DEFAULT_PID, "Warning: Image source \"" + r5 + "\" doesn't exist");
        goto L14
    L5:
        if (r10.f20818b.equals(r5) == false) goto L7;
    }

    public final void m(String r5, int r10, boolean r11, int r12, long r13, long r14, boolean r15, int r16, int r17) {
        if (this.G == true) goto L5;
        return;
    L5:
        if (r5.startsWith("http") == false) goto L21;
        LynxContext r18 = kk.a.i(this.A);
        HashMap r19 = this.E;
        if (r18 == null) goto L22;
        HashMap r20 = new HashMap();     // Catch: Exception -> L12
        r20.put("load_start", Long.valueOf(r13));     // Catch: Exception -> L12
        r20.put("load_finish", Long.valueOf(r14));     // Catch: Exception -> L12
        r20.put("cost", Long.valueOf(r14 - r13));     // Catch: Exception -> L12
        r20.put("src", r5);     // Catch: Exception -> L12
        r20.put(LynxMonitorService.KEY_MEMORY, Boolean.valueOf(r11));     // Catch: Exception -> L12
        r20.put("origin", Integer.valueOf(r12));     // Catch: Exception -> L12
        r20.put(WsConstants.ERROR_CODE, Integer.valueOf(r10));     // Catch: Exception -> L12
        r20.put("flatten", Boolean.valueOf(r15));     // Catch: Exception -> L12
        r20.put("width", Integer.valueOf(r16));     // Catch: Exception -> L12
        r20.put("height", Integer.valueOf(r17));     // Catch: Exception -> L12
        if (r19 == null) goto L14;
        r20.putAll(r19);     // Catch: Exception -> L12
    L14:
        LynxEventReporter.onEvent("lynxsdk_image_event", r20, r18.A);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        LynxLog.b(4, "FrescoEventHelper", "reportImageEvent got exception:" + e);
        return;
    L22:
        return;
    }

    public final void n(String r13, String r14) {
        boolean r5 = this.H;
        boolean r10 = false;
        if (r13 == null) goto L9;
        this.f11017u = r13;
        if (r5 == false) goto L15;
        OptionalBool r11 = this.i0;
        if (r11 != OptionalBool.f10951b) goto L11;
        r(r13);
        goto L9
    L11:
        if (r11 != OptionalBool.f10950a) goto L13;
    L14:
        this.f11018v = 1;
        goto L15
    L13:
        if (r11 == OptionalBool.f10952c) goto L14;
    L15:
        boolean r12 = true;
    L16:
        if (r14 == null) goto L21;
        if (r5 == true) goto L19;
    L22:
        boolean r15 = true;
    L23:
        if (r12 == true) goto L26;
        if (r15 == true) goto L26;
        return;
    L26:
        LynxContext r16 = kk.a.i(this.A);
        if (this.f11001f0 == false) goto L33;
        this.f11001f0 = false;
        if (this.g0 == false) goto L33;
        if (com.lynx.tasm.utils.j.j() == true) goto L33;
    L34:
        if (r10 == false) goto L40;
        LynxContext r17 = this.f10993a;
        if (r17 == null) goto L38;
        LynxFeatureCounter.a(74, r17.A);
    L38:
        mn.h.i().execute(new u(this, r13, r14, r12, r16, r15));
        return;
    L40:
        if (r12 == false) goto L42;
        r(a(r16, r13));
    L42:
        if (r15 == false) goto L45;
        l(a(r16, r14));
        return;
    L45:
        return;
    L33:
        r10 = this.T;
        goto L34
    L19:
        if (this.f11006j0 != OptionalBool.f10951b) goto L22;
        l(r14);
    L21:
        r15 = false;
    L9:
        r12 = false;
        goto L16
    }

    public final void o(String r5, String r10, boolean r11, boolean r12) {
        if (this.H == false) goto L51;
        if (r11 == true) goto L10;
        if (r12 == true) goto L10;
        return;
    L10:
        if (this.I == true) goto L36;
        ko.e r13 = (ko.e) ko.r.g().e(ko.e.class);
        if (r13 != null) goto L16;
        LynxLog.b(4, "ImageDelegate", "Unable to update redirect because ILynxResourceService cannot be obtained.");
        return;
    L16:
        if (r11 == false) goto L26;
        int r14 = r13.isLocalResource(r5);
        if (r14 != (-1)) goto L20;
        OptionalBool r15 = OptionalBool.f10952c;
    L25:
        this.i0 = r15;
        goto L26
    L20:
        if (r14 != 1) goto L22;
        r15 = OptionalBool.f10950a;
        goto L25
    L22:
        if (r14 != 0) goto L24;
        r15 = OptionalBool.f10951b;
        goto L25
    L24:
        r15 = OptionalBool.f10952c;
    L26:
        if (r12 == false) goto L52;
        int r16 = r13.isLocalResource(r10);
        if (r16 != (-1)) goto L30;
        OptionalBool r17 = OptionalBool.f10952c;
    L35:
        this.f11006j0 = r17;
        return;
    L30:
        if (r16 != 1) goto L32;
        r17 = OptionalBool.f10950a;
        goto L35
    L32:
        if (r16 != 0) goto L34;
        r17 = OptionalBool.f10951b;
        goto L35
    L34:
        r17 = OptionalBool.f10952c;
        goto L35
    L52:
        return;
    L36:
        TraceEvent.c("ImageDelegate.isLocalResource");
        com.bytedance.ies.bullet.base.utils.b r18 = this.K;
        ILynxImageService r19 = this.f11008k0;
        if (r11 == false) goto L43;
        if (r19 != null) goto L40;
    L42:
        this.i0 = r18.b(r5);
        goto L43
    L40:
        if (r19.canParseUrl(r5) == false) goto L42;
        this.i0 = OptionalBool.f10951b;
    L43:
        if (r12 == false) goto L49;
        if (r19 != null) goto L46;
    L48:
        this.f11006j0 = r18.b(r10);
        goto L49
    L46:
        if (r19.canParseUrl(r10) == false) goto L48;
        this.f11006j0 = OptionalBool.f10951b;
    L49:
        TraceEvent.a(0, "ImageDelegate.isLocalResource");
        return;
    }

    public final void p(String r17, boolean r18, long r19, long r21, int r23, JSONObject r24) {
        boolean r5 = LynxEnv.inst().enableImageMemoryReport();
        LynxContext r10 = kk.a.i(this.A);
        if (r5 == false) goto L18;
        LynxBaseUI r11 = this.D;
        if (r11 == null) goto L8;
        r11.getSign();
    L8:
        if (TextUtils.isEmpty(r17) == false) goto L11;
        return;
    L11:
        if (r19 > 0) goto L13;
        return;
    L13:
        if (r21 <= 0) goto L31;
        long r12 = System.currentTimeMillis();
        LynxEventReporter.runOnReportThread(new oo.h(r10, r17, r23, r12, r21 - r19, r12 - r19, r19, r18, r24));
        return;
    L31:
        return;
    L18:
        if (this.G == true) goto L20;
        return;
    L20:
        if (TextUtils.isEmpty(r17) == false) goto L23;
        return;
    L23:
        if (r19 > 0) goto L25;
        return;
    L25:
        if (r21 <= 0) goto L35;
        long r13 = System.currentTimeMillis();
        mn.h.i().execute(new oo.h(r10, r17, r18, r19, r21 - r19, r13 - r19, r13, r23, r24));
        return;
    }

    public final void q(Map r5) {
        this.N = false;
        this.O = false;
        this.P = false;
        if (r5.containsKey("startplay") == false) goto L6;
        this.N = true;
    L6:
        if (r5.containsKey("currentloopcomplete") == false) goto L9;
        this.O = true;
    L9:
        if (r5.containsKey("finalloopcomplete") == false) goto L12;
        this.P = true;
    L12:
        if (r5.containsKey("load") == false) goto L15;
        this.Q = true;
        return;
    }

    public final void r(String r5) {
        oo.k r10 = this.f11019w;
        if (r10 != null) goto L5;
    L7:
        this.f11019w = null;
        y r11 = this.f11022z;
        if (r5 != null) goto L10;
    L14:
        r11.clear();
    L15:
        this.d = 0;
        this.e = 0;
        r11.b();
        r11.c();
        return;
    L10:
        if (r5.isEmpty() == true) goto L14;
        oo.k r12 = new oo.k(this.A, r5);
        this.f11019w = r12;
        if (Uri.EMPTY.equals(r12.a()) == false) goto L15;
        LynxLog.b(3, LynxMonitorService.DEFAULT_PID, "Warning: Image source \"" + r5 + "\" doesn't exist");
        goto L15
    L5:
        if (r10.f20818b.equals(r5) == false) goto L7;
    }

    public final boolean s(int r10, int r11) {
        oo.k r5 = this.f11019w;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.f20818b != null) goto L7;
        return false;
    L7:
        if (this.s == true) goto L9;
        return false;
    L9:
        if (this.f10993a == null) goto L17;
        TraceEvent.c("ImageDelegate.tryFetchImageFromMediaFetcher");
        long r12 = System.currentTimeMillis();
        int r13 = 8;
        ko.r r14 = new ko.r(r13, this.f11019w.f20818b, LynxResourceRequest$LynxResourceType.f10942a);
        x r15 = new x(this, r10, r11, r12);
        this.K.i(r14, r15);
        TraceEvent.a(0, "ImageDelegate.tryFetchImageFromMediaFetcher");
        return true;
    L17:
        return false;
    }
}
