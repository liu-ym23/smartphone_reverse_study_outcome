package s1;

import j1.i0;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12001n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j1.b0 f12002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j1.t f12003b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f12004m;

    static {
        f12001n = androidx.work.m.f("StopWorkRunnable");
    }

    public t(j1.b0 r8, j1.t r10, boolean r11) {
        this.f12002a = r8;
        this.f12003b = r10;
        this.f12004m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f12004m == false) goto L14;
        j1.p r8 = this.f12002a.f8456f;
        j1.t r10 = this.f12003b;
        r8.getClass();
        String r11 = r10.f8541a.f11324a;
        Object r12 = r8.f8535v;
        monitor-enter(r12);
        androidx.work.m.d().a(j1.p.f8523w, "Processor stopping foreground work " + r11);     // Catch: Throwable -> L11
        i0 r13 = (i0) r8.f8529p.remove(r11);     // Catch: Throwable -> L11
        if (r13 == null) goto L9;
        r8.f8531r.remove(r11);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L11
        boolean r14 = j1.p.b(r13, r11);
    L29:
        androidx.work.m.d().a(f12001n, "StopWorkRunnable for " + this.f12003b.f8541a.f11324a + "; Processor.stopWork = " + r14);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        j1.p r15 = this.f12002a.f8456f;
        j1.t r16 = this.f12003b;
        r15.getClass();
        String r17 = r16.f8541a.f11324a;
        Object r18 = r15.f8535v;
        monitor-enter(r18);
        i0 r19 = (i0) r15.f8530q.remove(r17);     // Catch: Throwable -> L31
        if (r19 != null) goto L19;
        androidx.work.m.d().a(j1.p.f8523w, "WorkerWrapper could not be found for " + r17);     // Catch: Throwable -> L31
    L27:
        monitor-exit(r18);     // Catch: Throwable -> L31
        r14 = false;
        goto L29
    L19:
        Set r20 = (Set) r15.f8531r.get(r17);     // Catch: Throwable -> L31
        if (r20 == null) goto L27;
        if (r20.contains(r16) == false) goto L27;
        androidx.work.m.d().a(j1.p.f8523w, "Processor stopping background work " + r17);     // Catch: Throwable -> L31
        r15.f8531r.remove(r17);     // Catch: Throwable -> L31
        monitor-exit(r18);     // Catch: Throwable -> L31
        r14 = j1.p.b(r19, r17);
    L31:
        th = move-exception;
        throw th;
    }
}
