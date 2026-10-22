package cib;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final int a(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static final int b(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1.getResources().getColor(r2);
    }
}
