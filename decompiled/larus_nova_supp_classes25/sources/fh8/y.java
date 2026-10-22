package fh8;

import com.larus.platform.service.e2;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y {
    public static final int a(int r1) {
        if (e2.a.isPad() == true) goto L5;
        return r1;
    L5:
        return RangesKt.coerceAtMost(r1, i5.D() * 2);
    }
}
