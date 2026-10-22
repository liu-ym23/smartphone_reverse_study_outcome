package com.bytedance.apm.trace.fps;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import y.e;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Long f1062u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Long f1063v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static t.b f1064w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t.b.d f1067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.apm.trace.fps.b.g f1068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.trace.fps.b.h f1069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile com.bytedance.apm.trace.fps.b.f f1070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile com.bytedance.apm.trace.fps.b.i f1071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile com.bytedance.apm.trace.fps.b.e f1072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinkedList<Integer> f1073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HashMap<String, String> f1074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f1075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f1076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f1077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f1078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f1079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f1080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private C0040c f1081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private WindowManager f1082r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f1083s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final JSONObject f1084t;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f1085c;

        a(c r10) {
            this.f1085c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.a(this.f1085c) == false) goto L6;
            c.l(this.f1085c).invalidate();
            c.l(this.f1085c).postDelayed(this, 10);
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f1086c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f1087g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ t.b.d f1088h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f1089i;

        b(c r10, List r11, Map r12, t.b.d r13) {
            this.f1089i = r10;
            this.f1086c = r11;
            this.f1087g = r12;
            this.f1088h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
        L50:
            e = move-exception;
            if (d.D() == false) goto L67;
            e.printStackTrace();
            return;
        L67:
            return;
        L4:
            if (j.b(this.f1086c) == false) goto L6;
            return;
        L6:
            float r10 = g.c();     // Catch: Exception -> L50
            int r11 = g.e();     // Catch: Exception -> L50
            int r12 = r11 - 1;     // Catch: Exception -> L50
            int r13 = (r12 + 0) + 1;     // Catch: Exception -> L50
            int[] r14 = new int[r13];     // Catch: Exception -> L50
            int[] r15 = new int[r13];     // Catch: Exception -> L50
            Iterator r16 = this.f1086c.iterator();     // Catch: Exception -> L50
            int r17 = 0;
            int r18 = 0;
            int r19 = 0;
            int r110 = 0;
        L8:
            if (r16.hasNext() == false) goto L16;
            Integer r111 = (Integer) r16.next();     // Catch: Exception -> L50
            int r112 = c.n(r111.intValue(), r10);     // Catch: Exception -> L50
            if (r112 <= 0) goto L12;
            r18 = r18 + r112;     // Catch: Exception -> L50
        L12:
            int[] r113 = r14;
            if (r111.intValue() < 833.0d) goto L15;
            r19 = r19 + (r111.intValue() / 100);     // Catch: Exception -> L50
        L15:
            int r20 = Math.max(Math.min(r112, r12), r17);     // Catch: Exception -> L50
            r113[r20] = r113[r20] + 1;     // Catch: Exception -> L50
            r15[r20] = (int) (((double) r15[r20]) + (((double) r111.intValue()) / 100.0d));     // Catch: Exception -> L50
            r110 = r110 + (r111.intValue() / 100);     // Catch: Exception -> L50
            r14 = r113;
            r18 = r18;
            r17 = 0;
            goto L8
        L16:
            int[] r114 = r14;
            int r21 = ((this.f1086c.size() * 100) * r11) / (this.f1086c.size() + r18);     // Catch: Exception -> L50
            this.f1087g.put("report_list_size", Integer.toString(this.f1086c.size()));     // Catch: Exception -> L50
            c.o(this.f1089i, this.f1087g, (float) (((double) r21) / 100.0d));     // Catch: Exception -> L50
            int r22 = (int) ((this.f1086c.size() + r18) * r10);     // Catch: Exception -> L50
            JSONObject r23 = new JSONObject();     // Catch: Exception -> L50
            int r24 = 0;
        L17:
            if (r24 > r12) goto L22;
            if (r114[r24] <= 0) goto L21;
            r23.put(String.valueOf(r24), r114[r24]);     // Catch: Exception -> L50
            int r25 = r114[r24];     // Catch: Exception -> L50
        L21:
            r24 = r24 + 1;     // Catch: Exception -> L50
            goto L17
        L22:
            JSONObject r26 = new JSONObject();     // Catch: Exception -> L50
            int r27 = 0;
        L23:
            if (r27 > r12) goto L29;
            if (r15[r27] <= 0.1d) goto L27;
            r26.put(String.valueOf(r27), r15[r27]);     // Catch: Exception -> L50
        L27:
            r27 = r27 + 1;     // Catch: Exception -> L50
            goto L23
        L29:
            if (c.p(this.f1089i) == null) goto L32;
            c.p(this.f1089i).a(i.b(r23));     // Catch: Exception -> L50
        L32:
            if (c.q(this.f1089i) == null) goto L35;
            com.bytedance.apm.trace.fps.b.e r28 = c.q(this.f1089i);     // Catch: Exception -> L50
            t.b.d r29 = this.f1088h;     // Catch: Exception -> L50
            r28.a(r29.f12823c, r29.f12822b);     // Catch: Exception -> L50
        L35:
            if (c.r(this.f1089i) == null) goto L37;
            c.r(this.f1089i).a(i.b(r26), r22);     // Catch: Exception -> L50
        L37:
            JSONObject r30 = new JSONObject();     // Catch: Exception -> L50
            r30.put("scene", c.s(this.f1089i));     // Catch: Exception -> L50
            JSONObject r31 = new JSONObject();     // Catch: Exception -> L50
            r31.put("total_scroll_time", r110);     // Catch: Exception -> L50
            r31.put("dur", r22);     // Catch: Exception -> L50
            r31.put("hitch_dur_dic", r26);     // Catch: Exception -> L50
            r31.put("hitch_dur", r19);     // Catch: Exception -> L50
            r31.put("velocity", c.b(this.f1089i) + "," + c.c(this.f1089i));     // Catch: Exception -> L50
            r31.put("distance", c.d(this.f1089i) + "," + c.e(this.f1089i));     // Catch: Exception -> L50
            r31.put("frame_count", this.f1086c.size());     // Catch: Exception -> L50
            r31.put("drop_count", r18);     // Catch: Exception -> L50
            if (c.f(this.f1089i) == null) goto L40;
            r31.put(WsConstants.KEY_EXTRA, c.f(this.f1089i));     // Catch: Exception -> L50
        L40:
            r31.put("drop_time_rate", 1.0f - ((this.f1086c.size() * 1.0f) / ((int) (r110 / r10))));     // Catch: Exception -> L50
            e r32 = new e("fps_drop", c.s(this.f1089i), r23, r30, r31);     // Catch: Exception -> L50
            CommonDataAssembly.wrapFilters(r32, true);     // Catch: Exception -> L50
            r32.f13620f.put("refresh_rate", r11);     // Catch: Exception -> L50
            Map r33 = this.f1087g;     // Catch: Exception -> L50
            if (r33 != null) goto L43;
        L48:
            x.a.p().e(r32);     // Catch: Exception -> L50
            return;
        L43:
            if (r33.isEmpty() == true) goto L48;
            Iterator r34 = this.f1087g.entrySet().iterator();     // Catch: Exception -> L50
        L46:
            if (r34.hasNext() == false) goto L48;
            Map.Entry r35 = (Map.Entry) r34.next();     // Catch: Exception -> L50
            r32.f13620f.put((String) r35.getKey(), r35.getValue());     // Catch: Exception -> L50
            goto L46
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.c$c, reason: collision with other inner class name */
    private class C0040c extends View {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1090c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1091g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f1092h;

        public C0040c(c r10, Context r11) {
            this.f1092h = r10;
            super(r11);
            this.f1090c = -1;
            this.f1091g = 0;
        }

        static /* synthetic */ long a(C0040c r10, long r11) {
            r10.f1090c = r11;
            return r11;
        }

        static /* synthetic */ int b(C0040c r10, int r11) {
            r10.f1091g = r11;
            return r11;
        }

        @Override // android.view.View
        protected void onDraw(Canvas r10) {
            if (this.f1090c != (-1)) goto L5;
            this.f1090c = SystemClock.elapsedRealtime();
            int r11 = 0;
        L6:
            this.f1091g = r11;
            if (c.g(this.f1092h) == null) goto L9;
            c.g(this.f1092h).a(SystemClock.elapsedRealtime());
        L9:
            long r12 = SystemClock.elapsedRealtime() - this.f1090c;
            if (r12 <= c.h().longValue()) goto L16;
            double r13 = (((double) this.f1091g) / r12) * c.i().longValue();
            if (c.j(this.f1092h) == null) goto L14;
            c.j(this.f1092h).a(r13);
        L14:
            com.bytedance.apm.trace.fps.a.c().b(c.k(this.f1092h), c.s(this.f1092h), (float) r13);
            c.m(this.f1092h);
            return;
        L16:
            return;
        L5:
            r11 = this.f1091g + 1;
            goto L6
        }
    }

    static {
        f1062u = 200L;
        f1063v = 1000L;
    }

    public c(String r10, boolean r11, JSONObject r12) {
        this.f1066b = false;
        this.f1067c = new t.b.d();
        this.f1069e = null;
        this.f1074j = new HashMap();
        this.f1075k = 0.0f;
        this.f1076l = 0.0f;
        this.f1077m = 0.0f;
        this.f1078n = 0.0f;
        this.f1079o = 0;
        this.f1080p = 0;
        this.f1081q = null;
        this.f1082r = null;
        this.f1065a = r10;
        this.f1083s = r11;
        this.f1084t = r12;
        this.f1073i = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L6;
        this.f1082r = (WindowManager) d.g().getSystemService("window");
        this.f1081q = new C0040c(this, d.g());
        return;
    }

    private boolean A() {
        return o0.c.d("fps_drop", this.f1065a);
    }

    private boolean C() {
        return o0.c.d("fps", this.f1065a);
    }

    private void D() {
        this.f1075k = 0.0f;
        this.f1076l = 0.0f;
        this.f1077m = 0.0f;
        this.f1078n = 0.0f;
        this.f1079o = 0;
    }

    public static void F(t.b r10) {
        f1064w = r10;
    }

    @TargetApi(16)
    private void I() {
        if (f1064w == null) goto L6;
        this.f1066b = true;
        f1064w.k(this);
        return;
    }

    private void J() {
        C0040c.a(this.f1081q, -1);
        WindowManager.LayoutParams r10 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r10.gravity = 51;
        r10.flags = 24;
        r10.height = 1;
        r10.width = 1;
        this.f1082r.removeView(this.f1081q);     // Catch: Exception -> L6
    L4:
        this.f1082r.addView(this.f1081q, r10);
        this.f1081q.postDelayed(new a(this), 10);
    }

    static /* synthetic */ boolean a(c r10) {
        return r10.f1066b;
    }

    static /* synthetic */ float b(c r10) {
        return r10.f1075k;
    }

    static /* synthetic */ float c(c r10) {
        return r10.f1076l;
    }

    static /* synthetic */ float d(c r10) {
        return r10.f1077m;
    }

    static /* synthetic */ float e(c r10) {
        return r10.f1078n;
    }

    static /* synthetic */ JSONObject f(c r10) {
        return r10.f1084t;
    }

    static /* synthetic */ com.bytedance.apm.trace.fps.b.h g(c r10) {
        return r10.f1069e;
    }

    static /* synthetic */ Long h() {
        return f1062u;
    }

    static /* synthetic */ Long i() {
        return f1063v;
    }

    static /* synthetic */ com.bytedance.apm.trace.fps.b.g j(c r10) {
        return r10.f1068d;
    }

    static /* synthetic */ HashMap k(c r10) {
        return r10.f1074j;
    }

    static /* synthetic */ C0040c l(c r10) {
        return r10.f1081q;
    }

    static /* synthetic */ void m(c r10) {
        r10.y();
    }

    static /* synthetic */ int n(int r10, float r11) {
        return z(r10, r11);
    }

    static /* synthetic */ void o(c r10, Map r11, float r12) {
        r10.t(r11, r12);
    }

    static /* synthetic */ com.bytedance.apm.trace.fps.b.f p(c r10) {
        return r10.f1070f;
    }

    static /* synthetic */ com.bytedance.apm.trace.fps.b.e q(c r10) {
        return r10.f1072h;
    }

    static /* synthetic */ com.bytedance.apm.trace.fps.b.i r(c r10) {
        return r10.f1071g;
    }

    static /* synthetic */ String s(c r10) {
        return r10.f1065a;
    }

    private void t(Map<String, String> r10, float r11) {
        com.bytedance.apm.trace.fps.b.g r12 = this.f1068d;
        if (r12 == null) goto L5;
        r12.a(r11);
    L5:
        com.bytedance.apm.trace.fps.a.c().b(r10, this.f1065a, r11);
    }

    private void w(long r10, long r11) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1073i.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        int r12 = (this.f1080p > 0 ? 1 : (this.f1080p == 0 ? 0 : -1));
        this.f1080p = 0;     // Catch: Throwable -> L11
        LinkedList<Integer> r13 = this.f1073i;     // Catch: Throwable -> L11
        this.f1073i = new LinkedList();     // Catch: Throwable -> L11
        t.b.d r14 = this.f1067c;     // Catch: Throwable -> L11
        this.f1067c = new t.b.d();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        HashMap r15 = new HashMap();
        r15.putAll(this.f1074j);
        q0.b.f().i(new b(this, r13, r15, r14));
    }

    @TargetApi(16)
    private void x() {
        t.b r10 = f1064w;
        if (r10 == null) goto L9;
        r10.n(this);
        if (this.f1066b == true) goto L7;
        return;
    L7:
        w(this.f1079o, SystemClock.uptimeMillis());
        this.f1066b = false;
        return;
    }

    private void y() {
        if (this.f1066b == true) goto L10;
        return;
    L10:
        this.f1082r.removeView(this.f1081q);     // Catch: Exception -> L9
        C0040c.a(this.f1081q, -1);     // Catch: Exception -> L9
        C0040c.b(this.f1081q, 0);     // Catch: Exception -> L9
    L7:
        this.f1066b = false;
    }

    private static int z(int r10, float r11) {
        return r10 / ((int) (r11 * 100.0f));
    }

    public boolean B() {
        if (t.e.B().F() == false) goto L13;
        if (d.K() == true) goto L7;
        return false;
    L7:
        if (A() == true) goto L11;
        if (C() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (d.K() == true) goto L19;
        if (A() == true) goto L19;
        if (C() == true) goto L19;
        return false;
    L19:
        return true;
    }

    public void E(com.bytedance.apm.trace.fps.b.f r10) {
        this.f1070f = r10;
    }

    public void G(com.bytedance.apm.trace.fps.b.g r10) {
        this.f1068d = r10;
    }

    public void H() {
        if (this.f1066b == false) goto L6;
        return;
    L6:
        if (this.f1083s == false) goto L8;
    L10:
        D();
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        J();
    L14:
        this.f1079o = SystemClock.uptimeMillis();
        this.f1066b = true;
        return;
    L13:
        I();
        com.bytedance.apm.trace.fps.b.w(this.f1065a);
        goto L14
    L8:
        if (B() == true) goto L10;
    }

    public synchronized void K() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        monitor-exit(this);
        return;
    L8:
        x();     // Catch: Throwable -> L11
        com.bytedance.apm.trace.fps.b.H(this.f1065a);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void u(long r10, boolean r11) {
        this.f1067c.a(r10, r11);
    }

    public void v(long r10) {
        if (r10 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f1073i.size() <= 20000) goto L9;
        this.f1073i.poll();     // Catch: Throwable -> L12
    L9:
        this.f1073i.add(Integer.valueOf(((int) r10) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }
}
