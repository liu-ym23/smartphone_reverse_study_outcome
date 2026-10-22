package com.bytedance.android.live.effect.gift;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class GiftEffectResourceServiceHolder {
    public static final Lazy a = null;

    public static final class a {
        public static e a() {
            return (e) GiftEffectResourceServiceHolder.a.getValue();
        }
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GiftEffectResourceServiceHolder$Companion$instance$2.INSTANCE);
    }
}
