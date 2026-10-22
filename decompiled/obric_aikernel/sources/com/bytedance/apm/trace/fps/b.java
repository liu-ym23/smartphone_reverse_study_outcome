package com.bytedance.apm.trace.fps;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static boolean f1032u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Long f1033v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Long f1034w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f1037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f1038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.trace.fps.c f1039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f1040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Choreographer.FrameCallback f1041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinkedList<Integer> f1042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private HashMap<String, String> f1043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f1044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f1045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f1046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f1047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d f1048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private WindowManager f1049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final JSONObject f1051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f1052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f1053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f1054t;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f1055c;

        a(b r10) {
            this.f1055c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.a(this.f1055c) == false) goto L6;
            b.l(this.f1055c).invalidate();
            b.l(this.f1055c).postDelayed(this, 10);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.b$b, reason: collision with other inner class name */
    class ChoreographerFrameCallbackC0039b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f1056c;

        ChoreographerFrameCallbackC0039b(b r10) {
            this.f1056c = r10;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r10) {
            if (b.o(this.f1056c) != (-1)) goto L6;
            b.p(this.f1056c, r10);
        L6:
            if (b.q(this.f1056c) == null) goto L8;
            b.q(this.f1056c).a(r10 / TimeUtils.NANOSECONDS_PER_MILLISECOND);
        L8:
            b.r(this.f1056c);
            if (b.a(this.f1056c) == false) goto L11;
            Choreographer.getInstance().postFrameCallback(this);
        L11:
            b r11 = this.f1056c;
            b.u(r11, b.s(r11), r10);
            b.t(this.f1056c, r10);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f1057c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f1058g;

        c(b r10, List r11) {
            this.f1058g = r10;
            this.f1057c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
        L24:
            e = move-exception;
            if (com.bytedance.apm.d.D() == false) goto L35;
            e.printStackTrace();
            return;
        L35:
            return;
        L4:
            if (j.b(this.f1057c) == false) goto L6;
            return;
        L6:
            float r10 = com.bytedance.apm.util.g.c();     // Catch: Exception -> L24
            int r11 = com.bytedance.apm.util.g.e();     // Catch: Exception -> L24
            int r12 = r11 - 1;     // Catch: Exception -> L24
            int[] r13 = new int[(r12 + 0) + 1];     // Catch: Exception -> L24
            Iterator r14 = this.f1057c.iterator();     // Catch: Exception -> L24
            int r15 = 0;
            int r16 = 0;
        L8:
            if (r14.hasNext() == false) goto L10;
            Integer r17 = (Integer) r14.next();     // Catch: Exception -> L24
            int r18 = Math.max(Math.min(b.v(r17.intValue(), r10), r12), 0);     // Catch: Exception -> L24
            r13[r18] = r13[r18] + 1;     // Catch: Exception -> L24
            r16 = r16 + (r17.intValue() / 100);     // Catch: Exception -> L24
            goto L8
        L10:
            JSONObject r19 = new JSONObject();     // Catch: Exception -> L24
        L11:
            if (r15 > r12) goto L17;
            if (r13[r15] <= 0) goto L15;
            r19.put(String.valueOf(r15), r13[r15]);     // Catch: Exception -> L24
        L15:
            r15 = r15 + 1;     // Catch: Exception -> L24
            goto L11
        L17:
            if (b.b(this.f1058g) == null) goto L19;
            b.b(this.f1058g).a(com.bytedance.apm.util.i.b(r19));     // Catch: Exception -> L24
        L19:
            JSONObject r110 = new JSONObject();     // Catch: Exception -> L24
            r110.put("scene", b.c(this.f1058g));     // Catch: Exception -> L24
            JSONObject r111 = new JSONObject();     // Catch: Exception -> L24
            r111.put("total_scroll_time", r16);     // Catch: Exception -> L24
            r111.put("velocity", b.d(this.f1058g) + "," + b.e(this.f1058g));     // Catch: Exception -> L24
            r111.put("distance", b.f(this.f1058g) + "," + b.g(this.f1058g));     // Catch: Exception -> L24
            if (b.h(this.f1058g) == null) goto L22;
            r111.put(WsConstants.KEY_EXTRA, b.h(this.f1058g));     // Catch: Exception -> L24
        L22:
            r111.put("drop_time_rate", 1.0f - ((this.f1057c.size() * 1.0f) / ((int) (r16 / r10))));     // Catch: Exception -> L24
            y.e r20 = new y.e("fps_drop", b.c(this.f1058g), r19, r110, r111);     // Catch: Exception -> L24
            CommonDataAssembly.wrapFilters(r20, true);     // Catch: Exception -> L24
            r20.f13620f.put("refresh_rate", r11);     // Catch: Exception -> L24
            x.a.p().e(r20);     // Catch: Exception -> L24
        }
    }

    private class d extends View {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1059c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f1061h;

        public d(b r10, Context r11) {
            this.f1061h = r10;
            super(r11);
            this.f1059c = -1;
            this.f1060g = 0;
        }

        static /* synthetic */ long a(d r10, long r11) {
            r10.f1059c = r11;
            return r11;
        }

        static /* synthetic */ int b(d r10, int r11) {
            r10.f1060g = r11;
            return r11;
        }

        @Override // android.view.View
        protected void onDraw(Canvas r10) {
            if (this.f1059c != (-1)) goto L5;
            this.f1059c = SystemClock.elapsedRealtime();
            int r11 = 0;
        L6:
            this.f1060g = r11;
            if (b.q(this.f1061h) == null) goto L9;
            b.q(this.f1061h).a(SystemClock.elapsedRealtime());
        L9:
            long r12 = SystemClock.elapsedRealtime() - this.f1059c;
            if (r12 <= b.i().longValue()) goto L16;
            double r13 = (((double) this.f1060g) / r12) * b.j().longValue();
            if (b.k(this.f1061h) == null) goto L14;
            b.k(this.f1061h).a(r13);
        L14:
            com.bytedance.apm.trace.fps.a.c().b(b.m(this.f1061h), b.c(this.f1061h), (float) r13);
            b.n(this.f1061h);
            return;
        L16:
            return;
        L5:
            r11 = this.f1060g + 1;
            goto L6
        }
    }

    public interface e {
        void a(long r10, int r11);
    }

    public interface f {
        void a(JSONObject r10);
    }

    public interface g {
        void a(double r10);
    }

    public interface h {
        void a(long r10);
    }

    public interface i {
        void a(JSONObject r10, int r11);
    }

    static {
        f1033v = 200L;
        f1034w = 1000L;
    }

    public b(String r10, boolean r11) {
        this(r10, r11, null);
    }

    public b(String r10, boolean r11, JSONObject r12) {
        this.f1036b = false;
        this.f1040f = null;
        this.f1043i = new HashMap();
        this.f1044j = 0.0f;
        this.f1045k = 0.0f;
        this.f1046l = 0.0f;
        this.f1047m = 0.0f;
        this.f1048n = null;
        this.f1049o = null;
        this.f1052r = -1;
        this.f1053s = -1;
        this.f1054t = 0;
        this.f1051q = r12;
        if (f1032u == false) goto L6;
        this.f1039e = new com.bytedance.apm.trace.fps.c(r10, r11, r12);
        return;
    L6:
        this.f1035a = r10;
        this.f1050p = r11;
        this.f1042h = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L10;
        this.f1049o = (WindowManager) com.bytedance.apm.d.g().getSystemService("window");
        this.f1048n = new d(this, com.bytedance.apm.d.g());
        return;
    }

    @TargetApi(16)
    private void A() {
        if (this.f1036b == true) goto L5;
        return;
    L5:
        x();
        if (this.f1041g == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.f1041g);
    L8:
        z();
        this.f1036b = false;
    }

    private void B() {
        if (this.f1036b == true) goto L10;
        return;
    L10:
        this.f1049o.removeView(this.f1048n);     // Catch: Exception -> L9
        d.a(this.f1048n, -1);     // Catch: Exception -> L9
        d.b(this.f1048n, 0);     // Catch: Exception -> L9
    L7:
        this.f1036b = false;
    }

    private static int C(int r10, float r11) {
        int r12 = (int) (r11 * 100.0f);
        return ((r10 + (r12 - 1)) / r12) - 1;
    }

    public static String D() {
        return com.bytedance.apm.block.h.b();
    }

    private boolean E() {
        return o0.c.d("fps_drop", this.f1035a);
    }

    private boolean G() {
        return o0.c.d("fps", this.f1035a);
    }

    public static void H(String r10) {
        com.bytedance.apm.block.h.c(r10);
    }

    private void I() {
        this.f1044j = 0.0f;
        this.f1045k = 0.0f;
        this.f1046l = 0.0f;
        this.f1047m = 0.0f;
    }

    public static void K(boolean r10) {
        f1032u = r10;
    }

    @TargetApi(16)
    private void N() {
        monitor-enter(this);
        this.f1042h.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        O();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @TargetApi(16)
    private void O() {
        this.f1052r = -1;
        this.f1053s = -1;
        this.f1054t = 0;
        this.f1041g = new ChoreographerFrameCallbackC0039b(this);
        Choreographer.getInstance().postFrameCallback(this.f1041g);     // Catch: Exception -> L5
        return;
    L5:
        this.f1036b = false;
        this.f1052r = -1;
        this.f1053s = -1;
        this.f1054t = 0;
        this.f1041g = null;
    }

    private void P() {
        d.a(this.f1048n, -1);
        WindowManager.LayoutParams r10 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r10.gravity = 51;
        r10.flags = 24;
        r10.height = 1;
        r10.width = 1;
        this.f1049o.removeView(this.f1048n);     // Catch: Exception -> L6
    L4:
        this.f1049o.addView(this.f1048n, r10);
        this.f1048n.postDelayed(new a(this), 10);
    }

    static /* synthetic */ boolean a(b r10) {
        return r10.f1036b;
    }

    static /* synthetic */ f b(b r10) {
        return r10.f1038d;
    }

    static /* synthetic */ String c(b r10) {
        return r10.f1035a;
    }

    static /* synthetic */ float d(b r10) {
        return r10.f1044j;
    }

    static /* synthetic */ float e(b r10) {
        return r10.f1045k;
    }

    static /* synthetic */ float f(b r10) {
        return r10.f1046l;
    }

    static /* synthetic */ float g(b r10) {
        return r10.f1047m;
    }

    static /* synthetic */ JSONObject h(b r10) {
        return r10.f1051q;
    }

    static /* synthetic */ Long i() {
        return f1033v;
    }

    static /* synthetic */ Long j() {
        return f1034w;
    }

    static /* synthetic */ g k(b r10) {
        return r10.f1037c;
    }

    static /* synthetic */ d l(b r10) {
        return r10.f1048n;
    }

    static /* synthetic */ HashMap m(b r10) {
        return r10.f1043i;
    }

    static /* synthetic */ void n(b r10) {
        r10.B();
    }

    static /* synthetic */ long o(b r10) {
        return r10.f1052r;
    }

    static /* synthetic */ long p(b r10, long r11) {
        r10.f1052r = r11;
        return r11;
    }

    static /* synthetic */ h q(b r10) {
        return r10.f1040f;
    }

    static /* synthetic */ int r(b r10) {
        int r11 = r10.f1054t + 1;
        r10.f1054t = r11;
        return r11;
    }

    static /* synthetic */ long s(b r10) {
        return r10.f1053s;
    }

    static /* synthetic */ long t(b r10, long r11) {
        r10.f1053s = r11;
        return r11;
    }

    static /* synthetic */ void u(b r10, long r11, long r12) {
        r10.y(r11, r12);
    }

    static /* synthetic */ int v(int r10, float r11) {
        return C(r10, r11);
    }

    public static void w(String r10) {
        com.bytedance.apm.block.h.a(r10);
    }

    private void x() {
        long r10 = this.f1053s - this.f1052r;
        if (r10 <= 0) goto L12;
        int r11 = this.f1054t;
        if (r11 <= 1) goto L13;
        long r12 = (((((long) (r11 - 1)) * 1000) * 1000) * 1000) / r10;
        g r13 = this.f1037c;
        if (r13 == null) goto L10;
        r13.a(r12);
    L10:
        com.bytedance.apm.trace.fps.a.c().b(this.f1043i, this.f1035a, r12);
        return;
    L13:
        return;
    }

    private void y(long r10, long r11) {
        if (this.f1053s > 0) goto L5;
        return;
    L5:
        long r12 = r11 - r10;
        if ((r12 / TimeUtils.NANOSECONDS_PER_MILLISECOND) > 0) goto L8;
        return;
    L8:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.f1042h.size() <= 20000) goto L12;
        this.f1042h.poll();     // Catch: Throwable -> L15
    L12:
        this.f1042h.add(Integer.valueOf(((int) r12) / 10000));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    private void z() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1042h.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        LinkedList<Integer> r10 = this.f1042h;     // Catch: Throwable -> L11
        this.f1042h = new LinkedList();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        q0.b.f().i(new c(this, r10));
    }

    public boolean F() {
        if (com.bytedance.apm.d.K() == true) goto L5;
    L9:
        return false;
    L5:
        if (E() == false) goto L7;
    L8:
        return true;
    L7:
        if (G() == false) goto L9;
        goto L8
    }

    public void J(f r10) {
        com.bytedance.apm.trace.fps.c r11 = this.f1039e;
        if (r11 == null) goto L5;
        r11.E(r10);
    L5:
        this.f1038d = r10;
    }

    public void L(g r10) {
        com.bytedance.apm.trace.fps.c r11 = this.f1039e;
        if (r11 == null) goto L5;
        r11.G(r10);
    L5:
        this.f1037c = r10;
    }

    public void M() {
        com.bytedance.apm.trace.fps.c r10 = this.f1039e;
        if (r10 == null) goto L7;
        r10.H();
        return;
    L7:
        if (this.f1036b == false) goto L10;
        return;
    L10:
        if (this.f1050p == false) goto L12;
    L14:
        I();
        if (Build.VERSION.SDK_INT >= 16) goto L17;
        P();
    L18:
        this.f1036b = true;
        return;
    L17:
        N();
        w(this.f1035a);
        goto L18
    L12:
        if (F() == true) goto L14;
    }

    public synchronized void Q() {
        monitor-enter(this);
        com.bytedance.apm.trace.fps.c r10 = this.f1039e;     // Catch: Throwable -> L16
        if (r10 == null) goto L10;
        r10.K();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        monitor-exit(this);
        return;
    L13:
        A();     // Catch: Throwable -> L16
        H(this.f1035a);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
