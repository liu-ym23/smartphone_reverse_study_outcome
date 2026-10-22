package com.ss.android.lark.keyboard.dependency;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardAssemblerModule {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KeyboardAssemblerModule$sDependency$2.INSTANCE);
    }

    public static a a() {
        return (a) a.getValue();
    }
}
