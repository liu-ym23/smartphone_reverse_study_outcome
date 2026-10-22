package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    private ConcurrencyHelpers() {
    }

    @Deprecated
    static Executor convertHandlerToExecutor(final Handler r1) {
        Objects.requireNonNull(r1);
        return new $$Lambda$ConcurrencyHelpers$xMC8M6LLEeW997bBmO6BCC6GGAM(r1);
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(final String r8) {
        ThreadFactory r7 = new $$Lambda$ConcurrencyHelpers$rm7NN8F9tEuy2Vr8i0fl8_hnx_A(r8);
        ThreadPoolExecutor r9 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r7);
        r9.allowCoreThreadTimeOut(true);
        return r9;
    }

    static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r2, Runnable r3) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r2);
        r0.setPriority(10);
        return r0;
    }

    public static /* synthetic */ boolean lambda$xMC8M6LLEeW997bBmO6BCC6GGAM(Handler r0, Runnable r1) {
        return r0.post(r1);
    }

    static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Handler28Impl.createAsync(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }
}
