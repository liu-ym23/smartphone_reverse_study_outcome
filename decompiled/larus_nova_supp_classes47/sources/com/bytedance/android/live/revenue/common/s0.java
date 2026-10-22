package com.bytedance.android.live.revenue.common;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.Observable;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0 {
    public static final long b(u0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$naturalDayDiff");
        Calendar r0 = Calendar.getInstance();
        e(r0);
        long r1 = r0.getTimeInMillis();
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r5.a);
        e(r2);
        return (r1 - r2.getTimeInMillis()) / u0.e;
    }

    public static final boolean c(u0 r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$isToday");
        Calendar r0 = Calendar.getInstance();
        e(r0);
        long r1 = r0.getTimeInMillis();
        Calendar r2 = Calendar.getInstance();
        r2.add(5, 1);
        e(r2);
        long r3 = r2.getTimeInMillis();
        long r5 = r7.a;
        if (r1 <= r5) goto L6;
    L8:
        return false;
    L6:
        if (r3 <= r5) goto L8;
        return true;
    }

    public static final void d(Calendar r2) {
        r2.set(11, 23);
        r2.set(12, 59);
        r2.set(13, 59);
    }

    public static final void e(Calendar r2) {
        r2.set(11, 0);
        r2.set(12, 0);
        r2.set(13, 0);
        r2.set(14, 0);
    }

    public static final Observable<Long> a(u0 r2, u0 r3) {
        Intrinsics.checkNotNullParameter(r2, "total");
        Intrinsics.checkNotNullParameter(r3, "interval");
        return RxUtilKt.d(r2.a, r3.a);
    }
}
