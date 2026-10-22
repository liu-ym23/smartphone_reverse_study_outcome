package ida;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r {
    public static final Handler a = null;
    public static final AtomicInteger b = null;
    public static final ExecutorService c = null;

    static {
        a = new Handler(Looper.getMainLooper());
        b = new AtomicInteger();
        c = PThreadExecutorsUtils.newSingleThreadExecutor(new m());
    }
}
