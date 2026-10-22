package com.ss.android.lark.component.appcontext;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AppContextDependencyProvider {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AppContextDependencyProvider$contextInitDependency$2.INSTANCE);
    }
}
