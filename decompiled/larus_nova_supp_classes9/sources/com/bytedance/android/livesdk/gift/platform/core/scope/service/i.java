package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T, R> implements Function {
    public final /* synthetic */ AssetsService a;

    public i(AssetsService r1) {
        this.a = r1;
    }

    public final Object apply(Object r6) {
        ExtraResponse r7 = (ExtraResponse) r6;
        Intrinsics.checkNotNullParameter(r7, "it");
        AssetsService r0 = this.a;
        com.bytedance.android.livesdk.gift.model.d r8 = (com.bytedance.android.livesdk.gift.model.d) r7.data;
        r0.getClass();
        List<Long> r1 = r8.getZipSweepMarkAssets();
        List<com.bytedance.android.live.core.resources.e> r9 = r8.getAssets();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        com.bytedance.android.live.core.resources.e r3 = (com.bytedance.android.live.core.resources.e) r10.next();
        if (r1.contains(Long.valueOf(r3.getId())) == false) goto L4;
        r2.put(Long.valueOf(r3.getId()), r3);
        goto L4
    L8:
        return r2;
    }
}
