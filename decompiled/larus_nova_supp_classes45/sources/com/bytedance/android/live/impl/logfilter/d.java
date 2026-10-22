package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.service.FeatureManager;
import java.util.Deque;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class d implements z90.d {
    public final String a;

    public abstract void b(String r1, String r2);

    public d() {
        this.a = "LFM-FeatureFilter";
    }

    public static void c(String r4, Deque r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "deque");
        LinkedList r7 = (LinkedList) r5;
        r7.offerLast(Long.valueOf(r6));
    L4:
        if ((!r7.isEmpty()) == false) goto L10;
        Long r0 = (Long) r7.peekFirst();
        if (r0 == null) goto L10;
        float r1 = r6 - r0.longValue();
        FeatureManager.u.getClass();
        if (r1 <= (FeatureManager.h * 60000)) goto L10;
        r7.pollFirst();
    L10:
        FeatureManager.u.i(r4, Integer.valueOf(r7.size()), FeatureType.DYNAMIC);
    }

    public static void d(String r1, Deque r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "deque");
        if (r3 == 0) goto L6;
        LinkedList r5 = (LinkedList) r2;
        r5.pollLast();
        c(r1, r5, r4);
        return;
    }
}
