package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    @RequiresApi(28)
    public static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper r5) {
            return Handler.createAsync(r5);
        }
    }

    private ConcurrencyHelpers() {
    }

    public static /* synthetic */ Thread a(String r5, Runnable r10) {
        return lambda$createBackgroundPriorityExecutor$0(r5, r10);
    }

    @NonNull
    @Deprecated
    public static Executor convertHandlerToExecutor(@NonNull final Handler r5) {
        Objects.requireNonNull(r5);
        return new a(r5);
    }

    public static ThreadPoolExecutor createBackgroundPriorityExecutor(@NonNull final String r10) {
        ThreadFactory r11 = new b(r10);
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r11);
        r12.allowCoreThreadTimeOut(true);
        return r12;
    }

    private static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r5, Runnable r10) {
        Thread r11 = new Thread(r10, r5);
        r11.setPriority(10);
        return r11;
    }

    public static Handler mainHandlerAsync() {
        return Handler28Impl.createAsync(Looper.getMainLooper());
    }
}
