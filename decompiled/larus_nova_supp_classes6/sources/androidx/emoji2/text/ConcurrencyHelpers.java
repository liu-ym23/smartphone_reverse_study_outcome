package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    private ConcurrencyHelpers() {
    }

    public static /* synthetic */ Thread a(String r0, Runnable r1) {
        return lambda$createBackgroundPriorityExecutor$0(r0, r1);
    }

    public static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Handler28Impl.createAsync(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }

    public static Executor convertHandlerToExecutor(final Handler r1) {
        Objects.requireNonNull(r1);
        return new b(r1);
    }

    public static ThreadPoolExecutor createBackgroundPriorityExecutor(final String r8) {
        ThreadFactory r7 = new a(r8);
        PThreadPoolExecutor r9 = new PThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r7);
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    private static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r1, Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, r1);
        ThreadMethodProxy.setPriority(r0, 10);
        return r0;
    }
}
