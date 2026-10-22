package androidx.emoji2.text;

import android.os.Build;
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
    static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler createAsync(Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    private ConcurrencyHelpers() {
    }

    public static /* synthetic */ Thread a(String r10, Runnable r11) {
        return lambda$createBackgroundPriorityExecutor$0(r10, r11);
    }

    @NonNull
    @Deprecated
    static Executor convertHandlerToExecutor(@NonNull final Handler r10) {
        Objects.requireNonNull(r10);
        return new a(r10);
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(@NonNull final String r10) {
        ThreadFactory r11 = new b(r10);
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), r11);
        r12.allowCoreThreadTimeOut(true);
        return r12;
    }

    private static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String r10, Runnable r11) {
        Thread r12 = new Thread(r11, r10);
        r12.setPriority(10);
        return r12;
    }

    static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Handler28Impl.createAsync(Looper.getMainLooper());
    L7:
        return new Handler(Looper.getMainLooper());
    }
}
