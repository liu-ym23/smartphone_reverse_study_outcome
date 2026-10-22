package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultRunnableScheduler implements RunnableScheduler {
    private final Handler mHandler;

    public DefaultRunnableScheduler() {
        this.mHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    @VisibleForTesting
    public DefaultRunnableScheduler(@NonNull Handler r10) {
        this.mHandler = r10;
    }

    @Override // androidx.work.RunnableScheduler
    public void cancel(@NonNull Runnable r10) {
        this.mHandler.removeCallbacks(r10);
    }

    @NonNull
    public Handler getHandler() {
        return this.mHandler;
    }

    @Override // androidx.work.RunnableScheduler
    public void scheduleWithDelay(long r10, @NonNull Runnable r11) {
        this.mHandler.postDelayed(r11, r10);
    }
}
