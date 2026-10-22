package j1;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class p implements c, q1.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f8523w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f8524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8525b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final androidx.work.c f8526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final u1.a f8527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WorkDatabase f8528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap f8529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap f8530q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap f8531r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<r> f8532s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HashSet f8533t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f8534u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f8535v;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f8536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r1.l f8537b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ga.a<Boolean> f8538m;

        public a(c r8, r1.l r10, t1.c r11) {
            this.f8536a = r8;
            this.f8537b = r10;
            this.f8538m = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = this.f8538m.get().booleanValue();     // Catch: Throwable -> L4
        L5:
            this.f8536a.f(this.f8537b, r8);
            return;
        L4:
            r8 = true;
            goto L5
        }
    }

    static {
        f8523w = androidx.work.m.f("Processor");
    }

    public p(Context r8, androidx.work.c r10, u1.b r11, WorkDatabase r12, List r13) {
        this.f8525b = r8;
        this.f8526m = r10;
        this.f8527n = r11;
        this.f8528o = r12;
        this.f8530q = new HashMap();
        this.f8529p = new HashMap();
        this.f8532s = r13;
        this.f8533t = new HashSet();
        this.f8534u = new ArrayList();
        this.f8524a = null;
        this.f8535v = new Object();
        this.f8531r = new HashMap();
    }

    public static boolean b(i0 r8, String r10) {
        if (r8 == null) goto L11;
        r8.B = true;
        r8.j();
        r8.A.cancel(true);
        if (r8.f8491p != null) goto L6;
    L8:
        androidx.work.m.d().a(i0.C, "WorkSpec " + r8.f8490o + " is already done. Not interrupting.");
    L9:
        androidx.work.m.d().a(f8523w, "WorkerWrapper interrupted for " + r10);
        return true;
    L6:
        if ((r8.A.f12216a instanceof t1.a.b) == false) goto L8;
        r8.f8491p.stop();
        goto L9
    L11:
        androidx.work.m.d().a(f8523w, "WorkerWrapper could not be found for " + r10);
        return false;
    }

    public final void a(c r8) {
        Object r10 = this.f8535v;
        monitor-enter(r10);
        this.f8534u.add(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final boolean c(String r8) {
        Object r10 = this.f8535v;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f8530q.containsKey(r8) == false) goto L7;
    L10:
        boolean r11 = true;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    L7:
        if (this.f8529p.containsKey(r8) == true) goto L10;
        r11 = false;
        goto L11
    }

    public final void d(r1.l r8) {
        ((u1.b) this.f8527n).f12422c.execute(new o(this, r8, false, 0));
    }

    public final void e(String r8, androidx.work.h r10) {
        Object r11 = this.f8535v;
        monitor-enter(r11);
        androidx.work.m.d().e(f8523w, "Moving WorkSpec (" + r8 + ") to the foreground");     // Catch: Throwable -> L12
        i0 r12 = (i0) this.f8530q.remove(r8);     // Catch: Throwable -> L12
        if (r12 != null) goto L7;
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.f8524a != null) goto L9;
        PowerManager.WakeLock r13 = s1.v.a(this.f8525b, "ProcessorForegroundLck");     // Catch: Throwable -> L12
        this.f8524a = r13;     // Catch: Throwable -> L12
        r13.acquire();     // Catch: Throwable -> L12
    L9:
        this.f8529p.put(r8, r12);     // Catch: Throwable -> L12
        Intent r14 = androidx.work.impl.foreground.a.b(this.f8525b, l6.a.L(r12.f8490o), r10);     // Catch: Throwable -> L12
        Context r15 = this.f8525b;     // Catch: Throwable -> L12
        Object r16 = androidx.core.content.a.f1674a;     // Catch: Throwable -> L12
        androidx.core.content.a.d.b(r15, r14);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // j1.c
    public final void f(r1.l r8, boolean r10) {
        Object r11 = this.f8535v;
        monitor-enter(r11);
        i0 r12 = (i0) this.f8530q.get(r8.f11324a);     // Catch: Throwable -> L15
        if (r12 != null) goto L7;
    L9:
        androidx.work.m.d().a(f8523w, p.class.getSimpleName() + " " + r8.f11324a + " executed; reschedule = " + r10);     // Catch: Throwable -> L15
        Iterator r13 = this.f8534u.iterator();     // Catch: Throwable -> L15
    L11:
        if (r13.hasNext() == false) goto L13;
        ((c) r13.next()).f(r8, r10);     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L7:
        if (r8.equals(l6.a.L(r12.f8490o)) == false) goto L9;
        this.f8530q.remove(r8.f11324a);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean g(t r13, WorkerParameters.a r14) {
        r1.l r8 = r13.a();
        final String r10 = r8.b();
        final ArrayList r11 = new ArrayList();
        r1.t r12 = (r1.t) this.f8528o.runInTransaction(new n(this, r11, r10));
        if (r12 != null) goto L6;
        androidx.work.m.d().g(f8523w, "Didn't find WorkSpec for id " + r8);
        d(r8);
        return false;
    L6:
        Object r15 = this.f8535v;
        monitor-enter(r15);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (c(r10) == false) goto L17;
        Set r16 = (Set) this.f8531r.get(r10);     // Catch: Throwable -> L25
        if (((t) r16.iterator().next()).a().a() != r8.a()) goto L13;
        r16.add(r13);     // Catch: Throwable -> L25
        androidx.work.m.d().a(f8523w, "Work " + r8 + " is already enqueued for processing");     // Catch: Throwable -> L25
    L14:
        monitor-exit(r15);     // Catch: Throwable -> L25
        return false;
    L13:
        d(r8);     // Catch: Throwable -> L25
        goto L14
    L17:
        if (r12.c() == r8.a()) goto L21;
        d(r8);     // Catch: Throwable -> L25
        monitor-exit(r15);     // Catch: Throwable -> L25
        return false;
    L21:
        i0.a r17 = new i0.a(this.f8525b, this.f8526m, this.f8527n, this, this.f8528o, r12, r11);     // Catch: Throwable -> L25
        r17.c(this.f8532s);     // Catch: Throwable -> L25
        r17.b(r14);     // Catch: Throwable -> L25
        i0 r18 = r17.a();     // Catch: Throwable -> L25
        t1.c r19 = r18.b();     // Catch: Throwable -> L25
        r19.a(((u1.b) this.f8527n).b(), new a(this, r13.a(), r19));     // Catch: Throwable -> L25
        this.f8530q.put(r10, r18);     // Catch: Throwable -> L25
        HashSet r20 = new HashSet();     // Catch: Throwable -> L25
        r20.add(r13);     // Catch: Throwable -> L25
        this.f8531r.put(r10, r20);     // Catch: Throwable -> L25
        monitor-exit(r15);     // Catch: Throwable -> L25
        ((u1.b) this.f8527n).c().execute(r18);
        androidx.work.m.d().a(f8523w, p.class.getSimpleName() + ": processing " + r8);
        return true;
    }

    public final void h() {
        Object r8 = this.f8535v;
        monitor-enter(r8);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ((!this.f8529p.isEmpty()) == true) goto L14;
        Context r10 = this.f8525b;     // Catch: Throwable -> L16
        String r11 = androidx.work.impl.foreground.a.f2899t;     // Catch: Throwable -> L16
        Intent r12 = new Intent(r10, SystemForegroundService.class);     // Catch: Throwable -> L16
        r12.setAction("ACTION_STOP_FOREGROUND");     // Catch: Throwable -> L16
        this.f8525b.startService(r12);     // Catch: Throwable -> L9
    L11:
        PowerManager.WakeLock r13 = this.f8524a;     // Catch: Throwable -> L16
        if (r13 == null) goto L14;
        r13.release();     // Catch: Throwable -> L16
        this.f8524a = null;     // Catch: Throwable -> L16
        goto L14
    L9:
        th = move-exception;
        androidx.work.m.d().c(f8523w, "Unable to stop foreground service", th);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r8);     // Catch: Throwable -> L16
    }
}
