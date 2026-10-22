package nba;

import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements Function0 {
    public /* synthetic */ b() {
    }

    public final Object invoke() {
        int r0 = c.j;
        c.a.getClass();
        boolean r2 = false;
        if (r0 >= RangesKt.coerceAtLeast(c.e().getMaxSelfLoopRetryCount(), 0)) goto L7;
        r2 = true;
        c.j++;
    L7:
        return Boolean.valueOf(r2);
    }
}
