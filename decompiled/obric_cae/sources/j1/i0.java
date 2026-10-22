package j1;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Runnable {
    public static final String C = null;
    public final t1.c<androidx.work.l.a> A;
    public volatile boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8487b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<r> f8488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final WorkerParameters.a f8489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final r1.t f8490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public androidx.work.l f8491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u1.a f8492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public androidx.work.l.a f8493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.work.c f8494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final q1.a f8495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WorkDatabase f8496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r1.u f8497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r1.b f8498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f8499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f8500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final t1.c<Boolean> f8501z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q1.a f8503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final u1.a f8504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.work.c f8505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WorkDatabase f8506e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final r1.t f8507f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<r> f8508g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f8509h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public WorkerParameters.a f8510i;

        public a(Context r8, androidx.work.c r10, u1.a r11, q1.a r12, WorkDatabase r13, r1.t r14, ArrayList r15) {
            this.f8510i = new WorkerParameters.a();
            this.f8502a = r8.getApplicationContext();
            this.f8504c = r11;
            this.f8503b = r12;
            this.f8505d = r10;
            this.f8506e = r13;
            this.f8507f = r14;
            this.f8509h = r15;
        }

        public final i0 a() {
            return new i0(this);
        }

        public final void b(WorkerParameters.a r8) {
            if (r8 == null) goto L5;
            this.f8510i = r8;
            return;
        }

        public final void c(List r8) {
            this.f8508g = r8;
        }
    }

    static {
        C = androidx.work.m.f("WorkerWrapper");
    }

    public i0(a r8) {
        this.f8493r = new androidx.work.l.a.C0025a();
        this.f8501z = new t1.c();
        this.A = new t1.c();
        this.f8486a = r8.f8502a;
        this.f8492q = r8.f8504c;
        this.f8495t = r8.f8503b;
        r1.t r10 = r8.f8507f;
        this.f8490o = r10;
        this.f8487b = r10.f11339a;
        this.f8488m = r8.f8508g;
        this.f8489n = r8.f8510i;
        this.f8491p = null;
        this.f8494s = r8.f8505d;
        WorkDatabase r11 = r8.f8506e;
        this.f8496u = r11;
        this.f8497v = r11.f();
        this.f8498w = r11.a();
        this.f8499x = r8.f8509h;
    }

    public static /* synthetic */ void a(i0 r8, ga.a r10) {
        if (r8.A.isCancelled() == false) goto L6;
        r10.cancel(true);
        return;
    }

    public final t1.c b() {
        return this.f8501z;
    }

    public final void c(androidx.work.l.a r12) {
        boolean r8 = r12 instanceof androidx.work.l.a.c;
        r1.t r10 = this.f8490o;
        String r11 = C;
        if (r8 == false) goto L22;
        androidx.work.m.d().e(r11, "Worker result SUCCESS for " + this.f8500y);
        if (r10.f() == true) goto L26;
        r1.b r13 = this.f8498w;
        String r14 = this.f8487b;
        r1.u r15 = this.f8497v;
        WorkDatabase r16 = this.f8496u;
        r16.beginTransaction();
        r15.n(androidx.work.u.a.f2954m, r14);     // Catch: Throwable -> L18
        r15.o(r14, ((androidx.work.l.a.c) this.f8493r).f2927a);     // Catch: Throwable -> L18
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L18
        Iterator r18 = r13.a(r14).iterator();     // Catch: Throwable -> L18
    L10:
        if (r18.hasNext() == false) goto L16;
        String r19 = (String) r18.next();     // Catch: Throwable -> L18
        if (r15.f(r19) != androidx.work.u.a.f2956o) goto L10;
        if (r13.b(r19) == false) goto L10;
        androidx.work.m.d().e(r11, "Setting status to enqueued for " + r19);     // Catch: Throwable -> L18
        r15.n(androidx.work.u.a.f2952a, r19);     // Catch: Throwable -> L18
        r15.p(r17, r19);     // Catch: Throwable -> L18
        goto L10
    L16:
        r16.setTransactionSuccessful();     // Catch: Throwable -> L18
        r16.endTransaction();
        g(false);
        return;
    L18:
        th = move-exception;
        r16.endTransaction();
        g(false);
        throw th;
    L26:
        f();
        return;
    L22:
        if ((r12 instanceof androidx.work.l.a.b) == false) goto L24;
        androidx.work.m.d().e(r11, "Worker result RETRY for " + this.f8500y);
        e();
        return;
    L24:
        androidx.work.m.d().e(r11, "Worker result FAILURE for " + this.f8500y);
        if (r10.f() == true) goto L26;
        i();
    }

    public final void d() {
        boolean r8 = j();
        String r10 = this.f8487b;
        WorkDatabase r11 = this.f8496u;
        if (r8 == true) goto L19;
        r11.beginTransaction();
        androidx.work.u.a r12 = this.f8497v.f(r10);     // Catch: Throwable -> L16
        r11.e().delete(r10);     // Catch: Throwable -> L16
        if (r12 != null) goto L9;
        g(false);     // Catch: Throwable -> L16
    L14:
        r11.setTransactionSuccessful();     // Catch: Throwable -> L16
        r11.endTransaction();
        goto L19
    L9:
        if (r12 != androidx.work.u.a.f2953b) goto L12;
        c(this.f8493r);     // Catch: Throwable -> L16
        goto L14
    L12:
        if (r12.a() == true) goto L14;
        e();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L19:
        List<r> r13 = this.f8488m;
        if (r13 == null) goto L30;
        Iterator<r> r14 = r13.iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        r14.next().b(r10);
        goto L23
    L25:
        s.a(this.f8494s, r11, r13);
        return;
    }

    public final void e() {
        String r8 = this.f8487b;
        r1.u r10 = this.f8497v;
        WorkDatabase r11 = this.f8496u;
        r11.beginTransaction();
        r10.n(androidx.work.u.a.f2952a, r8);     // Catch: Throwable -> L6
        r10.p(System.currentTimeMillis(), r8);     // Catch: Throwable -> L6
        r10.b(-1, r8);     // Catch: Throwable -> L6
        r11.setTransactionSuccessful();     // Catch: Throwable -> L6
        r11.endTransaction();
        g(true);
        return;
    L6:
        th = move-exception;
        r11.endTransaction();
        g(true);
        throw th;
    }

    public final void f() {
        String r8 = this.f8487b;
        r1.u r10 = this.f8497v;
        WorkDatabase r11 = this.f8496u;
        r11.beginTransaction();
        r10.p(System.currentTimeMillis(), r8);     // Catch: Throwable -> L6
        r10.n(androidx.work.u.a.f2952a, r8);     // Catch: Throwable -> L6
        r10.t(r8);     // Catch: Throwable -> L6
        r10.a(r8);     // Catch: Throwable -> L6
        r10.b(-1, r8);     // Catch: Throwable -> L6
        r11.setTransactionSuccessful();     // Catch: Throwable -> L6
        r11.endTransaction();
        g(false);
        return;
    L6:
        th = move-exception;
        r11.endTransaction();
        g(false);
        throw th;
    }

    public final void g(boolean r8) {
        this.f8496u.beginTransaction();
    L31:
        th = move-exception;
        this.f8496u.endTransaction();
        throw th;
    L4:
        if (this.f8496u.f().s() == true) goto L6;
        s1.m.a(this.f8486a, RescheduleReceiver.class, false);     // Catch: Throwable -> L31
    L6:
        if (r8 == false) goto L9;
        this.f8497v.n(androidx.work.u.a.f2952a, this.f8487b);     // Catch: Throwable -> L31
        this.f8497v.b(-1, this.f8487b);     // Catch: Throwable -> L31
    L9:
        if (this.f8490o != null) goto L11;
    L28:
        this.f8496u.setTransactionSuccessful();     // Catch: Throwable -> L31
        this.f8496u.endTransaction();
        this.f8501z.j(Boolean.valueOf(r8));
        return;
    L11:
        if (this.f8491p == null) goto L28;
        q1.a r10 = this.f8495t;     // Catch: Throwable -> L31
        String r11 = this.f8487b;     // Catch: Throwable -> L31
        p r12 = (p) r10;     // Catch: Throwable -> L31
        Object r13 = r12.f8535v;     // Catch: Throwable -> L31
        monitor-enter(r13);     // Catch: Throwable -> L31
        boolean r14 = r12.f8529p.containsKey(r11);     // Catch: Throwable -> L25
        monitor-exit(r13);     // Catch: Throwable -> L25
        if (r14 == false) goto L28;
        q1.a r15 = this.f8495t;     // Catch: Throwable -> L31
        String r16 = this.f8487b;     // Catch: Throwable -> L31
        p r17 = (p) r15;     // Catch: Throwable -> L31
        Object r18 = r17.f8535v;     // Catch: Throwable -> L31
        monitor-enter(r18);     // Catch: Throwable -> L31
        r17.f8529p.remove(r16);     // Catch: Throwable -> L22
        r17.h();     // Catch: Throwable -> L22
        monitor-exit(r18);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    }

    public final void h() {
        r1.u r8 = this.f8497v;
        String r10 = this.f8487b;
        androidx.work.u.a r11 = r8.f(r10);
        androidx.work.u.a r12 = androidx.work.u.a.f2953b;
        String r13 = C;
        if (r11 != r12) goto L5;
        androidx.work.m.d().a(r13, "Status for " + r10 + " is RUNNING; not doing any work and rescheduling for later execution");
        boolean r14 = true;
    L6:
        g(r14);
        return;
    L5:
        androidx.work.m.d().a(r13, "Status for " + r10 + " is " + r11 + " ; not doing any work");
        r14 = false;
        goto L6
    }

    public final void i() {
        String r8 = this.f8487b;
        WorkDatabase r10 = this.f8496u;
        r10.beginTransaction();
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L14
        r11.add(r8);     // Catch: Throwable -> L14
    L4:
        boolean r12 = r11.isEmpty();     // Catch: Throwable -> L14
        r1.u r13 = this.f8497v;
        if (r12 == true) goto L11;
        String r14 = (String) r11.remove();     // Catch: Throwable -> L14
        if (r13.f(r14) == androidx.work.u.a.f2957p) goto L10;
        r13.n(androidx.work.u.a.f2955n, r14);     // Catch: Throwable -> L14
    L10:
        r11.addAll(this.f8498w.a(r14));     // Catch: Throwable -> L14
        goto L4
    L11:
        r13.o(r8, ((androidx.work.l.a.C0025a) this.f8493r).f2926a);     // Catch: Throwable -> L14
        r10.setTransactionSuccessful();     // Catch: Throwable -> L14
        r10.endTransaction();
        g(false);
        return;
    L14:
        th = move-exception;
        r10.endTransaction();
        g(false);
        throw th;
    }

    public final boolean j() {
        if (this.B == false) goto L9;
        androidx.work.m.d().a(C, "Work interrupted for " + this.f8500y);
        androidx.work.u.a r8 = this.f8497v.f(this.f8487b);
        if (r8 != null) goto L7;
        g(false);
    L8:
        return true;
    L7:
        g(!r8.a());
        goto L8
    L9:
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StringBuilder r8 = new StringBuilder("Work [ id=");
        String r10 = this.f8487b;
        r8.append(r10);
        r8.append(", tags={ ");
        Iterator<String> r11 = this.f8499x.iterator();
        boolean r12 = true;
    L4:
        if (r11.hasNext() == false) goto L10;
        String r13 = r11.next();
        if (r12 == false) goto L8;
        r12 = false;
    L9:
        r8.append(r13);
        goto L4
    L8:
        r8.append(", ");
        goto L9
    L10:
        r8.append(" } ]");
        this.f8500y = r8.toString();
        r1.t r14 = this.f8490o;
        if (j() == true) goto L85;
        WorkDatabase r15 = this.f8496u;
        r15.beginTransaction();
        androidx.work.u.a r16 = r14.f11340b;     // Catch: Throwable -> L71
        androidx.work.u.a r17 = androidx.work.u.a.f2952a;     // Catch: Throwable -> L71
        String r18 = r14.f11341c;
        String r19 = C;
        if (r16 == r17) goto L19;
        h();     // Catch: Throwable -> L71
        r15.setTransactionSuccessful();     // Catch: Throwable -> L71
        androidx.work.m.d().a(r19, r18 + " is not in ENQUEUED state. Nothing more to do");     // Catch: Throwable -> L71
    L30:
        r15.endTransaction();
        return;
    L19:
        if (r14.f() == true) goto L28;
        if (r14.f11340b == r17) goto L23;
    L25:
        boolean r20 = false;
    L26:
        if (r20 == true) goto L28;
    L31:
        r15.setTransactionSuccessful();     // Catch: Throwable -> L71
        r15.endTransaction();
        boolean r21 = r14.f();
        r1.u r22 = this.f8497v;
        androidx.work.c r23 = this.f8494s;
        if (r21 == false) goto L36;
        androidx.work.e r24 = r14.f11343e;
    L35:
        androidx.work.e r110 = r24;
        UUID r111 = UUID.fromString(r10);
        List<String> r112 = this.f8499x;
        WorkerParameters.a r113 = this.f8489n;
        int r114 = r14.f11349k;
        ExecutorService r25 = r23.f2796a;
        u1.a r26 = this.f8492q;
        androidx.work.x r27 = r23.f2798c;
        u1.a r28 = this.f8492q;
        WorkerParameters r29 = new WorkerParameters(r111, r110, r112, r113, r114, r25, r26, r27, new s1.c0(r15, r28), new s1.a0(r15, this.f8495t, r28));
        if (this.f8491p != null) goto L47;
        this.f8491p = r27.a(this.f8486a, r18, r29);
    L47:
        androidx.work.l r30 = this.f8491p;
        if (r30 != null) goto L51;
        androidx.work.m r31 = androidx.work.m.d();
        StringBuilder r32 = new StringBuilder("Could not create Worker ");
        r32.append(r18);
    L53:
        r31.b(r19, r32.toString());
        i();
        return;
    L51:
        if (r30.isUsed() == false) goto L54;
        r31 = androidx.work.m.d();
        r32 = defpackage.b.h("Received an already-used Worker ", r18, "; Worker Factory should return new instances");
        goto L53
    L54:
        this.f8491p.setUsed();
        r15.beginTransaction();
    L68:
        th = move-exception;
        r15.endTransaction();
        throw th;
    L56:
        if (r22.f(r10) != androidx.work.u.a.f2952a) goto L58;
        r22.n(androidx.work.u.a.f2953b, r10);     // Catch: Throwable -> L68
        r22.w(r10);     // Catch: Throwable -> L68
        boolean r33 = true;
    L59:
        r15.setTransactionSuccessful();     // Catch: Throwable -> L68
        r15.endTransaction();
        if (r33 == true) goto L63;
        h();
        return;
    L63:
        if (j() == true) goto L86;
        s1.y r34 = new s1.y(this.f8486a, this.f8490o, this.f8491p, r29.f2787j, this.f8492q);
        u1.b r35 = (u1.b) r28;
        r35.f12422c.execute(r34);
        t1.c<Void> r36 = r34.f12011a;
        androidx.appcompat.app.r r37 = new androidx.appcompat.app.r(3, this, r36);
        s1.u r38 = new s1.u();
        t1.c<androidx.work.l.a> r39 = this.A;
        r39.a(r38, r37);
        r36.a(r35.f12422c, new g0(this, r36));
        r39.a(r35.f12420a, new h0(this, this.f8500y));
        return;
    L86:
        return;
    L58:
        r33 = false;
        goto L59
    L36:
        androidx.work.k r40 = r23.f2799d;
        String r115 = r14.f11342d;
        r40.getClass();
        String r41 = androidx.work.j.f2925a;
        androidx.work.j r42 = (androidx.work.j) Class.forName(r115).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L39
    L41:
        if (r42 != null) goto L43;
        r31 = androidx.work.m.d();
        r32 = new StringBuilder("Could not create Input Merger ");
        r32.append(r14.f11342d);
        goto L53
    L43:
        ArrayList r43 = new ArrayList();
        r43.add(r14.f11343e);
        r43.addAll(r22.i(r10));
        r24 = r42.a(r43);
    L39:
        e = move-exception;
        androidx.work.m.d().c(androidx.work.j.f2925a, defpackage.b.c("Trouble instantiating + ", r115), e);
        r42 = null;
        goto L41
    L23:
        if (r14.f11349k <= 0) goto L25;
        r20 = true;
    L28:
        if (System.currentTimeMillis() >= r14.a()) goto L31;
        androidx.work.m.d().a(r19, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{r18}));     // Catch: Throwable -> L71
        g(true);     // Catch: Throwable -> L71
        r15.setTransactionSuccessful();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r15.endTransaction();
        throw th;
    }
}
