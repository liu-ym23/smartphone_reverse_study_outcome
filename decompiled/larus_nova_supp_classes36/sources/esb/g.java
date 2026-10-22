package esb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.monitor.memory.MemoryMetrics;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ b a;

    public final void a() {
        MemoryMetrics r0 = new MemoryMetrics();
        this.a.getClass();
        b.c(r0);
        Log.i("MemoryPerfMonitor", "before reachTop notify, reach_top_mem_info，" + r0);
        MemoryCallbackManager.getInstance().notifyMemoryReachTop();
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new f(this), 500, TimeUnit.MILLISECONDS);
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

    public g(b r1) {
        this.a = r1;
    }
}
