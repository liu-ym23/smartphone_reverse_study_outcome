package androidx.work;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends l {
    t1.c<l.a> mFuture;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Worker f2775a;

        public a(Worker r8) {
            this.f2775a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Worker r8 = this.f2775a;
            l.a r10 = r8.doWork();     // Catch: Throwable -> L5
            r8.mFuture.j(r10);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            r8.mFuture.k(th);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1.c f2776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Worker f2777b;

        public b(Worker r8, t1.c r10) {
            this.f2777b = r8;
            this.f2776a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            t1.c r8 = this.f2776a;
            r8.j(this.f2777b.getForegroundInfo());     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            r8.k(th);
        }
    }

    public Worker(Context r8, WorkerParameters r10) {
        super(r8, r10);
    }

    public abstract l.a doWork();

    public h getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // androidx.work.l
    public ga.a<h> getForegroundInfoAsync() {
        t1.c r8 = new t1.c();
        getBackgroundExecutor().execute(new b(this, r8));
        return r8;
    }

    @Override // androidx.work.l
    public final ga.a<l.a> startWork() {
        this.mFuture = new t1.c();
        getBackgroundExecutor().execute(new a(this));
        return this.mFuture;
    }
}
