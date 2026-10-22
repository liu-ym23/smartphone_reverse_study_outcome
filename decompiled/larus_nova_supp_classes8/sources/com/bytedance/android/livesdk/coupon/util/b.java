package com.bytedance.android.livesdk.coupon.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final int a;
    public final int b;
    public final a c;

    public interface a {
        List<Long> a();

        void b(List<Long> r1);
    }

    public static long a() {
        Calendar r0 = Calendar.getInstance();
        r0.set(10, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        r0.set(9, 0);
        return r0.getTimeInMillis();
    }

    public final void call() {
        long r0 = a();
        int r2 = 1 - this.a;
        Calendar r4 = Calendar.getInstance();
        r4.setTime(new Date(r0));
        r4.add(5, r2);
        long r1 = r4.getTimeInMillis();
        List<Long> r3 = this.c.a();
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r7 = r6.next();
        if (((Number) r7).longValue() <= r1) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L4;
        r5.add(r7);
        goto L4
    L8:
        r8 = false;
        goto L9
    L11:
        List<Long> r9 = CollectionsKt.toMutableList(r5);
        r9.add(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        this.c.b(r9);
    }

    public b(int r2, int r3, UgCouponNewDialogFrequencyController$frequencyController$2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callTimeHolder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
