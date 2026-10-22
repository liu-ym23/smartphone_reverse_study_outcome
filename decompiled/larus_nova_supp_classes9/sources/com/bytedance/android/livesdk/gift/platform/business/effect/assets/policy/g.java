package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Comparator {
    public final /* synthetic */ AssetsDownloadPolicyService a;

    public g(AssetsDownloadPolicyService r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r6) {
        com.bytedance.android.live.core.resources.e r7 = (com.bytedance.android.live.core.resources.e) r6;
        Map<Long, Integer> r0 = this.a.h;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        Integer r8 = (Integer) r1.get(Long.valueOf(((com.bytedance.android.live.core.resources.e) r5).getId()));
        int r2 = Integer.MAX_VALUE;
        if (r8 == null) goto L5;
        int r9 = r8.intValue();
    L6:
        Map<Long, Integer> r3 = this.a.h;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Integer r10 = (Integer) r4.get(Long.valueOf(r7.getId()));
        if (r10 == null) goto L10;
        r2 = r10.intValue();
    L10:
        return r9 - r2;
    L5:
        r9 = Integer.MAX_VALUE;
        goto L6
    }
}
