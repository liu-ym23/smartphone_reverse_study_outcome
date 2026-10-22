package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class ExecutorCompat {

    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler r3) {
            this.mHandler = (Handler) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), Handler.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            if (this.mHandler.post((Runnable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin")), Runnable.class, "com.obric.memorydata.plugin")) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private ExecutorCompat() {
    }

    public static Executor create(Handler r1) {
        return new HandlerExecutor(r1);
    }
}
