package com.bytedance.android.annie.card.base;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ComponentManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, ComponentManager$containerMap$2.INSTANCE);
    }
}
