package k1;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.work.m;
import androidx.work.u;
import j1.b0;
import j1.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import n1.d;
import r1.l;
import r1.t;
import s1.o;
import s1.q;

/* JADX INFO: loaded from: classes.dex */
public final class c implements r, n1.c, j1.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f8915t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f8917b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f8918m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet f8919n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f8920o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8921p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Object f8922q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final r6.d f8923r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Boolean f8924s;

    static {
        f8915t = m.f("GreedyScheduler");
    }

    public c(Context r8, androidx.work.c r10, p.c r11, b0 r12) {
        this.f8919n = new HashSet();
        this.f8923r = new r6.d();
        this.f8916a = r8;
        this.f8917b = r12;
        this.f8918m = new d(r11, this);
        this.f8920o = new b(this, r10.f2800e);
        this.f8922q = new Object();
    }

    @Override // j1.r
    public final void a(t... r13) {
        if (this.f8924s != null) goto L6;
        this.f8924s = Boolean.valueOf(o.a(this.f8916a, this.f8917b.f8452b));
    L6:
        if (this.f8924s.booleanValue() == true) goto L10;
        m.d().e(f8915t, "Ignoring schedule request in a secondary process");
        return;
    L10:
        if (this.f8921p == true) goto L12;
        this.f8917b.f8456f.a(this);
        this.f8921p = true;
    L12:
        HashSet r8 = new HashSet();
        HashSet r10 = new HashSet();
        int r11 = r13.length;
        int r12 = 0;
    L13:
        if (r12 >= r11) goto L41;
        t r14 = r13[r12];
        if (this.f8923r.c(l6.a.L(r14)) == true) goto L40;
        long r15 = r14.a();
        long r16 = System.currentTimeMillis();
        if (r14.f11340b != u.a.f2952a) goto L40;
        if (r16 >= r15) goto L28;
        b r17 = this.f8920o;
        if (r17 == null) goto L40;
        HashMap r18 = r17.f8914c;
        Runnable r19 = (Runnable) r18.remove(r14.f11339a);
        androidx.work.t r20 = r17.f8913b;
        if (r19 == null) goto L26;
        ((Handler) ((b9.a) r20).f3135b).removeCallbacks(r19);
    L26:
        a r21 = new a(r17, r14);
        r18.put(r14.f11339a, r21);
        ((Handler) ((b9.a) r20).f3135b).postDelayed(r21, r14.a() - System.currentTimeMillis());
        goto L40
    L28:
        if (r14.e() == false) goto L38;
        androidx.work.d r22 = r14.f11348j;
        if (r22.f2810c == false) goto L33;
        m r23 = m.d();
        String r24 = f8915t;
        StringBuilder r25 = new StringBuilder("Ignoring ");
        r25.append(r14);
        String r26 = ". Requires device idle.";
    L35:
        r25.append(r26);
        r23.a(r24, r25.toString());
        goto L40
    L33:
        if ((!r22.f2815h.isEmpty()) == false) goto L36;
        r23 = m.d();
        r24 = f8915t;
        r25 = new StringBuilder("Ignoring ");
        r25.append(r14);
        r26 = ". Requires ContentUri triggers.";
        goto L35
    L36:
        r8.add(r14);
        r10.add(r14.f11339a);
        goto L40
    L38:
        if (this.f8923r.c(l6.a.L(r14)) == true) goto L40;
        m.d().a(f8915t, "Starting work for " + r14.f11339a);
        b0 r27 = this.f8917b;
        r6.d r28 = this.f8923r;
        r28.getClass();
        r27.f8454d.a(new q(r27, r28.f(l6.a.L(r14)), null));
    L40:
        r12 = r12 + 1;
        goto L13
    L41:
        Object r110 = this.f8922q;
        monitor-enter(r110);
    L48:
        th = move-exception;
        throw th;
    L44:
        if (r8.isEmpty() == true) goto L46;
        String r29 = TextUtils.join(",", r10);     // Catch: Throwable -> L48
        m.d().a(f8915t, "Starting tracking for " + r29);     // Catch: Throwable -> L48
        this.f8919n.addAll(r8);     // Catch: Throwable -> L48
        this.f8918m.d(this.f8919n);     // Catch: Throwable -> L48
    L46:
        monitor-exit(r110);     // Catch: Throwable -> L48
    }

    @Override // j1.r
    public final void b(String r8) {
        Boolean r10 = this.f8924s;
        b0 r11 = this.f8917b;
        if (r10 != null) goto L5;
        this.f8924s = Boolean.valueOf(o.a(this.f8916a, r11.f8452b));
    L5:
        boolean r12 = this.f8924s.booleanValue();
        String r13 = f8915t;
        if (r12 == true) goto L10;
        m.d().e(r13, "Ignoring schedule request in non-main process");
        return;
    L10:
        if (this.f8921p == true) goto L12;
        r11.f8456f.a(this);
        this.f8921p = true;
    L12:
        m.d().a(r13, "Cancelling work ID " + r8);
        b r14 = this.f8920o;
        if (r14 == null) goto L17;
        Runnable r15 = (Runnable) r14.f8914c.remove(r8);
        if (r15 == null) goto L17;
        ((Handler) ((b9.a) r14.f8913b).f3135b).removeCallbacks(r15);
    L17:
        Iterator r16 = this.f8923r.e(r8).iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        r11.f8454d.a(new s1.t(r11, (j1.t) r16.next(), false));
        goto L19
    }

    @Override // n1.c
    public final void c(ArrayList r8) {
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        l r11 = l6.a.L((t) r10.next());
        m.d().a(f8915t, "Constraints not met: Cancelling work ID " + r11);
        j1.t r12 = this.f8923r.d(r11);
        if (r12 == null) goto L4;
        b0 r13 = this.f8917b;
        r13.f8454d.a(new s1.t(r13, r12, false));
        goto L4
    }

    @Override // j1.r
    public final boolean d() {
        return false;
    }

    @Override // n1.c
    public final void e(List<t> r8) {
        Iterator r10 = ((ArrayList) r8).iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        l r11 = l6.a.L((t) r10.next());
        r6.d r12 = this.f8923r;
        if (r12.c(r11) == true) goto L4;
        m.d().a(f8915t, "Constraints met: Scheduling work ID " + r11);
        j1.t r13 = r12.f(r11);
        b0 r14 = this.f8917b;
        r14.f8454d.a(new q(r14, r13, null));
        goto L4
    }

    @Override // j1.c
    public final void f(l r8, boolean r10) {
        this.f8923r.d(r8);
        Object r11 = this.f8922q;
        monitor-enter(r11);
        Iterator r12 = this.f8919n.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L10;
        t r13 = (t) r12.next();     // Catch: Throwable -> L12
        if (l6.a.L(r13).equals(r8) == false) goto L6;
        m.d().a(f8915t, "Stopping tracking for " + r8);     // Catch: Throwable -> L12
        this.f8919n.remove(r13);     // Catch: Throwable -> L12
        this.f8918m.d(this.f8919n);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
