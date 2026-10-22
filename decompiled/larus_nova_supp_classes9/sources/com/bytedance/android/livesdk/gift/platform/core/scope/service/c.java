package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements SingleOnSubscribe {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ Long c;

    public c(d.a r1, Pair r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<Object> r13) {
        Intrinsics.checkNotNullParameter(r13, "it");
        PolarisFileWrapper r14 = new PolarisFileWrapper((String) this.b.getSecond());
        if (r14.exists() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.revenue.common.c0.b(r14) == false) goto L13;
        int r15 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a;
        Long r16 = this.c;
        if (r16 == null) goto L9;
        long r0 = r16.longValue();
    L10:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r0, 0, (String) this.b.getSecond(), "ai_lru_cache", null, null, null, 112);
        this.a.size();
        String r17 = (String) this.b.getSecond();
        return;
    L9:
        r0 = 0;
        goto L10
    }
}
