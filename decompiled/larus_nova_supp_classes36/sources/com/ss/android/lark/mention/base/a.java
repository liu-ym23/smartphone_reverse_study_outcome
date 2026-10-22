package com.ss.android.lark.mention.base;

import com.ss.android.lark.featuregating.FeatureGatingModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        return FeatureGatingModule.getFeatureGatingService().isEnable("core.mention.debounce");
    }
}
