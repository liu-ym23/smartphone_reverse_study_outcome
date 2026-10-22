package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class y implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f2715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f2716b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f2717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f2718n;

    public y(Executor r8) {
        he.i.f(r8, "executor");
        this.f2715a = r8;
        this.f2716b = new ArrayDeque();
        this.f2718n = new Object();
    }

    public final void a() {
        Object r8 = this.f2718n;
        monitor-enter(r8);
        Runnable r10 = this.f2716b.poll();     // Catch: Throwable -> L10
        Runnable r11 = r10;     // Catch: Throwable -> L10
        this.f2717m = r11;     // Catch: Throwable -> L10
        if (r10 == null) goto L7;
        this.f2715a.execute(r11);     // Catch: Throwable -> L10
    L7:
        xd.j r12 = xd.j.f13877a;     // Catch: Throwable -> L10
        monitor-exit(r8);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        he.i.f(r8, "command");
        Object r10 = this.f2718n;
        monitor-enter(r10);
        this.f2716b.offer(new k(2, r8, this));     // Catch: Throwable -> L10
        if (this.f2717m != null) goto L7;
        a();     // Catch: Throwable -> L10
    L7:
        xd.j r11 = xd.j.f13877a;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
