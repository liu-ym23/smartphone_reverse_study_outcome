package com.bytedance.android.live.core.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class MainPostOptUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainPostOptUtils$sHandler$2.INSTANCE);
    }
}
