package h18;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final float a(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    @JvmStatic
    public static final float b(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return a(r1, r2);
    }

    @JvmStatic
    public static final float c(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1.getResources().getDimension(r2);
    }

    @JvmStatic
    public static final int d(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1.getResources().getDimensionPixelSize(r2);
    }

    @JvmStatic
    public static final int e(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r3 = r1.getResources();
        return (int) ((r2 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    @JvmStatic
    public static final int f(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r3 = r1.getResources();
        return (int) TypedValue.applyDimension(2, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }
}
