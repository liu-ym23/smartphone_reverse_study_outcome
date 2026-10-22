package q1;

import j1.i0;
import j1.p;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.work.impl.foreground.a f10125b;

    public b(androidx.work.impl.foreground.a r8, String r10) {
        this.f10125b = r8;
        this.f10124a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p r8 = this.f10125b.f2900a.f8456f;
        String r10 = this.f10124a;
        Object r11 = r8.f8535v;
        monitor-enter(r11);
        i0 r12 = (i0) r8.f8529p.get(r10);     // Catch: Throwable -> L25
        if (r12 != null) goto L7;
        r12 = (i0) r8.f8530q.get(r10);     // Catch: Throwable -> L25
    L7:
        if (r12 == null) goto L11;
        t r13 = r12.f8490o;     // Catch: Throwable -> L25
        monitor-exit(r11);     // Catch: Throwable -> L25
    L13:
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.e() == false) goto L31;
        Object r14 = this.f10125b.f2902m;
        monitor-enter(r14);
        this.f10125b.f2905p.put(l6.a.L(r13), r13);     // Catch: Throwable -> L21
        this.f10125b.f2906q.add(r13);     // Catch: Throwable -> L21
        androidx.work.impl.foreground.a r15 = this.f10125b;     // Catch: Throwable -> L21
        r15.f2907r.d(r15.f2906q);     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L31:
        return;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L25
        r13 = null;
    L25:
        th = move-exception;
        throw th;
    }
}
