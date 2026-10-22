package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import c12.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends f {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.f, com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.i
    public final fd6.b<String> a(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r2) {
        if (com.bytedance.android.livesdk.gift.platform.core.h.f() == false) goto L11;
        if (c12.j.b() == false) goto L11;
        if (d12.e.a() == false) goto L11;
        return new d12.d(r2);
    L11:
        return new m(r2);
    }
}
