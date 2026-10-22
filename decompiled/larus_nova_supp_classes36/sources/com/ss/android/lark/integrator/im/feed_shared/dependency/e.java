package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements peb.b.f {
    public e() {
    }

    public final boolean isCurrentEnable(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isCurrentEnable(r2);
    }

    public final boolean isEnable(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }
}
