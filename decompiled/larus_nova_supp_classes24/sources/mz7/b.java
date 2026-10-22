package mz7;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r2) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2.run();
        return;
    L8:
        a.post(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
