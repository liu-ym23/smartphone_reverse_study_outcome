package n2;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final int a(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r11 = r10.floatValue();
        Resources r0 = Resources.getSystem();
        return (int) ((r11 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static final float b(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r11 = r10.floatValue();
        Resources r0 = Resources.getSystem();
        return r11 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    public static final float c(Number r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        float r11 = r10.floatValue();
        Resources r0 = Resources.getSystem();
        return (r11 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f;
    }
}
