package rcb;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r1, long r2) {
        a.postDelayed(r1, r2);
    }
}
