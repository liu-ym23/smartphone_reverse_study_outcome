package uzb;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l {
    public static Resources getResources(Context r0) {
        return r0.getResources();
    }

    public static int a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r0, int r1) {
        return getResources(r0).getColor(r1);
    }

    public static float c(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).scaledDensity;
    }
}
