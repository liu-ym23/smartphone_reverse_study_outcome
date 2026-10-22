package jwb;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r2) {
        float r0 = r2.getResources().getDimension(2131167878);
        Resources r3 = r2.getResources();
        return MathKt.roundToInt(r0 / WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density);
    }
}
