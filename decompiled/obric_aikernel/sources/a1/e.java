package a1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.common.utility.NetworkUtils;
import f1.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import l1.f;
import l1.h;
import l1.i;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final List<String> f57t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static a f58u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f59a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f60b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f61c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f62d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f63e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f64f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f65g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h f66h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f67i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicLong f68j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f69k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f70l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f71m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f72n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f73o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f74p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f75q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile String f76r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile long f77s;

    static class a extends i {
        a() {
        }
    }

    static {
        f57t = Collections.singletonList("Session");
    }

    e(c r10) {
        this.f60b = 0;
        this.f61c = 0;
        this.f62d = 0;
        this.f63e = 0;
        this.f68j = new AtomicLong(1000);
        this.f71m = -1;
        this.f64f = r10;
        this.f77s = r10.v().t();
    }

    public static String c() {
        return UUID.randomUUID().toString();
    }

    static a h() {
        if (f58u != null) goto L5;
        f58u = new a();
    L5:
        f58u.x(0);
        return f58u;
    }

    static boolean l(l1.a r10) {
        if ((r10 instanceof h) == true) goto L5;
        return false;
    L5:
        return ((h) r10).G();
    }

    public void a(l1.a r10) {
        if (r10 == null) goto L5;
        b(r10, this.f59a);
        r10.u(this.f64f.s().getAppId());
        r10.f10833l = this.f64f.s().W();
        r10.f10830i = this.f67i;
        r10.f10829h = m();
        r10.f10835n = NetworkUtils.f(this.f64f.w()).getValue();
        return;
    }

    public void b(l1.a r10, long r11) {
        IBDAccountCallback r12 = this.f64f.s().t();
        if (this.f64f.s().D() == false) goto L11;
        if (r12 == null) goto L11;
        Pair<Integer, Long> r13 = r12.getOdinUserInfo();
        if (((Long) r13.second).longValue() <= 0) goto L9;
        r10.f10831j = ((Long) r13.second).longValue();
        r10.f10837p = 1;
        r10.f10838q = 1;
        r10.f10836o = ((Integer) r13.first).intValue();
        r10.f10832k = ((Long) r13.second).longValue();
    L12:
        r10.f10834m = this.f64f.s().n(String.valueOf(r10.f10831j));
        return;
    L9:
        if (this.f62d != 0) goto L12;
        r10.f10832k = this.f60b;
        r10.f10836o = this.f61c;
        r10.f10837p = this.f62d;
        r10.f10838q = this.f63e;
    L11:
        r10.f10831j = r11;
        goto L12
    }

    public String d() {
        return this.f67i;
    }

    public String e() {
        return this.f76r;
    }

    public long f() {
        return this.f77s;
    }

    synchronized Bundle g(long r10, long r11) {
        monitor-enter(this);
        Bundle r12 = null;
        long r13 = this.f69k;     // Catch: Throwable -> L15
        if (this.f64f.v().F() == true) goto L7;
    L13:
        monitor-exit(this);
        return r12;
    L7:
        if (k() == false) goto L13;
        if (r13 <= 0) goto L13;
        long r14 = r10 - r13;     // Catch: Throwable -> L15
        if (r14 <= r11) goto L13;
        r12 = new Bundle();     // Catch: Throwable -> L15
        r12.putInt("session_no", this.f74p);     // Catch: Throwable -> L15
        int r15 = this.f70l + 1;     // Catch: Throwable -> L15
        this.f70l = r15;     // Catch: Throwable -> L15
        r12.putInt("send_times", r15);     // Catch: Throwable -> L15
        r12.putLong("current_duration", r14 / 1000);     // Catch: Throwable -> L15
        r12.putString("session_start_time", l1.a.f(this.f71m));     // Catch: Throwable -> L15
        this.f69k = r10;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public long i() {
        return this.f59a;
    }

    public boolean j() {
        return this.f72n;
    }

    boolean k() {
        if (j() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f73o != 0) goto L7;
        return true;
    }

    public long m() {
        return this.f68j.incrementAndGet();
    }

    public boolean n(l1.a r18, ArrayList<l1.a> r19) {
        boolean r10 = r18 instanceof h;
        boolean r11 = l(r18);
        boolean r12 = true;
        if (this.f71m != (-1)) goto L7;
        this.f64f.s().P().o(f57t, "session process start session 1, data=" + r18 + ", isResume=" + r11, new Object[0]);
        r11 = l(r18);
    L5:
        p(r18, r19, r11);
    L19:
        if (r10 == false) goto L43;
        h r13 = (h) r18;
        if (r13.G() == false) goto L34;
        this.f73o = 0;
        r19.add(r18);
        if (TextUtils.isEmpty(r13.A) == false) goto L45;
        h r14 = this.f66h;
        if (r14 != null) goto L27;
    L29:
        r14 = this.f65g;
        if (r14 == null) goto L45;
        if (((r13.f10828g - r14.f10828g) - r14.f10865z) >= 500) goto L45;
    L28:
        r13.A = r14.B;
        goto L45
    L27:
        if (((r13.f10828g - r14.f10828g) - r14.f10865z) >= 500) goto L29;
    L45:
        a(r18);
        return r12;
    L34:
        Bundle r15 = g(r18.f10828g, 0);
        if (this.f64f.s() == null) goto L38;
        if (r15 == null) goto L38;
        this.f64f.s().n0("play_session", r15);
    L38:
        this.f73o = r13.f10828g;
        r19.add(r18);
        if (r13.F() == false) goto L41;
        this.f65g = r13;
        goto L45
    L41:
        this.f66h = r13;
        this.f65g = null;
        goto L45
    L43:
        if ((r18 instanceof a) == true) goto L45;
        r19.add(r18);
        goto L45
    L7:
        if (this.f72n == true) goto L10;
        if (r11 == false) goto L10;
        this.f64f.s().P().o(f57t, "session process start session 2, data=" + r18 + ", isResume=" + r11, new Object[0]);
        p(r18, r19, true);
    L10:
        long r16 = this.f73o;
        if (r16 == 0) goto L16;
        if (r18.f10828g <= (r16 + this.f64f.t())) goto L16;
        this.f64f.s().P().o(f57t, "session process start session 3, data=" + r18 + ", isResume=" + r11, new Object[0]);
    L16:
        if (this.f71m <= (r18.f10828g + 7200000)) goto L18;
        this.f64f.s().P().o(f57t, "session process start session 4, data=" + r18 + ", isResume=" + r11, new Object[0]);
        goto L5
    L18:
        r12 = false;
        goto L19
    }

    public void o(long r10) {
        this.f59a = r10;
    }

    synchronized f p(l1.a r10, ArrayList<l1.a> r11, boolean r12) {
        monitor-enter(this);
        if (r10 != null) goto L47;
        long r13 = 0;
    L10:
        this.f67i = c();     // Catch: Throwable -> L44
        if (r12 == false) goto L17;
        this.f77s = r13;     // Catch: Throwable -> L44
        this.f64f.v().O(this.f77s);     // Catch: Throwable -> L44
        if (this.f64f.f32v == true) goto L17;
        if (TextUtils.isEmpty(this.f76r) == false) goto L17;
        this.f76r = this.f67i;     // Catch: Throwable -> L44
    L17:
        this.f68j.set(WorkRequest.MIN_BACKOFF_MILLIS);     // Catch: Throwable -> L44
        this.f71m = r13;     // Catch: Throwable -> L44
        this.f72n = r12;     // Catch: Throwable -> L44
        this.f73o = 0;     // Catch: Throwable -> L44
        this.f69k = 0;     // Catch: Throwable -> L44
        boolean r14 = true;
        if (r12 == false) goto L27;
        Calendar r15 = Calendar.getInstance();     // Catch: Throwable -> L44
        String r16 = "" + r15.get(1) + r15.get(2) + r15.get(5);     // Catch: Throwable -> L44
        g1.b r17 = this.f64f.v();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(this.f75q) == false) goto L23;
        this.f75q = r17.s();     // Catch: Throwable -> L44
        this.f74p = r17.y();     // Catch: Throwable -> L44
    L23:
        if (r16.equals(this.f75q) == true) goto L25;
        this.f75q = r16;     // Catch: Throwable -> L44
        this.f74p = 1;     // Catch: Throwable -> L44
    L26:
        r17.N(r16, this.f74p);     // Catch: Throwable -> L44
        this.f70l = 0;     // Catch: Throwable -> L44
        this.f69k = r13;     // Catch: Throwable -> L44
        goto L27
    L25:
        this.f74p++;     // Catch: Throwable -> L44
    L27:
        f r18 = null;
        if (r13 == (-1)) goto L35;
        r18 = new f();     // Catch: Throwable -> L44
        r18.u(this.f64f.s().getAppId());     // Catch: Throwable -> L44
        r18.f10830i = this.f67i;     // Catch: Throwable -> L44
        if (this.f72n == false) goto L33;
        r14 = false;
    L33:
        r18.B = r14;     // Catch: Throwable -> L44
        r18.f10829h = m();     // Catch: Throwable -> L44
        r18.x(this.f71m);     // Catch: Throwable -> L44
        r18.A = this.f64f.y().i();     // Catch: Throwable -> L44
        r18.f10860z = this.f64f.y().h();     // Catch: Throwable -> L44
        b(r18, this.f59a);     // Catch: Throwable -> L44
        r18.f10833l = this.f64f.s().W();     // Catch: Throwable -> L44
        r11.add(r18);     // Catch: Throwable -> L44
        this.f64f.s().M().a(r18.f10830i, r18.f10828g, r18.B);     // Catch: Throwable -> L44
    L35:
        if (this.f64f.s().L() > 0) goto L37;
        this.f64f.s().s0(6);     // Catch: Throwable -> L44
    L37:
        g r19 = this.f64f.s().P();     // Catch: Throwable -> L44
        List<String> r20 = f57t;     // Catch: Throwable -> L44
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L44
        r21.append("startSession, ");     // Catch: Throwable -> L44
        if (this.f72n == false) goto L40;
        String r22 = "fg";
    L41:
        r21.append(r22);     // Catch: Throwable -> L44
        r21.append(", ");     // Catch: Throwable -> L44
        r21.append(this.f67i);     // Catch: Throwable -> L44
        r21.append(", ");     // Catch: Throwable -> L44
        r21.append(r13);     // Catch: Throwable -> L44
        r19.t(r20, r21.toString(), new Object[0]);     // Catch: Throwable -> L44
        monitor-exit(this);
        return r18;
    L44:
        th = move-exception;
        throw th;
    L40:
        r22 = "bg";
        goto L41
    L47:
        if ((r10 instanceof a) == false) goto L8;
        r13 = -1;
        goto L10
    L8:
        r13 = r10.f10828g;     // Catch: Throwable -> L44
        goto L10
    }
}
