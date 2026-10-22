package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final Bitmap.Config s0 = null;
    public static final ConcurrentHashMap<String, FrescoImageView.d> t0 = null;
    public final c A;
    public final Context B;
    public ReadableMap C;
    public boolean D;
    public LynxBaseUI E;
    public final Map<String, String> F;
    public final boolean G;
    public boolean H;
    public final boolean I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final g8a.a M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public float Z;
    public final LynxContext a;
    public boolean a0;
    public int b;
    public boolean b0;
    public int c;
    public int c0;
    public int d;
    public int d0;
    public int e;
    public int e0;
    public boolean f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public int h0;
    public String i;
    public GenericDraweeHierarchy i0;
    public String j;
    public boolean j0;
    public boolean k;
    public final boolean k0;
    public boolean l;
    public boolean l0;
    public boolean m;
    public Rect m0;
    public ShadowNode n;
    public boolean n0;
    public boolean o;
    public final a o0;
    public Bitmap.Config p;
    public OptionalBool p0;
    public long q;
    public OptionalBool q0;
    public ImageResizeMethod r;
    public final ILynxImageService r0;
    public l8a.c s;
    public boolean t;
    public boolean u;
    public String v;
    public int w;
    public m8a.g x;
    public m8a.g y;
    public f z;

    public class a extends BaseAnimationListener {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void onAnimationRepeat(AnimatedDrawable2 r2) {
            if (this.a.S == true) goto L5;
            return;
        L5:
            if (r2.isRunning() == false) goto L9;
            h.a(this.a, "currentloopcomplete");
            return;
        }

        public final void onAnimationStart(AnimatedDrawable2 r2) {
            h r3 = this.a;
            if (r3.R == false) goto L6;
            h.a(r3, "startplay");
            return;
        }

        public final void onAnimationStop(AnimatedDrawable2 r2) {
            if (this.a.T == true) goto L5;
            return;
        L5:
            if (r2.isRunning() == false) goto L9;
            h.a(this.a, "currentloopcomplete");
            h.a(this.a, "finalloopcomplete");
            return;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ LynxContext d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ h f;

        public class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ b c;

            public final void a() {
                b r0 = this.c;
                if (r0.c == true) goto L5;
            L8:
                b r1 = this.c;
                if (r1.e == false) goto L11;
                h r2 = r1.f;
                String r3 = this.b;
                Bitmap.Config r4 = h.s0;
                r2.t(r3);
            L11:
                f r5 = this.c.f.z;
                if (r5 == null) goto L15;
                r5.a();
                return;
            L15:
                return;
            L5:
                if (TextUtils.equals(r0.a, r0.f.v) == false) goto L7;
                this.c.f.w(this.a);
                goto L8
            L7:
                LLog.w("Lynx-Image", "image redirect check failed curUrl = " + this.c.f.v + " preUrl = " + this.c.a);
                goto L8
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

            public a(b r1, String r2, String r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        public final void a() {
            String r0 = this.a;
            String r1 = this.b;
        L10:
            th = move-exception;
            LLog.e("Lynx-Image", "async redirect url failed, placeholder: " + this.b + ", url:" + this.a + ", msg:" + th.getMessage());
            r0 = this.a;
            r1 = this.b;
        L12:
            UIThreadUtils.runOnUiThread(new a(this, r0, r1));
            return;
        L4:
            if (this.c == false) goto L7;
            r0 = this.f.f(r0, this.d);     // Catch: Throwable -> L10
        L7:
            if (this.e == false) goto L12;
            r1 = this.f.f(this.b, this.d);     // Catch: Throwable -> L10
            goto L12
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

        public b(h r1, String r2, String r3, boolean r4, LynxContext r5, boolean r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public interface c {
        void a();

        void b(List<Postprocessor> r1);

        ImageRequestBuilder c(Uri r1);

        void clear();

        void d();

        boolean e();

        void f(CloseableReference<?> r1);

        void g();

        void markDirty();
    }

    public static class d extends l8a.a {
        public final String a;

        @Override // l8a.a
        public final CloseableReference<Bitmap> process(Bitmap r6, PlatformBitmapFactory r7) {
            ConcurrentHashMap<String, FrescoImageView.d> r0 = h.t0;
            if (r0.containsKey(this.a) == true) goto L6;
            r0.put(this.a, new FrescoImageView.d(r6.getWidth(), r6.getHeight()));
        L6:
            return super.process(r6, r7);
        }

        public d(String r1, int r2, int r3, int r4, int r5, int r6, int r7, float[] r8, ScalingUtils.ScaleType r9, String r10, String r11, Bitmap.Config r12, boolean r13) {
            super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
            this.a = r1;
        }
    }

    static {
        s0 = Bitmap.Config.ARGB_8888;
        t0 = new ConcurrentHashMap();
        CloseableImage.class.getMethod("isHitBitmapMemoryCache", new Class[0]);     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        LLog.d("ImageDelegate", "Current Fresco version dose not support isHitBitmapMemoryCache");
    }

    public final void i() {
        LynxBaseUI r0 = this.E;
        if (r0 == null) goto L21;
        final int r3 = this.d;
        if (r3 == 0) goto L22;
        final int r4 = this.e;
        if (r4 == 0) goto L24;
        final boolean r2 = this.m;
        final int r5 = r0.getWidth();
        final int r6 = this.E.getHeight();
        if (this.L == false) goto L13;
        this.E.getLynxContext().findShadowNodeAndRunTask(this.E.getSign(), new g(r2, r3, r4, r5, r6));
        return;
    L13:
        if (this.n != null) goto L15;
        this.n = this.E.getLynxContext().findShadowNodeBySign(this.E.getSign());
    L15:
        ShadowNode r1 = this.n;
        if ((r1 instanceof AutoSizeImage) == true) goto L19;
        this.W = true;
        return;
    L19:
        ((AutoSizeImage) r1).D(r2, r3, r4, r5, r6);
        return;
    L24:
        return;
    L22:
        return;
    }

    public static void b(h r2) {
        r2.getClass();
        k r0 = new k(r2);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r0.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r0);
    }

    public final ImageRequestBuilder e(Uri r3) {
        Bitmap.Config r0 = this.p;
        boolean r1 = this.V;
        ImageRequestBuilder r4 = ImageRequestBuilder.newBuilderWithSource(r3);
        m8a.e.b(r4, r0, r1);
        if (((HashMap) this.F).isEmpty() == true) goto L5;
        m8a.e.e(r4, this.F);
    L10:
        return r4;
    L5:
        LynxContext r2 = this.a;
        if (r2 == null) goto L10;
        if (r2.getImageCustomParam() == null) goto L10;
        m8a.e.e(r4, this.a.getImageCustomParam());
        goto L10
    }

    public final boolean m(String r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.equals(this.v) == true) goto L6;
        return false;
    L6:
        if (r3.startsWith("http") == false) goto L14;
        int r0 = this.w;
        this.w = r0 - 1;
        if (r0 <= 0) goto L15;
        w(r3);
        this.A.markDirty();
        this.A.a();
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final void p(int r3) {
        if (r3 != 0) goto L10;
        this.s = null;
    L8:
        this.A.markDirty();
        return;
    L10:
        this.s = new l8a.c(r3, this.a);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        LLog.e("ImageDelegate", "setBlurRadius failed: " + th.getMessage());
        goto L8
    }

    public final void q(ReadableMap r5) {
        if (((HashMap) this.F).isEmpty() == true) goto L5;
        ((HashMap) this.F).clear();
    L5:
        if (r5 == null) goto L10;
        ReadableMapKeySetIterator r0 = r5.keySetIterator();
    L8:
        if (r0.hasNextKey() == false) goto L12;
        String r1 = r0.nextKey();
        Map<String, String> r2 = this.F;
        HashMap r3 = (HashMap) r2;
        r3.put(r1, r5.getString(r1, NameKeys.UnloadStrategy_No_Strategy));
        goto L8
    L12:
        return;
    }

    public final void r(Map<String, EventsListener> r3) {
        this.R = false;
        this.S = false;
        this.T = false;
        if (r3.containsKey("startplay") == false) goto L6;
        this.R = true;
    L6:
        if (r3.containsKey("currentloopcomplete") == false) goto L9;
        this.S = true;
    L9:
        if (r3.containsKey("finalloopcomplete") == false) goto L12;
        this.T = true;
    L12:
        if (r3.containsKey("load") == false) goto L15;
        this.U = true;
        return;
    }

    public final void s(ReadableMap r10) {
        if (r10 == null) goto L16;
        String r0 = r10.getString("type");
        if ("preview".equalsIgnoreCase(r0) == false) goto L7;
        this.a0 = true;
    L11:
        if (this.a0 == false) goto L13;
    L14:
        this.c0 = Math.round(com.lynx.tasm.utils.n.c(r10.getString("width"), this.a.getUIBody().getFontSize(), this.E.getFontSize(), this.a.getUIBody().getWidth(), this.a.getUIBody().getHeight(), this.a.getScreenMetrics()));
        this.d0 = Math.round(com.lynx.tasm.utils.n.c(r10.getString("height"), this.a.getUIBody().getFontSize(), this.E.getFontSize(), this.a.getUIBody().getWidth(), this.a.getUIBody().getHeight(), this.a.getScreenMetrics()));
        this.e0 = Math.round(com.lynx.tasm.utils.n.c(r10.getString("radius"), this.a.getUIBody().getFontSize(), this.E.getFontSize(), this.a.getUIBody().getWidth(), this.a.getUIBody().getHeight(), this.a.getScreenMetrics()));
        this.f0 = r10.getString("hash");
        this.g0 = r10.getString("metaData");
        this.h0 = r10.getInt("iterations", 1);
        return;
    L13:
        if (this.b0 == true) goto L14;
        return;
    L7:
        if ("blur".equalsIgnoreCase(r0) == false) goto L9;
        this.b0 = true;
        goto L11
    L9:
        this.a0 = false;
        this.b0 = false;
        goto L11
    }

    public final void t(String r3) {
        m8a.g r0 = this.y;
        if (r0 != null) goto L5;
    L7:
        this.y = null;
        if (r3 != null) goto L10;
    L14:
        this.A.markDirty();
        return;
    L10:
        if (r3.isEmpty() == true) goto L14;
        m8a.g r1 = new m8a.g(this.B, r3);
        this.y = r1;
        if (Uri.EMPTY.equals(r1.b()) == false) goto L14;
        LLog.w("Lynx", "Warning: Image source \"" + r3 + "\" doesn't exist");
        goto L14
    L5:
        if (r0.b.equals(r3) == false) goto L7;
    }

    public final void w(String r3) {
        m8a.g r0 = this.x;
        if (r0 != null) goto L5;
    L7:
        this.x = null;
        if (r3 != null) goto L10;
    L14:
        this.A.clear();
    L15:
        this.d = 0;
        this.e = 0;
        this.A.g();
        this.A.markDirty();
        return;
    L10:
        if (r3.isEmpty() == true) goto L14;
        m8a.g r1 = new m8a.g(this.B, r3);
        this.x = r1;
        if (Uri.EMPTY.equals(r1.b()) == false) goto L15;
        LLog.w("Lynx", "Warning: Image source \"" + r3 + "\" doesn't exist");
        goto L15
    L5:
        if (r0.b.equals(r3) == false) goto L7;
    }

    public h(Context r5, c r6) {
        boolean r0 = false;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = false;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = null;
        this.p = s0;
        this.q = 0;
        this.r = ImageResizeMethod.RESIZE;
        this.t = false;
        this.u = false;
        this.z = null;
        this.D = false;
        this.E = null;
        this.F = new HashMap();
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = 0;
        this.O = false;
        this.Q = false;
        this.X = false;
        this.Y = false;
        this.Z = 0.0f;
        this.a0 = false;
        this.b0 = false;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = null;
        this.g0 = null;
        this.h0 = 1;
        this.j0 = false;
        this.k0 = false;
        this.l0 = false;
        this.n0 = false;
        this.o0 = new a(this);
        OptionalBool r2 = OptionalBool.UNDEFINED;
        this.p0 = r2;
        this.q0 = r2;
        this.B = r5;
        this.A = r6;
        LynxContext r7 = com.lynx.tasm.utils.a.a(r5);
        this.a = r7;
        this.j0 = true;
        this.r0 = (ILynxImageService) i8a.n.c().a(ILynxImageService.class);
        if (r7 == null) goto L24;
        r7.getLynxImageConfig();
        if (this.f == false) goto L7;
    L10:
        boolean r8 = true;
    L11:
        this.f = r8;
        this.t = r7.getEnableImageResourceHint();
        this.J = r7.isEnableCheckLocalImage();
        this.G = r7.getEnableImageSmallDiskCache();
        this.I = LynxEnv.inst().enableImageEventReport();
        g8a.a r9 = r7.getMediaResourceFetcher();
        this.M = r9;
        if (r9 == null) goto L14;
        boolean r10 = true;
    L15:
        this.K = r10;
        if (LynxEnv.inst().enableImageAsyncRedirect() == false) goto L21;
        if (r10 == false) goto L19;
    L22:
        r0 = true;
    L23:
        this.X = r0;
        goto L24
    L19:
        if (r7.getAsyncImageInterceptor() != null) goto L22;
    L21:
        if (r7.isAsyncRedirect() == false) goto L23;
    L14:
        r10 = false;
        goto L15
    L7:
        if (r7.getEnableImageResourceHint() == true) goto L10;
        r8 = false;
    L24:
        this.k0 = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        this.L = !LynxEnv.inst().enableImageAsyncLayout();
    }

    public static void a(h r2, String r3) {
        if (r2.a == null) goto L8;
        LynxBaseUI r0 = r2.E;
        if (r0 == null) goto L9;
        m7a.a r1 = new m7a.a(r0.getSign(), r3);
        r2.a.getEventEmitter().sendCustomEvent(r1);
        return;
    L9:
        return;
    }

    public final int c(int r2, int r3) {
        Bitmap.Config r0 = this.p;
        if (r0 != null) goto L6;
        r0 = Bitmap.Config.ARGB_8888;
    L6:
        return u7a.g.a(r2, r3, r0);
    }

    public final String f(String r4, LynxContext r5) {
        if (this.K == true) goto L9;
        if (this.X == false) goto L16;
        return d7a.a.b(r5, r4, true);
    L16:
        return d7a.a.b(r5, r4, false);
    L9:
        if (TraceEvent.isTracingStarted() == false) goto L11;
        HashMap r6 = new HashMap();
        r6.put(LynxEventReporter.PROP_NAME_URL, r4);
        TraceEvent.beginSection("MediaFetcher.shouldRedirectImageUrl", r6);
    L11:
        String r7 = this.M.c(new LynxResourceRequest(r4, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage));
        if (TraceEvent.isTracingStarted() == false) goto L17;
        TraceEvent.endSection("MediaFetcher.shouldRedirectImageUrl");
        return r7;
    L17:
        return r7;
    }

    public final void u(String r12, String r13) {
        boolean r1 = false;
        if (r12 == null) goto L15;
        this.v = r12;
        if (this.J == false) goto L14;
        OptionalBool r2 = this.p0;
        if (r2 != OptionalBool.FALSE) goto L10;
        w(r12);
        goto L15
    L10:
        if (r2 != OptionalBool.TRUE) goto L12;
    L13:
        this.w = 1;
        goto L14
    L12:
        if (r2 == OptionalBool.UNDEFINED) goto L13;
    L14:
        boolean r8 = true;
    L16:
        if (r13 != null) goto L18;
    L23:
        boolean r10 = false;
    L24:
        if (r8 == true) goto L27;
        if (r10 == true) goto L27;
        return;
    L27:
        LynxContext r9 = com.lynx.tasm.utils.a.a(this.B);
        if (this.j0 == false) goto L34;
        this.j0 = false;
        if (this.k0 == false) goto L34;
        if (UIThreadUtils.isOnUiThread() == true) goto L34;
    L35:
        if (r1 == false) goto L40;
        LynxContext r0 = this.a;
        if (r0 == null) goto L39;
        LynxFeatureCounter.a(84, r0.getInstanceId());
    L39:
        LynxThreadPool.b().execute(new b(this, r12, r13, r8, r9, r10));
        return;
    L40:
        if (r8 == false) goto L42;
        w(f(r12, r9));
    L42:
        if (r10 == false) goto L46;
        t(f(r13, r9));
        return;
    L46:
        return;
    L34:
        r1 = this.X;
        goto L35
    L18:
        if (this.J == true) goto L20;
    L22:
        r10 = true;
        goto L24
    L20:
        if (this.q0 != OptionalBool.FALSE) goto L22;
        t(r13);
    L15:
        r8 = false;
        goto L16
    }

    public final void v(String r1, boolean r2) {
        if (r2 == false) goto L4;
        u(r1, null);
        return;
    L4:
        this.v = r1;
        w(r1);
    }

    public final void x(int r14, int r15) {
        m8a.g r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b != null) goto L7;
        return;
    L7:
        if (this.t == true) goto L9;
        return;
    L9:
        if (this.B == null) goto L16;
        TraceEvent.beginSection("ImageDelegate.tryFetchImageFromLocalCache");
        long r6 = System.currentTimeMillis();
        String r8 = this.x.b;
        d7a.a.a(this.B, r8, r14, r15, new i(this, r8, r14, r15, r6));
        TraceEvent.endSection("ImageDelegate.tryFetchImageFromLocalCache");
        return;
    }

    public final boolean y(int r11, int r12) {
        m8a.g r0 = this.x;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.b != null) goto L7;
        return false;
    L7:
        if (this.t == true) goto L9;
        return false;
    L9:
        if (this.a == null) goto L17;
        TraceEvent.beginSection("ImageDelegate.tryFetchImageFromMediaFetcher");
        long r5 = System.currentTimeMillis();
        this.M.a(new LynxResourceRequest(this.x.b, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage), new j(this, r11, r12, r5));
        TraceEvent.endSection("ImageDelegate.tryFetchImageFromMediaFetcher");
        return true;
    L17:
        return false;
    }

    public final JSONObject g(int r3, int r4, int r5, int r6) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("viewWidth", r3);     // Catch: JSONException -> L7
        r0.put("viewHeight", r4);     // Catch: JSONException -> L7
        r0.put("width", r5);     // Catch: JSONException -> L7
        r0.put("height", r6);     // Catch: JSONException -> L7
        Bitmap.Config r7 = this.p;     // Catch: JSONException -> L7
        if (r7 != null) goto L5;
        r7 = s0;     // Catch: JSONException -> L7
    L5:
        r0.put("config", r7);     // Catch: JSONException -> L7
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final void z(String r5, String r6, boolean r7, boolean r8) {
        if (this.J == true) goto L5;
        return;
    L5:
        if (r7 == true) goto L8;
        if (r8 == true) goto L8;
        return;
    L8:
        if (this.K == true) goto L34;
        i8a.e r0 = (i8a.e) i8a.n.c().a(i8a.e.class);
        if (r0 != null) goto L14;
        LLog.e("ImageDelegate", "Unable to update redirect because ILynxResourceService cannot be obtained.");
        return;
    L14:
        if (r7 == false) goto L24;
        int r3 = r0.isLocalResource(r5);
        if (r3 != (-1)) goto L18;
        OptionalBool r4 = OptionalBool.UNDEFINED;
    L23:
        this.p0 = r4;
        goto L24
    L18:
        if (r3 != 1) goto L20;
        r4 = OptionalBool.TRUE;
        goto L23
    L20:
        if (r3 != 0) goto L22;
        r4 = OptionalBool.FALSE;
        goto L23
    L22:
        r4 = OptionalBool.UNDEFINED;
    L24:
        if (r8 == false) goto L50;
        int r9 = r0.isLocalResource(r6);
        if (r9 != (-1)) goto L28;
        OptionalBool r10 = OptionalBool.UNDEFINED;
    L33:
        this.q0 = r10;
        goto L50
    L28:
        if (r9 != 1) goto L30;
        r10 = OptionalBool.TRUE;
        goto L33
    L30:
        if (r9 != 0) goto L32;
        r10 = OptionalBool.FALSE;
        goto L33
    L32:
        r10 = OptionalBool.UNDEFINED;
    L50:
        if (r7 == false) goto L65;
        LynxContext r11 = this.a;
        if (r11 != null) goto L54;
        return;
    L54:
        if (r11.isPrefetchImageOnCreate() == true) goto L56;
        return;
    L56:
        if (this.p0 == OptionalBool.TRUE) goto L68;
        if (r5 != null) goto L59;
        return;
    L59:
        if (r5.startsWith("http") == true) goto L61;
        return;
    L61:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L71;
        TraceEvent.beginSection("ImageDelegate.prefetchToDiskCache");
        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r5), null);
        TraceEvent.endSection("ImageDelegate.prefetchToDiskCache");
        return;
    L71:
        return;
    L68:
        return;
    L65:
        return;
    L34:
        TraceEvent.beginSection("ImageDelegate.isLocalResource");
        if (r7 == false) goto L42;
        ILynxImageService r1 = this.r0;
        if (r1 != null) goto L39;
    L41:
        this.p0 = this.M.b(r5);
        goto L42
    L39:
        if (r1.canParseUrl(r5) == false) goto L41;
        this.p0 = OptionalBool.FALSE;
    L42:
        if (r8 == false) goto L49;
        ILynxImageService r12 = this.r0;
        if (r12 != null) goto L46;
    L48:
        this.q0 = this.M.b(r6);
        goto L49
    L46:
        if (r12.canParseUrl(r6) == false) goto L48;
        this.q0 = OptionalBool.FALSE;
    L49:
        TraceEvent.endSection("ImageDelegate.isLocalResource");
        goto L50
    }

    public final void j(final String r17, final boolean r18, final long r19, long r21, final int r23, final JSONObject r24) {
        boolean r1 = LynxEnv.inst().enableImageMemoryReport();
        final LynxContext r2 = com.lynx.tasm.utils.a.a(this.B);
        if (r1 == false) goto L17;
        LynxBaseUI r3 = this.E;
        if (r3 == null) goto L8;
        r3.getSign();
    L8:
        if (TextUtils.isEmpty(r17) == false) goto L11;
        return;
    L11:
        if (r19 > 0) goto L13;
        return;
    L13:
        if (r21 <= 0) goto L24;
        final long r7 = r21 - r19;
        final long r5 = System.currentTimeMillis();
        final long r9 = r5 - r19;
        LynxEventReporter.runOnReportThread(new u7a.c(r2, r17, r23, r5, r7, r9, r19, r18, r24));
        return;
    L24:
        return;
    L17:
        if (this.I == false) goto L22;
        u7a.f.b(r2, r17, r18, false, r19, r21, r23, r24);
        return;
    }

    public final void l(String r15, boolean r16, boolean r17, long r18, long r20, int r22, int r23) {
        LynxContext r3 = com.lynx.tasm.utils.a.a(this.B);
        if (this.I == false) goto L6;
        LynxThreadPool.b().execute(new u7a.d(r3, r18, r20, r16, r15, r23, r22, r17));
        return;
    }

    public final void o(int r5, int r6, int r7, int r8, long r9, long r11, int r13) {
        if (this.U == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L11;
        LynxBaseUI r0 = this.E;
        if (r0 == null) goto L12;
        m7a.a r1 = new m7a.a(r0.getSign(), "load");
        int r2 = c(r7, r8);
        r1.a(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, this.v);
        r1.a("load_start", Long.valueOf(r9));
        r1.a("load_finish", Long.valueOf(r11));
        r1.a("cost", Long.valueOf(r11 - r9));
        r1.a("width", Integer.valueOf(r7));
        r1.a("height", Integer.valueOf(r8));
        r1.a("memory_cost", Integer.valueOf(r2));
        r1.a("origin", Integer.valueOf(r13));
        r1.a("view_width", Integer.valueOf(r5));
        r1.a("view_height", Integer.valueOf(r6));
        this.a.getEventEmitter().sendCustomEvent(r1);
        return;
    L12:
        return;
    }

    public final void h(int r20, int r21, ImageInfo r22, Animatable r23, long r24, boolean r26, int r27, l r28) {
        long r14 = System.currentTimeMillis();
        m8a.g r0 = this.x;
        boolean r2 = false;
        if (r0 == null) goto L7;
        ConcurrentHashMap<String, FrescoImageView.d> r3 = t0;
        if (r3.containsKey(r0.b().toString()) == false) goto L7;
        FrescoImageView.d r1 = r3.get(this.x.b().toString());
        int r4 = r1.a;
        int r5 = r1.b;
    L9:
        int r10 = r5;
        int r11 = r4;
    L11:
        JSONObject r8 = g(r20, r21, r11, r10);
        if (r8 != null) goto L14;
    L22:
        if (r28 != null) goto L24;
        int r15 = r10;
    L40:
        int r16 = r11;
    L42:
        if ((r23 instanceof AnimatedDrawable2) == false) goto L55;
        AnimatedDrawable2 r6 = (AnimatedDrawable2) r23;
        if (this.T == false) goto L46;
    L51:
        r6.setAnimationListener(this.o0);
    L52:
        r6.setAnimationBackend(new l8a.b(r6.getAnimationBackend(), this.N));
        if (this.O == true) goto L55;
        m8a.e.c(r6);
        goto L55
    L46:
        if (this.R == true) goto L51;
        if (this.S == true) goto L51;
        r6.setAnimationListener(null);
    L55:
        int r12 = c(r16, r15);
        this.q = r12;
        j(this.v, true, r24, r14, r12, r8);
        l(this.v, true, false, r24, r14, 0, r12);
        k(this.v, 0, false, r27, r24, r14, r26, r16, r15);
        return;
    L24:
        if (this.m == true) goto L26;
    L30:
        if (r2 == false) goto L33;
        this.d = r11;
        this.e = r10;
        i();
    L33:
        if (this.Q == false) goto L35;
        o(r20, r21, r11, r10, r24, r14, r27);
        r15 = r10;
        goto L40
    L35:
        r8 = r8;
        int r25 = r10;
        if (this.P == false) goto L38;
        r14 = r14;
        r16 = r11;
        n(r20, r21, r11, r25, r24, r14, false, r27);
        r15 = r25;
        goto L42
    L38:
        r14 = r14;
        r15 = r25;
        r16 = r11;
        r28.onImageLoadSuccess(r16, r15);
        goto L42
    L26:
        if (this.d != 0) goto L30;
        if (this.e != 0) goto L30;
        r2 = true;
        goto L30
    L14:
        if (r23 == null) goto L17;
        if (r26 == false) goto L17;
        int r7 = 1;
    L57:
        r8.put("isFlattenAnim", r7);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L17:
        r7 = 0;
    L7:
        if (r22 == null) goto L10;
        r4 = r22.getWidth();
        r5 = r22.getHeight();
        goto L9
    L10:
        r10 = 0;
        r11 = 0;
        goto L11
    }

    public final void n(int r20, int r21, int r22, int r23, long r24, long r26, boolean r28, int r29) {
        if (this.U == true) goto L5;
        return;
    L5:
        if (this.a != null) goto L7;
        return;
    L7:
        if (this.E == null) goto L42;
        int r16 = c(r22, r23);
        long r12 = r26 - r24;
        if (this.x == null) goto L21;
        String r0 = this.v;
        if (r0 == null) goto L21;
        if (r0.startsWith(LynxResourceModule.DATA_KEY) == false) goto L16;
        String r1 = "base64";
    L22:
        String r14 = r1;
        JSONObject r17 = g(r20, r21, r22, r23);
        JSONObject r4 = u7a.f.a(this.a, this.v, true, r28, r24, r12, r12, r26, r16, r17);
        if (r4 == null) goto L43;
        m7a.a r5 = new m7a.a(this.E.getSign(), "load");
        Iterator<String> r6 = r4.keys();
    L26:
        if (r6.hasNext() == false) goto L33;
        String r7 = r6.next();
        Object r2 = r4.get(r7);     // Catch: JSONException -> L30
    L32:
        r5.a(r7, r2);
    L30:
        e = move-exception;
        e.printStackTrace();
        r2 = null;
        goto L32
    L33:
        r5.a("resourceFrom", r14);
        r5.a("width", Integer.valueOf(r22));
        r5.a("height", Integer.valueOf(r23));
        r5.a("origin", Integer.valueOf(r29));
        this.a.getEventEmitter().sendCustomEvent(r5);
        return;
    L43:
        return;
    L16:
        if (this.v.startsWith("http") == true) goto L18;
    L20:
        r1 = "local resource";
        goto L22
    L18:
        if (this.x.b.equals(this.v) == false) goto L20;
        r1 = "cdn";
    L21:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L22
    }

    public final l8a.d d(m8a.g r23, int r24, int r25, int r26, int r27, int r28, int r29, float[] r30, ScalingUtils.ScaleType r31) {
        Postprocessor r17 = null;
        if (r23 != null) goto L5;
        return null;
    L5:
        TraceEvent.beginSection("ImageDelegate.createImageRequest");
        ImageRequestBuilder r15 = this.A.c(r23.b());
        r15.setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.o);
        if (this.f == true) goto L33;
        if (this.Y == true) goto L33;
        if (this.n0 == true) goto L33;
        if (this.m0 != null) goto L33;
        if (m8a.f.a(r23, this.r) == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L30;
        int r4 = this.b;
        int r5 = this.c;
        if (r4 <= 0) goto L29;
        if (r5 <= 0) goto L29;
        if (Math.abs(r24 - r4) > 1) goto L29;
        if (Math.abs(r25 - r5) > 1) goto L29;
        ResizeOptions r6 = new ResizeOptions(r4, r5);
    L31:
        r15.setResizeOptions(r6);
    L29:
        r6 = new ResizeOptions(r24, r25);
        goto L31
    L30:
        r6 = null;
        goto L31
    L16:
        if (this.m == true) goto L18;
        r3 = true;
    L33:
        if (this.G == false) goto L38;
        if (r15.getCacheChoice() != ImageRequest.CacheChoice.DEFAULT) goto L38;
        r15.setCacheChoice(ImageRequest.CacheChoice.SMALL);
    L38:
        if (this.H == false) goto L40;
        r15.setRequestPriority(Priority.HIGH);
    L40:
        boolean r7 = this.A.e();
        LinkedList r12 = new LinkedList();
        if (this.Y == false) goto L47;
        ILynxImageService r8 = this.r0;
        if (r8 == null) goto L47;
        r12.add((Postprocessor) r8.getImageSRPostProcessor());
        float r9 = this.Z;
        if (r9 <= 0.0f) goto L47;
        this.r0.setImageSRSize(r15, (int) (r24 * r9), (int) (r25 * r9));
    L47:
        if (r7 == false) goto L53;
        if (r24 <= 0) goto L53;
        if (r25 <= 0) goto L53;
        if (this.D == true) goto L53;
        LinkedList r1 = r12;
        r1.add(new d(r23.b().toString(), r24, r25, r26, r27, r28, r29, r30, r31, this.g, this.h, this.p, this.k));
    L54:
        LinkedList r0 = r1;
        l8a.c r2 = this.s;
        if (r2 == null) goto L57;
        r0.add(r2);
    L57:
        this.A.b(r0);
        int r10 = r0.size();
        if (r10 == 0) goto L63;
        int r11 = 1;
        if (r10 == 1) goto L62;
        Postprocessor r13 = new m0(r0);
        char r14 = 0;
    L65:
        if (r13 == null) goto L77;
        m8a.g r16 = this.x;
        if (r16 == null) goto L74;
        String r18 = r16.b().toString().toLowerCase();
        if (r18.endsWith(".gif") == true) goto L74;
        if (r18.endsWith(".apng") == true) goto L74;
        boolean r19 = true;
    L75:
        if (r19 == false) goto L77;
        ImageRequestBuilder r20 = r15;
        r20.setPostprocessor(r13);
    L79:
        if (TextUtils.isEmpty(this.i) == false) goto L81;
    L87:
        boolean r21 = this.l0;
        if (r21 == false) goto L106;
        Method r22 = m8a.e.d;
        if (r22 != null) goto L144;
    L97:
        r20.setProgressiveRenderingEnabled(this.l0);
        boolean r32 = this.l0;
        Method r33 = m8a.e.e;
        if (r33 == null) goto L106;
        Object[] r34 = new Object[r11];     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
        r34[r14] = Boolean.valueOf(r32);     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
        r33.invoke(r20, r34);     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
    L103:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
    L101:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
        goto L106
    L144:
        Object[] r35 = new Object[r11];     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
        r35[r14] = Boolean.valueOf(r21);     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
        r22.invoke(r20, r35);     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
    L95:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
    L93:
        e = move-exception;
        LLog.e("Fresco", Log.getStackTraceString(e));
    L106:
        if (TextUtils.isEmpty(this.j) == true) goto L111;
        ILynxImageService r36 = this.r0;
        if (r36 == null) goto L111;
        r36.setImageCacheChoice(this.j, r20);
    L111:
        if (this.l == false) goto L122;
        if (this.r0 == null) goto L122;
        Uri r37 = r23.b();
        String r38 = r37.getScheme();
        if (r38 == null) goto L122;
        if (r38.startsWith("http") == false) goto L122;
        String r39 = r37.getPath();
        if (TextUtils.isEmpty(r39) == true) goto L122;
        this.r0.setCacheKeyUri(r20, UriProtector.parse(r39));
    L122:
        if (this.n0 == false) goto L126;
        ILynxImageService r40 = this.r0;
        if (r40 == null) goto L126;
        r40.setSampleSize(r20, r11);
    L126:
        Rect r41 = this.m0;
        if (r41 == null) goto L131;
        ILynxImageService r42 = this.r0;
        if (r42 == null) goto L131;
        r42.setImageDecodeRegion(r20, r41);
    L131:
        l8a.d r43 = new l8a.d(r20, this.C);
        if (TextUtils.isEmpty(this.f0) == true) goto L140;
        boolean r110 = this.a0;
        if (r110 == false) goto L136;
    L137:
        ILynxImageService r44 = this.r0;
        if (r44 == null) goto L140;
        r44.setImagePlaceHolderHash(this.i0, r43, r31, this.f0, this.g0, this.c0, this.d0, this.e0, this.h0, r110);
        goto L140
    L136:
        if (this.b0 == true) goto L137;
    L140:
        TraceEvent.endSection("ImageDelegate.createImageRequest");
        return r43;
    L81:
        if ("high".equalsIgnoreCase(this.i) == false) goto L84;
        r20.setRequestPriority(Priority.HIGH);
        goto L87
    L84:
        if ("low".equalsIgnoreCase(this.i) == false) goto L86;
        r20.setRequestPriority(Priority.LOW);
        goto L87
    L86:
        r20.setRequestPriority(Priority.MEDIUM);
    L74:
        r19 = false;
    L77:
        r20 = r15;
        goto L79
    L62:
        r14 = 0;
        r17 = (Postprocessor) ListProtector.get(r0, 0);
    L64:
        r13 = r17;
        goto L65
    L63:
        r14 = 0;
        r11 = 1;
    L53:
        r1 = r12;
        goto L54
    }

    public final void k(String r16, int r17, boolean r18, int r19, long r20, long r22, boolean r24, int r25, int r26) {
        if (this.I == true) goto L5;
        return;
    L5:
        if (r16.startsWith("http") == false) goto L9;
        u7a.f.c(com.lynx.tasm.utils.a.a(this.B), r16, r17, r18, r19, r20, r22, r24, r25, r26, this.F);
        return;
    }
}
