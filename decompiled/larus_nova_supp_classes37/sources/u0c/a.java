package u0c;

import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final int a(int r2) {
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r1 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
    }
}
