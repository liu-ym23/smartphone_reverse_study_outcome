package com.ss.android.lark.integrator.todo.dependency;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements g7c.j {
    public p() {
    }

    public final boolean a(String r2, boolean r3) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r2, r3);
    }
}
