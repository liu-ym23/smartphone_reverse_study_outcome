package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements w4b.l {
    public g() {
    }

    public final boolean isEnable(String r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2);
    }
}
