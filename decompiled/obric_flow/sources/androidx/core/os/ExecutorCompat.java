package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class ExecutorCompat {

    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        public HandlerExecutor(@NonNull Handler r5) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r5);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r5) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r5)) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    @NonNull
    public static Executor create(@NonNull Handler r5) {
        return new HandlerExecutor(r5);
    }
}
