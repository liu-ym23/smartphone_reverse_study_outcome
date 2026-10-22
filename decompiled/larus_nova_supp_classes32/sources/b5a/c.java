package b5a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static volatile Handler a;

    public c() {
    }

    public static void a(Runnable r3) {
        if (a == null) goto L5;
    L14:
        a.post(r3);
        return;
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
