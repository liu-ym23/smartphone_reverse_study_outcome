package com.bytedance.android.live.recharge.deal;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final long b(Iterable<d> r7) {
        if (r7 == null) goto L19;
        Iterator<d> r8 = r7.iterator();
        if (r8.hasNext() == true) goto L6;
        d r9 = null;
    L16:
        d r10 = r9;
        if (r10 == null) goto L19;
        return r10.h;
    L6:
        d r0 = r8.next();
        if (r8.hasNext() == true) goto L9;
    L8:
        r9 = r0;
        goto L16
    L9:
        long r1 = r0.h;
    L10:
        d r3 = r8.next();
        long r4 = r3.h;
        if (r1 >= r4) goto L14;
        r0 = r3;
        r1 = r4;
    L14:
        if (r8.hasNext() == true) goto L10;
    L19:
        return 0;
    }

    public static final long c(Iterable<d> r7) {
        if (r7 == null) goto L19;
        Iterator<d> r8 = r7.iterator();
        if (r8.hasNext() == true) goto L6;
        d r9 = null;
    L16:
        d r10 = r9;
        if (r10 == null) goto L19;
        return r10.g;
    L6:
        d r0 = r8.next();
        if (r8.hasNext() == true) goto L9;
    L8:
        r9 = r0;
        goto L16
    L9:
        long r1 = r0.g;
    L10:
        d r3 = r8.next();
        long r4 = r3.g;
        if (r1 <= r4) goto L14;
        r0 = r3;
        r1 = r4;
    L14:
        if (r8.hasNext() == true) goto L10;
    L19:
        return 0;
    }

    public static final d a(Iterable<d> r6, long r7, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "$this$createCustomDeal");
        Iterator<d> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        d r0 = r8.next();
        d r2 = r0;
        if (r2.g <= r7) goto L8;
    L9:
        if (r10 == false) goto L11;
    L10:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L4;
    L15:
        d r1 = r0;
        if (r1 != null) goto L18;
        return null;
    L18:
        return d.j(r1, r7, r9, 509);
    L11:
        r3 = false;
        goto L12
    L8:
        if (r7 <= r2.h) goto L10;
    L14:
        r0 = null;
        goto L15
    }
}
