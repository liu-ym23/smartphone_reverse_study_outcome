package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import c12.m;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.DefaultResourceSupport;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f implements i {
    public final DefaultResourceSupport c() {
        boolean r0 = com.bytedance.android.livesdk.gift.platform.business.effect.b.a();
        boolean r1 = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.b.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[3])).booleanValue();
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.c();
    L7:
        if (r0 == false) goto L11;
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.a();
    L11:
        return new com.bytedance.android.livesdk.gift.platform.business.effect.assets.multiresource.b();
    }

    public f() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy.i
    public fd6.b<String> a(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r2) {
        return new m(r2);
    }

    public final AssetsDefaultDownloadPolicy b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.j r4) {
        AssetsDefaultDownloadPolicy r0 = new AssetsDefaultDownloadPolicy(r4);
        int r5 = ((Number) com.bytedance.android.livesdk.gift.platform.business.effect.a.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[3])).intValue();
        if ((r5 & 2) != 2) goto L5;
        boolean r1 = true;
    L6:
        r0.c = r1;
        jy0.b.a("AssetsDownloadPolicyFactory", "[create]-policy need sort :" + r5);
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
