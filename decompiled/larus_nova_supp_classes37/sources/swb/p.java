package swb;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class p {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final Resources getResources(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return r2.getResources();
        }

        @JvmStatic
        public static int a(Context r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Resources r3 = r1.getResources();
            return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
        }
    }

    static {
        a = new a();
    }

    @JvmStatic
    public static final int a(Context r0, float r1) {
        return a.a(r0, r1);
    }

    @JvmStatic
    public static final Resources getResources(Context r1) {
        return a.getResources(r1);
    }
}
