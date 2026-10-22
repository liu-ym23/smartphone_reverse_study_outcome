package ms.bd.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class f0 {
    public static int a;

    public static String a(Context r1) {
        if (r1 == null) goto L6;
        new DisplayMetrics();     // Catch: Throwable -> L7
        Resources r2 = r1.getResources();     // Catch: Throwable -> L7
        a = WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).densityDpi;     // Catch: Throwable -> L7
    L6:
        return "" + a;
    }
}
