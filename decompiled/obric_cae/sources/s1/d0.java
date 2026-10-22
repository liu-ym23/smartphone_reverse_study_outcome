package s1;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11964e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.t f11965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f11966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f11967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11968d;

    public interface a {
        void a(r1.l r8);
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f11969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r1.l f11970b;

        public b(d0 r8, r1.l r10) {
            this.f11969a = r8;
            this.f11970b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r8 = this.f11969a.f11968d;
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (((b) this.f11969a.f11966b.remove(this.f11970b)) == null) goto L9;
            a r10 = (a) this.f11969a.f11967c.remove(this.f11970b);     // Catch: Throwable -> L12
            if (r10 == null) goto L10;
            r10.a(this.f11970b);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L9:
            androidx.work.m.d().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.f11970b}));     // Catch: Throwable -> L12
            goto L10
        }
    }

    static {
        f11964e = androidx.work.m.f("WorkTimer");
    }

    public d0(b9.a r8) {
        this.f11966b = new HashMap();
        this.f11967c = new HashMap();
        this.f11968d = new Object();
        this.f11965a = r8;
    }

    public final void a(r1.l r8) {
        Object r10 = this.f11968d;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (((b) this.f11966b.remove(r8)) == null) goto L7;
        androidx.work.m.d().a(f11964e, "Stopping timer for " + r8);     // Catch: Throwable -> L9
        this.f11967c.remove(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }
}
