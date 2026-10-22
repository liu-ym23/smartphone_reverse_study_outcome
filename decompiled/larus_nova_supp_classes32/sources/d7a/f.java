package d7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.m;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import u7a.i;
import u7a.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class f implements Drawable.Callback {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public v7a.f G;
    public final Map<String, String> G1;
    public v7a.f H;
    public boolean H0;
    public boolean H1;
    public float I;
    public float J;
    public float K;
    public float L;
    public boolean L0;
    public final boolean L1;
    public float[] M;
    public float M1;
    public RectF N;
    public int O;
    public int P;
    public int P0;
    public boolean P1;
    public long Q;
    public Rect Q1;
    public ShadowNode R;
    public boolean S;
    public long S1;
    public LynxBaseUI T;
    public long T1;
    public m U;
    public View V;
    public int V0;
    public final e V1;
    public final boolean W;
    public final i X;
    public final boolean Y;
    public boolean Z;
    public long a;
    public final LynxContext b;
    public OptionalBool b1;
    public final b b2;
    public final d7a.c c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public OptionalBool g1;
    public final c g2;
    public boolean h;
    public ColorFilter h1;
    public boolean i;
    public j j;
    public j k;
    public boolean k0;
    public v7a.f k1;
    public String l;
    public String m;
    public u7a.m.b n;
    public String o;
    public boolean p;
    public boolean p0;
    public BackgroundDrawable.RoundRectPath p1;
    public int q;
    public Bitmap.Config r;
    public boolean s;
    public int t;
    public long u;
    public String v;
    public boolean v1;
    public boolean w;
    public int x;
    public boolean x1;
    public int y;
    public boolean y1;
    public int z;

    public class a implements v7a.e {
        public final /* synthetic */ f a;

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r1) {
        }

        public a(f r1) {
            this.a = r1;
        }

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r8) {
            f r0 = this.a;
            if (r0.H1 == false) goto L30;
            LynxBaseUI r1 = r0.T;
            if (r1 == null) goto L7;
            int r2 = r1.getSign();
        L9:
            if (r0.b == null) goto L31;
            if (r2 >= 0) goto L12;
            return;
        L12:
            if (r0.H1 == false) goto L33;
            if (r8 == null) goto L34;
            m7a.a r3 = new m7a.a(r2, "load");
            Iterator<String> r4 = r8.keys();
        L16:
            if (r4.hasNext() == false) goto L23;
            String r5 = r4.next();
            Object r6 = r8.get(r5);     // Catch: JSONException -> L20
        L22:
            r3.a(r5, r6);
        L20:
            e = move-exception;
            LLog.e("LynxImageManager", e.getMessage());
            r6 = null;
            goto L22
        L23:
            r3.a(LynxError.LYNX_ERROR_KEY_RESOURCE_URL, r0.d);
            r3.a("width", Integer.valueOf(r0.O));
            r3.a("height", Integer.valueOf(r0.P));
            r3.a("view_width", Integer.valueOf(r0.B));
            r3.a("view_height", Integer.valueOf(r0.C));
            r3.a("memoryCost", Long.valueOf(r0.Q));
            r3.a("load_start", Long.valueOf(r0.S1));
            r3.a("load_finish", Long.valueOf(r0.T1));
            r3.a("cost", Long.valueOf(r0.T1 - r0.S1));
            r0.b.getEventEmitter().sendCustomEvent(r3);
            return;
        L34:
            return;
        L33:
            return;
        L31:
            return;
        L7:
            r2 = r0.V0;
            goto L9
        }

        @Override // v7a.e
        public final void onFailure(int r21, Throwable r22) {
            LLog.e("LynxImageManager", "onFailed src:" + this.a.d + ",with reason:" + r22.getMessage());
            int r1 = u7a.b.b(r21);
            String r2 = r22.getMessage();
            if (TextUtils.isEmpty(r2) == false) goto L9;
            r2 = Log.getStackTraceString(r22);
            if (r2 == null) goto L9;
            if (r2.length() <= 200) goto L9;
            r2 = r2.substring(0, 200);
        L9:
            LynxError r3 = new LynxError(r1, "Android LynxImageManager loading image failed", NameKeys.UnloadStrategy_No_Strategy, "error");
            r3.setRootCause(r2);
            this.a.j(r3, r1, r21);
            f r4 = this.a;
            r4.getClass();
            long r8 = System.currentTimeMillis();
            r4.T1 = r8;
            String r5 = r4.d;
            long r6 = r4.S1;
            boolean r12 = false;
            if (r4.L1 == false) goto L12;
            u7a.f.b(r4.b, r5, false, false, r6, r8, 0, null);
        L12:
            String r11 = r4.d;
            long r7 = r4.S1;
            long r9 = r4.T1;
            int r10 = 0;
            if (r4.L1 == false) goto L15;
            LynxThreadPool.b().execute(new u7a.d(r4.b, r7, r9, r12, r11, r10, r21, false));
        L15:
            r4.q(r4.d, r21, false, -1, r4.S1, r4.T1, r4.T instanceof LynxFlattenUI, 0, 0);
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r31, v7a.f r32, v7a.d r33) {
            String r2 = r32.a;
            v7a.f r4 = this.a.G;
            if (r4 == null) goto L5;
            String r5 = r4.a;
        L7:
            if (TextUtils.equals(r2, r5) == true) goto L9;
            return;
        L9:
            boolean r3 = false;
            if (r31 != null) goto L12;
        L22:
            f r6 = this.a;
            if (r6.g == false) goto L27;
            r6.p(r6.k1);
            f r7 = this.a;
            r7.o(r7.j);
            f r8 = this.a;
            r8.k1 = null;
            j r9 = r8.j;
            if (r9 == null) goto L27;
            r9.b();
            this.a.j = null;
        L27:
            this.a.j = new j(r31, this.a.n);
            if (TextUtils.isEmpty(this.a.l) == true) goto L30;
            f r0 = this.a;
            j r10 = r0.j;
            String r11 = r0.l;
            String r1 = r0.m;
            r10.h = r11;
            r10.i = r1;
        L30:
            f r12 = this.a;
            int r13 = r33.a;
            r12.O = r13;
            int r14 = r33.b;
            r12.P = r14;
            if (r13 <= 0) goto L40;
            if (r14 <= 0) goto L40;
            Bitmap.Config r15 = r12.r;     // Catch: UnsupportedOperationException -> L39
            if (r15 != null) goto L37;
            r15 = Bitmap.Config.ARGB_8888;     // Catch: UnsupportedOperationException -> L39
        L37:
            long r16 = u7a.g.a(r13, r14, r15);     // Catch: UnsupportedOperationException -> L39
        L41:
            r12.Q = r16;
            com.lynx.tasm.group.d r17 = this.a.b.getRuntimeCacheManager();
            if (r17 == null) goto L44;
            int r18 = this.a.O;
            r17.c();
        L44:
            this.a.h();
            f r19 = this.a;
            ColorFilter r20 = r19.h1;
            if (r20 == null) goto L47;
            r19.j.setColorFilter(r20);
        L47:
            f r21 = this.a;
            r21.b(r21.j);
            f r22 = this.a;
            if (r22.t <= 0) goto L50;
            r22.u = SystemClock.uptimeMillis();
        L51:
            f r23 = this.a;
            r23.k(r23.O, r23.P);
            f r24 = this.a;
            r24.getClass();
            r24.T1 = System.currentTimeMillis();
            boolean r25 = r33.c;
            JSONObject r26 = new JSONObject();     // Catch: JSONException -> L63
            r26.put("viewWidth", r24.B);     // Catch: JSONException -> L63
            r26.put("viewHeight", r24.C);     // Catch: JSONException -> L63
            r26.put("width", r24.O);     // Catch: JSONException -> L63
            r26.put("height", r24.P);     // Catch: JSONException -> L63
            Bitmap.Config r110 = r24.r;     // Catch: JSONException -> L63
            if (r110 != null) goto L55;
            r110 = Bitmap.Config.ARGB_8888;     // Catch: JSONException -> L63
        L55:
            r26.put("config", r110);     // Catch: JSONException -> L63
            if (r25 == true) goto L58;
        L60:
            int r27 = 0;
        L61:
            r26.put("isFlattenAnim", r27);     // Catch: JSONException -> L63
            JSONObject r111 = r26;
        L65:
            int r28 = (int) r24.Q;
            if (r33.d != 5) goto L68;
            r3 = true;
        L68:
            String r112 = r24.d;
            boolean r29 = true;
            long r113 = r24.S1;
            long r30 = r24.T1;
            if (r24.L1 == false) goto L71;
            u7a.f.b(r24.b, r112, true, r3, r113, r30, r28, r111);
        L71:
            String r34 = r24.d;
            long r35 = r24.S1;
            long r36 = r24.T1;
            int r210 = 0;
            if (r24.L1 == false) goto L74;
            LynxThreadPool.b().execute(new u7a.d(r24.b, r35, r36, r29, r34, r28, r210, r3));
        L74:
            r24.q(r24.d, 0, r3, r33.d, r24.S1, r24.T1, r24.T instanceof LynxFlattenUI, r24.O, r24.P);
            this.a.f();
            return;
        L58:
            if ((r24.T instanceof LynxFlattenUI) == false) goto L60;
            r27 = 1;
        L63:
            e = move-exception;
            LLog.e("LynxImageManager", "getSizeInfo error: " + e.getMessage());
            r111 = null;
            goto L65
        L50:
            r22.u = -1;
        L39:
            LLog.w("LynxImageManager", "Unsupported bitmap config when reporting image memory usage: " + r12.r);
        L40:
            r16 = 0;
            goto L41
        L12:
            if (this.a.v1 == false) goto L18;
            if (r31.d == false) goto L16;
            r31.j.setFilterBitmap(false);
            goto L18
        L16:
            r31.c.setFilterBitmap(false);
        L18:
            if (r33.c == false) goto L22;
            f r37 = this.a;
            if (r31.d == true) goto L22;
            r31.c.setCallback(r37);
            goto L22
        L5:
            r5 = null;
            goto L7
        }
    }

    public class b implements v7a.e {
        public final /* synthetic */ f a;

        @Override // v7a.e
        public final void onFailure(int r1, Throwable r2) {
        }

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r1) {
        }

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r1) {
        }

        public b(f r1) {
            this.a = r1;
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r2, v7a.f r3, v7a.d r4) {
            String r5 = r3.a;
            v7a.f r6 = this.a.H;
            if (r6 == null) goto L5;
            String r7 = r6.a;
        L7:
            if (TextUtils.equals(r5, r7) == true) goto L9;
            return;
        L9:
            f r8 = this.a;
            r8.k = new j(r2, this.a.n);
            f r9 = this.a;
            r9.b(r9.k);
            this.a.f();
            return;
        L5:
            r7 = null;
            goto L7
        }
    }

    public class c implements v7a.a {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ f a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(f r1) {
            this.a = r1;
        }
    }

    public static class e implements v7a.e {
        public final v7a.e a;
        public final ArrayList<Runnable> b;

        public class a implements Runnable {
            public final /* synthetic */ e a;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r1) {
                this.a = r1;
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ v7a.f a;
            public final /* synthetic */ e b;

            @Override // java.lang.Runnable
            public final void run() {
                this.b.a.onRequestSubmit(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(e r1, v7a.f r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ u7a.a a;
            public final /* synthetic */ v7a.f b;
            public final /* synthetic */ v7a.d c;
            public final /* synthetic */ e d;

            @Override // java.lang.Runnable
            public final void run() {
                this.d.a.onSuccess(this.a, this.b, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(e r1, u7a.a r2, v7a.f r3, v7a.d r4) {
                this.d = r1;
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ Throwable b;
            public final /* synthetic */ e c;

            @Override // java.lang.Runnable
            public final void run() {
                this.c.a.onFailure(this.a, this.b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(e r1, int r2, Throwable r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        /* JADX INFO: renamed from: d7a.f$e$e, reason: collision with other inner class name */
        public class RunnableC0081e implements Runnable {
            public final /* synthetic */ JSONObject a;
            public final /* synthetic */ e b;

            @Override // java.lang.Runnable
            public final void run() {
                this.b.a.onImageMonitorInfo(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0081e(e r1, JSONObject r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final synchronized void b() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.b.isEmpty() == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            Iterator<Runnable> r0 = this.b.iterator();     // Catch: Throwable -> L14
        L9:
            if (r0.hasNext() == false) goto L11;
            r0.next().run();     // Catch: Throwable -> L14
            goto L9
        L11:
            this.b.clear();     // Catch: Throwable -> L14
            monitor-exit(this);
        }

        public e(a r2) {
            this.b = new ArrayList();
            this.a = r2;
        }

        public final synchronized void a(Runnable r2) {
            monitor-enter(this);
            this.b.add(r2);     // Catch: Throwable -> L6
            UIThreadUtils.runOnUiThreadImmediately(new a(this));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onImageMonitorInfo(JSONObject r2) {
            monitor-enter(this);
            a(new RunnableC0081e(this, r2));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onRequestSubmit(v7a.f r2) {
            monitor-enter(this);
            a(new b(this, r2));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onFailure(int r2, Throwable r3) {
            monitor-enter(this);
            a(new d(this, r2, r3));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onSuccess(u7a.a r2, v7a.f r3, v7a.d r4) {
            monitor-enter(this);
            a(new c(this, r2, r3, r4));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public final void B() {
        if (this.f == false) goto L6;
        return;
    L6:
        if (this.Y == true) goto L8;
        return;
    L8:
        boolean r0 = g(2);
        boolean r1 = g(4);
        boolean r2 = false;
        final LynxResourceRequest r3 = null;
        if (r0 == false) goto L20;
        d7a.c r4 = this.c;
        String r5 = this.d;
        if (r4.b == true) goto L13;
        boolean r6 = r4.a.canParseUrl(r5);
    L14:
        if (r6 == false) goto L16;
        this.b1 = OptionalBool.FALSE;
    L18:
        if (this.b1 == OptionalBool.FALSE) goto L20;
        final LynxResourceRequest r7 = new LynxResourceRequest(this.d, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
    L21:
        if (r1 == false) goto L32;
        d7a.c r8 = this.c;
        String r9 = this.e;
        if (r8.b == true) goto L25;
        r2 = r8.a.canParseUrl(r9);
    L25:
        if (r2 == false) goto L27;
        this.g1 = OptionalBool.FALSE;
    L29:
        if (this.g1 == OptionalBool.FALSE) goto L32;
        r3 = new LynxResourceRequest(this.e, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
        goto L32
    L27:
        this.g1 = this.X.b(this.e);
    L32:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L34;
    L43:
        if (r7 == null) goto L45;
        this.d = this.X.c(r7);
    L45:
        if (r3 == null) goto L50;
        this.e = this.X.c(r3);
        return;
    L50:
        return;
    L34:
        if (this.W == false) goto L43;
        if (r7 != null) goto L38;
        if (r3 != null) goto L38;
        return;
    L38:
        if (r7 == null) goto L40;
        this.a &= -3;
    L40:
        if (r3 == null) goto L42;
        this.a &= -5;
    L42:
        LynxThreadPool.b().execute(new d7a.d(this, r3, r7));
        return;
    L16:
        this.b1 = this.X.b(this.d);
        goto L18
    L13:
        r6 = false;
    L20:
        r7 = null;
        goto L21
    }

    public final void d() {
        p(this.G);
        p(this.H);
        o(this.j);
        o(this.k);
        this.G = null;
        this.H = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        j r1 = this.j;
        if (r1 == null) goto L5;
        r1.b();
        this.j = null;
    L5:
        j r2 = this.k;
        if (r2 == null) goto L9;
        r2.b();
        this.k = null;
        return;
    }

    public final Boolean e() {
        if (this.j == null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        return Boolean.valueOf(r0);
    L5:
        if (this.k != null) goto L8;
        r0 = false;
        goto L10
    }

    public void f() {
        LynxBaseUI r0 = this.T;
        if (r0 == null) goto L5;
        r0.invalidateMeaningfulPaintingArea();
    L5:
        m r1 = this.U;
        if (r1 == null) goto L11;
        KeyEvent.Callback r2 = r1.b;
        if ((r2 instanceof com.lynx.tasm.behavior.ui.e.a) == false) goto L11;
        ((com.lynx.tasm.behavior.ui.e.a) r2).invalidateMeaningfulPaintingArea();
    L11:
        if (UIThreadUtils.isOnUiThread() == true) goto L13;
        return;
    L13:
        LynxBaseUI r3 = this.T;
        if (r3 == null) goto L16;
        r3.invalidate();
    L16:
        m r4 = this.U;
        if (r4 == null) goto L22;
        View r5 = r4.b;
        if (r5 == null) goto L22;
        r5.invalidate();
    L22:
        View r6 = this.V;
        if (r6 == null) goto L26;
        r6.invalidate();
        return;
    }

    public final void h() {
        if (this.O != 0) goto L5;
        return;
    L5:
        if (this.P != 0) goto L7;
        return;
    L7:
        if (this.p == false) goto L22;
        LynxBaseUI r0 = this.T;
        if (r0 != null) goto L12;
        return;
    L12:
        if (this.R != null) goto L14;
        this.R = r0.getLynxContext().findShadowNodeBySign(this.T.getSign());
    L14:
        ShadowNode r1 = this.R;
        if ((r1 instanceof AutoSizeImage) == true) goto L18;
        this.S = true;
        return;
    L18:
        ((AutoSizeImage) r1).D(this.p, this.O, this.P, this.T.getWidth(), this.T.getHeight());
        return;
    }

    public final void z() {
        if (g(2048) == false) goto L14;
        if (this.F == true) goto L11;
        if (this.p == true) goto L11;
        if (this.h == false) goto L14;
    L11:
        if (this.G == null) goto L14;
        this.a &= -2049;
    L14:
        if (g(16) == false) goto L19;
        if (this.j == null) goto L19;
        this.j = new j(this.j.f, this.n);
    L19:
        if (g(8) == false) goto L24;
        j r2 = this.j;
        if (r2 == null) goto L24;
        String r3 = this.l;
        String r4 = this.m;
        r2.h = r3;
        r2.i = r4;
    L24:
        if (g(128) == false) goto L28;
        j r5 = this.j;
        if (r5 == null) goto L28;
        r5.setColorFilter(this.h1);
    L28:
        boolean r6 = true;
        if (g(4) == false) goto L59;
        p(this.H);
        o(this.k);
        j r7 = this.k;
        if (r7 == null) goto L33;
        r7.b();
        this.k = null;
    L33:
        this.H = null;
        if (TraceEvent.isTracingStarted() == false) goto L36;
        TraceEvent.beginSection("LynxImageManager.updatePlaceholderSource");
    L36:
        int r8 = this.B;
        if (r8 <= 0) goto L41;
        int r9 = this.C;
        if (r9 <= 0) goto L41;
    L45:
        boolean r10 = true;
    L47:
        if (r10 == true) goto L49;
    L57:
        TraceEvent.endSection("LynxImageManager.updatePlaceholderSource");
        goto L59
    L49:
        if (this.j != null) goto L57;
        v7a.f r11 = c(r8, r9, this.e);
        if (r11 == null) goto L57;
        this.H = r11;
        d7a.c r12 = this.c;
        b r13 = this.b2;
        LynxContext r14 = this.b;
        r12.getClass();
        TraceEvent.beginSection("LynxImageServiceProxy.fetchImage");
        if (r12.b == true) goto L56;
        r12.a.fetchImage(r11, r13, null, r14);
        TraceEvent.endSection("LynxImageServiceProxy.fetchImage");
        goto L57
    L56:
        throw null;
    L41:
        r8 = this.D;
        if (r8 <= 0) goto L46;
        r9 = this.E;
        if (r9 > 0) goto L45;
    L46:
        r8 = 0;
        r9 = 0;
        r10 = false;
    L59:
        if (g(2) == true) goto L67;
        if (g(32) == true) goto L67;
        if (g(2048) == true) goto L67;
        if (g(8192) == true) goto L67;
    L94:
        if (g(512) == false) goto L96;
    L99:
        b(this.j);
        b(this.k);
        float[] r0 = this.M;
        if (r0 != null) goto L102;
    L108:
        if (this.S == false) goto L112;
        this.S = false;
        if (this.p == false) goto L112;
        h();
    L112:
        this.a = 0;
        return;
    L102:
        if (r0.length <= 0) goto L108;
        if (this.p1 != null) goto L106;
        this.p1 = new BackgroundDrawable.RoundRectPath();
    L106:
        this.p1.d(new Rect(this.x, this.y, this.B - this.z, this.C - this.A), this.M, this.N, 1.0f, false);
        goto L108
    L96:
        if (g(1024) == true) goto L99;
        if (g(4096) == false) goto L108;
    L67:
        if (this.g == true) goto L72;
        p(this.G);
        o(this.j);
        j r1 = this.j;
        if (r1 == null) goto L71;
        r1.b();
        this.j = null;
    L71:
        this.G = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
    L74:
        if (TraceEvent.isTracingStarted() == false) goto L76;
        TraceEvent.beginSection("LynxImageManager.updateImageSource");
    L76:
        int r15 = this.B;
        if (r15 <= 0) goto L81;
        int r16 = this.C;
        if (r16 <= 0) goto L81;
    L90:
        if (r6 == false) goto L92;
        LynxThreadPool.g(new g(this, r15, r16));
    L92:
        TraceEvent.endSection("LynxImageManager.updateImageSource");
    L81:
        r15 = this.D;
        if (r15 <= 0) goto L87;
        r16 = this.E;
        if (r16 > 0) goto L90;
    L87:
        if (this.p == true) goto L89;
        r15 = 0;
        r16 = 0;
        r6 = false;
        goto L90
    L89:
        r15 = 0;
        r16 = 0;
        goto L90
    L72:
        this.k1 = this.G;
        goto L74
    }

    public final void m() {
        z();
        f();
    }

    public f(LynxContext r7) {
        this.a = 0;
        this.n = u7a.m.b.a;
        boolean r2 = false;
        this.q = 0;
        this.s = true;
        this.t = 0;
        this.u = -1;
        this.w = true;
        this.N = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.R = null;
        this.V = null;
        this.Y = false;
        this.P0 = -1;
        this.V0 = -1;
        OptionalBool r5 = OptionalBool.UNDEFINED;
        this.b1 = r5;
        this.g1 = r5;
        this.h1 = null;
        this.k1 = null;
        this.v1 = false;
        this.x1 = false;
        this.y1 = false;
        this.G1 = new HashMap();
        this.H1 = false;
        this.L1 = false;
        this.M1 = 0.0f;
        this.P1 = false;
        this.S1 = 0;
        this.T1 = 0;
        this.V1 = new e(new a(this));
        this.b2 = new b(this);
        this.g2 = new c(this);
        this.b = r7;
        r7.getImageFetcher();
        this.c = new d7a.c();
        this.X = new i(r7);
        if (r7.getMediaResourceFetcher() == null) goto L5;
    L6:
        r2 = true;
    L7:
        this.W = r2;
        this.Y = r7.isEnableCheckLocalImage();
        r7.getLynxImageConfig();
        this.L1 = LynxEnv.inst().enableImageEventReport();
        return;
    L5:
        if (r7.getAsyncImageInterceptor() == null) goto L7;
        goto L6
    }

    public final void A(ReadableMap r11) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("LynxImageManager.updatePropertiesInterval");
    L5:
        ReadableMapKeySetIterator r0 = r11.keySetIterator();
    L7:
        if (r0.hasNextKey() == false) goto L220;
        String r2 = r0.nextKey();
        r2.getClass();
        int r4 = 0;
        switch(r2.hashCode()) {
            case -1937917490: goto L132;
            case -1900756664: goto L128;
            case -1492006372: goto L124;
            case -1338903714: goto L120;
            case -1138223116: goto L116;
            case -1059824547: goto L112;
            case -629825370: goto L108;
            case -320982203: goto L104;
            case -256430480: goto L100;
            case 114148: goto L96;
            case 3357091: goto L92;
            case 108305470: goto L88;
            case 207594941: goto L84;
            case 259555579: goto L80;
            case 305374695: goto L76;
            case 313009824: goto L72;
            case 516005201: goto L68;
            case 598246771: goto L64;
            case 660415178: goto L60;
            case 681292984: goto L56;
            case 893413739: goto L52;
            case 1145216977: goto L48;
            case 1198809474: goto L44;
            case 1282944765: goto L40;
            case 1439562083: goto L36;
            case 1515751784: goto L32;
            case 1615092063: goto L28;
            case 1739487650: goto L24;
            case 1856274660: goto L20;
            case 1860054545: goto L16;
            case 1998893929: goto L12;
            default: goto L135;
        };
    L135:
        byte r3 = -1;
    L137:
        switch(r3) {
            case 0: goto L217;
            case 1: goto L213;
            case 2: goto L211;
            case 3: goto L210;
            case 4: goto L198;
            case 5: goto L197;
            case 6: goto L192;
            case 7: goto L191;
            case 8: goto L190;
            case 9: goto L189;
            case 10: goto L188;
            case 11: goto L185;
            case 12: goto L184;
            case 13: goto L183;
            case 14: goto L180;
            case 15: goto L179;
            case 16: goto L176;
            case 17: goto L173;
            case 18: goto L172;
            case 19: goto L169;
            case 20: goto L166;
            case 21: goto L164;
            case 22: goto L163;
            case 23: goto L162;
            case 24: goto L161;
            case 25: goto L158;
            case 26: goto L155;
            case 27: goto L154;
            case 28: goto L146;
            case 29: goto L140;
            case 30: goto L139;
            default: goto L7;
        };
    L139:
        this.i = r11.getBoolean(r2, false);
        goto L7
    L140:
        String r5 = r11.getString(r2);
        if (TextUtils.equals(r5, this.v) == true) goto L7;
        this.v = r5;
        if (ColorUtils.a(r5) == false) goto L145;
        this.h1 = new PorterDuffColorFilter(ColorUtils.b(this.v), PorterDuff.Mode.SRC_IN);
    L145:
        this.a |= 128;
        goto L7
    L146:
        ReadableMap r6 = r11.getMap(r2);
        if (((HashMap) this.G1).isEmpty() == true) goto L149;
        ((HashMap) this.G1).clear();
    L149:
        if (r6 == null) goto L7;
        ReadableMapKeySetIterator r7 = r6.keySetIterator();
    L152:
        if (r7.hasNextKey() == false) goto L7;
        String r8 = r7.nextKey();
        ((HashMap) this.G1).put(r8, r6.getString(r8, NameKeys.UnloadStrategy_No_Strategy));
        goto L152
    L154:
        this.g = r11.getBoolean(r2, false);
        goto L7
    L155:
        boolean r9 = r11.getBoolean(r2, false);
        if (r9 == this.p) goto L7;
        this.p = r9;
        this.a |= 64;
        goto L7
    L158:
        String r10 = r11.getString(r2);
        if (TextUtils.equals(r10, this.l) == true) goto L7;
        this.l = r10;
        this.a |= 8;
        goto L7
    L161:
        this.s = r11.getBoolean(r2, true);
        goto L7
    L162:
        this.P1 = r11.getBoolean(r2, false);
        goto L7
    L163:
        r11.getBoolean(r2, false);
        goto L7
    L164:
        this.x1 = r11.getBoolean(r2, false);
        goto L7
    L166:
        if ("fadeIn".equals(r11.getString(r2)) == true) goto L167;
        this.t = 0;
        goto L7
    L167:
        this.t = 300;
        goto L7
    L169:
        String r12 = r11.getString(r2);
        if (TextUtils.equals(r12, this.o) == true) goto L7;
        this.o = r12;
        this.a |= 32;
        goto L7
    L172:
        this.y1 = r11.getBoolean(r2, false);
        goto L7
    L173:
        String r13 = r11.getString(r2);
        if (TextUtils.equals(r13, this.e) == true) goto L7;
        this.e = r13;
        this.a |= 4;
        goto L7
    L176:
        String r14 = r11.getString(r2);
        if (TextUtils.equals(r14, this.l) == true) goto L7;
        this.l = r14;
        this.a |= 8;
        goto L7
    L179:
        u7a.g.b(r11.getDynamic(r2));
        goto L7
    L180:
        Rect r15 = u7a.g.c(r11.getMap(r2));
        if (Objects.equals(r15, this.Q1) == true) goto L7;
        this.Q1 = r15;
        this.a |= 8192;
        goto L7
    L183:
        this.M1 = (float) r11.getDouble(r2, 0.0d);
        goto L7
    L184:
        this.E = (int) n.b(r11.getString(r2), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.b.getScreenMetrics());
        goto L7
    L185:
        boolean r16 = r11.getBoolean(r2, false);
        if (this.w == r16) goto L7;
        this.w = r16;
        this.a |= 256;
        goto L7
    L188:
        u(r11.getString(r2));
        goto L7
    L189:
        v(r11.getString(r2));
        goto L7
    L190:
        this.D = (int) n.b(r11.getString(r2), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.b.getScreenMetrics());
        goto L7
    L191:
        this.F = r11.getBoolean(r2, false);
        goto L7
    L192:
        int r17 = r11.getInt(r2, 0);
        if (r17 <= 0) goto L196;
        r4 = r17;
    L196:
        this.q = r4;
        goto L7
    L197:
        this.H1 = r11.getBoolean(r2, false);
        goto L7
    L198:
        String r18 = r11.getString(r2);
        if (r18 == null) goto L209;
        if (r18.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L209;
        if (r18.equalsIgnoreCase("RGB_565") == true) goto L205;
        if (r18.equalsIgnoreCase("ARGB_8888") == false) goto L7;
        this.r = Bitmap.Config.ARGB_8888;
        goto L7
    L205:
        this.r = Bitmap.Config.RGB_565;
    L209:
        this.r = null;
        goto L7
    L210:
        this.f = r11.getBoolean(r2, false);
        goto L7
    L211:
        this.h = r11.getBoolean(r2, false);
        goto L7
    L213:
        if (r11.getBoolean(r2) == false) goto L215;
        float r19 = 1.0f;
    L216:
        this.M1 = r19;
        goto L7
    L215:
        r19 = 0.0f;
        goto L216
    L217:
        String r20 = r11.getString(r2);
        if (TextUtils.equals(r20, this.m) == true) goto L7;
        this.m = r20;
        this.a |= 8;
        goto L7
    L12:
        if (r2.equals("enable-custom-gif-decoder") == false) goto L135;
        r3 = 30;
        goto L137
    L16:
        if (r2.equals("tint-color") == false) goto L135;
        r3 = 29;
        goto L137
    L20:
        if (r2.equals("additional-custom-info") == false) goto L135;
        r3 = 28;
        goto L137
    L24:
        if (r2.equals("defer-src-invalidation") == false) goto L135;
        r3 = 27;
        goto L137
    L28:
        if (r2.equals("auto-size") == false) goto L135;
        r3 = 26;
        goto L137
    L32:
        if (r2.equals("capInsets") == false) goto L135;
        r3 = 25;
        goto L137
    L36:
        if (r2.equals("autoplay") == false) goto L135;
        r3 = 24;
        goto L137
    L40:
        if (r2.equals("android-cache-key-path-only") == false) goto L135;
        r3 = 23;
        goto L137
    L44:
        if (r2.equals("disable-default-placeholder") == false) goto L135;
        r3 = 22;
        goto L137
    L48:
        if (r2.equals("android-enable-smooth-animation") == false) goto L135;
        r3 = 21;
        goto L137
    L52:
        if (r2.equals("image-transition-style") == false) goto L135;
        r3 = 20;
        goto L137
    L56:
        if (r2.equals("blur-radius") == false) goto L135;
        r3 = 19;
        goto L137
    L60:
        if (r2.equals("progressive-rendering") == false) goto L135;
        r3 = 18;
        goto L137
    L64:
        if (r2.equals("placeholder") == false) goto L135;
        r3 = 17;
        goto L137
    L68:
        if (r2.equals("cap-insets") == false) goto L135;
        r3 = 16;
        goto L137
    L72:
        if (r2.equals("local-cache") == false) goto L135;
        r3 = 15;
        goto L137
    L76:
        if (r2.equals("region-to-decode") == false) goto L135;
        r3 = 14;
        goto L137
    L80:
        if (r2.equals("super-resolution-scale") == false) goto L135;
        r3 = 13;
        goto L137
    L84:
        if (r2.equals("prefetch-height") == false) goto L135;
        r3 = 12;
        goto L137
    L88:
        if (r2.equals("async-request") == false) goto L135;
        r3 = 11;
        goto L137
    L92:
        if (r2.equals("mode") == false) goto L135;
        r3 = 10;
        goto L137
    L96:
        if (r2.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L135;
        r3 = 9;
        goto L137
    L100:
        if (r2.equals("prefetch-width") == false) goto L135;
        r3 = 8;
        goto L137
    L104:
        if (r2.equals("disable-default-resize") == false) goto L135;
        r3 = 7;
        goto L137
    L108:
        if (r2.equals("loop-count") == false) goto L135;
        r3 = 6;
        goto L137
    L112:
        if (r2.equals("enable-report-info") == false) goto L135;
        r3 = 5;
        goto L137
    L116:
        if (r2.equals("image-config") == false) goto L135;
        r3 = 4;
        goto L137
    L120:
        if (r2.equals("skip-redirection") == false) goto L135;
        r3 = 3;
        goto L137
    L124:
        if (r2.equals("enable-resource-hint") == false) goto L135;
        r3 = 2;
        goto L137
    L128:
        if (r2.equals("enable-super-resolution") == false) goto L135;
        r3 = 1;
        goto L137
    L132:
        if (r2.equals("cap-insets-scale") == false) goto L135;
        r3 = 0;
        goto L137
    L220:
        B();
        TraceEvent.endSection("LynxImageManager.updatePropertiesInterval");
    }

    public final void b(j r5) {
        Rect r0 = new Rect(0, 0, this.B, this.C);
        r0.left = (int) ((r0.left + this.I) + this.x);
        r0.top = (int) ((r0.top + this.K) + this.y);
        r0.right = (int) ((r0.right - this.J) - this.z);
        r0.bottom = (int) ((r0.bottom - this.L) - this.A);
        if (r5 == null) goto L6;
        r5.setBounds(r0);
        return;
    }

    public final boolean g(long r4) {
        if ((r4 & this.a) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(Canvas r8) {
        this.V1.b();
        r8.save();
        BackgroundDrawable.RoundRectPath r0 = this.p1;
        if (r0 == null) goto L7;
        Path r1 = r0.c;
        if (r1 == null) goto L7;
        r8.clipPath(r1);
    L7:
        j r2 = this.k;
        if (r2 == null) goto L10;
        r2.draw(r8);
    L10:
        j r3 = this.j;
        if (r3 != null) goto L14;
    L23:
        r8.restore();
        return;
    L14:
        if (this.u >= 0) goto L16;
    L22:
        r3.draw(r8);
        goto L23
    L16:
        if (this.t <= 0) goto L22;
        long r4 = SystemClock.uptimeMillis() - this.u;
        long r5 = this.t;
        if (r4 < r5) goto L21;
        this.u = -1;
        this.j.setAlpha(255);
        this.j.draw(r8);
        goto L23
    L21:
        this.j.setAlpha((int) ((r4 * 255) / r5));
        this.j.draw(r8);
        this.j.setAlpha(255);
        f();
        goto L23
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r1) {
        UIThreadUtils.runOnUiThreadImmediately(new d(this));
    }

    public final void n(Callback r7) {
        j r0 = this.j;
        if (r0 == null) goto L14;
        d7a.c r4 = this.c;
        u7a.a r1 = r0.f;
        if (r1 == null) goto L7;
        Drawable r2 = r1.c;
    L9:
        if (r4.b == true) goto L11;
        boolean r3 = r4.a.pauseAnimation(r2);
    L12:
        if (r3 == false) goto L14;
        r7.invoke(new Object[]{0, "Animation paused."});
        return;
    L11:
        r3 = false;
        goto L12
    L7:
        r2 = null;
    L14:
        r7.invoke(new Object[]{4, "Not support pause yet"});
    }

    public final void o(j r3) {
        if (r3 == null) goto L7;
        d7a.c r0 = this.c;
        Drawable r4 = r3.getCurrent();
        if (r0.b == true) goto L8;
        r0.a.releaseAnimDrawable(r4);
        return;
    L8:
        return;
    }

    public final void p(v7a.f r3) {
        if (r3 == null) goto L8;
        d7a.c r0 = this.c;
        if (r0.b == true) goto L7;
        r0.a.releaseImage(r3);
        return;
    L7:
        throw null;
    }

    public final void r(Callback r7) {
        j r0 = this.j;
        if (r0 == null) goto L14;
        d7a.c r4 = this.c;
        u7a.a r1 = r0.f;
        if (r1 == null) goto L7;
        Drawable r2 = r1.c;
    L9:
        if (r4.b == true) goto L11;
        boolean r3 = r4.a.resumeAnimation(r2);
    L12:
        if (r3 == false) goto L14;
        r7.invoke(new Object[]{0, "Animation resumed."});
        return;
    L11:
        r3 = false;
        goto L12
    L7:
        r2 = null;
    L14:
        r7.invoke(new Object[]{4, "Not support resume yet"});
    }

    public final void s(RectF r9) {
        this.N = r9;
        float r0 = r9.top;
        float r1 = r9.bottom;
        float r2 = r9.left;
        float r10 = r9.right;
        if (this.K == r0) goto L6;
        this.K = r0;
        this.a |= 1024;
    L6:
        if (this.I == r2) goto L9;
        this.I = r2;
        this.a |= 1024;
    L9:
        if (this.J == r10) goto L12;
        this.J = r10;
        this.a |= 1024;
    L12:
        if (this.L == r1) goto L15;
        this.L = r1;
        this.a |= 1024;
        return;
    }

    public final void t(Map<String, EventsListener> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.Z = false;
        this.k0 = false;
        this.p0 = false;
        this.H0 = false;
        this.L0 = false;
        if (r3.containsKey("startplay") == false) goto L8;
        this.Z = true;
    L8:
        if (r3.containsKey("currentloopcomplete") == false) goto L11;
        this.k0 = true;
    L11:
        if (r3.containsKey("finalloopcomplete") == false) goto L14;
        this.p0 = true;
    L14:
        if (r3.containsKey("load") == false) goto L17;
        this.H0 = true;
    L17:
        if (r3.containsKey("error") == false) goto L20;
        this.L0 = true;
        return;
    }

    public final void u(String r5) {
        if ("aspectFit".equals(r5) == false) goto L6;
        u7a.m.b r6 = u7a.m.b.b;
    L13:
        if (Objects.equals(r6, this.n) == true) goto L16;
        this.n = r6;
        this.a |= 16;
        return;
    L16:
        return;
    L6:
        if ("aspectFill".equals(r5) == false) goto L9;
        r6 = u7a.m.b.d;
        goto L13
    L9:
        if ("center".equals(r5) == false) goto L11;
        r6 = u7a.m.b.c;
        goto L13
    L11:
        r6 = u7a.m.b.a;
        goto L13
    }

    public final void v(String r5) {
        if (TextUtils.equals(r5, this.d) == true) goto L6;
        this.d = r5;
        this.a |= 2;
        return;
    }

    public final void w(Callback r7) {
        j r0 = this.j;
        if (r0 == null) goto L14;
        d7a.c r4 = this.c;
        u7a.a r1 = r0.f;
        if (r1 == null) goto L7;
        Drawable r2 = r1.c;
    L9:
        if (r4.b == true) goto L11;
        boolean r3 = r4.a.startAnimation(r2);
    L12:
        if (r3 == false) goto L14;
        r7.invoke(new Object[]{0, "Animation started."});
        return;
    L11:
        r3 = false;
        goto L12
    L7:
        r2 = null;
    L14:
        r7.invoke(new Object[]{4, "Not support start yet"});
    }

    public final void x(Callback r7) {
        j r0 = this.j;
        if (r0 == null) goto L14;
        d7a.c r4 = this.c;
        u7a.a r1 = r0.f;
        if (r1 == null) goto L7;
        Drawable r2 = r1.c;
    L9:
        if (r4.b == true) goto L11;
        boolean r3 = r4.a.stopAnimation(r2);
    L12:
        if (r3 == false) goto L14;
        r7.invoke(new Object[]{0, "Animation stopped."});
        return;
    L11:
        r3 = false;
        goto L12
    L7:
        r2 = null;
    L14:
        r7.invoke(new Object[]{4, "Not support stop yet"});
    }

    public final void y(x6a.j r5) {
        if (r5 != null) goto L4;
    L15:
        this.p1 = null;
        return;
    L4:
        if (r5.c == false) goto L15;
        BackgroundDrawable.RoundRectPath r0 = new BackgroundDrawable.RoundRectPath();
        this.p1 = r0;
        Rect r1 = r5.a();
        float[] r6 = r5.b;
        if (r0.a != null) goto L9;
        r0.a = new RectF();
    L9:
        RectF r2 = r0.a;
        r2.left = r1.left;
        r2.top = r1.top;
        r2.right = r1.right;
        r2.bottom = r1.bottom;
        r0.b = r6;
        r0.d = BackgroundDrawable.RoundRectPath.a(r6);
        Path r7 = r0.c;
        if (r7 != null) goto L12;
        r0.c = new Path();
    L13:
        r0.c.addRoundRect(r0.a, r0.b, Path.Direction.CW);
        return;
    L12:
        r7.reset();
        goto L13
    }

    public static void a(f r2, String r3) {
        LynxBaseUI r0 = r2.T;
        if (r0 == null) goto L5;
        int r1 = r0.getSign();
    L7:
        if (r2.b == null) goto L11;
        if (r1 < 0) goto L12;
        m7a.a r4 = new m7a.a(r1, r3);
        r2.b.getEventEmitter().sendCustomEvent(r4);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = r2.V0;
        goto L7
    }

    public void k(int r4, int r5) {
        int r0 = this.P0;
        if (r0 < 0) goto L8;
        boolean r1 = true;
        if ((r0 & 1) != 0) goto L9;
        r1 = false;
    L9:
        if (r1 == false) goto L21;
        LynxBaseUI r2 = this.T;
        if (r2 == null) goto L13;
        int r3 = r2.getSign();
    L15:
        if (this.b == null) goto L22;
        if (r3 >= 0) goto L18;
        return;
    L18:
        if (this.H1 == true) goto L24;
        m7a.a r6 = new m7a.a(r3, "load");
        r6.a("height", Integer.valueOf(r5));
        r6.a("width", Integer.valueOf(r4));
        this.b.getEventEmitter().sendCustomEvent(r6);
        return;
    L24:
        return;
    L22:
        return;
    L13:
        r3 = this.V0;
        goto L15
    L21:
        return;
    L8:
        r1 = this.H0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r1, Runnable r2) {
        UIThreadUtils.removeCallbacks(r2, r1);
    }

    public final v7a.f c(int r9, int r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return null;
    L6:
        v7a.g r0 = new v7a.g();
        r0.a = r11;
        r0.b = r9;
        r0.c = r10;
        r0.d = this.q;
        r0.n = this.b.getFrescoCallerContext();
        r0.k = this.s;
        if (this.F == false) goto L9;
    L11:
        boolean r12 = false;
    L12:
        r0.l = r12;
        r0.j = this.w;
        r0.f = this.i;
        r0.m = this.h;
        r0.q = this.x1;
        r0.r = this.y1;
        r0.s = this.H1;
        r0.t = this.P1;
        float r13 = this.M1;
        if (r13 <= 0.0f) goto L16;
        r0.u = r13;
    L16:
        if (((HashMap) this.G1).isEmpty() == true) goto L19;
        r0.g = this.G1;
    L21:
        Bitmap.Config r14 = this.r;
        if (r14 == null) goto L25;
        r0.e = r14;
    L25:
        if (this.b.getEnableImageSmallDiskCache() == false) goto L28;
        r0.h = 1;
    L28:
        if (TextUtils.isEmpty(this.o) == true) goto L32;
        float r15 = n.b(this.o, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.b.getScreenMetrics());
        if (r15 <= 0.0f) goto L32;
        v7a.c r16 = new v7a.c((int) r15);
        ArrayList r17 = new ArrayList();
        r17.add(r16);
        r0.i = r17;
    L32:
        Rect r18 = this.Q1;
        if (r18 == null) goto L36;
        r0.v = r18;
    L36:
        return new v7a.f(r0);
    L19:
        if (this.b.getImageCustomParam() == null) goto L21;
        r0.g = this.b.getImageCustomParam();
        goto L21
    L9:
        if (this.p == true) goto L11;
        r12 = true;
        goto L12
    }

    public void j(LynxError r4, int r5, int r6) {
        LynxBaseUI r0 = this.T;
        if (r0 == null) goto L5;
        int r1 = r0.getSign();
    L7:
        if (this.b == null) goto L26;
        if (r1 < 0) goto L28;
        LynxBaseUI r2 = this.T;
        if (r2 == null) goto L13;
        r4.addCustomInfo("node_index", Integer.toString(r2.getNodeIndex()));
    L13:
        int r3 = this.P0;
        if (r3 >= 0) goto L16;
        boolean r7 = this.L0;
    L20:
        if (r7 == false) goto L23;
        m7a.a r8 = new m7a.a(r1, "error");
        r8.a("errMsg", r4.getSummaryMessage() + ": " + r4.getRootCause());
        r8.a("lynx_categorized_code", Integer.valueOf(r5));
        r8.a("error_code", Integer.valueOf(r6));
        this.b.getEventEmitter().sendCustomEvent(r8);
    L23:
        if (this.T == null) goto L27;
        r4.addCustomInfo(LynxError.LYNX_ERROR_KEY_IMAGE_CATEGORIZED_CODE, String.valueOf(r5));
        this.b.reportResourceError(this.d, "image", r4);
        return;
    L27:
        return;
    L16:
        if ((r3 & 2) == 0) goto L18;
        r7 = true;
        goto L20
    L18:
        r7 = false;
        goto L20
    L28:
        return;
    L26:
        return;
    L5:
        r1 = this.V0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        UIThreadUtils.runOnUiThreadAtTime(r2, r1, r3);
    }

    public final void l(int r8, int r9, int r10, int r11, int r12, int r13) {
        if (r8 > 0) goto L5;
        if (r9 > 0) goto L5;
        return;
    L5:
        int r0 = this.B;
        if (r8 == r0) goto L8;
    L9:
        if (r8 <= r0) goto L11;
    L12:
        this.a |= 2048;
    L13:
        this.B = r8;
        this.C = r9;
        this.a |= 512;
    L15:
        if (this.y == r12) goto L17;
    L22:
        this.y = r12;
        this.z = r11;
        this.x = r10;
        this.A = r13;
        this.a |= 512;
        return;
    L17:
        if (this.z != r11) goto L22;
        if (this.A != r13) goto L22;
        if (this.x != r10) goto L22;
        return;
    L11:
        if (r9 <= this.C) goto L13;
    L8:
        if (r9 == this.C) goto L15;
        goto L9
    }

    public final void q(String r15, int r16, boolean r17, int r18, long r19, long r21, boolean r23, int r24, int r25) {
        if (this.L1 == false) goto L9;
        if (r15 != null) goto L6;
        return;
    L6:
        if (r15.startsWith("http") == false) goto L11;
        u7a.f.c(this.b, r15, r16, r17, r18, r19, r21, r23, r24, r25, this.G1);
        return;
    L11:
        return;
    }
}
