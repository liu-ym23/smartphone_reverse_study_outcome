package com.bytedance.android.livesdk.config.setting;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class NewBroadcastSharedConfig {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(NewBroadcastSharedConfig$isSharedOpen$2.INSTANCE);
    }

    public static Boolean a() {
        return (Boolean) a.getValue();
    }
}
