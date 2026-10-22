package mn;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r5, Throwable r10) {
        Log.e("lynx_LynxThreadPool", r10.toString());
    }
}
