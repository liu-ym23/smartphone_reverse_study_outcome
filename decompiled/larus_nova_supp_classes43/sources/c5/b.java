package c5;

import com.bytedance.ai.infra.thread_pool.f;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements RejectedExecutionHandler {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "poolName");
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable r10, final ThreadPoolExecutor r11) {
        if (r10 == null) goto L4;
        f.f.execute(r10);
    L4:
        if (r11 == null) goto L7;
        f.c.submit(new c5.a(this, r11));
        return;
    }
}
