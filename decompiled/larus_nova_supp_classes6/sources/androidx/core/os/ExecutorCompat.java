package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ExecutorCompat {
    private ExecutorCompat() {
    }

    public static Executor create(Handler r1) {
        return new HandlerExecutor(r1);
    }
}
