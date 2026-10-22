package uga;

import android.os.SystemClock;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long a(long r6) {
        long r4 = SystemClock.elapsedRealtime();
        if (r6 > 0) goto L6;
        return r4;
    L6:
        return RangesKt.coerceIn(r4 - RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - r6, 0), 0, r4);
    }
}
