package s1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<a> f11989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f11990b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f11991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f11992n;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f11993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f11994b;

        public a(p r8, Runnable r10) {
            this.f11993a = r8;
            this.f11994b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f11994b.run();     // Catch: Throwable -> L11
            Object r8 = this.f11993a.f11992n;
            monitor-enter(r8);
            this.f11993a.a();     // Catch: Throwable -> L8
            monitor-exit(r8);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f11993a.f11992n);
            this.f11993a.a();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public p(ExecutorService r8) {
        this.f11990b = r8;
        this.f11989a = new ArrayDeque();
        this.f11992n = new Object();
    }

    public final void a() {
        a r8 = this.f11989a.poll();
        this.f11991m = r8;
        if (r8 == null) goto L6;
        this.f11990b.execute(r8);
        return;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        Object r10 = this.f11992n;
        monitor-enter(r10);
        this.f11989a.add(new a(this, r8));     // Catch: Throwable -> L9
        if (this.f11991m != null) goto L7;
        a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
