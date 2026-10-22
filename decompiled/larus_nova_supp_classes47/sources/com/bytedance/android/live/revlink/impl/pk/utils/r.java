package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r implements IConfig.e {
    public r() {
    }

    public final int getHeight() {
        Pair<Integer, Integer> r0 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.getSecond();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }

    public final Object getReal() {
        Pair<Integer, Integer> r0 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    public final int getWidth() {
        Pair<Integer, Integer> r0 = com.bytedance.android.live.revlink.impl.utils.u.f();
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.getFirst();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }
}
