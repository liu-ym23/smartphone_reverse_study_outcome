package glc;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ugc.effectplatform.k;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    static {
    }

    public static k a(int r9, long r10) {
        PThreadPoolExecutor r8 = new PThreadPoolExecutor(r9, r9, r10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("or/ThreadPool"));
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        r8.allowCoreThreadTimeOut(r11);
        return new k(r8);
    L5:
        r11 = false;
        goto L6
    }
}
