package r3;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.s;
import com.bytedance.applog.params.CommonParamsWrapper;
import com.google.protobuf.DescriptorProtos;
import com.obric.cae.cloud.ttnet.AppConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import x4.b0;
import x4.i0;
import x4.o0;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f {
    public static final CopyOnWriteArrayList N = null;
    public static final AtomicInteger O = null;
    public volatile j A;
    public final b4.b B;
    public volatile boolean C;
    public volatile ConcurrentHashMap<String, String> D;
    public volatile boolean E;
    public volatile boolean F;
    public final a G;
    public final c4.m H;
    public final AtomicBoolean I;
    public final CopyOnWriteArrayList J;
    public final v3.c K;
    public final t3.a L;
    public final s M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b4.c f11393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b4.a f11394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d4.a f11395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u3.a f11396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q4.a f11397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r6.d f11398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Application f11402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile d4.c f11403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile d4.d f11404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile y3.c f11405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final v3.a f11406n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f11407o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public v4.a f11408p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f11409q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final u3.e f11410r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f11411s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicInteger f11412t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f11413u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f11414v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile int f11415w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final qd.a f11416x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i4.f f11417y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Long f11418z;

    public class a extends c4.b {
        public a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            return new CommonParamsWrapper(String.valueOf(hashCode()));
        }
    }

    static {
        System.currentTimeMillis();
        N = new CopyOnWriteArrayList();
        O = new AtomicInteger(0);
    }

    public c() {
        this.f11393a = new b4.c();
        this.f11394b = new b4.a();
        this.f11400h = 0;
        this.f11401i = "";
        this.f11402j = null;
        this.f11409q = true;
        this.f11411s = true;
        this.f11412t = new AtomicInteger(0);
        this.f11413u = true;
        new HashSet();
        this.f11414v = false;
        this.f11415w = 8;
        this.f11416x = new qd.a(3);
        this.C = true;
        this.D = new ConcurrentHashMap();
        this.E = true;
        this.F = true;
        this.G = new a();
        this.I = new AtomicBoolean(false);
        this.J = new CopyOnWriteArrayList();
        this.L = new t3.a();
        this.M = new s(5);
        this.f11399g = O.getAndIncrement();
        this.H = new c4.m();
        this.f11397e = new q4.a(this);
        this.B = new b4.b(this);
        this.f11396d = new u3.a(this);
        this.f11398f = new r6.d(this);
        N.add(this);
        this.f11395c = new d4.a(this);
        this.f11410r = new u3.e(this);
        this.f11406n = new v3.a(this);
        this.f11417y = new i4.f();
        this.K = new v3.c();
    }

    public final String a(Application r8, String r10) {
        o0 r11 = o0.f13536b;
        StringBuilder r12 = new StringBuilder(r10);
        x4.j r13 = (x4.j) this.f11410r.b();
        r13.getClass();
        boolean r14 = true;
        if (r13 != x4.h.f13430b) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L9;
    L12:
        if (r14 == true) goto L16;
        return null;
    L16:
        return r13.f13458h.a(r8, r12, r11);
    L9:
        if (r13.f13451a != null) goto L12;
        r14 = false;
        goto L12
    L5:
        r15 = false;
        goto L6
    }

    public final String b() {
        if (this.f11404l == null) goto L9;
        d4.c r8 = this.f11404l.f6777d;
        if (r8.f6770n != null) goto L8;
        r8.f6770n = r8.f6759c.getString("ab_sdk_version", "");
    L8:
        return r8.f6770n;
    L9:
        return null;
    }

    public final String c() {
        u3.e r8 = this.f11410r;
        if (TextUtils.isEmpty(r8.f12443h) == false) goto L19;
        x4.j r10 = (x4.j) r8.b();
        if (r10.f13451a != null) goto L7;
    L10:
        int r11 = r.f13543a;
        Context r12 = r10.a();
        if (r12 != null) goto L13;
        i0 r13 = null;
    L14:
        if (r13 != null) goto L16;
        String r14 = null;
    L17:
        r8.f12443h = r14;
        goto L19
    L16:
        r14 = r13.f13443a;
        goto L17
    L13:
        r13 = r10.f13461k.b(new Object[]{r12});
        goto L14
    L7:
        if (r10.f13451a.f13465c == null) goto L10;
        r14 = ((i5.b) r10.f13457g.b(new Object[]{r10.f13451a.f13465c})).h();
    L19:
        return r8.f12443h;
    }

    public final int d() {
        return this.f11412t.get();
    }

    public final m e() {
        if (this.f11403k != null) goto L7;
        return null;
    L7:
        return this.f11403k.f6758b;
    }

    public final b0 f() {
        b0 r8 = this.f11403k.f6758b.f11434j;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return this.f11398f;
    }

    public final String g() {
        if (this.f11404l == null) goto L14;
        d4.d r8 = this.f11404l;
        if (r8.f6775b == true) goto L15;
        d4.c r10 = r8.f6777d;
        if (r10 != null) goto L10;
        return "";
    L10:
        if (r10.f6771o != null) goto L13;
        r10.f6771o = r10.f6759c.getString("user_unique_id", "");
    L13:
        return r10.f6771o;
    L15:
        return r8.f6778e.optString("user_unique_id", "");
    L14:
        return "";
    }

    public final void h(Context r14, m r15) {
        monitor-enter(c.class);
    L58:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r15.f11425a) == true) goto L57;
        if (b.c(r15.f11425a) == true) goto L55;
        this.H.s(r15.f11425a);     // Catch: Throwable -> L58
        this.f11401i = r15.f11425a;     // Catch: Throwable -> L58
        this.f11402j = (Application) r14.getApplicationContext();     // Catch: Throwable -> L58
        if (r15.f11438n == true) goto L11;
    L13:
        this.H.g(0, null, "App:{} init begin...", new Object[]{this.f11401i});     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r15.f11437m) == false) goto L19;
        String r16 = b.b(this, "applog_stats");     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r16) == true) goto L19;
        r15.f11437m = r16;     // Catch: Throwable -> L58
    L19:
        if (c4.l.b() == true) goto L22;
        c4.l.c("init_begin", new d(this, r15));     // Catch: Throwable -> L58
    L22:
        this.f11403k = new d4.c(this, this.f11402j, r15);     // Catch: Throwable -> L58
        if (this.A != null) goto L25;
        this.A = new androidx.room.h(this, this.f11403k);     // Catch: Throwable -> L58
    L25:
        this.f11404l = new d4.d(this, this.f11403k, this.f11410r);     // Catch: Throwable -> L58
        this.f11405m = new y3.c(this, this.f11403k, this.f11404l, this.f11410r, this.f11395c, this.L);     // Catch: Throwable -> L58
        if (r15.f11436l == false) goto L28;
        this.f11402j.registerActivityLifecycleCallbacks(this.f11406n);     // Catch: Throwable -> L58
    L28:
        this.f11400h = 1;     // Catch: Throwable -> L58
        this.f11407o = r15.f11426b;     // Catch: Throwable -> L58
        if (this.f11418z == null) goto L39;
        long r8 = this.f11418z.longValue();     // Catch: Throwable -> L58
        if (this.f11405m != null) goto L33;
    L37:
        this.f11418z = Long.valueOf(r8);     // Catch: Throwable -> L58
    L38:
        this.f11418z = null;     // Catch: Throwable -> L58
        goto L39
    L33:
        if (this.f11405m.f13945u == null) goto L37;
        if (this.f11405m.f13945u.f13975a == r8) goto L38;
        this.f11405m.f13945u.f13975a = r8;     // Catch: Throwable -> L58
    L39:
        this.f11417y.h(1, "congestion_enable");     // Catch: Throwable -> L58
        if (r15.f11436l == false) goto L42;
        this.f11417y.h(1, "handle_lifecycle_enable");     // Catch: Throwable -> L58
    L42:
        String r17 = this.f11401i;     // Catch: Throwable -> L58
        if (c4.l.b() == false) goto L45;
    L48:
        this.H.g(0, null, "App:{} init end.", new Object[]{this.f11401i});     // Catch: Throwable -> L58
        d4.c r13 = this.f11403k;     // Catch: Throwable -> L58
        r13.getClass();     // Catch: Throwable -> L58
        if (c4.l.b() == true) goto L52;
        c4.l.c("remote_settings", new d4.b(r13));     // Catch: Throwable -> L58
    L52:
        monitor-exit(c.class);     // Catch: Throwable -> L58
        return;
    L45:
        if (v4.i.g("init_end") == true) goto L48;
        ((c4.e) c4.e.f3331o.b(new Object[0])).a(r17, c4.l.e("init_end"));     // Catch: Throwable -> L58
        goto L48
    L11:
        if (this.I.compareAndSet(false, true) == false) goto L13;
        c4.j.f3348b.put(this.f11401i, new c4.d(this));     // Catch: Throwable -> L58
        goto L13
    L55:
        throw new IllegalStateException("The app id is init already!");     // Catch: Throwable -> L58
    L57:
        throw new IllegalStateException("App id must not be empty!");     // Catch: Throwable -> L58
    }

    public final boolean i() {
        m r8 = e();
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.f11438n;
    }

    public final void j(String r8, String r10) {
        if (TextUtils.isEmpty("event_v1") == false) goto L5;
    L9:
        this.H.b("category or tag is empty", new Object[0]);
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L9;
        l(new r4.c(this.f11401i, r8, r10, m(i4.j.f8241m, r8, r10, null)));
    }

    public final void k(String r8, JSONObject r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        this.H.b("event name is empty", new Object[0]);
        return;
    L5:
        l(new r4.e(this.f11401i, r8, m(i4.j.f8240b, r8, null, r10), 0));
    }

    public final void l(r4.a r19) {
        r19.f11461w = this.f11401i;
        this.K.getClass();
        r19.E = null;
        if ((r19 instanceof r4.e) == false) goto L5;
    L8:
        this.f11417y.b(i4.k.f8247a, 1);
        int r8 = l6.a.S(this.f11417y, r19);
        r19.C = r8;
        if (r8 <= 0) goto L11;
        l6.a.P0(this.f11417y, i4.a.f8139o, r19);
    L11:
        b4.a r10 = this.f11394b;
        if (r10.a(1) == false) goto L99;
    L26:
        long r11 = 0;
        if (this.f11405m != null) goto L46;
        d4.a r12 = this.f11395c;
        LinkedList<r4.a> r13 = r12.f6751a;
        monitor-enter(r13);
    L43:
        th = move-exception;
        throw th;
    L31:
        if (r12.f6751a.size() <= r12.f6753c) goto L38;
        r4.a r14 = r12.f6751a.poll();     // Catch: Throwable -> L43
        if (r14 == null) goto L38;
        if (r14.C <= 0) goto L37;
        l6.a.P0(r12.f6754d.f11417y, i4.a.f8141q, r19);     // Catch: Throwable -> L43
    L37:
        r12.f6754d.f11417y.b(i4.k.f8270v, 1);     // Catch: Throwable -> L43
        r12.f6754d.f11417y.g("cache drop event", new Throwable(r14.toString()));     // Catch: Throwable -> L43
        r12.f6754d.H.f(0, d4.a.f6750e, "AppLogCache overflow remove data: {}", new Object[]{r14});     // Catch: Throwable -> L43
    L38:
        r12.f6751a.add(r19);     // Catch: Throwable -> L43
        monitor-exit(r13);     // Catch: Throwable -> L43
        if (r19.C <= 0) goto L80;
        l6.a.P0(this.f11417y, i4.a.f8140p, r19);
    L80:
        String r15 = r19.g();
        if (v4.i.h(r15) == false) goto L83;
        r11 = 0 + ((long) r15.length());
    L83:
        String r16 = r19.f();
        if (v4.i.h(r16) == false) goto L87;
        r11 = r11 + ((long) r16.length());
    L87:
        if (r11 <= 1048576) goto L89;
        this.f11417y.g("receive data too big (>1MB)", new Throwable(r19.toString()));
    L89:
        c4.l.d(r19, "event_receive");
        return;
    L46:
        y3.c r17 = this.f11405m;
        r17.getClass();
        if (r19.f11450b != 0) goto L49;
        r17.f13937m.H.i(y3.c.G, "receive zero ts", null, new Object[0]);
    L49:
        ArrayList<r4.a> r18 = r17.f13940p;
        monitor-enter(r18);
        int r20 = r17.f13940p.size();     // Catch: Throwable -> L91
        r17.f13940p.add(r19);     // Catch: Throwable -> L91
        monitor-exit(r18);     // Catch: Throwable -> L91
        if (r19.C <= 0) goto L56;
        l6.a.P0(r17.f13937m.f11417y, i4.a.f8142r, r19);
    L56:
        boolean r21 = r19 instanceof r4.j;
        r17.f13937m.getClass();
        if ((r20 % 5) == 0) goto L59;
        if (r21 == true) goto L59;
    L66:
        if (r19.C <= 0) goto L68;
        l6.a.P0(r17.f13937m.f11417y, i4.a.f8143s, r19);
    L68:
        if (r21 == false) goto L80;
        v3.b r22 = r17.D;
        r22.getClass();
        long r23 = ((r4.j) r19).H;
        Handler r24 = r22.f12712b;
        if (r23 <= 0) goto L72;
        r24.sendEmptyMessageDelayed(DescriptorProtos.Edition.EDITION_UNSTABLE_VALUE, 500);
        r22.f12714n = Math.max(0, r22.f12714n - 1);
        goto L80
    L72:
        r24.removeMessages(DescriptorProtos.Edition.EDITION_UNSTABLE_VALUE);
        r22.f12714n++;
        boolean r25 = r22.f12713m;
        c r26 = r22.f12711a;
        if (r25 == false) goto L76;
        r22.f12713m = false;
        r26.H.e("App first to frontend...", new Object[0]);
    L76:
        if (r22.f12715o == false) goto L80;
        r22.f12715o = false;
        r26.H.e("App back to frontend...", new Object[0]);
        if (r26.e() == null) goto L80;
        r26.e().getClass();
    L59:
        r17.f13947w.removeMessages(4);
        if (r20 != 0) goto L64;
        if (r21 == true) goto L64;
        r17.f13947w.sendEmptyMessageDelayed(4, 200);
    L64:
        r17.f13947w.sendEmptyMessage(4);
    L91:
        th = move-exception;
        throw th;
    L99:
    L24:
        th = move-exception;
        this.H.k(th, 4, "notify event observer before receive failed", new Object[0]);
        this.f11417y.g("notify event observer before receive failed", th);
        goto L26
    L15:
        if ((r19 instanceof r4.c) == false) goto L18;
        r4.c r27 = (r4.c) r19;     // Catch: Throwable -> L24
        this.f11394b.b(1, r27.L, r27.M, r27.H, r27.I, r27.J, r27.K);     // Catch: Throwable -> L24
    L98:
        goto L26
    L18:
        if ((r19 instanceof r4.e) == false) goto L21;
        r4.e r28 = (r4.e) r19;     // Catch: Throwable -> L24
        r10.c(1, r28.J, r28.H);     // Catch: Throwable -> L24
        goto L98
    L21:
        if ((r19 instanceof r4.d) == false) goto L98;
        r4.d r29 = (r4.d) r19;     // Catch: Throwable -> L24
        r10.d(1, r29.I, r29.H);     // Catch: Throwable -> L24
        goto L98
    L5:
        if ((r19 instanceof r4.c) == true) goto L8;
        if ((r19 instanceof r4.d) == false) goto L11;
        goto L8
    }

    public final String m(i4.j r13, String r14, String r15, JSONObject r16) {
        i4.f r8 = this.f11417y;
        if (r16 != null) goto L48;
        return null;
    L48:
        return r16.toString();
    L7:
        th = move-exception;
        c4.m r10 = this.H;
        r10.i(null, defpackage.b.e("event toString failed ", r14, ", label: ", r15), th, new Object[0]);
        JSONObject r11 = v4.i.e(r16);
        if (r11 == null) goto L45;
        m r12 = e();
        if (r12 != null) goto L13;
    L15:
        boolean r17 = false;
    L50:
    L54:
        return r11.toString();
    L27:
        e = move-exception;
        r8.b(i4.k.P, 1);
        if (r17 == true) goto L31;
        r10.i(null, defpackage.b.e("event toString OOM tag: ", r14, ", label: ", r15), e, new Object[0]);
        return null;
    L31:
        if (r8.e(r14) == false) goto L34;
        this.f11417y.k(i4.a.f8138n, r14, String.valueOf(i4.h.f8231a.incrementAndGet()), System.currentTimeMillis(), i4.j.f8240b);
    L34:
        throw new RuntimeException(defpackage.b.e("event toString OOM tag: ", r14, ", label: ", r15), e);
    L18:
        e = move-exception;
        r8.b(i4.k.W, 1);
        if (r17 == true) goto L22;
        r10.i(null, defpackage.b.e("event toString stack overflow tag: ", r14, ", label: ", r15), e, new Object[0]);
        return null;
    L22:
        if (r8.e(r14) == false) goto L25;
        this.f11417y.k(i4.a.f8138n, r14, String.valueOf(i4.h.f8231a.incrementAndGet()), System.currentTimeMillis(), r13);
    L25:
        throw new RuntimeException(defpackage.b.e("event toString stack overflow tag: ", r14, ", label: ", r15), e);
    L36:
        r8.b(i4.k.V, 1);
        return r11.toString();
    L39:
        th = move-exception;
        if (r8.e(r14) == false) goto L44;
        this.f11417y.k(i4.a.f8138n, r14, String.valueOf(i4.h.f8231a.incrementAndGet()), System.currentTimeMillis(), r13);
    L44:
        throw new RuntimeException(defpackage.b.e("event params exception tag: ", r14, ", label: ", r15), th);
    L13:
        if (AppConstants.CHANNEL_NAME.equalsIgnoreCase(r12.f11427c) == false) goto L15;
        r17 = true;
        goto L50
    L45:
        return null;
    }

    public final String toString() {
        return "AppLogInstance{id:" + this.f11399g + ";appId:" + this.f11401i + "}@" + hashCode();
    }
}
