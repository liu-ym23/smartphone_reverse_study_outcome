package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import c12.m;
import com.bytedance.live.kmp.core.KmpEnv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends f {
    public h() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f, com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.i
    public final fd6.b<String> a(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r4) {
        int r0 = ((Number) com.bytedance.android.livesdk.gift.platform.business.effect.a.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[3])).intValue();
        jy0.b.a("DouyinAssetsDownloadPolicyFactory", "[createTTDownloadProducer]- policy : " + r0);
        if ((r0 & 1) != 1) goto L9;
        KmpEnv r1 = KmpEnv.a;
        if (KmpEnv.c() == false) goto L16;
        return new c12.f(r4);
    L16:
        return new c12.b(r4);
    L9:
        if (com.bytedance.android.livesdk.gift.platform.core.h.f() == false) goto L14;
        if (c12.j.b() == false) goto L14;
        d12.e.a();
    L14:
        return new m(r4);
    }
}
