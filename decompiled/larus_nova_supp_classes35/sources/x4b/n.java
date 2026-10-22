package x4b;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements d {
    public final ExecutorService a;
    public final AtomicBoolean b;
    public volatile Thread c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ n a;
        public final /* synthetic */ Runnable b;

        public b(n r1, Runnable r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.b.compareAndSet(false, true) == true) goto L5;
            Log.w("SerialExecutor", "serial task may occur crash, isRunning not reset");
            this.a.b.set(false);
        L5:
            n r0 = this.a;
            r0.c = ThreadMethodProxy.currentThread();
            this.b.run();
            this.a.b.set(false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // x4b.d
    public final void f() {
        if (this.b.get() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), this.c) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("serial thread check failed");
    }

    @Override // x4b.d
    public final void shutdown() {
        this.a.shutdown();
    }

    public n(ExecutorService r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
        this.b = new AtomicBoolean(false);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        if (this.a.isShutdown() == false) goto L5;
        return;
    L5:
        this.a.execute(new b(this, r3));
    }
}
