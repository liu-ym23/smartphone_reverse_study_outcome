package j08;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public static int b(int r2, float r3) {
        return Color.argb((int) (r3 * 255.0f), Color.red(r2), Color.green(r2), Color.blue(r2));
    }

    public static int d(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static int e(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return (int) TypedValue.applyDimension(2, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public static int c(Context r0, int r1, float r2) {
        return b(r0.getResources().getColor(r1), r2);
    }
}
