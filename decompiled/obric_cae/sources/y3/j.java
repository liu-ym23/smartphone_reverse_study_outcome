package y3;

import android.app.Application;
import android.text.TextUtils;
import c4.m;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import r4.k;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<String> f13970n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13971o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicInteger f13972p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile boolean f13973q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static a f13974r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f13975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f13976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r4.j f13977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r4.j f13978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f13979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f13980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f13982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f13985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile String f13986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f13987m;

    public static class a extends k {
    }

    static {
        f13970n = Collections.singletonList("Session");
        f13971o = UUID.randomUUID().toString();
        f13972p = new AtomicInteger(0);
        f13973q = true;
    }

    public j(c r8) {
        this.f13980f = new AtomicLong(1000);
        this.f13981g = -1;
        this.f13976b = r8;
        this.f13987m = r8.f13938n.f6760d.getLong("latest_forground_session_time", 0);
    }

    public static String c() {
        if (f13973q == false) goto L6;
        String r8 = f13971o + "#" + f13972p.getAndIncrement();
        m.u().e("Session:genSessionId#: {}", new Object[]{r8});
        return r8;
    L6:
        String r10 = UUID.randomUUID().toString();
        m.u().e("Session:genSessionId: {}", new Object[]{r10});
        return r10;
    }

    public final void a(r4.a r8) {
        if (r8 == null) goto L8;
        b(r8, this.f13975a);
        r3.c r10 = this.f13976b.f13937m;
        r8.f11461w = r10.f11401i;
        r8.f11455q = r10.g();
        r8.f11452n = this.f13979e;
        r8.f11451m = this.f13980f.incrementAndGet();
        Application r11 = this.f13976b.f13937m.f11402j;
        r5.e.a(r11);
        if ((System.currentTimeMillis() - r5.e.f11505d) <= r5.e.f11504c) goto L6;
        r5.e.f11502a = r5.e.d(r11);
        r5.e.f11505d = System.currentTimeMillis();
    L6:
        r8.f11457s = r5.e.f11502a.f11519a;
        return;
    }

    public final void b(r4.a r8, long r10) {
        c r11 = this.f13976b;
        r11.f13937m.getClass();
        r11.f13937m.getClass();
        r8.f11453o = r10;
        r3.c r12 = r11.f13937m;
        String.valueOf(r10);
        r8.f11456r = r12.b();
    }

    public final synchronized r4.g d(r4.a r17, ArrayList<r4.a> r18, boolean r19) {
        monitor-enter(this);
        long r8 = 0;
        if (r17 != null) goto L64;
        long r10 = 0;
    L13:
        this.f13979e = c();     // Catch: Throwable -> L10
        if (r19 == false) goto L18;
        this.f13987m = r10;     // Catch: Throwable -> L10
        d4.c r11 = this.f13976b.f13938n;     // Catch: Throwable -> L10
        r11.f6760d.edit().putLong("latest_forground_session_time", this.f13987m).apply();     // Catch: Throwable -> L10
        this.f13976b.getClass();     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(this.f13986l) == false) goto L18;
        this.f13986l = this.f13979e;     // Catch: Throwable -> L10
    L18:
        this.f13980f.set(10000);     // Catch: Throwable -> L10
        this.f13981g = r10;     // Catch: Throwable -> L10
        this.f13982h = r19;     // Catch: Throwable -> L10
        this.f13983i = 0;     // Catch: Throwable -> L10
        if (r19 == false) goto L29;
        Calendar r12 = Calendar.getInstance();     // Catch: Throwable -> L10
        String r13 = "" + r12.get(1) + r12.get(2) + r12.get(5);     // Catch: Throwable -> L10
        d4.c r14 = this.f13976b.f13938n;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(this.f13985k) == false) goto L24;
        this.f13985k = r14.f6760d.getString("session_last_day", "");     // Catch: Throwable -> L10
        this.f13984j = r14.f6760d.getInt("session_order", 0);     // Catch: Throwable -> L10
    L24:
        if (r13.equals(this.f13985k) == true) goto L26;
        this.f13985k = r13;     // Catch: Throwable -> L10
        this.f13984j = 1;     // Catch: Throwable -> L10
    L27:
        r14.f6760d.edit().putString("session_last_day", r13).putInt("session_order", this.f13984j).apply();     // Catch: Throwable -> L10
        goto L29
    L26:
        this.f13984j++;     // Catch: Throwable -> L10
    L29:
        if (r10 == (-1)) goto L51;
        r4.g r15 = new r4.g();     // Catch: Throwable -> L10
        r15.f11461w = this.f13976b.f13937m.f11401i;     // Catch: Throwable -> L10
        r15.f11452n = this.f13979e;     // Catch: Throwable -> L10
        if (this.f13982h == true) goto L33;
        boolean r16 = true;
    L34:
        r15.J = r16;     // Catch: Throwable -> L10
        r15.f11451m = this.f13980f.incrementAndGet();     // Catch: Throwable -> L10
        r15.l(this.f13981g);     // Catch: Throwable -> L10
        j0 r20 = ((u3.e) this.f13976b.f13942r.f6774a).f12437b;     // Catch: Throwable -> L10
        if (r20 == null) goto L37;
        String r21 = r20.c();     // Catch: Throwable -> L10
    L38:
        r15.I = r21;     // Catch: Throwable -> L10
        j0 r22 = ((u3.e) this.f13976b.f13942r.f6774a).f12437b;     // Catch: Throwable -> L10
        if (r22 == null) goto L41;
        r8 = r22.d();     // Catch: Throwable -> L10
    L41:
        r15.H = r8;     // Catch: Throwable -> L10
        b(r15, this.f13975a);     // Catch: Throwable -> L10
        r15.f11455q = this.f13976b.f13937m.g();     // Catch: Throwable -> L10
        r15.C = l6.a.S(this.f13976b.f13937m.f11417y, r15);     // Catch: Throwable -> L10
        if ((r17 instanceof r4.j) == false) goto L44;
        r15.L = ((r4.j) r17).M;     // Catch: Throwable -> L10
    L44:
        this.f13976b.f13937m.getClass();     // Catch: Throwable -> L10
        r18.add(r15);     // Catch: Throwable -> L10
        if (r15.C <= 0) goto L47;
        l6.a.P0(this.f13976b.f13937m.f11417y, i4.a.f8137m, r15);     // Catch: Throwable -> L10
    L47:
        this.f13976b.f13937m.f11417y.b(i4.k.f8249b, 1);     // Catch: Throwable -> L10
        if (this.f13982h == false) goto L50;
        this.f13976b.f13937m.f11417y.b(i4.k.f8260m, 1);     // Catch: Throwable -> L10
    L50:
        this.f13976b.f13937m.B.a(r15.f11450b, r15.f11452n, r15.J);     // Catch: Throwable -> L10
    L52:
        r3.c r23 = this.f13976b.f13937m;     // Catch: Throwable -> L10
        if (r23.f11400h > 0) goto L55;
        r23.f11400h = 6;     // Catch: Throwable -> L10
    L55:
        m r24 = r23.H;     // Catch: Throwable -> L10
        List<String> r25 = f13970n;     // Catch: Throwable -> L10
        StringBuilder r26 = new StringBuilder("startSession, ");     // Catch: Throwable -> L10
        if (this.f13982h == false) goto L58;
        String r27 = "fg";
    L59:
        r26.append(r27);     // Catch: Throwable -> L10
        r26.append(", ");     // Catch: Throwable -> L10
        r26.append(this.f13979e);     // Catch: Throwable -> L10
        r26.append(", ");     // Catch: Throwable -> L10
        r26.append(r10);     // Catch: Throwable -> L10
        r24.g(0, r25, r26.toString(), new Object[0]);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r15;
    L10:
        th = move-exception;
        throw th;
    L58:
        r27 = "bg";
        goto L59
    L37:
        r21 = "";
        goto L38
    L33:
        r16 = false;
        goto L34
    L51:
        r15 = null;
        goto L52
    L64:
        if ((r17 instanceof a) == false) goto L9;
        r10 = -1;
        goto L13
    L9:
        r10 = r17.f11450b;     // Catch: Throwable -> L10
        goto L13
    }
}
