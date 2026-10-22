package x4b;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements d {
    public Handler a;

    public final synchronized boolean a() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.a != null) goto L9;
        Log.i("HandlerExecutor", "Handler is null");     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L9:
        if (Looper.myLooper() == this.a.getLooper()) goto L12;
        r1 = false;
    L12:
        monitor-exit(this);
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // x4b.d
    public final synchronized void shutdown() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.a.getLooper() == null) goto L6;
        ThreadMethodProxy.quitSafely(this.a.getLooper());     // Catch: Throwable -> L9
    L6:
        this.a = null;     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // x4b.d
    public final void f() {
        if (a() == true) goto L6;
        Log.e("HandlerExecutor", new Exception("serial task check failed"), true);
        return;
    }

    public b(String r1) {
        this.a = CoreThreadPool.newThreadHandler(r1);
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable r2) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.a != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (a() == false) goto L10;
        r2.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L10:
        this.a.post(r2);     // Catch: Throwable -> L13
        goto L11
    }
}
