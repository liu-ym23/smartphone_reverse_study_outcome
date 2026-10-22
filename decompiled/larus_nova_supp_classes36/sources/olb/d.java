package olb;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final Handler a = null;

    static {
        a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r1) {
        a.removeCallbacks(r1);
    }
}
