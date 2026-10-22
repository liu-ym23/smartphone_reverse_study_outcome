package com.bytedance.android.livesdk.interactivity.api.base.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final <T> Lazy<T> a(Function0<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "initializer");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, r1);
    }
}
