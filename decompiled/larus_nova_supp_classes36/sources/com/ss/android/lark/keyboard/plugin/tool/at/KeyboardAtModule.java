package com.ss.android.lark.keyboard.plugin.tool.at;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardAtModule {
    public static final Lazy a = null;

    public interface a {
        boolean isFeatureGatingEnable(String r1);
    }

    static {
        a = LazyKt.lazy(KeyboardAtModule$dependency$2.INSTANCE);
    }
}
