package y50;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public final int a;
    public final String b;

    public r(String r5, WidgetCostModule r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "cost");
        this.b = r5;
        long r0 = r6.getTotal();
        long r2 = r6.getInflateDuration();
        if (r6.isAsync == false) goto L5;
        r0 = r0 - r2;
    L5:
        this.a = (int) r0;
    }
}
