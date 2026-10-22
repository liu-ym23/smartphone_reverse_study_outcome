package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class w1 {
    public static final ExecutorCoroutineDispatcher a(final int r2, final String r3) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        final AtomicInteger r1 = new AtomicInteger();
        return ExecutorsKt.from(PThreadExecutorsUtils.newScheduledThreadPool(r2, new x1(r2, r3, r1)));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r2 + " specified").toString());
    }
}
