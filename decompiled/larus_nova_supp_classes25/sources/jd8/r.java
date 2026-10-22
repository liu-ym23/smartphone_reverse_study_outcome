package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r {
    static {
    }

    public static float a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r3 = r2.getResources();
        return RangesKt.coerceAtLeast(TypedValue.applyDimension(1, 0.5f, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())), 1.0f);
    }
}
