package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.activity.j;
import androidx.work.m;
import j1.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r1.l;
import s1.d0;
import s1.p;
import s1.v;

/* JADX INFO: loaded from: classes.dex */
public final class c implements n1.c, d0.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2861w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2863b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f2864m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f2865n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n1.d f2866o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f2867p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2868q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final p f2869r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u1.b.a f2870s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PowerManager.WakeLock f2871t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2872u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t f2873v;

    static {
        f2861w = m.f("DelayMetCommandHandler");
    }

    public c(Context r8, int r10, d r11, t r12) {
        this.f2862a = r8;
        this.f2863b = r10;
        this.f2865n = r11;
        this.f2864m = r12.f8541a;
        this.f2873v = r12;
        p.c r13 = r11.f2879o.f8460j;
        u1.b r14 = (u1.b) r11.f2876b;
        this.f2869r = r14.f12420a;
        this.f2870s = r14.f12422c;
        this.f2866o = new n1.d(r13, this);
        this.f2872u = false;
        this.f2868q = 0;
        this.f2867p = new Object();
    }

    public static void b(c r10) {
        l r8 = r10.f2864m;
        String r11 = r8.f11324a;
        int r12 = r10.f2868q;
        String r13 = f2861w;
        if (r12 >= 2) goto L8;
        r10.f2868q = 2;
        m.d().a(r13, "Stopping work for WorkSpec " + r11);
        String r14 = a.f2852o;
        Context r15 = r10.f2862a;
        Intent r16 = new Intent(r15, SystemAlarmService.class);
        r16.setAction("ACTION_STOP_WORK");
        a.c(r16, r8);
        int r17 = r10.f2863b;
        d r18 = r10.f2865n;
        d.b r19 = new d.b(r17, r16, r18);
        u1.b.a r110 = r10.f2870s;
        r110.execute(r19);
        if (r18.f2878n.c(r8.f11324a) == false) goto L7;
        m.d().a(r13, "WorkSpec " + r11 + " needs to be rescheduled");
        Intent r20 = new Intent(r15, SystemAlarmService.class);
        r20.setAction("ACTION_SCHEDULE_WORK");
        a.c(r20, r8);
        r110.execute(new d.b(r17, r20, r18));
        return;
    L7:
        m r111 = m.d();
        StringBuilder r21 = new StringBuilder("Processor does not have WorkSpec ");
        r21.append(r11);
        r11 = ". No need to reschedule";
    L9:
        r21.append(r11);
        r111.a(r13, r21.toString());
        return;
    L8:
        r111 = m.d();
        r21 = new StringBuilder("Already stopped work for ");
        goto L9
    }

    @Override // s1.d0.a
    public final void a(l r8) {
        m.d().a(f2861w, "Exceeded time limits on execution for " + r8);
        this.f2869r.execute(new l1.b(this, 0));
    }

    @Override // n1.c
    public final void c(ArrayList r8) {
        androidx.activity.d r10 = new androidx.activity.d(this, 8);
        this.f2869r.execute(r10);
    }

    public final void d() {
        Object r8 = this.f2867p;
        monitor-enter(r8);
        this.f2866o.e();     // Catch: Throwable -> L11
        this.f2865n.f2877m.a(this.f2864m);     // Catch: Throwable -> L11
        PowerManager.WakeLock r10 = this.f2871t;     // Catch: Throwable -> L11
        if (r10 != null) goto L7;
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L7:
        if (r10.isHeld() == false) goto L9;
        m.d().a(f2861w, "Releasing wakelock " + this.f2871t + "for WorkSpec " + this.f2864m);     // Catch: Throwable -> L11
        this.f2871t.release();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // n1.c
    public final void e(List<r1.t> r8) {
        Iterator<r1.t> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        if (l6.a.L(r10.next()).equals(this.f2864m) == false) goto L4;
        l1.b r11 = new l1.b(this, 1);
        this.f2869r.execute(r11);
        return;
    }

    public final void f() {
        String r8 = this.f2864m.f11324a;
        this.f2871t = v.a(this.f2862a, android.aimedia.a.h(android.aimedia.a.k(r8, " ("), this.f2863b, ")"));
        m r10 = m.d();
        String r11 = "Acquiring wakelock " + this.f2871t + "for WorkSpec " + r8;
        String r12 = f2861w;
        r10.a(r12, r11);
        this.f2871t.acquire();
        r1.t r13 = this.f2865n.f2879o.f8453c.f().g(r8);
        if (r13 != null) goto L6;
        this.f2869r.execute(new j(this, 9));
        return;
    L6:
        boolean r14 = r13.e();
        this.f2872u = r14;
        if (r14 == true) goto L9;
        m.d().a(r12, "No constraints for " + r8);
        e(Collections.singletonList(r13));
        return;
    L9:
        this.f2866o.d(Collections.singletonList(r13));
    }

    public final void g(boolean r8) {
        m r10 = m.d();
        StringBuilder r11 = new StringBuilder("onExecuted ");
        l r12 = this.f2864m;
        r11.append(r12);
        r11.append(", ");
        r11.append(r8);
        String r13 = r11.toString();
        r10.a(f2861w, r13);
        d();
        int r14 = this.f2863b;
        d r15 = this.f2865n;
        u1.b.a r16 = this.f2870s;
        Context r17 = this.f2862a;
        if (r8 == false) goto L6;
        String r18 = a.f2852o;
        Intent r19 = new Intent(r17, SystemAlarmService.class);
        r19.setAction("ACTION_SCHEDULE_WORK");
        a.c(r19, r12);
        r16.execute(new d.b(r14, r19, r15));
    L6:
        if (this.f2872u == false) goto L9;
        String r20 = a.f2852o;
        Intent r21 = new Intent(r17, SystemAlarmService.class);
        r21.setAction("ACTION_CONSTRAINTS_CHANGED");
        r16.execute(new d.b(r14, r21, r15));
        return;
    }
}
